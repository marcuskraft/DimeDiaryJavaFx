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
    public QGridLayout gridLayout_2;
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
    public QSpacerItem horizontalSpacer;
    public QPushButton pushButtonAdd;
    public QPushButton pushButtonOK;
    public QTableWidget tableTransactions;
    public QPushButton pushButtonDelete;
    public QSpacerItem horizontalSpacer_2;
    public QSpacerItem horizontalSpacer_3;

    public UiTransactionDialog() { super(); }

    public void setupUi(QDialog TransactionDialog)
    {
        TransactionDialog.setObjectName("TransactionDialog");
        TransactionDialog.resize(new QSize(570, 485).expandedTo(TransactionDialog.minimumSizeHint()));
        gridLayout_2 = new QGridLayout(TransactionDialog);
        gridLayout_2.setObjectName("gridLayout_2");
        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        subjectEdit = new QLineEdit(TransactionDialog);
        subjectEdit.setObjectName("subjectEdit");

        gridLayout.addWidget(subjectEdit, 1, 2, 1, 1);

        comboBoxAccount = new QComboBox(TransactionDialog);
        comboBoxAccount.setObjectName("comboBoxAccount");

        gridLayout.addWidget(comboBoxAccount, 3, 2, 1, 1);

        label_5 = new QLabel(TransactionDialog);
        label_5.setObjectName("label_5");

        gridLayout.addWidget(label_5, 4, 1, 1, 1);

        dateEdit = new QDateEdit(TransactionDialog);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setCalendarPopup(true);

        gridLayout.addWidget(dateEdit, 0, 2, 1, 1);

        label_3 = new QLabel(TransactionDialog);
        label_3.setObjectName("label_3");

        gridLayout.addWidget(label_3, 2, 1, 1, 1);

        label_2 = new QLabel(TransactionDialog);
        label_2.setObjectName("label_2");

        gridLayout.addWidget(label_2, 1, 1, 1, 1);

        label_4 = new QLabel(TransactionDialog);
        label_4.setObjectName("label_4");

        gridLayout.addWidget(label_4, 3, 1, 1, 1);

        pushButtonAddAccount = new QPushButton(TransactionDialog);
        pushButtonAddAccount.setObjectName("pushButtonAddAccount");

        gridLayout.addWidget(pushButtonAddAccount, 3, 3, 1, 1);

        checkBoxIncome = new QCheckBox(TransactionDialog);
        checkBoxIncome.setObjectName("checkBoxIncome");

        gridLayout.addWidget(checkBoxIncome, 4, 3, 1, 1);

        comboBoxCategory = new QComboBox(TransactionDialog);
        comboBoxCategory.setObjectName("comboBoxCategory");

        gridLayout.addWidget(comboBoxCategory, 2, 2, 1, 1);

        pushButtonAddCategory = new QPushButton(TransactionDialog);
        pushButtonAddCategory.setObjectName("pushButtonAddCategory");

        gridLayout.addWidget(pushButtonAddCategory, 2, 3, 1, 1);

        label = new QLabel(TransactionDialog);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 1, 1, 1);

        doubleSpinBoxAmount = new QDoubleSpinBox(TransactionDialog);
        doubleSpinBoxAmount.setObjectName("doubleSpinBoxAmount");
        doubleSpinBoxAmount.setMinimum(-1e+09);
        doubleSpinBoxAmount.setMaximum(1e+09);

        gridLayout.addWidget(doubleSpinBoxAmount, 4, 2, 1, 1);


        gridLayout_2.addLayout(gridLayout, 2, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_2.addItem(horizontalSpacer, 2, 2, 1, 1);

        pushButtonAdd = new QPushButton(TransactionDialog);
        pushButtonAdd.setObjectName("pushButtonAdd");

        gridLayout_2.addWidget(pushButtonAdd, 3, 0, 1, 1);

        pushButtonOK = new QPushButton(TransactionDialog);
        pushButtonOK.setObjectName("pushButtonOK");

        gridLayout_2.addWidget(pushButtonOK, 3, 2, 1, 1);

        tableTransactions = new QTableWidget(TransactionDialog);
        tableTransactions.setObjectName("tableTransactions");
        tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);

        gridLayout_2.addWidget(tableTransactions, 1, 0, 1, 3);

        pushButtonDelete = new QPushButton(TransactionDialog);
        pushButtonDelete.setObjectName("pushButtonDelete");

        gridLayout_2.addWidget(pushButtonDelete, 0, 0, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_2.addItem(horizontalSpacer_2, 3, 1, 1, 1);

        horizontalSpacer_3 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_2.addItem(horizontalSpacer_3, 0, 1, 1, 2);

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
        pushButtonOK.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "OK", null));
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

