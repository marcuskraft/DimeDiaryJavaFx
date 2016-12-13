/**
 * Sample Skeleton for 'ContinuousTransactionDialog.fxml' Controller Class
 */

package com.dimediary.view.design.window;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;

public class ContinuousTransactionDialog {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="buttonOk"
	private Button buttonOk; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCancel"
	private Button buttonCancel; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonMonthly"
	private RadioButton radioButtonMonthly; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonDaily"
	private RadioButton radioButtonDaily; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonWeekly"
	private RadioButton radioButtonWeekly; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonYearly"
	private RadioButton radioButtonYearly; // Value injected by FXMLLoader

	@FXML // fx:id="spinnerEveryMonth"
	private Spinner<?> spinnerEveryMonth; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxWhichDayOfMonth"
	private ComboBox<?> checkBoxWhichDayOfMonth; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonNoEndDate"
	private RadioButton radioButtonNoEndDate; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonIterateNumber"
	private RadioButton radioButtonIterateNumber; // Value injected by
													// FXMLLoader

	@FXML // fx:id="radioButtonIterateUntil"
	private RadioButton radioButtonIterateUntil; // Value injected by FXMLLoader

	@FXML
	void onCancel(final ActionEvent event) {

	}

	@FXML
	void onDaily(final ActionEvent event) {

	}

	@FXML
	void onIterateNumber(final ActionEvent event) {

	}

	@FXML
	void onIterateUntil(final ActionEvent event) {

	}

	@FXML
	void onMonthly(final ActionEvent event) {

	}

	@FXML
	void onNoEndDate(final ActionEvent event) {

	}

	@FXML
	void onOK(final ActionEvent event) {

	}

	@FXML
	void onWeekly(final ActionEvent event) {

	}

	@FXML
	void onYearly(final ActionEvent event) {

	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.buttonOk != null : "fx:id=\"buttonOk\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonMonthly != null : "fx:id=\"radioButtonMonthly\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonDaily != null : "fx:id=\"radioButtonDaily\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonWeekly != null : "fx:id=\"radioButtonWeekly\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonYearly != null : "fx:id=\"radioButtonYearly\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.spinnerEveryMonth != null : "fx:id=\"spinnerEveryMonth\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.checkBoxWhichDayOfMonth != null : "fx:id=\"checkBoxWhichDayOfMonth\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonNoEndDate != null : "fx:id=\"radioButtonNoEndDate\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonIterateNumber != null : "fx:id=\"radioButtonIterateNumber\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonIterateUntil != null : "fx:id=\"radioButtonIterateUntil\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";

	}
}
