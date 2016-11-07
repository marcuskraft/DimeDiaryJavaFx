package com.dimediary.view.main;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.view.design.AccountCategoryDialog;
import com.dimediary.view.design.BankAccountDialog;
import com.dimediary.view.design.MainWindow;
import com.dimediary.view.design.TransactionDialog;
import com.trolltech.qt.gui.QApplication;

public class Main {

	private static MainWindow mainWindow;
	private static QApplication application;
	private static TransactionDialog transactionDialog;
	private static BankAccountDialog bankAccountDialog;
	private static AccountCategoryDialog accountCategoryDialog;

	public static void main(final String[] args) {

		Main.application = new QApplication(args);
		Main.application.aboutToQuit.connect(DBUtils.getInstance(), "close()");
		Main.mainWindow = new MainWindow();
		Main.accountCategoryDialog = new AccountCategoryDialog();
		Main.bankAccountDialog = new BankAccountDialog();
		Main.transactionDialog = new TransactionDialog();
		Main.mainWindow.initialize();

		Main.application.exec();

	}

	public static MainWindow getMainWindow() {
		return Main.mainWindow;
	}

	public static QApplication getApplication() {
		return Main.application;
	}

	public static TransactionDialog getTransactionDialog() {
		return Main.transactionDialog;
	}

	public static AccountCategoryDialog getAccountCategoryDialog() {
		return Main.accountCategoryDialog;
	}

	public static BankAccountDialog getBankAccountDialog() {
		return Main.bankAccountDialog;
	}

}
