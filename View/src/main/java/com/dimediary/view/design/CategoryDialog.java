package com.dimediary.view.design;

import java.util.ArrayList;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Category;
import com.dimediary.view.design.ui.UiCategoryDialog;
import com.dimediary.view.main.Main;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QListWidgetItem;

public class CategoryDialog extends UiCategoryDialog {

	private final QDialog dialog;

	public CategoryDialog() {
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
		this.listCategories.addItems(DBUtils.getInstance().getCategoryNames());
		this.lineEditName.clear();
	}

	public void onAddButton() {
		final Category category = new Category();
		category.setName(this.lineEditName.text());

		DBUtils.getInstance().persist(category);
		this.initialize();
		Main.getTransactionDialog().initialize();
	}

	public void onDeleteButton() {
		final ArrayList<String> categoryNames = new ArrayList<>();

		for (final QListWidgetItem item : this.listCategories.selectedItems()) {
			categoryNames.add(item.text());
		}

		DBUtils.getInstance().deleteCategories(DBUtils.getInstance().getCategories(categoryNames));

		this.initialize();
		Main.getTransactionDialog().initialize();
	}

	public void exec() {
		this.dialog.exec();
	}

	public QDialog getDialog() {
		return this.dialog;
	}

}
