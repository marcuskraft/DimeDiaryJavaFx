package com.dimediary.controller.balance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.controller.utils.DateUtils;
import com.dimediary.model.entities.BalanceHistory;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;
import com.dimediary.model.utils.AmountUtils;

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
	 * @param dateUntil
	 *            the date
	 * @return returns the balance for this bank account and date
	 */
	public static Double getBalance(final BankAccount bankAccount, final Date dateUntil) {

		final Date lastSunday = DateUtils.getLastSunday(dateUntil);

		BalanceHistory balanceHistory = DBUtils.getInstance().getBalanceHistory(bankAccount, lastSunday);

		if (balanceHistory == null) {
			AccountBalancer.proofBalance(bankAccount);
			balanceHistory = DBUtils.getInstance().getBalanceHistory(bankAccount, lastSunday);
		}

		Double result = balanceHistory.getAmount();

		if (lastSunday.before(dateUntil)) {
			final Date dateFrom = DateUtils.addOneDay(lastSunday);
			final List<Transaction> transactions = DBUtils.getInstance().getTransactions(dateFrom, dateUntil,
					bankAccount);

			for (final Transaction transaction : transactions) {
				result += transaction.getAmount();
			}
		}

		return AmountUtils.round(result);

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
		final Date date = transaction.getDate();
		Date nextSunday;
		if (!DateUtils.isSunday(date)) {
			nextSunday = DateUtils.getNextSunday(date);
		} else {
			nextSunday = date;
		}

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

		final ArrayList<Date> sundays = DateUtils.getSundays(bankAccount);

		final ArrayList<BalanceHistory> balanceHistories = new ArrayList<>();
		for (final Date date : sundays) {
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
	 * history if no exists. Corrects wrong entries in the balance history if
	 * there are some.
	 *
	 * @param bankAccount
	 *            bank account to proof
	 */
	public static void proofBalance(final BankAccount bankAccount) {
		AccountBalancer.initBalance(bankAccount); // TODO implement the logic
													// for the case that no
													// initialization but a
													// refresh of the balance
													// history is necessary
	}

}
