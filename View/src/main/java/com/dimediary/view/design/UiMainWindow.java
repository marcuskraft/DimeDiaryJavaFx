/********************************************************************************
 ** Form generated from reading ui file 'design.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design;

import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiMainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionTest;
    public QWidget centralwidget;
    public QTableWidget tableWidget;
    public QTextEdit textEdit;
    public QDateEdit dateEdit;
    public QDateTimeEdit dateTimeEdit;
    public QMenuBar menubar;
    public QMenu menuDatei;
    public QStatusBar statusbar;

    public UiMainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(1070, 846).expandedTo(MainWindow.minimumSizeHint()));
        actionTest = new QAction(MainWindow);
        actionTest.setObjectName("actionTest");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        tableWidget = new QTableWidget(centralwidget);
        tableWidget.setObjectName("tableWidget");
        tableWidget.setGeometry(new QRect(380, 20, 481, 251));
        textEdit = new QTextEdit(centralwidget);
        textEdit.setObjectName("textEdit");
        textEdit.setGeometry(new QRect(710, 280, 151, 41));
        dateEdit = new QDateEdit(centralwidget);
        dateEdit.setObjectName("dateEdit");
        dateEdit.setGeometry(new QRect(400, 300, 110, 22));
        dateTimeEdit = new QDateTimeEdit(centralwidget);
        dateTimeEdit.setObjectName("dateTimeEdit");
        dateTimeEdit.setGeometry(new QRect(440, 340, 194, 22));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 1070, 21));
        menuDatei = new QMenu(menubar);
        menuDatei.setObjectName("menuDatei");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menubar.addAction(menuDatei.menuAction());
        menuDatei.addAction(actionTest);
        retranslateUi(MainWindow);

        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        actionTest.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Test", null));
        tableWidget.clear();
        tableWidget.setColumnCount(3);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidget.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidget.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Transaktion", null));
        tableWidget.setHorizontalHeaderItem(2, __colItem2);
        tableWidget.setRowCount(0);
        menuDatei.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datei", null));
    } // retranslateUi

}

