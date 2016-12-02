package com.dimediary.view;

import com.dimediary.view.design.AccountCategoryDialog;
import com.dimediary.view.design.BankAccountDialog;
import com.dimediary.view.design.CategoryDialog;
import com.dimediary.view.design.MainWindow;
import com.dimediary.view.design.TransactionDialog;
import com.trolltech.qt.gui.QApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static QApplication application;

	private static MainWindow mainWindow;

	private static TransactionDialog transactionDialog;
	private static BankAccountDialog bankAccountDialog;
	private static AccountCategoryDialog accountCategoryDialog;
	private static CategoryDialog categoryDialog;

	public static void main(final String[] args) {
		Application.launch(args);
	}

	public static void initialize() {

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

	@Override
	public void start(final Stage stage) throws Exception {
		stage.setMaximized(true);
		final Parent root = FXMLLoader.load(this.getClass().getResource("design/window/MainWindow.fxml"));

		final Scene scene = new Scene(root);

		stage.setTitle("FXML Welcome");
		stage.setScene(scene);
		stage.show();
	}

}
