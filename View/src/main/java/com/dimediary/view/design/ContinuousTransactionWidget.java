package com.dimediary.view.design;

import java.util.ArrayList;
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

	HashMap<String, DayOfMonth> dayOfMonthByMonthlyMapping;
	ArrayList<String> dayOfMonthStrings;

	public ContinuousTransactionWidget() {
		this.continuousTransactionWidget = new QWidget();
		this.setupUi(this.continuousTransactionWidget);

		this.radioButtonMonthly.setChecked(true);

		this.groupBoxMonthly.setVisible(true);
		this.groupBoxDayli.setVisible(false);
		this.groupBoxWeekly.setVisible(false);
		this.groupBoxYearly.setVisible(false);

		this.spinBoxEveryNumberOfMonths.setValue(1);

		this.initMapping();

		this.comboBoxMonthlyWhichDayOfMonth.addItems(this.dayOfMonthStrings);

	}

	public void initContinuousTransaction(final ContinuousTransaction continuousTransaction) {
		if (this.radioButtonMonthly.isChecked()) {
			this.initMonthlyTransaction(continuousTransaction);
		} else if (this.radioButtonDayli.isChecked()) {

		} else if (this.radioButtonWeekly.isChecked()) {

		} else if (this.radioButtonYearly.isChecked()) {

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
		final ArrayList<Date> dates = DateUtils.getMonthlyDates(continuousTransaction.getEveryIterationState(),
				continuousTransaction.getDayOfMonth(), continuousTransaction.getDateBeginn(),
				continuousTransaction.getDateUntil(), continuousTransaction.getNumberOfIterations());

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

		DBUtils.getInstance().persistContinuousTransaction(continuousTransaction, transactions);

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
		this.frame.adjustSize();
	}

	public void onButtonDayli() {
		this.groupBoxMonthly.setVisible(false);
		this.groupBoxDayli.setVisible(true);
		this.groupBoxWeekly.setVisible(false);
		this.groupBoxYearly.setVisible(false);
		this.frame.adjustSize();
	}

	public void onButtonWeekly() {
		this.groupBoxMonthly.setVisible(false);
		this.groupBoxDayli.setVisible(false);
		this.groupBoxWeekly.setVisible(true);
		this.groupBoxYearly.setVisible(false);
		this.frame.adjustSize();
	}

	public void onButtonYearly() {
		this.groupBoxMonthly.setVisible(false);
		this.groupBoxDayli.setVisible(false);
		this.groupBoxWeekly.setVisible(false);
		this.groupBoxYearly.setVisible(true);
		this.frame.adjustSize();
	}

	public void adjustSize() {
		this.groupBoxMonthly.adjustSize();
		this.groupBoxDayli.adjustSize();
		this.groupBoxWeekly.adjustSize();
		this.groupBoxYearly.adjustSize();
		this.groupBoxScheme.adjustSize();
		this.groupBoxNumberOfIterations.adjustSize();
		this.frame.adjustSize();
	}

	public QWidget getContinuousTransactionWidget() {
		return this.continuousTransactionWidget;
	}
}
