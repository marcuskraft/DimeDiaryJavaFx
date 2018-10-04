package com.dimediary.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dimediary.model.entities.BalanceHistory;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;
import com.dimediary.model.utils.AmountUtils;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.util.utils.DateUtils;

/**
 *
 * @author eyota
 *
 */
public class AccountBalanceService {

	/**
	 *
	 * @author eyota
	 *
	 */
	public static enum BalanceAction {
	adding, deleting
	}

	/**
	 *
	 * @param bankAccount
	 *                        the bank account
	 * @param date
	 *                        the date
	 * @return returns the balance for this bank account and date
	 */
	public static Double getBalance(final BankAccount bankAccount, final LocalDate date) {
		if (bankAccount == null || date == null
				|| date.isBefore(DateUtils.getLastSunday(bankAccount.getDateStartBudget()))) {
			return null;
		}

		BalanceHistory lastBalanceHistoryBeforeRequestedDate = AccountBalanceService.getLastBalanceHistory(bankAccount,
				date);

		lastBalanceHistoryBeforeRequestedDate = AccountBalanceService
				.generateMissingBalanceHistoriesIfNeeded(bankAccount, date, lastBalanceHistoryBeforeRequestedDate);

		if (lastBalanceHistoryBeforeRequestedDate == null) {
			return AccountBalanceService.getBalanceWithAllTransactions(bankAccount, date);
		}

		final Double result = AccountBalanceService.sumAllTransactionsBetween(bankAccount, date,
				lastBalanceHistoryBeforeRequestedDate);

		return AmountUtils.round(result);

	}

	/**
	 *
	 * @param bankAccount
	 *                        bank account for which the balances are requested
	 * @param dates
	 *                        sequence of following days for which the balances are
	 *                        requested
	 * @return returns a HashMap with the given Dates and the corresponding balances
	 *         for this bank account on this date
	 */
	public static Map<LocalDate, Double> getBalancesFollowingDays(final BankAccount bankAccount,
			final List<LocalDate> dates) {
		final HashMap<LocalDate, Double> balances = new HashMap<>();

		Double lastBalance = 0.0;

		dates.sort(null);

		for (int i = 0; i < dates.size(); i++) {
			if (i == 0) {
				lastBalance = AccountBalanceService.getBalance(bankAccount, dates.get(i));
			} else {
				lastBalance = AccountBalanceService.getBalance(bankAccount, dates.get(i), lastBalance);
			}
			balances.put(dates.get(i), lastBalance);
		}

		return balances;
	}

	/**
	 * updates the balance history after adding or deleting a transaction if the
	 * transaction belongs to a bank account
	 *
	 * @param transaction
	 *                        the transaction for the updates; only this transaction
	 *                        will be considered for update
	 * @param action
	 *                        defines whether the transaction is added or deleted
	 */
	public static void updateBalance(final Transaction transaction, final BalanceAction action) {
		if (transaction.getBankAccount() == null) {
			return;
		}
		final LocalDate lastSundayFromToday = DateUtils.getLastSunday(LocalDate.now());
		final LocalDate nextSundayFromTransaction = DateUtils.getNextSunday(transaction.getDate());

		if (transaction.getDate().isAfter(lastSundayFromToday)) {
			return;
		}

		final List<BalanceHistory> balanceHistories = DatabaseService.getInstance()
				.getBalanceHistoriesAfterDate(transaction.getBankAccount(), nextSundayFromTransaction);

		switch (action) {
		case adding:
			for (final BalanceHistory balanceHistory : balanceHistories) {
				balanceHistory.addAmount(transaction.getAmount());
			}
			break;
		case deleting:
			for (final BalanceHistory balanceHistory : balanceHistories) {
				balanceHistory.addAmount(-transaction.getAmount());
			}
			break;
		default:
			break;

		}
	}

	// TODO write junit test for this method in comparison to the other
	// getBalance() method
	private static Double getBalance(final BankAccount bankAccount, final LocalDate date,
			final Double balanceDayBefore) {
		if (bankAccount == null || date == null || date.isBefore(bankAccount.getDateStartBudget())) {
			return null;
		}
		final List<Transaction> transactions = DatabaseService.getInstance().getTransactions(bankAccount, date);

		Double result;
		if (balanceDayBefore == null) {
			result = AccountBalanceService.getBalance(bankAccount, date.minusDays(1));
			if (result == null) {
				result = 0.0;
			}
		} else {
			result = balanceDayBefore;
		}

		for (final Transaction transaction : transactions) {
			result += transaction.getAmount();
		}

		return AmountUtils.round(result);
	}

	private static Double getBalanceWithAllTransactions(final BankAccount bankAccount, final LocalDate date) {
		Double amount;

		amount = bankAccount.getStartBudget();

		final List<Transaction> transactions = DatabaseService.getInstance()
				.getTransactions(bankAccount.getDateStartBudget(), date, bankAccount);

		for (final Transaction transaction : transactions) {
			amount += transaction.getAmount();
		}

		return AmountUtils.round(amount);
	}

	/**
	 * initialize the balance history for this bank account. All old balance
	 * histories will be deleted.
	 *
	 * @param bankAccount
	 *                        bank account to initialize
	 */
	private static void initBalance(final BankAccount bankAccount) {
		final boolean ownTransaction = DatabaseService.getInstance().beginTransaction();

		try {
			DatabaseService.getInstance().deleteBalanceHistories(bankAccount);

			final List<Transaction> transactions = DatabaseService.getInstance().getTransactions(bankAccount);

			final List<LocalDate> sundays = DateUtils.getAllSundaysForBalancing(bankAccount, null);

			final List<BalanceHistory> balanceHistories = new ArrayList<>();
			for (final LocalDate sunday : sundays) {
				final BalanceHistory balanceHistory = new BalanceHistory();
				balanceHistory.setBankAccount(bankAccount);
				balanceHistory.setDate(sunday);
				balanceHistory.setAmount(bankAccount.getStartBudget());
				balanceHistories.add(balanceHistory);
			}
			DatabaseService.getInstance().persistBalanceHistories(balanceHistories);

			for (final Transaction transaction : transactions) {
				AccountBalanceService.updateBalance(transaction, BalanceAction.adding);
			}
		} catch (final Exception e) {
			DatabaseService.getInstance().rollbackTransaction();
			throw e;
		}
		if (ownTransaction) {
			DatabaseService.getInstance().commitTransaction();
		}
	}

	/**
	 * proofs the balance history of this bank account. Initialize the balance
	 * history if no exists. Corrects wrong entries in the balance history if there
	 * are some.
	 *
	 * @param bankAccount
	 *                        bank account to proof
	 */
	private static void generateMissingBalanceHistories(final BankAccount bankAccount) {
		final BalanceHistory lastBalanceHistory = DatabaseService.getInstance().getLastBalanceHistory(bankAccount);

		if (lastBalanceHistory == null) {
			AccountBalanceService.initBalance(bankAccount);
			return;
		}

		final LocalDate dateOfLastBalanceHistory = lastBalanceHistory.getDate();
		final LocalDate lastSundayFromToday = DateUtils.getLastSunday(LocalDate.now());

		if (!dateOfLastBalanceHistory.isBefore(lastSundayFromToday)) {
			return;
		}

		final LocalDate dateForNextBalanceHostory = DateUtils.getNextSundayAlways(dateOfLastBalanceHistory);

		final ArrayList<LocalDate> sundays = DateUtils.getAllSundaysForBalancing(bankAccount,
				dateForNextBalanceHostory);

		LocalDate lastSunday;
		Double lastAmount = lastBalanceHistory.getAmount();

		final ArrayList<BalanceHistory> balanceHistories = new ArrayList<>();
		for (final LocalDate date : sundays) {
			final BalanceHistory balanceHistory = new BalanceHistory();

			lastSunday = DateUtils.getLastSundayAlways(date);
			final List<Transaction> transactions = DatabaseService.getInstance().getTransactions(lastSunday.plusDays(1),
					date, bankAccount);

			for (final Transaction transaction : transactions) {
				lastAmount += transaction.getAmount();
			}

			balanceHistory.setBankAccount(bankAccount);
			balanceHistory.setDate(date);
			balanceHistory.setAmount(lastAmount);

			balanceHistories.add(balanceHistory);
		}

		DatabaseService.getInstance().persistBalanceHistories(balanceHistories);

	}

	private static BalanceHistory getLastBalanceHistory(final BankAccount bankAccount, final LocalDate date) {
		BalanceHistory balanceHistory;
		if (date.isAfter(LocalDate.now())) {
			balanceHistory = DatabaseService.getInstance().getLastBalanceHistory(bankAccount);
		} else {
			balanceHistory = DatabaseService.getInstance().getBalanceHistory(bankAccount,
					DateUtils.getLastSunday(date));
		}
		return balanceHistory;
	}

	private static BalanceHistory generateMissingBalanceHistoriesIfNeeded(final BankAccount bankAccount,
			final LocalDate date, BalanceHistory balanceHistory) {
		final LocalDate lastSundayBeforeRequestedDate = DateUtils.getLastSunday(date);
		final LocalDate nextSundayAfterToday = DateUtils.getNextSunday(LocalDate.now());
		if (balanceHistory == null || date.isBefore(nextSundayAfterToday)
				&& !balanceHistory.getDate().equals(lastSundayBeforeRequestedDate)) {
			AccountBalanceService.generateMissingBalanceHistories(bankAccount);
			balanceHistory = AccountBalanceService.getLastBalanceHistory(bankAccount, date);
		}
		return balanceHistory;
	}

	private static Double sumAllTransactionsBetween(final BankAccount bankAccount, final LocalDate date,
			final BalanceHistory balanceHistory) {
		Double result = balanceHistory.getAmount();

		final LocalDate dateFrom = balanceHistory.getDate().plusDays(1);
		final List<Transaction> transactions = DatabaseService.getInstance().getTransactions(dateFrom, date,
				bankAccount);

		for (final Transaction transaction : transactions) {
			result += transaction.getAmount();
		}
		return result;
	}

}
