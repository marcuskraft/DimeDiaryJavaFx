/********************************************************************************
 ** Form generated from reading ui file 'continuoustransactiondialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.core.Qt.Orientation;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiContinuousTransactionDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout_8;
    public QGroupBox groupBox;
    public QGridLayout gridLayout_7;
    public QGroupBox groupBoxDayli;
    public QGridLayout gridLayout_6;
    public QGridLayout gridLayout_2;
    public QComboBox comboBox_3;
    public QLabel label_3;
    public QComboBox comboBox_4;
    public QSpinBox spinBox_2;
    public QLabel label_4;
    public QGroupBox groupBoxMonthly;
    public QGridLayout gridLayout_3;
    public QGridLayout gridLayout;
    public QComboBox comboBox_2;
    public QLabel label;
    public QComboBox comboBox;
    public QSpinBox spinBox;
    public QLabel label_2;
    public QWidget widget;
    public QGridLayout gridLayout_5;
    public QSpacerItem horizontalSpacer;
    public QGridLayout gridLayout_4;
    public QRadioButton radioButtonMonthly;
    public QRadioButton radioButtonDayli;
    public QSpacerItem verticalSpacer;
    public QSpacerItem horizontalSpacer_2;
    public QDialogButtonBox buttonBox;

    public UiContinuousTransactionDialog() { super(); }

    public void setupUi(QDialog ContinuousTransactionDialog)
    {
        ContinuousTransactionDialog.setObjectName("ContinuousTransactionDialog");
        ContinuousTransactionDialog.resize(new QSize(543, 412).expandedTo(ContinuousTransactionDialog.minimumSizeHint()));
        gridLayout_8 = new QGridLayout(ContinuousTransactionDialog);
        gridLayout_8.setObjectName("gridLayout_8");
        groupBox = new QGroupBox(ContinuousTransactionDialog);
        groupBox.setObjectName("groupBox");
        gridLayout_7 = new QGridLayout(groupBox);
        gridLayout_7.setObjectName("gridLayout_7");
        groupBoxDayli = new QGroupBox(groupBox);
        groupBoxDayli.setObjectName("groupBoxDayli");
        gridLayout_6 = new QGridLayout(groupBoxDayli);
        gridLayout_6.setObjectName("gridLayout_6");
        gridLayout_2 = new QGridLayout();
        gridLayout_2.setObjectName("gridLayout_2");
        comboBox_3 = new QComboBox(groupBoxDayli);
        comboBox_3.setObjectName("comboBox_3");

        gridLayout_2.addWidget(comboBox_3, 1, 2, 1, 1);

        label_3 = new QLabel(groupBoxDayli);
        label_3.setObjectName("label_3");

        gridLayout_2.addWidget(label_3, 0, 0, 1, 1);

        comboBox_4 = new QComboBox(groupBoxDayli);
        comboBox_4.setObjectName("comboBox_4");

        gridLayout_2.addWidget(comboBox_4, 1, 1, 1, 1);

        spinBox_2 = new QSpinBox(groupBoxDayli);
        spinBox_2.setObjectName("spinBox_2");

        gridLayout_2.addWidget(spinBox_2, 0, 1, 1, 1);

        label_4 = new QLabel(groupBoxDayli);
        label_4.setObjectName("label_4");

        gridLayout_2.addWidget(label_4, 0, 2, 1, 1);


        gridLayout_6.addLayout(gridLayout_2, 0, 0, 1, 1);


        gridLayout_7.addWidget(groupBoxDayli, 3, 0, 1, 1);

        groupBoxMonthly = new QGroupBox(groupBox);
        groupBoxMonthly.setObjectName("groupBoxMonthly");
        gridLayout_3 = new QGridLayout(groupBoxMonthly);
        gridLayout_3.setObjectName("gridLayout_3");
        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        comboBox_2 = new QComboBox(groupBoxMonthly);
        comboBox_2.setObjectName("comboBox_2");

        gridLayout.addWidget(comboBox_2, 1, 2, 1, 1);

        label = new QLabel(groupBoxMonthly);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        comboBox = new QComboBox(groupBoxMonthly);
        comboBox.setObjectName("comboBox");

        gridLayout.addWidget(comboBox, 1, 1, 1, 1);

        spinBox = new QSpinBox(groupBoxMonthly);
        spinBox.setObjectName("spinBox");

        gridLayout.addWidget(spinBox, 0, 1, 1, 1);

        label_2 = new QLabel(groupBoxMonthly);
        label_2.setObjectName("label_2");

        gridLayout.addWidget(label_2, 0, 2, 1, 1);


        gridLayout_3.addLayout(gridLayout, 0, 0, 1, 1);


        gridLayout_7.addWidget(groupBoxMonthly, 1, 0, 1, 1);

        widget = new QWidget(groupBox);
        widget.setObjectName("widget");
        gridLayout_5 = new QGridLayout(widget);
        gridLayout_5.setObjectName("gridLayout_5");
        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_5.addItem(horizontalSpacer, 0, 1, 1, 1);

        gridLayout_4 = new QGridLayout();
        gridLayout_4.setObjectName("gridLayout_4");
        radioButtonMonthly = new QRadioButton(widget);
        radioButtonMonthly.setObjectName("radioButtonMonthly");

        gridLayout_4.addWidget(radioButtonMonthly, 1, 0, 1, 1);

        radioButtonDayli = new QRadioButton(widget);
        radioButtonDayli.setObjectName("radioButtonDayli");

        gridLayout_4.addWidget(radioButtonDayli, 0, 0, 1, 1);


        gridLayout_5.addLayout(gridLayout_4, 0, 0, 1, 1);


        gridLayout_7.addWidget(widget, 0, 0, 1, 1);

        verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_7.addItem(verticalSpacer, 4, 0, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_7.addItem(horizontalSpacer_2, 3, 1, 1, 1);


        gridLayout_8.addWidget(groupBox, 0, 0, 1, 1);

        buttonBox = new QDialogButtonBox(ContinuousTransactionDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));

        gridLayout_8.addWidget(buttonBox, 1, 0, 1, 1);

        retranslateUi(ContinuousTransactionDialog);
        buttonBox.accepted.connect(ContinuousTransactionDialog, "accept()");
        buttonBox.rejected.connect(ContinuousTransactionDialog, "reject()");

        ContinuousTransactionDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog ContinuousTransactionDialog)
    {
        ContinuousTransactionDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "Dauertransaktion erstellen", null));
        groupBox.setTitle(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "Wiederholungsschema", null));
        groupBoxDayli.setTitle(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "t\u00e4glich", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "Jeden", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "Tag", null));
        groupBoxMonthly.setTitle(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "monatlich", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "Jeden", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "Monat", null));
        radioButtonMonthly.setText(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "monatlich", null));
        radioButtonDayli.setText(com.trolltech.qt.core.QCoreApplication.translate("ContinuousTransactionDialog", "t\u00e4glich", null));
    } // retranslateUi

}

