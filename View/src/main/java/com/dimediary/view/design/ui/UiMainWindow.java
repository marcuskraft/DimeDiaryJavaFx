/********************************************************************************
 ** Form generated from reading ui file 'mainwindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;
import com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior;
import com.trolltech.qt.core.Qt.LayoutDirection;
import com.trolltech.qt.gui.QAbstractItemView.EditTrigger;



import com.trolltech.qt.core.*;
import com.trolltech.qt.gui.*;

public class UiMainWindow implements com.trolltech.qt.QUiForm<QMainWindow>
{
    public QAction actionBeenden;
    public QAction actionEinstellungen;
    public QAction actionKonto_erstellen;
    public QAction actionKontoart_erstellen;
    public QAction actionKategorie_erstellen;
    public QWidget centralwidget;
    public QWidget gridLayoutWidget;
    public QGridLayout gridLayout;
    public QTabWidget tabWidget;
    public QWidget transactions;
    public QTableWidget tableTransactions;
    public QComboBox comboBoxBankaccount;
    public QLabel label;
    public QDateEdit dateUntil;
    public QDateEdit dateFrom;
    public QLabel label_2;
    public QLabel label_3;
    public QPushButton buttonAddTransaction;
    public QPushButton pushButtonDelete;
    public QWidget tab_2;
    public QMenuBar menubar;
    public QMenu menuDatei;
    public QMenu menuBearbeiten;
    public QStatusBar statusbar;

    public UiMainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(722, 792).expandedTo(MainWindow.minimumSizeHint()));
        actionBeenden = new QAction(MainWindow);
        actionBeenden.setObjectName("actionBeenden");
        actionEinstellungen = new QAction(MainWindow);
        actionEinstellungen.setObjectName("actionEinstellungen");
        actionKonto_erstellen = new QAction(MainWindow);
        actionKonto_erstellen.setObjectName("actionKonto_erstellen");
        actionKontoart_erstellen = new QAction(MainWindow);
        actionKontoart_erstellen.setObjectName("actionKontoart_erstellen");
        actionKategorie_erstellen = new QAction(MainWindow);
        actionKategorie_erstellen.setObjectName("actionKategorie_erstellen");
        centralwidget = new QWidget(MainWindow);
        centralwidget.setObjectName("centralwidget");
        gridLayoutWidget = new QWidget(centralwidget);
        gridLayoutWidget.setObjectName("gridLayoutWidget");
        gridLayoutWidget.setGeometry(new QRect(0, 0, 2, 2));
        gridLayout = new QGridLayout(gridLayoutWidget);
        gridLayout.setObjectName("gridLayout");
        tabWidget = new QTabWidget(centralwidget);
        tabWidget.setObjectName("tabWidget");
        tabWidget.setGeometry(new QRect(0, 0, 941, 771));
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Maximum, com.trolltech.qt.gui.QSizePolicy.Policy.Maximum);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(tabWidget.sizePolicy().hasHeightForWidth());
        tabWidget.setSizePolicy(sizePolicy);
        tabWidget.setTabsClosable(false);
        tabWidget.setMovable(false);
        transactions = new QWidget();
        transactions.setObjectName("transactions");
        tableTransactions = new QTableWidget(transactions);
        tableTransactions.setObjectName("tableTransactions");
        tableTransactions.setGeometry(new QRect(0, 40, 711, 651));
        tableTransactions.setLayoutDirection(LayoutDirection.LeftToRight);
        tableTransactions.setAutoFillBackground(false);
        tableTransactions.setEditTriggers(EditTrigger.createQFlags(EditTrigger.NoEditTriggers));
        tableTransactions.setAlternatingRowColors(true);
        tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);
        tableTransactions.setSortingEnabled(true);
        tableTransactions.setRowCount(0);
        tableTransactions.setColumnCount(6);
        comboBoxBankaccount = new QComboBox(transactions);
        comboBoxBankaccount.setObjectName("comboBoxBankaccount");
        comboBoxBankaccount.setGeometry(new QRect(40, 10, 91, 22));
        label = new QLabel(transactions);
        label.setObjectName("label");
        label.setGeometry(new QRect(10, 10, 31, 16));
        dateUntil = new QDateEdit(transactions);
        dateUntil.setObjectName("dateUntil");
        dateUntil.setGeometry(new QRect(310, 10, 110, 22));
        dateUntil.setCalendarPopup(true);
        dateFrom = new QDateEdit(transactions);
        dateFrom.setObjectName("dateFrom");
        dateFrom.setGeometry(new QRect(170, 10, 110, 22));
        dateFrom.setCalendarPopup(true);
        label_2 = new QLabel(transactions);
        label_2.setObjectName("label_2");
        label_2.setGeometry(new QRect(150, 10, 21, 20));
        label_3 = new QLabel(transactions);
        label_3.setObjectName("label_3");
        label_3.setGeometry(new QRect(290, 10, 46, 20));
        buttonAddTransaction = new QPushButton(transactions);
        buttonAddTransaction.setObjectName("buttonAddTransaction");
        buttonAddTransaction.setGeometry(new QRect(600, 10, 111, 23));
        pushButtonDelete = new QPushButton(transactions);
        pushButtonDelete.setObjectName("pushButtonDelete");
        pushButtonDelete.setGeometry(new QRect(630, 700, 75, 23));
        tabWidget.addTab(transactions, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));
        tab_2 = new QWidget();
        tab_2.setObjectName("tab_2");
        tabWidget.addTab(tab_2, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tab 2", null));
        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 722, 21));
        menuDatei = new QMenu(menubar);
        menuDatei.setObjectName("menuDatei");
        menuBearbeiten = new QMenu(menubar);
        menuBearbeiten.setObjectName("menuBearbeiten");
        MainWindow.setMenuBar(menubar);
        statusbar = new QStatusBar(MainWindow);
        statusbar.setObjectName("statusbar");
        MainWindow.setStatusBar(statusbar);

        menubar.addAction(menuDatei.menuAction());
        menubar.addAction(menuBearbeiten.menuAction());
        menuDatei.addAction(actionEinstellungen);
        menuDatei.addAction(actionBeenden);
        menuBearbeiten.addAction(actionKonto_erstellen);
        menuBearbeiten.addAction(actionKontoart_erstellen);
        menuBearbeiten.addSeparator();
        menuBearbeiten.addAction(actionKategorie_erstellen);
        retranslateUi(MainWindow);
        actionBeenden.triggered.connect(MainWindow, "close()");

        tabWidget.setCurrentIndex(0);


        MainWindow.connectSlotsByName();
    } // setupUi

    void retranslateUi(QMainWindow MainWindow)
    {
        MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "DimeDiary", null));
        actionBeenden.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Beenden", null));
        actionEinstellungen.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Einstellungen", null));
        actionKonto_erstellen.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto erstellen", null));
        actionKontoart_erstellen.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontoart erstellen", null));
        actionKategorie_erstellen.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kategorie erstellen", null));
        tableTransactions.clear();
        tableTransactions.setColumnCount(6);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableTransactions.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableTransactions.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Betrag", null));
        tableTransactions.setHorizontalHeaderItem(2, __colItem2);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Betreff", null));
        tableTransactions.setHorizontalHeaderItem(3, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kategorie", null));
        tableTransactions.setHorizontalHeaderItem(4, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableTransactions.setHorizontalHeaderItem(5, __colItem5);
        tableTransactions.setRowCount(0);
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "von", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "bis", null));
        buttonAddTransaction.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Transaktion erstellen", null));
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "L\u00f6schen", null));
        tabWidget.setTabText(tabWidget.indexOf(transactions), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));
        tabWidget.setTabText(tabWidget.indexOf(tab_2), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Tab 2", null));
        menuDatei.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datei", null));
        menuBearbeiten.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Bearbeiten", null));
    } // retranslateUi

}

