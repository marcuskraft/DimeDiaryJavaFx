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
import com.trolltech.qt.core.Qt.Orientation;
import com.trolltech.qt.gui.QAbstractItemView.EditTrigger;
import com.trolltech.qt.gui.QTabWidget.TabPosition;



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
    public QGridLayout gridLayout_2;
    public QTabWidget MainWindowTabWidget;
    public QWidget overview;
    public QGridLayout gridLayout_5;
    public QGridLayout gridLayout_4;
    public QComboBox comboBoxBankaccountOverview;
    public QLabel label_4;
    public QLabel label_5;
    public QSpinBox spinBoxYear;
    public QSpacerItem horizontalSpacer;
    public QTabWidget tabWidget;
    public QWidget tabJanuary;
    public QGridLayout gridLayout_7;
    public QTableWidget tableWidgetBalanceJanuary;
    public QWidget tabFebruary;
    public QGridLayout gridLayout_8;
    public QTableWidget tableWidgetBalanceFebruar;
    public QWidget tabMarch;
    public QGridLayout gridLayout_9;
    public QTableWidget tableWidgetBalanceMarch;
    public QWidget tabAprile;
    public QGridLayout gridLayout_10;
    public QTableWidget tableWidgetBalanceApril;
    public QWidget tabMay;
    public QGridLayout gridLayout_11;
    public QTableWidget tableWidgetBalanceMay;
    public QWidget tabJune;
    public QGridLayout gridLayout_12;
    public QTableWidget tableWidgetBalanceJune;
    public QWidget tabJuly;
    public QGridLayout gridLayout_13;
    public QTableWidget tableWidgetBalanceJuly;
    public QWidget tabAugust;
    public QGridLayout gridLayout_14;
    public QTableWidget tableWidgetBalanceAugust;
    public QWidget tabSeptember;
    public QGridLayout gridLayout_15;
    public QTableWidget tableWidgetBalanceSeptember;
    public QWidget tabOctober;
    public QGridLayout gridLayout_16;
    public QTableWidget tableWidgetBalanceOctober;
    public QWidget tabNovember;
    public QGridLayout gridLayout_17;
    public QTableWidget tableWidgetBalanceNovember;
    public QWidget tabDecember;
    public QGridLayout gridLayout_18;
    public QTableWidget tableWidgetBalanceDecember;
    public QWidget transactions;
    public QGridLayout gridLayout_6;
    public QPushButton buttonAddTransaction;
    public QTableWidget tableTransactions;
    public QSpacerItem horizontalSpacer_2;
    public QGridLayout gridLayout_3;
    public QLabel label;
    public QComboBox comboBoxBankaccountTransaction;
    public QLabel label_2;
    public QDateEdit dateFrom;
    public QLabel label_3;
    public QDateEdit dateUntil;
    public QPushButton pushButtonDelete;
    public QMenuBar menubar;
    public QMenu menuDatei;
    public QMenu menuBearbeiten;
    public QStatusBar statusbar;

    public UiMainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(1063, 779).expandedTo(MainWindow.minimumSizeHint()));
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
        gridLayout_2 = new QGridLayout(centralwidget);
        gridLayout_2.setObjectName("gridLayout_2");
        MainWindowTabWidget = new QTabWidget(centralwidget);
        MainWindowTabWidget.setObjectName("MainWindowTabWidget");
        QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred, com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
        sizePolicy.setHorizontalStretch((byte)0);
        sizePolicy.setVerticalStretch((byte)0);
        sizePolicy.setHeightForWidth(MainWindowTabWidget.sizePolicy().hasHeightForWidth());
        MainWindowTabWidget.setSizePolicy(sizePolicy);
        MainWindowTabWidget.setTabsClosable(false);
        MainWindowTabWidget.setMovable(false);
        overview = new QWidget();
        overview.setObjectName("overview");
        gridLayout_5 = new QGridLayout(overview);
        gridLayout_5.setObjectName("gridLayout_5");
        gridLayout_4 = new QGridLayout();
        gridLayout_4.setObjectName("gridLayout_4");
        comboBoxBankaccountOverview = new QComboBox(overview);
        comboBoxBankaccountOverview.setObjectName("comboBoxBankaccountOverview");

        gridLayout_4.addWidget(comboBoxBankaccountOverview, 0, 1, 1, 1);

        label_4 = new QLabel(overview);
        label_4.setObjectName("label_4");

        gridLayout_4.addWidget(label_4, 0, 0, 1, 1);

        label_5 = new QLabel(overview);
        label_5.setObjectName("label_5");

        gridLayout_4.addWidget(label_5, 1, 0, 1, 1);

        spinBoxYear = new QSpinBox(overview);
        spinBoxYear.setObjectName("spinBoxYear");
        spinBoxYear.setMinimum(1900);
        spinBoxYear.setMaximum(3000);
        spinBoxYear.setValue(2016);

        gridLayout_4.addWidget(spinBoxYear, 1, 1, 1, 1);


        gridLayout_5.addLayout(gridLayout_4, 0, 0, 1, 1);

        horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_5.addItem(horizontalSpacer, 0, 1, 1, 1);

        tabWidget = new QTabWidget(overview);
        tabWidget.setObjectName("tabWidget");
        tabWidget.setTabPosition(TabPosition.South);
        tabJanuary = new QWidget();
        tabJanuary.setObjectName("tabJanuary");
        gridLayout_7 = new QGridLayout(tabJanuary);
        gridLayout_7.setObjectName("gridLayout_7");
        tableWidgetBalanceJanuary = new QTableWidget(tabJanuary);
        tableWidgetBalanceJanuary.setObjectName("tableWidgetBalanceJanuary");

        gridLayout_7.addWidget(tableWidgetBalanceJanuary, 0, 0, 1, 1);

        tabWidget.addTab(tabJanuary, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Januar", null));
        tabFebruary = new QWidget();
        tabFebruary.setObjectName("tabFebruary");
        gridLayout_8 = new QGridLayout(tabFebruary);
        gridLayout_8.setObjectName("gridLayout_8");
        tableWidgetBalanceFebruar = new QTableWidget(tabFebruary);
        tableWidgetBalanceFebruar.setObjectName("tableWidgetBalanceFebruar");

        gridLayout_8.addWidget(tableWidgetBalanceFebruar, 0, 0, 1, 1);

        tabWidget.addTab(tabFebruary, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Februar", null));
        tabMarch = new QWidget();
        tabMarch.setObjectName("tabMarch");
        gridLayout_9 = new QGridLayout(tabMarch);
        gridLayout_9.setObjectName("gridLayout_9");
        tableWidgetBalanceMarch = new QTableWidget(tabMarch);
        tableWidgetBalanceMarch.setObjectName("tableWidgetBalanceMarch");

        gridLayout_9.addWidget(tableWidgetBalanceMarch, 0, 0, 1, 1);

        tabWidget.addTab(tabMarch, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "M\u00e4rz", null));
        tabAprile = new QWidget();
        tabAprile.setObjectName("tabAprile");
        gridLayout_10 = new QGridLayout(tabAprile);
        gridLayout_10.setObjectName("gridLayout_10");
        tableWidgetBalanceApril = new QTableWidget(tabAprile);
        tableWidgetBalanceApril.setObjectName("tableWidgetBalanceApril");

        gridLayout_10.addWidget(tableWidgetBalanceApril, 0, 0, 1, 1);

        tabWidget.addTab(tabAprile, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "April", null));
        tabMay = new QWidget();
        tabMay.setObjectName("tabMay");
        gridLayout_11 = new QGridLayout(tabMay);
        gridLayout_11.setObjectName("gridLayout_11");
        tableWidgetBalanceMay = new QTableWidget(tabMay);
        tableWidgetBalanceMay.setObjectName("tableWidgetBalanceMay");

        gridLayout_11.addWidget(tableWidgetBalanceMay, 0, 0, 1, 1);

        tabWidget.addTab(tabMay, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Mai", null));
        tabJune = new QWidget();
        tabJune.setObjectName("tabJune");
        gridLayout_12 = new QGridLayout(tabJune);
        gridLayout_12.setObjectName("gridLayout_12");
        tableWidgetBalanceJune = new QTableWidget(tabJune);
        tableWidgetBalanceJune.setObjectName("tableWidgetBalanceJune");

        gridLayout_12.addWidget(tableWidgetBalanceJune, 0, 0, 1, 1);

        tabWidget.addTab(tabJune, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juni", null));
        tabJuly = new QWidget();
        tabJuly.setObjectName("tabJuly");
        gridLayout_13 = new QGridLayout(tabJuly);
        gridLayout_13.setObjectName("gridLayout_13");
        tableWidgetBalanceJuly = new QTableWidget(tabJuly);
        tableWidgetBalanceJuly.setObjectName("tableWidgetBalanceJuly");

        gridLayout_13.addWidget(tableWidgetBalanceJuly, 0, 0, 1, 1);

        tabWidget.addTab(tabJuly, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juli", null));
        tabAugust = new QWidget();
        tabAugust.setObjectName("tabAugust");
        gridLayout_14 = new QGridLayout(tabAugust);
        gridLayout_14.setObjectName("gridLayout_14");
        tableWidgetBalanceAugust = new QTableWidget(tabAugust);
        tableWidgetBalanceAugust.setObjectName("tableWidgetBalanceAugust");

        gridLayout_14.addWidget(tableWidgetBalanceAugust, 0, 0, 1, 1);

        tabWidget.addTab(tabAugust, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "August", null));
        tabSeptember = new QWidget();
        tabSeptember.setObjectName("tabSeptember");
        gridLayout_15 = new QGridLayout(tabSeptember);
        gridLayout_15.setObjectName("gridLayout_15");
        tableWidgetBalanceSeptember = new QTableWidget(tabSeptember);
        tableWidgetBalanceSeptember.setObjectName("tableWidgetBalanceSeptember");

        gridLayout_15.addWidget(tableWidgetBalanceSeptember, 0, 0, 1, 1);

        tabWidget.addTab(tabSeptember, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "September", null));
        tabOctober = new QWidget();
        tabOctober.setObjectName("tabOctober");
        gridLayout_16 = new QGridLayout(tabOctober);
        gridLayout_16.setObjectName("gridLayout_16");
        tableWidgetBalanceOctober = new QTableWidget(tabOctober);
        tableWidgetBalanceOctober.setObjectName("tableWidgetBalanceOctober");

        gridLayout_16.addWidget(tableWidgetBalanceOctober, 0, 0, 1, 1);

        tabWidget.addTab(tabOctober, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Oktober", null));
        tabNovember = new QWidget();
        tabNovember.setObjectName("tabNovember");
        gridLayout_17 = new QGridLayout(tabNovember);
        gridLayout_17.setObjectName("gridLayout_17");
        tableWidgetBalanceNovember = new QTableWidget(tabNovember);
        tableWidgetBalanceNovember.setObjectName("tableWidgetBalanceNovember");

        gridLayout_17.addWidget(tableWidgetBalanceNovember, 0, 0, 1, 1);

        tabWidget.addTab(tabNovember, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "November", null));
        tabDecember = new QWidget();
        tabDecember.setObjectName("tabDecember");
        gridLayout_18 = new QGridLayout(tabDecember);
        gridLayout_18.setObjectName("gridLayout_18");
        tableWidgetBalanceDecember = new QTableWidget(tabDecember);
        tableWidgetBalanceDecember.setObjectName("tableWidgetBalanceDecember");

        gridLayout_18.addWidget(tableWidgetBalanceDecember, 0, 0, 1, 1);

        tabWidget.addTab(tabDecember, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Dezember", null));

        gridLayout_5.addWidget(tabWidget, 1, 0, 1, 2);

        MainWindowTabWidget.addTab(overview, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00dcberblick", null));
        transactions = new QWidget();
        transactions.setObjectName("transactions");
        gridLayout_6 = new QGridLayout(transactions);
        gridLayout_6.setObjectName("gridLayout_6");
        buttonAddTransaction = new QPushButton(transactions);
        buttonAddTransaction.setObjectName("buttonAddTransaction");

        gridLayout_6.addWidget(buttonAddTransaction, 0, 2, 1, 1);

        tableTransactions = new QTableWidget(transactions);
        tableTransactions.setObjectName("tableTransactions");
        tableTransactions.setLayoutDirection(LayoutDirection.LeftToRight);
        tableTransactions.setAutoFillBackground(false);
        tableTransactions.setEditTriggers(EditTrigger.createQFlags(EditTrigger.NoEditTriggers));
        tableTransactions.setAlternatingRowColors(true);
        tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);
        tableTransactions.setSortingEnabled(true);
        tableTransactions.setRowCount(0);
        tableTransactions.setColumnCount(6);

        gridLayout_6.addWidget(tableTransactions, 1, 0, 1, 3);

        horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

        gridLayout_6.addItem(horizontalSpacer_2, 0, 1, 1, 1);

        gridLayout_3 = new QGridLayout();
        gridLayout_3.setObjectName("gridLayout_3");
        label = new QLabel(transactions);
        label.setObjectName("label");

        gridLayout_3.addWidget(label, 0, 0, 1, 1);

        comboBoxBankaccountTransaction = new QComboBox(transactions);
        comboBoxBankaccountTransaction.setObjectName("comboBoxBankaccountTransaction");

        gridLayout_3.addWidget(comboBoxBankaccountTransaction, 0, 1, 1, 1);

        label_2 = new QLabel(transactions);
        label_2.setObjectName("label_2");

        gridLayout_3.addWidget(label_2, 1, 0, 1, 1);

        dateFrom = new QDateEdit(transactions);
        dateFrom.setObjectName("dateFrom");
        dateFrom.setCalendarPopup(true);

        gridLayout_3.addWidget(dateFrom, 1, 1, 1, 1);

        label_3 = new QLabel(transactions);
        label_3.setObjectName("label_3");

        gridLayout_3.addWidget(label_3, 2, 0, 1, 1);

        dateUntil = new QDateEdit(transactions);
        dateUntil.setObjectName("dateUntil");
        dateUntil.setCalendarPopup(true);

        gridLayout_3.addWidget(dateUntil, 2, 1, 1, 1);


        gridLayout_6.addLayout(gridLayout_3, 0, 0, 1, 1);

        pushButtonDelete = new QPushButton(transactions);
        pushButtonDelete.setObjectName("pushButtonDelete");

        gridLayout_6.addWidget(pushButtonDelete, 2, 2, 1, 1);

        MainWindowTabWidget.addTab(transactions, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));

        gridLayout_2.addWidget(MainWindowTabWidget, 0, 0, 1, 1);

        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 1063, 21));
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

        MainWindowTabWidget.setCurrentIndex(0);
        tabWidget.setCurrentIndex(1);


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
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Jahr", null));
        tableWidgetBalanceJanuary.clear();
        tableWidgetBalanceJanuary.setColumnCount(3);

        QTableWidgetItem __colItem = new QTableWidgetItem();
        __colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceJanuary.setHorizontalHeaderItem(0, __colItem);

        QTableWidgetItem __colItem1 = new QTableWidgetItem();
        __colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceJanuary.setHorizontalHeaderItem(1, __colItem1);

        QTableWidgetItem __colItem2 = new QTableWidgetItem();
        __colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceJanuary.setHorizontalHeaderItem(2, __colItem2);
        tableWidgetBalanceJanuary.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabJanuary), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Januar", null));
        tableWidgetBalanceFebruar.clear();
        tableWidgetBalanceFebruar.setColumnCount(3);

        QTableWidgetItem __colItem3 = new QTableWidgetItem();
        __colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceFebruar.setHorizontalHeaderItem(0, __colItem3);

        QTableWidgetItem __colItem4 = new QTableWidgetItem();
        __colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceFebruar.setHorizontalHeaderItem(1, __colItem4);

        QTableWidgetItem __colItem5 = new QTableWidgetItem();
        __colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceFebruar.setHorizontalHeaderItem(2, __colItem5);
        tableWidgetBalanceFebruar.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabFebruary), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Februar", null));
        tableWidgetBalanceMarch.clear();
        tableWidgetBalanceMarch.setColumnCount(3);

        QTableWidgetItem __colItem6 = new QTableWidgetItem();
        __colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceMarch.setHorizontalHeaderItem(0, __colItem6);

        QTableWidgetItem __colItem7 = new QTableWidgetItem();
        __colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceMarch.setHorizontalHeaderItem(1, __colItem7);

        QTableWidgetItem __colItem8 = new QTableWidgetItem();
        __colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceMarch.setHorizontalHeaderItem(2, __colItem8);
        tableWidgetBalanceMarch.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabMarch), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "M\u00e4rz", null));
        tableWidgetBalanceApril.clear();
        tableWidgetBalanceApril.setColumnCount(3);

        QTableWidgetItem __colItem9 = new QTableWidgetItem();
        __colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceApril.setHorizontalHeaderItem(0, __colItem9);

        QTableWidgetItem __colItem10 = new QTableWidgetItem();
        __colItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceApril.setHorizontalHeaderItem(1, __colItem10);

        QTableWidgetItem __colItem11 = new QTableWidgetItem();
        __colItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceApril.setHorizontalHeaderItem(2, __colItem11);
        tableWidgetBalanceApril.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabAprile), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "April", null));
        tableWidgetBalanceMay.clear();
        tableWidgetBalanceMay.setColumnCount(3);

        QTableWidgetItem __colItem12 = new QTableWidgetItem();
        __colItem12.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceMay.setHorizontalHeaderItem(0, __colItem12);

        QTableWidgetItem __colItem13 = new QTableWidgetItem();
        __colItem13.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceMay.setHorizontalHeaderItem(1, __colItem13);

        QTableWidgetItem __colItem14 = new QTableWidgetItem();
        __colItem14.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceMay.setHorizontalHeaderItem(2, __colItem14);
        tableWidgetBalanceMay.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabMay), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Mai", null));
        tableWidgetBalanceJune.clear();
        tableWidgetBalanceJune.setColumnCount(3);

        QTableWidgetItem __colItem15 = new QTableWidgetItem();
        __colItem15.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceJune.setHorizontalHeaderItem(0, __colItem15);

        QTableWidgetItem __colItem16 = new QTableWidgetItem();
        __colItem16.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceJune.setHorizontalHeaderItem(1, __colItem16);

        QTableWidgetItem __colItem17 = new QTableWidgetItem();
        __colItem17.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceJune.setHorizontalHeaderItem(2, __colItem17);
        tableWidgetBalanceJune.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabJune), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juni", null));
        tableWidgetBalanceJuly.clear();
        tableWidgetBalanceJuly.setColumnCount(3);

        QTableWidgetItem __colItem18 = new QTableWidgetItem();
        __colItem18.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceJuly.setHorizontalHeaderItem(0, __colItem18);

        QTableWidgetItem __colItem19 = new QTableWidgetItem();
        __colItem19.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceJuly.setHorizontalHeaderItem(1, __colItem19);

        QTableWidgetItem __colItem20 = new QTableWidgetItem();
        __colItem20.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceJuly.setHorizontalHeaderItem(2, __colItem20);
        tableWidgetBalanceJuly.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabJuly), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juli", null));
        tableWidgetBalanceAugust.clear();
        tableWidgetBalanceAugust.setColumnCount(3);

        QTableWidgetItem __colItem21 = new QTableWidgetItem();
        __colItem21.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceAugust.setHorizontalHeaderItem(0, __colItem21);

        QTableWidgetItem __colItem22 = new QTableWidgetItem();
        __colItem22.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceAugust.setHorizontalHeaderItem(1, __colItem22);

        QTableWidgetItem __colItem23 = new QTableWidgetItem();
        __colItem23.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceAugust.setHorizontalHeaderItem(2, __colItem23);
        tableWidgetBalanceAugust.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabAugust), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "August", null));
        tableWidgetBalanceSeptember.clear();
        tableWidgetBalanceSeptember.setColumnCount(3);

        QTableWidgetItem __colItem24 = new QTableWidgetItem();
        __colItem24.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceSeptember.setHorizontalHeaderItem(0, __colItem24);

        QTableWidgetItem __colItem25 = new QTableWidgetItem();
        __colItem25.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceSeptember.setHorizontalHeaderItem(1, __colItem25);

        QTableWidgetItem __colItem26 = new QTableWidgetItem();
        __colItem26.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceSeptember.setHorizontalHeaderItem(2, __colItem26);
        tableWidgetBalanceSeptember.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabSeptember), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "September", null));
        tableWidgetBalanceOctober.clear();
        tableWidgetBalanceOctober.setColumnCount(3);

        QTableWidgetItem __colItem27 = new QTableWidgetItem();
        __colItem27.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceOctober.setHorizontalHeaderItem(0, __colItem27);

        QTableWidgetItem __colItem28 = new QTableWidgetItem();
        __colItem28.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceOctober.setHorizontalHeaderItem(1, __colItem28);

        QTableWidgetItem __colItem29 = new QTableWidgetItem();
        __colItem29.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceOctober.setHorizontalHeaderItem(2, __colItem29);
        tableWidgetBalanceOctober.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabOctober), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Oktober", null));
        tableWidgetBalanceNovember.clear();
        tableWidgetBalanceNovember.setColumnCount(3);

        QTableWidgetItem __colItem30 = new QTableWidgetItem();
        __colItem30.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceNovember.setHorizontalHeaderItem(0, __colItem30);

        QTableWidgetItem __colItem31 = new QTableWidgetItem();
        __colItem31.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceNovember.setHorizontalHeaderItem(1, __colItem31);

        QTableWidgetItem __colItem32 = new QTableWidgetItem();
        __colItem32.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceNovember.setHorizontalHeaderItem(2, __colItem32);
        tableWidgetBalanceNovember.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabNovember), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "November", null));
        tableWidgetBalanceDecember.clear();
        tableWidgetBalanceDecember.setColumnCount(3);

        QTableWidgetItem __colItem33 = new QTableWidgetItem();
        __colItem33.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableWidgetBalanceDecember.setHorizontalHeaderItem(0, __colItem33);

        QTableWidgetItem __colItem34 = new QTableWidgetItem();
        __colItem34.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableWidgetBalanceDecember.setHorizontalHeaderItem(1, __colItem34);

        QTableWidgetItem __colItem35 = new QTableWidgetItem();
        __colItem35.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableWidgetBalanceDecember.setHorizontalHeaderItem(2, __colItem35);
        tableWidgetBalanceDecember.setRowCount(0);
        tabWidget.setTabText(tabWidget.indexOf(tabDecember), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Dezember", null));
        MainWindowTabWidget.setTabText(MainWindowTabWidget.indexOf(overview), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00dcberblick", null));
        buttonAddTransaction.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Transaktion erstellen", null));
        tableTransactions.clear();
        tableTransactions.setColumnCount(6);

        QTableWidgetItem __colItem36 = new QTableWidgetItem();
        __colItem36.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
        tableTransactions.setHorizontalHeaderItem(0, __colItem36);

        QTableWidgetItem __colItem37 = new QTableWidgetItem();
        __colItem37.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
        tableTransactions.setHorizontalHeaderItem(1, __colItem37);

        QTableWidgetItem __colItem38 = new QTableWidgetItem();
        __colItem38.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Betrag", null));
        tableTransactions.setHorizontalHeaderItem(2, __colItem38);

        QTableWidgetItem __colItem39 = new QTableWidgetItem();
        __colItem39.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Betreff", null));
        tableTransactions.setHorizontalHeaderItem(3, __colItem39);

        QTableWidgetItem __colItem40 = new QTableWidgetItem();
        __colItem40.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kategorie", null));
        tableTransactions.setHorizontalHeaderItem(4, __colItem40);

        QTableWidgetItem __colItem41 = new QTableWidgetItem();
        __colItem41.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
        tableTransactions.setHorizontalHeaderItem(5, __colItem41);
        tableTransactions.setRowCount(0);
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "von", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "bis", null));
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "L\u00f6schen", null));
        MainWindowTabWidget.setTabText(MainWindowTabWidget.indexOf(transactions), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));
        menuDatei.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datei", null));
        menuBearbeiten.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Bearbeiten", null));
    } // retranslateUi

}

