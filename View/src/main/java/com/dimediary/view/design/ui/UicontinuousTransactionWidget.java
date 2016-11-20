/********************************************************************************
 ** Form generated from reading ui file 'continuoustransactionwidget.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.core.Qt.Orientation;
import com.trolltech.qt.gui.QFrame;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UicontinuousTransactionWidget implements com.trolltech.qt.QUiForm<QWidget>
{
    public QGridLayout gridLayout_2;
    public QFrame frame;
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
    public QSpacerItem verticalSpacer_7;

    public UicontinuousTransactionWidget() { super(); }

    public void setupUi(QWidget continuousTransactionWidget)
    {
        continuousTransactionWidget.setObjectName("continuousTransactionWidget");
        continuousTransactionWidget.resize(new QSize(324, 749).expandedTo(continuousTransactionWidget.minimumSizeHint()));
        gridLayout_2 = new QGridLayout(continuousTransactionWidget);
        gridLayout_2.setObjectName("gridLayout_2");
        frame = new QFrame(continuousTransactionWidget);
        frame.setObjectName("frame");
        frame.setFrameShape(QFrame.Shape.StyledPanel);
        frame.setFrameShadow(QFrame.Shadow.Raised);
        gridLayout = new QGridLayout(frame);
        gridLayout.setObjectName("gridLayout");
        groupBoxScheme = new QGroupBox(frame);
        groupBoxScheme.setObjectName("groupBoxScheme");
        gridLayout_14 = new QGridLayout(groupBoxScheme);
        gridLayout_14.setObjectName("gridLayout_14");
        widget_5 = new QWidget(groupBoxScheme);
        widget_5.setObjectName("widget_5");
        gridLayout_8 = new QGridLayout(widget_5);
        gridLayout_8.setObjectName("gridLayout_8");
        horizontalSpacer_4 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_8.addItem(horizontalSpacer_4, 0, 1, 1, 1);

        gridLayout_9 = new QGridLayout();
        gridLayout_9.setObjectName("gridLayout_9");
        radioButtonDayli = new QRadioButton(widget_5);
        radioButtonDayli.setObjectName("radioButtonDayli");

        gridLayout_9.addWidget(radioButtonDayli, 0, 1, 1, 1);

        radioButtonWeekly = new QRadioButton(widget_5);
        radioButtonWeekly.setObjectName("radioButtonWeekly");

        gridLayout_9.addWidget(radioButtonWeekly, 0, 0, 1, 1);

        radioButtonMonthly = new QRadioButton(widget_5);
        radioButtonMonthly.setObjectName("radioButtonMonthly");

        gridLayout_9.addWidget(radioButtonMonthly, 1, 0, 1, 1);

        radioButtonYearly = new QRadioButton(widget_5);
        radioButtonYearly.setObjectName("radioButtonYearly");

        gridLayout_9.addWidget(radioButtonYearly, 1, 1, 1, 1);


        gridLayout_8.addLayout(gridLayout_9, 0, 0, 1, 1);


        gridLayout_14.addWidget(widget_5, 0, 0, 1, 1);

        groupBoxMonthly = new QGroupBox(groupBoxScheme);
        groupBoxMonthly.setObjectName("groupBoxMonthly");
        gridLayout_10 = new QGridLayout(groupBoxMonthly);
        gridLayout_10.setObjectName("gridLayout_10");
        horizontalSpacer_5 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_10.addItem(horizontalSpacer_5, 0, 1, 1, 1);

        gridLayout_11 = new QGridLayout();
        gridLayout_11.setObjectName("gridLayout_11");
        label_6 = new QLabel(groupBoxMonthly);
        label_6.setObjectName("label_6");

        gridLayout_11.addWidget(label_6, 0, 2, 1, 1);

        spinBoxEveryNumberOfMonths = new QSpinBox(groupBoxMonthly);
        spinBoxEveryNumberOfMonths.setObjectName("spinBoxEveryNumberOfMonths");

        gridLayout_11.addWidget(spinBoxEveryNumberOfMonths, 0, 1, 1, 1);

        label_7 = new QLabel(groupBoxMonthly);
        label_7.setObjectName("label_7");

        gridLayout_11.addWidget(label_7, 0, 0, 1, 1);

        comboBoxMonthlyWhichDayOfMonth = new QComboBox(groupBoxMonthly);
        comboBoxMonthlyWhichDayOfMonth.setObjectName("comboBoxMonthlyWhichDayOfMonth");

        gridLayout_11.addWidget(comboBoxMonthlyWhichDayOfMonth, 2, 1, 1, 1);


        gridLayout_10.addLayout(gridLayout_11, 0, 0, 1, 1);


        gridLayout_14.addWidget(groupBoxMonthly, 1, 0, 1, 1);

        groupBoxDayli = new QGroupBox(groupBoxScheme);
        groupBoxDayli.setObjectName("groupBoxDayli");
        gridLayout_12 = new QGridLayout(groupBoxDayli);
        gridLayout_12.setObjectName("gridLayout_12");
        gridLayout_13 = new QGridLayout();
        gridLayout_13.setObjectName("gridLayout_13");
        radioButtonEveryWorkday = new QRadioButton(groupBoxDayli);
        radioButtonEveryWorkday.setObjectName("radioButtonEveryWorkday");

        gridLayout_13.addWidget(radioButtonEveryWorkday, 1, 0, 1, 1);

        spinBoxDayliEveryNumberOfDays = new QSpinBox(groupBoxDayli);
        spinBoxDayliEveryNumberOfDays.setObjectName("spinBoxDayliEveryNumberOfDays");

        gridLayout_13.addWidget(spinBoxDayliEveryNumberOfDays, 0, 1, 1, 1);

        label_8 = new QLabel(groupBoxDayli);
        label_8.setObjectName("label_8");

        gridLayout_13.addWidget(label_8, 0, 2, 1, 1);

        radioButtonEveryDay = new QRadioButton(groupBoxDayli);
        radioButtonEveryDay.setObjectName("radioButtonEveryDay");

        gridLayout_13.addWidget(radioButtonEveryDay, 0, 0, 1, 1);


        gridLayout_12.addLayout(gridLayout_13, 0, 0, 1, 1);

        horizontalSpacer_6 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_12.addItem(horizontalSpacer_6, 0, 1, 1, 1);


        gridLayout_14.addWidget(groupBoxDayli, 2, 0, 1, 1);

        groupBoxWeekly = new QGroupBox(groupBoxScheme);
        groupBoxWeekly.setObjectName("groupBoxWeekly");
        gridLayout_15 = new QGridLayout(groupBoxWeekly);
        gridLayout_15.setObjectName("gridLayout_15");
        widget_6 = new QWidget(groupBoxWeekly);
        widget_6.setObjectName("widget_6");
        gridLayout_16 = new QGridLayout(widget_6);
        gridLayout_16.setObjectName("gridLayout_16");
        verticalSpacer_4 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_16.addItem(verticalSpacer_4, 1, 0, 1, 1);

        gridLayout_17 = new QGridLayout();
        gridLayout_17.setObjectName("gridLayout_17");
        label_9 = new QLabel(widget_6);
        label_9.setObjectName("label_9");

        gridLayout_17.addWidget(label_9, 0, 0, 1, 1);

        spinBoxEveryWeek = new QSpinBox(widget_6);
        spinBoxEveryWeek.setObjectName("spinBoxEveryWeek");

        gridLayout_17.addWidget(spinBoxEveryWeek, 0, 1, 1, 1);

        label_10 = new QLabel(widget_6);
        label_10.setObjectName("label_10");

        gridLayout_17.addWidget(label_10, 0, 2, 1, 1);


        gridLayout_16.addLayout(gridLayout_17, 0, 0, 1, 1);

        widget_7 = new QWidget(widget_6);
        widget_7.setObjectName("widget_7");
        gridLayout_18 = new QGridLayout(widget_7);
        gridLayout_18.setObjectName("gridLayout_18");
        verticalLayout = new QVBoxLayout();
        verticalLayout.setObjectName("verticalLayout");
        checkBoxMonday = new QCheckBox(widget_7);
        checkBoxMonday.setObjectName("checkBoxMonday");

        verticalLayout.addWidget(checkBoxMonday);

        checkBoxThuesday = new QCheckBox(widget_7);
        checkBoxThuesday.setObjectName("checkBoxThuesday");

        verticalLayout.addWidget(checkBoxThuesday);

        checkBoxWednesday = new QCheckBox(widget_7);
        checkBoxWednesday.setObjectName("checkBoxWednesday");

        verticalLayout.addWidget(checkBoxWednesday);

        checkBoxThursday = new QCheckBox(widget_7);
        checkBoxThursday.setObjectName("checkBoxThursday");

        verticalLayout.addWidget(checkBoxThursday);

        checkBoxFriday = new QCheckBox(widget_7);
        checkBoxFriday.setObjectName("checkBoxFriday");

        verticalLayout.addWidget(checkBoxFriday);

        checkBoxSaturday = new QCheckBox(widget_7);
        checkBoxSaturday.setObjectName("checkBoxSaturday");

        verticalLayout.addWidget(checkBoxSaturday);

        checkBoxSunday = new QCheckBox(widget_7);
        checkBoxSunday.setObjectName("checkBoxSunday");

        verticalLayout.addWidget(checkBoxSunday);


        gridLayout_18.addLayout(verticalLayout, 0, 0, 1, 1);

        verticalSpacer_5 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_18.addItem(verticalSpacer_5, 1, 0, 1, 1);

        horizontalSpacer_7 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_18.addItem(horizontalSpacer_7, 0, 1, 1, 1);


        gridLayout_16.addWidget(widget_7, 0, 1, 2, 1);


        gridLayout_15.addWidget(widget_6, 0, 0, 1, 1);


        gridLayout_14.addWidget(groupBoxWeekly, 3, 0, 1, 1);

        groupBoxYearly = new QGroupBox(groupBoxScheme);
        groupBoxYearly.setObjectName("groupBoxYearly");
        gridLayout_19 = new QGridLayout(groupBoxYearly);
        gridLayout_19.setObjectName("gridLayout_19");
        horizontalSpacer_8 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_19.addItem(horizontalSpacer_8, 0, 1, 1, 1);

        gridLayout_20 = new QGridLayout();
        gridLayout_20.setObjectName("gridLayout_20");
        comboBoxYearlyWhichMonth = new QComboBox(groupBoxYearly);
        comboBoxYearlyWhichMonth.setObjectName("comboBoxYearlyWhichMonth");

        gridLayout_20.addWidget(comboBoxYearlyWhichMonth, 1, 2, 1, 1);

        label_11 = new QLabel(groupBoxYearly);
        label_11.setObjectName("label_11");

        gridLayout_20.addWidget(label_11, 0, 0, 1, 1);

        spinBoxEveryYear = new QSpinBox(groupBoxYearly);
        spinBoxEveryYear.setObjectName("spinBoxEveryYear");

        gridLayout_20.addWidget(spinBoxEveryYear, 0, 1, 1, 1);

        label_12 = new QLabel(groupBoxYearly);
        label_12.setObjectName("label_12");

        gridLayout_20.addWidget(label_12, 0, 2, 1, 1);

        spinBoxYearlyDayOfMonth = new QSpinBox(groupBoxYearly);
        spinBoxYearlyDayOfMonth.setObjectName("spinBoxYearlyDayOfMonth");

        gridLayout_20.addWidget(spinBoxYearlyDayOfMonth, 1, 1, 1, 1);

        label_13 = new QLabel(groupBoxYearly);
        label_13.setObjectName("label_13");

        gridLayout_20.addWidget(label_13, 1, 0, 1, 1);


        gridLayout_19.addLayout(gridLayout_20, 0, 0, 1, 1);

        verticalSpacer_6 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_19.addItem(verticalSpacer_6, 1, 0, 1, 1);


        gridLayout_14.addWidget(groupBoxYearly, 4, 0, 1, 1);


        gridLayout.addWidget(groupBoxScheme, 0, 0, 1, 1);

        groupBoxNumberOfIterations = new QGroupBox(frame);
        groupBoxNumberOfIterations.setObjectName("groupBoxNumberOfIterations");
        gridLayout_21 = new QGridLayout(groupBoxNumberOfIterations);
        gridLayout_21.setObjectName("gridLayout_21");
        gridLayout_22 = new QGridLayout();
        gridLayout_22.setObjectName("gridLayout_22");
        radioButtonIterateUntilDate = new QRadioButton(groupBoxNumberOfIterations);
        radioButtonIterateUntilDate.setObjectName("radioButtonIterateUntilDate");

        gridLayout_22.addWidget(radioButtonIterateUntilDate, 2, 0, 1, 1);

        radioButtonNumberOfIterations = new QRadioButton(groupBoxNumberOfIterations);
        radioButtonNumberOfIterations.setObjectName("radioButtonNumberOfIterations");

        gridLayout_22.addWidget(radioButtonNumberOfIterations, 1, 0, 1, 1);

        dateEditIterateUntil = new QDateEdit(groupBoxNumberOfIterations);
        dateEditIterateUntil.setObjectName("dateEditIterateUntil");
        dateEditIterateUntil.setCalendarPopup(true);

        gridLayout_22.addWidget(dateEditIterateUntil, 2, 1, 1, 1);

        spinBoxNumberOfIterations = new QSpinBox(groupBoxNumberOfIterations);
        spinBoxNumberOfIterations.setObjectName("spinBoxNumberOfIterations");

        gridLayout_22.addWidget(spinBoxNumberOfIterations, 1, 1, 1, 1);

        radioButtonNoEndDate = new QRadioButton(groupBoxNumberOfIterations);
        radioButtonNoEndDate.setObjectName("radioButtonNoEndDate");

        gridLayout_22.addWidget(radioButtonNoEndDate, 0, 0, 1, 1);

        label_14 = new QLabel(groupBoxNumberOfIterations);
        label_14.setObjectName("label_14");

        gridLayout_22.addWidget(label_14, 1, 2, 1, 1);


        gridLayout_21.addLayout(gridLayout_22, 0, 0, 1, 1);

        horizontalSpacer_9 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_21.addItem(horizontalSpacer_9, 0, 1, 1, 1);

        verticalSpacer_7 = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_21.addItem(verticalSpacer_7, 1, 0, 1, 1);


        gridLayout.addWidget(groupBoxNumberOfIterations, 1, 0, 1, 1);


        gridLayout_2.addWidget(frame, 0, 0, 1, 1);

        retranslateUi(continuousTransactionWidget);

        continuousTransactionWidget.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget continuousTransactionWidget)
    {
        continuousTransactionWidget.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Form", null));
        groupBoxScheme.setTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Wiederholungsschema", null));
        radioButtonDayli.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "t\u00e4glich", null));
        radioButtonWeekly.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "w\u00f6chentlich", null));
        radioButtonMonthly.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "monatlich", null));
        radioButtonYearly.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "j\u00e4hrlich", null));
        groupBoxMonthly.setTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "monatlich", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Monat", null));
        label_7.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jeden", null));
        groupBoxDayli.setTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "t\u00e4glich", null));
        radioButtonEveryWorkday.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "jeden Werktag", null));
        label_8.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Tag", null));
        radioButtonEveryDay.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jeden", null));
        groupBoxWeekly.setTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "w\u00f6chentlich", null));
        label_9.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jede", null));
        label_10.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Woche", null));
        checkBoxMonday.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Monatg", null));
        checkBoxThuesday.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Dienstag", null));
        checkBoxWednesday.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Mittwoch", null));
        checkBoxThursday.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Donnerstag", null));
        checkBoxFriday.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Freitag", null));
        checkBoxSaturday.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Sonnabend", null));
        checkBoxSunday.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Sonntag", null));
        groupBoxYearly.setTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "j\u00e4hrlich", null));
        label_11.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jedes", null));
        label_12.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jahr", null));
        label_13.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Jeden", null));
        groupBoxNumberOfIterations.setTitle(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Bereich der Widerholung", null));
        radioButtonIterateUntilDate.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Wiederhole bis", null));
        radioButtonNumberOfIterations.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Erstelle", null));
        radioButtonNoEndDate.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Kein Enddatum", null));
        label_14.setText(com.trolltech.qt.core.QCoreApplication.translate("continuousTransactionWidget", "Transaktioinen", null));
    } // retranslateUi

}

