/********************************************************************************
 ** Form generated from reading ui file 'continuoustransactionwidget.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;

import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.QCheckBox;
import com.trolltech.qt.gui.QComboBox;
import com.trolltech.qt.gui.QDateEdit;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QGroupBox;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QRadioButton;
import com.trolltech.qt.gui.QSpacerItem;
import com.trolltech.qt.gui.QSpinBox;
import com.trolltech.qt.gui.QVBoxLayout;
import com.trolltech.qt.gui.QWidget;

public class UicontinuousTransactionWidget implements com.trolltech.qt.QUiForm<QWidget> {
	public QGridLayout gridLayout;
	public QGroupBox groupBoxScheme;
	public QGridLayout gridLayout_14;
	public QWidget widget_5;
	public QGridLayout gridLayout_8;
	public QSpacerItem horizontalSpacer_4;
	public QGridLayout gridLayout_9;
	public QRadioButton radioButtonDayli;
	public QRadioButton radioButtonWeekly;
	public QRadioButton radioButtonMonthly;
	public QRadioButton radioButtonYearly;
	public QGroupBox groupBoxMonthly;
	public QGridLayout gridLayout_10;
	public QSpacerItem horizontalSpacer_5;
	public QGridLayout gridLayout_11;
	public QLabel label_6;
	public QSpinBox spinBoxEveryNumberOfMonths;
	public QLabel label_7;
	public QComboBox comboBoxMonthlyWhichDayOfMonth;
	public QGroupBox groupBoxDayli;
	public QGridLayout gridLayout_12;
	public QGridLayout gridLayout_13;
	public QRadioButton radioButtonEveryWorkday;
	public QSpinBox spinBoxDayliEveryNumberOfDays;
	public QLabel label_8;
	public QRadioButton radioButtonEveryDay;
	public QSpacerItem horizontalSpacer_6;
	public QGroupBox groupBoxWeekly;
	public QGridLayout gridLayout_15;
	public QWidget widget_6;
	public QGridLayout gridLayout_16;
	public QSpacerItem verticalSpacer_4;
	public QGridLayout gridLayout_17;
	public QLabel label_9;
	public QSpinBox spinBoxEveryWeek;
	public QLabel label_10;
	public QWidget widget_7;
	public QGridLayout gridLayout_18;
	public QVBoxLayout verticalLayout;
	public QCheckBox checkBoxMonday;
	public QCheckBox checkBoxThuesday;
	public QCheckBox checkBoxWednesday;
	public QCheckBox checkBoxThursday;
	public QCheckBox checkBoxFriday;
	public QCheckBox checkBoxSaturday;
	public QCheckBox checkBoxSunday;
	public QSpacerItem verticalSpacer_5;
	public QSpacerItem horizontalSpacer_7;
	public QGroupBox groupBoxYearly;
	public QGridLayout gridLayout_19;
	public QSpacerItem horizontalSpacer_8;
	public QGridLayout gridLayout_20;
	public QComboBox comboBoxYearlyWhichMonth;
	public QLabel label_11;
	public QSpinBox spinBoxEveryYear;
	public QLabel label_12;
	public QSpinBox spinBoxYearlyDayOfMonth;
	public QLabel label_13;
	public QSpacerItem verticalSpacer_6;
	public QGroupBox groupBoxNumberOfIterations;
	public QGridLayout gridLayout_21;
	public QGridLayout gridLayout_22;
	public QRadioButton radioButtonIterateUntilDate;
	public QRadioButton radioButtonNumberOfIterations;
	public QDateEdit dateEditIterateUntil;
	public QSpinBox spinBoxNumberOfIterations;
	public QRadioButton radioButtonNoEndDate;
	public QLabel label_14;
	public QSpacerItem horizontalSpacer_9;

	public UicontinuousTransactionWidget() {
		super();
	}

	@Override
	public void setupUi(final QWidget continuousTransactionWidget) {
		continuousTransactionWidget.setObjectName("continuousTransactionWidget");
		continuousTransactionWidget
				.resize(new QSize(304, 723).expandedTo(continuousTransactionWidget.minimumSizeHint()));
		this.gridLayout = new QGridLayout(continuousTransactionWidget);
		this.gridLayout.setObjectName("gridLayout");
		this.groupBoxScheme = new QGroupBox(continuousTransactionWidget);
		this.groupBoxScheme.setObjectName("groupBoxScheme");
		this.gridLayout_14 = new QGridLayout(this.groupBoxScheme);
		this.gridLayout_14.setObjectName("gridLayout_14");
		this.widget_5 = new QWidget(this.groupBoxScheme);
		this.widget_5.setObjectName("widget_5");
		this.gridLayout_8 = new QGridLayout(this.widget_5);
		this.gridLayout_8.setObjectName("gridLayout_8");
		this.horizontalSpacer_4 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_8.addItem(this.horizontalSpacer_4, 0, 1, 1, 1);

		this.gridLayout_9 = new QGridLayout();
		this.gridLayout_9.setObjectName("gridLayout_9");
		this.radioButtonDayli = new QRadioButton(this.widget_5);
		this.radioButtonDayli.setObjectName("radioButtonDayli");

		this.gridLayout_9.addWidget(this.radioButtonDayli, 0, 1, 1, 1);

		this.radioButtonWeekly = new QRadioButton(this.widget_5);
		this.radioButtonWeekly.setObjectName("radioButtonWeekly");

		this.gridLayout_9.addWidget(this.radioButtonWeekly, 0, 0, 1, 1);

		this.radioButtonMonthly = new QRadioButton(this.widget_5);
		this.radioButtonMonthly.setObjectName("radioButtonMonthly");

		this.gridLayout_9.addWidget(this.radioButtonMonthly, 1, 0, 1, 1);

		this.radioButtonYearly = new QRadioButton(this.widget_5);
		this.radioButtonYearly.setObjectName("radioButtonYearly");

		this.gridLayout_9.addWidget(this.radioButtonYearly, 1, 1, 1, 1);

		this.gridLayout_8.addLayout(this.gridLayout_9, 0, 0, 1, 1);

		this.gridLayout_14.addWidget(this.widget_5, 0, 0, 1, 1);

		this.groupBoxMonthly = new QGroupBox(this.groupBoxScheme);
		this.groupBoxMonthly.setObjectName("groupBoxMonthly");
		this.gridLayout_10 = new QGridLayout(this.groupBoxMonthly);
		this.gridLayout_10.setObjectName("gridLayout_10");
		this.horizontalSpacer_5 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_10.addItem(this.horizontalSpacer_5, 0, 1, 1, 1);

		this.gridLayout_11 = new QGridLayout();
		this.gridLayout_11.setObjectName("gridLayout_11");
		this.label_6 = new QLabel(this.groupBoxMonthly);
		this.label_6.setObjectName("label_6");

		this.gridLayout_11.addWidget(this.label_6, 0, 2, 1, 1);

		this.spinBoxEveryNumberOfMonths = new QSpinBox(this.groupBoxMonthly);
		this.spinBoxEveryNumberOfMonths.setObjectName("spinBoxEveryNumberOfMonths");

		this.gridLayout_11.addWidget(this.spinBoxEveryNumberOfMonths, 0, 1, 1, 1);

		this.label_7 = new QLabel(this.groupBoxMonthly);
		this.label_7.setObjectName("label_7");

		this.gridLayout_11.addWidget(this.label_7, 0, 0, 1, 1);

		this.comboBoxMonthlyWhichDayOfMonth = new QComboBox(this.groupBoxMonthly);
		this.comboBoxMonthlyWhichDayOfMonth.setObjectName("comboBoxMonthlyWhichDayOfMonth");

		this.gridLayout_11.addWidget(this.comboBoxMonthlyWhichDayOfMonth, 2, 1, 1, 1);

		this.gridLayout_10.addLayout(this.gridLayout_11, 0, 0, 1, 1);

		this.gridLayout_14.addWidget(this.groupBoxMonthly, 1, 0, 1, 1);

		this.groupBoxDayli = new QGroupBox(this.groupBoxScheme);
		this.groupBoxDayli.setObjectName("groupBoxDayli");
		this.gridLayout_12 = new QGridLayout(this.groupBoxDayli);
		this.gridLayout_12.setObjectName("gridLayout_12");
		this.gridLayout_13 = new QGridLayout();
		this.gridLayout_13.setObjectName("gridLayout_13");
		this.radioButtonEveryWorkday = new QRadioButton(this.groupBoxDayli);
		this.radioButtonEveryWorkday.setObjectName("radioButtonEveryWorkday");

		this.gridLayout_13.addWidget(this.radioButtonEveryWorkday, 1, 0, 1, 1);

		this.spinBoxDayliEveryNumberOfDays = new QSpinBox(this.groupBoxDayli);
		this.spinBoxDayliEveryNumberOfDays.setObjectName("spinBoxDayliEveryNumberOfDays");

		this.gridLayout_13.addWidget(this.spinBoxDayliEveryNumberOfDays, 0, 1, 1, 1);

		this.label_8 = new QLabel(this.groupBoxDayli);
		this.label_8.setObjectName("label_8");

		this.gridLayout_13.addWidget(this.label_8, 0, 2, 1, 1);

		this.radioButtonEveryDay = new QRadioButton(this.groupBoxDayli);
		this.radioButtonEveryDay.setObjectName("radioButtonEveryDay");

		this.gridLayout_13.addWidget(this.radioButtonEveryDay, 0, 0, 1, 1);

		this.gridLayout_12.addLayout(this.gridLayout_13, 0, 0, 1, 1);

		this.horizontalSpacer_6 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_12.addItem(this.horizontalSpacer_6, 0, 1, 1, 1);

		this.gridLayout_14.addWidget(this.groupBoxDayli, 2, 0, 1, 1);

		this.groupBoxWeekly = new QGroupBox(this.groupBoxScheme);
		this.groupBoxWeekly.setObjectName("groupBoxWeekly");
		this.gridLayout_15 = new QGridLayout(this.groupBoxWeekly);
		this.gridLayout_15.setObjectName("gridLayout_15");
		this.widget_6 = new QWidget(this.groupBoxWeekly);
		this.widget_6.setObjectName("widget_6");
		this.gridLayout_16 = new QGridLayout(this.widget_6);
		this.gridLayout_16.setObjectName("gridLayout_16");
		this.verticalSpacer_4 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum,
				com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

		this.gridLayout_16.addItem(this.verticalSpacer_4, 1, 0, 1, 1);

		this.gridLayout_17 = new QGridLayout();
		this.gridLayout_17.setObjectName("gridLayout_17");
		this.label_9 = new QLabel(this.widget_6);
		this.label_9.setObjectName("label_9");

		this.gridLayout_17.addWidget(this.label_9, 0, 0, 1, 1);

		this.spinBoxEveryWeek = new QSpinBox(this.widget_6);
		this.spinBoxEveryWeek.setObjectName("spinBoxEveryWeek");

		this.gridLayout_17.addWidget(this.spinBoxEveryWeek, 0, 1, 1, 1);

		this.label_10 = new QLabel(this.widget_6);
		this.label_10.setObjectName("label_10");

		this.gridLayout_17.addWidget(this.label_10, 0, 2, 1, 1);

		this.gridLayout_16.addLayout(this.gridLayout_17, 0, 0, 1, 1);

		this.widget_7 = new QWidget(this.widget_6);
		this.widget_7.setObjectName("widget_7");
		this.gridLayout_18 = new QGridLayout(this.widget_7);
		this.gridLayout_18.setObjectName("gridLayout_18");
		this.verticalLayout = new QVBoxLayout();
		this.verticalLayout.setObjectName("verticalLayout");
		this.checkBoxMonday = new QCheckBox(this.widget_7);
		this.checkBoxMonday.setObjectName("checkBoxMonday");

		this.verticalLayout.addWidget(this.checkBoxMonday);

		this.checkBoxThuesday = new QCheckBox(this.widget_7);
		this.checkBoxThuesday.setObjectName("checkBoxThuesday");

		this.verticalLayout.addWidget(this.checkBoxThuesday);

		this.checkBoxWednesday = new QCheckBox(this.widget_7);
		this.checkBoxWednesday.setObjectName("checkBoxWednesday");

		this.verticalLayout.addWidget(this.checkBoxWednesday);

		this.checkBoxThursday = new QCheckBox(this.widget_7);
		this.checkBoxThursday.setObjectName("checkBoxThursday");

		this.verticalLayout.addWidget(this.checkBoxThursday);

		this.checkBoxFriday = new QCheckBox(this.widget_7);
		this.checkBoxFriday.setObjectName("checkBoxFriday");

		this.verticalLayout.addWidget(this.checkBoxFriday);

		this.checkBoxSaturday = new QCheckBox(this.widget_7);
		this.checkBoxSaturday.setObjectName("checkBoxSaturday");

		this.verticalLayout.addWidget(this.checkBoxSaturday);

		this.checkBoxSunday = new QCheckBox(this.widget_7);
		this.checkBoxSunday.setObjectName("checkBoxSunday");

		this.verticalLayout.addWidget(this.checkBoxSunday);

		this.gridLayout_18.addLayout(this.verticalLayout, 0, 0, 1, 1);

		this.verticalSpacer_5 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum,
				com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

		this.gridLayout_18.addItem(this.verticalSpacer_5, 1, 0, 1, 1);

		this.horizontalSpacer_7 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_18.addItem(this.horizontalSpacer_7, 0, 1, 1, 1);

		this.gridLayout_16.addWidget(this.widget_7, 0, 1, 2, 1);

		this.gridLayout_15.addWidget(this.widget_6, 0, 0, 1, 1);

		this.gridLayout_14.addWidget(this.groupBoxWeekly, 3, 0, 1, 1);

		this.groupBoxYearly = new QGroupBox(this.groupBoxScheme);
		this.groupBoxYearly.setObjectName("groupBoxYearly");
		this.gridLayout_19 = new QGridLayout(this.groupBoxYearly);
		this.gridLayout_19.setObjectName("gridLayout_19");
		this.horizontalSpacer_8 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_19.addItem(this.horizontalSpacer_8, 0, 1, 1, 1);

		this.gridLayout_20 = new QGridLayout();
		this.gridLayout_20.setObjectName("gridLayout_20");
		this.comboBoxYearlyWhichMonth = new QComboBox(this.groupBoxYearly);
		this.comboBoxYearlyWhichMonth.setObjectName("comboBoxYearlyWhichMonth");

		this.gridLayout_20.addWidget(this.comboBoxYearlyWhichMonth, 1, 2, 1, 1);

		this.label_11 = new QLabel(this.groupBoxYearly);
		this.label_11.setObjectName("label_11");

		this.gridLayout_20.addWidget(this.label_11, 0, 0, 1, 1);

		this.spinBoxEveryYear = new QSpinBox(this.groupBoxYearly);
		this.spinBoxEveryYear.setObjectName("spinBoxEveryYear");

		this.gridLayout_20.addWidget(this.spinBoxEveryYear, 0, 1, 1, 1);

		this.label_12 = new QLabel(this.groupBoxYearly);
		this.label_12.setObjectName("label_12");

		this.gridLayout_20.addWidget(this.label_12, 0, 2, 1, 1);

		this.spinBoxYearlyDayOfMonth = new QSpinBox(this.groupBoxYearly);
		this.spinBoxYearlyDayOfMonth.setObjectName("spinBoxYearlyDayOfMonth");

		this.gridLayout_20.addWidget(this.spinBoxYearlyDayOfMonth, 1, 1, 1, 1);

		this.label_13 = new QLabel(this.groupBoxYearly);
		this.label_13.setObjectName("label_13");

		this.gridLayout_20.addWidget(this.label_13, 1, 0, 1, 1);

		this.gridLayout_19.addLayout(this.gridLayout_20, 0, 0, 1, 1);

		this.verticalSpacer_6 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum,
				com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

		this.gridLayout_19.addItem(this.verticalSpacer_6, 1, 0, 1, 1);

		this.gridLayout_14.addWidget(this.groupBoxYearly, 4, 0, 1, 1);

		this.gridLayout.addWidget(this.groupBoxScheme, 0, 0, 1, 1);

		this.groupBoxNumberOfIterations = new QGroupBox(continuousTransactionWidget);
		this.groupBoxNumberOfIterations.setObjectName("groupBoxNumberOfIterations");
		this.gridLayout_21 = new QGridLayout(this.groupBoxNumberOfIterations);
		this.gridLayout_21.setObjectName("gridLayout_21");
		this.gridLayout_22 = new QGridLayout();
		this.gridLayout_22.setObjectName("gridLayout_22");
		this.radioButtonIterateUntilDate = new QRadioButton(this.groupBoxNumberOfIterations);
		this.radioButtonIterateUntilDate.setObjectName("radioButtonIterateUntilDate");

		this.gridLayout_22.addWidget(this.radioButtonIterateUntilDate, 2, 0, 1, 1);

		this.radioButtonNumberOfIterations = new QRadioButton(this.groupBoxNumberOfIterations);
		this.radioButtonNumberOfIterations.setObjectName("radioButtonNumberOfIterations");

		this.gridLayout_22.addWidget(this.radioButtonNumberOfIterations, 1, 0, 1, 1);

		this.dateEditIterateUntil = new QDateEdit(this.groupBoxNumberOfIterations);
		this.dateEditIterateUntil.setObjectName("dateEditIterateUntil");
		this.dateEditIterateUntil.setCalendarPopup(true);

		this.gridLayout_22.addWidget(this.dateEditIterateUntil, 2, 1, 1, 1);

		this.spinBoxNumberOfIterations = new QSpinBox(this.groupBoxNumberOfIterations);
		this.spinBoxNumberOfIterations.setObjectName("spinBoxNumberOfIterations");

		this.gridLayout_22.addWidget(this.spinBoxNumberOfIterations, 1, 1, 1, 1);

		this.radioButtonNoEndDate = new QRadioButton(this.groupBoxNumberOfIterations);
		this.radioButtonNoEndDate.setObjectName("radioButtonNoEndDate");

		this.gridLayout_22.addWidget(this.radioButtonNoEndDate, 0, 0, 1, 1);

		this.label_14 = new QLabel(this.groupBoxNumberOfIterations);
		this.label_14.setObjectName("label_14");

		this.gridLayout_22.addWidget(this.label_14, 1, 2, 1, 1);

		this.gridLayout_21.addLayout(this.gridLayout_22, 0, 0, 1, 1);

		this.horizontalSpacer_9 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_21.addItem(this.horizontalSpacer_9, 0, 1, 1, 1);

		this.gridLayout.addWidget(this.groupBoxNumberOfIterations, 1, 0, 1, 1);

		this.retranslateUi(continuousTransactionWidget);

		continuousTransactionWidget.connectSlotsByName();
	} // setupUi

	void retranslateUi(final QWidget continuousTransactionWidget) {
		continuousTransactionWidget.setWindowTitle(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Form", null));
		this.groupBoxScheme.setTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget",
				"Wiederholungsschema", null));
		this.radioButtonDayli.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "t\u00e4glich", null));
		this.radioButtonWeekly.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget",
				"w\u00f6chentlich", null));
		this.radioButtonMonthly.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "monatlich", null));
		this.radioButtonYearly.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "j\u00e4hrlich", null));
		this.groupBoxMonthly.setTitle(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "monatlich", null));
		this.label_6.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Monat", null));
		this.label_7.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jeden", null));
		this.groupBoxDayli.setTitle(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "t\u00e4glich", null));
		this.radioButtonEveryWorkday.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "jeden Werktag", null));
		this.label_8
				.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Tag", null));
		this.radioButtonEveryDay.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jeden", null));
		this.groupBoxWeekly.setTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget",
				"w\u00f6chentlich", null));
		this.label_9
				.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jede", null));
		this.label_10.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Woche", null));
		this.checkBoxMonday.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Monatg", null));
		this.checkBoxThuesday.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Dienstag", null));
		this.checkBoxWednesday.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Mittwoch", null));
		this.checkBoxThursday.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Donnerstag", null));
		this.checkBoxFriday.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Freitag", null));
		this.checkBoxSaturday.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Sonnabend", null));
		this.checkBoxSunday.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Sonntag", null));
		this.groupBoxYearly.setTitle(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "j\u00e4hrlich", null));
		this.label_11.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jedes", null));
		this.label_12
				.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jahr", null));
		this.label_13.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jeden", null));
		this.groupBoxNumberOfIterations.setTitle(com.trolltech.qt.core.QCoreApplication
				.translate("continuousTransactionWidget", "Bereich der Widerholung", null));
		this.radioButtonIterateUntilDate.setText(com.trolltech.qt.core.QCoreApplication
				.translate("continuousTransactionWidget", "Wiederhole bis", null));
		this.radioButtonNumberOfIterations.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Erstelle", null));
		this.radioButtonNoEndDate.setText(
				com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Kein Enddatum", null));
		this.label_14.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget",
				"Transaktioinen", null));
	} // retranslateUi

}
