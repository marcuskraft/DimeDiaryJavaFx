/**
 * Sample Skeleton for 'DiagramsScene.fxml' Controller Class
 */

package com.dimediary.view.scene;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Category;
import com.dimediary.services.AccountBalanceService;
import com.dimediary.services.CategoryService;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.view.window.util.NumberToDateStringConverter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
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

	@FXML // fx:id="paneTopLeft"
	private BorderPane paneTopLeft; // Value injected by FXMLLoader

	@FXML // fx:id="paneBottomLeft"
	private BorderPane paneBottomLeft; // Value injected by FXMLLoader

	@FXML // fx:id="paneTopRight"
	private BorderPane paneTopRight; // Value injected by FXMLLoader

	@FXML // fx:id="paneBottomRight"
	private BorderPane paneBottomRight; // Value injected by FXMLLoader

	private Month actualMonth;

	private LineChart<Number, Number> lineChart;

	private PieChart pieChart;

	@FXML
	void onComboBoxAccountDiagramm(final ActionEvent event) {
		this.refresh();
	}

	@FXML
	void onDateFromSpinner(final ActionEvent event) {
		this.refresh();
	}

	@FXML
	void onDateUntilSpinner(final ActionEvent event) {
		this.refresh();
	}

	@FXML
	void onMonthbackButton(final ActionEvent event) {
		final LocalDate actualDateFrom = this.dateFromSpinner.getValue();
		final LocalDate actualDateUntil = this.dateUntilSpinner.getValue();
		this.dateFromSpinner.setValue(actualDateFrom.minusMonths(1));
		this.dateUntilSpinner.setValue(actualDateUntil.minusMonths(1));
		this.refresh();
	}

	@FXML
	void onMonthforwardButton(final ActionEvent event) {
		final LocalDate actualDateFrom = this.dateFromSpinner.getValue();
		final LocalDate actualDateUntil = this.dateUntilSpinner.getValue();
		this.dateFromSpinner.setValue(actualDateFrom.plusMonths(1));
		this.dateUntilSpinner.setValue(actualDateUntil.plusMonths(1));
		this.refresh();
	}

	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert this.borderPaneDiagramm != null : "fx:id=\"borderPaneDiagramm\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.comboBoxAccountDiagramm != null : "fx:id=\"comboBoxAccountDiagramm\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.dateFromSpinner != null : "fx:id=\"dateFromSpinner\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.dateUntilSpinner != null : "fx:id=\"dateUntilSpinner\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.monthbackButton != null : "fx:id=\"monthbackButton\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.monthforwardButton != null : "fx:id=\"monthforwardButton\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.paneTopLeft != null : "fx:id=\"paneTopLeft\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.paneBottomLeft != null : "fx:id=\"paneBottomLeft\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.paneTopRight != null : "fx:id=\"paneTopRight\" was not injected: check your FXML file 'Diagrams.fxml'.";
		assert this.paneBottomRight != null : "fx:id=\"paneBottomRight\" was not injected: check your FXML file 'Diagrams.fxml'.";

		this.init();

	}

	private void init() {

		this.refreshComboBoxAccounts();

		this.actualMonth = DateUtils.getActualMonth();

		this.dateFromSpinner.setValue(DateUtils.firstDayOfMonth(this.actualMonth, DateUtils.getActualYear()));
		this.dateUntilSpinner.setValue(DateUtils.lastDayOfMonth(this.actualMonth, DateUtils.getActualYear()));

		this.initializeBalanceDiagramm();

		this.initializeCategoryPieChart();

	}

	private void initializeCategoryPieChart() {

		this.pieChart = new PieChart();

		this.pieChart.setTitle("Kategorien");

		this.refreshPieChart();

		this.paneTopRight.setCenter(this.pieChart);

	}

	private void initializeBalanceDiagramm() {
		final NumberAxis xAxis = new NumberAxis();
		final NumberAxis yAxis = new NumberAxis();
		xAxis.setLabel("Datum");
		yAxis.setLabel("Kontostand");
		xAxis.setTickLabelFormatter(new NumberToDateStringConverter());
		this.lineChart = new LineChart<>(xAxis, yAxis);
		this.refreshBalanceDiagram();
		this.paneBottomRight.setCenter(this.lineChart);
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

	private void refresh() {
		this.refreshBalanceDiagram();
		this.refreshPieChart();
	}

	private void refreshPieChart() {
		final BankAccount bankAccount = DatabaseService.getInstance()
				.getBankAccount(this.comboBoxAccountDiagramm.getValue());

		final Map<Category, Double> calculatePercentageFromTo = CategoryService.calculatePercentageFromTo(bankAccount,
				this.dateFromSpinner.getValue(), this.dateUntilSpinner.getValue());

		final ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

		for (final Entry<Category, Double> entry : calculatePercentageFromTo.entrySet()) {
			pieChartData.add(new PieChart.Data(entry.getKey().getName(), entry.getValue()));
		}

		this.pieChart.setData(pieChartData);
	}

	private void refreshBalanceDiagram() {
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
