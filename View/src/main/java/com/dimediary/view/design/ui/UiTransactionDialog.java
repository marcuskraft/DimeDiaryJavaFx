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
    public QDialogButtonBox buttonBox;
    public QLabel label;
    public QLabel label_2;
    public QLabel label_3;
    public QLabel label_4;
    public QDateEdit dateEdit;
    public QLineEdit lineEdit;
    public QComboBox comboBox;
    public QComboBox comboBox_2;
    public QSpinBox spinBox;
    public QLabel label_5;

    public UiTransactionDialog() { super(); }

    public void setupUi(QDialog TransactionDialog)
    {
        TransactionDialog.setObjectName("TransactionDialog");
        TransactionDialog.resize(new QSize(321, 211).expandedTo(TransactionDialog.minimumSizeHint()));
        buttonBox = new QDialogButtonBox(TransactionDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(-40, 170, 341, 32));
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));
        label = new QLabel(TransactionDialog);
        label.setObjectName("label");
        label.setGeometry(new QRect(10, 10, 46, 13));
        label_2 = new QLabel(TransactionDialog);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(10, 40, 46, 13));
        label_3 = new QLabel(TransactionDialog);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(10, 70, 46, 13));
        label_4 = new QLabel(TransactionDialog);
        label_4.setObjectName("label_4");
        label_4.setGeometry(new QRect(10, 100, 46, 13));
        dateEdit = new QDateEdit(TransactionDialog);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setGeometry(new QRect(60, 10, 110, 22));
        lineEdit = new QLineEdit(TransactionDialog);
        lineEdit.setObjectName("lineEdit");
        lineEdit.setGeometry(new QRect(60, 40, 111, 20));
        comboBox = new QComboBox(TransactionDialog);
        comboBox.setObjectName("comboBox");
        comboBox.setGeometry(new QRect(60, 70, 111, 22));
        comboBox_2 = new QComboBox(TransactionDialog);
        comboBox_2.setObjectName("comboBox_2");
        comboBox_2.setGeometry(new QRect(60, 100, 111, 22));
        spinBox = new QSpinBox(TransactionDialog);
        spinBox.setObjectName("spinBox");
        spinBox.setGeometry(new QRect(60, 130, 111, 22));
        label_5 = new QLabel(TransactionDialog);
        label_5.setObjectName("label_5");
        label_5.setGeometry(new QRect(10, 130, 46, 13));
        retranslateUi(TransactionDialog);
        buttonBox.accepted.connect(TransactionDialog, "accept()");
        buttonBox.rejected.connect(TransactionDialog, "reject()");

        TransactionDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog TransactionDialog)
    {
        TransactionDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion erstellen / bearbeiten", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
    } // retranslateUi

}

