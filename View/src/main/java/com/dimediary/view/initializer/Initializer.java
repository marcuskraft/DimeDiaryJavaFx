package com.dimediary.view.initializer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dimediary.controller.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.UiMainWindow;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QDateTime;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
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
		QDateTime dateTime = new QDateTime(qdateFrom);
		final Date dateFrom = new Date(dateTime.toMSecsSinceEpoch());

		dateTime = new QDateTime(qdateUntil);
		final Date dateUntil = new Date(dateTime.toMSecsSinceEpoch());

		final List<Transaction> transactions = DBUtils.geTransactions(dateFrom, dateUntil, bankAccountNames.get(0));

		mainWindow.tableTransactions.setRowCount(transactions.size());
		for (int i = 0; i < transactions.size(); i++) {
			final Transaction transaction = transactions.get(i);

			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			final String date = simpleDateFormat.format(transaction.getDate());

			mainWindow.tableTransactions.setItem(i, 0, new QTableWidgetItem(date));
		}

		window.show();

		QApplication.setActiveWindow(window);
	}

}
