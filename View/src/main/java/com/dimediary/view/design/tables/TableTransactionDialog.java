package com.dimediary.view.design.tables;

import java.text.SimpleDateFormat;

import com.dimediary.model.entities.Transaction;
import com.trolltech.qt.gui.QTableWidget;

public class TableTransactionDialog extends TableTransactions {

	public TableTransactionDialog(final QTableWidget tableWidget) {
		super(tableWidget);
	}

	@Override
	public void updateTransactionTable() {
		this.items.clear();
		this.tableWidget.setRowCount(this.transactions.size());
		for (int i = 0; i < this.transactions.size(); i++) {
			final Transaction transaction = this.transactions.get(i);

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
			final String date = simpleDateFormat.format(transaction.getDate());
			simpleDateFormat = new SimpleDateFormat("E");
			final String account = transaction.getBankAccount().getName();
			final String amount = transaction.getAmount().toString().replace(".", ",");
			final String name = transaction.getName();

			final String category = transaction.getCategory() != null ? transaction.getCategory().getName() : "-";

			this.addItem(i, 0, new TableTransactionItem(date, transaction));
			this.addItem(i, 1, new TableTransactionItem(name, transaction));
			this.addItem(i, 2, new TableTransactionItem(amount, transaction));
			this.addItem(i, 3, new TableTransactionItem(category, transaction));
			this.addItem(i, 4, new TableTransactionItem(account, transaction));
		}
	}

}
