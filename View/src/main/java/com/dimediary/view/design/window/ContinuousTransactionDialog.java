/**
 * Sample Skeleton for 'ContinuousTransactionDialog.fxml' Controller Class
 */

package com.dimediary.view.design.window;

import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.ContinuousTransaction.DayOfMonth;
import com.dimediary.model.entities.ContinuousTransaction.IterationState;
import com.dimediary.util.utils.DateUtils;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ContinuousTransactionDialog {

	private TransactionDialog transactionDialog;

	HashMap<String, DayOfMonth> dayOfMonthByMonthlyMapping;
	ArrayList<String> dayOfMonthStrings;

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
	private Spinner<Integer> spinnerEveryMonth; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxWhichDayOfMonth"
	private ComboBox<String> comboBoxWhichDayOfMonth; // Value injected by
														// FXMLLoader

	@FXML // fx:id="radioButtonNoEndDate"
	private RadioButton radioButtonNoEndDate; // Value injected by FXMLLoader

	@FXML // fx:id="radioButtonIterateNumber"
	private RadioButton radioButtonIterateNumber; // Value injected by
													// FXMLLoader

	@FXML // fx:id="radioButtonIterateUntil"
	private RadioButton radioButtonIterateUntil; // Value injected by FXMLLoader

	@FXML // fx:id="spinnerNumberOfIterations"
	private Spinner<Integer> spinnerNumberOfIterations; // Value injected by
	// FXMLLoader

	@FXML // fx:id="dateUntil"
	private DatePicker dateUntil; // Value injected by FXMLLoader

	@FXML
	void onCancel(final ActionEvent event) {
		this.close();
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
		if (this.radioButtonMonthly.isSelected()) {
			this.initMonthlyTransaction();
		} else if (this.radioButtonDaily.isSelected()) {

		} else if (this.radioButtonWeekly.isSelected()) {

		} else if (this.radioButtonYearly.isSelected()) {

		}
	}

	private void initMonthlyTransaction() {
		final ContinuousTransaction continuousTransaction = this.transactionDialog.getContinuousTransaction();
		continuousTransaction.setIterationState(IterationState.MONTHLY);
		continuousTransaction.setEveryIterationState(this.spinnerEveryMonth.getValue());
		continuousTransaction
				.setDayOfMonth(this.dayOfMonthByMonthlyMapping.get(this.comboBoxWhichDayOfMonth.getValue()));

		if (this.radioButtonIterateNumber.isSelected()) {
			continuousTransaction.setNumberOfIterations(this.spinnerNumberOfIterations.getValue());
		} else if (this.radioButtonIterateUntil.isSelected()) {
			continuousTransaction.setDateUntil(DateUtils.localDateToDate(this.dateUntil.getValue()));

		}
		this.close();
	}

	@FXML
	void onWeekly(final ActionEvent event) {

	}

	@FXML
	void onYearly(final ActionEvent event) {

	}

	@FXML
	void onComboBoxWhichDay(final ActionEvent event) {

	}

	@FXML
	void onDateUntil(final ActionEvent event) {

	}

	@FXML
	void onSpinnerEveryMonth(final MouseEvent event) {

	}

	@FXML
	void onSpinnerNumberOfIterations(final MouseEvent event) {

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
		assert this.comboBoxWhichDayOfMonth != null : "fx:id=\"checkBoxWhichDayOfMonth\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonNoEndDate != null : "fx:id=\"radioButtonNoEndDate\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonIterateNumber != null : "fx:id=\"radioButtonIterateNumber\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";
		assert this.radioButtonIterateUntil != null : "fx:id=\"radioButtonIterateUntil\" was not injected: check your FXML file 'ContinuousTransactionDialog.fxml'.";

		this.init();
	}

	private void init() {
		this.initMapping();

		final ToggleGroup toggleGroup = new ToggleGroup();
		this.radioButtonDaily.setToggleGroup(toggleGroup);
		this.radioButtonWeekly.setToggleGroup(toggleGroup);
		this.radioButtonMonthly.setToggleGroup(toggleGroup);
		this.radioButtonYearly.setToggleGroup(toggleGroup);

		this.radioButtonMonthly.setSelected(true);

		final ToggleGroup toggleGroup2 = new ToggleGroup();
		this.radioButtonIterateNumber.setToggleGroup(toggleGroup2);
		this.radioButtonIterateUntil.setToggleGroup(toggleGroup2);
		this.radioButtonNoEndDate.setToggleGroup(toggleGroup2);

		this.radioButtonNoEndDate.setSelected(true);

		final SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,
				5000, 10) {
		};
		this.spinnerNumberOfIterations.setValueFactory(spinnerValueFactory);

		final SpinnerValueFactory<Integer> spinnerValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,
				48, 1);
		this.spinnerEveryMonth.setValueFactory(spinnerValueFactory2);

		final Date date = new Date();
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, 1);
		this.dateUntil.setValue(DateUtils.date2LocalDate(calendar.getTime()));

		final ObservableList<String> dayOfMonthObsevables = FXCollections.observableArrayList(this.dayOfMonthStrings);
		this.comboBoxWhichDayOfMonth.setItems(dayOfMonthObsevables);

		this.radioButtonDaily.setDisable(true);
		this.radioButtonWeekly.setDisable(true);
		this.radioButtonYearly.setDisable(true);

	}

	private void initContinuousTransaction() {
		if (this.transactionDialog == null || this.transactionDialog.getContinuousTransaction() == null) {
			throw new IllegalStateException("transactionDialog not injected or has no continuous transaction");
		}

		switch (this.transactionDialog.getContinuousTransaction().getIterationState()) {
		case WEEKLY:
			// TODO not yet implemented
			break;
		case DAYLI:
			// TODO not yet implemented
			break;
		case MONTHLY:
			this.initMonthly();
			break;
		// TODO not yet implemented
		case YEARLY:

			break;
		default:
			break;
		}
	}

	private void initMonthly() {
		this.radioButtonMonthly.setSelected(true);
		this.spinnerEveryMonth.getValueFactory()
				.setValue(this.transactionDialog.getContinuousTransaction().getEveryIterationState());
		this.comboBoxWhichDayOfMonth.setValue(
				this.getStringForDayOfMonth(this.transactionDialog.getContinuousTransaction().getDayOfMonth()));

		if (this.transactionDialog.getContinuousTransaction().getDateUntil() != null) {
			this.radioButtonIterateUntil.setSelected(true);
			this.dateUntil.setValue(
					DateUtils.date2LocalDate(this.transactionDialog.getContinuousTransaction().getDateUntil()));
			this.spinnerNumberOfIterations.setDisable(true);
		} else if (this.transactionDialog.getContinuousTransaction().getNumberOfIterations() != null) {
			this.radioButtonIterateNumber.setSelected(true);
			this.spinnerNumberOfIterations.getValueFactory()
					.setValue(this.transactionDialog.getContinuousTransaction().getNumberOfIterations());
			this.dateUntil.setDisable(true);
		} else {
			this.radioButtonNoEndDate.setSelected(true);
		}
	}

	private void initMapping() {
		this.dayOfMonthByMonthlyMapping = new HashMap<>();
		final String key1 = "Am ersten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(key1, DayOfMonth.FIRST);
		final String key2 = "Am zweiten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(key2, DayOfMonth.SECOND);
		final String key3 = "Am dritten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(key3, DayOfMonth.THIRD);
		final String key15 = "Am Fünfzehnten des Monats";
		this.dayOfMonthByMonthlyMapping.put(key15, DayOfMonth.FIFTHTEENS);
		final String keyNextToLast = "Am vorletzten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(keyNextToLast, DayOfMonth.NEXT_TO_LAST);
		final String keyLast = "Am letzten Tag des Monats";
		this.dayOfMonthByMonthlyMapping.put(keyLast, DayOfMonth.LAST);

		this.dayOfMonthStrings = new ArrayList<>();
		this.dayOfMonthStrings.add(key1);
		this.dayOfMonthStrings.add(key2);
		this.dayOfMonthStrings.add(key3);
		this.dayOfMonthStrings.add(key15);
		this.dayOfMonthStrings.add(keyNextToLast);
		this.dayOfMonthStrings.add(keyLast);

	}

	private String getStringForDayOfMonth(final DayOfMonth dayOfMonth) {
		for (final String string : this.dayOfMonthByMonthlyMapping.keySet()) {
			if (dayOfMonth == this.dayOfMonthByMonthlyMapping.get(string)) {
				return string;
			}
		}
		return null;
	}

	public void setTransactionDialog(final TransactionDialog transactionDialog) {
		this.transactionDialog = transactionDialog;
		this.initContinuousTransaction();
	}

	private void close() {
		final Stage stage = (Stage) this.buttonOk.getScene().getWindow();
		stage.close();
	}

}
