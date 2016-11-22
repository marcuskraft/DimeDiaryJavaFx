package com.dimediary.view.design.tables;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.dimediary.controller.balance.AccountBalancer;
import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;

public class TableTransactions {

	protected final QTableWidget tableWidget;

	protected final ArrayList<TableTransactionItem> items;

	protected ArrayList<Transaction> transactions;

	public TableTransactions(final QTableWidget tableWidget) {
		this.tableWidget = tableWidget;
		this.items = new ArrayList<>();
		this.transactions = new ArrayList<>();
	}

	public void updateTransactionTable() {
		this.items.clear();
		this.tableWidget.setRowCount(this.transactions.size());
		for (int i = 0; i < this.transactions.size(); i++) {
			final Transaction transaction = this.transactions.get(i);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			final String date = simpleDateFormat.format(transaction.getDate());
			simpleDateFormat = new SimpleDateFormat("E");
			final String weekDay = simpleDateFormat.format(transaction.getDate());
			final String amount = transaction.getAmount().toString().replace(".", ",");
			final String name = transaction.getName();
			final String category = transaction.getCategory() != null ? transaction.getCategory().getName() : "-";
			String balance = AccountBalancer.getBalance(transaction.getBankAccount(), transaction.getDate()).toString();

			balance = balance != null ? balance : "";

			this.addItem(i, 0, new TableTransactionItem(date, transaction));
			this.addItem(i, 1, new TableTransactionItem(weekDay, transaction));
			this.addItem(i, 2, new TableTransactionItem(amount, transaction));
			this.addItem(i, 3, new TableTransactionItem(name, transaction));
			this.addItem(i, 4, new TableTransactionItem(category, transaction));
			this.addItem(i, 5, new TableTransactionItem(balance, transaction));
		}
	}

	public void addTransaction(final Transaction transaction) {
		if (this.transactions.contains(transaction)) {
			return;
		}
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

	protected void addItem(final Integer row, final Integer column, final TableTransactionItem item) {
		this.items.add(item);
		this.tableWidget.setItem(row, column, item);
	}

	public ArrayList<Transaction> getSelectedTransactions() {
		final ArrayList<Transaction> transactions = new ArrayList<>();

		for (final QTableWidgetItem qTableWidgetItem : this.tableWidget.selectedItems()) {
			final Transaction transaction = ((TableTransactionItem) qTableWidgetItem).getTransaction();
			if (transactions.contains(transaction)) {
				continue;
			}
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
