package com.dimediary.view.window.transaction;

/**
 * Sample Skeleton for 'TransactionDialog.fxml' Controller Class
 */

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.dmfs.rfc5545.recur.RecurrenceRule;

import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.util.utils.DBUtils;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.util.utils.RecurrenceUtils;
import com.dimediary.view.Main;
import com.dimediary.view.window.main.MainWindow;
import com.dimediary.view.window.util.IWindowParameterInjection;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransactionDialog implements IWindowParameterInjection {

	public static final Double MAX_AMOUNT = 999999999.99;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="fieldDescription"
	private TextField fieldDescription; // Value injected by FXMLLoader

	@FXML // fx:id="datepicker"
	private DatePicker datepicker; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxCategory"
	private ComboBox<String> comboboxCategory; // Value injected by FXMLLoader

	@FXML // fx:id="checkboxCategory"
	private CheckBox checkboxCategory; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxAccount"
	private ComboBox<String> comboboxAccount; // Value injected by
												// FXMLLoader

	@FXML // fx:id="checkboxIncome"
	private CheckBox checkboxIncome; // Value injected by FXMLLoader

	@FXML // fx:id="checkboxAccount"
	private CheckBox checkboxAccount; // Value injected by FXMLLoader

	@FXML // fx:id="spinnerAmount"
	private Spinner<Double> spinnerAmount; // Value injected by FXMLLoader

	@FXML // fx:id="buttonRecurrence"
	private Button buttonRecurrence; // Value injected by FXMLLoader

	@FXML // fx:id="buttonOk"
	private Button buttonOk; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCancel"
	private Button buttonCancel; // Value injected by FXMLLoader

	private MainWindow mainWindow;

	private Transaction transaction;

	private ContinuousTransaction continuousTransaction;

	@FXML
	void onButtonCancel(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onButtonOk(final ActionEvent event) {

		this.mainWindow.refresh();
	}

	@FXML
	void onButtonRecurrence(final ActionEvent event) {
		final WindowParameters parameters = new WindowParameters();
		parameters.put(TransactionDialog.class, this);
		final WindowCreater<RecurrenceDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/RecurrenceDialog.fxml"), "Wiederholung",
				parameters);
	}

	@FXML
	void onCheckboxAccount(final ActionEvent event) {

	}

	@FXML
	void onCheckboxCategory(final ActionEvent event) {

	}

	@FXML
	void onComboboxAccount(final ActionEvent event) {

	}

	@FXML
	void onCheckboxIncome(final ActionEvent event) {

	}

	@FXML
	void onComboboxCategory(final ActionEvent event) {

	}

	@FXML
	void onDatepicker(final ActionEvent event) {

	}

	@FXML
	void onFieldDescription(final ActionEvent event) {

	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.fieldDescription != null : "fx:id=\"fieldDescription\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.datepicker != null : "fx:id=\"datepicker\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.comboboxCategory != null : "fx:id=\"comboboxCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkboxCategory != null : "fx:id=\"checkboxCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.comboboxAccount != null : "fx:id=\"comboboxAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkboxAccount != null : "fx:id=\"checkboxAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.spinnerAmount != null : "fx:id=\"spinnerAmount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonRecurrence != null : "fx:id=\"buttonRecurrence\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonOk != null : "fx:id=\"buttonOk\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'TransactionDialog.fxml'.";

		this.refreshCategories(true);
		this.refreshBankAccounts(true);

		this.datepicker.setValue(DateUtils.date2LocalDate(new Date()));

		this.fieldDescription.setText("");

		final SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,
				TransactionDialog.MAX_AMOUNT, 0.0);

		this.spinnerAmount.setValueFactory(spinnerValueFactory);
		this.spinnerAmount.setEditable(true);
		this.spinnerAmount.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				this.spinnerAmount.increment(0); // won't change value, but will
													// commit editor
			}
		});

	}

	public RecurrenceRule getRecurrenceRule() {
		if (this.continuousTransaction != null) {
			final String ruleString = this.continuousTransaction.getRecurrenceRule();
			return RecurrenceUtils.getRecurrenceRule(ruleString);
		}
		return null;
	}

	public void refreshCategories() {
		this.refreshCategories(false);
	}

	private void refreshCategories(final boolean refreshFirst) {
		final ObservableList<String> categoryNames = FXCollections
				.observableArrayList(DBUtils.getInstance().getCategoryNames());

		if (categoryNames == null) {
			return;
		}
		this.comboboxCategory.setItems(categoryNames);

		if (categoryNames.size() == 0) {
			this.comboboxCategory.setValue("-");
			return;
		}

		if (this.transaction != null) {
			if (this.transaction.getCategory() != null) {
				this.comboboxCategory.setValue(this.transaction.getCategory().getName());
			} else {
				this.comboboxCategory.setValue("-");
				if (refreshFirst) {
					this.comboboxCategory.setEditable(false);
					this.checkboxCategory.setSelected(true);
				} else {
					this.comboboxCategory.setEditable(true);
				}
			}
		} else {
			this.comboboxCategory.setValue(categoryNames.get(0));
		}
	}

	private void refreshBankAccounts(final boolean refreshFirst) {
		final ObservableList<String> bankAccountNames = FXCollections
				.observableArrayList(DBUtils.getInstance().getBankAccountNames());

		if (bankAccountNames == null) {
			return;
		}
		this.comboboxAccount.setItems(bankAccountNames);

		if (bankAccountNames.size() == 0) {
			return;
		}
		if (this.transaction != null) {
			if (this.transaction.getBankAccount() != null) {
				this.comboboxAccount.setValue(this.transaction.getBankAccount().getName());
			} else {
				this.comboboxAccount.setValue("-");
				if (refreshFirst) {
					this.comboboxAccount.setEditable(false);
					this.checkboxAccount.setSelected(true);
				} else {
					this.comboboxAccount.setEditable(true);
				}
			}
		} else {
			this.comboboxAccount.setValue(bankAccountNames.get(0));
		}
	}

	public void refreshBankAccounts() {
		this.refreshBankAccounts(false);
	}

	@Override
	public void inject(final WindowParameters parameters) {
		Object object = parameters.getParameters().get(MainWindow.class);
		if (object == null || !(object instanceof MainWindow)) {
			throw new IllegalArgumentException("mainwindow must be set to create a transaction dialog");
		}
		this.mainWindow = (MainWindow) object;

		object = parameters.getParameters().get(Transaction.class);
		if (object != null && object instanceof Transaction) {
			this.transaction = (Transaction) object;
		}

		object = parameters.getParameters().get(Date.class);
		if (object != null && object instanceof Date) {
			this.datepicker.setValue(DateUtils.date2LocalDate((Date) object));
		}

		object = parameters.getParameters().get(ContinuousTransaction.class);
		if (object != null && object instanceof ContinuousTransaction) {
			this.continuousTransaction = (ContinuousTransaction) object;
		}

		if (this.transaction != null && this.continuousTransaction != null) {
			throw new IllegalArgumentException(
					"it's not possible to create a transaction dialog for a transaction and a continuous transaction together");
		}

		if (this.transaction != null) {
			this.initTransaction();
			return;
		}

		if (this.continuousTransaction != null) {
			this.initContinuousTransaction();
			return;
		}

	}

	private void initContinuousTransaction() {
		this.transaction = null;

		this.refreshCategories(true);
		this.refreshBankAccounts(true);

		this.datepicker.setValue(DateUtils.date2LocalDate(this.continuousTransaction.getDateBeginn()));

		this.fieldDescription.setText(this.continuousTransaction.getName());

		final Double amount = this.continuousTransaction.getAmount();
		this.checkboxIncome.setSelected(amount > 0.0);
		this.spinnerAmount.getValueFactory().setValue(Math.abs(amount));

		this.buttonRecurrence.setText(this.continuousTransaction.getRecurrenceRule());

	}

	private void initTransaction() {
		if (this.transaction == null) {
			throw new IllegalStateException("transaction is not set to an instance!");
		}
		this.refreshCategories(true);
		this.refreshBankAccounts(true);

		this.datepicker.setValue(DateUtils.date2LocalDate(this.transaction.getDate()));
		this.fieldDescription.setText(this.transaction.getName());

		final Double amount = this.transaction.getAmount();
		this.checkboxIncome.setSelected(amount > 0.0);
		this.spinnerAmount.getValueFactory().setValue(Math.abs(amount));
	}

	private void close() {
		final Stage stage = (Stage) this.fieldDescription.getScene().getWindow();
		stage.close();
	}
}
