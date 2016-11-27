package com.dimediary.view.design;

import java.util.ArrayList;

import javax.persistence.RollbackException;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.view.Main;
import com.dimediary.view.design.ui.UiBankAccountDialog;
import com.dimediary.view.utils.QTUtils;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QErrorMessage;
import com.trolltech.qt.gui.QListWidgetItem;

/**
 * wrapper class for the dialog to create / delete / modify bank accounts
 *
 * @author eyota
 *
 */
public class BankAccountDialog extends UiBankAccountDialog {

	private final QDialog dialog;

	/**
	 * constructor
	 */
	public BankAccountDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.initialize();

	}

	/**
	 * executes this dialog
	 */
	public void exec() {
		this.dialog.exec();
	}

	/**
	 * initializes the components of this dialog
	 */
	public void initialize() {
		this.comboBoxAccountCategory.clear();
		this.comboBoxAccountCategory.addItems(DBUtils.getInstance().getBankAccountCategoryNames());
		this.lineEditAccountName.clear();
		this.lineEditBankName.clear();
		this.lineEditIBAN.clear();
		this.lineEditBIC.clear();
		this.listWidget.clear();
		this.listWidget.addItems(DBUtils.getInstance().getBankAccountNames());
		this.dateEditStartBudget.setDate(QDate.currentDate());
		this.doubleSpinBoxStartBudget.setValue(0);
	}

	/**
	 * initializes the components of this dialog with the data of the bank
	 * account
	 *
	 * @param bankAccount
	 *            bank account to be shown
	 */
	public void initialize(final BankAccount bankAccount) {
		this.comboBoxAccountCategory.clear();
		this.comboBoxAccountCategory.addItems(DBUtils.getInstance().getBankAccountCategoryNames());
		this.comboBoxAccountCategory
				.setCurrentIndex(this.comboBoxAccountCategory.findText(bankAccount.getBankAccountCategory().getName()));
		this.lineEditAccountName.setText(bankAccount.getName());
		this.lineEditBankName.setText(bankAccount.getBankName());
		this.lineEditIBAN.setText(bankAccount.getIban());
		this.lineEditBIC.setText(bankAccount.getBic());
		this.listWidget.clear();
		this.listWidget.addItems(DBUtils.getInstance().getBankAccountNames());
		this.dateEditStartBudget.setDate(QTUtils.dateToQDate(bankAccount.getDateStartBudget()));
		this.doubleSpinBoxStartBudget.setValue(bankAccount.getStartBudget());
	}

	/**
	 * creates the triggers for this dialog
	 */
	public void createTriggers() {
		this.pushButtonAddAccountCategory.clicked.connect(Main.getAccountCategoryDialog(), "exec()");

		this.pushButtonAdd.clicked.connect(this, "onAddButton()");
		this.pushButtonAdd.clicked.connect(Main.getMainWindow(), "update()");
		this.pushButtonAdd.clicked.connect(Main.getTransactionDialog(), "refreshBankAccounts()");

		this.pushButtonDelete.clicked.connect(this, "onDeleteButton()");
		this.pushButtonDelete.clicked.connect(Main.getMainWindow(), "update()");
		this.pushButtonDelete.clicked.connect(Main.getTransactionDialog(), "refreshBankAccounts()");

		this.listWidget.itemDoubleClicked.connect(this, "onDoubleClick(com.trolltech.qt.gui.QListWidgetItem)");
	}

	/**
	 * show the data of the bank account which was double clicked
	 *
	 * @param item
	 */
	public void onDoubleClick(final QListWidgetItem item) {
		final BankAccount bankAccount = DBUtils.getInstance().getBankAccount(item.text());
		this.initialize(bankAccount);
	}

	/**
	 * add a bank account with the current data on this dialog to the data base
	 */
	public void onAddButton() {
		final BankAccount bankAccount = new BankAccount();

		bankAccount.setBankAccountCategory(
				DBUtils.getInstance().getBankAccountCategory(this.comboBoxAccountCategory.currentText()));
		bankAccount.setBankName(this.lineEditBankName.text());
		bankAccount.setBic(this.lineEditBIC.text());
		bankAccount.setIban(this.lineEditIBAN.text());
		bankAccount.setName(this.lineEditAccountName.text());
		bankAccount.setStartBudget(this.doubleSpinBoxStartBudget.value());
		bankAccount.setDateStartBudget(QTUtils.qDateToDate(this.dateEditStartBudget.date()));

		DBUtils.getInstance().persist(bankAccount);

		this.initialize();
	}

	/**
	 * delete the selected bank accounts from the data base
	 */
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

	/**
	 *
	 * @return the real QDialog
	 */
	public QDialog getDialog() {
		return this.dialog;
	}

}
