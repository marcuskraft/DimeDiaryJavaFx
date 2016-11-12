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

public class AccountBalancer {

	public static enum BalanceAction {
		adding, deleting
	}

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

	public static void proofBalance(final BankAccount bankAccount) {
		AccountBalancer.initBalance(bankAccount); // TODO implement the logic
													// for the case that no
													// initialization but a
													// refresh of the balance
													// history is necessary
	}

}
