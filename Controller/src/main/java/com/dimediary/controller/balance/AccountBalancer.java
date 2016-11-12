package com.dimediary.controller.balance;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.BalanceHistory;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;

public class AccountBalancer implements IAccountBalancer {

	private final static int numberOfWeeksFuture = 60;

	@Override
	public Double getBalance(final BankAccount bankAccount, final Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateBalance(final Transaction transaction, final BalanceAction action) {
		if (transaction.getBankAccount() == null) {
			return;
		}
		final Date date = transaction.getDate();
		Date nextSunday;
		if (!this.isSunday(date)) {
			nextSunday = this.getNextSunday(date);
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

	@Override
	public void initBalance(final BankAccount bankAccount) {
		final ArrayList<BalanceHistory> balanceHistoriesOld = DBUtils.getInstance().getBalanceHistories(bankAccount);
		if (!balanceHistoriesOld.isEmpty()) {
			DBUtils.getInstance().deleteBalanceHistories(balanceHistoriesOld);
		}

		final ArrayList<Transaction> transactions = DBUtils.getInstance().getTransactions(bankAccount);

		final ArrayList<Date> sundays = this.getSundays(bankAccount);

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
			this.updateBalance(transaction, BalanceAction.adding);
		}

	}

	@Override
	public void proofBalance(final BankAccount bankAccount) {
		// TODO Auto-generated method stub

	}

	private Date getLastSunday(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		if (dayOfWeek != 1) {
			calendar.add(Calendar.DAY_OF_WEEK, 1 - dayOfWeek);
		}

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	private Date getNextSunday(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		calendar.add(Calendar.DAY_OF_WEEK, 8 - dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	private ArrayList<Date> getSundays(final BankAccount bankAccount) {
		final ArrayList<Date> sundays = new ArrayList<>();

		final Date lastSunday = this.getLastSunday(AccountBalancer.numberOfWeeksFuture);
		Date sunday = this.getLastSunday(bankAccount.getDateStartBudget());
		sundays.add(sunday);

		while (sunday.before(lastSunday)) {
			sunday = this.getNextSunday(sunday);
			sundays.add(sunday);
		}

		return sundays;

	}

	private Date getLastSunday(final int numberOfWeeks) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.WEEK_OF_YEAR, numberOfWeeks);

		return calendar.getTime();

	}

	private boolean isSunday(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK) == 1;
	}

}
