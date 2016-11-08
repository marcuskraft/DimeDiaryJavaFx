package com.dimediary.view.design;

import java.util.ArrayList;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.ui.UiMainWindow;
import com.dimediary.view.main.Main;
import com.dimediary.view.utils.QTUtils;
import com.dimediary.view.utils.TableTransactionsMainWindow;
import com.trolltech.qt.core.QDate;
import com.trolltech.qt.gui.QApplication;
import com.trolltech.qt.gui.QMainWindow;

public class MainWindow extends UiMainWindow {

	private final QMainWindow window;
	private final TableTransactionsMainWindow ownTableTransactions;

	public MainWindow() {
		super();
		this.window = new QMainWindow();
		this.setupUi(this.window);
		this.ownTableTransactions = new TableTransactionsMainWindow(this.tableTransactions);

		this.initTableTransaction();

		this.window.show();

		QApplication.setActiveWindow(this.window);
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

		this.initComboBocAccounts();

		// fill the table with the transactions between the two dates for the
		// selected bank account
		this.updateTransactionsTable();
	}

	public void initComboBocAccounts() {
		// set the possible bank accounts in the combo box
		final ArrayList<String> bankAccountNames = DBUtils.getInstance().getBankAccountNames();
		// TODO if no bankAccounts exists ask the user to add bank account
		this.comboBoxBankaccount.clear();
		this.comboBoxBankaccount.addItems(bankAccountNames);
	}

	public void updateTransactionsTable() {
		this.ownTableTransactions.updateTransactionTable(QTUtils.qDateToDate(this.dateFrom.date()),
				QTUtils.qDateToDate(this.dateUntil.date()),
				this.comboBoxBankaccount.itemText(this.comboBoxBankaccount.currentIndex()));
	}

	public void onDoubleClickRow(final Integer row, final Integer column) {
		Main.getTransactionDialog().initialize(this.ownTableTransactions.getTransaction(row, column));
	}

	public void OnDeleteTransaction() {
		final ArrayList<Transaction> transactionsToDelete = this.ownTableTransactions.getSelectedTransactions();
		DBUtils.getInstance().deleteTransactions(transactionsToDelete);
		this.ownTableTransactions.deleteTransactions(transactionsToDelete);
		Main.getTransactionDialog().deleteTransactions(transactionsToDelete);
	}

	public void createTrigger() {
		// menu buttons
		this.actionBeenden.triggered.connect(Main.getApplication(), "exit()");
		this.actionKonto_erstellen.triggered.connect(Main.getBankAccountDialog(), "exec()");
		this.actionKontoart_erstellen.triggered.connect(Main.getAccountCategoryDialog(), "exec()");
		this.actionKategorie_erstellen.triggered.connect(Main.getCategoryDialog(), "exec()");

		this.pushButtonDelete.clicked.connect(this, "OnDeleteTransaction()");

		this.comboBoxBankaccount.currentIndexChanged.connect(this, "updateTransactionsTable()");
		this.dateFrom.dateChanged.connect(this, "updateTransactionsTable()");
		this.dateUntil.dateChanged.connect(this, "updateTransactionsTable()");

		this.tableTransactions.cellDoubleClicked.connect(this,
				"onDoubleClickRow(java.lang.Integer, java.lang.Integer)");

		this.buttonAddTransaction.clicked.connect(Main.getTransactionDialog(), "initialize()");
		this.buttonAddTransaction.clicked.connect(Main.getTransactionDialog(), "exec()");
	}

}
