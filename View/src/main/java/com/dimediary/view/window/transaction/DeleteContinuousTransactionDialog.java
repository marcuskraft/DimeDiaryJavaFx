/**
 * Sample Skeleton for 'DeleteContinuousTransactionDialog.fxml' Controller Class
 */

package com.dimediary.view.window.transaction;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.dimediary.util.utils.DateUtils;
import com.dimediary.view.window.util.IWindowParameterInjection;
import com.dimediary.view.window.util.WindowParameters;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class DeleteContinuousTransactionDialog implements IWindowParameterInjection {

	private TransactionDialog transactionDialog;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="buttonOK"
	private Button buttonOK; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCancel"
	private Button buttonCancel; // Value injected by FXMLLoader

	@FXML // fx:id="radiobuttonUntil"
	private RadioButton radiobuttonUntil; // Value injected by FXMLLoader

	@FXML // fx:id="radiobuttonAll"
	private RadioButton radiobuttonAll; // Value injected by FXMLLoader

	@FXML // fx:id="dateUntil"
	private DatePicker dateUntil; // Value injected by FXMLLoader

	@FXML
	void onAll(final ActionEvent event) {
		this.dateUntil.setDisable(true);
	}

	@FXML
	void onCancel(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onOK(final ActionEvent event) {
		if (this.radiobuttonAll.isSelected()) {
			this.transactionDialog.deleteAllContinuousTransactions();
		} else {
			this.transactionDialog.deleteContinuousTransaction(DateUtils.localDateToDate(this.dateUntil.getValue()));
		}
		this.close();
	}

	@FXML
	void onUntil(final ActionEvent event) {
		this.dateUntil.setDisable(false);
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.buttonOK != null : "fx:id=\"buttonOK\" was not injected: check your FXML file 'MergeContinuousTransactionDialog.fxml'.";
		assert this.buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'MergeContinuousTransactionDialog.fxml'.";
		assert this.radiobuttonUntil != null : "fx:id=\"radiobuttonUntil\" was not injected: check your FXML file 'MergeContinuousTransactionDialog.fxml'.";
		assert this.radiobuttonAll != null : "fx:id=\"radiobuttonAll\" was not injected: check your FXML file 'MergeContinuousTransactionDialog.fxml'.";
		assert this.dateUntil != null : "fx:id=\"dateUntil\" was not injected: check your FXML file 'MergeContinuousTransactionDialog.fxml'.";

		final ToggleGroup toggleGroup = new ToggleGroup();
		this.radiobuttonAll.setToggleGroup(toggleGroup);
		this.radiobuttonUntil.setToggleGroup(toggleGroup);
	}

	private void init() {
		this.dateUntil.setValue(DateUtils.date2LocalDate(new Date()));
		this.radiobuttonUntil.setSelected(true);
	}

	private void close() {
		final Stage stage = (Stage) this.buttonOK.getScene().getWindow();
		stage.close();
	}

	@Override
	public void inject(final WindowParameters parameters) {
		final Object object = parameters.getParameters().get(TransactionDialog.class);
		if (object == null || !(object instanceof TransactionDialog)) {
			throw new IllegalArgumentException(
					"transaction dialog must be set to create a delete continuous transaction dialog");
		}
		this.transactionDialog = (TransactionDialog) object;
		this.init();
	}
}
