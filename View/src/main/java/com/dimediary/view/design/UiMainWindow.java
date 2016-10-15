/********************************************************************************
 ** Form generated from reading ui file 'mainwindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design;
import com.trolltech.qt.core.Qt.LayoutDirection;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiMainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionBeenden;
    public QAction actionEinstellungen;
    public QWidget centralwidget;
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout;
    public QTabWidget tabWidget;
    public QWidget tab;
    public QTableWidget tableWidget;
    public QWidget tab_2;
    public QMenuBar menubar;
    public QMenu menuDatei;
    public QStatusBar statusbar;

    public UiMainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(949, 800).expandedTo(MainWindow.minimumSizeHint()));
        actionBeenden = new QAction(MainWindow);
        actionBeenden.setObjectName("actionBeenden");
        actionEinstellungen = new QAction(MainWindow);
        actionEinstellungen.setObjectName("actionEinstellungen");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        gridLayoutWidget = new QWidget(centralwidget);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(0, 0, 2, 2));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout.setObjectName("gridLayout");
        tabWidget = new QTabWidget(centralwidget);
        tabWidget.setObjectName("tabWidget");
        tabWidget.setGeometry(new QRect(0, 0, 911, 741));
        tabWidget.setTabsClosable(false);
        tabWidget.setMovable(false);
        tab = new QWidget();
        tab.setObjectName("tab");
        tableWidget = new QTableWidget(tab);
        tableWidget.setObjectName("tableWidget");
        tableWidget.setGeometry(new QRect(0, 0, 901, 711));
        tableWidget.setLayoutDirection(LayoutDirection.LeftToRight);
        tableWidget.setRowCount(0);
        tableWidget.setColumnCount(4);
        tabWidget.addTab(tab, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tab 1", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        tabWidget.addTab(tab_2, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tab 2", null));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 949, 21));
        menuDatei = new QMenu(menubar);
        menuDatei.setObjectName("menuDatei");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menubar.addAction(menuDatei.menuAction());
        menuDatei.addAction(actionEinstellungen);
        menuDatei.addAction(actionBeenden);
        retranslateUi(MainWindow);
        actionBeenden.triggered.connect(MainWindow, "close()");

        tabWidget.setCurrentIndex(0);


        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "MainWindow", null));
        actionBeenden.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Beenden", null));
        actionEinstellungen.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Einstellungen", null));
        tableWidget.clear();
        tableWidget.setColumnCount(4);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidget.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidget.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidget.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));
        tableWidget.setHorizontalHeaderItem(3, __colItem3);
        tableWidget.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tab), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tab 1", null));
        tabWidget.setTabText(tabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tab 2", null));
        menuDatei.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datei", null));
    } // retranslateUi

}

