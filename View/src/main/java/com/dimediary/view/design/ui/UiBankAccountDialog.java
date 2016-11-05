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
import com.trolltech.qt.gui.QAbstractItemView.EditTrigger;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiBankAccountDialog implements com.trolltech.qt.QUiForm<QDialog>
{
    public QDialogButtonBox buttonBox;
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout;
    public QLabel label;
    public QComboBox comboBox;
    public QLabel label_2;
    public QLabel label_6;
    public QLabel label_5;
    public QLabel label_4;
    public QDoubleSpinBox doubleSpinBox;
    public QLineEdit lineEdit_3;
    public QLineEdit lineEdit_2;
    public QLineEdit lineEdit;
    public QLineEdit lineEdit_4;
    public QLabel label_3;
    public QPushButton pushButton;
    public QTableWidget tableWidget;
    public QPushButton pushButton_2;

    public UiBankAccountDialog() { super(); }

    public void setupUi(QDialog BankAccountDialog)
    {
        BankAccountDialog.setObjectName("BankAccountDialog");
        BankAccountDialog.resize(new QSize(684, 273).expandedTo(BankAccountDialog.minimumSizeHint()));
        buttonBox = new QDialogButtonBox(BankAccountDialog);
        buttonBox.setObjectName("buttonBox");
        buttonBox.setGeometry(new QRect(510, 240, 171, 32));
        buttonBox.setOrientation(Orientation.Horizontal);
        buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel,StandardButton.Ok));
        gridLayoutWidget = new QWidget(BankAccountDialog);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(10, 0, 251, 231));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout.setObjectName("gridLayout");
        label = new QLabel(gridLayoutWidget);
        label.setObjectName("label");

        gridLayout.addWidget(label, 0, 0, 1, 1);

        comboBox = new QComboBox(gridLayoutWidget);
        comboBox.setObjectName("comboBox");

        gridLayout.addWidget(comboBox, 0, 1, 1, 1);

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

        doubleSpinBox = new QDoubleSpinBox(gridLayoutWidget);
        doubleSpinBox.setObjectName("doubleSpinBox");

        gridLayout.addWidget(doubleSpinBox, 5, 1, 1, 1);

        lineEdit_3 = new QLineEdit(gridLayoutWidget);
        lineEdit_3.setObjectName("lineEdit_3");

        gridLayout.addWidget(lineEdit_3, 3, 1, 1, 1);

        lineEdit_2 = new QLineEdit(gridLayoutWidget);
        lineEdit_2.setObjectName("lineEdit_2");

        gridLayout.addWidget(lineEdit_2, 2, 1, 1, 1);

        lineEdit = new QLineEdit(gridLayoutWidget);
        lineEdit.setObjectName("lineEdit");

        gridLayout.addWidget(lineEdit, 1, 1, 1, 1);

        lineEdit_4 = new QLineEdit(gridLayoutWidget);
        lineEdit_4.setObjectName("lineEdit_4");

        gridLayout.addWidget(lineEdit_4, 4, 1, 1, 1);

        label_3 = new QLabel(gridLayoutWidget);
        label_3.setObjectName("label_3");

        gridLayout.addWidget(label_3, 1, 0, 1, 1);

        pushButton = new QPushButton(gridLayoutWidget);
        pushButton.setObjectName("pushButton");

        gridLayout.addWidget(pushButton, 0, 2, 1, 1);

        tableWidget = new QTableWidget(BankAccountDialog);
        tableWidget.setObjectName("tableWidget");
        tableWidget.setGeometry(new QRect(270, 10, 411, 221));
        tableWidget.setEditTriggers(EditTrigger.createQFlags(EditTrigger.AllEditTriggers));
        tableWidget.setAlternatingRowColors(true);
        tableWidget.setSortingEnabled(true);
        pushButton_2 = new QPushButton(BankAccountDialog);
        pushButton_2.setObjectName("pushButton_2");
        pushButton_2.setGeometry(new QRect(180, 240, 75, 23));
        retranslateUi(BankAccountDialog);
        buttonBox.accepted.connect(BankAccountDialog, "accept()");
        buttonBox.rejected.connect(BankAccountDialog, "reject()");

        BankAccountDialog.connectSlotsByName();
    } // setupUi

    void retranslateUi(QDialog BankAccountDialog)
    {
        BankAccountDialog.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Konto erstellen", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Kontoart", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Bankname", null));
        label_6.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Startbudget", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "BIC", null));
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "IBAN", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Kontoname", null));
        pushButton.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "neu erstellen", null));
        tableWidget.clear();
        tableWidget.setColumnCount(4);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Name", null));
        tableWidget.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Kontoart", null));
        tableWidget.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Bankname", null));
        tableWidget.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "IBAN", null));
        tableWidget.setHorizontalHeaderItem(3, __colItem3);
        tableWidget.setRowCount(0);
        pushButton_2.setText(com.trolltech.qt.core.QCoreApplication.translate("BankAccountDialog", "Hinzuf\u00fcgen", null));
    } // retranslateUi

}

