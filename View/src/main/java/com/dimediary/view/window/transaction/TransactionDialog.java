/**
 * Sample Skeleton for 'TransactionDialog.fxml' Controller Class
 */

package com.dimediary.view.window.transaction;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.util.utils.DBUtils;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.view.Main;
import com.dimediary.view.window.bankaccount.BankAccountDialog;
import com.dimediary.view.window.category.CategoryDialog;
import com.dimediary.view.window.main.MainWindow;
import com.dimediary.view.window.util.IWindowParameterInjection;
import com.dimediary.view.window.util.WindowCreater;
import com.dimediary.view.window.util.WindowParameters;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TransactionDialog implements IWindowParameterInjection {

	private Transaction transaction = null;
	private ContinuousTransaction continuousTransaction = null;
	private MainWindow mainWindow = null;
	private ArrayList<Date> dates = null;

	public static final Double MAX_AMOUNT = 999999999.99;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="buttonAdd"
	private Button buttonAdd; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCancel"
	private Button buttonCancel; // Value injected by FXMLLoader

	@FXML // fx:id="datePicker"
	private DatePicker datePicker; // Value injected by FXMLLoader

	@FXML // fx:id="textFieldName"
	private TextField textFieldName; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxCategory"
	private ComboBox<String> comboBoxCategory; // Value injected by FXMLLoader

	@FXML // fx:id="comboBoxAccount"
	private ComboBox<String> comboBoxAccount; // Value injected by FXMLLoader

	@FXML // fx:id="spinnerAmount"
	private Spinner<Double> spinnerAmount; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxNoCategory"
	private CheckBox checkBoxNoCategory; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxNoAccount"
	private CheckBox checkBoxNoAccount; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCreateCategory"
	private Button buttonCreateCategory; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCreateAccount"
	private Button buttonCreateAccount; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxIncome"
	private CheckBox checkBoxIncome; // Value injected by FXMLLoader

	@FXML // fx:id="checkBoxIterate"
	private CheckBox checkBoxIterate; // Value injected by FXMLLoader

	@FXML // fx:id="buttonIterate"
	private Button buttonIterate; // Value injected by FXMLLoader

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.buttonAdd != null : "fx:id=\"buttonAdd\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.textFieldName != null : "fx:id=\"textFieldName\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.comboBoxCategory != null : "fx:id=\"comboBoxCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.comboBoxAccount != null : "fx:id=\"comboBoxAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.spinnerAmount != null : "fx:id=\"spinnerAmount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkBoxNoCategory != null : "fx:id=\"checkBoxNoCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkBoxNoAccount != null : "fx:id=\"checkBoxNoAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonCreateCategory != null : "fx:id=\"buttonCreateCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonCreateAccount != null : "fx:id=\"buttonCreateAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkBoxIncome != null : "fx:id=\"checkBoxIncome\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkBoxIterate != null : "fx:id=\"checkBoxIterate\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonIterate != null : "fx:id=\"buttonIterate\" was not injected: check your FXML file 'TransactionDialog.fxml'.";

		this.refreshCategories(true);
		this.refreshBankAccounts(true);

		this.datePicker.setValue(DateUtils.date2LocalDate(new Date()));

		this.textFieldName.setText("");

		final SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,
				TransactionDialog.MAX_AMOUNT, 0.0) {

		};

		this.spinnerAmount.setValueFactory(spinnerValueFactory);
		this.spinnerAmount.setEditable(true);
		this.spinnerAmount.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				this.spinnerAmount.increment(0); // won't change value, but will
													// commit editor
			}
		});

		this.buttonIterate.setDisable(true);
	}

	public void initTransaction(final Transaction transaction) {
		this.transaction = transaction;
		this.continuousTransaction = null;
		this.initTransaction();
	}

	public void initTransaction() {
		if (this.transaction == null) {
			throw new IllegalStateException("transaction is not set to an instance!");
		}
		this.refreshCategories(true);
		this.refreshBankAccounts(true);
		this.buttonIterate.setDisable(true);

		this.datePicker.setValue(DateUtils.date2LocalDate(this.transaction.getDate()));
		this.textFieldName.setText(this.transaction.getName());

		final Double amount = this.transaction.getAmount();
		this.checkBoxIncome.setSelected(amount > 0.0);
		this.spinnerAmount.getValueFactory().setValue(Math.abs(amount));

		this.checkBoxIterate.setDisable(true);
	}

	private void initContinuousTransaction() {

		this.transaction = null;

		this.refreshCategories(true);
		this.refreshBankAccounts(true);

		this.checkBoxIterate.setSelected(true);
		this.checkBoxIterate.setDisable(true);

		this.datePicker.setValue(DateUtils.date2LocalDate(this.continuousTransaction.getDateBeginn()));

		this.textFieldName.setText(this.continuousTransaction.getName());

		final Double amount = this.continuousTransaction.getAmount();
		this.checkBoxIncome.setSelected(amount > 0.0);
		this.spinnerAmount.getValueFactory().setValue(Math.abs(amount));

		this.checkBoxIterate.setSelected(true);
		this.buttonIterate.setDisable(false);
		switch (this.continuousTransaction.getIterationState()) {
		case MONTHLY:
			this.buttonIterate.setText("monatlich");
			break;

		default:
			break;
		}
	}

	@FXML
	void onButtonAdd(final ActionEvent event) {
		if (this.transaction != null) {
			this.mergeTransaction();
		} else if (this.continuousTransaction != null) {
			this.mergeContinuousTransaction();
		} else {
			if (this.checkBoxIterate.isSelected()) {
				this.addContinuousTransaction();
			} else {
				this.addSingleTransaction();
			}
		}
	}

	@FXML
	void onButtonCancel(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onButtonIterate(final ActionEvent event) {
		final WindowParameters parameters = new WindowParameters();
		parameters.put(TransactionDialog.class, this);

		final WindowCreater<ContinuousTransactionDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/ContinuousTransactionDialog.fxml"),
				"Transaktion erstellen / bearbeiten", parameters);
	}

	@FXML
	void onCheckboxIterate(final ActionEvent event) {
		this.buttonIterate.setDisable(!this.checkBoxIterate.isSelected());
	}

	@FXML
	void onCreateAccount(final ActionEvent event) {
		final WindowParameters parameters = new WindowParameters();
		parameters.put(TransactionDialog.class, this);
		final WindowCreater<BankAccountDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/AccountDialog.fxml"), "Konten bearbeiten",
				parameters);
	}

	@FXML
	void onCreateCategory(final ActionEvent event) {
		final WindowParameters parameters = new WindowParameters();
		parameters.put(TransactionDialog.class, this);
		final WindowCreater<CategoryDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/CategoryDialog.fxml"), "Kategorien bearbeiten",
				parameters);
	}

	@FXML
	void onCheckBoxIncome(final ActionEvent event) {

	}

	@FXML
	void onNoCategory(final ActionEvent event) {
		if (this.checkBoxNoCategory.isSelected()) {
			this.comboBoxCategory.setValue("-");
			this.comboBoxCategory.setEditable(false);
		} else {
			this.comboBoxCategory.setEditable(true);
			this.refreshCategories(false);
		}
	}

	@FXML
	void onNoAccount(final ActionEvent event) {
		if (this.checkBoxNoAccount.isSelected()) {
			this.comboBoxAccount.setValue("-");
			this.comboBoxAccount.setEditable(false);
		} else {
			this.comboBoxAccount.setEditable(true);
			this.refreshBankAccounts(false);
		}
	}

	private void mergeContinuousTransaction() {
		this.setTransactionAttributes(this.continuousTransaction);
		switch (this.continuousTransaction.getIterationState()) {
		case MONTHLY:
			this.dates = DateUtils.getMonthlyDates(this.continuousTransaction.getEveryIterationState(),
					this.continuousTransaction.getDayOfMonth(), this.continuousTransaction.getDateBeginn(),
					this.continuousTransaction.getDateUntil(), this.continuousTransaction.getNumberOfIterations());
			break;
		case DAYLI:

			break;
		case WEEKLY:

			break;

		case YEARLY:

			break;
		default:
			break;
		}

		final WindowParameters parameters = new WindowParameters();
		parameters.put(TransactionDialog.class, this);

		final WindowCreater<MergeContinuousTransactionDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/MergeContinuousTransactionDialog.fxml"),
				"Ab wann?", parameters);

	}

	public void mergeContinuousTransaction(final Date date) {
		final ArrayList<Transaction> oldTransactions = DBUtils.getInstance()
				.getTransactionsFromDate(this.continuousTransaction, date);
		DBUtils.getInstance().deleteTransactions(oldTransactions);
		this.dates = DateUtils.removeDatesBefore(this.dates, date);
		final ArrayList<Transaction> newTransActions = this.createTransactions(this.continuousTransaction, this.dates);

		this.persist(this.continuousTransaction, newTransActions);
		if (this.mainWindow != null) {
			this.mainWindow.refreshMonthOverview();
		}
		this.close();
	}

	public void mergAllContinuousTransactions() {
		final ArrayList<Transaction> oldTransactions = DBUtils.getInstance()
				.getTransactions(this.continuousTransaction);
		DBUtils.getInstance().deleteTransactions(oldTransactions);
		final ArrayList<Transaction> newTransActions = this.createTransactions(this.continuousTransaction, this.dates);

		this.persist(this.continuousTransaction, newTransActions);
		if (this.mainWindow != null) {
			this.mainWindow.refreshMonthOverview();
		}
		this.close();
	}

	public void deleteContinuousTransaction(final Date dateFrom) {
		final ArrayList<Transaction> transactionsToDelete = DBUtils.getInstance()
				.getTransactionsFromDate(this.continuousTransaction, dateFrom);
		DBUtils.getInstance().deleteTransactions(transactionsToDelete);
		this.continuousTransaction.setDateUntil(DateUtils.substractOnDay(dateFrom));
		DBUtils.getInstance().merge(this.continuousTransaction);
	}

	public void deleteAllContinuousTransactions() {
		DBUtils.getInstance().deleteAllContinuousTransactions(this.continuousTransaction);
	}

	private ArrayList<Transaction> createTransactions(final ContinuousTransaction continuousTransaction,
			final ArrayList<Date> dates) {
		final ArrayList<Transaction> transactions = new ArrayList<>();

		for (final Date date : dates) {
			final Transaction transaction = new Transaction();
			transaction.setAmount(continuousTransaction.getAmount());
			transaction.setBankAccount(continuousTransaction.getBankAccount());
			transaction.setCategory(continuousTransaction.getCategory());
			transaction.setDate(date);
			transaction.setContinuousTransaction(continuousTransaction);
			transaction.setName(continuousTransaction.getName());
			transaction.setUser(continuousTransaction.getUser());
			transactions.add(transaction);
		}
		return transactions;
	}

	private void mergeTransaction() {
		DBUtils.getInstance().delete(this.transaction);
		this.addSingleTransaction();
	}

	private void addSingleTransaction() {
		final Transaction transaction = new Transaction();
		this.setTransactionAttributes(transaction);
		DBUtils.getInstance().persist(transaction);
		if (this.mainWindow != null) {
			this.mainWindow.refreshMonthOverview();
		}
		this.close();
	}

	private void setTransactionAttributes(final Transaction transaction) {
		Double amount;
		final Double value = this.spinnerAmount.getValue();
		if (this.checkBoxIncome.isSelected()) {
			amount = Math.abs(value);
		} else {
			amount = -Math.abs(value);
		}
		transaction.setAmount(amount);

		if (this.checkBoxNoAccount.isSelected()) {
			transaction.setBankAccount(null);
		} else {
			transaction.setBankAccount(DBUtils.getInstance().getBankAccount(this.comboBoxAccount.getValue()));
		}

		if (this.checkBoxNoCategory.isSelected()) {
			transaction.setCategory(null);
		} else {
			transaction.setCategory(DBUtils.getInstance().getCategory(this.comboBoxCategory.getValue()));
		}

		transaction.setDate(DateUtils.localDateToDate(this.datePicker.getValue()));
		transaction.setName(this.textFieldName.getText());
		transaction.setUser(null);
	}

	private void setTransactionAttributes(final ContinuousTransaction continuousTransaction) {
		Double amount;
		if (this.checkBoxIncome.isSelected()) {
			amount = Math.abs(this.spinnerAmount.getValue());
		} else {
			amount = -Math.abs(this.spinnerAmount.getValue());
		}
		continuousTransaction.setAmount(amount);

		if (this.checkBoxNoAccount.isSelected()) {
			continuousTransaction.setBankAccount(null);
		} else {
			continuousTransaction.setBankAccount(DBUtils.getInstance().getBankAccount(this.comboBoxAccount.getValue()));
		}

		if (this.checkBoxNoCategory.isSelected()) {
			continuousTransaction.setCategory(null);
		} else {
			continuousTransaction.setCategory(DBUtils.getInstance().getCategory(this.comboBoxCategory.getValue()));
		}

		continuousTransaction.setDateBeginn(DateUtils.localDateToDate(this.datePicker.getValue()));
		continuousTransaction.setName(this.textFieldName.getText());
		continuousTransaction.setUser(null);
	}

	private void addContinuousTransaction() {
		this.setTransactionAttributes(this.continuousTransaction);
		ArrayList<Date> dates = new ArrayList<>();
		switch (this.continuousTransaction.getIterationState()) {
		case MONTHLY:
			dates = DateUtils.getMonthlyDates(this.continuousTransaction.getEveryIterationState(),
					this.continuousTransaction.getDayOfMonth(), this.continuousTransaction.getDateBeginn(),
					this.continuousTransaction.getDateUntil(), this.continuousTransaction.getNumberOfIterations());
			break;
		case DAYLI:

			break;
		case WEEKLY:

			break;

		case YEARLY:

			break;
		default:
			break;
		}

		final ArrayList<Transaction> transactions = this.createTransactions(dates);
		this.persist(this.continuousTransaction, transactions);
		if (this.mainWindow != null) {
			this.mainWindow.refreshMonthOverview();
		}
		this.close();
	}

	private void persist(final ContinuousTransaction continuousTransaction2,
			final ArrayList<Transaction> transactions) {
		DBUtils.getInstance().persistContinuousTransaction(this.continuousTransaction, transactions);
	}

	private ArrayList<Transaction> createTransactions(final ArrayList<Date> dates) {
		final ArrayList<Transaction> transactions = new ArrayList<>();

		for (final Date date : dates) {
			final Transaction transaction = new Transaction();
			transaction.setAmount(this.continuousTransaction.getAmount());
			transaction.setBankAccount(this.continuousTransaction.getBankAccount());
			transaction.setCategory(this.continuousTransaction.getCategory());
			transaction.setDate(date);
			transaction.setContinuousTransaction(this.continuousTransaction);
			transaction.setName(this.continuousTransaction.getName());
			transaction.setUser(this.continuousTransaction.getUser());
			transactions.add(transaction);
		}
		return transactions;
	}

	private void refreshBankAccounts(final boolean refreshFirst) {
		final ObservableList<String> bankAccountNames = FXCollections
				.observableArrayList(DBUtils.getInstance().getBankAccountNames());

		if (bankAccountNames == null) {
			return;
		}
		this.comboBoxAccount.setItems(bankAccountNames);

		if (bankAccountNames.size() == 0) {
			return;
		}
		if (this.transaction != null) {
			if (this.transaction.getBankAccount() != null) {
				this.comboBoxAccount.setValue(this.transaction.getBankAccount().getName());
			} else {
				this.comboBoxAccount.setValue("-");
				if (refreshFirst) {
					this.comboBoxAccount.setEditable(false);
					this.checkBoxNoAccount.setSelected(true);
				} else {
					this.comboBoxAccount.setEditable(true);
				}
			}
		} else if (this.continuousTransaction != null) {
			if (this.continuousTransaction.getBankAccount() != null) {
				this.comboBoxAccount.setValue(this.continuousTransaction.getBankAccount().getName());
			} else {
				this.comboBoxAccount.setValue("-");
				if (refreshFirst) {
					this.comboBoxAccount.setEditable(false);
					this.checkBoxNoAccount.setSelected(true);
				} else {
					this.comboBoxAccount.setEditable(true);
				}
			}
		} else {
			this.comboBoxAccount.setValue(bankAccountNames.get(0));
		}
	}

	public void refreshBankAccounts() {
		this.refreshBankAccounts(false);
	}

	private void refreshCategories(final boolean refreshFirst) {
		final ObservableList<String> categoryNames = FXCollections
				.observableArrayList(DBUtils.getInstance().getCategoryNames());

		if (categoryNames == null) {
			return;
		}
		this.comboBoxCategory.setItems(categoryNames);

		if (categoryNames.size() == 0) {
			this.comboBoxCategory.setValue("-");
			return;
		}

		if (this.transaction != null) {
			if (this.transaction.getCategory() != null) {
				this.comboBoxCategory.setValue(this.transaction.getCategory().getName());
			} else {
				this.comboBoxCategory.setValue("-");
				if (refreshFirst) {
					this.comboBoxCategory.setEditable(false);
					this.checkBoxNoCategory.setSelected(true);
				} else {
					this.comboBoxCategory.setEditable(true);
				}

			}
		} else if (this.continuousTransaction != null) {
			if (this.continuousTransaction.getCategory() != null) {
				this.comboBoxCategory.setValue(this.continuousTransaction.getCategory().getName());
			} else {
				this.comboBoxCategory.setValue("-");
				if (refreshFirst) {
					this.comboBoxCategory.setEditable(false);
					this.checkBoxNoCategory.setSelected(true);
				} else {
					this.comboBoxCategory.setEditable(true);
				}
			}
		} else {
			this.comboBoxCategory.setValue(categoryNames.get(0));
		}

	}

	public void refreshCategories() {
		this.refreshCategories(false);
	}

	public void close() {
		final Stage stage = (Stage) this.buttonAdd.getScene().getWindow();
		stage.close();
	}

	public ContinuousTransaction getContinuousTransaction() {
		return this.continuousTransaction;
	}

	@Override
	public void inject(final WindowParameters parameters) {
		Object object = parameters.getParameters().get(MainWindow.class);
		if (object == null || !(object instanceof MainWindow)) {
			throw new IllegalArgumentException("mainwindow must be set to create a transaction dialog");
		}
		this.mainWindow = (MainWindow) object;

		object = parameters.getParameters().get(Transaction.class);
		if (object != null && object instanceof Transaction) {
			this.transaction = (Transaction) object;
		}

		object = parameters.getParameters().get(ContinuousTransaction.class);
		if (object != null && object instanceof ContinuousTransaction) {
			this.continuousTransaction = (ContinuousTransaction) object;
		}

		object = parameters.getParameters().get(Date.class);
		if (object != null && object instanceof Date) {
			this.datePicker.setValue(DateUtils.date2LocalDate((Date) object));
		}

		if (this.transaction != null && this.continuousTransaction != null) {
			throw new IllegalArgumentException(
					"it's not possible to create a transaction dialog for a transaction and a continuous transaction together");
		}

		if (this.transaction != null) {
			this.initTransaction();
			return;
		}

		if (this.continuousTransaction != null) {
			this.initContinuousTransaction();
			return;
		}

	}

	public void setContinuousTransaction(final ContinuousTransaction continuousTransaction) {
		this.continuousTransaction = continuousTransaction;
	}

	public Transaction getTransaction() {
		return this.transaction;
	}

	public void setTransaction(final Transaction transaction) {
		this.transaction = transaction;
	}

}
