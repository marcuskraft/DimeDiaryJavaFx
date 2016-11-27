package com.dimediary.view.design.tables;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.dimediary.controller.balance.AccountBalancer;
import com.dimediary.controller.utils.DBUtils;
import com.dimediary.controller.utils.DateUtils;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.Main;
import com.trolltech.qt.gui.QTabWidget;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;

public class TableMonthOverview {

	private final HashMap<Month, QTableWidget> tablesOverview;
	private final HashMap<Month, QWidget> tabs;
	private final QTabWidget qTabWidget;

	private Month actualMonth;

	public TableMonthOverview(final HashMap<Month, QTableWidget> tablesOverview, final HashMap<Month, QWidget> tabs,
			final QTabWidget qTabWidget) {
		this.tablesOverview = tablesOverview;
		this.tabs = tabs;
		this.qTabWidget = qTabWidget;
	}

	public void createTrigger() {
		this.qTabWidget.currentChanged.connect(this, "updateMonthOverview(java.lang.Integer)");
		Main.getMainWindow().comboBoxBankaccountOverview.currentStringChanged.connect(this, "updateMonthOverview()");
		Main.getMainWindow().spinBoxYear.valueChanged.connect(this, "updateMonthOverview()");
	}

	public void updateMonthOverview() {
		this.updateMonthOverview(this.actualMonth);
	}

	public void updateMonthOverview(final Month month) {
		if (month == null) {
			return; // TODO throw exception
		}
		this.actualMonth = month;
		final QTableWidget qTableWidget = this.tablesOverview.get(month);
		final ArrayList<Date> dates = DateUtils.getDatesForMonth(month, Main.getMainWindow().spinBoxYear.value());
		final BankAccount bankAccount = DBUtils.getInstance()
				.getBankAccount(Main.getMainWindow().comboBoxBankaccountOverview
						.itemText(Main.getMainWindow().comboBoxBankaccountOverview.currentIndex()));

		final HashMap<Date, Double> balances = AccountBalancer.getBalancesFollowingDays(bankAccount, dates);

		final HashMap<Date, ArrayList<Transaction>> transactionsForDates = new HashMap<>();

		int maxTransaction = 0;
		for (final Date date : dates) {
			final List<Transaction> transactions = DBUtils.getInstance().getTransactions(bankAccount, date);
			if (Main.getMainWindow().isAccountlessTransactionsEnabled()) {
				transactions.addAll(DBUtils.getInstance().getTrandactionsWithoutAccount(date));
			}
			transactionsForDates.put(date, new ArrayList<Transaction>(transactions));
			if (transactions.size() > maxTransaction) {
				maxTransaction = transactions.size();
			}
		}

		qTableWidget.clear();

		// create the table now
		qTableWidget.setColumnCount(maxTransaction + 3);
		// +3 because of the three colums Datum, Wochentag and Kontostand which
		// are always there
		qTableWidget.setRowCount(dates.size());

		final ArrayList<String> labels = new ArrayList<>();
		labels.add("Datum");
		labels.add("Wochentag");
		labels.add("Kontostand");
		for (int i = 3; i < maxTransaction + 3; i++) {
			labels.add("");
		}
		qTableWidget.setHorizontalHeaderLabels(labels);

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		final SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("E");
		for (int i = 0; i < dates.size(); i++) {
			final Double balance = balances.get(dates.get(i));
			String balanceString;
			if (balance == null) {
				balanceString = "";
			} else {
				balanceString = balance.toString();
			}

			qTableWidget.setItem(i, 0, new QTableWidgetItem(simpleDateFormat.format(dates.get(i))));
			qTableWidget.setItem(i, 1, new QTableWidgetItem(simpleDateFormatDay.format(dates.get(i))));
			qTableWidget.setItem(i, 2, new QTableWidgetItem(balanceString));

			final ArrayList<Transaction> transactions = transactionsForDates.get(dates.get(i));

			for (int j = 0; j < transactions.size(); j++) {
				final String text = transactions.get(j).getName() + " : " + transactions.get(j).getAmount();
				qTableWidget.setIndexWidget(qTableWidget.model().index(i, 3 + j),
						new TransactionButton(text, transactions.get(j)));
			}

		}

		qTableWidget.resizeColumnsToContents();
		qTableWidget.resizeRowsToContents();

	}

	public void updateMonthOverview(final Integer tabNumber) {
		final QWidget qWidget = this.qTabWidget.widget(tabNumber);
		final Month month = this.findMonth(qWidget);
		this.updateMonthOverview(month);
	}

	private Month findMonth(final QWidget qWidget) {
		if (qWidget == null) {
			return null;
		}
		final ArrayList<Month> months = new ArrayList<>();

		months.add(Month.JANUARY);
		months.add(Month.FEBRUARY);
		months.add(Month.MARCH);
		months.add(Month.APRIL);
		months.add(Month.MAY);
		months.add(Month.JUNE);
		months.add(Month.JULY);
		months.add(Month.AUGUST);
		months.add(Month.SEPTEMBER);
		months.add(Month.OCTOBER);
		months.add(Month.NOVEMBER);
		months.add(Month.DECEMBER);

		for (final Month month : months) {
			if (qWidget.equals(this.tabs.get(month))) {
				return month;
			}
		}
		return null;
	}

	public boolean monthBack() {
		boolean yearChange = false;

		final QWidget qWidget = this.qTabWidget.currentWidget();
		Month month = this.findMonth(qWidget);

		if (month == Month.JANUARY) {
			month = Month.DECEMBER;
			yearChange = true;
		} else {
			final Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MONTH, month.getValue() - 2);
			// minus 1 because shift between month as value and enum and minus 1
			// because we want to shift by one month
			month = DateUtils.getMonth(calendar.getTime());
		}

		this.qTabWidget.setCurrentWidget(this.tabs.get(month));

		this.updateMonthOverview(month);

		return yearChange;
	}

	public boolean monthForward() {
		boolean yearChange = false;

		final QWidget qWidget = this.qTabWidget.currentWidget();
		Month month = this.findMonth(qWidget);

		if (month == Month.DECEMBER) {
			month = Month.JANUARY;
			yearChange = true;
		} else {
			final Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.MONTH, month.getValue());
			// minus 1 because shift between month as value and enum and plus 1
			// because we want to shift by one month
			month = DateUtils.getMonth(calendar.getTime());
		}

		this.qTabWidget.setCurrentWidget(this.tabs.get(month));

		this.updateMonthOverview(month);

		return yearChange;
	}

	public HashMap<Month, QWidget> getTabs() {
		return this.tabs;
	}

}
