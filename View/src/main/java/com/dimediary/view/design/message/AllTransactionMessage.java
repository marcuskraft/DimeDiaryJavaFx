package com.dimediary.view.design.message;

import com.dimediary.model.entities.Transaction;
import com.dimediary.view.design.ui.UiallTransactionsMessage;
import com.dimediary.view.main.Main;
import com.trolltech.qt.gui.QDialog;

public class AllTransactionMessage extends UiallTransactionsMessage {

	private final QDialog dialog;
	Transaction transaction;

	public AllTransactionMessage(final Transaction transaction) {
		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.transaction = transaction;

		this.createTrigger();

		this.dialog.exec();
	}

	private void createTrigger() {
		this.pushButtonCancel.clicked.connect(this.dialog, "close()");

		this.pushButtonAll.clicked.connect(this.dialog, "close()");
		this.pushButtonAll.clicked.connect(this, "onButtonAll()");

		this.pushButtonOnlyThis.clicked.connect(this.dialog, "close()");
		this.pushButtonOnlyThis.clicked.connect(this, "onBottonOnlyThis()");

	}

	public void onButtonAll() {
		Main.getTransactionDialog().initialize(this.transaction.getContinuousTransaction());
	}

	public void onBottonOnlyThis() {
		Main.getTransactionDialog().initialize(this.transaction);
	}

	public QDialog getDialog() {
		return this.dialog;
	}

}
