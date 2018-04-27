/**
 * Sample Skeleton for 'MainWindow.fxml' Controller Class
 */

package com.dimediary.view.window.main;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;
import com.dimediary.util.balance.AccountBalancer;
import com.dimediary.util.utils.DBUtils;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.view.Main;
import com.dimediary.view.window.bankaccount.BankAccountDialog;
import com.dimediary.view.window.bankaccount.BankaccountCategoryDialog;
import com.dimediary.view.window.category.CategoryDialog;
import com.dimediary.view.window.transaction.TransactionButton;
import com.dimediary.view.window.transaction.TransactionButtonFactory;
import com.dimediary.view.window.transaction.TransactionDialog;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

public class MainWindow {

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

	@FXML // fx:id="overviewTab"
	private Tab overviewTab; // Value injected by FXMLLoader

	@FXML // fx:id="tabPane"
	private TabPane tabPane; // Value injected by FXMLLoader

	@FXML // fx:id="tabJanuary"
	private Tab tabJanuary; // Value injected by FXMLLoader

	@FXML // fx:id="tabFebruary"
	private Tab tabFebruary; // Value injected by FXMLLoader

	@FXML // fx:id="tabMarch"
	private Tab tabMarch; // Value injected by FXMLLoader

	@FXML // fx:id="tabAprile"
	private Tab tabAprile; // Value injected by FXMLLoader

	@FXML // fx:id="tabMay"
	private Tab tabMay; // Value injected by FXMLLoader

	@FXML // fx:id="tabJune"
	private Tab tabJune; // Value injected by FXMLLoader

	@FXML // fx:id="tabJuly"
	private Tab tabJuly; // Value injected by FXMLLoader

	@FXML // fx:id="tabAugust"
	private Tab tabAugust; // Value injected by FXMLLoader

	@FXML // fx:id="tabSeptembre"
	private Tab tabSeptembre; // Value injected by FXMLLoader

	@FXML // fx:id="tabOctober"
	private Tab tabOctober; // Value injected by FXMLLoader

	@FXML // fx:id="tabNovember"
	private Tab tabNovember; // Value injected by FXMLLoader

	@FXML // fx:id="tabDecember"
	private Tab tabDecember; // Value injected by FXMLLoader

	@FXML // fx:id="buttonBack"
	private Button buttonBack; // Value injected by FXMLLoader

	@FXML // fx:id="buttonForward"
	private Button buttonForward; // Value injected by FXMLLoader

	@FXML // fx:id="buttonActualMonth"
	private Button buttonActualMonth; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxAccount"
	private ComboBox<String> comboBoxAccount; // Value injected by FXMLLoader

	@FXML // fx:id="SpinnerYear"
	private Spinner<Integer> SpinnerYear; // Value injected by FXMLLoader

	@FXML // fx:id="buttonAddTransaction"
	private Button buttonAddTransaction; // Value injected by FXMLLoader

	@FXML // fx:id="checkboxAccountlessTransactions"
	private CheckBox checkboxAccountlessTransactions; // Value injected by
														// FXMLLoader

	@FXML // fx:id="diagramTab"
	private Tab diagramTab; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxAccountDiagramm"
	private ComboBox<Integer> comboBoxAccountDiagramm; // Value injected by
														// FXMLLoader

	@FXML // fx:id="dateFromSpinner"
	private DatePicker dateFromSpinner; // Value injected by FXMLLoader

	@FXML // fx:id="dateUntilSpinner"
	private DatePicker dateUntilSpinner; // Value injected by FXMLLoader

	@FXML // fx:id="monthbackButton"
	private Button monthbackButton; // Value injected by FXMLLoader

	@FXML // fx:id="monthforwardButton"
	private Button monthforwardButton; // Value injected by FXMLLoader

	@FXML // fx:id="diagramm"
	private LineChart<Date, Integer> diagramm; // Value injected by FXMLLoader

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.menuClose != null : "fx:id=\"menuClose\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuCategory != null : "fx:id=\"menuCategory\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuAccount != null : "fx:id=\"menuAccount\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.menuAccCategory != null : "fx:id=\"menuAccCategory\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.overviewTab != null : "fx:id=\"overviewTab\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabJanuary != null : "fx:id=\"tabJanuary\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabFebruary != null : "fx:id=\"tabFebruary\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabMarch != null : "fx:id=\"tabMarch\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabAprile != null : "fx:id=\"tabAprile\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabMay != null : "fx:id=\"tabMay\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabJune != null : "fx:id=\"tabJune\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabJuly != null : "fx:id=\"tabJuly\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabAugust != null : "fx:id=\"tabAugust\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabSeptembre != null : "fx:id=\"tabSeptembre\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabOctober != null : "fx:id=\"tabOctober\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabNovember != null : "fx:id=\"tabNovember\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.tabDecember != null : "fx:id=\"tabDecember\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.buttonBack != null : "fx:id=\"buttonBack\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.buttonForward != null : "fx:id=\"buttonForward\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.buttonActualMonth != null : "fx:id=\"buttonActualMonth\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.comboBoxAccount != null : "fx:id=\"comboBoxAccount\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.SpinnerYear != null : "fx:id=\"SpinnerYear\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.buttonAddTransaction != null : "fx:id=\"buttonAddTransaction\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.checkboxAccountlessTransactions != null : "fx:id=\"checkboxAccountlessTransactions\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.diagramTab != null : "fx:id=\"diagramTab\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.comboBoxAccountDiagramm != null : "fx:id=\"comboBoxAccountDiagramm\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.dateFromSpinner != null : "fx:id=\"dateFromSpinner\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.dateUntilSpinner != null : "fx:id=\"dateUntilSpinner\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.monthbackButton != null : "fx:id=\"monthbackButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.monthforwardButton != null : "fx:id=\"monthforwardButton\" was not injected: check your FXML file 'MainWindow.fxml'.";
		assert this.diagramm != null : "fx:id=\"diagramm\" was not injected: check your FXML file 'MainWindow.fxml'.";

		this.checkboxAccountlessTransactions.setSelected(true);
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
	void onAccountlessTransactions(final ActionEvent event) {
		this.refresh();
	}

	@FXML
	void onComboBoxAccount(final ActionEvent event) {
		this.refresh();
	}

	@FXML
	void onButtonActualMonth(final ActionEvent event) {

		this.SpinnerYear.getValueFactory().setValue(DateUtils.getActualYear());

		this.refreshFirst();
	}

	@FXML
	void onButtonAddTransaction(final ActionEvent event) throws IOException {
		final WindowParameters parameters = new WindowParameters();
		parameters.put(MainWindow.class, this);
		final WindowCreater<TransactionDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/TransactionDialog.fxml"),
				"Transaktion erstellen / bearbeiten", parameters);
	}

	@FXML
	void onBackwards(final ActionEvent event) {
		boolean yearChange = false;

		Month month = this.findMonth(this.tabPane.getSelectionModel().getSelectedItem());

		if (month == Month.JANUARY) {
			month = Month.DECEMBER;
			yearChange = true;
		} else {
			final Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.MONTH, month.getValue() - 2);
			// minus 1 because shift between month as value and enum and minus 1
			// because we want to shift by one month
			month = DateUtils.getMonth(calendar.getTime());
		}

		this.tabPane.getSelectionModel().select(this.month2Tabs.get(month));

		this.refreshMonthOverview(month);

		if (yearChange) {
			this.SpinnerYear.getValueFactory().setValue(this.SpinnerYear.getValue() - 1);
		}
	}

	@FXML
	void onComboBoxAccountDiagramm(final ActionEvent event) {

	}

	@FXML
	void onDateFromSpinner(final ActionEvent event) {

	}

	@FXML
	void onDateUntilSpinner(final ActionEvent event) {

	}

	@FXML
	void onDiagramTab(final ActionEvent event) {

	}

	@FXML
	void onMonthbackButton(final ActionEvent event) {

	}

	@FXML
	void onMonthforwardButton(final ActionEvent event) {

	}

	@FXML
	void onOverviewTab(final ActionEvent event) {

	}

	@FXML
	void onForwards(final ActionEvent event) {
		boolean yearChange = false;

		Month month = this.findMonth(this.tabPane.getSelectionModel().getSelectedItem());

		if (month == Month.DECEMBER) {
			month = Month.JANUARY;
			yearChange = true;
		} else {
			final Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.set(Calendar.MONTH, month.getValue());
			// minus 1 because shift between month as value and enum and plus 1
			// because we want to shift by one month
			month = DateUtils.getMonth(calendar.getTime());
		}

		this.tabPane.getSelectionModel().select(this.month2Tabs.get(month));

		this.refreshMonthOverview(month);

		if (yearChange) {
			this.SpinnerYear.getValueFactory().setValue(this.SpinnerYear.getValue() + 1);
		}
	}

	HashMap<Month, Tab> month2Tabs;
	Month actualMonth;

	private void init() {

		this.createOnTabEvents();

		this.createHashMap();

		this.refreshComboBoxAccounts();

		this.initSpinnerYear();

		this.refreshFirst();

	}

	private void initSpinnerYear() {
		final SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(
				1900, 9999999, DateUtils.getActualYear());
		this.SpinnerYear.setValueFactory(spinnerValueFactory);
		this.SpinnerYear.setEditable(true);

		this.SpinnerYear.valueProperty().addListener(new ChangeListener<Integer>() {
			{
			}

			@Override
			public void changed(final ObservableValue<? extends Integer> observable, final Integer oldValue,
					final Integer newValue) {
				MainWindow.this.refresh();
			}
		});
	}

	private void refreshFirst() {
		this.actualMonth = DateUtils.getActualMonth();
		this.refreshMonthOverview(this.actualMonth);

		final SingleSelectionModel<Tab> selectionModel = this.tabPane.getSelectionModel();

		selectionModel.select(this.month2Tabs.get(this.actualMonth));
	}

	public void refreshComboBoxAccounts() {
		final ObservableList<String> bankAccountNames = FXCollections
				.observableArrayList(DBUtils.getInstance().getBankAccountNames());

		if (bankAccountNames == null) {
			return;
		}
		this.comboBoxAccount.setItems(bankAccountNames);

		if (bankAccountNames.size() == 0) {
			return;
		}
		this.comboBoxAccount.setValue(bankAccountNames.get(0));
	}

	public void refresh() {
		this.refreshMonthOverview();
	}

	private void refreshMonthOverview() {
		if (this.actualMonth == null) {
			this.actualMonth = DateUtils.getActualMonth();
		}
		this.refreshMonthOverview(this.actualMonth);
	}

	private void refreshMonthOverview(final Month month) {
		if (month == null) {
			return; // TODO throw exception
		}
		this.actualMonth = month;

		final ArrayList<Date> dates = DateUtils.getDatesForMonth(month, this.SpinnerYear.getValue());
		final String bankaccountName = this.comboBoxAccount.getValue();
		final BankAccount bankAccount = DBUtils.getInstance().getBankAccount(bankaccountName);

		final HashMap<Date, Double> balances = AccountBalancer.getBalancesFollowingDays(bankAccount, dates);

		final HashMap<Date, ArrayList<Transaction>> transactionsForDates = new HashMap<>();

		int maxTransaction = 0;
		for (final Date date : dates) {
			List<Transaction> transactions = DBUtils.getInstance().getTransactions(bankAccount, date);

			if (transactions == null) {
				transactions = new ArrayList<>();
			}

			if (this.checkboxAccountlessTransactions.isSelected()) {
				transactions.addAll(DBUtils.getInstance().getTrandactionsWithoutAccount(date));
			}
			transactionsForDates.put(date, new ArrayList<Transaction>(transactions));
			if (transactions.size() > maxTransaction) {
				maxTransaction = transactions.size();
			}
		}

		final ArrayList<RowConstraints> rowConstraints = new ArrayList<>();
		for (int i = 0; i < dates.size() + 1; i++) {
			final RowConstraints rowConstraint = new RowConstraints();
			rowConstraint.setPercentHeight(100 / (dates.size() + 1));
			rowConstraints.add(rowConstraint);
		}

		final ArrayList<ColumnConstraints> columnConstraints = new ArrayList<>();
		for (int i = 0; i < maxTransaction + 4; i++) {
			final ColumnConstraints columnConstraint = new ColumnConstraints();
			columnConstraint.setMinWidth(50);
			columnConstraint.setMaxWidth(200);
			columnConstraints.add(columnConstraint);
		}

		final Insets insets = new Insets(5, 5, 5, 5);

		final GridPane gridPane = new GridPane();
		gridPane.setPadding(insets);
		gridPane.getRowConstraints().addAll(rowConstraints);
		gridPane.getColumnConstraints().addAll(columnConstraints);

		gridPane.add(new Label("Datum"), 0, 0);
		gridPane.add(new Label("Wochentag"), 1, 0);
		gridPane.add(new Label("Kontostand"), 2, 0);

		final MainWindow mainWindow = this;

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		final SimpleDateFormat simpleDateFormatDay = new SimpleDateFormat("E");
		for (int i = 1; i <= dates.size(); i++) {
			final Double balance = balances.get(dates.get(i - 1));
			String balanceString;
			if (balance == null) {
				balanceString = "";
			} else {
				balanceString = balance.toString();
			}

			final Label labelDate = new Label(simpleDateFormat.format(dates.get(i - 1)));
			final Label labelDay = new Label(simpleDateFormatDay.format(dates.get(i - 1)));
			final Label labelBalance = new Label(balanceString);

			labelDate.setPadding(insets);
			labelBalance.setPadding(insets);
			labelDay.setPadding(insets);

			gridPane.add(labelBalance, 2, i);
			gridPane.add(labelDate, 0, i);
			gridPane.add(labelDay, 1, i);

			final Date date = dates.get(i - 1);
			final ArrayList<Transaction> transactions = transactionsForDates.get(date);

			for (int j = 0; j < transactions.size(); j++) {
				final String text = transactions.get(j).getName() + " : " + transactions.get(j).getAmount();
				final TransactionButton transactionButton = TransactionButtonFactory.createTransactionButton(text,
						transactions.get(j), this);
				transactionButton.setPadding(insets);
				gridPane.add(transactionButton, 3 + j, i);
			}

			for (int j = transactions.size(); j < maxTransaction + 1; j++) {
				final Pane pane = this.getEmptyPane(mainWindow, date);
				gridPane.add(pane, 3 + j, i);
			}

		}

		final ScrollPane scrollPane = new ScrollPane(gridPane);
		this.month2Tabs.get(month).setContent(scrollPane);
		gridPane.setMinSize(0, 0);
		gridPane.setGridLinesVisible(true);

	}

	private Pane getEmptyPane(final MainWindow mainWindow, final Date date) {
		final Pane pane = new Pane();

		pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(final MouseEvent event) {
				if (event.getClickCount() < 2) {
					return;
				}
				if (date != null) {
					final WindowParameters parameters = new WindowParameters();
					parameters.put(MainWindow.class, mainWindow);
					parameters.put(Date.class, date);
					final WindowCreater<TransactionDialog> windowCreater = new WindowCreater<>();
					windowCreater.createWindow(Main.class.getResource("design/window/TransactionDialog.fxml"),
							"Transaktion erstellen / bearbeiten", parameters);
				}
			}
		});

		pane.setOnDragDropped(new EventHandler<DragEvent>() {

			@Override
			public void handle(final DragEvent event) {

				final Transaction transaction;
				final Dragboard dragboard = event.getDragboard();

				final Object object = dragboard.getContent(TransactionButtonFactory.KEY_TRANSACTION);

				if (object instanceof Transaction) {
					transaction = (Transaction) object;
				} else {
					return;
				}

				if (transaction.getContinuousTransaction() == null) {
					final Transaction transactionNew = transaction.getCopy();
					if (dragboard.getTransferModes().contains(TransferMode.MOVE)) {
						DBUtils.getInstance().delete(transaction);
					}
					transactionNew.setDate(date);
					DBUtils.getInstance().persist(transactionNew);
					mainWindow.refresh();
				}
				event.setDropCompleted(true);
				event.consume();
			}
		});

		pane.setOnDragOver(new EventHandler<DragEvent>() {

			@Override
			public void handle(final DragEvent event) {
				event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
				event.consume();
			}
		});

		return pane;
	}

	private Month findMonth(final Tab tab) {
		if (tab == null) {
			return null;
		}
		final ArrayList<Month> months = new ArrayList<>();

		months.add(Month.JANUARY);
		months.add(Month.FEBRUARY);
		months.add(Month.MARCH);
		months.add(Month.APRIL);
		months.add(Month.MAY);
		months.add(Month.JUNE);
		months.add(Month.JULY);
		months.add(Month.AUGUST);
		months.add(Month.SEPTEMBER);
		months.add(Month.OCTOBER);
		months.add(Month.NOVEMBER);
		months.add(Month.DECEMBER);

		for (final Month month : months) {
			if (tab.equals(this.month2Tabs.get(month))) {
				return month;
			}
		}
		return null;
	}

	private void createHashMap() {
		this.month2Tabs = new HashMap<>();
		this.month2Tabs.put(Month.JANUARY, this.tabJanuary);
		this.month2Tabs.put(Month.FEBRUARY, this.tabFebruary);
		this.month2Tabs.put(Month.MARCH, this.tabMarch);
		this.month2Tabs.put(Month.APRIL, this.tabAprile);
		this.month2Tabs.put(Month.MAY, this.tabMay);
		this.month2Tabs.put(Month.JUNE, this.tabJune);
		this.month2Tabs.put(Month.JULY, this.tabJuly);
		this.month2Tabs.put(Month.AUGUST, this.tabAugust);
		this.month2Tabs.put(Month.SEPTEMBER, this.tabSeptembre);
		this.month2Tabs.put(Month.OCTOBER, this.tabOctober);
		this.month2Tabs.put(Month.NOVEMBER, this.tabNovember);
		this.month2Tabs.put(Month.DECEMBER, this.tabDecember);
	}

	private void createOnTabEvents() {
		this.tabJanuary.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.JANUARY);
		});

		this.tabFebruary.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.FEBRUARY);
		});

		this.tabMarch.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.MARCH);
		});

		this.tabAprile.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.APRIL);
		});

		this.tabMay.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.MAY);
		});

		this.tabJune.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.JUNE);
		});

		this.tabJuly.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.JULY);
		});

		this.tabAugust.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.AUGUST);
		});

		this.tabSeptembre.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.SEPTEMBER);
		});

		this.tabOctober.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.OCTOBER);
		});

		this.tabNovember.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.NOVEMBER);
		});

		this.tabDecember.setOnSelectionChanged((event) -> {
			this.refreshMonthOverview(Month.DECEMBER);
		});
	}

}
