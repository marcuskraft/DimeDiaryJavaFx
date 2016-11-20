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
import com.trolltech.qt.gui.QFrame;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiTransactionDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout_8;
    public QGridLayout gridLayoutMain;
    public QWidget widgetOverview;
    public QGridLayout gridLayout_3;
    public QPushButton pushButtonDelete;
    public QSpacerItem horizontalSpacer_3;
    public QTableWidget tableTransactions;
    public QGroupBox groupBoxTransaction;
    public QGridLayout gridLayout_5;
    public QWidget widgetTransactionData;
    public QGridLayout gridLayout_7;
    public QGridLayout gridLayout_2;
    public QLabel label_5;
    public QLabel label_4;
    public QPushButton pushButtonAddAccount;
    public QLabel label_3;
    public QDateEdit dateEdit;
    public QDoubleSpinBox doubleSpinBoxAmount;
    public QLabel label_2;
    public QComboBox comboBoxAccount;
    public QLabel label;
    public QLineEdit subjectEdit;
    public QCheckBox checkBoxIncome;
    public QComboBox comboBoxCategory;
    public QPushButton pushButtonAddCategory;
    public QFrame frameIterateButton;
    public QGridLayout gridLayout_6;
    public QSpacerItem horizontalSpacer_4;
    public QCheckBox checkBoxIterate;
    public QSpacerItem horizontalSpacer_2;
    public QHBoxLayout horizontalLayout;
    public QPushButton pushButtonAdd;
    public QPushButton pushButtonModify;
    public QWidget widget_4;
    public QGridLayout gridLayout;
    public QPushButton pushButtonOK;
    public QSpacerItem horizontalSpacer;

    public UiTransactionDialog() { super(); }

    public void setupUi(QDialog TransactionDialog)
    {
        TransactionDialog.setObjectName("TransactionDialog");
        TransactionDialog.resize(new QSize(564, 503).expandedTo(TransactionDialog.minimumSizeHint()));
        gridLayout_8 = new QGridLayout(TransactionDialog);
        gridLayout_8.setObjectName("gridLayout_8");
        gridLayoutMain = new QGridLayout();
        gridLayoutMain.setObjectName("gridLayoutMain");
        widgetOverview = new QWidget(TransactionDialog);
        widgetOverview.setObjectName("widgetOverview");
        gridLayout_3 = new QGridLayout(widgetOverview);
        gridLayout_3.setObjectName("gridLayout_3");
        pushButtonDelete = new QPushButton(widgetOverview);
        pushButtonDelete.setObjectName("pushButtonDelete");

        gridLayout_3.addWidget(pushButtonDelete, 0, 0, 1, 1);

        horizontalSpacer_3 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_3.addItem(horizontalSpacer_3, 0, 1, 1, 1);

        tableTransactions = new QTableWidget(widgetOverview);
        tableTransactions.setObjectName("tableTransactions");
        tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);

        gridLayout_3.addWidget(tableTransactions, 1, 0, 2, 2);


        gridLayoutMain.addWidget(widgetOverview, 0, 0, 1, 1);

        groupBoxTransaction = new QGroupBox(TransactionDialog);
        groupBoxTransaction.setObjectName("groupBoxTransaction");
        gridLayout_5 = new QGridLayout(groupBoxTransaction);
        gridLayout_5.setObjectName("gridLayout_5");
        widgetTransactionData = new QWidget(groupBoxTransaction);
        widgetTransactionData.setObjectName("widgetTransactionData");
        gridLayout_7 = new QGridLayout(widgetTransactionData);
        gridLayout_7.setObjectName("gridLayout_7");
        gridLayout_2 = new QGridLayout();
        gridLayout_2.setObjectName("gridLayout_2");
        label_5 = new QLabel(widgetTransactionData);
        label_5.setObjectName("label_5");

        gridLayout_2.addWidget(label_5, 4, 0, 1, 1);

        label_4 = new QLabel(widgetTransactionData);
        label_4.setObjectName("label_4");

        gridLayout_2.addWidget(label_4, 3, 0, 1, 1);

        pushButtonAddAccount = new QPushButton(widgetTransactionData);
        pushButtonAddAccount.setObjectName("pushButtonAddAccount");

        gridLayout_2.addWidget(pushButtonAddAccount, 3, 2, 1, 1);

        label_3 = new QLabel(widgetTransactionData);
        label_3.setObjectName("label_3");

        gridLayout_2.addWidget(label_3, 2, 0, 1, 1);

        dateEdit = new QDateEdit(widgetTransactionData);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setCalendarPopup(true);

        gridLayout_2.addWidget(dateEdit, 0, 1, 1, 1);

        doubleSpinBoxAmount = new QDoubleSpinBox(widgetTransactionData);
        doubleSpinBoxAmount.setObjectName("doubleSpinBoxAmount");
        doubleSpinBoxAmount.setMinimum(-1e+09);
        doubleSpinBoxAmount.setMaximum(1e+09);

        gridLayout_2.addWidget(doubleSpinBoxAmount, 4, 1, 1, 1);

        label_2 = new QLabel(widgetTransactionData);
        label_2.setObjectName("label_2");

        gridLayout_2.addWidget(label_2, 1, 0, 1, 1);

        comboBoxAccount = new QComboBox(widgetTransactionData);
        comboBoxAccount.setObjectName("comboBoxAccount");

        gridLayout_2.addWidget(comboBoxAccount, 3, 1, 1, 1);

        label = new QLabel(widgetTransactionData);
        label.setObjectName("label");

        gridLayout_2.addWidget(label, 0, 0, 1, 1);

        subjectEdit = new QLineEdit(widgetTransactionData);
        subjectEdit.setObjectName("subjectEdit");

        gridLayout_2.addWidget(subjectEdit, 1, 1, 1, 1);

        checkBoxIncome = new QCheckBox(widgetTransactionData);
        checkBoxIncome.setObjectName("checkBoxIncome");

        gridLayout_2.addWidget(checkBoxIncome, 4, 2, 1, 1);

        comboBoxCategory = new QComboBox(widgetTransactionData);
        comboBoxCategory.setObjectName("comboBoxCategory");

        gridLayout_2.addWidget(comboBoxCategory, 2, 1, 1, 1);

        pushButtonAddCategory = new QPushButton(widgetTransactionData);
        pushButtonAddCategory.setObjectName("pushButtonAddCategory");

        gridLayout_2.addWidget(pushButtonAddCategory, 2, 2, 1, 1);


        gridLayout_7.addLayout(gridLayout_2, 0, 0, 1, 1);


        gridLayout_5.addWidget(widgetTransactionData, 0, 0, 1, 1);

        frameIterateButton = new QFrame(groupBoxTransaction);
        frameIterateButton.setObjectName("frameIterateButton");
        frameIterateButton.setFrameShape(QFrame.Shape.StyledPanel);
        frameIterateButton.setFrameShadow(QFrame.Shadow.Raised);
        gridLayout_6 = new QGridLayout(frameIterateButton);
        gridLayout_6.setObjectName("gridLayout_6");
        horizontalSpacer_4 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_6.addItem(horizontalSpacer_4, 0, 1, 1, 1);

        checkBoxIterate = new QCheckBox(frameIterateButton);
        checkBoxIterate.setObjectName("checkBoxIterate");

        gridLayout_6.addWidget(checkBoxIterate, 0, 0, 1, 1);


        gridLayout_5.addWidget(frameIterateButton, 1, 0, 1, 1);

        horizontalSpacer_2 = new QSpacerItem(349, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_5.addItem(horizontalSpacer_2, 1, 2, 1, 1);

        horizontalLayout = new QHBoxLayout();
        horizontalLayout.setObjectName("horizontalLayout");
        pushButtonAdd = new QPushButton(groupBoxTransaction);
        pushButtonAdd.setObjectName("pushButtonAdd");

        horizontalLayout.addWidget(pushButtonAdd);

        pushButtonModify = new QPushButton(groupBoxTransaction);
        pushButtonModify.setObjectName("pushButtonModify");

        horizontalLayout.addWidget(pushButtonModify);


        gridLayout_5.addLayout(horizontalLayout, 1, 1, 1, 1);


        gridLayoutMain.addWidget(groupBoxTransaction, 1, 0, 1, 1);


        gridLayout_8.addLayout(gridLayoutMain, 0, 0, 1, 1);

        widget_4 = new QWidget(TransactionDialog);
        widget_4.setObjectName("widget_4");
        gridLayout = new QGridLayout(widget_4);
        gridLayout.setObjectName("gridLayout");
        pushButtonOK = new QPushButton(widget_4);
        pushButtonOK.setObjectName("pushButtonOK");

        gridLayout.addWidget(pushButtonOK, 0, 1, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout.addItem(horizontalSpacer, 0, 0, 1, 1);


        gridLayout_8.addWidget(widget_4, 1, 0, 1, 1);

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
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Markierte Transaktionen L\u00f6schen", null));
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
        groupBoxTransaction.setTitle(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
        pushButtonAddAccount.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
        checkBoxIncome.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Einnahme", null));
        pushButtonAddCategory.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
        checkBoxIterate.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Wiederholen", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Hinzuf\u00fcgen", null));
        pushButtonModify.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "\u00c4ndern", null));
        pushButtonOK.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "OK", null));
    } // retranslateUi

}

