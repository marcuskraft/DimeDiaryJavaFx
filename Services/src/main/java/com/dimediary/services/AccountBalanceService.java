package com.dimediary.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
	 *            the bank account
	 * @param date
	 *            the date
	 * @return returns the balance for this bank account and date
	 */
	public static Double getBalance(final BankAccount bankAccount, final LocalDate date) {
		if (bankAccount == null || date == null || date.isBefore(bankAccount.getDateStartBudget())) {
			return null;
		}

		final LocalDate lastSunday = DateUtils.getLastSunday(date);

		BalanceHistory balanceHistory = DatabaseService.getInstance().getBalanceHistory(bankAccount, lastSunday);

		if (balanceHistory == null) {
			AccountBalanceService.proofBalance(bankAccount);
			balanceHistory = DatabaseService.getInstance().getBalanceHistory(bankAccount, lastSunday);
			if (balanceHistory == null) {
				return AccountBalanceService.getBalance(DatabaseService.getInstance().getLastBalanceHistory(bankAccount), date);
			}
		}

		Double result = balanceHistory.getAmount();

		if (lastSunday.isBefore(date)) {
			final LocalDate dateFrom = lastSunday.plusDays(1);
			final List<Transaction> transactions = DatabaseService.getInstance().getTransactions(dateFrom, date, bankAccount);

			for (final Transaction transaction : transactions) {
				result += transaction.getAmount();
			}
		}

		return AmountUtils.round(result);

	}

	/**
	 *
	 * @param bankAccount
	 *            bank account for which the balances are requested
	 * @param dates
	 *            sequence of following days for which the balances are requested
	 * @return returns a HashMap with the given Dates and the corresponding balances
	 *         for this bank account on this date
	 */
	public static HashMap<LocalDate, Double> getBalancesFollowingDays(final BankAccount bankAccount,
			final ArrayList<LocalDate> dates) {
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
	 *            the transaction for the updates; only this transaction will be
	 *            considered for update
	 * @param action
	 *            defines whether the transaction is added or deleted
	 */
	public static void updateBalance(final Transaction transaction, final BalanceAction action) {
		if (transaction.getBankAccount() == null) {
			return;
		}
		final LocalDate date = transaction.getDate();
		final LocalDate nextSunday = DateUtils.getNextSunday(date);

		final ArrayList<BalanceHistory> balanceHistories = DatabaseService.getInstance()
				.getBalanceHistoriesAfterDate(transaction.getBankAccount(), nextSunday);

		if (action == BalanceAction.adding) {
			for (final BalanceHistory balanceHistory : balanceHistories) {
				balanceHistory.addAmount(transaction.getAmount());
			}
		} else {
			for (final BalanceHistory balanceHistory : balanceHistories) {
				balanceHistory.addAmount(-transaction.getAmount());
			}
		}
		DatabaseService.getInstance().mergeBalanceHistories(balanceHistories);

	}

	// TODO write junit test for this method in comparison to the other
	// getBalance() method
	private static Double getBalance(final BankAccount bankAccount, final LocalDate date,
			final Double balanceDayBefore) {
		if (bankAccount == null || date == null || date.isBefore(bankAccount.getDateStartBudget())) {
			return null;
		}
		final ArrayList<Transaction> transactions = DatabaseService.getInstance().getTransactions(bankAccount, date);

		Double result;
		if (balanceDayBefore == null) {
			result = AccountBalanceService.getBalance(bankAccount, date);
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

	private static Double getBalance(final BalanceHistory lastBalanceHistory, final LocalDate date) {
		Double amount = lastBalanceHistory.getAmount();

		final List<Transaction> transactions = DatabaseService.getInstance()
				.getTransactions(lastBalanceHistory.getDate().plusDays(1), date, lastBalanceHistory.getBankAccount());

		for (final Transaction transaction : transactions) {
			amount += transaction.getAmount();
		}

		return amount;
	}

	/**
	 * initialize the balance history for this bank account. All old balance
	 * histories will be deleted.
	 *
	 * @param bankAccount
	 *            bank account to initialize
	 */
	private static void initBalance(final BankAccount bankAccount) {
		DatabaseService.getInstance().deleteBalanceHistories(bankAccount);

		final List<Transaction> transactions = DatabaseService.getInstance().getTransactions(bankAccount);

		final List<LocalDate> sundays = DateUtils.getAllSundaysForBalancing(bankAccount, null);

		final List<BalanceHistory> balanceHistories = new ArrayList<BalanceHistory>();
		for (final LocalDate date : sundays) {
			final BalanceHistory balanceHistory = new BalanceHistory();
			balanceHistory.setBankAccount(bankAccount);
			balanceHistory.setDate(date);
			balanceHistory.setAmount(bankAccount.getStartBudget());
			balanceHistories.add(balanceHistory);
		}
		DatabaseService.getInstance().persistBalanceHistories(balanceHistories);

		for (final Transaction transaction : transactions) {
			AccountBalanceService.updateBalance(transaction, BalanceAction.adding);
		}

	}

	/**
	 * proofs the balance history of this bank account. Initialize the balance
	 * history if no exists. Corrects wrong entries in the balance history if there
	 * are some.
	 *
	 * @param bankAccount
	 *            bank account to proof
	 */
	private static void proofBalance(final BankAccount bankAccount) {
		ContinuousTransactionService.proofContinuosTransactions(bankAccount);
		final BalanceHistory lastBalanceHistory = DatabaseService.getInstance().getLastBalanceHistory(bankAccount);

		if (lastBalanceHistory == null) {
			AccountBalanceService.initBalance(bankAccount);
			return;
		}

		LocalDate dateFrom = lastBalanceHistory.getDate();
		final LocalDate dateUntil = DateUtils.getLastSundayForBalancing();

		if (!lastBalanceHistory.getDate().isBefore(dateUntil)) {
			return;
		}

		dateFrom = DateUtils.getNextSundayAlways(dateFrom);

		final ArrayList<LocalDate> sundays = DateUtils.getAllSundaysForBalancing(bankAccount, dateFrom);

		LocalDate lastSunday;

		Double lastAmount = lastBalanceHistory.getAmount();

		final ArrayList<BalanceHistory> balanceHistories = new ArrayList<>();
		for (final LocalDate date : sundays) {
			final BalanceHistory balanceHistory = new BalanceHistory();

			lastSunday = DateUtils.getLastSundayAlways(date);
			final List<Transaction> transactions = DatabaseService.getInstance().getTransactions(lastSunday.plusDays(1), date,
					bankAccount);

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

}
