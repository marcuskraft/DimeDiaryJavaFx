package com.dimediary.view.design;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.controller.utils.DateUtils;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.ContinuousTransaction.DayOfMonth;
import com.dimediary.model.entities.ContinuousTransaction.IterationState;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.ui.UicontinuousTransactionWidget;
import com.dimediary.view.utils.QTUtils;
import com.trolltech.qt.gui.QWidget;

public class ContinuousTransactionWidget extends UicontinuousTransactionWidget {

	private final QWidget continuousTransactionWidget;

	private ArrayList<Date> dates;

	HashMap<String, DayOfMonth> dayOfMonthByMonthlyMapping;
	ArrayList<String> dayOfMonthStrings;

	public ContinuousTransactionWidget() {
		this.continuousTransactionWidget = new QWidget();
		this.setupUi(this.continuousTransactionWidget);

		this.initMapping();
		this.initialize();

		this.spinBoxEveryNumberOfMonths.setValue(1);

	}

	private void initialize() {
		this.radioButtonMonthly.setChecked(true);
		this.radioButtonDayli.setDisabled(true);
		this.radioButtonWeekly.setDisabled(true);
		this.radioButtonYearly.setDisabled(true);

		this.groupBoxMonthly.setVisible(true);
		this.groupBoxDayli.setVisible(false);
		this.groupBoxWeekly.setVisible(false);
		this.groupBoxYearly.setVisible(false);

		this.radioButtonNoEndDate.setChecked(true);

		this.spinBoxNumberOfIterations.setValue(10);

		final Date date = new Date();
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		this.dateEditIterateUntil.setDate(QTUtils.dateToQDate(calendar.getTime()));

		this.comboBoxMonthlyWhichDayOfMonth.clear();
		this.comboBoxMonthlyWhichDayOfMonth.addItems(this.dayOfMonthStrings);

	}

	public void addContinuousTransaction(final ContinuousTransaction continuousTransaction) {
		final ArrayList<Date> dates = this.initContinuousTransaction(continuousTransaction);
		final ArrayList<Transaction> transactions = this.createTransactions(continuousTransaction, dates);
		this.persist(continuousTransaction, transactions);
	}

	private ArrayList<Date> initContinuousTransaction(final ContinuousTransaction continuousTransaction) {
		ArrayList<Date> dates = new ArrayList<>();
		if (this.radioButtonMonthly.isChecked()) {
			this.initMonthlyTransaction(continuousTransaction);
			dates = DateUtils.getMonthlyDates(continuousTransaction.getEveryIterationState(),
					continuousTransaction.getDayOfMonth(), continuousTransaction.getDateBeginn(),
					continuousTransaction.getDateUntil(), continuousTransaction.getNumberOfIterations());
		} else if (this.radioButtonDayli.isChecked()) {

		} else if (this.radioButtonWeekly.isChecked()) {

		} else if (this.radioButtonYearly.isChecked()) {

		}
		return dates;
	}

	public void mergeContinuousTransaction(final ContinuousTransaction continuousTransaction) {
		this.dates = this.initContinuousTransaction(continuousTransaction);
		new MergeContinuousTransactionDialog(this, continuousTransaction);
	}

	public void mergeContinuousTransaction(final ContinuousTransaction continuousTransaction, final Date date) {
		final ArrayList<Transaction> oldTransactions = DBUtils.getInstance()
				.getTransactionsFromDate(continuousTransaction, date);
		DBUtils.getInstance().deleteTransactions(oldTransactions);
		this.dates = DateUtils.removeDatesBefore(this.dates, date);
		final ArrayList<Transaction> newTransActions = this.createTransactions(continuousTransaction, this.dates);

		this.persist(continuousTransaction, newTransActions);
	}

	public void mergAllContinuousTransactions(final ContinuousTransaction continuousTransaction) {
		final ArrayList<Transaction> oldTransactions = DBUtils.getInstance().getTransactions(continuousTransaction);
		DBUtils.getInstance().deleteTransactions(oldTransactions);
		final ArrayList<Transaction> newTransActions = this.createTransactions(continuousTransaction, this.dates);

		this.persist(continuousTransaction, newTransActions);
	}

	public void deleteContinuousTransaction(final ContinuousTransaction continuousTransaction) {
		new DeleteContinuousTransactionWidget(this, continuousTransaction);
	}

	public void deleteAllContinuousTransactions(final ContinuousTransaction continuousTransaction) {
		DBUtils.getInstance().deleteAllContinuousTransactions(continuousTransaction);
	}

	public void deleteContinuousTransaction(final ContinuousTransaction continuousTransaction, final Date dateFrom) {
		final ArrayList<Transaction> transactionsToDelete = DBUtils.getInstance()
				.getTransactionsFromDate(continuousTransaction, dateFrom);
		DBUtils.getInstance().deleteTransactions(transactionsToDelete);
		continuousTransaction.setDateUntil(DateUtils.substractOnDay(dateFrom));
		DBUtils.getInstance().merge(continuousTransaction);
	}

	public void initializeMonthly(final ContinuousTransaction continuousTransaction) {
		this.initialize();

		this.spinBoxEveryNumberOfMonths.setValue(continuousTransaction.getEveryIterationState());
		final DayOfMonth dayOfMonth = continuousTransaction.getDayOfMonth();

		this.comboBoxMonthlyWhichDayOfMonth
				.setCurrentIndex(this.comboBoxMonthlyWhichDayOfMonth.findText(this.getStringForDayOfMonth(dayOfMonth)));

		if (continuousTransaction.getDateUntil() != null) {
			this.radioButtonIterateUntilDate.setChecked(true);
		} else if (continuousTransaction.getNumberOfIterations() != null) {
			this.radioButtonNumberOfIterations.setChecked(true);
		}
	}

	private void initMonthlyTransaction(final ContinuousTransaction continuousTransaction) {
		continuousTransaction.setIterationState(IterationState.MONTHLY);
		continuousTransaction.setEveryIterationState(this.spinBoxEveryNumberOfMonths.value());
		continuousTransaction
				.setDayOfMonth(this.dayOfMonthByMonthlyMapping.get(this.comboBoxMonthlyWhichDayOfMonth.currentText()));

		if (this.radioButtonNumberOfIterations.isChecked()) {
			continuousTransaction.setNumberOfIterations(this.spinBoxNumberOfIterations.value());
		} else if (this.radioButtonIterateUntilDate.isChecked()) {
			continuousTransaction.setDateUntil(QTUtils.qDateToDate(this.dateEditIterateUntil.date()));

		}

	}

	private void persist(final ContinuousTransaction continuousTransaction, final ArrayList<Transaction> transactions) {
		DBUtils.getInstance().persistContinuousTransaction(continuousTransaction, transactions);
	}

	private ArrayList<Transaction> createTransactions(final ContinuousTransaction continuousTransaction,
			final ArrayList<Date> dates) {
		final ArrayList<Transaction> transactions = new ArrayList<>();

		for (final Date date : dates) {
			final Transaction transaction = new Transaction();
			transaction.setAmount(continuousTransaction.getAmount());
			transaction.setBankAccount(continuousTransaction.getBankAccount());
			transaction.setCategory(continuousTransaction.getCategory());
			transaction.setDate(date);
			transaction.setContinuousTransaction(continuousTransaction);
			transaction.setName(continuousTransaction.getName());
			transaction.setUser(continuousTransaction.getUser());
			transactions.add(transaction);
		}
		return transactions;
	}

	private void initMapping() {
		this.dayOfMonthByMonthlyMapping = new HashMap<>();
		final String key1 = "Am ersten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(key1, DayOfMonth.FIRST);
		final String key2 = "Am zweiten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(key2, DayOfMonth.SECOND);
		final String key3 = "Am dritten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(key3, DayOfMonth.THIRD);
		final String key15 = "Am Fünfzehnten des Monats";
		this.dayOfMonthByMonthlyMapping.put(key15, DayOfMonth.FIFTHTEENS);
		final String keyNextToLast = "Am vorletzten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(keyNextToLast, DayOfMonth.NEXT_TO_LAST);
		final String keyLast = "Am letzten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(keyLast, DayOfMonth.LAST);

		this.dayOfMonthStrings = new ArrayList<>();
		this.dayOfMonthStrings.add(key1);
		this.dayOfMonthStrings.add(key2);
		this.dayOfMonthStrings.add(key3);
		this.dayOfMonthStrings.add(key15);
		this.dayOfMonthStrings.add(keyNextToLast);
		this.dayOfMonthStrings.add(keyLast);

	}

	public void createTrigger() {
		this.radioButtonDayli.clicked.connect(this, "onButtonDayli()");
		this.radioButtonMonthly.clicked.connect(this, "onButtonMonthly()");
		this.radioButtonWeekly.clicked.connect(this, "onButtonWeekly()");
		this.radioButtonYearly.clicked.connect(this, "onButtonYearly()");
	}

	public void onButtonMonthly() {
		this.groupBoxMonthly.setVisible(true);
		this.groupBoxDayli.setVisible(false);
		this.groupBoxWeekly.setVisible(false);
		this.groupBoxYearly.setVisible(false);
	}

	public void onButtonDayli() {
		this.groupBoxMonthly.setVisible(false);
		this.groupBoxDayli.setVisible(true);
		this.groupBoxWeekly.setVisible(false);
		this.groupBoxYearly.setVisible(false);
	}

	public void onButtonWeekly() {
		this.groupBoxMonthly.setVisible(false);
		this.groupBoxDayli.setVisible(false);
		this.groupBoxWeekly.setVisible(true);
		this.groupBoxYearly.setVisible(false);
	}

	public void onButtonYearly() {
		this.groupBoxMonthly.setVisible(false);
		this.groupBoxDayli.setVisible(false);
		this.groupBoxWeekly.setVisible(false);
		this.groupBoxYearly.setVisible(true);
	}

	private String getStringForDayOfMonth(final DayOfMonth dayOfMonth) {
		for (final String string : this.dayOfMonthByMonthlyMapping.keySet()) {
			if (dayOfMonth == this.dayOfMonthByMonthlyMapping.get(string)) {
				return string;
			}
		}
		return null;
	}

	public QWidget getContinuousTransactionWidget() {
		return this.continuousTransactionWidget;
	}
}
