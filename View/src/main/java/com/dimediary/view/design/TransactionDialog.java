package com.dimediary.view.design;

import com.dimediary.view.design.ui.UiTransactionDialog;
import com.trolltech.qt.gui.QDialog;

public class TransactionDialog extends UiTransactionDialog {

	private final QDialog dialog;

	public TransactionDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);
		// TODO Auto-generated constructor stub
	}

	public int exec() {
		return this.dialog.exec();
	}

}
