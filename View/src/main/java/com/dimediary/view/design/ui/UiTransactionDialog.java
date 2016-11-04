/********************************************************************************
 ** Form generated from reading ui file 'transactiondialog.jui'
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

public class UiTransactionDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout;
    public QDoubleSpinBox doubleSpinBoxAmount;
    public QLabel label_3;
    public QDateEdit dateEdit;
    public QLabel label_2;
    public QLabel label;
    public QLineEdit subjectEdit;
    public QComboBox comboBoxAccount;
    public QLabel label_4;
    public QLabel label_5;
    public QComboBox comboBoxCategory;
    public QCheckBox checkBoxIncome;
    public QDialogButtonBox buttonBox;

    public UiTransactionDialog() { super(); }

    public void setupUi(QDialog TransactionDialog)
    {
        TransactionDialog.setObjectName("TransactionDialog");
        TransactionDialog.resize(new QSize(324, 243).expandedTo(TransactionDialog.minimumSizeHint()));
        gridLayoutWidget = new QWidget(TransactionDialog);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(10, 0, 271, 191));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout.setObjectName("gridLayout");
        doubleSpinBoxAmount = new QDoubleSpinBox(gridLayoutWidget);
        doubleSpinBoxAmount.setObjectName("doubleSpinBoxAmount");
        doubleSpinBoxAmount.setMinimum(-1e+09);
        doubleSpinBoxAmount.setMaximum(1e+09);

        gridLayout.addWidget(doubleSpinBoxAmount, 4, 2, 1, 1);

        label_3 = new QLabel(gridLayoutWidget);
        label_3.setObjectName("label_3");

        gridLayout.addWidget(label_3, 2, 1, 1, 1);

        dateEdit = new QDateEdit(gridLayoutWidget);
        dateEdit.setObjectName("dateEdit");

        gridLayout.addWidget(dateEdit, 0, 2, 1, 1);

        label_2 = new QLabel(gridLayoutWidget);
        label_2.setObjectName("label_2");

        gridLayout.addWidget(label_2, 1, 1, 1, 1);

        label = new QLabel(gridLayoutWidget);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 1, 1, 1);

        subjectEdit = new QLineEdit(gridLayoutWidget);
        subjectEdit.setObjectName("subjectEdit");

        gridLayout.addWidget(subjectEdit, 1, 2, 1, 1);

        comboBoxAccount = new QComboBox(gridLayoutWidget);
        comboBoxAccount.setObjectName("comboBoxAccount");

        gridLayout.addWidget(comboBoxAccount, 3, 2, 1, 1);

        label_4 = new QLabel(gridLayoutWidget);
        label_4.setObjectName("label_4");

        gridLayout.addWidget(label_4, 3, 1, 1, 1);

        label_5 = new QLabel(gridLayoutWidget);
        label_5.setObjectName("label_5");

        gridLayout.addWidget(label_5, 4, 1, 1, 1);

        comboBoxCategory = new QComboBox(gridLayoutWidget);
        comboBoxCategory.setObjectName("comboBoxCategory");

        gridLayout.addWidget(comboBoxCategory, 2, 2, 1, 1);

        checkBoxIncome = new QCheckBox(gridLayoutWidget);
        checkBoxIncome.setObjectName("checkBoxIncome");

        gridLayout.addWidget(checkBoxIncome, 4, 3, 1, 1);

        buttonBox = new QDialogButtonBox(TransactionDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(80, 210, 233, 23));
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));
        retranslateUi(TransactionDialog);
        buttonBox.accepted.connect(TransactionDialog, "accept()");
        buttonBox.rejected.connect(TransactionDialog, "reject()");

        TransactionDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog TransactionDialog)
    {
        TransactionDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion erstellen", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
        checkBoxIncome.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Einnahme", null));
    } // retranslateUi

}

