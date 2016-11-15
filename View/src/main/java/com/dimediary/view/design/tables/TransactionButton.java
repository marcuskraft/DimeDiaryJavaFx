package com.dimediary.view.design.tables;

import com.dimediary.model.entities.Transaction;
import com.trolltech.qt.gui.QPushButton;

public class TransactionButton extends QPushButton {

	private final Transaction transaction;

	public TransactionButton(final String text, final Transaction transaction) {
		super();
		this.transaction = transaction;
		this.setText(text);
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

}
