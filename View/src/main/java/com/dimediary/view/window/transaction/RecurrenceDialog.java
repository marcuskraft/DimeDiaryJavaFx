package com.dimediary.view.window.transaction;

import java.net.URL;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmfs.rfc5545.Weekday;
import org.dmfs.rfc5545.recur.Freq;
import org.dmfs.rfc5545.recur.RecurrenceRule;
import org.dmfs.rfc5545.recur.RecurrenceRule.WeekdayNum;

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

	private final static Logger log = LogManager.getLogger(RecurrenceDialog.class);

	public enum Frequences {
		MONTHLY("monatlich"), WEEKLY("wöchentlich"), DAILY("täglich"), YEARLY("jährlich"), NONE("keine Wiederholung");

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
				return Frequences.DAILY;
			} else if (YEARLY.getText().equals(frequenceString)) {
				return Frequences.YEARLY;
			} else if (NONE.getText().equals(frequenceString)) {
				return Frequences.NONE;
			}
			return null;
		}
	}

	private static final ObservableList<String> FREQUENCES_LIST = FXCollections.observableArrayList(
			Frequences.MONTHLY.getText(), Frequences.WEEKLY.getText(), Frequences.DAILY.getText(),
			Frequences.YEARLY.getText(), Frequences.NONE.getText());

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
		boolean disableAllOthers = false;
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
		case NONE:
			disableDayOfWeek = true;
			disabledayOfMonthSpinner = true;
			disableAllOthers = true;
		default:
			break;
		}

		this.intervallSpinner.setDisable(disableAllOthers);
		this.noEndRadioButton.setDisable(disableAllOthers);
		this.untilRadiobutton.setDisable(disableAllOthers);
		this.countRadioButton.setDisable(disableAllOthers);
		this.untilDatepicker.setDisable(disableAllOthers);
		this.countSpinner.setDisable(disableAllOthers);

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
		RecurrenceRule recurrenceRule = null;
		if (!Frequences.NONE.getText().equals(this.frequenceCheckbox.getValue())) {
			recurrenceRule = this.createRecurrenceRule();

		}
		this.transactionDialog.setRecurrenceRule(recurrenceRule);
		this.transactionDialog.setNameOfRecurrenceButton(recurrenceRule != null ? recurrenceRule.getFreq() : null);
		this.close();
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
		assert this.montagComboBox != null : "fx:id=\"montagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.dienstagComboBox != null : "fx:id=\"dienstagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.mittwochComboBox != null : "fx:id=\"mittwochComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.donnerstagComboBox != null : "fx:id=\"donnerstagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.freitagComboBox != null : "fx:id=\"freitagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.samstagComboBox != null : "fx:id=\"samstagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";
		assert this.sonntagComboBox != null : "fx:id=\"sonntagComboBox\" was not injected: check your FXML file 'RecurrenceDialog.fxml'.";

		this.frequenceCheckbox.setItems(RecurrenceDialog.FREQUENCES_LIST);
		this.frequenceCheckbox.setValue(Frequences.NONE.getText());

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

		this.onFrequenceCheckbox(null);

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

		switch (recurrenceRule.getFreq()) {
		case DAILY:
			this.frequenceCheckbox.setValue(Frequences.DAILY.getText());
			this.setWeekNums(recurrenceRule.getByDayPart());
			break;
		case MONTHLY:
			this.frequenceCheckbox.setValue(Frequences.MONTHLY.getText());
			this.intervallSpinner.getValueFactory().setValue(recurrenceRule.getInterval());
			break;
		case WEEKLY:
			this.frequenceCheckbox.setValue(Frequences.WEEKLY.getText());
			this.setWeekNums(recurrenceRule.getByDayPart());
			break;
		case YEARLY:
			this.frequenceCheckbox.setValue(Frequences.YEARLY.getText());
			this.intervallSpinner.getValueFactory().setValue(recurrenceRule.getInterval());
			break;
		default:
			log.error("no valid RecurrenceRule for the initializiation of the gui");
			throw new InvalidParameterException("no valid RecurrenceRule for the initializiation of the gui");
		}

		if (recurrenceRule.getCount() != null) {
			this.countRadioButton.setSelected(true);
			this.countSpinner.getValueFactory().setValue(recurrenceRule.getCount());
		} else if (recurrenceRule.getUntil() != null) {
			this.untilRadiobutton.setSelected(true);
			this.untilDatepicker.setValue(DateUtils.dateTimeToLocalDate(recurrenceRule.getUntil()));
		}

		this.onFrequenceCheckbox(null);

	}

	private RecurrenceRule createRecurrenceRule() {

		RecurrenceRule recurrenceRule;

		switch (Frequences.getFrequence(this.frequenceCheckbox.getValue())) {
		case DAILY:
			recurrenceRule = new RecurrenceRule(Freq.DAILY);
			recurrenceRule.setByDayPart(this.getWeekDayNums());
			break;
		case MONTHLY:
			recurrenceRule = new RecurrenceRule(Freq.MONTHLY);
			recurrenceRule.setInterval(this.intervallSpinner.getValue());
			break;
		case WEEKLY:
			recurrenceRule = new RecurrenceRule(Freq.WEEKLY);
			recurrenceRule.setByDayPart(this.getWeekDayNums());
			break;
		case YEARLY:
			recurrenceRule = new RecurrenceRule(Freq.YEARLY);
			recurrenceRule.setInterval(this.intervallSpinner.getValue());
			break;
		default:
			recurrenceRule = new RecurrenceRule(Freq.MONTHLY);
			recurrenceRule.setInterval(this.intervallSpinner.getValue());
			break;

		}

		if (this.untilRadiobutton.isSelected()) {
			recurrenceRule.setUntil(DateUtils.localDateTimeToDateTime(this.untilDatepicker.getValue()));
		} else if (this.countRadioButton.isSelected()) {
			recurrenceRule.setCount(this.countSpinner.getValue());
		}

		return recurrenceRule;
	}

	private List<WeekdayNum> getWeekDayNums() {
		final List<WeekdayNum> weekdayNums = new ArrayList<>();

		int pos = 1;
		if (this.montagComboBox.isSelected()) {
			weekdayNums.add(new WeekdayNum(pos, Weekday.MO));
			pos++;
		}

		if (this.dienstagComboBox.isSelected()) {
			weekdayNums.add(new WeekdayNum(pos, Weekday.TU));
			pos++;
		}

		if (this.mittwochComboBox.isSelected()) {
			weekdayNums.add(new WeekdayNum(pos, Weekday.WE));
			pos++;
		}

		if (this.donnerstagComboBox.isSelected()) {
			weekdayNums.add(new WeekdayNum(pos, Weekday.TH));
			pos++;
		}

		if (this.freitagComboBox.isSelected()) {
			weekdayNums.add(new WeekdayNum(pos, Weekday.FR));
			pos++;
		}

		if (this.samstagComboBox.isSelected()) {
			weekdayNums.add(new WeekdayNum(pos, Weekday.SA));
			pos++;
		}

		if (this.sonntagComboBox.isSelected()) {
			weekdayNums.add(new WeekdayNum(pos, Weekday.SU));
			pos++;
		}

		return weekdayNums;
	}

	private void setWeekNums(List<WeekdayNum> weekdayNums) {

		for (final WeekdayNum weekdayNum : weekdayNums) {
			switch (weekdayNum.weekday) {
			case FR:
				this.freitagComboBox.setSelected(true);
				break;
			case MO:
				this.montagComboBox.setSelected(true);
				break;
			case SA:
				this.samstagComboBox.setSelected(true);
				break;
			case SU:
				this.sonntagComboBox.setSelected(true);
				break;
			case TH:
				this.donnerstagComboBox.setSelected(true);
				break;
			case TU:
				this.dienstagComboBox.setSelected(true);
				break;
			case WE:
				this.mittwochComboBox.setSelected(true);
				break;
			default:
				break;

			}

		}

	}

	private void close() {
		final Stage stage = (Stage) this.frequenceCheckbox.getScene().getWindow();
		stage.close();
	}
}
