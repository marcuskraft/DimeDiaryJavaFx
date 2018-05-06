package com.dimediary.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.dmfs.rfc5545.recur.RecurrenceRule;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.services.utils.DBUtils;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.util.utils.RecurrenceRuleUtils;

public class ContinuousTransactionService {

	public static List<Transaction> generateTransactionsFromContinuousTransaction(
			final ContinuousTransaction continuousTransaction) {
		final LocalDate currentMaxDate = DBUtils.getInstance().getDateOfLastTransaction(continuousTransaction);
		return ContinuousTransactionService.generateTransactionsFromContinuousTransaction(continuousTransaction,
				currentMaxDate);
	}

	public static List<Transaction> generateTransactionsFromNewContinuousTransaction(
			final ContinuousTransaction continuousTransaction) {
		return ContinuousTransactionService.generateTransactionsFromContinuousTransaction(continuousTransaction, null);

	}

	public static void proofContinuosTransactions(final BankAccount bankAccount) {
		final List<ContinuousTransaction> continuousTransactions = DBUtils.getInstance()
				.getContinuousTransactions(bankAccount);

		for (final ContinuousTransaction continuousTransaction : continuousTransactions) {

			final List<Transaction> transactions = ContinuousTransactionService
					.generateTransactionsFromContinuousTransaction(continuousTransaction);

			DBUtils.getInstance().persistTransactions(transactions);

		}
	}

	private static List<Transaction> generateTransactionsFromContinuousTransaction(
			final ContinuousTransaction continuousTransaction, final LocalDate fromDate) {
		final RecurrenceRule recurrenceRule = RecurrenceRuleUtils
				.createRecurrenceRule(continuousTransaction.getRecurrenceRule());
		LocalDate firstDate = fromDate;
		boolean skipFirst = false;
		if (firstDate == null) {
			firstDate = continuousTransaction.getDateBeginn();
		} else {
			skipFirst = true;
		}

		final List<LocalDate> dates = RecurrenceRuleUtils.getDatesForRecurrenceRule(recurrenceRule,
				DateUtils.localDateToDateTime(continuousTransaction.getDateBeginn()),
				DateUtils.localDateToDateTime(firstDate));

		if (dates != null && !dates.isEmpty() && skipFirst) {
			dates.remove(0);
		}

		final List<Transaction> transactions = new ArrayList<>();
		for (final LocalDate date : dates) {
			transactions.add(continuousTransaction.createTransaction(date));
		}

		return transactions;

	}

}
