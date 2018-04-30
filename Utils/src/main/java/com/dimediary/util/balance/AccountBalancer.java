package com.dimediary.util.balance;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dimediary.model.entities.BalanceHistory;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.model.utils.AmountUtils;
import com.dimediary.util.transaction.ContinuousTransactionManager;
import com.dimediary.util.utils.DBUtils;
import com.dimediary.util.utils.DateUtils;

/**
 *
 * @author eyota
 *
 */
public class AccountBalancer {

	/**
	 *
	 * @author eyota
	 *
	 */
	public static enum BalanceAction {
		/**
		 * adding a transaction
		 */
		adding,
		/**
		 * deleting a transaction
		 */
		deleting
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

		BalanceHistory balanceHistory = DBUtils.getInstance().getBalanceHistory(bankAccount, lastSunday);

		if (balanceHistory == null) {
			AccountBalancer.proofBalance(bankAccount);
			balanceHistory = DBUtils.getInstance().getBalanceHistory(bankAccount, lastSunday);
			if (balanceHistory == null) {
				return AccountBalancer.getBalance(DBUtils.getInstance().getLastBalanceHistory(bankAccount), date);
			}
		}

		Double result = balanceHistory.getAmount();

		if (lastSunday.isBefore(date)) {
			final LocalDate dateFrom = lastSunday.plusDays(1);
			final List<Transaction> transactions = DBUtils.getInstance().getTransactions(dateFrom, date, bankAccount);

			for (final Transaction transaction : transactions) {
				result += transaction.getAmount();
			}
		}

		return AmountUtils.round(result);

	}

	// TODO write junit test for this method in comparison to the other
	// getBalance() method
	private static Double getBalance(final BankAccount bankAccount, final LocalDate date,
			final Double balanceDayBefore) {
		if (bankAccount == null || date == null || date.isBefore(bankAccount.getDateStartBudget())) {
			return null;
		}
		final ArrayList<Transaction> transactions = DBUtils.getInstance().getTransactions(bankAccount, date);

		Double result;
		if (balanceDayBefore == null) {
			result = AccountBalancer.getBalance(bankAccount, date);
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

	public static Double getBalance(final BalanceHistory lastBalanceHistory, final LocalDate date) {
		Double amount = lastBalanceHistory.getAmount();

		final List<Transaction> transactions = DBUtils.getInstance()
				.getTransactions(lastBalanceHistory.getDate().plusDays(1), date, lastBalanceHistory.getBankAccount());

		for (final Transaction transaction : transactions) {
			amount += transaction.getAmount();
		}

		return amount;
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
				lastBalance = AccountBalancer.getBalance(bankAccount, dates.get(i));
			} else {
				lastBalance = AccountBalancer.getBalance(bankAccount, dates.get(i), lastBalance);
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

		final ArrayList<BalanceHistory> balanceHistories = DBUtils.getInstance()
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
		DBUtils.getInstance().mergeBalanceHistories(balanceHistories);

	}

	/**
	 * initialize the balance history for this bank account. All old balance
	 * histories will be deleted.
	 *
	 * @param bankAccount
	 *            bank account to initialize
	 */
	public static void initBalance(final BankAccount bankAccount) {
		DBUtils.getInstance().deleteBalanceHistories(bankAccount);

		final ArrayList<Transaction> transactions = DBUtils.getInstance().getTransactions(bankAccount);

		final ArrayList<LocalDate> sundays = DateUtils.getAllSundaysForBalancing(bankAccount, null);

		final ArrayList<BalanceHistory> balanceHistories = new ArrayList<>();
		for (final LocalDate date : sundays) {
			final BalanceHistory balanceHistory = new BalanceHistory();
			balanceHistory.setBankAccount(bankAccount);
			balanceHistory.setDate(date);
			balanceHistory.setAmount(bankAccount.getStartBudget());
			balanceHistories.add(balanceHistory);
		}
		DBUtils.getInstance().persistBalanceHistories(balanceHistories);

		for (final Transaction transaction : transactions) {
			AccountBalancer.updateBalance(transaction, BalanceAction.adding);
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
	public static void proofBalance(final BankAccount bankAccount) {
		AccountBalancer.proofContinuosTransactions(bankAccount);
		final BalanceHistory lastBalanceHistory = DBUtils.getInstance().getLastBalanceHistory(bankAccount);

		if (lastBalanceHistory == null) {
			AccountBalancer.initBalance(bankAccount);
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
			final List<Transaction> transactions = DBUtils.getInstance().getTransactions(lastSunday.plusDays(1), date,
					bankAccount);

			for (final Transaction transaction : transactions) {
				lastAmount += transaction.getAmount();
			}

			balanceHistory.setBankAccount(bankAccount);
			balanceHistory.setDate(date);
			balanceHistory.setAmount(lastAmount);

			balanceHistories.add(balanceHistory);
		}

		DBUtils.getInstance().persistBalanceHistories(balanceHistories);

	}

	private static void proofContinuosTransactions(final BankAccount bankAccount) {
		final List<ContinuousTransaction> continuousTransactions = DBUtils.getInstance()
				.getContinuousTransactions(bankAccount);

		for (final ContinuousTransaction continuousTransaction : continuousTransactions) {

			final List<Transaction> transactions = ContinuousTransactionManager
					.generateTransactionsFromContinuousTransaction(continuousTransaction);

			DBUtils.getInstance().persistTransactions(transactions);

		}
	}

}
