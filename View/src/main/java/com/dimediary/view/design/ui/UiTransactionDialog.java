/********************************************************************************
 ** Form generated from reading ui file 'transactiondialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiTransactionDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout;
    public QLineEdit subjectEdit;
    public QComboBox comboBoxAccount;
    public QLabel label_5;
    public QDateEdit dateEdit;
    public QLabel label_3;
    public QLabel label_2;
    public QLabel label_4;
    public QPushButton pushButtonAddAccount;
    public QCheckBox checkBoxIncome;
    public QComboBox comboBoxCategory;
    public QPushButton pushButtonAddCategory;
    public QLabel label;
    public QDoubleSpinBox doubleSpinBoxAmount;
    public QPushButton pushButtonAdd;
    public QTableWidget tableTransactions;
    public QPushButton pushButtonDelete;
    public QPushButton pushButtonOK;

    public UiTransactionDialog() { super(); }

    public void setupUi(QDialog TransactionDialog)
    {
        TransactionDialog.setObjectName("TransactionDialog");
        TransactionDialog.resize(new QSize(642, 439).expandedTo(TransactionDialog.minimumSizeHint()));
        gridLayoutWidget = new QWidget(TransactionDialog);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(10, 210, 307, 191));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout.setObjectName("gridLayout");
        subjectEdit = new QLineEdit(gridLayoutWidget);
        subjectEdit.setObjectName("subjectEdit");

        gridLayout.addWidget(subjectEdit, 1, 2, 1, 1);

        comboBoxAccount = new QComboBox(gridLayoutWidget);
        comboBoxAccount.setObjectName("comboBoxAccount");

        gridLayout.addWidget(comboBoxAccount, 3, 2, 1, 1);

        label_5 = new QLabel(gridLayoutWidget);
        label_5.setObjectName("label_5");

        gridLayout.addWidget(label_5, 4, 1, 1, 1);

        dateEdit = new QDateEdit(gridLayoutWidget);
        dateEdit.setObjectName("dateEdit");

        gridLayout.addWidget(dateEdit, 0, 2, 1, 1);

        label_3 = new QLabel(gridLayoutWidget);
        label_3.setObjectName("label_3");

        gridLayout.addWidget(label_3, 2, 1, 1, 1);

        label_2 = new QLabel(gridLayoutWidget);
        label_2.setObjectName("label_2");

        gridLayout.addWidget(label_2, 1, 1, 1, 1);

        label_4 = new QLabel(gridLayoutWidget);
        label_4.setObjectName("label_4");

        gridLayout.addWidget(label_4, 3, 1, 1, 1);

        pushButtonAddAccount = new QPushButton(gridLayoutWidget);
        pushButtonAddAccount.setObjectName("pushButtonAddAccount");

        gridLayout.addWidget(pushButtonAddAccount, 3, 3, 1, 1);

        checkBoxIncome = new QCheckBox(gridLayoutWidget);
        checkBoxIncome.setObjectName("checkBoxIncome");

        gridLayout.addWidget(checkBoxIncome, 4, 3, 1, 1);

        comboBoxCategory = new QComboBox(gridLayoutWidget);
        comboBoxCategory.setObjectName("comboBoxCategory");

        gridLayout.addWidget(comboBoxCategory, 2, 2, 1, 1);

        pushButtonAddCategory = new QPushButton(gridLayoutWidget);
        pushButtonAddCategory.setObjectName("pushButtonAddCategory");

        gridLayout.addWidget(pushButtonAddCategory, 2, 3, 1, 1);

        label = new QLabel(gridLayoutWidget);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 1, 1, 1);

        doubleSpinBoxAmount = new QDoubleSpinBox(gridLayoutWidget);
        doubleSpinBoxAmount.setObjectName("doubleSpinBoxAmount");
        doubleSpinBoxAmount.setMinimum(-1e+09);
        doubleSpinBoxAmount.setMaximum(1e+09);

        gridLayout.addWidget(doubleSpinBoxAmount, 4, 2, 1, 1);

        pushButtonAdd = new QPushButton(TransactionDialog);
        pushButtonAdd.setObjectName("pushButtonAdd");
        pushButtonAdd.setGeometry(new QRect(10, 410, 75, 23));
        tableTransactions = new QTableWidget(TransactionDialog);
        tableTransactions.setObjectName("tableTransactions");
        tableTransactions.setGeometry(new QRect(10, 10, 621, 192));
        tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);
        pushButtonDelete = new QPushButton(TransactionDialog);
        pushButtonDelete.setObjectName("pushButtonDelete");
        pushButtonDelete.setGeometry(new QRect(434, 210, 191, 23));
        pushButtonOK = new QPushButton(TransactionDialog);
        pushButtonOK.setObjectName("pushButtonOK");
        pushButtonOK.setGeometry(new QRect(550, 410, 75, 23));
        QWidget.setTabOrder(dateEdit, subjectEdit);
        QWidget.setTabOrder(subjectEdit, comboBoxCategory);
        QWidget.setTabOrder(comboBoxCategory, comboBoxAccount);
        QWidget.setTabOrder(comboBoxAccount, doubleSpinBoxAmount);
        QWidget.setTabOrder(doubleSpinBoxAmount, pushButtonAddCategory);
        QWidget.setTabOrder(pushButtonAddCategory, pushButtonAddAccount);
        QWidget.setTabOrder(pushButtonAddAccount, checkBoxIncome);
        QWidget.setTabOrder(checkBoxIncome, pushButtonAdd);
        QWidget.setTabOrder(pushButtonAdd, tableTransactions);
        QWidget.setTabOrder(tableTransactions, pushButtonOK);
        QWidget.setTabOrder(pushButtonOK, pushButtonDelete);
        retranslateUi(TransactionDialog);
        pushButtonOK.clicked.connect(TransactionDialog, "accept()");

        TransactionDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog TransactionDialog)
    {
        TransactionDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion erstellen", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
        pushButtonAddAccount.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
        checkBoxIncome.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Einnahme", null));
        pushButtonAddCategory.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Hinzuf\u00fcgen", null));
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
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Markierte TransaktionenL\u00f6schen", null));
        pushButtonOK.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "OK", null));
    } // retranslateUi

}

