package com.dimediary.view.window.transaction;

/**
 * Sample Skeleton for 'TransactionDialog.fxml' Controller Class
 */

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmfs.rfc5545.recur.Freq;
import org.dmfs.rfc5545.recur.RecurrenceRule;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Category;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.services.ContinuousTransactionService;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.util.utils.RecurrenceRuleUtils;
import com.dimediary.view.Main;
import com.dimediary.view.scene.OverviewScene;
import com.dimediary.view.window.transaction.RecurrenceDialog.Frequences;
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

	private static final String HYPHEN = "-";

	private final static Logger log = LogManager.getLogger(TransactionDialog.class);

	public static final Double MAX_AMOUNT = 999999999.99;

	private OverviewScene overviewScene;

	private Transaction transaction;

	private ContinuousTransaction continuousTransaction;

	private RecurrenceRule recurrenceRule;

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="fieldDescription"
	private TextField fieldDescription; // Value injected by FXMLLoader

	@FXML // fx:id="datepicker"
	private DatePicker datepicker; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxCategory"
	private ComboBox<String> comboboxCategory; // Value injected by FXMLLoader

	@FXML // fx:id="checkboxCategory"
	private CheckBox checkboxCategory; // Value injected by FXMLLoader

	@FXML // fx:id="comboboxAccount"
	private ComboBox<String> comboboxAccount; // Value injected by
												// FXMLLoader

	@FXML // fx:id="checkboxIncome"
	private CheckBox checkboxIncome; // Value injected by FXMLLoader

	@FXML // fx:id="checkboxAccount"
	private CheckBox checkboxAccount; // Value injected by FXMLLoader

	@FXML // fx:id="spinnerAmount"
	private Spinner<Double> spinnerAmount; // Value injected by FXMLLoader

	@FXML // fx:id="buttonRecurrence"
	private Button buttonRecurrence; // Value injected by FXMLLoader

	@FXML // fx:id="buttonOk"
	private Button buttonOk; // Value injected by FXMLLoader

	@FXML // fx:id="buttonCancel"
	private Button buttonCancel; // Value injected by FXMLLoader

	@FXML
	void onButtonCancel(final ActionEvent event) {
		this.close();
	}

	@FXML
	void onButtonOk(final ActionEvent event) {
		if (this.transaction != null) {
			if (this.recurrenceRule == null) {
				this.changeTransaction(true);
			} else {
				this.changeNewContinuousTransactionFromTransaction(true);
			}
		} else if (this.continuousTransaction != null) {
			if (this.recurrenceRule == null) {
				this.changeContinuesTransactionToTransaction();
			} else {
				this.changeContinuousTransaction();
			}
		} else {
			if (this.recurrenceRule == null) {
				this.createNewTransaction(true);
			} else {
				this.createNewContinuousTransaction(true);
			}
		}
	}

	@FXML
	void onButtonRecurrence(final ActionEvent event) {
		final WindowParameters parameters = new WindowParameters();
		parameters.put(TransactionDialog.class, this);
		final WindowCreater<RecurrenceDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/RecurrenceDialog.fxml"), "Wiederholung",
				parameters);
	}

	@FXML
	void onCheckboxAccount(final ActionEvent event) {
		if (this.checkboxAccount.isSelected()) {
			this.comboboxAccount.setEditable(false);
			if (!this.comboboxAccount.getItems().contains(TransactionDialog.HYPHEN)) {
				this.comboboxAccount.getItems().add(TransactionDialog.HYPHEN);
			}
			this.comboboxAccount.setValue(TransactionDialog.HYPHEN);
			this.comboboxAccount.setDisable(true);
		} else {
			this.comboboxAccount.getItems().remove(TransactionDialog.HYPHEN);
			this.comboboxAccount.setDisable(false);
			this.refreshBankAccounts();
		}
	}

	@FXML
	void onCheckboxCategory(final ActionEvent event) {
		if (this.checkboxCategory.isSelected()) {
			this.comboboxCategory.setEditable(false);
			if (!this.comboboxCategory.getItems().contains(TransactionDialog.HYPHEN)) {
				this.comboboxCategory.getItems().add(TransactionDialog.HYPHEN);
			}
			this.comboboxCategory.setValue(TransactionDialog.HYPHEN);
			this.comboboxCategory.setDisable(true);
		} else {
			this.comboboxCategory.getItems().remove(TransactionDialog.HYPHEN);
			this.comboboxCategory.setDisable(false);
			this.refreshCategories();
		}
	}

	@FXML
	void onComboboxAccount(final ActionEvent event) {

	}

	@FXML
	void onCheckboxIncome(final ActionEvent event) {

	}

	@FXML
	void onComboboxCategory(final ActionEvent event) {

	}

	@FXML
	void onDatepicker(final ActionEvent event) {

	}

	@FXML
	void onFieldDescription(final ActionEvent event) {

	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert this.fieldDescription != null : "fx:id=\"fieldDescription\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.datepicker != null : "fx:id=\"datepicker\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.comboboxCategory != null : "fx:id=\"comboboxCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkboxCategory != null : "fx:id=\"checkboxCategory\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.comboboxAccount != null : "fx:id=\"comboboxAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.checkboxAccount != null : "fx:id=\"checkboxAccount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.spinnerAmount != null : "fx:id=\"spinnerAmount\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonRecurrence != null : "fx:id=\"buttonRecurrence\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonOk != null : "fx:id=\"buttonOk\" was not injected: check your FXML file 'TransactionDialog.fxml'.";
		assert this.buttonCancel != null : "fx:id=\"buttonCancel\" was not injected: check your FXML file 'TransactionDialog.fxml'.";

		this.refreshCategories();
		this.refreshBankAccounts();

		this.datepicker.setValue(LocalDate.now());

		this.fieldDescription.setText("");

		final SpinnerValueFactory<Double> spinnerValueFactory = new SpinnerValueFactory.DoubleSpinnerValueFactory(0.0,
				TransactionDialog.MAX_AMOUNT, 0.0);

		this.spinnerAmount.setValueFactory(spinnerValueFactory);
		this.spinnerAmount.setEditable(true);
		this.spinnerAmount.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue) {
				this.spinnerAmount.increment(0); // won't change value, but will
													// commit editor
			}
		});

	}

	public RecurrenceRule getRecurrenceRule() {
		return this.recurrenceRule;
	}

	public void setRecurrenceRule(final RecurrenceRule recurrenceRule) {
		this.recurrenceRule = recurrenceRule;
	}

	public int getActualDayOfMonth() {
		return this.datepicker.getValue().getDayOfMonth();
	}

	public int getActualDayOfYear() {
		return this.datepicker.getValue().getDayOfYear();
	}

	public DayOfWeek getDayOfWeek() {
		return this.datepicker.getValue().getDayOfWeek();
	}

	private void refreshCategories() {
		final ObservableList<String> categoryNames = FXCollections
				.observableArrayList(DatabaseService.getInstance().getCategoryNames());

		if (categoryNames == null) {
			return;
		}

		this.comboboxCategory.setItems(categoryNames);

		if (categoryNames.size() == 0) {
			this.comboboxCategory.setValue(TransactionDialog.HYPHEN);
			return;
		}

		if (this.transaction != null) {
			if (this.transaction.getCategory() == null) {
				this.comboboxCategory.setEditable(false);
				if (!this.comboboxCategory.getItems().contains(TransactionDialog.HYPHEN)) {
					this.comboboxCategory.getItems().add(TransactionDialog.HYPHEN);
				}
				this.comboboxCategory.setValue(TransactionDialog.HYPHEN);
				this.checkboxCategory.setSelected(true);
			} else {
				this.comboboxCategory.setEditable(true);
				this.comboboxCategory.getItems().remove(TransactionDialog.HYPHEN);
				this.comboboxCategory.setValue(this.transaction.getCategory().getName());
				this.checkboxCategory.setSelected(false);
			}
		} else if (this.continuousTransaction != null) {
			if (this.continuousTransaction.getCategory() == null) {
				this.comboboxCategory.setEditable(false);
				if (!this.comboboxCategory.getItems().contains(TransactionDialog.HYPHEN)) {
					this.comboboxCategory.getItems().add(TransactionDialog.HYPHEN);
				}
				this.comboboxCategory.setValue(TransactionDialog.HYPHEN);
				this.checkboxCategory.setSelected(true);
			} else {
				this.comboboxCategory.setEditable(true);
				this.comboboxCategory.getItems().remove(TransactionDialog.HYPHEN);
				this.comboboxCategory.setValue(this.continuousTransaction.getCategory().getName());
				this.checkboxCategory.setSelected(false);
			}
		} else {
			if (categoryNames.size() == 0) {
				this.comboboxCategory.setEditable(false);
				if (!this.comboboxCategory.getItems().contains(TransactionDialog.HYPHEN)) {
					this.comboboxCategory.getItems().add(TransactionDialog.HYPHEN);
				}
				this.comboboxCategory.setValue(TransactionDialog.HYPHEN);
				this.checkboxCategory.setSelected(true);
			} else {
				this.comboboxCategory.setEditable(true);
				this.comboboxCategory.getItems().remove(TransactionDialog.HYPHEN);
				this.comboboxCategory.setValue(categoryNames.get(0));
				this.checkboxCategory.setSelected(false);
			}
		}

	}

	private void refreshBankAccounts() {
		final ObservableList<String> bankAccountNames = FXCollections
				.observableArrayList(DatabaseService.getInstance().getBankAccountNames());

		if (bankAccountNames == null) {
			return;
		}
		bankAccountNames.add(TransactionDialog.HYPHEN);
		this.comboboxAccount.setItems(bankAccountNames);

		if (bankAccountNames.size() == 0) {
			return;
		}

		if (this.transaction != null) {
			if (this.transaction.getBankAccount() == null) {
				this.comboboxAccount.setEditable(false);
				if (!this.comboboxAccount.getItems().contains(TransactionDialog.HYPHEN)) {
					this.comboboxAccount.getItems().add(TransactionDialog.HYPHEN);
				}
				this.comboboxAccount.setValue(TransactionDialog.HYPHEN);
				this.checkboxAccount.setSelected(true);
			} else {
				this.comboboxAccount.setEditable(true);
				this.comboboxAccount.getItems().remove(TransactionDialog.HYPHEN);
				this.comboboxAccount.setValue(this.transaction.getBankAccount().getName());
				this.checkboxAccount.setSelected(false);
			}
		} else if (this.continuousTransaction != null) {
			if (this.continuousTransaction.getBankAccount() == null) {
				this.comboboxAccount.setEditable(false);
				if (!this.comboboxAccount.getItems().contains(TransactionDialog.HYPHEN)) {
					this.comboboxAccount.getItems().add(TransactionDialog.HYPHEN);
				}
				this.comboboxAccount.setValue(TransactionDialog.HYPHEN);
				this.checkboxAccount.setSelected(true);
			} else {
				this.comboboxAccount.setEditable(true);
				this.comboboxAccount.getItems().remove(TransactionDialog.HYPHEN);
				this.comboboxAccount.setValue(this.continuousTransaction.getBankAccount().getName());
				this.checkboxAccount.setSelected(false);
			}
		} else {
			if (bankAccountNames.size() == 0) {
				this.comboboxAccount.setEditable(false);
				if (!this.comboboxAccount.getItems().contains(TransactionDialog.HYPHEN)) {
					this.comboboxAccount.getItems().add(TransactionDialog.HYPHEN);
				}
				this.comboboxAccount.setValue(TransactionDialog.HYPHEN);
				this.checkboxAccount.setSelected(true);
			} else {
				this.comboboxAccount.setEditable(true);
				this.comboboxAccount.getItems().remove(TransactionDialog.HYPHEN);
				this.comboboxAccount.setValue(bankAccountNames.get(0));
				this.checkboxAccount.setSelected(false);
			}
		}
	}

	@Override
	public void inject(final WindowParameters parameters) {
		Object object = parameters.getParameters().get(OverviewScene.class);
		if (object == null || !(object instanceof OverviewScene)) {
			throw new IllegalArgumentException("mainwindow must be set to create a transaction dialog");
		}
		this.overviewScene = (OverviewScene) object;

		object = parameters.getParameters().get(Transaction.class);
		if (object != null && object instanceof Transaction) {
			this.transaction = (Transaction) object;
		}

		object = parameters.getParameters().get(ContinuousTransaction.class);
		if (object != null && object instanceof ContinuousTransaction) {
			this.continuousTransaction = (ContinuousTransaction) object;
		}

		if (this.transaction != null && this.continuousTransaction != null) {
			throw new IllegalArgumentException(
					"it's not possible to create a transaction dialog for a transaction and a continuous transaction together");
		}

		if (this.transaction != null) {
			this.initTransaction();
		}

		if (this.continuousTransaction != null) {
			this.initContinuousTransaction();
		}

		object = parameters.getParameters().get(LocalDate.class);
		if (object != null && object instanceof LocalDate) {
			this.datepicker.setValue((LocalDate) object);
		}

	}

	private void initContinuousTransaction() {
		this.transaction = null;

		this.refreshCategories();
		this.refreshBankAccounts();

		this.datepicker.setValue(this.continuousTransaction.getDateBeginn());

		this.fieldDescription.setText(this.continuousTransaction.getName());

		final Double amount = this.continuousTransaction.getAmount();
		this.checkboxIncome.setSelected(amount > 0.0);
		this.spinnerAmount.getValueFactory().setValue(Math.abs(amount));

		this.recurrenceRule = RecurrenceRuleUtils.createRecurrenceRule(this.continuousTransaction.getRecurrenceRule());

		this.setNameOfRecurrenceButton(this.recurrenceRule.getFreq());

	}

	private void initTransaction() {
		if (this.transaction == null) {
			throw new IllegalStateException("transaction is not set to an instance!");
		}
		this.refreshCategories();
		this.refreshBankAccounts();

		this.datepicker.setValue(this.transaction.getDate());
		this.fieldDescription.setText(this.transaction.getName());

		final Double amount = this.transaction.getAmount();
		this.checkboxIncome.setSelected(amount > 0.0);
		this.spinnerAmount.getValueFactory().setValue(Math.abs(amount));

	}

	private void createNewTransaction(final boolean ownTransaction) {
		if (ownTransaction) {
			this.beginTransaction();
		}
		try {
			this.transaction = new Transaction();
			this.setTransactionAttributes(this.transaction);
			DatabaseService.getInstance().persist(this.transaction);
			this.overviewScene.refresh();
		} catch (final Exception e) {
			this.rollbackTransaction();
			throw e;
		}
		if (ownTransaction) {
			this.commitTransaction();
		}
		this.close();
	}

	private void createNewContinuousTransaction(final boolean ownTransaction) {
		if (ownTransaction) {
			this.beginTransaction();
		}
		try {
			this.continuousTransaction = new ContinuousTransaction();
			this.setContinuousTransactionAttributtes(this.continuousTransaction);
			final List<Transaction> transactions = ContinuousTransactionService
					.generateTransactionsForContinuousTransaction(this.continuousTransaction);
			DatabaseService.getInstance().persistContinuousTransaction(this.continuousTransaction, transactions);
			this.overviewScene.refresh();
		} catch (final Exception e) {
			this.rollbackTransaction();
			throw e;
		}
		if (ownTransaction) {
			this.commitTransaction();
		}
		this.close();
	}

	private void setContinuousTransactionAttributtes(final ContinuousTransaction continuousTransaction) {
		continuousTransaction.setAmount(this.getAmount());
		continuousTransaction.setBankAccount(this.getBankAccount());
		continuousTransaction.setCategory(this.getCategory());
		continuousTransaction.setDateBeginn(this.getDate());
		continuousTransaction.setName(this.getName());
		continuousTransaction.setRecurrenceRule(this.recurrenceRule.toString());
	}

	private void changeNewContinuousTransactionFromTransaction(final boolean ownTransaction) {
		if (ownTransaction) {
			this.beginTransaction();
		}
		try {
			DatabaseService.getInstance().delete(this.transaction);
			this.createNewContinuousTransaction(false);
			this.overviewScene.refresh();
		} catch (final Exception e) {
			this.rollbackTransaction();
			throw e;
		}
		if (ownTransaction) {
			this.commitTransaction();
		}
		this.close();
	}

	private void changeContinuesTransactionToTransaction() {
		this.changeContinuousTransaction();
	}

	private void changeTransaction(final boolean ownTransaction) {
		if (ownTransaction) {
			this.beginTransaction();
		}
		try {
			if (this.transaction.getContinuousTransaction() != null) {
				ContinuousTransactionService.splitContinuousTransaction(this.transaction);
			} else {
				DatabaseService.getInstance().delete(this.transaction);
			}

			this.createNewTransaction(false);
		} catch (final Exception e) {
			this.rollbackTransaction();
			throw e;
		}
		if (ownTransaction) {
			this.commitTransaction();
		}
		this.overviewScene.refresh();
		this.close();
	}

	private void changeContinuousTransaction() {
		final WindowParameters parameters = new WindowParameters();
		parameters.put(TransactionDialog.class, this);
		parameters.put(LocalDate.class, this.datepicker.getValue());
		final WindowCreater<MergeContinuousTransactionDialog> windowCreater = new WindowCreater<>();
		windowCreater.createWindow(Main.class.getResource("design/window/MergeContinuousTransactionDialog.fxml"),
				"Ab wann?", parameters);
	}

	public void changeContinuosTransacationFrom(final LocalDate dateFrom) {
		if (this.continuousTransaction == null) {
			throw new IllegalStateException("continuousTransaction should not be null");
		}

		this.beginTransaction();
		try {
			if (dateFrom == null) {
				this.datepicker.setValue(this.continuousTransaction.getDateBeginn());
				DatabaseService.getInstance().deleteAllContinuousTransactions(this.continuousTransaction);
			} else {
				this.datepicker.setValue(dateFrom);

				final List<Transaction> transactionsAfter = DatabaseService.getInstance()
						.getTransactionsFromDate(this.continuousTransaction, dateFrom);
				DatabaseService.getInstance().deleteTransactions(transactionsAfter);

				final RecurrenceRule recurrenceRuleOfOldContinuousTransaction = RecurrenceRuleUtils
						.createRecurrenceRule(this.continuousTransaction.getRecurrenceRule());

				final LocalDate lastDateBeforeRecurrence = RecurrenceRuleUtils.getLastRecurrenceDateBefore(
						recurrenceRuleOfOldContinuousTransaction, this.continuousTransaction.getDateBeginn(), dateFrom);

				recurrenceRuleOfOldContinuousTransaction
						.setUntil(DateUtils.localDateToDateTime(lastDateBeforeRecurrence));
				this.continuousTransaction.setRecurrenceRule(recurrenceRuleOfOldContinuousTransaction.toString());
				DatabaseService.getInstance().merge(this.continuousTransaction);
			}

			if (this.recurrenceRule != null) {
				this.createNewContinuousTransaction(false);
			} else {
				this.createNewTransaction(false);
			}

			this.overviewScene.refresh();
		} catch (final Exception e) {
			this.rollbackTransaction();
			throw e;
		}
		this.commitTransaction();
		this.close();
	}

	private void setTransactionAttributes(final Transaction transactionPara) {
		transactionPara.setAmount(this.getAmount());
		transactionPara.setBankAccount(this.getBankAccount());
		transactionPara.setCategory(this.getCategory());
		transactionPara.setDate(this.getDate());
		transactionPara.setName(this.getName());
	}

	private String getName() {
		return this.fieldDescription.getText();
	}

	private LocalDate getDate() {
		return this.datepicker.getValue();
	}

	private Category getCategory() {
		return DatabaseService.getInstance().getCategory(this.comboboxCategory.getValue());
	}

	private BankAccount getBankAccount() {
		return DatabaseService.getInstance().getBankAccount(this.comboboxAccount.getValue());
	}

	private double getAmount() {
		return this.checkboxIncome.isSelected() ? this.spinnerAmount.getValue() : -this.spinnerAmount.getValue();
	}

	public void setNameOfRecurrenceButton(final Freq freq) {
		if (freq == null) {
			this.buttonRecurrence.setText(Frequences.NONE.getText());
			return;
		}

		switch (freq) {
		case DAILY:
			this.buttonRecurrence.setText(Frequences.DAILY.getText());
			break;
		case MONTHLY:
			this.buttonRecurrence.setText(Frequences.MONTHLY.getText());
			break;
		case WEEKLY:
			this.buttonRecurrence.setText(Frequences.WEEKLY.getText());
			break;
		case YEARLY:
			this.buttonRecurrence.setText(Frequences.YEARLY.getText());
			break;
		default:
			TransactionDialog.log.error("no valid RecurrenceRule");
			throw new IllegalStateException("no valid RecurrenceRule");
		}

	}

	private void close() {
		final Stage stage = (Stage) this.fieldDescription.getScene().getWindow();
		stage.close();
	}

	private void beginTransaction() {
		DatabaseService.getInstance().beginTransaction();
	}

	private void commitTransaction() {
		DatabaseService.getInstance().commitTransaction();
	}

	private void rollbackTransaction() {
		DatabaseService.getInstance().rollbackTransaction();
	}

}
