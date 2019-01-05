/**
 * Sample Skeleton for 'MainWindow.fxml' Controller Class
 */

package com.dimediary.view.window.main;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.ResourceBundle;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.services.AccountBalanceService;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.view.Main;
import com.dimediary.view.window.bankaccount.BankAccountDialog;
import com.dimediary.view.window.bankaccount.BankaccountCategoryDialog;
import com.dimediary.view.window.category.CategoryDialog;
import com.dimediary.view.window.util.NumberToDateStringConverter;
import com.dimediary.view.window.util.WindowCreater;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Window;

public class MainWindow extends Window {

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="menuClose"
	private MenuItem menuClose; // Value injected by FXMLLoader

	@FXML // fx:id="menuCategory"
	private MenuItem menuCategory; // Value injected by FXMLLoader

	@FXML // fx:id="menuAccount"
	private MenuItem menuAccount; // Value injected by FXMLLoader

	@FXML // fx:id="menuAccCategory"
	private MenuItem menuAccCategory; // Value injected by FXMLLoader

	@FXML // fx:id="tabPane"
	private TabPane tabPane; // Value injected by FXMLLoader

	@FXML // fx:id="overviewTab"
	private Tab overviewTab; // Value injected by FXMLLoader

	@FXML // fx:id="diagramTab"
	private Tab diagramTab; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxAccountDiagramm"
	private ComboBox<String> comboBoxAccountDiagramm; // Value injected by
														// FXMLLoader

	@FXML // fx:id="dateFromSpinner"
	private DatePicker dateFromSpinner; // Value injected by FXMLLoader

	@FXML // fx:id="dateUntilSpinner"
	private DatePicker dateUntilSpinner; // Value injected by FXMLLoader

	@FXML // fx:id="monthbackButton"
	private Button monthbackButton; // Value injected by FXMLLoader

	@FXML // fx:id="monthforwardButton"
	private Button monthforwardButton; // Value injected by FXMLLoader

	@FXML // fx:id="borderPaneDiagramm"
	private BorderPane borderPaneDiagramm; // Value injected by FXMLLoader

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.menuClose != null : "fx:id=\"menuClose\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuCategory != null : "fx:id=\"menuCategory\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuAccount != null : "fx:id=\"menuAccount\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuAccCategory != null : "fx:id=\"menuAccCategory\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.overviewTab != null : "fx:id=\"overviewTab\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.diagramTab != null : "fx:id=\"diagramTab\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.comboBoxAccountDiagramm != null : "fx:id=\"comboBoxAccountDiagramm\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.dateFromSpinner != null : "fx:id=\"dateFromSpinner\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.dateUntilSpinner != null : "fx:id=\"dateUntilSpinner\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.monthbackButton != null : "fx:id=\"monthbackButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.monthforwardButton != null : "fx:id=\"monthforwardButton\" was not injected: check your FXML file 'MainWindow.fxml'.";

		this.init();

	}

	@FXML
	void onMenuAccount(final ActionEvent event) {
		final WindowCreater<BankAccountDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/AccountDialog.fxml"), "Konten bearbeiten");
	}

	@FXML
	void onMenuCategory(final ActionEvent event) {
		final WindowCreater<CategoryDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/CategoryDialog.fxml"),
				"Kategorien bearbeiten");
	}

	@FXML
	void onMenuClose(final ActionEvent event) {
		Platform.exit();
	}

	@FXML
	void onMenuAccCategory(final ActionEvent event) {
		final WindowCreater<BankaccountCategoryDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/BankaccountCategoryDialog.fxml"),
				"Konto-Kategorien bearbeiten");
	}

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

	Month actualMonth;

	private LineChart<Number, Number> lineChart;

	private void init() {

		this.LoadOverviewTab();

		this.createOnTabEvents();

		this.refreshComboBoxAccounts();

		this.actualMonth = DateUtils.getActualMonth();

		this.dateFromSpinner.setValue(DateUtils.firstDayOfMonth(this.actualMonth, DateUtils.getActualYear()));
		this.dateUntilSpinner.setValue(DateUtils.lastDayOfMonth(this.actualMonth, DateUtils.getActualYear()));

		this.initializeDiagramm();

	}

	public void refreshComboBoxAccounts() {
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

	private void createOnTabEvents() {

		this.overviewTab.setOnSelectionChanged((event) -> {
			this.LoadOverviewTab();
		});

		this.diagramTab.setOnSelectionChanged((event) -> {
			this.refreshDiagram();
		});
	}

	private void LoadOverviewTab() {
		final FXMLLoader loader = new FXMLLoader(Main.class.getResource("design/scene/Overview.fxml"));
		Node node;
		try {
			node = loader.load();
		} catch (final IOException e) {
			throw new IllegalStateException("fxml file could not be found", e);
		}
		this.overviewTab.setContent(node);
	}

}
