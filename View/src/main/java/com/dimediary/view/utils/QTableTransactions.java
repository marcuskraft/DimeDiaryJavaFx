package com.dimediary.view.utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Transaction;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;

public class QTableTransactions {

	private final QTableWidget tableWidget;

	private final ArrayList<QTableTransactionItem> items;

	private ArrayList<Transaction> transactions;

	public QTableTransactions(final QTableWidget tableWidget) {
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

	public void updateTransactionTable(final Date dateFrom, final Date dateUntil, final String bankAccountName) {
		this.transactions = new ArrayList<Transaction>(
				DBUtils.getInstance().geTransactions(dateFrom, dateUntil, bankAccountName));
		this.updateTransactionTable();
	}

	public void updateTransactionTable() {
		// table.clear();
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
			final String category = transaction.getCategory().getName();

			this.addItem(i, 0, new QTableTransactionItem(date, transaction));
			this.addItem(i, 1, new QTableTransactionItem(weekDay, transaction));
			this.addItem(i, 2, new QTableTransactionItem(amount, transaction));
			this.addItem(i, 3, new QTableTransactionItem(name, transaction));
			this.addItem(i, 4, new QTableTransactionItem(category, transaction));
		}
	}

	private void addItem(final Integer row, final Integer column, final QTableTransactionItem item) {
		this.items.add(item);
		this.tableWidget.setItem(row, column, item);
	}

	public ArrayList<Transaction> getSelectedTransactions() {
		final ArrayList<Transaction> transactions = new ArrayList<>();

		for (final QTableWidgetItem qTableWidgetItem : this.tableWidget.selectedItems()) {
			final Transaction transaction = ((QTableTransactionItem) qTableWidgetItem).getTransaction();
			transactions.add(transaction);
		}

		return transactions;
	}

	public Transaction getTransaction(final Integer row, final Integer column) {
		final QTableWidgetItem qTableWidgetItem = this.tableWidget.item(row, column);
		return ((QTableTransactionItem) qTableWidgetItem).getTransaction();
	}

	public ArrayList<QTableTransactionItem> getItems() {
		return this.items;
	}

	public ArrayList<Transaction> getTransactions() {
		return this.transactions;
	}

}
