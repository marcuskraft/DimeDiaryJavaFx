package com.dimediary.util.transaction;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dmfs.rfc5545.recur.RecurrenceRule;

import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.util.utils.DBUtils;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.util.utils.RecurrenceRuleUtils;

public class ContinuousTransactionManager {

	public static List<Transaction> generateTransactionsFromContinuousTransaction(
			final ContinuousTransaction continuousTransaction) {
		final Date currentMaxDate = DBUtils.getInstance().getDateOfLastTransaction(continuousTransaction);
		return ContinuousTransactionManager.generateTransactionsFromContinuousTransaction(continuousTransaction,
				currentMaxDate);
	}

	public static List<Transaction> generateTransactionsFromNewContinuousTransaction(
			final ContinuousTransaction continuousTransaction) {
		return ContinuousTransactionManager.generateTransactionsFromContinuousTransaction(continuousTransaction, null);

	}

	private static List<Transaction> generateTransactionsFromContinuousTransaction(
			final ContinuousTransaction continuousTransaction, final Date fromDate) {
		final RecurrenceRule recurrenceRule = RecurrenceRuleUtils
				.createRecurrenceRule(continuousTransaction.getRecurrenceRule());
		Date firstDate = fromDate;
		boolean skipFirst = false;
		if (firstDate == null) {
			firstDate = continuousTransaction.getDateBeginn();
		} else {
			skipFirst = true;
		}

		final List<Date> dates = RecurrenceRuleUtils.getDatesForRecurrenceRule(recurrenceRule,
				DateUtils.dateToDateTime(continuousTransaction.getDateBeginn()), DateUtils.dateToDateTime(firstDate));

		if (skipFirst) {
			dates.remove(0);
		}

		final List<Transaction> transactions = new ArrayList<>();
		for (final Date date : dates) {
			transactions.add(continuousTransaction.createTransaction(date));
		}

		return transactions;

	}

}
