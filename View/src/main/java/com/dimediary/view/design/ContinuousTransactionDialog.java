package com.dimediary.view.design;

import com.dimediary.view.design.ui.UiContinuousTransactionDialog;
import com.trolltech.qt.gui.QDialog;

public class ContinuousTransactionDialog extends UiContinuousTransactionDialog {

	private final QDialog dialog;

	public ContinuousTransactionDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.radioButtonMonthly.setChecked(true);
		this.groupBoxDayli.setVisible(false);

	}

	public void createTrigger() {
		this.radioButtonDayli.clicked.connect(this, "onButtonDayli()");
		this.radioButtonMonthly.clicked.connect(this, "onButtonMonthly()");
	}

	public void onButtonMonthly() {
		this.groupBoxDayli.setVisible(false);
		this.groupBoxMonthly.setVisible(true);
	}

	public void onButtonDayli() {
		this.groupBoxDayli.setVisible(true);
		this.groupBoxMonthly.setVisible(false);
	}

	public void exec() {
		this.dialog.exec();
	}

}
