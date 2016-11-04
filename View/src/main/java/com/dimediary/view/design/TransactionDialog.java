package com.dimediary.view.design;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.ui.UiTransactionDialog;
import com.dimediary.view.main.Main;
import com.dimediary.view.utils.QTUtils;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QDialog;

public class TransactionDialog extends UiTransactionDialog {

	private final QDialog dialog;

	public TransactionDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);
		this.initialize();

		this.buttonBox.accepted.connect(this, "OnOK()");
		this.buttonBox.accepted.connect(Main.getMainWindow(), "updateTransactionsTable()");
	}

	private void initialize() {
		this.dateEdit.setDate(QDate.currentDate());
		this.comboBoxCategory.clear();
		this.comboBoxAccount.clear();
		this.comboBoxCategory.addItems(DBUtils.getCategoryNames());
		this.comboBoxAccount.addItems(DBUtils.getBankAccountNames());
		this.checkBoxIncome.setChecked(false);
		this.subjectEdit.setText("");
		this.doubleSpinBoxAmount.setValue(0);
	}

	public void OnOK() {
		final Transaction transaction = new Transaction();
		transaction.setAmount(this.doubleSpinBoxAmount.value());
		transaction.setBankAccount(DBUtils.getBankAccount(this.comboBoxAccount.currentText()));
		transaction.setCategory(DBUtils.getCategory(this.comboBoxCategory.currentText()));
		transaction.setDate(QTUtils.qDateToDate(this.dateEdit.date()));
		transaction.setName(this.subjectEdit.text());
		transaction.setUser(null);
		DBUtils.persist(transaction);
	}

	public int exec() {
		return this.dialog.exec();
	}

	public QDialog getDialog() {
		return this.dialog;
	}

}
