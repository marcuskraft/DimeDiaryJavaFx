/********************************************************************************
 ** Form generated from reading ui file 'transactiondialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior;
import com.trolltech.qt.core.Qt.Orientation;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiTransactionDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QWidget widget;
    public QGridLayout gridLayout_2;
    public QPushButton pushButtonAdd;
    public QLabel label_2;
    public QLabel label_3;
    public QDateEdit dateEdit;
    public QComboBox comboBoxCategory;
    public QLabel label;
    public QLabel label_4;
    public QComboBox comboBoxAccount;
    public QLineEdit subjectEdit;
    public QPushButton pushButtonOK;
    public QPushButton pushButtonAddCategory;
    public QDoubleSpinBox doubleSpinBoxAmount;
    public QPushButton pushButtonAddAccount;
    public QLabel label_5;
    public QCheckBox checkBoxIncome;
    public QSpacerItem horizontalSpacer;
    public QPushButton pushButtonContinuousTransaction;
    public QWidget widget_2;
    public QGridLayout gridLayout_3;
    public QTableWidget tableTransactions;
    public QPushButton pushButtonDelete;
    public QSpacerItem horizontalSpacer_3;

    public UiTransactionDialog() { super(); }

    public void setupUi(QDialog TransactionDialog)
    {
        TransactionDialog.setObjectName("TransactionDialog");
        TransactionDialog.resize(new QSize(691, 523).expandedTo(TransactionDialog.minimumSizeHint()));
        gridLayout = new QGridLayout(TransactionDialog);
        gridLayout.setObjectName("gridLayout");
        widget = new QWidget(TransactionDialog);
        widget.setObjectName("widget");
        gridLayout_2 = new QGridLayout(widget);
        gridLayout_2.setObjectName("gridLayout_2");
        pushButtonAdd = new QPushButton(widget);
        pushButtonAdd.setObjectName("pushButtonAdd");

        gridLayout_2.addWidget(pushButtonAdd, 5, 0, 1, 1);

        label_2 = new QLabel(widget);
        label_2.setObjectName("label_2");

        gridLayout_2.addWidget(label_2, 1, 0, 1, 1);

        label_3 = new QLabel(widget);
        label_3.setObjectName("label_3");

        gridLayout_2.addWidget(label_3, 2, 0, 1, 1);

        dateEdit = new QDateEdit(widget);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setCalendarPopup(true);

        gridLayout_2.addWidget(dateEdit, 0, 1, 1, 1);

        comboBoxCategory = new QComboBox(widget);
        comboBoxCategory.setObjectName("comboBoxCategory");

        gridLayout_2.addWidget(comboBoxCategory, 2, 1, 1, 1);

        label = new QLabel(widget);
        label.setObjectName("label");

        gridLayout_2.addWidget(label, 0, 0, 1, 1);

        label_4 = new QLabel(widget);
        label_4.setObjectName("label_4");

        gridLayout_2.addWidget(label_4, 3, 0, 1, 1);

        comboBoxAccount = new QComboBox(widget);
        comboBoxAccount.setObjectName("comboBoxAccount");

        gridLayout_2.addWidget(comboBoxAccount, 3, 1, 1, 1);

        subjectEdit = new QLineEdit(widget);
        subjectEdit.setObjectName("subjectEdit");

        gridLayout_2.addWidget(subjectEdit, 1, 1, 1, 1);

        pushButtonOK = new QPushButton(widget);
        pushButtonOK.setObjectName("pushButtonOK");

        gridLayout_2.addWidget(pushButtonOK, 5, 5, 1, 1);

        pushButtonAddCategory = new QPushButton(widget);
        pushButtonAddCategory.setObjectName("pushButtonAddCategory");

        gridLayout_2.addWidget(pushButtonAddCategory, 2, 2, 1, 1);

        doubleSpinBoxAmount = new QDoubleSpinBox(widget);
        doubleSpinBoxAmount.setObjectName("doubleSpinBoxAmount");
        doubleSpinBoxAmount.setMinimum(-1e+09);
        doubleSpinBoxAmount.setMaximum(1e+09);

        gridLayout_2.addWidget(doubleSpinBoxAmount, 4, 1, 1, 1);

        pushButtonAddAccount = new QPushButton(widget);
        pushButtonAddAccount.setObjectName("pushButtonAddAccount");

        gridLayout_2.addWidget(pushButtonAddAccount, 3, 2, 1, 1);

        label_5 = new QLabel(widget);
        label_5.setObjectName("label_5");

        gridLayout_2.addWidget(label_5, 4, 0, 1, 1);

        checkBoxIncome = new QCheckBox(widget);
        checkBoxIncome.setObjectName("checkBoxIncome");

        gridLayout_2.addWidget(checkBoxIncome, 4, 2, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_2.addItem(horizontalSpacer, 5, 4, 1, 1);

        pushButtonContinuousTransaction = new QPushButton(widget);
        pushButtonContinuousTransaction.setObjectName("pushButtonContinuousTransaction");

        gridLayout_2.addWidget(pushButtonContinuousTransaction, 0, 5, 1, 1);


        gridLayout.addWidget(widget, 1, 0, 1, 1);

        widget_2 = new QWidget(TransactionDialog);
        widget_2.setObjectName("widget_2");
        gridLayout_3 = new QGridLayout(widget_2);
        gridLayout_3.setObjectName("gridLayout_3");
        tableTransactions = new QTableWidget(widget_2);
        tableTransactions.setObjectName("tableTransactions");
        tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);

        gridLayout_3.addWidget(tableTransactions, 1, 0, 2, 2);

        pushButtonDelete = new QPushButton(widget_2);
        pushButtonDelete.setObjectName("pushButtonDelete");

        gridLayout_3.addWidget(pushButtonDelete, 0, 0, 1, 1);

        horizontalSpacer_3 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_3.addItem(horizontalSpacer_3, 0, 1, 1, 1);


        gridLayout.addWidget(widget_2, 0, 0, 1, 1);

        QWidget.setTabOrder(dateEdit, subjectEdit);
        QWidget.setTabOrder(subjectEdit, comboBoxCategory);
        QWidget.setTabOrder(comboBoxCategory, comboBoxAccount);
        QWidget.setTabOrder(comboBoxAccount, doubleSpinBoxAmount);
        QWidget.setTabOrder(doubleSpinBoxAmount, pushButtonAddCategory);
        QWidget.setTabOrder(pushButtonAddCategory, pushButtonAddAccount);
        QWidget.setTabOrder(pushButtonAddAccount, checkBoxIncome);
        retranslateUi(TransactionDialog);
        pushButtonOK.clicked.connect(TransactionDialog, "accept()");

        TransactionDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog TransactionDialog)
    {
        TransactionDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion erstellen", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Hinzuf\u00fcgen", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
        pushButtonOK.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "OK", null));
        pushButtonAddCategory.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
        pushButtonAddAccount.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
        checkBoxIncome.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Einnahme", null));
        pushButtonContinuousTransaction.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Dauertransaktion", null));
        tableTransactions.clear();
        tableTransactions.setColumnCount(5);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
        tableTransactions.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
        tableTransactions.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
        tableTransactions.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
        tableTransactions.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
        tableTransactions.setHorizontalHeaderItem(4, __colItem4);
        tableTransactions.setRowCount(0);
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Markierte Transaktionen L\u00f6schen", null));
    } // retranslateUi

}

