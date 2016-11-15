/********************************************************************************
 ** Form generated from reading ui file 'mainwindow.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;

import com.trolltech.qt.core.QRect;
import com.trolltech.qt.core.QSize;
import com.trolltech.qt.core.Qt.LayoutDirection;
import com.trolltech.qt.gui.QAbstractItemView.EditTrigger;
import com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior;
import com.trolltech.qt.gui.QAction;
import com.trolltech.qt.gui.QComboBox;
import com.trolltech.qt.gui.QDateEdit;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QMenu;
import com.trolltech.qt.gui.QMenuBar;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QSizePolicy;
import com.trolltech.qt.gui.QSpacerItem;
import com.trolltech.qt.gui.QSpinBox;
import com.trolltech.qt.gui.QStatusBar;
import com.trolltech.qt.gui.QTabWidget;
import com.trolltech.qt.gui.QTabWidget.TabPosition;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;

public class UiMainWindow implements com.trolltech.qt.QUiForm<QMainWindow> {
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

	public UiMainWindow() {
		super();
	}

	@Override
	public void setupUi(final QMainWindow MainWindow) {
		MainWindow.setObjectName("MainWindow");
		MainWindow.resize(new QSize(1063, 779).expandedTo(MainWindow.minimumSizeHint()));
		this.actionBeenden = new QAction(MainWindow);
		this.actionBeenden.setObjectName("actionBeenden");
		this.actionEinstellungen = new QAction(MainWindow);
		this.actionEinstellungen.setObjectName("actionEinstellungen");
		this.actionKonto_erstellen = new QAction(MainWindow);
		this.actionKonto_erstellen.setObjectName("actionKonto_erstellen");
		this.actionKontoart_erstellen = new QAction(MainWindow);
		this.actionKontoart_erstellen.setObjectName("actionKontoart_erstellen");
		this.actionKategorie_erstellen = new QAction(MainWindow);
		this.actionKategorie_erstellen.setObjectName("actionKategorie_erstellen");
		this.centralwidget = new QWidget(MainWindow);
		this.centralwidget.setObjectName("centralwidget");
		this.gridLayoutWidget = new QWidget(this.centralwidget);
		this.gridLayoutWidget.setObjectName("gridLayoutWidget");
		this.gridLayoutWidget.setGeometry(new QRect(0, 0, 2, 2));
		this.gridLayout = new QGridLayout(this.gridLayoutWidget);
		this.gridLayout.setObjectName("gridLayout");
		this.gridLayout_2 = new QGridLayout(this.centralwidget);
		this.gridLayout_2.setObjectName("gridLayout_2");
		this.MainWindowTabWidget = new QTabWidget(this.centralwidget);
		this.MainWindowTabWidget.setObjectName("MainWindowTabWidget");
		final QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred,
				com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
		sizePolicy.setHorizontalStretch((byte) 0);
		sizePolicy.setVerticalStretch((byte) 0);
		sizePolicy.setHeightForWidth(this.MainWindowTabWidget.sizePolicy().hasHeightForWidth());
		this.MainWindowTabWidget.setSizePolicy(sizePolicy);
		this.MainWindowTabWidget.setTabsClosable(false);
		this.MainWindowTabWidget.setMovable(false);
		this.overview = new QWidget();
		this.overview.setObjectName("overview");
		this.gridLayout_5 = new QGridLayout(this.overview);
		this.gridLayout_5.setObjectName("gridLayout_5");
		this.gridLayout_4 = new QGridLayout();
		this.gridLayout_4.setObjectName("gridLayout_4");
		this.comboBoxBankaccountOverview = new QComboBox(this.overview);
		this.comboBoxBankaccountOverview.setObjectName("comboBoxBankaccountOverview");

		this.gridLayout_4.addWidget(this.comboBoxBankaccountOverview, 0, 1, 1, 1);

		this.label_4 = new QLabel(this.overview);
		this.label_4.setObjectName("label_4");

		this.gridLayout_4.addWidget(this.label_4, 0, 0, 1, 1);

		this.label_5 = new QLabel(this.overview);
		this.label_5.setObjectName("label_5");

		this.gridLayout_4.addWidget(this.label_5, 1, 0, 1, 1);

		this.spinBoxYear = new QSpinBox(this.overview);
		this.spinBoxYear.setObjectName("spinBoxYear");
		this.spinBoxYear.setMinimum(1900);
		this.spinBoxYear.setMaximum(3000);
		this.spinBoxYear.setValue(2016);

		this.gridLayout_4.addWidget(this.spinBoxYear, 1, 1, 1, 1);

		this.gridLayout_5.addLayout(this.gridLayout_4, 0, 0, 1, 1);

		this.horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_5.addItem(this.horizontalSpacer, 0, 1, 1, 1);

		this.tabWidget = new QTabWidget(this.overview);
		this.tabWidget.setObjectName("tabWidget");
		this.tabWidget.setTabPosition(TabPosition.South);
		this.tabJanuary = new QWidget();
		this.tabJanuary.setObjectName("tabJanuary");
		this.gridLayout_7 = new QGridLayout(this.tabJanuary);
		this.gridLayout_7.setObjectName("gridLayout_7");
		this.tableWidgetBalanceJanuary = new QTableWidget(this.tabJanuary);
		this.tableWidgetBalanceJanuary.setObjectName("tableWidgetBalanceJanuary");

		this.gridLayout_7.addWidget(this.tableWidgetBalanceJanuary, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabJanuary,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Januar", null));
		this.tabFebruary = new QWidget();
		this.tabFebruary.setObjectName("tabFebruary");
		this.gridLayout_8 = new QGridLayout(this.tabFebruary);
		this.gridLayout_8.setObjectName("gridLayout_8");
		this.tableWidgetBalanceFebruar = new QTableWidget(this.tabFebruary);
		this.tableWidgetBalanceFebruar.setObjectName("tableWidgetBalanceFebruar");

		this.gridLayout_8.addWidget(this.tableWidgetBalanceFebruar, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabFebruary,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Februar", null));
		this.tabMarch = new QWidget();
		this.tabMarch.setObjectName("tabMarch");
		this.gridLayout_9 = new QGridLayout(this.tabMarch);
		this.gridLayout_9.setObjectName("gridLayout_9");
		this.tableWidgetBalanceMarch = new QTableWidget(this.tabMarch);
		this.tableWidgetBalanceMarch.setObjectName("tableWidgetBalanceMarch");

		this.gridLayout_9.addWidget(this.tableWidgetBalanceMarch, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabMarch,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "M\u00e4rz", null));
		this.tabAprile = new QWidget();
		this.tabAprile.setObjectName("tabAprile");
		this.gridLayout_10 = new QGridLayout(this.tabAprile);
		this.gridLayout_10.setObjectName("gridLayout_10");
		this.tableWidgetBalanceApril = new QTableWidget(this.tabAprile);
		this.tableWidgetBalanceApril.setObjectName("tableWidgetBalanceApril");

		this.gridLayout_10.addWidget(this.tableWidgetBalanceApril, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabAprile,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "April", null));
		this.tabMay = new QWidget();
		this.tabMay.setObjectName("tabMay");
		this.gridLayout_11 = new QGridLayout(this.tabMay);
		this.gridLayout_11.setObjectName("gridLayout_11");
		this.tableWidgetBalanceMay = new QTableWidget(this.tabMay);
		this.tableWidgetBalanceMay.setObjectName("tableWidgetBalanceMay");

		this.gridLayout_11.addWidget(this.tableWidgetBalanceMay, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabMay, com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Mai", null));
		this.tabJune = new QWidget();
		this.tabJune.setObjectName("tabJune");
		this.gridLayout_12 = new QGridLayout(this.tabJune);
		this.gridLayout_12.setObjectName("gridLayout_12");
		this.tableWidgetBalanceJune = new QTableWidget(this.tabJune);
		this.tableWidgetBalanceJune.setObjectName("tableWidgetBalanceJune");

		this.gridLayout_12.addWidget(this.tableWidgetBalanceJune, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabJune,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juni", null));
		this.tabJuly = new QWidget();
		this.tabJuly.setObjectName("tabJuly");
		this.gridLayout_13 = new QGridLayout(this.tabJuly);
		this.gridLayout_13.setObjectName("gridLayout_13");
		this.tableWidgetBalanceJuly = new QTableWidget(this.tabJuly);
		this.tableWidgetBalanceJuly.setObjectName("tableWidgetBalanceJuly");

		this.gridLayout_13.addWidget(this.tableWidgetBalanceJuly, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabJuly,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juli", null));
		this.tabAugust = new QWidget();
		this.tabAugust.setObjectName("tabAugust");
		this.gridLayout_14 = new QGridLayout(this.tabAugust);
		this.gridLayout_14.setObjectName("gridLayout_14");
		this.tableWidgetBalanceAugust = new QTableWidget(this.tabAugust);
		this.tableWidgetBalanceAugust.setObjectName("tableWidgetBalanceAugust");

		this.gridLayout_14.addWidget(this.tableWidgetBalanceAugust, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabAugust,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "August", null));
		this.tabSeptember = new QWidget();
		this.tabSeptember.setObjectName("tabSeptember");
		this.gridLayout_15 = new QGridLayout(this.tabSeptember);
		this.gridLayout_15.setObjectName("gridLayout_15");
		this.tableWidgetBalanceSeptember = new QTableWidget(this.tabSeptember);
		this.tableWidgetBalanceSeptember.setObjectName("tableWidgetBalanceSeptember");

		this.gridLayout_15.addWidget(this.tableWidgetBalanceSeptember, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabSeptember,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "September", null));
		this.tabOctober = new QWidget();
		this.tabOctober.setObjectName("tabOctober");
		this.gridLayout_16 = new QGridLayout(this.tabOctober);
		this.gridLayout_16.setObjectName("gridLayout_16");
		this.tableWidgetBalanceOctober = new QTableWidget(this.tabOctober);
		this.tableWidgetBalanceOctober.setObjectName("tableWidgetBalanceOctober");

		this.gridLayout_16.addWidget(this.tableWidgetBalanceOctober, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabOctober,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Oktober", null));
		this.tabNovember = new QWidget();
		this.tabNovember.setObjectName("tabNovember");
		this.gridLayout_17 = new QGridLayout(this.tabNovember);
		this.gridLayout_17.setObjectName("gridLayout_17");
		this.tableWidgetBalanceNovember = new QTableWidget(this.tabNovember);
		this.tableWidgetBalanceNovember.setObjectName("tableWidgetBalanceNovember");

		this.gridLayout_17.addWidget(this.tableWidgetBalanceNovember, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabNovember,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "November", null));
		this.tabDecember = new QWidget();
		this.tabDecember.setObjectName("tabDecember");
		this.gridLayout_18 = new QGridLayout(this.tabDecember);
		this.gridLayout_18.setObjectName("gridLayout_18");
		this.tableWidgetBalanceDecember = new QTableWidget(this.tabDecember);
		this.tableWidgetBalanceDecember.setObjectName("tableWidgetBalanceDecember");

		this.gridLayout_18.addWidget(this.tableWidgetBalanceDecember, 0, 0, 1, 1);

		this.tabWidget.addTab(this.tabDecember,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Dezember", null));

		this.gridLayout_5.addWidget(this.tabWidget, 1, 0, 1, 2);

		this.MainWindowTabWidget.addTab(this.overview,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00dcberblick", null));
		this.transactions = new QWidget();
		this.transactions.setObjectName("transactions");
		this.gridLayout_6 = new QGridLayout(this.transactions);
		this.gridLayout_6.setObjectName("gridLayout_6");
		this.buttonAddTransaction = new QPushButton(this.transactions);
		this.buttonAddTransaction.setObjectName("buttonAddTransaction");

		this.gridLayout_6.addWidget(this.buttonAddTransaction, 0, 2, 1, 1);

		this.tableTransactions = new QTableWidget(this.transactions);
		this.tableTransactions.setObjectName("tableTransactions");
		this.tableTransactions.setLayoutDirection(LayoutDirection.LeftToRight);
		this.tableTransactions.setAutoFillBackground(false);
		this.tableTransactions.setEditTriggers(EditTrigger.createQFlags(EditTrigger.NoEditTriggers));
		this.tableTransactions.setAlternatingRowColors(true);
		this.tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);
		this.tableTransactions.setSortingEnabled(true);
		this.tableTransactions.setRowCount(0);
		this.tableTransactions.setColumnCount(6);

		this.gridLayout_6.addWidget(this.tableTransactions, 1, 0, 1, 3);

		this.horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_6.addItem(this.horizontalSpacer_2, 0, 1, 1, 1);

		this.gridLayout_3 = new QGridLayout();
		this.gridLayout_3.setObjectName("gridLayout_3");
		this.label = new QLabel(this.transactions);
		this.label.setObjectName("label");

		this.gridLayout_3.addWidget(this.label, 0, 0, 1, 1);

		this.comboBoxBankaccountTransaction = new QComboBox(this.transactions);
		this.comboBoxBankaccountTransaction.setObjectName("comboBoxBankaccountTransaction");

		this.gridLayout_3.addWidget(this.comboBoxBankaccountTransaction, 0, 1, 1, 1);

		this.label_2 = new QLabel(this.transactions);
		this.label_2.setObjectName("label_2");

		this.gridLayout_3.addWidget(this.label_2, 1, 0, 1, 1);

		this.dateFrom = new QDateEdit(this.transactions);
		this.dateFrom.setObjectName("dateFrom");
		this.dateFrom.setCalendarPopup(true);

		this.gridLayout_3.addWidget(this.dateFrom, 1, 1, 1, 1);

		this.label_3 = new QLabel(this.transactions);
		this.label_3.setObjectName("label_3");

		this.gridLayout_3.addWidget(this.label_3, 2, 0, 1, 1);

		this.dateUntil = new QDateEdit(this.transactions);
		this.dateUntil.setObjectName("dateUntil");
		this.dateUntil.setCalendarPopup(true);

		this.gridLayout_3.addWidget(this.dateUntil, 2, 1, 1, 1);

		this.gridLayout_6.addLayout(this.gridLayout_3, 0, 0, 1, 1);

		this.pushButtonDelete = new QPushButton(this.transactions);
		this.pushButtonDelete.setObjectName("pushButtonDelete");

		this.gridLayout_6.addWidget(this.pushButtonDelete, 2, 2, 1, 1);

		this.MainWindowTabWidget.addTab(this.transactions,
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));

		this.gridLayout_2.addWidget(this.MainWindowTabWidget, 0, 0, 1, 1);

		MainWindow.setCentralWidget(this.centralwidget);
		this.menubar = new QMenuBar(MainWindow);
		this.menubar.setObjectName("menubar");
		this.menubar.setGeometry(new QRect(0, 0, 1063, 21));
		this.menuDatei = new QMenu(this.menubar);
		this.menuDatei.setObjectName("menuDatei");
		this.menuBearbeiten = new QMenu(this.menubar);
		this.menuBearbeiten.setObjectName("menuBearbeiten");
		MainWindow.setMenuBar(this.menubar);
		this.statusbar = new QStatusBar(MainWindow);
		this.statusbar.setObjectName("statusbar");
		MainWindow.setStatusBar(this.statusbar);

		this.menubar.addAction(this.menuDatei.menuAction());
		this.menubar.addAction(this.menuBearbeiten.menuAction());
		this.menuDatei.addAction(this.actionEinstellungen);
		this.menuDatei.addAction(this.actionBeenden);
		this.menuBearbeiten.addAction(this.actionKonto_erstellen);
		this.menuBearbeiten.addAction(this.actionKontoart_erstellen);
		this.menuBearbeiten.addSeparator();
		this.menuBearbeiten.addAction(this.actionKategorie_erstellen);
		this.retranslateUi(MainWindow);
		this.actionBeenden.triggered.connect(MainWindow, "close()");

		this.MainWindowTabWidget.setCurrentIndex(0);
		this.tabWidget.setCurrentIndex(1);

		MainWindow.connectSlotsByName();
	} // setupUi

	void retranslateUi(final QMainWindow MainWindow) {
		MainWindow.setWindowTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "DimeDiary", null));
		this.actionBeenden.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Beenden", null));
		this.actionEinstellungen
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Einstellungen", null));
		this.actionKonto_erstellen
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto erstellen", null));
		this.actionKontoart_erstellen
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontoart erstellen", null));
		this.actionKategorie_erstellen
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kategorie erstellen", null));
		this.label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto", null));
		this.label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Jahr", null));
		this.tableWidgetBalanceJanuary.clear();
		this.tableWidgetBalanceJanuary.setColumnCount(3);

		final QTableWidgetItem __colItem = new QTableWidgetItem();
		__colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceJanuary.setHorizontalHeaderItem(0, __colItem);

		final QTableWidgetItem __colItem1 = new QTableWidgetItem();
		__colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceJanuary.setHorizontalHeaderItem(1, __colItem1);

		final QTableWidgetItem __colItem2 = new QTableWidgetItem();
		__colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceJanuary.setHorizontalHeaderItem(2, __colItem2);
		this.tableWidgetBalanceJanuary.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabJanuary),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Januar", null));
		this.tableWidgetBalanceFebruar.clear();
		this.tableWidgetBalanceFebruar.setColumnCount(3);

		final QTableWidgetItem __colItem3 = new QTableWidgetItem();
		__colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceFebruar.setHorizontalHeaderItem(0, __colItem3);

		final QTableWidgetItem __colItem4 = new QTableWidgetItem();
		__colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceFebruar.setHorizontalHeaderItem(1, __colItem4);

		final QTableWidgetItem __colItem5 = new QTableWidgetItem();
		__colItem5.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceFebruar.setHorizontalHeaderItem(2, __colItem5);
		this.tableWidgetBalanceFebruar.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabFebruary),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Februar", null));
		this.tableWidgetBalanceMarch.clear();
		this.tableWidgetBalanceMarch.setColumnCount(3);

		final QTableWidgetItem __colItem6 = new QTableWidgetItem();
		__colItem6.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceMarch.setHorizontalHeaderItem(0, __colItem6);

		final QTableWidgetItem __colItem7 = new QTableWidgetItem();
		__colItem7.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceMarch.setHorizontalHeaderItem(1, __colItem7);

		final QTableWidgetItem __colItem8 = new QTableWidgetItem();
		__colItem8.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceMarch.setHorizontalHeaderItem(2, __colItem8);
		this.tableWidgetBalanceMarch.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabMarch),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "M\u00e4rz", null));
		this.tableWidgetBalanceApril.clear();
		this.tableWidgetBalanceApril.setColumnCount(3);

		final QTableWidgetItem __colItem9 = new QTableWidgetItem();
		__colItem9.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceApril.setHorizontalHeaderItem(0, __colItem9);

		final QTableWidgetItem __colItem10 = new QTableWidgetItem();
		__colItem10.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceApril.setHorizontalHeaderItem(1, __colItem10);

		final QTableWidgetItem __colItem11 = new QTableWidgetItem();
		__colItem11.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceApril.setHorizontalHeaderItem(2, __colItem11);
		this.tableWidgetBalanceApril.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabAprile),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "April", null));
		this.tableWidgetBalanceMay.clear();
		this.tableWidgetBalanceMay.setColumnCount(3);

		final QTableWidgetItem __colItem12 = new QTableWidgetItem();
		__colItem12.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceMay.setHorizontalHeaderItem(0, __colItem12);

		final QTableWidgetItem __colItem13 = new QTableWidgetItem();
		__colItem13.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceMay.setHorizontalHeaderItem(1, __colItem13);

		final QTableWidgetItem __colItem14 = new QTableWidgetItem();
		__colItem14.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceMay.setHorizontalHeaderItem(2, __colItem14);
		this.tableWidgetBalanceMay.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabMay),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Mai", null));
		this.tableWidgetBalanceJune.clear();
		this.tableWidgetBalanceJune.setColumnCount(3);

		final QTableWidgetItem __colItem15 = new QTableWidgetItem();
		__colItem15.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceJune.setHorizontalHeaderItem(0, __colItem15);

		final QTableWidgetItem __colItem16 = new QTableWidgetItem();
		__colItem16.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceJune.setHorizontalHeaderItem(1, __colItem16);

		final QTableWidgetItem __colItem17 = new QTableWidgetItem();
		__colItem17.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceJune.setHorizontalHeaderItem(2, __colItem17);
		this.tableWidgetBalanceJune.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabJune),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juni", null));
		this.tableWidgetBalanceJuly.clear();
		this.tableWidgetBalanceJuly.setColumnCount(3);

		final QTableWidgetItem __colItem18 = new QTableWidgetItem();
		__colItem18.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceJuly.setHorizontalHeaderItem(0, __colItem18);

		final QTableWidgetItem __colItem19 = new QTableWidgetItem();
		__colItem19.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceJuly.setHorizontalHeaderItem(1, __colItem19);

		final QTableWidgetItem __colItem20 = new QTableWidgetItem();
		__colItem20.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceJuly.setHorizontalHeaderItem(2, __colItem20);
		this.tableWidgetBalanceJuly.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabJuly),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Juli", null));
		this.tableWidgetBalanceAugust.clear();
		this.tableWidgetBalanceAugust.setColumnCount(3);

		final QTableWidgetItem __colItem21 = new QTableWidgetItem();
		__colItem21.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceAugust.setHorizontalHeaderItem(0, __colItem21);

		final QTableWidgetItem __colItem22 = new QTableWidgetItem();
		__colItem22.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceAugust.setHorizontalHeaderItem(1, __colItem22);

		final QTableWidgetItem __colItem23 = new QTableWidgetItem();
		__colItem23.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceAugust.setHorizontalHeaderItem(2, __colItem23);
		this.tableWidgetBalanceAugust.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabAugust),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "August", null));
		this.tableWidgetBalanceSeptember.clear();
		this.tableWidgetBalanceSeptember.setColumnCount(3);

		final QTableWidgetItem __colItem24 = new QTableWidgetItem();
		__colItem24.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceSeptember.setHorizontalHeaderItem(0, __colItem24);

		final QTableWidgetItem __colItem25 = new QTableWidgetItem();
		__colItem25.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceSeptember.setHorizontalHeaderItem(1, __colItem25);

		final QTableWidgetItem __colItem26 = new QTableWidgetItem();
		__colItem26.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceSeptember.setHorizontalHeaderItem(2, __colItem26);
		this.tableWidgetBalanceSeptember.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabSeptember),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "September", null));
		this.tableWidgetBalanceOctober.clear();
		this.tableWidgetBalanceOctober.setColumnCount(3);

		final QTableWidgetItem __colItem27 = new QTableWidgetItem();
		__colItem27.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceOctober.setHorizontalHeaderItem(0, __colItem27);

		final QTableWidgetItem __colItem28 = new QTableWidgetItem();
		__colItem28.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceOctober.setHorizontalHeaderItem(1, __colItem28);

		final QTableWidgetItem __colItem29 = new QTableWidgetItem();
		__colItem29.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceOctober.setHorizontalHeaderItem(2, __colItem29);
		this.tableWidgetBalanceOctober.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabOctober),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Oktober", null));
		this.tableWidgetBalanceNovember.clear();
		this.tableWidgetBalanceNovember.setColumnCount(3);

		final QTableWidgetItem __colItem30 = new QTableWidgetItem();
		__colItem30.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceNovember.setHorizontalHeaderItem(0, __colItem30);

		final QTableWidgetItem __colItem31 = new QTableWidgetItem();
		__colItem31.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceNovember.setHorizontalHeaderItem(1, __colItem31);

		final QTableWidgetItem __colItem32 = new QTableWidgetItem();
		__colItem32.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceNovember.setHorizontalHeaderItem(2, __colItem32);
		this.tableWidgetBalanceNovember.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabNovember),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "November", null));
		this.tableWidgetBalanceDecember.clear();
		this.tableWidgetBalanceDecember.setColumnCount(3);

		final QTableWidgetItem __colItem33 = new QTableWidgetItem();
		__colItem33.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableWidgetBalanceDecember.setHorizontalHeaderItem(0, __colItem33);

		final QTableWidgetItem __colItem34 = new QTableWidgetItem();
		__colItem34.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableWidgetBalanceDecember.setHorizontalHeaderItem(1, __colItem34);

		final QTableWidgetItem __colItem35 = new QTableWidgetItem();
		__colItem35.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableWidgetBalanceDecember.setHorizontalHeaderItem(2, __colItem35);
		this.tableWidgetBalanceDecember.setRowCount(0);
		this.tabWidget.setTabText(this.tabWidget.indexOf(this.tabDecember),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Dezember", null));
		this.MainWindowTabWidget.setTabText(this.MainWindowTabWidget.indexOf(this.overview),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "\u00dcberblick", null));
		this.buttonAddTransaction
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Transaktion erstellen", null));
		this.tableTransactions.clear();
		this.tableTransactions.setColumnCount(6);

		final QTableWidgetItem __colItem36 = new QTableWidgetItem();
		__colItem36.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datum", null));
		this.tableTransactions.setHorizontalHeaderItem(0, __colItem36);

		final QTableWidgetItem __colItem37 = new QTableWidgetItem();
		__colItem37.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Wochentag", null));
		this.tableTransactions.setHorizontalHeaderItem(1, __colItem37);

		final QTableWidgetItem __colItem38 = new QTableWidgetItem();
		__colItem38.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Betrag", null));
		this.tableTransactions.setHorizontalHeaderItem(2, __colItem38);

		final QTableWidgetItem __colItem39 = new QTableWidgetItem();
		__colItem39.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Betreff", null));
		this.tableTransactions.setHorizontalHeaderItem(3, __colItem39);

		final QTableWidgetItem __colItem40 = new QTableWidgetItem();
		__colItem40.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kategorie", null));
		this.tableTransactions.setHorizontalHeaderItem(4, __colItem40);

		final QTableWidgetItem __colItem41 = new QTableWidgetItem();
		__colItem41.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Kontostand", null));
		this.tableTransactions.setHorizontalHeaderItem(5, __colItem41);
		this.tableTransactions.setRowCount(0);
		this.label.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Konto", null));
		this.label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "von", null));
		this.label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "bis", null));
		this.pushButtonDelete
				.setText(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "L\u00f6schen", null));
		this.MainWindowTabWidget.setTabText(this.MainWindowTabWidget.indexOf(this.transactions),
				com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Ums\u00e4tze", null));
		this.menuDatei.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Datei", null));
		this.menuBearbeiten
				.setTitle(com.trolltech.qt.core.QCoreApplication.translate("MainWindow", "Bearbeiten", null));
	} // retranslateUi

}
