package com.dimediary.view.initializer;

import java.util.ArrayList;

import com.dimediary.controller.DBUtils;
import com.dimediary.view.design.UiMainWindow;
import com.trolltech.qt.core.QDate;

public class Initializer {

	static public void initMainWindow(final UiMainWindow mainWindow) {
		QDate today = new QDate();
		today = QDate.currentDate();
		final QDate dateFrom = today.addDays(-10);
		final QDate dateUntil = today.addDays(10);
		mainWindow.dateFrom.setDate(dateFrom);
		mainWindow.dateUntil.setDate(dateUntil);

		final ArrayList<String> bankAccountNames = DBUtils.getBankAccountNames();
		mainWindow.cBBankaccount.addItems(bankAccountNames);

	}

}
