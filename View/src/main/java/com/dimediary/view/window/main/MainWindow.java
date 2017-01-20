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
import com.dimediary.view.window.category.CategoryDialog;
import com.dimediary.view.window.transaction.TransactionButtonFactory;
import com.dimediary.view.window.transaction.TransactionDialog;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;

public class MainWindow {

	@FXML // fx:id="menuClose"
	private MenuItem menuClose; // Value injected by FXMLLoader

	@FXML // fx:id="menuCategory"
	private MenuItem menuCategory; // Value injected by FXMLLoader

	@FXML // fx:id="menuAccount"
	private MenuItem menuAccount; // Value injected by FXMLLoader

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

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

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
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

	}

	@FXML
	void onAccountlessTransactions(final ActionEvent event) {

	}

	@FXML
	void onComboBoxAccount(final ActionEvent event) {
		this.refreshMonthOverview();
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
	void onForwards(final ActionEvent event) {
		boolean yearChange = false;

		Month month = this.findMonth(this.tabPane.getSelectionModel().getSelectedItem());

		if (month == Month.DECEMBER) {
			month = Month.JANUARY;
			yearChange = true;
		} else {
			final Calendar calendar = Calendar.getInstance();
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
				MainWindow.this.refreshMonthOverview();
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

	public void refreshMonthOverview() {
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
			final List<Transaction> transactions = DBUtils.getInstance().getTransactions(bankAccount, date);
			// if (Main.getMainWindow().isAccountlessTransactionsEnabled()) {
			// transactions.addAll(DBUtils.getInstance().getTrandactionsWithoutAccount(date));
			// }
			transactionsForDates.put(date, new ArrayList<Transaction>(transactions));
			if (transactions.size() > maxTransaction) {
				maxTransaction = transactions.size();
			}
		}

		final GridPane gridPane = new GridPane();

		gridPane.add(new Label("Datum"), 0, 0);
		gridPane.add(new Label("Wochentag"), 1, 0);
		gridPane.add(new Label("Kontostand"), 2, 0);

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

			gridPane.add(new Label(simpleDateFormat.format(dates.get(i - 1))), 0, i);
			gridPane.add(new Label(simpleDateFormatDay.format(dates.get(i - 1))), 1, i);
			gridPane.add(new Label(balanceString), 2, i);

			final ArrayList<Transaction> transactions = transactionsForDates.get(dates.get(i - 1));

			for (int j = 0; j < transactions.size(); j++) {
				final String text = transactions.get(j).getName() + " : " + transactions.get(j).getAmount();
				gridPane.add(TransactionButtonFactory.createTransactionButton(text, transactions.get(j), this), 3 + j,
						i);
			}

		}

		final ScrollPane scrollPane = new ScrollPane(gridPane);
		this.month2Tabs.get(month).setContent(scrollPane);
		gridPane.setGridLinesVisible(true);

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
