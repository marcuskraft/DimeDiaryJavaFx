package com.dimediary.view.main;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.view.design.AccountCategoryDialog;
import com.dimediary.view.design.BankAccountDialog;
import com.dimediary.view.design.CategoryDialog;
import com.dimediary.view.design.MainWindow;
import com.dimediary.view.design.TransactionDialog;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMessageBox;

public class Main {

	private static QApplication application;

	private static MainWindow mainWindow;

	private static TransactionDialog transactionDialog;
	private static BankAccountDialog bankAccountDialog;
	private static AccountCategoryDialog accountCategoryDialog;
	private static CategoryDialog categoryDialog;

	public static void main(final String[] args) {

		try {
			Main.application = new QApplication(args);
			Main.application.aboutToQuit.connect(DBUtils.getInstance(), "close()");

			Main.mainWindow = new MainWindow();

			Main.accountCategoryDialog = new AccountCategoryDialog();
			Main.bankAccountDialog = new BankAccountDialog();
			Main.transactionDialog = new TransactionDialog();
			Main.categoryDialog = new CategoryDialog();

			Main.mainWindow.initialize();

			Main.mainWindow.createTrigger();
			Main.accountCategoryDialog.createTrigger();
			Main.bankAccountDialog.createTriggers();
			Main.transactionDialog.createTriggers();
			Main.categoryDialog.createTrigger();

			Main.application.exec();
		} catch (final Exception e) {
			DBUtils.getInstance().close();
			final QMessageBox messageBox = new QMessageBox(null, "Error", e.getMessage());
			messageBox.show();
			e.printStackTrace();
			throw e;
		}

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

	public static CategoryDialog getCategoryDialog() {
		return Main.categoryDialog;
	}

}
