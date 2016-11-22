package com.dimediary.view.design;

import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.controller.utils.DateUtils;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.message.AllTransactionMessage;
import com.dimediary.view.design.tables.TableMonthOverview;
import com.dimediary.view.design.tables.TableTransactions;
import com.dimediary.view.design.ui.UiMainWindow;
import com.dimediary.view.main.Main;
import com.dimediary.view.utils.QTUtils;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QWidget;

public class MainWindow extends UiMainWindow {

	private final QMainWindow window;
	private final TableTransactions ownTableTransactions;
	private TableMonthOverview tableMonthOverview;

	public MainWindow() {
		super();
		this.window = new QMainWindow();
		this.setupUi(this.window);
		this.ownTableTransactions = new TableTransactions(this.tableTransactions);

		this.window.show();

		QApplication.setActiveWindow(this.window);
	}

	public void initialize() {
		this.initTableTransaction();
		this.initOverview();
	}

	private void initTableTransaction() {
		// set date range for the shown transactions
		QDate today = new QDate();
		today = QDate.currentDate();
		final QDate qdateFrom = today.addDays(-30); // TODO read this option
													// from
													// option file
		final QDate qdateUntil = today.addDays(30);
		this.dateFrom.setDate(qdateFrom);
		this.dateUntil.setDate(qdateUntil);

		this.initComboBoxAccounts();

		// fill the table with the transactions between the two dates for the
		// selected bank account
		this.updateTransactionsTable();
	}

	public void initComboBoxAccounts() {
		// set the possible bank accounts in the combo box
		final ArrayList<String> bankAccountNames = DBUtils.getInstance().getBankAccountNames();
		// TODO if no bankAccounts exists ask the user to add bank account
		this.comboBoxBankaccountTransaction.clear();
		this.comboBoxBankaccountTransaction.addItems(bankAccountNames);
		this.comboBoxBankaccountOverview.clear();
		this.comboBoxBankaccountOverview.addItems(bankAccountNames);
	}

	public void updateTransactionsTable() {
		this.ownTableTransactions.updateTransactionTable(QTUtils.qDateToDate(this.dateFrom.date()),
				QTUtils.qDateToDate(this.dateUntil.date()),
				this.comboBoxBankaccountTransaction.itemText(this.comboBoxBankaccountTransaction.currentIndex()));
	}

	private void initOverview() {
		final HashMap<Month, QTableWidget> tablesOverview = new HashMap<>();

		tablesOverview.put(Month.JANUARY, this.tableWidgetBalanceJanuary);
		tablesOverview.put(Month.FEBRUARY, this.tableWidgetBalanceFebruar);
		tablesOverview.put(Month.MARCH, this.tableWidgetBalanceMarch);
		tablesOverview.put(Month.APRIL, this.tableWidgetBalanceApril);
		tablesOverview.put(Month.MAY, this.tableWidgetBalanceMay);
		tablesOverview.put(Month.JUNE, this.tableWidgetBalanceJune);
		tablesOverview.put(Month.JULY, this.tableWidgetBalanceJuly);
		tablesOverview.put(Month.AUGUST, this.tableWidgetBalanceAugust);
		tablesOverview.put(Month.SEPTEMBER, this.tableWidgetBalanceSeptember);
		tablesOverview.put(Month.OCTOBER, this.tableWidgetBalanceOctober);
		tablesOverview.put(Month.NOVEMBER, this.tableWidgetBalanceNovember);
		tablesOverview.put(Month.DECEMBER, this.tableWidgetBalanceDecember);

		final HashMap<Month, QWidget> tabs = new HashMap<>();

		tabs.put(Month.JANUARY, this.tabJanuary);
		tabs.put(Month.FEBRUARY, this.tabFebruary);
		tabs.put(Month.MARCH, this.tabMarch);
		tabs.put(Month.APRIL, this.tabAprile);
		tabs.put(Month.MAY, this.tabMay);
		tabs.put(Month.JUNE, this.tabJune);
		tabs.put(Month.JULY, this.tabJuly);
		tabs.put(Month.AUGUST, this.tabAugust);
		tabs.put(Month.SEPTEMBER, this.tabSeptember);
		tabs.put(Month.OCTOBER, this.tabOctober);
		tabs.put(Month.NOVEMBER, this.tabNovember);
		tabs.put(Month.DECEMBER, this.tabDecember);

		this.spinBoxYear.setValue(DateUtils.getActualYear());
		this.tableMonthOverview = new TableMonthOverview(tablesOverview, tabs, this.tabWidget);

		final Month actualMonth = DateUtils.getActualMonth();
		this.tabWidget.setCurrentWidget(tabs.get(actualMonth));

		this.updateOverview(actualMonth);

	}

	public void update() {
		this.updateTransactionsTable();
		this.tableMonthOverview.updateMonthOverview();
	}

	public void updateOverview(final Month month) {
		this.tableMonthOverview.updateMonthOverview(month);
	}

	public void onDoubleClickRowTransactionView(final Integer row, final Integer column) {
		final Transaction transaction = this.ownTableTransactions.getTransaction(row, column);
		if (transaction.getContinuousTransaction() != null) {
			new AllTransactionMessage(transaction);
		} else {
			Main.getTransactionDialog().initialize(transaction);
		}

	}

	public void onButtonBack() {
		final boolean yearChange = this.tableMonthOverview.monthBack();
		if (yearChange) {
			this.spinBoxYear.setValue(this.spinBoxYear.value() - 1);
		}
	}

	public void onButtonForward() {
		final boolean yearChange = this.tableMonthOverview.monthForward();
		if (yearChange) {
			this.spinBoxYear.setValue(this.spinBoxYear.value() + 1);
		}
	}

	public void OnDeleteTransaction() {
		final ArrayList<Transaction> transactionsToDelete = this.ownTableTransactions.getSelectedTransactions();
		DBUtils.getInstance().deleteTransactions(transactionsToDelete);
		this.ownTableTransactions.deleteTransactions(transactionsToDelete);
	}

	public void createTrigger() {
		// menu buttons
		this.actionBeenden.triggered.connect(Main.getApplication(), "exit()");
		this.actionKonto_erstellen.triggered.connect(Main.getBankAccountDialog(), "exec()");
		this.actionKontoart_erstellen.triggered.connect(Main.getAccountCategoryDialog(), "exec()");
		this.actionKategorie_erstellen.triggered.connect(Main.getCategoryDialog(), "exec()");

		this.pushButtonDelete.clicked.connect(this, "OnDeleteTransaction()");

		this.pushButtonBack.clicked.connect(this, "onButtonBack()");
		this.pushButtonForward.clicked.connect(this, "onButtonForward()");

		this.comboBoxBankaccountTransaction.currentIndexChanged.connect(this, "updateTransactionsTable()");
		this.dateFrom.dateChanged.connect(this, "updateTransactionsTable()");
		this.dateUntil.dateChanged.connect(this, "updateTransactionsTable()");

		this.tableTransactions.cellDoubleClicked.connect(this,
				"onDoubleClickRowTransactionView(java.lang.Integer, java.lang.Integer)");

		this.buttonAddTransaction.clicked.connect(Main.getTransactionDialog(), "initialize()");
		this.buttonAddTransaction.clicked.connect(Main.getTransactionDialog(), "exec()");

		this.pushButtonAddTransactionOverview.clicked.connect(Main.getTransactionDialog(), "initialize()");
		this.pushButtonAddTransactionOverview.clicked.connect(Main.getTransactionDialog(), "exec()");

		this.tableMonthOverview.createTrigger();
	}

	public TableTransactions getOwnTableTransactions() {
		return this.ownTableTransactions;
	}

	public TableMonthOverview getTableMonthOverview() {
		return this.tableMonthOverview;
	}

}
