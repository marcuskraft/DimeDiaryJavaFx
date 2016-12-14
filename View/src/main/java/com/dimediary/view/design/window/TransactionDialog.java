/**
 * Sample Skeleton for 'TransactionDialog.fxml' Controller Class
 */

package com.dimediary.view.design.window;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.controller.utils.DateUtils;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;

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

public class TransactionDialog {

	private Transaction transaction = null;
	private ContinuousTransaction continuousTransaction = null;
	private MainWindow mainWindow = null;

	private static final Double MAX_AMOUNT = 999999999.99;

	@FXML // fx:id="buttonDelete"
	private Button buttonDelete; // Value injected by FXMLLoader

	@FXML // fx:id="buttonModify"
	private Button buttonModify; // Value injected by FXMLLoader

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="buttonAdd"
	private Button buttonAdd; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCancel"
	private Button buttonCancel; // Value injected by FXMLLoader

	@FXML // fx:id="datePicker"
	private DatePicker datePicker; // Value injected by FXMLLoader

	@FXML // fx:id="textFieldName"
	private TextField textFieldName; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxCategory"
	private ComboBox<String> comboBoxCategory; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxAccount"
	private ComboBox<String> comboBoxAccount; // Value injected by FXMLLoader

	@FXML // fx:id="spinnerAmount"
	private Spinner<Double> spinnerAmount; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxNoCategory"
	private CheckBox checkBoxNoCategory; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxNoAccount"
	private CheckBox checkBoxNoAccount; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCreateCategory"
	private Button buttonCreateCategory; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCreateAccount"
	private Button buttonCreateAccount; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxIncome"
	private CheckBox checkBoxIncome; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxIterate"
	private CheckBox checkBoxIterate; // Value injected by FXMLLoader

	@FXML // fx:id="buttonIterate"
	private Button buttonIterate; // Value injected by FXMLLoader

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.textFieldName != null : "fx:id=\"textFieldName\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.comboBoxCategory != null : "fx:id=\"comboBoxCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.comboBoxAccount != null : "fx:id=\"comboBoxAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.spinnerAmount != null : "fx:id=\"spinnerAmount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkBoxNoCategory != null : "fx:id=\"checkBoxNoCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkBoxNoAccount != null : "fx:id=\"checkBoxNoAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonCreateCategory != null : "fx:id=\"buttonCreateCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonCreateAccount != null : "fx:id=\"buttonCreateAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkBoxIncome != null : "fx:id=\"checkBoxIncome\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkBoxIterate != null : "fx:id=\"checkBoxIterate\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonIterate != null : "fx:id=\"buttonIterate\" was not injected: check your FXML file 'TransactionDialog.fxml'.";

		this.refreshCategories(true);
		this.refreshBankAccounts(true);
		this.datePicker.setValue(DateUtils.date2LocalDate(new Date()));
		this.textFieldName.setText("");

		final SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(
				-TransactionDialog.MAX_AMOUNT, 0.0, 0.0) {
		};

		this.spinnerAmount.setValueFactory(spinnerValueFactory);

		this.buttonDelete.setVisible(false);
		this.buttonModify.setVisible(false);
		this.buttonAdd.setVisible(true);
	}

	private void initTransaction() {
		this.refreshCategories(true);
		this.refreshBankAccounts(true);
		this.buttonAdd.setVisible(false);
		this.buttonDelete.setVisible(true);
		this.buttonModify.setVisible(true);

		this.datePicker.setValue(DateUtils.date2LocalDate(this.transaction.getDate()));
		this.textFieldName.setText(this.transaction.getName());
		final SpinnerValueFactory<Double> spinnerValueFactory;
		if (this.transaction.getAmount() > 0.0) {
			spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0, TransactionDialog.MAX_AMOUNT,
					this.transaction.getAmount()) {
			};
			this.checkBoxIncome.setSelected(true);
		} else {
			spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(-TransactionDialog.MAX_AMOUNT, 0.0,
					this.transaction.getAmount()) {
			};
			this.checkBoxIncome.setSelected(false);
		}

		this.spinnerAmount.setValueFactory(spinnerValueFactory);
	}

	@FXML
	void onButtonAdd(final ActionEvent event) {
		if (this.checkBoxIterate.isSelected()) {
			this.addContinuousTransaction();
		} else {
			this.addSingleTransaction();
		}
		if (this.mainWindow != null) {
			this.mainWindow.refreshMonthOverview();
		}
		this.close();
	}

	@FXML
	void onDelete(final ActionEvent event) {
		if (this.transaction != null) {
			DBUtils.getInstance().delete(this.transaction);
		} else if (this.continuousTransaction != null) {
			this.deleteContinuousTransaction();
		} else {
			throw new IllegalStateException(
					"TransactionDialog has no transaction or continuous transaction to delete after clicking the delete button!");
		}
		if (this.mainWindow != null) {
			this.mainWindow.refreshMonthOverview();
		}
		this.close();
	}

	@FXML
	void onModify(final ActionEvent event) {
		if (this.transaction != null) {
			this.mergeTransaction();
		} else if (this.continuousTransaction != null) {
			this.mergeContinuousTransaction();
		} else {
			throw new IllegalStateException(
					"TransactionDialog has no transaction or continuous transaction to modify after clicking the modify button!");
		}
		if (this.mainWindow != null) {
			this.mainWindow.refreshMonthOverview();
		}
		this.close();
	}

	@FXML
	void onButtonCancel(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onButtonIterate(final ActionEvent event) {

	}

	@FXML
	void onCheckboxIterate(final ActionEvent event) {

	}

	@FXML
	void onCreateAccount(final ActionEvent event) {

	}

	@FXML
	void onCreateCategory(final ActionEvent event) {

	}

	@FXML
	void onCheckBoxIncome(final ActionEvent event) {
		final Double value = this.spinnerAmount.getValue();
		if (this.checkBoxIncome.isSelected()) {
			this.spinnerAmount.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(0,
					TransactionDialog.MAX_AMOUNT, Math.abs(value)) {
			});
		} else {
			this.spinnerAmount.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(
					-TransactionDialog.MAX_AMOUNT, 0, -Math.abs(value)) {
			});
		}
	}

	@FXML
	void onNoCategory(final ActionEvent event) {
		if (this.checkBoxNoCategory.isSelected()) {
			this.comboBoxCategory.setValue("-");
			this.comboBoxCategory.setEditable(false);
		} else {
			this.comboBoxCategory.setEditable(true);
			this.refreshCategories(false);
		}
	}

	@FXML
	void onNoAccount(final ActionEvent event) {
		if (this.checkBoxNoAccount.isSelected()) {
			this.comboBoxAccount.setValue("-");
			this.comboBoxAccount.setEditable(false);
		} else {
			this.comboBoxAccount.setEditable(true);
			this.refreshBankAccounts(false);
		}
	}

	private void deleteContinuousTransaction() {
		// TODO Auto-generated method stub

	}

	private void mergeContinuousTransaction() {
		// TODO Auto-generated method stub

	}

	private void mergeTransaction() {
		DBUtils.getInstance().delete(this.transaction);
		this.addSingleTransaction();
	}

	private void addSingleTransaction() {
		final Transaction transaction = new Transaction();
		this.setTransactionAttributes(transaction);
		DBUtils.getInstance().persist(transaction);
	}

	private void setTransactionAttributes(final Transaction transaction) {
		transaction.setAmount(this.spinnerAmount.getValue());

		if (this.checkBoxNoAccount.isSelected()) {
			transaction.setBankAccount(null);
		} else {
			transaction.setBankAccount(DBUtils.getInstance().getBankAccount(this.comboBoxAccount.getValue()));
		}

		if (this.checkBoxNoCategory.isSelected()) {
			transaction.setCategory(null);
		} else {
			transaction.setCategory(DBUtils.getInstance().getCategory(this.comboBoxCategory.getValue()));
		}

		transaction.setDate(DateUtils.localDateToDate(this.datePicker.getValue()));
		transaction.setName(this.textFieldName.getText());
		transaction.setUser(null);
	}

	private void addContinuousTransaction() {
		// TODO Auto-generated method stub

	}

	private void refreshBankAccounts(final boolean refreshFirst) {
		final ObservableList<String> bankAccountNames = FXCollections
				.observableArrayList(DBUtils.getInstance().getBankAccountNames());

		if (bankAccountNames == null) {
			return;
		}
		this.comboBoxAccount.setItems(bankAccountNames);

		if (bankAccountNames.size() == 0) {
			return;
		}
		if (this.transaction != null) {
			if (this.transaction.getBankAccount() != null) {
				this.comboBoxAccount.setValue(this.transaction.getBankAccount().getName());
			} else {
				this.comboBoxAccount.setValue("-");
				if (refreshFirst) {
					this.comboBoxAccount.setEditable(false);
					this.checkBoxNoAccount.setSelected(true);
				} else {
					this.comboBoxAccount.setEditable(true);
				}
			}
		} else if (this.continuousTransaction != null) {
			// TODO implement the logic here
		} else {
			this.comboBoxAccount.setValue(bankAccountNames.get(0));
		}
	}

	private void refreshCategories(final boolean refreshFirst) {
		final ObservableList<String> categoryNames = FXCollections
				.observableArrayList(DBUtils.getInstance().getCategoryNames());

		if (categoryNames == null) {
			return;
		}
		this.comboBoxCategory.setItems(categoryNames);

		if (categoryNames.size() == 0) {
			this.comboBoxCategory.setValue("-");
			return;
		}

		if (this.transaction != null) {
			if (this.transaction.getCategory() != null) {
				this.comboBoxCategory.setValue(this.transaction.getCategory().getName());
			} else {
				this.comboBoxCategory.setValue("-");
				if (refreshFirst) {
					this.comboBoxCategory.setEditable(false);
					this.checkBoxNoCategory.setSelected(true);
				} else {
					this.comboBoxCategory.setEditable(true);
				}

			}
		} else if (this.continuousTransaction != null) {
			// TODO implement the logic here
		} else {
			this.comboBoxCategory.setValue(categoryNames.get(0));
		}

	}

	private void close() {
		final Stage stage = (Stage) this.buttonAdd.getScene().getWindow();
		stage.close();
	}

	public void setTransaction(final Transaction transaction) {
		this.transaction = transaction;
		this.initTransaction();
	}

	public void setMainWindow(final MainWindow mainWindow) {
		this.mainWindow = mainWindow;
	}

	public void setContinuousTransaction(final ContinuousTransaction continuousTransaction) {
		this.continuousTransaction = continuousTransaction;
	}

}
