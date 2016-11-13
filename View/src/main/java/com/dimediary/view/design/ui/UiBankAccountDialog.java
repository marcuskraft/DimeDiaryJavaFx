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
    public QGridLayout gridLayout_2;
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
    public QPushButton pushButtonDelete;
    public QListWidget listWidget;
    public QPushButton pushButtonAdd;
    public QDialogButtonBox buttonBox;

    public UiBankAccountDialog() { super(); }

    public void setupUi(QDialog BankAccountDialog)
    {
        BankAccountDialog.setObjectName("BankAccountDialog");
        BankAccountDialog.resize(new QSize(372, 250).expandedTo(BankAccountDialog.minimumSizeHint()));
        gridLayout_2 = new QGridLayout(BankAccountDialog);
        gridLayout_2.setObjectName("gridLayout_2");
        gridLayout = new QGridLayout();
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(BankAccountDialog);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        comboBoxAccountCategory = new QComboBox(BankAccountDialog);
        comboBoxAccountCategory.setObjectName("comboBoxAccountCategory");

        gridLayout.addWidget(comboBoxAccountCategory, 0, 1, 1, 1);

        label_2 = new QLabel(BankAccountDialog);
        label_2.setObjectName("label_2");

        gridLayout.addWidget(label_2, 2, 0, 1, 1);

        label_6 = new QLabel(BankAccountDialog);
        label_6.setObjectName("label_6");

        gridLayout.addWidget(label_6, 5, 0, 1, 1);

        label_5 = new QLabel(BankAccountDialog);
        label_5.setObjectName("label_5");

        gridLayout.addWidget(label_5, 4, 0, 1, 1);

        label_4 = new QLabel(BankAccountDialog);
        label_4.setObjectName("label_4");

        gridLayout.addWidget(label_4, 3, 0, 1, 1);

        lineEditIBAN = new QLineEdit(BankAccountDialog);
        lineEditIBAN.setObjectName("lineEditIBAN");

        gridLayout.addWidget(lineEditIBAN, 3, 1, 1, 1);

        lineEditBankName = new QLineEdit(BankAccountDialog);
        lineEditBankName.setObjectName("lineEditBankName");

        gridLayout.addWidget(lineEditBankName, 2, 1, 1, 1);

        lineEditAccountName = new QLineEdit(BankAccountDialog);
        lineEditAccountName.setObjectName("lineEditAccountName");

        gridLayout.addWidget(lineEditAccountName, 1, 1, 1, 1);

        lineEditBIC = new QLineEdit(BankAccountDialog);
        lineEditBIC.setObjectName("lineEditBIC");

        gridLayout.addWidget(lineEditBIC, 4, 1, 1, 1);

        label_3 = new QLabel(BankAccountDialog);
        label_3.setObjectName("label_3");

        gridLayout.addWidget(label_3, 1, 0, 1, 1);

        pushButtonAddAccountCategory = new QPushButton(BankAccountDialog);
        pushButtonAddAccountCategory.setObjectName("pushButtonAddAccountCategory");

        gridLayout.addWidget(pushButtonAddAccountCategory, 0, 2, 1, 1);

        doubleSpinBoxStartBudget = new QDoubleSpinBox(BankAccountDialog);
        doubleSpinBoxStartBudget.setObjectName("doubleSpinBoxStartBudget");
        doubleSpinBoxStartBudget.setMinimum(-1e+09);
        doubleSpinBoxStartBudget.setMaximum(1e+09);

        gridLayout.addWidget(doubleSpinBoxStartBudget, 5, 2, 1, 1);

        dateEditStartBudget = new QDateEdit(BankAccountDialog);
        dateEditStartBudget.setObjectName("dateEditStartBudget");
        dateEditStartBudget.setCalendarPopup(true);

        gridLayout.addWidget(dateEditStartBudget, 5, 1, 1, 1);


        gridLayout_2.addLayout(gridLayout, 0, 0, 2, 2);

        pushButtonDelete = new QPushButton(BankAccountDialog);
        pushButtonDelete.setObjectName("pushButtonDelete");

        gridLayout_2.addWidget(pushButtonDelete, 0, 2, 1, 1);

        listWidget = new QListWidget(BankAccountDialog);
        listWidget.setObjectName("listWidget");

        gridLayout_2.addWidget(listWidget, 1, 2, 1, 1);

        pushButtonAdd = new QPushButton(BankAccountDialog);
        pushButtonAdd.setObjectName("pushButtonAdd");

        gridLayout_2.addWidget(pushButtonAdd, 2, 0, 1, 1);

        buttonBox = new QDialogButtonBox(BankAccountDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));

        gridLayout_2.addWidget(buttonBox, 2, 1, 1, 2);

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
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "L\u00f6schen", null));
        pushButtonAdd.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Hinzuf\u00fcgen", null));
    } // retranslateUi

}

