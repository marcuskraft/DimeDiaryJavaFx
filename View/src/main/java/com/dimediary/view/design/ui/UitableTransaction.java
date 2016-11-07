/********************************************************************************
 ** Form generated from reading ui file 'tableTransaction.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UitableTransaction implements com.trolltech.qt.QUiForm<QWidget>
{
    public QTableWidget tableTransactions;

    public UitableTransaction() { super(); }

    public void setupUi(QWidget tableTransaction)
    {
        tableTransaction.setObjectName("tableTransaction");
        tableTransaction.resize(new QSize(548, 215).expandedTo(tableTransaction.minimumSizeHint()));
        tableTransactions = new QTableWidget(tableTransaction);
        tableTransactions.setObjectName("tableTransactions");
        tableTransactions.setGeometry(new QRect(10, 10, 521, 192));
        tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);
        retranslateUi(tableTransaction);

        tableTransaction.connectSlotsByName();
    } // setupUi

    void retranslateUi(QWidget tableTransaction)
    {
        tableTransaction.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("tableTransaction", "Form", null));
        tableTransactions.clear();
        tableTransactions.setColumnCount(5);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("tableTransaction", "Datum", null));
        tableTransactions.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("tableTransaction", "Betreff", null));
        tableTransactions.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("tableTransaction", "Kategorie", null));
        tableTransactions.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("tableTransaction", "Konto", null));
        tableTransactions.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("tableTransaction", "Betrag", null));
        tableTransactions.setHorizontalHeaderItem(4, __colItem4);
        tableTransactions.setRowCount(0);
    } // retranslateUi

}

