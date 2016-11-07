package com.dimediary.view.design;

import java.util.ArrayList;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.ui.UiTransactionDialog;
import com.dimediary.view.main.Main;
import com.dimediary.view.utils.QTUtils;
import com.dimediary.view.utils.QTableTransactions;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QDialog;

public class TransactionDialog extends UiTransactionDialog {

	private final QDialog dialog;

	QTableTransactions qtableTransactions;

	public TransactionDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.qtableTransactions = new QTableTransactions(this.tableTransactions);

		this.initialize();

		this.createTriggers();
	}

	private void initialize() {
		this.dateEdit.setDate(QDate.currentDate());
		this.comboBoxCategory.clear();
		this.comboBoxAccount.clear();
		this.comboBoxCategory.addItems(DBUtils.getInstance().getCategoryNames());
		this.comboBoxAccount.addItems(DBUtils.getInstance().getBankAccountNames());
		this.checkBoxIncome.setChecked(false);
		this.subjectEdit.setText("");
		this.doubleSpinBoxAmount.setValue(0);
	}

	public void initialize(final Transaction transaction) {
		this.initialize();
		this.dateEdit.setDate(QTUtils.dateToQDate(transaction.getDate()));
		this.comboBoxAccount.setCurrentIndex(this.comboBoxAccount.findText(transaction.getBankAccount().getName()));
		this.comboBoxCategory.setCurrentIndex(this.comboBoxCategory.findText(transaction.getCategory().getName()));
		this.checkBoxIncome.setChecked(transaction.getAmount() > 0);
		this.subjectEdit.setText(transaction.getName());
		this.doubleSpinBoxAmount.setValue(transaction.getAmount());

		this.qtableTransactions.addTransaction(transaction);

		this.exec();
	}

	private void createTriggers() {
		this.pushButtonAdd.clicked.connect(this, "onAdd()");
		this.pushButtonAdd.clicked.connect(Main.getMainWindow(), "updateTransactionsTable()");

		this.pushButtonDelete.clicked.connect(this, "onDelete()");
		this.pushButtonDelete.clicked.connect(Main.getMainWindow(), "updateTransactionsTable()");

		this.pushButtonAddAccount.clicked.connect(Main.getBankAccountDialog(), "exec()");

		this.checkBoxIncome.clicked.connect(this, "onEditingFinished()");
		this.doubleSpinBoxAmount.editingFinished.connect(this, "onEditingFinished()");

	}

	public void onAdd() {
		final Transaction transaction = new Transaction();
		transaction.setAmount(this.doubleSpinBoxAmount.value());
		transaction.setBankAccount(DBUtils.getInstance().getBankAccount(this.comboBoxAccount.currentText()));
		transaction.setCategory(DBUtils.getInstance().getCategory(this.comboBoxCategory.currentText()));
		transaction.setDate(QTUtils.qDateToDate(this.dateEdit.date()));
		transaction.setName(this.subjectEdit.text());
		transaction.setUser(null);
		DBUtils.getInstance().persist(transaction);
		this.qtableTransactions.addTransaction(transaction);
	}

	public void onDelete() {
		final ArrayList<Transaction> transactionsToDelete = this.qtableTransactions.getSelectedTransactions();

		DBUtils.getInstance().deleteTransactions(transactionsToDelete);
		for (final Transaction transaction : transactionsToDelete) {
			this.qtableTransactions.deleteTransaction(transaction);
		}
		Main.getMainWindow().updateTransactionsTable();
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
		return this.dialog.exec();
	}

	public QDialog getDialog() {
		return this.dialog;
	}

}
