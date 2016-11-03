package com.dimediary.view.initializer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.UiMainWindow;
import com.dimediary.view.utils.QTUtils;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;

public class Initializer {

	static public void initMainWindow(final UiMainWindow mainWindow, final QApplication application) {
		final QMainWindow window = new QMainWindow();
		mainWindow.setupUi(window);

		mainWindow.actionBeenden.triggered.connect(application, "exit()");

		// set date range for the shown transactions
		QDate today = new QDate();
		today = QDate.currentDate();
		final QDate qdateFrom = today.addDays(-30); // TODO read this option
													// from
													// option file
		final QDate qdateUntil = today.addDays(30);
		mainWindow.dateFrom.setDate(qdateFrom);
		mainWindow.dateUntil.setDate(qdateUntil);

		// set the possible bank accounts in the combo box
		final ArrayList<String> bankAccountNames = DBUtils.getBankAccountNames();
		mainWindow.comboBoxBankaccount.addItems(bankAccountNames);

		// fill the table with the transactions between the two dates for the
		// selected bank account
		final Date dateFrom = QTUtils.qDateToDate(qdateFrom);
		final Date dateUntil = QTUtils.qDateToDate(qdateUntil);

		final List<Transaction> transactions = DBUtils.geTransactions(dateFrom, dateUntil, bankAccountNames.get(0));

		final QTableWidget table = mainWindow.tableTransactions;
		table.setRowCount(transactions.size());
		for (int i = 0; i < transactions.size(); i++) {
			final Transaction transaction = transactions.get(i);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			final String date = simpleDateFormat.format(transaction.getDate());
			simpleDateFormat = new SimpleDateFormat("E");
			final String weekDay = simpleDateFormat.format(transaction.getDate());
			final String amount = transaction.getAmount().toString().replace(".", ",");
			final String name = transaction.getName();
			final String category = transaction.getCategory().getName();

			table.setItem(i, 0, new QTableWidgetItem(date));
			table.setItem(i, 1, new QTableWidgetItem(weekDay));
			table.setItem(i, 2, new QTableWidgetItem(amount));
			table.setItem(i, 3, new QTableWidgetItem(name));
			table.setItem(i, 4, new QTableWidgetItem(category));
		}

		window.show();

		QApplication.setActiveWindow(window);
	}

}
