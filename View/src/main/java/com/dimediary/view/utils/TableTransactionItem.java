package com.dimediary.view.utils;

import com.dimediary.model.entities.Transaction;
import com.trolltech.qt.gui.QTableWidgetItem;

public class TableTransactionItem extends QTableWidgetItem {

	private final Transaction transaction;

	public TableTransactionItem(final String text, final Transaction transaction) {
		super(text);
		this.transaction = transaction;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

}
