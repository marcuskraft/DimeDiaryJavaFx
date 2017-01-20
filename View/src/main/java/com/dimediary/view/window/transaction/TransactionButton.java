package com.dimediary.view.window.transaction;

import com.dimediary.model.entities.Transaction;

import javafx.scene.control.Button;

public class TransactionButton extends Button {

	private final Transaction transaction;

	public TransactionButton(final String text, final Transaction transaction) {
		super(text);
		this.transaction = transaction;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

}
