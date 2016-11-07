package com.dimediary.view.utils;

import com.dimediary.model.entities.Transaction;
import com.trolltech.qt.gui.QTableWidgetItem;

public class QTableTransactionItem extends QTableWidgetItem {

	private final Transaction transaction;

	public QTableTransactionItem(final String text, final Transaction transaction) {
		super(text);
		this.transaction = transaction;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

}
