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
    public QComboBox comboBoxBankaccount_2;
    public QLabel label_4;
    public QLabel label_5;
    public QSpinBox spinBoxYear;
    public QSpacerItem horizontalSpacer;
    public QTabWidget tabWidget;
    public QWidget tabJanuary;
    public QWidget tabFebruary;
    public QWidget tabMarch;
    public QWidget tabAprile;
    public QWidget tabMay;
    public QWidget tabJune;
    public QWidget tabJuly;
    public QWidget tabAugust;
    public QWidget tabSeptember;
    public QWidget tabOctober;
    public QWidget tabNovember;
    public QWidget tabDecember;
    public QWidget transactions;
    public QGridLayout gridLayout_6;
    public QGridLayout gridLayout_3;
    public QLabel label;
    public QComboBox comboBoxBankaccount;
    public QLabel label_2;
    public QDateEdit dateFrom;
    public QLabel label_3;
    public QDateEdit dateUntil;
    public QPushButton pushButtonDelete;
    public QPushButton buttonAddTransaction;
    public QTableWidget tableTransactions;
    public QSpacerItem horizontalSpacer_2;
    public QMenuBar menubar;
    public QMenu menuDatei;
    public QMenu menuBearbeiten;
    public QStatusBar statusbar;

    public UiMainWindow() { super(); }

    public void setupUi(QMainWindow MainWindow)
    {
        MainWindow.setObjectName("MainWindow");
        MainWindow.resize(new QSize(815, 695).expandedTo(MainWindow.minimumSizeHint()));
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
        comboBoxBankaccount_2 = new QComboBox(overview);
        comboBoxBankaccount_2.setObjectName("comboBoxBankaccount_2");

        gridLayout_4.addWidget(comboBoxBankaccount_2, 0, 1, 1, 1);

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
        tabWidget.addTab(tabJanuary, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Januar", null));
        tabFebruary = new QWidget();
        tabFebruary.setObjectName("tabFebruary");
        tabWidget.addTab(tabFebruary, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Februar", null));
        tabMarch = new QWidget();
        tabMarch.setObjectName("tabMarch");
        tabWidget.addTab(tabMarch, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "M\u00e4rz", null));
        tabAprile = new QWidget();
        tabAprile.setObjectName("tabAprile");
        tabWidget.addTab(tabAprile, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "April", null));
        tabMay = new QWidget();
        tabMay.setObjectName("tabMay");
        tabWidget.addTab(tabMay, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Mai", null));
        tabJune = new QWidget();
        tabJune.setObjectName("tabJune");
        tabWidget.addTab(tabJune, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juni", null));
        tabJuly = new QWidget();
        tabJuly.setObjectName("tabJuly");
        tabWidget.addTab(tabJuly, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juli", null));
        tabAugust = new QWidget();
        tabAugust.setObjectName("tabAugust");
        tabWidget.addTab(tabAugust, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "August", null));
        tabSeptember = new QWidget();
        tabSeptember.setObjectName("tabSeptember");
        tabWidget.addTab(tabSeptember, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "September", null));
        tabOctober = new QWidget();
        tabOctober.setObjectName("tabOctober");
        tabWidget.addTab(tabOctober, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Oktober", null));
        tabNovember = new QWidget();
        tabNovember.setObjectName("tabNovember");
        tabWidget.addTab(tabNovember, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "November", null));
        tabDecember = new QWidget();
        tabDecember.setObjectName("tabDecember");
        tabWidget.addTab(tabDecember, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Dezember", null));

        gridLayout_5.addWidget(tabWidget, 1, 0, 1, 2);

        MainWindowTabWidget.addTab(overview, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00dcberblick", null));
        transactions = new QWidget();
        transactions.setObjectName("transactions");
        gridLayout_6 = new QGridLayout(transactions);
        gridLayout_6.setObjectName("gridLayout_6");
        gridLayout_3 = new QGridLayout();
        gridLayout_3.setObjectName("gridLayout_3");
        label = new QLabel(transactions);
        label.setObjectName("label");

        gridLayout_3.addWidget(label, 0, 0, 1, 1);

        comboBoxBankaccount = new QComboBox(transactions);
        comboBoxBankaccount.setObjectName("comboBoxBankaccount");

        gridLayout_3.addWidget(comboBoxBankaccount, 0, 1, 1, 1);

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

        gridLayout_6.addWidget(pushButtonDelete, 2, 0, 1, 1);

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

        MainWindowTabWidget.addTab(transactions, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));

        gridLayout_2.addWidget(MainWindowTabWidget, 0, 0, 1, 1);

        MainWindow.setCentralWidget(centralwidget);
        menubar = new QMenuBar(MainWindow);
        menubar.setObjectName("menubar");
        menubar.setGeometry(new QRect(0, 0, 815, 21));
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
        label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto", null));
        label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Jahr", null));
        tabWidget.setTabText(tabWidget.indexOf(tabJanuary), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Januar", null));
        tabWidget.setTabText(tabWidget.indexOf(tabFebruary), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Februar", null));
        tabWidget.setTabText(tabWidget.indexOf(tabMarch), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "M\u00e4rz", null));
        tabWidget.setTabText(tabWidget.indexOf(tabAprile), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "April", null));
        tabWidget.setTabText(tabWidget.indexOf(tabMay), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Mai", null));
        tabWidget.setTabText(tabWidget.indexOf(tabJune), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juni", null));
        tabWidget.setTabText(tabWidget.indexOf(tabJuly), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juli", null));
        tabWidget.setTabText(tabWidget.indexOf(tabAugust), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "August", null));
        tabWidget.setTabText(tabWidget.indexOf(tabSeptember), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "September", null));
        tabWidget.setTabText(tabWidget.indexOf(tabOctober), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Oktober", null));
        tabWidget.setTabText(tabWidget.indexOf(tabNovember), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "November", null));
        tabWidget.setTabText(tabWidget.indexOf(tabDecember), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Dezember", null));
        MainWindowTabWidget.setTabText(MainWindowTabWidget.indexOf(overview), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00dcberblick", null));
        label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto", null));
        label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "von", null));
        label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "bis", null));
        pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "L\u00f6schen", null));
        buttonAddTransaction.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Transaktion erstellen", null));
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
        MainWindowTabWidget.setTabText(MainWindowTabWidget.indexOf(transactions), com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));
        menuDatei.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datei", null));
        menuBearbeiten.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Bearbeiten", null));
    } // retranslateUi

}

