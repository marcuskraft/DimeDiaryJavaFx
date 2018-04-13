package com.dimediary.view.window.transaction;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import org.dmfs.rfc5545.recur.RecurrenceRule;

import com.dimediary.util.utils.DateUtils;
import com.dimediary.view.window.util.IWindowParameterInjection;
import com.dimediary.view.window.util.WindowParameters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class RecurrenceDialog implements IWindowParameterInjection {

	public enum Frequences {
		MONTHLY("monatlich"), WEEKLY("wöchentlich"), DAILY("täglich"), YEARLY("jährlich");

		private final String text;

		private Frequences(final String text) {
			this.text = text;
		}

		public String getText() {
			return this.text;
		}

		public static Frequences getFrequence(final String frequenceString) {
			if (MONTHLY.getText().equals(frequenceString)) {
				return Frequences.MONTHLY;
			} else if (WEEKLY.getText().equals(frequenceString)) {
				return Frequences.WEEKLY;
			} else if (DAILY.getText().equals(frequenceString)) {
				return DAILY;
			} else if (YEARLY.getText().equals(frequenceString)) {
				return Frequences.YEARLY;
			}
			return null;
		}
	}

	private static final ObservableList<String> FREQUENCES_LIST = FXCollections.observableArrayList(
			Frequences.MONTHLY.getText(), Frequences.WEEKLY.getText(), Frequences.DAILY.getText(),
			Frequences.YEARLY.getText());

	private static final int MAX_DAY_OF_MONTH = 366;
	private static final int MAX_INTERVALL = 10000;
	private static final int MAX_COUNT = 1000000;

	private TransactionDialog transactionDialog;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ComboBox<String> frequenceCheckbox;

	@FXML
	private Spinner<Integer> intervallSpinner;

	@FXML
	private Spinner<Integer> dayOfMonthSpinner;

	@FXML
	private RadioButton noEndRadioButton;

	@FXML
	private RadioButton countRadioButton;

	@FXML
	private Spinner<Integer> countSpinner;

	@FXML
	private RadioButton untilRadiobutton;

	@FXML
	private DatePicker untilDatepicker;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	@FXML
	private DatePicker beginnDatePicker;

	@FXML
	private CheckBox montagComboBox;

	@FXML
	private CheckBox dienstagComboBox;

	@FXML
	private CheckBox mittwochComboBox;

	@FXML
	private CheckBox donnerstagComboBox;

	@FXML
	private CheckBox freitagComboBox;

	@FXML
	private CheckBox samstagComboBox;

	@FXML
	private CheckBox sonntagComboBox;

	@FXML
	private Label dayOfString;

	@FXML
	private Label intervallString;

	@FXML
	void onBeginnDatePicker(final ActionEvent event) {

	}

	@FXML
	void onCancel(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onCountRadioButton(final ActionEvent event) {
		this.untilDatepicker.setDisable(true);
		this.countSpinner.setDisable(false);
	}

	@FXML
	void onCountSpinner(final MouseEvent event) {

	}

	@FXML
	void onDayOfMonthSpinner(final MouseEvent event) {

	}

	@FXML
	void onFrequenceCheckbox(final ActionEvent event) {
		boolean disableDayOfWeek = true;
		boolean disabledayOfMonthSpinner = false;
		String intervall = "Monat";
		String dayOf = "Tag des Monats";
		switch (Frequences.getFrequence(this.frequenceCheckbox.getValue())) {
		case DAILY:
			disableDayOfWeek = false;
			disabledayOfMonthSpinner = true;
			intervall = "Tag";
			dayOf = "";
			break;
		case WEEKLY:
			disableDayOfWeek = false;
			disabledayOfMonthSpinner = true;
			intervall = "Woche";
			dayOf = "";
			break;
		case MONTHLY:
			disableDayOfWeek = true;
			disabledayOfMonthSpinner = false;
			intervall = "Monat";
			dayOf = "Tag des Monats";
			break;
		case YEARLY:
			disableDayOfWeek = true;
			disabledayOfMonthSpinner = false;
			intervall = "Jahr";
			dayOf = "Tag im Jahr";
			break;

		default:
			break;
		}
		this.montagComboBox.setDisable(disableDayOfWeek);
		this.dienstagComboBox.setDisable(disableDayOfWeek);
		this.mittwochComboBox.setDisable(disableDayOfWeek);
		this.donnerstagComboBox.setDisable(disableDayOfWeek);
		this.freitagComboBox.setDisable(disableDayOfWeek);
		this.samstagComboBox.setDisable(disableDayOfWeek);
		this.sonntagComboBox.setDisable(disableDayOfWeek);

		this.dayOfMonthSpinner.setDisable(disabledayOfMonthSpinner);

		this.intervallString.setText(intervall);
		this.dayOfString.setText(dayOf);
	}

	@FXML
	void onIntervalSpinner(final MouseEvent event) {

	}

	@FXML
	void onNoEndRadioButton(final ActionEvent event) {
		this.untilDatepicker.setDisable(true);
		this.countSpinner.setDisable(true);
	}

	@FXML
	void onOk(final ActionEvent event) {

	}

	@FXML
	void onUntilDatepicker(final ActionEvent event) {

	}

	@FXML
	void onUntilRadiobutton(final ActionEvent event) {
		this.untilDatepicker.setDisable(false);
		this.countSpinner.setDisable(true);
	}

	@FXML
	void initialize() {
		assert this.frequenceCheckbox != null : "fx:id=\"frequenceCheckbox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.intervallSpinner != null : "fx:id=\"intervallSpinner\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.intervallString != null : "fx:id=\"intervallString\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.dayOfMonthSpinner != null : "fx:id=\"dayOfMonthSpinner\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.dayOfString != null : "fx:id=\"dayOfString\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.noEndRadioButton != null : "fx:id=\"noEndRadioButton\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.countRadioButton != null : "fx:id=\"countRadioButton\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.countSpinner != null : "fx:id=\"countSpinner\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.untilRadiobutton != null : "fx:id=\"untilRadiobutton\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.untilDatepicker != null : "fx:id=\"untilDatepicker\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.beginnDatePicker != null : "fx:id=\"beginnDatePicker\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.montagComboBox != null : "fx:id=\"montagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.dienstagComboBox != null : "fx:id=\"dienstagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.mittwochComboBox != null : "fx:id=\"mittwochComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.donnerstagComboBox != null : "fx:id=\"donnerstagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.freitagComboBox != null : "fx:id=\"freitagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.samstagComboBox != null : "fx:id=\"samstagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.sonntagComboBox != null : "fx:id=\"sonntagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";

		this.frequenceCheckbox.setItems(RecurrenceDialog.FREQUENCES_LIST);
		this.frequenceCheckbox.setValue(RecurrenceDialog.FREQUENCES_LIST.get(0));

		final SpinnerValueFactory<Integer> intervallSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
				1, RecurrenceDialog.MAX_INTERVALL, 1);

		this.intervallSpinner.setValueFactory(intervallSpinnerValueFactory);
		this.intervallSpinner.setEditable(true);
		this.intervallSpinner.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				this.intervallSpinner.increment(0); // won't change value, but
													// will
													// commit editor
			}
		});

		final SpinnerValueFactory<Integer> dayOfMonthSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
				1, RecurrenceDialog.MAX_DAY_OF_MONTH, 1);

		this.dayOfMonthSpinner.setValueFactory(dayOfMonthSpinnerValueFactory);
		this.dayOfMonthSpinner.setEditable(true);
		this.dayOfMonthSpinner.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				this.dayOfMonthSpinner.increment(0); // won't change value, but
														// will
														// commit editor
			}
		});

		final SpinnerValueFactory<Integer> countSpinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
				1, RecurrenceDialog.MAX_COUNT, 1);

		this.countSpinner.setValueFactory(countSpinnerValueFactory);
		this.countSpinner.setEditable(true);
		this.countSpinner.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				this.countSpinner.increment(0); // won't change value, but
												// will
												// commit editor
			}
		});

		final ToggleGroup toggleGroup = new ToggleGroup();
		this.noEndRadioButton.setToggleGroup(toggleGroup);
		this.countRadioButton.setToggleGroup(toggleGroup);
		this.untilRadiobutton.setToggleGroup(toggleGroup);

		this.noEndRadioButton.setSelected(true);

		this.untilDatepicker.setValue(DateUtils.date2LocalDate(new Date()));
		this.untilDatepicker.setDisable(true);

		this.beginnDatePicker.setValue(DateUtils.date2LocalDate(new Date()));

		final boolean disableDayOfWeek = true;
		this.montagComboBox.setDisable(disableDayOfWeek);
		this.dienstagComboBox.setDisable(disableDayOfWeek);
		this.mittwochComboBox.setDisable(disableDayOfWeek);
		this.donnerstagComboBox.setDisable(disableDayOfWeek);
		this.freitagComboBox.setDisable(disableDayOfWeek);
		this.samstagComboBox.setDisable(disableDayOfWeek);
		this.sonntagComboBox.setDisable(disableDayOfWeek);

		this.countSpinner.setDisable(true);
	}

	@Override
	public void inject(final WindowParameters parameters) {
		final Object object = parameters.getParameters().get(TransactionDialog.class);
		if (object == null || !(object instanceof TransactionDialog)) {
			throw new IllegalArgumentException(
					"transaction dialog must be set to create a continuous transaction dialog");
		}
		this.transactionDialog = (TransactionDialog) object;

		if (this.transactionDialog == null) {
			throw new IllegalStateException("transactionDialog not injected or has no continuous transaction");
		}

		this.initContinuousTransaction();
	}

	private void initContinuousTransaction() {
		final RecurrenceRule recurrenceRule = this.transactionDialog.getRecurrenceRule();
		if (recurrenceRule != null) {
			this.initRecurrenceRule(recurrenceRule);
		}
	}

	private void initRecurrenceRule(final RecurrenceRule recurrenceRule) {

	}

	private void close() {
		final Stage stage = (Stage) this.frequenceCheckbox.getScene().getWindow();
		stage.close();
	}

}
