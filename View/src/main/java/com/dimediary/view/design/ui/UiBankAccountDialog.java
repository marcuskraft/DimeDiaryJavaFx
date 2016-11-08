/********************************************************************************
 ** Form generated from reading ui file 'bankaccountdialog.jui'
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

public class UiBankAccountDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout;
    public QLabel label;
    public QComboBox comboBoxAccountCategory;
    public QLabel label_2;
    public QLabel label_6;
    public QLabel label_5;
    public QLabel label_4;
    public QLineEdit lineEditIBAN;
    public QLineEdit lineEditBankName;
    public QLineEdit lineEditAccountName;
    public QLineEdit lineEditBIC;
    public QLabel label_3;
    public QPushButton pushButtonAddAccountCategory;
    public QDoubleSpinBox doubleSpinBoxStartBudget;
    public QDateEdit dateEditStartBudget;
    public QPushButton pushButtonAdd;
    public QPushButton pushButtonDelete;
    public QListWidget listWidget;

    public UiBankAccountDialog() { super(); }

    public void setupUi(QDialog BankAccountDialog)
    {
        BankAccountDialog.setObjectName("BankAccountDialog");
        BankAccountDialog.resize(new QSize(403, 272).expandedTo(BankAccountDialog.minimumSizeHint()));
        buttonBox = new QDialogButtonBox(BankAccountDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(220, 240, 171, 32));
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));
        gridLayoutWidget = new QWidget(BankAccountDialog);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(10, 0, 256, 231));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(gridLayoutWidget);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        comboBoxAccountCategory = new QComboBox(gridLayoutWidget);
        comboBoxAccountCategory.setObjectName("comboBoxAccountCategory");

        gridLayout.addWidget(comboBoxAccountCategory, 0, 1, 1, 1);

        label_2 = new QLabel(gridLayoutWidget);
        label_2.setObjectName("label_2");

        gridLayout.addWidget(label_2, 2, 0, 1, 1);

        label_6 = new QLabel(gridLayoutWidget);
        label_6.setObjectName("label_6");

        gridLayout.addWidget(label_6, 5, 0, 1, 1);

        label_5 = new QLabel(gridLayoutWidget);
        label_5.setObjectName("label_5");

        gridLayout.addWidget(label_5, 4, 0, 1, 1);

        label_4 = new QLabel(gridLayoutWidget);
        label_4.setObjectName("label_4");

        gridLayout.addWidget(label_4, 3, 0, 1, 1);

        lineEditIBAN = new QLineEdit(gridLayoutWidget);
        lineEditIBAN.setObjectName("lineEditIBAN");

        gridLayout.addWidget(lineEditIBAN, 3, 1, 1, 1);

        lineEditBankName = new QLineEdit(gridLayoutWidget);
        lineEditBankName.setObjectName("lineEditBankName");

        gridLayout.addWidget(lineEditBankName, 2, 1, 1, 1);

        lineEditAccountName = new QLineEdit(gridLayoutWidget);
        lineEditAccountName.setObjectName("lineEditAccountName");

        gridLayout.addWidget(lineEditAccountName, 1, 1, 1, 1);

        lineEditBIC = new QLineEdit(gridLayoutWidget);
        lineEditBIC.setObjectName("lineEditBIC");

        gridLayout.addWidget(lineEditBIC, 4, 1, 1, 1);

        label_3 = new QLabel(gridLayoutWidget);
        label_3.setObjectName("label_3");

        gridLayout.addWidget(label_3, 1, 0, 1, 1);

        pushButtonAddAccountCategory = new QPushButton(gridLayoutWidget);
        pushButtonAddAccountCategory.setObjectName("pushButtonAddAccountCategory");

        gridLayout.addWidget(pushButtonAddAccountCategory, 0, 2, 1, 1);

        doubleSpinBoxStartBudget = new QDoubleSpinBox(gridLayoutWidget);
        doubleSpinBoxStartBudget.setObjectName("doubleSpinBoxStartBudget");
        doubleSpinBoxStartBudget.setMinimum(-1e+09);
        doubleSpinBoxStartBudget.setMaximum(1e+09);

        gridLayout.addWidget(doubleSpinBoxStartBudget, 5, 2, 1, 1);

        dateEditStartBudget = new QDateEdit(gridLayoutWidget);
        dateEditStartBudget.setObjectName("dateEditStartBudget");

        gridLayout.addWidget(dateEditStartBudget, 5, 1, 1, 1);

        pushButtonAdd = new QPushButton(BankAccountDialog);
        pushButtonAdd.setObjectName("pushButtonAdd");
        pushButtonAdd.setGeometry(new QRect(10, 240, 75, 23));
        pushButtonDelete = new QPushButton(BankAccountDialog);
        pushButtonDelete.setObjectName("pushButtonDelete");
        pushButtonDelete.setGeometry(new QRect(300, 0, 75, 23));
        listWidget = new QListWidget(BankAccountDialog);
        listWidget.setObjectName("listWidget");
        listWidget.setGeometry(new QRect(280, 30, 111, 201));
        QWidget.setTabOrder(comboBoxAccountCategory, lineEditAccountName);
        QWidget.setTabOrder(lineEditAccountName, lineEditBankName);
        QWidget.setTabOrder(lineEditBankName, lineEditIBAN);
        QWidget.setTabOrder(lineEditIBAN, lineEditBIC);
        QWidget.setTabOrder(lineEditBIC, pushButtonAdd);
        QWidget.setTabOrder(pushButtonAdd, pushButtonAddAccountCategory);
        QWidget.setTabOrder(pushButtonAddAccountCategory, buttonBox);
        QWidget.setTabOrder(buttonBox, pushButtonDelete);
        QWidget.setTabOrder(pushButtonDelete, listWidget);
        retranslateUi(BankAccountDialog);
        buttonBox.accepted.connect(BankAccountDialog, "accept()");
        buttonBox.rejected.connect(BankAccountDialog, "reject()");

        BankAccountDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog BankAccountDialog)
    {
        BankAccountDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Konto erstellen", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Kontoart*", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Bankname", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Startbudget*", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "BIC", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "IBAN", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Kontoname*", null));
        pushButtonAddAccountCategory.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "erstellen", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Hinzuf\u00fcgen", null));
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "L\u00f6schen", null));
    } // retranslateUi

}

