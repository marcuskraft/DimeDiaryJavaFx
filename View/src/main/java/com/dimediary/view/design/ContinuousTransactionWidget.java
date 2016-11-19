package com.dimediary.view.design;

import java.util.ArrayList;
import java.util.HashMap;

import com.dimediary.model.entities.ContinuousTransaction.DayOfMonth;
import com.dimediary.view.design.ui.UicontinuousTransactionWidget;
import com.trolltech.qt.gui.QWidget;

public class ContinuousTransactionWidget extends UicontinuousTransactionWidget {

	private final QWidget continuousTransactionWidget;

	HashMap<DayOfMonth, String> dayOfMonthByMonthlyMapping;
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

	private void initMapping() {
		this.dayOfMonthByMonthlyMapping = new HashMap<>();
		this.dayOfMonthByMonthlyMapping.put(DayOfMonth.FIRST, "Am ersten Tag des Monats");
		this.dayOfMonthByMonthlyMapping.put(DayOfMonth.SECOND, "Am zweiten Tag des Monats");
		this.dayOfMonthByMonthlyMapping.put(DayOfMonth.THIRD, "Am dritten Tag des Monats");
		this.dayOfMonthByMonthlyMapping.put(DayOfMonth.FIFTHTEENS, "Am Fünfzehnten des Monats");
		this.dayOfMonthByMonthlyMapping.put(DayOfMonth.NEXT_TO_LAST, "Am vorletzten Tag des Monats");
		this.dayOfMonthByMonthlyMapping.put(DayOfMonth.LAST, "Am letzten Tag des Monats");

		this.dayOfMonthStrings = new ArrayList<>();
		this.dayOfMonthStrings.add(this.dayOfMonthByMonthlyMapping.get(DayOfMonth.FIRST));
		this.dayOfMonthStrings.add(this.dayOfMonthByMonthlyMapping.get(DayOfMonth.SECOND));
		this.dayOfMonthStrings.add(this.dayOfMonthByMonthlyMapping.get(DayOfMonth.THIRD));
		this.dayOfMonthStrings.add(this.dayOfMonthByMonthlyMapping.get(DayOfMonth.FIFTHTEENS));
		this.dayOfMonthStrings.add(this.dayOfMonthByMonthlyMapping.get(DayOfMonth.NEXT_TO_LAST));
		this.dayOfMonthStrings.add(this.dayOfMonthByMonthlyMapping.get(DayOfMonth.LAST));
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
