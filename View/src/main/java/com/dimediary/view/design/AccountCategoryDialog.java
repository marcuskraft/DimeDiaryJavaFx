package com.dimediary.view.design;

import java.util.ArrayList;

import javax.persistence.RollbackException;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.BankAccountCategory;
import com.dimediary.view.design.ui.UiaccountCategoryDialog;
import com.dimediary.view.main.Main;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QErrorMessage;
import com.trolltech.qt.gui.QListWidgetItem;

public class AccountCategoryDialog extends UiaccountCategoryDialog {

	private final QDialog dialog;

	public AccountCategoryDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.initialize();

	}

	public void createTrigger() {
		this.pushButtonAdd.clicked.connect(this, "onAddButton()");
		this.pushButtonDelete.clicked.connect(this, "onDeleteButton()");
	}

	private void initialize() {
		this.listCategories.clear();
		this.listCategories.addItems(DBUtils.getInstance().getBankAccountCategoryNames());
		this.checkBoxRealAccount.setChecked(false);
		this.lineEditName.clear();
	}

	public void onAddButton() {
		final BankAccountCategory bankAccountCategory = new BankAccountCategory();
		bankAccountCategory.setName(this.lineEditName.text());
		bankAccountCategory.setIsRealAccount(this.checkBoxRealAccount.isChecked());

		DBUtils.getInstance().persist(bankAccountCategory);
		this.initialize();
		Main.getBankAccountDialog().initialize();
	}

	public void onDeleteButton() {
		final ArrayList<String> bankAccountCategoryNames = new ArrayList<>();

		for (final QListWidgetItem item : this.listCategories.selectedItems()) {
			bankAccountCategoryNames.add(item.text());
		}

		try {
			DBUtils.getInstance().deleteBankAccountCategories(bankAccountCategoryNames);
		} catch (final RollbackException e) {
			final QErrorMessage errorMessage = new QErrorMessage(this.getDialog());
			errorMessage.setWindowTitle("Konto verkn�pft!");
			errorMessage.showMessage(
					"Es gibt noch mindestens ein Konto, welches diesen Typ hat. Bitte �ndern die bei den betroffenen Konten die Kontoart.");
		}

		this.initialize();
		Main.getBankAccountDialog().initialize();
	}

	public void exec() {
		this.dialog.exec();
	}

	public QDialog getDialog() {
		return this.dialog;
	}

}
