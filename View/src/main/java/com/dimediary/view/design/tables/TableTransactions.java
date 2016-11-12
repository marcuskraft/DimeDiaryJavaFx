package com.dimediary.view.design.tables;

import java.util.ArrayList;
import java.util.Date;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;

public abstract class TableTransactions {

	protected final QTableWidget tableWidget;

	protected final ArrayList<TableTransactionItem> items;

	protected ArrayList<Transaction> transactions;

	public TableTransactions(final QTableWidget tableWidget) {
		this.tableWidget = tableWidget;
		this.items = new ArrayList<>();
		this.transactions = new ArrayList<>();
	}

	public void addTransaction(final Transaction transaction) {
		this.transactions.add(transaction);
		this.updateTransactionTable();
	}

	public void deleteTransaction(final Transaction transaction) {
		this.transactions.remove(transaction);
		this.updateTransactionTable();
	}

	public void deleteTransactions(final ArrayList<Transaction> transactions) {
		for (final Transaction transaction : transactions) {
			this.deleteTransaction(transaction);
		}
	}

	public void updateTransactionTable(final Date dateFrom, final Date dateUntil, final String bankAccountName) {
		this.transactions = new ArrayList<Transaction>(
				DBUtils.getInstance().getTransactions(dateFrom, dateUntil, bankAccountName));
		this.updateTransactionTable();
	}

	public abstract void updateTransactionTable();

	protected void addItem(final Integer row, final Integer column, final TableTransactionItem item) {
		this.items.add(item);
		this.tableWidget.setItem(row, column, item);
	}

	public ArrayList<Transaction> getSelectedTransactions() {
		final ArrayList<Transaction> transactions = new ArrayList<>();

		for (final QTableWidgetItem qTableWidgetItem : this.tableWidget.selectedItems()) {
			final Transaction transaction = ((TableTransactionItem) qTableWidgetItem).getTransaction();
			transactions.add(transaction);
		}

		return transactions;
	}

	public Transaction getTransaction(final Integer row, final Integer column) {
		final QTableWidgetItem qTableWidgetItem = this.tableWidget.item(row, column);
		return ((TableTransactionItem) qTableWidgetItem).getTransaction();
	}

	public ArrayList<TableTransactionItem> getItems() {
		return this.items;
	}

	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}

}
