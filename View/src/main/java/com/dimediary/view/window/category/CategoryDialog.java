package com.dimediary.view.window.category;
/**
 * Sample Skeleton for 'CategoryDialog.fxml' Controller Class
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.dimediary.model.entities.Category;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.view.window.util.IWindowParameterInjection;
import com.dimediary.view.window.util.WindowParameters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CategoryDialog implements IWindowParameterInjection {

	private ObservableList<String> items;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="listView"
	private ListView<String> listView; // Value injected by FXMLLoader

	@FXML // fx:id="okButton"
	private Button okButton; // Value injected by FXMLLoader

	@FXML // fx:id="textFieldName"
	private TextField textFieldName; // Value injected by FXMLLoader

	@FXML // fx:id="addButton"
	private Button addButton; // Value injected by FXMLLoader

	@FXML // fx:id="deleteButton"
	private Button deleteButton; // Value injected by FXMLLoader

	@FXML
	void onAdd(final ActionEvent event) {
		final Category category = new Category();
		category.setName(this.textFieldName.getText());
		this.items.add(category.getName());
		DatabaseService.getInstance().persist(category);
		this.textFieldName.clear();
	}

	@FXML
	void onDelete(final ActionEvent event) {
		final ArrayList<String> categoryNames = new ArrayList<>();

		final ObservableList<String> itemsToDelete = this.listView.getSelectionModel().getSelectedItems();

		for (final String string : itemsToDelete) {
			categoryNames.add(string);
		}

		DatabaseService.getInstance().deleteCategories(DatabaseService.getInstance().getCategories(categoryNames));

		for (final String string : categoryNames) {
			this.items.remove(string);
		}
	}

	@FXML
	void onOK(final ActionEvent event) {
		this.close();
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'CategoryDialog.fxml'.";
		assert this.okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'CategoryDialog.fxml'.";
		assert this.textFieldName != null : "fx:id=\"textFieldName\" was not injected: check your FXML file 'CategoryDialog.fxml'.";
		assert this.addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'CategoryDialog.fxml'.";
		assert this.deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'CategoryDialog.fxml'.";

		this.items = FXCollections.observableArrayList();
		this.items.addAll(DatabaseService.getInstance().getCategoryNames());
		this.listView.setItems(this.items);
		this.listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.textFieldName.clear();
	}

	@Override
	public void inject(final WindowParameters parameters) {

	}

	public void close() {
		final Stage stage = (Stage) this.okButton.getScene().getWindow();
		stage.close();
	}

}
