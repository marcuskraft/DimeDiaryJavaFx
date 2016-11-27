/********************************************************************************
 ** Form generated from reading ui file 'transactiondialog.jui'
 **
 ** Created by: Qt User Interface Compiler version 4.8.7
 **
 ** WARNING! All changes made in this file will be lost when recompiling ui file!
 ********************************************************************************/
package com.dimediary.view.design.ui;

import com.trolltech.qt.core.QSize;
import com.trolltech.qt.gui.QCheckBox;
import com.trolltech.qt.gui.QComboBox;
import com.trolltech.qt.gui.QDateEdit;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QDoubleSpinBox;
import com.trolltech.qt.gui.QFrame;
import com.trolltech.qt.gui.QGridLayout;
import com.trolltech.qt.gui.QGroupBox;
import com.trolltech.qt.gui.QLabel;
import com.trolltech.qt.gui.QLayout.SizeConstraint;
import com.trolltech.qt.gui.QLineEdit;
import com.trolltech.qt.gui.QPushButton;
import com.trolltech.qt.gui.QSizePolicy;
import com.trolltech.qt.gui.QSpacerItem;
import com.trolltech.qt.gui.QWidget;

public class UiTransactionDialog implements com.trolltech.qt.QUiForm<QDialog>

{
	public QGridLayout gridLayout;
	public QGridLayout gridLayoutMain;
	public QWidget widgetOK;
	public QGridLayout gridLayout_3;
	public QPushButton pushButtonDelete;
	public QPushButton pushButtonAdd;
	public QPushButton pushButtonOK;
	public QSpacerItem verticalSpacer;
	public QSpacerItem horizontalSpacer;
	public QPushButton pushButtonModify;
	public QGroupBox groupBoxTransaction;
	public QGridLayout gridLayout_5;
	public QWidget widgetTransactionData;
	public QGridLayout gridLayout_7;
	public QGridLayout gridLayout_2;
	public QLineEdit subjectEdit;
	public QLabel label;
	public QPushButton pushButtonAddAccount;
	public QLabel label_3;
	public QComboBox comboBoxAccount;
	public QLabel label_5;
	public QDoubleSpinBox doubleSpinBoxAmount;
	public QLabel label_4;
	public QDateEdit dateEdit;
	public QCheckBox checkBoxIncome;
	public QComboBox comboBoxCategory;
	public QPushButton pushButtonAddCategory;
	public QLabel label_2;
	public QCheckBox checkBoxNoCategory;
	public QCheckBox checkBoxNoAccount;
	public QSpacerItem horizontalSpacer_3;
	public QFrame frameIterateButton;
	public QGridLayout gridLayout_4;
	public QSpacerItem horizontalSpacer_2;
	public QCheckBox checkBoxIterate;
	public QWidget widget;

	public UiTransactionDialog() {
		super();
	}

	@Override
	public void setupUi(final QDialog TransactionDialog) {
		TransactionDialog.setObjectName("TransactionDialog");
		TransactionDialog.resize(new QSize(398, 308).expandedTo(TransactionDialog.minimumSizeHint()));
		final QSizePolicy sizePolicy = new QSizePolicy(com.trolltech.qt.gui.QSizePolicy.Policy.Preferred,
				com.trolltech.qt.gui.QSizePolicy.Policy.Preferred);
		sizePolicy.setHorizontalStretch((byte) 0);
		sizePolicy.setVerticalStretch((byte) 0);
		sizePolicy.setHeightForWidth(TransactionDialog.sizePolicy().hasHeightForWidth());
		TransactionDialog.setSizePolicy(sizePolicy);
		TransactionDialog.setModal(true);
		this.gridLayout = new QGridLayout(TransactionDialog);
		this.gridLayout.setObjectName("gridLayout");
		this.gridLayout.setSizeConstraint(SizeConstraint.SetMinimumSize);
		this.gridLayoutMain = new QGridLayout();
		this.gridLayoutMain.setObjectName("gridLayoutMain");
		this.gridLayoutMain.setSizeConstraint(SizeConstraint.SetDefaultConstraint);
		this.widgetOK = new QWidget(TransactionDialog);
		this.widgetOK.setObjectName("widgetOK");
		this.gridLayout_3 = new QGridLayout(this.widgetOK);
		this.gridLayout_3.setObjectName("gridLayout_3");
		this.pushButtonDelete = new QPushButton(this.widgetOK);
		this.pushButtonDelete.setObjectName("pushButtonDelete");

		this.gridLayout_3.addWidget(this.pushButtonDelete, 1, 2, 1, 1);

		this.pushButtonAdd = new QPushButton(this.widgetOK);
		this.pushButtonAdd.setObjectName("pushButtonAdd");

		this.gridLayout_3.addWidget(this.pushButtonAdd, 1, 1, 1, 1);

		this.pushButtonOK = new QPushButton(this.widgetOK);
		this.pushButtonOK.setObjectName("pushButtonOK");

		this.gridLayout_3.addWidget(this.pushButtonOK, 1, 4, 1, 1);

		this.verticalSpacer = new QSpacerItem(20, 40, com.trolltech.qt.gui.QSizePolicy.Policy.Minimum,
				com.trolltech.qt.gui.QSizePolicy.Policy.Expanding);

		this.gridLayout_3.addItem(this.verticalSpacer, 0, 4, 1, 1);

		this.horizontalSpacer = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_3.addItem(this.horizontalSpacer, 1, 0, 1, 1);

		this.pushButtonModify = new QPushButton(this.widgetOK);
		this.pushButtonModify.setObjectName("pushButtonModify");

		this.gridLayout_3.addWidget(this.pushButtonModify, 1, 3, 1, 1);

		this.gridLayoutMain.addWidget(this.widgetOK, 2, 0, 1, 1);

		this.groupBoxTransaction = new QGroupBox(TransactionDialog);
		this.groupBoxTransaction.setObjectName("groupBoxTransaction");
		this.gridLayout_5 = new QGridLayout(this.groupBoxTransaction);
		this.gridLayout_5.setObjectName("gridLayout_5");
		this.widgetTransactionData = new QWidget(this.groupBoxTransaction);
		this.widgetTransactionData.setObjectName("widgetTransactionData");
		this.gridLayout_7 = new QGridLayout(this.widgetTransactionData);
		this.gridLayout_7.setObjectName("gridLayout_7");
		this.gridLayout_2 = new QGridLayout();
		this.gridLayout_2.setObjectName("gridLayout_2");
		this.subjectEdit = new QLineEdit(this.widgetTransactionData);
		this.subjectEdit.setObjectName("subjectEdit");

		this.gridLayout_2.addWidget(this.subjectEdit, 1, 1, 1, 1);

		this.label = new QLabel(this.widgetTransactionData);
		this.label.setObjectName("label");

		this.gridLayout_2.addWidget(this.label, 0, 0, 1, 1);

		this.pushButtonAddAccount = new QPushButton(this.widgetTransactionData);
		this.pushButtonAddAccount.setObjectName("pushButtonAddAccount");

		this.gridLayout_2.addWidget(this.pushButtonAddAccount, 3, 3, 1, 1);

		this.label_3 = new QLabel(this.widgetTransactionData);
		this.label_3.setObjectName("label_3");

		this.gridLayout_2.addWidget(this.label_3, 2, 0, 1, 1);

		this.comboBoxAccount = new QComboBox(this.widgetTransactionData);
		this.comboBoxAccount.setObjectName("comboBoxAccount");

		this.gridLayout_2.addWidget(this.comboBoxAccount, 3, 1, 1, 1);

		this.label_5 = new QLabel(this.widgetTransactionData);
		this.label_5.setObjectName("label_5");

		this.gridLayout_2.addWidget(this.label_5, 4, 0, 1, 1);

		this.doubleSpinBoxAmount = new QDoubleSpinBox(this.widgetTransactionData);
		this.doubleSpinBoxAmount.setObjectName("doubleSpinBoxAmount");
		this.doubleSpinBoxAmount.setMinimum(-1e+09);
		this.doubleSpinBoxAmount.setMaximum(1e+09);

		this.gridLayout_2.addWidget(this.doubleSpinBoxAmount, 4, 1, 1, 1);

		this.label_4 = new QLabel(this.widgetTransactionData);
		this.label_4.setObjectName("label_4");

		this.gridLayout_2.addWidget(this.label_4, 3, 0, 1, 1);

		this.dateEdit = new QDateEdit(this.widgetTransactionData);
		this.dateEdit.setObjectName("dateEdit");
		this.dateEdit.setCalendarPopup(true);

		this.gridLayout_2.addWidget(this.dateEdit, 0, 1, 1, 1);

		this.checkBoxIncome = new QCheckBox(this.widgetTransactionData);
		this.checkBoxIncome.setObjectName("checkBoxIncome");

		this.gridLayout_2.addWidget(this.checkBoxIncome, 4, 3, 1, 1);

		this.comboBoxCategory = new QComboBox(this.widgetTransactionData);
		this.comboBoxCategory.setObjectName("comboBoxCategory");

		this.gridLayout_2.addWidget(this.comboBoxCategory, 2, 1, 1, 1);

		this.pushButtonAddCategory = new QPushButton(this.widgetTransactionData);
		this.pushButtonAddCategory.setObjectName("pushButtonAddCategory");

		this.gridLayout_2.addWidget(this.pushButtonAddCategory, 2, 3, 1, 1);

		this.label_2 = new QLabel(this.widgetTransactionData);
		this.label_2.setObjectName("label_2");

		this.gridLayout_2.addWidget(this.label_2, 1, 0, 1, 1);

		this.checkBoxNoCategory = new QCheckBox(this.widgetTransactionData);
		this.checkBoxNoCategory.setObjectName("checkBoxNoCategory");

		this.gridLayout_2.addWidget(this.checkBoxNoCategory, 2, 2, 1, 1);

		this.checkBoxNoAccount = new QCheckBox(this.widgetTransactionData);
		this.checkBoxNoAccount.setObjectName("checkBoxNoAccount");

		this.gridLayout_2.addWidget(this.checkBoxNoAccount, 3, 2, 1, 1);

		this.gridLayout_7.addLayout(this.gridLayout_2, 0, 0, 1, 1);

		this.horizontalSpacer_3 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_7.addItem(this.horizontalSpacer_3, 0, 1, 1, 1);

		this.gridLayout_5.addWidget(this.widgetTransactionData, 0, 0, 1, 1);

		this.frameIterateButton = new QFrame(this.groupBoxTransaction);
		this.frameIterateButton.setObjectName("frameIterateButton");
		this.frameIterateButton.setFrameShape(QFrame.Shape.StyledPanel);
		this.frameIterateButton.setFrameShadow(QFrame.Shadow.Raised);
		this.gridLayout_4 = new QGridLayout(this.frameIterateButton);
		this.gridLayout_4.setObjectName("gridLayout_4");
		this.horizontalSpacer_2 = new QSpacerItem(40, 20, com.trolltech.qt.gui.QSizePolicy.Policy.Expanding,
				com.trolltech.qt.gui.QSizePolicy.Policy.Minimum);

		this.gridLayout_4.addItem(this.horizontalSpacer_2, 0, 1, 1, 1);

		this.checkBoxIterate = new QCheckBox(this.frameIterateButton);
		this.checkBoxIterate.setObjectName("checkBoxIterate");

		this.gridLayout_4.addWidget(this.checkBoxIterate, 0, 0, 1, 1);

		this.gridLayout_5.addWidget(this.frameIterateButton, 1, 0, 1, 1);

		this.gridLayoutMain.addWidget(this.groupBoxTransaction, 0, 0, 1, 1);

		this.widget = new QWidget(TransactionDialog);
		this.widget.setObjectName("widget");

		this.gridLayoutMain.addWidget(this.widget, 1, 0, 1, 1);

		this.gridLayout.addLayout(this.gridLayoutMain, 0, 0, 1, 1);

		QWidget.setTabOrder(this.dateEdit, this.subjectEdit);
		QWidget.setTabOrder(this.subjectEdit, this.comboBoxCategory);
		QWidget.setTabOrder(this.comboBoxCategory, this.comboBoxAccount);
		QWidget.setTabOrder(this.comboBoxAccount, this.doubleSpinBoxAmount);
		QWidget.setTabOrder(this.doubleSpinBoxAmount, this.pushButtonAddCategory);
		QWidget.setTabOrder(this.pushButtonAddCategory, this.pushButtonAddAccount);
		QWidget.setTabOrder(this.pushButtonAddAccount, this.checkBoxIncome);
		this.retranslateUi(TransactionDialog);
		this.pushButtonOK.clicked.connect(TransactionDialog, "accept()");

		TransactionDialog.connectSlotsByName();
	} // setupUi

	void retranslateUi(final QDialog TransactionDialog) {
		TransactionDialog.setWindowTitle(
				com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion erstellen", null));
		this.pushButtonDelete
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "L\u00f6schen", null));
		this.pushButtonAdd.setText(
				com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Hinzuf\u00fcgen", null));
		this.pushButtonOK
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Abbrechen", null));
		this.pushButtonModify
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "\u00c4ndern", null));
		this.groupBoxTransaction
				.setTitle(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Transaktion", null));
		this.label.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Datum", null));
		this.pushButtonAddAccount
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
		this.label_3.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Kategorie", null));
		this.label_5.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betrag", null));
		this.label_4.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Konto", null));
		this.checkBoxIncome
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Einnahme", null));
		this.pushButtonAddCategory
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "erstellen", null));
		this.label_2.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Betreff", null));
		this.checkBoxNoCategory
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "keine", null));
		this.checkBoxNoAccount
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "keins", null));
		this.checkBoxIterate
				.setText(com.trolltech.qt.core.QCoreApplication.translate("TransactionDialog", "Wiederholen", null));
	} // retranslateUi

}
