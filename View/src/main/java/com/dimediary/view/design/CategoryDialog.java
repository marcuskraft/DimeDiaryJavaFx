package com.dimediary.view.design;

import java.util.ArrayList;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.Category;
import com.dimediary.view.Main;
import com.dimediary.view.design.ui.UiCategoryDialog;
import com.trolltech.qt.gui.QDialog;
import com.trolltech.qt.gui.QListWidgetItem;

/**
 * wrapper class for the category dialog
 *
 * @author eyota
 *
 */
public class CategoryDialog extends UiCategoryDialog {

	private final QDialog dialog;

	/**
	 * constructor
	 */
	public CategoryDialog() {
		super();
		this.dialog = new QDialog();
		this.setupUi(this.dialog);

		this.initialize();
	}

	/**
	 * create trigger for this dialog
	 */
	public void createTrigger() {
		this.pushButtonAdd.clicked.connect(this, "onAddButton()");
		this.pushButtonAdd.clicked.connect(Main.getTransactionDialog(), "refreshCategories()");

		this.pushButtonDelete.clicked.connect(this, "onDeleteButton()");
		this.pushButtonDelete.clicked.connect(Main.getTransactionDialog(), "refreshCategories()");
	}

	private void initialize() {
		this.listCategories.clear();
		this.listCategories.addItems(DBUtils.getInstance().getCategoryNames());
		this.lineEditName.clear();
	}

	/**
	 * add a category to the data base
	 */
	public void onAddButton() {
		final Category category = new Category();
		category.setName(this.lineEditName.text());

		DBUtils.getInstance().persist(category);
		this.initialize();
	}

	/**
	 * delete the selected categories from the data base
	 */
	public void onDeleteButton() {
		final ArrayList<String> categoryNames = new ArrayList<>();

		for (final QListWidgetItem item : this.listCategories.selectedItems()) {
			categoryNames.add(item.text());
		}

		DBUtils.getInstance().deleteCategories(DBUtils.getInstance().getCategories(categoryNames));

		this.initialize();
	}

	/**
	 * executes this dialig
	 */
	public void exec() {
		this.dialog.exec();
	}

	/**
	 *
	 * @return real QDialog
	 */
	public QDialog getDialog() {
		return this.dialog;
	}

}
