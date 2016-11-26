/********************************************************************************
 ** Form generated from reading ui file 'transactiondialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.core.Qt.Orientation;
import com.trolltech.qt.gui.QFrame;
import com.trolltech.qt.gui.QLayout.SizeConstraint;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiTransactionDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QGridLayout gridLayout;
    public QGridLayout gridLayoutMain;
    public QWidget widgetOK;
    public QGridLayout gridLayout_3;
    public QPushButton pushButtonDelete;
    public QPushButton pushButtonAdd;
    public QPushButton pushButtonOK;
    public QSpacerItem verticalSpacer;
    public QSpacerItem horizontalSpacer;
    public QPushButton pushButtonModify;
    public QGroupBox groupBoxTransaction;
    public QGridLayout gridLayout_5;
    public QWidget widgetTransactionData;
    public QGridLayout gridLayout_7;
    public QGridLayout gridLayout_2;
    public QLineEdit subjectEdit;
    public QLabel label;
    public QPushButton pushButtonAddAccount;
    public QLabel label_3;
    public QComboBox comboBoxAccount;
    public QLabel label_5;
    public QDoubleSpinBox doubleSpinBoxAmount;
    public QLabel label_4;
    public QDateEdit dateEdit;
    public QCheckBox checkBoxIncome;
    public QComboBox comboBoxCategory;
    public QPushButton pushButtonAddCategory;
    public QLabel label_2;
    public QCheckBox checkBoxNoCategory;
    public QCheckBox checkBoxNoAccount;
    public QSpacerItem horizontalSpacer_3;
    public QFrame frameIterateButton;
    public QGridLayout gridLayout_4;
    public QSpacerItem horizontalSpacer_2;
    public QCheckBox checkBoxIterate;
    public QWidget widget;

    public UiTransactionDialog() { super(); }

    public void setupUi(QDialog TransactionDialog)
    {
        TransactionDialog.setObjectName("TransactionDialog");
        TransactionDialog.resize(new QSize(398, 308).expandedTo(TransactionDialog.minimumSizeHint()));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(TransactionDialog.sizePolicy().hasHeightForWidth());
        TransactionDialog.setSizePolicy(sizePolicy);
        TransactionDialog.setModal(true);
        gridLayout = new QGridLayout(TransactionDialog);
        gridLayout.setObjectName("gridLayout");
        gridLayout.setSizeConstraint(SizeConstraint.SetMinimumSize);
        gridLayoutMain = new QGridLayout();
        gridLayoutMain.setObjectName("gridLayoutMain");
        gridLayoutMain.setSizeConstraint(SizeConstraint.SetDefaultConstraint);
        widgetOK = new QWidget(TransactionDialog);
        widgetOK.setObjectName("widgetOK");
        gridLayout_3 = new QGridLayout(widgetOK);
        gridLayout_3.setObjectName("gridLayout_3");
        pushButtonDelete = new QPushButton(widgetOK);
        pushButtonDelete.setObjectName("pushButtonDelete");

        gridLayout_3.addWidget(pushButtonDelete, 1, 2, 1, 1);

        pushButtonAdd = new QPushButton(widgetOK);
        pushButtonAdd.setObjectName("pushButtonAdd");

        gridLayout_3.addWidget(pushButtonAdd, 1, 1, 1, 1);

        pushButtonOK = new QPushButton(widgetOK);
        pushButtonOK.setObjectName("pushButtonOK");

        gridLayout_3.addWidget(pushButtonOK, 1, 4, 1, 1);

        verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

        gridLayout_3.addItem(verticalSpacer, 0, 4, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_3.addItem(horizontalSpacer, 1, 0, 1, 1);

        pushButtonModify = new QPushButton(widgetOK);
        pushButtonModify.setObjectName("pushButtonModify");

        gridLayout_3.addWidget(pushButtonModify, 1, 3, 1, 1);


        gridLayoutMain.addWidget(widgetOK, 2, 0, 1, 1);

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
        subjectEdit = new QLineEdit(widgetTransactionData);
        subjectEdit.setObjectName("subjectEdit");

        gridLayout_2.addWidget(subjectEdit, 1, 1, 1, 1);

        label = new QLabel(widgetTransactionData);
        label.setObjectName("label");

        gridLayout_2.addWidget(label, 0, 0, 1, 1);

        pushButtonAddAccount = new QPushButton(widgetTransactionData);
        pushButtonAddAccount.setObjectName("pushButtonAddAccount");

        gridLayout_2.addWidget(pushButtonAddAccount, 3, 3, 1, 1);

        label_3 = new QLabel(widgetTransactionData);
        label_3.setObjectName("label_3");

        gridLayout_2.addWidget(label_3, 2, 0, 1, 1);

        comboBoxAccount = new QComboBox(widgetTransactionData);
        comboBoxAccount.setObjectName("comboBoxAccount");

        gridLayout_2.addWidget(comboBoxAccount, 3, 1, 1, 1);

        label_5 = new QLabel(widgetTransactionData);
        label_5.setObjectName("label_5");

        gridLayout_2.addWidget(label_5, 4, 0, 1, 1);

        doubleSpinBoxAmount = new QDoubleSpinBox(widgetTransactionData);
        doubleSpinBoxAmount.setObjectName("doubleSpinBoxAmount");
        doubleSpinBoxAmount.setMinimum(-1e+09);
        doubleSpinBoxAmount.setMaximum(1e+09);

        gridLayout_2.addWidget(doubleSpinBoxAmount, 4, 1, 1, 1);

        label_4 = new QLabel(widgetTransactionData);
        label_4.setObjectName("label_4");

        gridLayout_2.addWidget(label_4, 3, 0, 1, 1);

        dateEdit = new QDateEdit(widgetTransactionData);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setCalendarPopup(true);

        gridLayout_2.addWidget(dateEdit, 0, 1, 1, 1);

        checkBoxIncome = new QCheckBox(widgetTransactionData);
        checkBoxIncome.setObjectName("checkBoxIncome");

        gridLayout_2.addWidget(checkBoxIncome, 4, 3, 1, 1);

        comboBoxCategory = new QComboBox(widgetTransactionData);
        comboBoxCategory.setObjectName("comboBoxCategory");

        gridLayout_2.addWidget(comboBoxCategory, 2, 1, 1, 1);

        pushButtonAddCategory = new QPushButton(widgetTransactionData);
        pushButtonAddCategory.setObjectName("pushButtonAddCategory");

        gridLayout_2.addWidget(pushButtonAddCategory, 2, 3, 1, 1);

        label_2 = new QLabel(widgetTransactionData);
        label_2.setObjectName("label_2");

        gridLayout_2.addWidget(label_2, 1, 0, 1, 1);

        checkBoxNoCategory = new QCheckBox(widgetTransactionData);
        checkBoxNoCategory.setObjectName("checkBoxNoCategory");

        gridLayout_2.addWidget(checkBoxNoCategory, 2, 2, 1, 1);

        checkBoxNoAccount = new QCheckBox(widgetTransactionData);
        checkBoxNoAccount.setObjectName("checkBoxNoAccount");

        gridLayout_2.addWidget(checkBoxNoAccount, 3, 2, 1, 1);


        gridLayout_7.addLayout(gridLayout_2, 0, 0, 1, 1);

        horizontalSpacer_3 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_7.addItem(horizontalSpacer_3, 0, 1, 1, 1);


        gridLayout_5.addWidget(widgetTransactionData, 0, 0, 1, 1);

        frameIterateButton = new QFrame(groupBoxTransaction);
        frameIterateButton.setObjectName("frameIterateButton");
        frameIterateButton.setFrameShape(QFrame.Shape.StyledPanel);
        frameIterateButton.setFrameShadow(QFrame.Shadow.Raised);
        gridLayout_4 = new QGridLayout(frameIterateButton);
        gridLayout_4.setObjectName("gridLayout_4");
        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_4.addItem(horizontalSpacer_2, 0, 1, 1, 1);

        checkBoxIterate = new QCheckBox(frameIterateButton);
        checkBoxIterate.setObjectName("checkBoxIterate");

        gridLayout_4.addWidget(checkBoxIterate, 0, 0, 1, 1);


        gridLayout_5.addWidget(frameIterateButton, 1, 0, 1, 1);


        gridLayoutMain.addWidget(groupBoxTransaction, 0, 0, 1, 1);

        widget = new QWidget(TransactionDialog);
        widget.setObjectName("widget");

        gridLayoutMain.addWidget(widget, 1, 0, 1, 1);


        gridLayout.addLayout(gridLayoutMain, 0, 0, 1, 1);

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
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "L\u00f6schen", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Hinzuf\u00fcgen", null));
        pushButtonOK.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Abbrechen", null));
        pushButtonModify.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "\u00c4ndern", null));
        groupBoxTransaction.setTitle(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
        pushButtonAddAccount.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
        checkBoxIncome.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Einnahme", null));
        pushButtonAddCategory.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
        checkBoxNoCategory.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "keine", null));
        checkBoxNoAccount.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "keins", null));
        checkBoxIterate.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Wiederholen", null));
    } // retranslateUi

}

