package com.dimediary.view.design;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.ui.UiMainWindow;
import com.dimediary.view.main.Main;
import com.dimediary.view.utils.QTUtils;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QTableWidgetItem;

public class MainWindow extends UiMainWindow {

	private QMainWindow window;

	public void initialize() {
		this.window = new QMainWindow();
		this.setupUi(this.window);

		this.initTrigger();

		// set date range for the shown transactions
		QDate today = new QDate();
		today = QDate.currentDate();
		final QDate qdateFrom = today.addDays(-30); // TODO read this option
													// from
													// option file
		final QDate qdateUntil = today.addDays(30);
		this.dateFrom.setDate(qdateFrom);
		this.dateUntil.setDate(qdateUntil);

		// set the possible bank accounts in the combo box
		final ArrayList<String> bankAccountNames = DBUtils.getInstance().getBankAccountNames();
		// TODO if no bankAccounts exists ask the user to add bank account
		this.comboBoxBankaccount.addItems(bankAccountNames);

		// fill the table with the transactions between the two dates for the
		// selected bank account
		this.updateTransactionsTable();

		this.window.show();

		QApplication.setActiveWindow(this.window);
	}

	public void updateTransactionsTable() {
		final Date utilDateFrom = QTUtils.qDateToDate(this.dateFrom.date());
		final Date utilDateUntil = QTUtils.qDateToDate(this.dateUntil.date());

		final String bankAccountName = this.comboBoxBankaccount.itemText(this.comboBoxBankaccount.currentIndex());
		Assert.assertTrue("No bank accounts in the combo box for bank accounts available", bankAccountName != null);
		// TODO ask the user to add a bank account

		final List<Transaction> transactions = DBUtils.getInstance().geTransactions(utilDateFrom, utilDateUntil,
				bankAccountName);

		this.tableTransactions.setRowCount(transactions.size());
		for (int i = 0; i < transactions.size(); i++) {
			final Transaction transaction = transactions.get(i);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			final String date = simpleDateFormat.format(transaction.getDate());
			simpleDateFormat = new SimpleDateFormat("E");
			final String weekDay = simpleDateFormat.format(transaction.getDate());
			final String amount = transaction.getAmount().toString().replace(".", ",");
			final String name = transaction.getName();
			final String category = transaction.getCategory().getName();

			this.tableTransactions.setItem(i, 0, new QTableWidgetItem(date));
			this.tableTransactions.setItem(i, 1, new QTableWidgetItem(weekDay));
			this.tableTransactions.setItem(i, 2, new QTableWidgetItem(amount));
			this.tableTransactions.setItem(i, 3, new QTableWidgetItem(name));
			this.tableTransactions.setItem(i, 4, new QTableWidgetItem(category));
		}
	}

	private void initTrigger() {
		// menu buttons
		this.actionBeenden.triggered.connect(Main.getApplication(), "exit()");
		this.actionKontoart_erstellen.triggered.connect(Main.getAccountCategoryDialog(), "exec()");

		this.comboBoxBankaccount.currentIndexChanged.connect(this, "updateTransactionsTable()");
		this.dateFrom.dateChanged.connect(this, "updateTransactionsTable()");
		this.dateUntil.dateChanged.connect(this, "updateTransactionsTable()");

		this.buttonAddTransaction.clicked.connect(Main.getTransactionDialog(), "initialize()");
		this.buttonAddTransaction.clicked.connect(Main.getTransactionDialog(), "exec()");

	}

}
