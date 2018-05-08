/**
 * Sample Skeleton for 'AccountDialog.fxml' Controller Class
 */

package com.dimediary.view.window.bankaccount;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.persistence.RollbackException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.services.utils.DBUtils;
import com.dimediary.view.Main;
import com.dimediary.view.window.category.CategoryDialog;
import com.dimediary.view.window.transaction.TransactionDialog;
import com.dimediary.view.window.util.IWindowParameterInjection;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BankAccountDialog implements IWindowParameterInjection {

	private final static Logger log = LogManager.getLogger(BankAccountDialog.class);

	private ObservableList<String> items;

	@FXML
	private ListView<String> listView;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="buttonDelete"
	private Button buttonDelete; // Value injected by FXMLLoader

	@FXML // fx:id="buttonOk"
	private Button buttonOk; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxAccountCategory"
	private ComboBox<String> comboBoxAccountCategory; // Value injected by
														// FXMLLoader

	@FXML // fx:id="buttonAddAccCategory"
	private Button buttonAddAccCategory; // Value injected by FXMLLoader

	@FXML // fx:id="textFieldAccName"
	private TextField textFieldAccName; // Value injected by FXMLLoader

	@FXML // fx:id="textFieldBankName"
	private TextField textFieldBankName; // Value injected by FXMLLoader

	@FXML // fx:id="textFieldIBAN"
	private TextField textFieldIBAN; // Value injected by FXMLLoader

	@FXML // fx:id="textFieldBIC"
	private TextField textFieldBIC; // Value injected by FXMLLoader

	@FXML // fx:id="datePickerStartBudget"
	private DatePicker datePickerStartBudget; // Value injected by FXMLLoader

	@FXML // fx:id="spinnerStartBudget"
	private Spinner<Double> spinnerStartBudget; // Value injected by FXMLLoader

	@FXML // fx:id="buttonAdd"
	private Button buttonAdd; // Value injected by FXMLLoader

	@FXML
	void onButtonAdd(final ActionEvent event) {
		final BankAccount bankAccount = new BankAccount();

		bankAccount.setBankAccountCategory(
				DBUtils.getInstance().getBankAccountCategory(this.comboBoxAccountCategory.getValue()));
		bankAccount.setBankName(this.textFieldBankName.getText());
		bankAccount.setBic(this.textFieldBIC.getText());
		bankAccount.setIban(this.textFieldIBAN.getText());
		bankAccount.setName(this.textFieldAccName.getText());
		bankAccount.setStartBudget(this.spinnerStartBudget.getValue());
		bankAccount.setDateStartBudget(this.datePickerStartBudget.getValue());

		DBUtils.getInstance().persist(bankAccount);
		this.items.add(bankAccount.getName());

		this.initialize();
	}

	@FXML
	void onButtonAddAccCategory(final ActionEvent event) {
		final WindowParameters parameters = new WindowParameters();
		parameters.put(BankAccountDialog.class, this);
		final WindowCreater<CategoryDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/BankaccountCategoryDialog.fxml"),
				"Konto-Kategorien bearbeiten", parameters);
	}

	@FXML
	void onButtonDelete(final ActionEvent event) {
		final ArrayList<String> bankAccountNames = new ArrayList<>();

		for (final String string : this.listView.getSelectionModel().getSelectedItems()) {
			bankAccountNames.add(string);
		}

		try {
			DBUtils.getInstance().deleteBankAccounts(bankAccountNames);
		} catch (final RollbackException e) {
			BankAccountDialog.log.warn(e);
			final Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Fehler");
			alert.setHeaderText("Transaktion verknüpft!");
			alert.setContentText("Es gibt noch mindestens eine Transaktion, welche dieses Konto referenziert.");
			alert.showAndWait();
		}

		this.initialize();
	}

	@FXML
	void onButtonOk(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onComboBoxAccCategory(final ActionEvent event) {

	}

	@FXML
	void onClickListView(final MouseEvent event) {
		if (event.getClickCount() > 1) {
			final BankAccount bankAccount = DBUtils.getInstance()
					.getBankAccount(this.listView.getSelectionModel().getSelectedItem());
			this.initialize(bankAccount);
		}
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.buttonDelete != null : "fx:id=\"buttonDelete\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.buttonOk != null : "fx:id=\"buttonOk\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.comboBoxAccountCategory != null : "fx:id=\"comboBoxAccountCategory\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.buttonAddAccCategory != null : "fx:id=\"buttonAddAccCategory\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.textFieldAccName != null : "fx:id=\"textFieldAccName\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.textFieldBankName != null : "fx:id=\"textFieldBankName\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.textFieldIBAN != null : "fx:id=\"textFieldIBAN\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.textFieldBIC != null : "fx:id=\"textFieldBIC\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.datePickerStartBudget != null : "fx:id=\"datePickerStartBudget\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.spinnerStartBudget != null : "fx:id=\"spinnerStartBudget\" was not injected: check your FXML file 'AccountDialog.fxml'.";
		assert this.buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'AccountDialog.fxml'.";

		this.items = FXCollections.observableArrayList();
		this.items.addAll(DBUtils.getInstance().getBankAccountNames());
		this.listView.setItems(this.items);
		this.listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		this.textFieldAccName.clear();
		this.textFieldBankName.clear();
		this.textFieldBIC.clear();
		this.textFieldIBAN.clear();

		this.refreshAccCategories();

		this.datePickerStartBudget.setValue(LocalDate.now());

		final SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(
				-TransactionDialog.MAX_AMOUNT, TransactionDialog.MAX_AMOUNT, 0.0) {

		};
		this.spinnerStartBudget.setEditable(true);
		this.spinnerStartBudget.setValueFactory(spinnerValueFactory);
		this.spinnerStartBudget.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				this.spinnerStartBudget.increment(0); // won't change value, but will
														// commit editor
			}
		});

	}

	/**
	 * initializes the components of this dialog with the data of the bank account
	 *
	 * @param bankAccount
	 *            bank account to be shown
	 */
	public void initialize(final BankAccount bankAccount) {
		this.initialize();

		this.comboBoxAccountCategory.getSelectionModel().select(bankAccount.getBankAccountCategory().getName());
		this.textFieldAccName.setText(bankAccount.getName());
		this.textFieldBankName.setText(bankAccount.getBankName());
		this.textFieldIBAN.setText(bankAccount.getIban());
		this.textFieldBIC.setText(bankAccount.getBic());
		this.datePickerStartBudget.setValue(bankAccount.getDateStartBudget());
		this.spinnerStartBudget.getValueFactory().setValue(bankAccount.getStartBudget());
	}

	public void refreshAccCategories() {
		final ObservableList<String> accountCategories = FXCollections.observableArrayList();
		accountCategories.addAll(DBUtils.getInstance().getBankAccountCategoryNames());
		this.comboBoxAccountCategory.setItems(accountCategories);
	}

	@Override
	public void inject(final WindowParameters parameters) {

	}

	public void close() {
		final Stage stage = (Stage) this.buttonOk.getScene().getWindow();
		stage.close();
	}
}
