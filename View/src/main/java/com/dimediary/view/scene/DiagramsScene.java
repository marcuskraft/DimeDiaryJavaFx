/**
 * Sample Skeleton for 'DiagramsScene.fxml' Controller Class
 */

package com.dimediary.view.scene;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.services.AccountBalanceService;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.view.window.util.NumberToDateStringConverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.BorderPane;

public class DiagramsScene {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="borderPaneDiagramm"
	private BorderPane borderPaneDiagramm; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxAccountDiagramm"
	private ComboBox<String> comboBoxAccountDiagramm; // Value injected by FXMLLoader

	@FXML // fx:id="dateFromSpinner"
	private DatePicker dateFromSpinner; // Value injected by FXMLLoader

	@FXML // fx:id="dateUntilSpinner"
	private DatePicker dateUntilSpinner; // Value injected by FXMLLoader

	@FXML // fx:id="monthbackButton"
	private Button monthbackButton; // Value injected by FXMLLoader

	@FXML // fx:id="monthforwardButton"
	private Button monthforwardButton; // Value injected by FXMLLoader

	private Month actualMonth;

	private LineChart<Number, Number> lineChart;

	@FXML
	void onComboBoxAccountDiagramm(final ActionEvent event) {
		this.refreshDiagram();
	}

	@FXML
	void onDateFromSpinner(final ActionEvent event) {
		this.refreshDiagram();
	}

	@FXML
	void onDateUntilSpinner(final ActionEvent event) {
		this.refreshDiagram();
	}

	@FXML
	void onMonthbackButton(final ActionEvent event) {
		final LocalDate actualDateFrom = this.dateFromSpinner.getValue();
		final LocalDate actualDateUntil = this.dateUntilSpinner.getValue();
		this.dateFromSpinner.setValue(actualDateFrom.minusMonths(1));
		this.dateUntilSpinner.setValue(actualDateUntil.minusMonths(1));
		this.refreshDiagram();
	}

	@FXML
	void onMonthforwardButton(final ActionEvent event) {
		final LocalDate actualDateFrom = this.dateFromSpinner.getValue();
		final LocalDate actualDateUntil = this.dateUntilSpinner.getValue();
		this.dateFromSpinner.setValue(actualDateFrom.plusMonths(1));
		this.dateUntilSpinner.setValue(actualDateUntil.plusMonths(1));
		this.refreshDiagram();
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert this.borderPaneDiagramm != null : "fx:id=\"borderPaneDiagramm\" was not injected: check your FXML file 'DiagramsScene.fxml'.";
		assert this.comboBoxAccountDiagramm != null : "fx:id=\"comboBoxAccountDiagramm\" was not injected: check your FXML file 'DiagramsScene.fxml'.";
		assert this.dateFromSpinner != null : "fx:id=\"dateFromSpinner\" was not injected: check your FXML file 'DiagramsScene.fxml'.";
		assert this.dateUntilSpinner != null : "fx:id=\"dateUntilSpinner\" was not injected: check your FXML file 'DiagramsScene.fxml'.";
		assert this.monthbackButton != null : "fx:id=\"monthbackButton\" was not injected: check your FXML file 'DiagramsScene.fxml'.";
		assert this.monthforwardButton != null : "fx:id=\"monthforwardButton\" was not injected: check your FXML file 'DiagramsScene.fxml'.";

		this.init();

	}

	private void init() {

		this.refreshComboBoxAccounts();

		this.actualMonth = DateUtils.getActualMonth();

		this.dateFromSpinner.setValue(DateUtils.firstDayOfMonth(this.actualMonth, DateUtils.getActualYear()));
		this.dateUntilSpinner.setValue(DateUtils.lastDayOfMonth(this.actualMonth, DateUtils.getActualYear()));

		this.initializeDiagramm();

	}

	private void initializeDiagramm() {
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Datum");
		yAxis.setLabel("Kontostand");

		xAxis.setTickLabelFormatter(new NumberToDateStringConverter());

		this.lineChart = new LineChart<>(xAxis, yAxis);

		this.refreshDiagram();

		this.borderPaneDiagramm.setCenter(this.lineChart);

	}

	private void refreshComboBoxAccounts() {
		final ObservableList<String> bankAccountNames = FXCollections
				.observableArrayList(DatabaseService.getInstance().getBankAccountNames());

		if (bankAccountNames == null) {
			return;
		}

		this.comboBoxAccountDiagramm.setItems(bankAccountNames);

		if (bankAccountNames.size() == 0) {
			return;
		}

		this.comboBoxAccountDiagramm.setValue(bankAccountNames.get(0));

	}

	private void refreshDiagram() {
		final Series<Number, Number> series = new Series<>();

		final BankAccount bankAccount = DatabaseService.getInstance()
				.getBankAccount(this.comboBoxAccountDiagramm.getValue());

		if (bankAccount == null) {
			return;
		}

		series.setName("Kontostand " + bankAccount.getName());

		final List<LocalDate> localDates = DateUtils.getLocalDatesFromTo(this.dateFromSpinner.getValue(),
				this.dateUntilSpinner.getValue());

		for (final LocalDate localDate : localDates) {
			final Double balance = AccountBalanceService.getBalance(bankAccount, localDate);
			series.getData().add(new XYChart.Data<Number, Number>(Long.valueOf(localDate.toEpochDay()),
					balance != null ? balance : 0.0));
		}

		this.lineChart.getData().clear();
		this.lineChart.getData().add(series);

		final NumberAxis xAxis = (NumberAxis) this.lineChart.getXAxis();

		xAxis.setAutoRanging(false);
		xAxis.setLowerBound(localDates.get(0).toEpochDay());
		xAxis.setUpperBound(localDates.get(localDates.size() - 1).toEpochDay());

	}

}
