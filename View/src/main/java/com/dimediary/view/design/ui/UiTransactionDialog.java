/********************************************************************************
 ** Form generated from reading ui file 'transactiondialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;

import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.QAbstractItemView.SelectionBehavior;
import com.trolltech.qt.gui.QCheckBox;
import com.trolltech.qt.gui.QComboBox;
import com.trolltech.qt.gui.QDateEdit;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QDoubleSpinBox;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QSpacerItem;
import com.trolltech.qt.gui.QTableWidget;
import com.trolltech.qt.gui.QTableWidgetItem;
import com.trolltech.qt.gui.QWidget;

public class UiTransactionDialog implements com.trolltech.qt.QUiForm<QDialog> {
	public QGridLayout gridLayout_2;
	public QGridLayout gridLayout;
	public QLineEdit subjectEdit;
	public QComboBox comboBoxAccount;
	public QLabel label_5;
	public QDateEdit dateEdit;
	public QLabel label_3;
	public QLabel label_2;
	public QLabel label_4;
	public QPushButton pushButtonAddAccount;
	public QCheckBox checkBoxIncome;
	public QComboBox comboBoxCategory;
	public QPushButton pushButtonAddCategory;
	public QLabel label;
	public QDoubleSpinBox doubleSpinBoxAmount;
	public QSpacerItem horizontalSpacer;
	public QPushButton pushButtonAdd;
	public QPushButton pushButtonOK;
	public QTableWidget tableTransactions;
	public QPushButton pushButtonDelete;
	public QSpacerItem horizontalSpacer_2;
	public QSpacerItem horizontalSpacer_3;

	public UiTransactionDialog() {
		super();
	}

	@Override
	public void setupUi(final QDialog TransactionDialog) {
		TransactionDialog.setObjectName("TransactionDialog");
		TransactionDialog.resize(new QSize(570, 485).expandedTo(TransactionDialog.minimumSizeHint()));
		this.gridLayout_2 = new QGridLayout(TransactionDialog);
		this.gridLayout_2.setObjectName("gridLayout_2");
		this.gridLayout = new QGridLayout();
		this.gridLayout.setObjectName("gridLayout");
		this.subjectEdit = new QLineEdit(TransactionDialog);
		this.subjectEdit.setObjectName("subjectEdit");

		this.gridLayout.addWidget(this.subjectEdit, 1, 2, 1, 1);

		this.comboBoxAccount = new QComboBox(TransactionDialog);
		this.comboBoxAccount.setObjectName("comboBoxAccount");

		this.gridLayout.addWidget(this.comboBoxAccount, 3, 2, 1, 1);

		this.label_5 = new QLabel(TransactionDialog);
		this.label_5.setObjectName("label_5");

		this.gridLayout.addWidget(this.label_5, 4, 1, 1, 1);

		this.dateEdit = new QDateEdit(TransactionDialog);
		this.dateEdit.setObjectName("dateEdit");
		this.dateEdit.setCalendarPopup(true);

		this.gridLayout.addWidget(this.dateEdit, 0, 2, 1, 1);

		this.label_3 = new QLabel(TransactionDialog);
		this.label_3.setObjectName("label_3");

		this.gridLayout.addWidget(this.label_3, 2, 1, 1, 1);

		this.label_2 = new QLabel(TransactionDialog);
		this.label_2.setObjectName("label_2");

		this.gridLayout.addWidget(this.label_2, 1, 1, 1, 1);

		this.label_4 = new QLabel(TransactionDialog);
		this.label_4.setObjectName("label_4");

		this.gridLayout.addWidget(this.label_4, 3, 1, 1, 1);

		this.pushButtonAddAccount = new QPushButton(TransactionDialog);
		this.pushButtonAddAccount.setObjectName("pushButtonAddAccount");

		this.gridLayout.addWidget(this.pushButtonAddAccount, 3, 3, 1, 1);

		this.checkBoxIncome = new QCheckBox(TransactionDialog);
		this.checkBoxIncome.setObjectName("checkBoxIncome");

		this.gridLayout.addWidget(this.checkBoxIncome, 4, 3, 1, 1);

		this.comboBoxCategory = new QComboBox(TransactionDialog);
		this.comboBoxCategory.setObjectName("comboBoxCategory");

		this.gridLayout.addWidget(this.comboBoxCategory, 2, 2, 1, 1);

		this.pushButtonAddCategory = new QPushButton(TransactionDialog);
		this.pushButtonAddCategory.setObjectName("pushButtonAddCategory");

		this.gridLayout.addWidget(this.pushButtonAddCategory, 2, 3, 1, 1);

		this.label = new QLabel(TransactionDialog);
		this.label.setObjectName("label");

		this.gridLayout.addWidget(this.label, 0, 1, 1, 1);

		this.doubleSpinBoxAmount = new QDoubleSpinBox(TransactionDialog);
		this.doubleSpinBoxAmount.setObjectName("doubleSpinBoxAmount");
		this.doubleSpinBoxAmount.setMinimum(-1e+09);
		this.doubleSpinBoxAmount.setMaximum(1e+09);

		this.gridLayout.addWidget(this.doubleSpinBoxAmount, 4, 2, 1, 1);

		this.gridLayout_2.addLayout(this.gridLayout, 2, 0, 1, 1);

		this.horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_2.addItem(this.horizontalSpacer, 2, 2, 1, 1);

		this.pushButtonAdd = new QPushButton(TransactionDialog);
		this.pushButtonAdd.setObjectName("pushButtonAdd");

		this.gridLayout_2.addWidget(this.pushButtonAdd, 3, 0, 1, 1);

		this.pushButtonOK = new QPushButton(TransactionDialog);
		this.pushButtonOK.setObjectName("pushButtonOK");

		this.gridLayout_2.addWidget(this.pushButtonOK, 3, 2, 1, 1);

		this.tableTransactions = new QTableWidget(TransactionDialog);
		this.tableTransactions.setObjectName("tableTransactions");
		this.tableTransactions.setSelectionBehavior(SelectionBehavior.SelectRows);

		this.gridLayout_2.addWidget(this.tableTransactions, 1, 0, 1, 3);

		this.pushButtonDelete = new QPushButton(TransactionDialog);
		this.pushButtonDelete.setObjectName("pushButtonDelete");

		this.gridLayout_2.addWidget(this.pushButtonDelete, 0, 0, 1, 1);

		this.horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_2.addItem(this.horizontalSpacer_2, 3, 1, 1, 1);

		this.horizontalSpacer_3 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_2.addItem(this.horizontalSpacer_3, 0, 1, 1, 2);

		QWidget.setTabOrder(this.dateEdit, this.subjectEdit);
		QWidget.setTabOrder(this.subjectEdit, this.comboBoxCategory);
		QWidget.setTabOrder(this.comboBoxCategory, this.comboBoxAccount);
		QWidget.setTabOrder(this.comboBoxAccount, this.doubleSpinBoxAmount);
		QWidget.setTabOrder(this.doubleSpinBoxAmount, this.pushButtonAddCategory);
		QWidget.setTabOrder(this.pushButtonAddCategory, this.pushButtonAddAccount);
		QWidget.setTabOrder(this.pushButtonAddAccount, this.checkBoxIncome);
		QWidget.setTabOrder(this.checkBoxIncome, this.pushButtonAdd);
		QWidget.setTabOrder(this.pushButtonAdd, this.tableTransactions);
		QWidget.setTabOrder(this.tableTransactions, this.pushButtonOK);
		this.retranslateUi(TransactionDialog);
		this.pushButtonOK.clicked.connect(TransactionDialog, "accept()");

		TransactionDialog.connectSlotsByName();
	} // setupUi

	void retranslateUi(final QDialog TransactionDialog) {
		TransactionDialog.setWindowTitle(
				com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion erstellen", null));
		this.label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
		this.label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
		this.label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
		this.label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
		this.pushButtonAddAccount
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
		this.checkBoxIncome
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Einnahme", null));
		this.pushButtonAddCategory
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
		this.label.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
		this.pushButtonAdd.setText(
				com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Hinzuf\u00fcgen", null));
		this.pushButtonOK.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "OK", null));
		this.tableTransactions.clear();
		this.tableTransactions.setColumnCount(5);

		final QTableWidgetItem __colItem = new QTableWidgetItem();
		__colItem.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
		this.tableTransactions.setHorizontalHeaderItem(0, __colItem);

		final QTableWidgetItem __colItem1 = new QTableWidgetItem();
		__colItem1.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
		this.tableTransactions.setHorizontalHeaderItem(1, __colItem1);

		final QTableWidgetItem __colItem2 = new QTableWidgetItem();
		__colItem2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
		this.tableTransactions.setHorizontalHeaderItem(2, __colItem2);

		final QTableWidgetItem __colItem3 = new QTableWidgetItem();
		__colItem3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
		this.tableTransactions.setHorizontalHeaderItem(3, __colItem3);

		final QTableWidgetItem __colItem4 = new QTableWidgetItem();
		__colItem4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
		this.tableTransactions.setHorizontalHeaderItem(4, __colItem4);
		this.tableTransactions.setRowCount(0);
		this.pushButtonDelete.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog",
				"Markierte Transaktionen L\u00f6schen", null));
	} // retranslateUi

}
