/********************************************************************************
 ** Form generated from reading ui file 'mergecontinuoustransactiondialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;

import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.QDateEdit;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QDialogButtonBox;
import com.trolltech.qt.gui.QDialogButtonBox.StandardButton;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QRadioButton;
import com.trolltech.qt.gui.QSpacerItem;
import com.trolltech.qt.gui.QWidget;

public class UiMergeContinuousTransactionDialog implements com.trolltech.qt.QUiForm<QDialog> {
	public QGridLayout gridLayout_3;
	public QWidget widget;
	public QGridLayout gridLayout_2;
	public QGridLayout gridLayout;
	public QDateEdit dateEdit;
	public QRadioButton radioButtonFrom;
	public QRadioButton radioButtonAll;
	public QSpacerItem verticalSpacer;
	public QSpacerItem horizontalSpacer;
	public QDialogButtonBox buttonBox;
	public QLabel label;

	public UiMergeContinuousTransactionDialog() {
		super();
	}

	@Override
	public void setupUi(final QDialog MergeContinuousTransactionDialog) {
		MergeContinuousTransactionDialog.setObjectName("MergeContinuousTransactionDialog");
		MergeContinuousTransactionDialog
				.resize(new QSize(248, 135).expandedTo(MergeContinuousTransactionDialog.minimumSizeHint()));
		MergeContinuousTransactionDialog.setModal(true);
		this.gridLayout_3 = new QGridLayout(MergeContinuousTransactionDialog);
		this.gridLayout_3.setObjectName("gridLayout_3");
		this.widget = new QWidget(MergeContinuousTransactionDialog);
		this.widget.setObjectName("widget");
		this.gridLayout_2 = new QGridLayout(this.widget);
		this.gridLayout_2.setObjectName("gridLayout_2");
		this.gridLayout = new QGridLayout();
		this.gridLayout.setObjectName("gridLayout");
		this.dateEdit = new QDateEdit(this.widget);
		this.dateEdit.setObjectName("dateEdit");
		this.dateEdit.setCalendarPopup(true);

		this.gridLayout.addWidget(this.dateEdit, 1, 1, 1, 1);

		this.radioButtonFrom = new QRadioButton(this.widget);
		this.radioButtonFrom.setObjectName("radioButtonFrom");

		this.gridLayout.addWidget(this.radioButtonFrom, 1, 0, 1, 1);

		this.radioButtonAll = new QRadioButton(this.widget);
		this.radioButtonAll.setObjectName("radioButtonAll");

		this.gridLayout.addWidget(this.radioButtonAll, 2, 0, 1, 1);

		this.gridLayout_2.addLayout(this.gridLayout, 0, 0, 1, 1);

		this.verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum,
				com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

		this.gridLayout_2.addItem(this.verticalSpacer, 1, 0, 1, 1);

		this.horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_2.addItem(this.horizontalSpacer, 0, 1, 1, 1);

		this.gridLayout_3.addWidget(this.widget, 1, 0, 1, 1);

		this.buttonBox = new QDialogButtonBox(MergeContinuousTransactionDialog);
		this.buttonBox.setObjectName("buttonBox");
		this.buttonBox.setStandardButtons(StandardButton.createQFlags(StandardButton.Cancel, StandardButton.Ok));

		this.gridLayout_3.addWidget(this.buttonBox, 2, 0, 1, 1);

		this.label = new QLabel(MergeContinuousTransactionDialog);
		this.label.setObjectName("label");

		this.gridLayout_3.addWidget(this.label, 0, 0, 1, 1);

		this.retranslateUi(MergeContinuousTransactionDialog);

		MergeContinuousTransactionDialog.connectSlotsByName();
	} // setupUi

	void retranslateUi(final QDialog MergeContinuousTransactionDialog) {
		MergeContinuousTransactionDialog.setWindowTitle(
				com.trolltech.qt.core.QCoreApplication.translate("MergeContinuousTransactionDialog", "Ab wann?", null));
		this.radioButtonFrom.setText(
				com.trolltech.qt.core.QCoreApplication.translate("MergeContinuousTransactionDialog", "ab", null));
		this.radioButtonAll.setText(
				com.trolltech.qt.core.QCoreApplication.translate("MergeContinuousTransactionDialog", "Alle", null));
		this.label.setText(com.trolltech.qt.core.QCoreApplication.translate("MergeContinuousTransactionDialog",
				"Welche Transaktionen sollen ver\u00e4ndert werden?", null));
	} // retranslateUi

}
