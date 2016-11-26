package com.dimediary.view.design.tables;

import com.dimediary.model.entities.Transaction;
import com.dimediary.view.main.Main;
import com.trolltech.qt.gui.QPushButton;

public class TransactionButton extends QPushButton {

	private final Transaction transaction;

	public TransactionButton(final String text, final Transaction transaction) {
		super();
		this.transaction = transaction;
		this.setText(text);

		this.clicked.connect(this, "onClick()");

	}

	public void onClick() {
		Main.getTransactionDialog().openTransactionDialog(this.transaction);
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

}
