package com.dimediary.view.design;

import java.util.ArrayList;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.tables.TableTransactionDialog;
import com.dimediary.view.design.ui.UiTransactionDialog;
import com.dimediary.view.main.Main;
import com.dimediary.view.utils.QTUtils;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QDialog;

public class TransactionDialog extends UiTransactionDialog {

	private final QDialog dialog;

	private final TableTransactionDialog ownTableTransactions;

	private final ContinuousTransactionWidget continuousTransactionWidget;

	private boolean isActive = false;

	public TransactionDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.ownTableTransactions = new TableTransactionDialog(this.tableTransactions);
		this.continuousTransactionWidget = new ContinuousTransactionWidget();

		this.gridLayoutMain.addWidget(this.continuousTransactionWidget.getContinuousTransactionWidget(), 2, 0);
		this.continuousTransactionWidget.getContinuousTransactionWidget().setVisible(false);

		this.initialize();

		this.dialog.finished.connect(this, "OnFinish(java.lang.Integer)");

	}

	public void initialize() {
		this.dateEdit.setDate(QDate.currentDate());
		this.comboBoxCategory.clear();
		this.comboBoxAccount.clear();
		this.comboBoxCategory.addItems(DBUtils.getInstance().getCategoryNames());
		this.comboBoxAccount.addItems(DBUtils.getInstance().getBankAccountNames());
		this.checkBoxIncome.setChecked(false);
		this.subjectEdit.setText("");
		this.doubleSpinBoxAmount.setValue(0);

		this.checkBoxIterate.setDisabled(false);
		this.pushButtonAdd.setVisible(true);
		this.pushButtonModify.setVisible(false);
	}

	public void initialize(final Transaction transaction) {
		this.initialize();

		this.checkBoxIterate.setDisabled(true);
		this.pushButtonAdd.setVisible(false);
		this.pushButtonModify.setVisible(true);

		String accountName = transaction.getBankAccount() != null ? transaction.getBankAccount().getName() : null;
		if (accountName == null) {
			accountName = "-";
			this.comboBoxAccount.addItem(accountName);
		}
		this.comboBoxAccount.setCurrentIndex(this.comboBoxAccount.findText(accountName));

		String categoryName = transaction.getCategory() != null ? transaction.getCategory().getName() : null;
		if (categoryName == null) {
			categoryName = "-";
			this.comboBoxCategory.addItem(categoryName);
		}
		this.dateEdit.setDate(QTUtils.dateToQDate(transaction.getDate()));

		this.comboBoxCategory.setCurrentIndex(this.comboBoxCategory.findText(categoryName));
		this.checkBoxIncome.setChecked(transaction.getAmount() > 0);
		this.subjectEdit.setText(transaction.getName());
		this.doubleSpinBoxAmount.setValue(transaction.getAmount());

		this.ownTableTransactions.addTransaction(transaction);

		this.exec();
	}

	public void initialize(final ContinuousTransaction continuousTransaction) {
		this.initialize();

		this.pushButtonAdd.setVisible(false);
		this.pushButtonModify.setVisible(true);
		this.checkBoxIterate.setChecked(true);
		this.onCeckBoxIterate(true);

		String accountName = continuousTransaction.getBankAccount() != null
				? continuousTransaction.getBankAccount().getName() : null;
		if (accountName == null) {
			accountName = "-";
			this.comboBoxAccount.addItem(accountName);
		}
		this.comboBoxAccount.setCurrentIndex(this.comboBoxAccount.findText(accountName));

		String categoryName = continuousTransaction.getCategory() != null
				? continuousTransaction.getCategory().getName() : null;
		if (categoryName == null) {
			categoryName = "-";
			this.comboBoxCategory.addItem(categoryName);
		}
		this.dateEdit.setDate(QTUtils.dateToQDate(continuousTransaction.getDateBeginn()));

		this.comboBoxCategory.setCurrentIndex(this.comboBoxCategory.findText(categoryName));
		this.checkBoxIncome.setChecked(continuousTransaction.getAmount() > 0);
		this.subjectEdit.setText(continuousTransaction.getName());
		this.doubleSpinBoxAmount.setValue(continuousTransaction.getAmount());

		switch (continuousTransaction.getIterationState()) {
		case MONTHLY:
			this.initializeMonthly(continuousTransaction);
			break;

		default:
			break;
		}

	}

	public void initializeMonthly(final ContinuousTransaction continuousTransaction) {
		this.continuousTransactionWidget.initializeMonthly(continuousTransaction);
		this.exec();
	}

	public void update() {
		this.comboBoxCategory.clear();
		this.comboBoxAccount.clear();
		this.comboBoxCategory.addItems(DBUtils.getInstance().getCategoryNames());
		this.comboBoxAccount.addItems(DBUtils.getInstance().getBankAccountNames());
	}

	public void createTriggers() {
		this.pushButtonAdd.clicked.connect(this, "onAdd()");
		this.pushButtonAdd.clicked.connect(Main.getMainWindow(), "updateTransactionsTable()");
		this.pushButtonAdd.clicked.connect(Main.getMainWindow().getTableMonthOverview(), "updateMonthOverview()");

		this.pushButtonDelete.clicked.connect(this, "onDelete()");
		this.pushButtonDelete.clicked.connect(Main.getMainWindow(), "updateTransactionsTable()");
		this.pushButtonDelete.clicked.connect(Main.getMainWindow().getTableMonthOverview(), "updateMonthOverview()");

		this.pushButtonAddAccount.clicked.connect(Main.getBankAccountDialog(), "exec()");
		this.pushButtonAddCategory.clicked.connect(Main.getCategoryDialog(), "exec()");

		this.checkBoxIncome.clicked.connect(this, "onEditingFinished()");
		this.doubleSpinBoxAmount.editingFinished.connect(this, "onEditingFinished()");

		this.checkBoxIterate.clicked.connect(this, "onCeckBoxIterate(java.lang.Boolean)");
		this.continuousTransactionWidget.createTrigger();

	}

	public void onCeckBoxIterate(final Boolean active) {
		this.continuousTransactionWidget.getContinuousTransactionWidget().setVisible(active);
		this.dialog.adjustSize();

	}

	public void adjustSize() {
		if (this.checkBoxIterate.isChecked()) {
			this.continuousTransactionWidget.adjustSize();
		}
		this.widgetTransactionData.adjustSize();
		this.frameIterateButton.adjustSize();
		this.tableTransactions.adjustSize();
		this.widgetOverview.adjustSize();
		this.groupBoxTransaction.adjustSize();

	}

	public void onAdd() {
		if (this.checkBoxIterate.isChecked()) {
			this.addContinuousTransaction();
		} else {
			this.addSingleTransaction();
		}

	}

	private void addContinuousTransaction() {
		final ContinuousTransaction continuousTransaction = new ContinuousTransaction();
		continuousTransaction.setAmount(this.doubleSpinBoxAmount.value());
		continuousTransaction.setBankAccount(DBUtils.getInstance().getBankAccount(this.comboBoxAccount.currentText()));
		continuousTransaction.setCategory(DBUtils.getInstance().getCategory(this.comboBoxCategory.currentText()));
		continuousTransaction.setName(this.subjectEdit.text());
		continuousTransaction.setDateBeginn(QTUtils.qDateToDate(this.dateEdit.date()));
		this.continuousTransactionWidget.initContinuousTransaction(continuousTransaction);
		// Main.getMainWindow().update();
	}

	private void addSingleTransaction() {
		final Transaction transaction = new Transaction();
		transaction.setAmount(this.doubleSpinBoxAmount.value());
		transaction.setBankAccount(DBUtils.getInstance().getBankAccount(this.comboBoxAccount.currentText()));
		transaction.setCategory(DBUtils.getInstance().getCategory(this.comboBoxCategory.currentText()));
		transaction.setDate(QTUtils.qDateToDate(this.dateEdit.date()));
		transaction.setName(this.subjectEdit.text());
		transaction.setUser(null);
		DBUtils.getInstance().persist(transaction);
		this.ownTableTransactions.addTransaction(transaction);
	}

	public void onDelete() {
		final ArrayList<Transaction> transactionsToDelete = this.ownTableTransactions.getSelectedTransactions();

		DBUtils.getInstance().deleteTransactions(transactionsToDelete);
		this.ownTableTransactions.deleteTransactions(transactionsToDelete);

		Main.getMainWindow().updateTransactionsTable();
	}

	public void deleteTransactions(final ArrayList<Transaction> transactions) {
		for (final Transaction transaction : transactions) {
			if (this.ownTableTransactions.getTransactions().contains(transaction)) {
				this.ownTableTransactions.deleteTransaction(transaction);
			}
		}
	}

	public void onEditingFinished() {
		final Double value = this.doubleSpinBoxAmount.value();
		if (this.checkBoxIncome.isChecked()) {
			this.doubleSpinBoxAmount.setValue(Math.abs(value));
		} else {
			this.doubleSpinBoxAmount.setValue(-Math.abs(value));
		}
	}

	public int exec() {
		if (this.isActive) {
			return 0;
		}
		this.isActive = true;
		return this.dialog.exec();
	}

	public void OnFinish(final Integer number) {
		this.isActive = false;
	}

	public QDialog getDialog() {
		return this.dialog;
	}

}
