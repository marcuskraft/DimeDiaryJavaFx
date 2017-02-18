/**
 * Sample Skeleton for 'BankaccountCategoryDialog.fxml' Controller Class
 */

package com.dimediary.view.window.bankaccount;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dimediary.model.entities.BankAccountCategory;
import com.dimediary.util.utils.DBUtils;
import com.dimediary.view.window.util.IWindowParameterInjection;
import com.dimediary.view.window.util.WindowParameters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BankaccountCategoryDialog implements IWindowParameterInjection {

	private final static Logger log = LogManager.getLogger(DBUtils.class);

	private BankAccountDialog bankAccountDialog;
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
		final BankAccountCategory bankAccountCategory = new BankAccountCategory();
		bankAccountCategory.setName(this.textFieldName.getText());

		DBUtils.getInstance().persist(bankAccountCategory);
		this.textFieldName.clear();
		this.items.add(bankAccountCategory.getName());
	}

	@FXML
	void onDelete(final ActionEvent event) {
		final ArrayList<String> bankAccountCategoryNames = new ArrayList<>();

		for (final String string : this.listView.getSelectionModel().getSelectedItems()) {
			bankAccountCategoryNames.add(string);
		}

		try {
			DBUtils.getInstance().deleteBankAccountCategories(bankAccountCategoryNames);
		} catch (final RollbackException e) {
			BankaccountCategoryDialog.log.warn(e);
			final Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Konto verknüpft!");
			alert.setContentText(
					"Es gibt noch mindestens ein Konto, welches diesen Typ hat. Bitte ändern die bei den betroffenen Konten die Kontoart.");
			alert.showAndWait();
		}
		this.initialize();
	}

	@FXML
	void onOK(final ActionEvent event) {
		this.close();
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.listView != null : "fx:id=\"listView\" was not injected: check your FXML file 'BankaccountCategoryDialog.fxml'.";
		assert this.okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'BankaccountCategoryDialog.fxml'.";
		assert this.textFieldName != null : "fx:id=\"textFieldName\" was not injected: check your FXML file 'BankaccountCategoryDialog.fxml'.";
		assert this.addButton != null : "fx:id=\"addButton\" was not injected: check your FXML file 'BankaccountCategoryDialog.fxml'.";
		assert this.deleteButton != null : "fx:id=\"deleteButton\" was not injected: check your FXML file 'BankaccountCategoryDialog.fxml'.";

		this.items = FXCollections.observableArrayList();
		this.items.addAll(DBUtils.getInstance().getBankAccountCategoryNames());
		this.listView.setItems(this.items);
		this.listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.textFieldName.clear();

	}

	@Override
	public void inject(final WindowParameters parameters) {
		final Object object = parameters.getParameters().get(BankAccountDialog.class);
		if (object != null && object instanceof BankAccountDialog) {
			this.bankAccountDialog = (BankAccountDialog) object;
		}
	}

	public void close() {
		if (this.bankAccountDialog != null) {
			this.bankAccountDialog.refreshAccCategories();
		}
		final Stage stage = (Stage) this.okButton.getScene().getWindow();
		stage.close();
	}
}
