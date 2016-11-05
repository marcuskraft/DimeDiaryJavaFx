package com.dimediary.view.design;

import java.util.ArrayList;

import javax.persistence.RollbackException;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.view.design.ui.UiBankAccountDialog;
import com.dimediary.view.main.Main;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QErrorMessage;
import com.trolltech.qt.gui.QListWidgetItem;

public class BankAccountDialog extends UiBankAccountDialog {

	private final QDialog dialog;

	public BankAccountDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.initialize();

		this.createTriggers();
	}

	public void exec() {
		this.dialog.exec();
	}

	public void initialize() {
		this.comboBoxAccountCategory.clear();
		this.comboBoxAccountCategory.addItems(DBUtils.getInstance().getBankAccountCategoryNames());
		this.lineEditAccountName.clear();
		this.lineEditBankName.clear();
		this.lineEditIBAN.clear();
		this.lineEditBIC.clear();
		this.doubleSpinBoxStartBudget.setValue(0);
		this.listWidget.clear();
		this.listWidget.addItems(DBUtils.getInstance().getBankAccountNames());
	}

	private void createTriggers() {
		this.pushButtonAddAccountCategory.clicked.connect(Main.getAccountCategoryDialog(), "exec()");
		this.pushButtonAdd.clicked.connect(this, "onAddButton()");
		this.pushButtonDelete.clicked.connect(this, "onDeleteButton()");
	}

	public void onAddButton() {
		final BankAccount bankAccount = new BankAccount();

		bankAccount.setBankAccountCategory(
				DBUtils.getInstance().getBankAccountCategory(this.comboBoxAccountCategory.currentText()));
		bankAccount.setBankName(this.lineEditBankName.text());
		bankAccount.setBic(this.lineEditBIC.text());
		bankAccount.setIban(this.lineEditIBAN.text());
		bankAccount.setName(this.lineEditAccountName.text());

		DBUtils.getInstance().persist(bankAccount);
		this.initialize();
	}

	public void onDeleteButton() {
		final ArrayList<String> bankAccountNames = new ArrayList<>();

		for (final QListWidgetItem item : this.listWidget.selectedItems()) {
			bankAccountNames.add(item.text());
		}

		try {
			DBUtils.getInstance().deleteBankAccounts(bankAccountNames);
		} catch (final RollbackException e) {
			final QErrorMessage errorMessage = new QErrorMessage(this.getDialog());
			errorMessage.setWindowTitle("Transaktion verknüpft!");
			errorMessage.showMessage("Es gibt noch mindestens eine Transaktion, welche dieses Konto referenziert.");
		}

		this.initialize();
	}

	public QDialog getDialog() {
		return this.dialog;
	}

}
