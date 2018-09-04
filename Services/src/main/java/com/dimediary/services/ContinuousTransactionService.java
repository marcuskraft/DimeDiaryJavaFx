package com.dimediary.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.dmfs.rfc5545.recur.RecurrenceRule;

import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.util.utils.RecurrenceRuleUtils;

public class ContinuousTransactionService {

	public static List<Transaction> generateTransactionsFromContinuousTransaction(
			final ContinuousTransaction continuousTransaction) {
		final LocalDate currentMaxDate = DatabaseService.getInstance().getDateOfLastTransaction(continuousTransaction);
		return ContinuousTransactionService.generateTransactionsFromContinuousTransaction(continuousTransaction,
				currentMaxDate);
	}

	public static List<Transaction> generateTransactionsFromNewContinuousTransaction(
			final ContinuousTransaction continuousTransaction) {
		return ContinuousTransactionService.generateTransactionsFromContinuousTransaction(continuousTransaction, null);

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

	public static void splitContinuousTransaction(final Transaction transaction) {

		final boolean ownTransaction = DatabaseService.getInstance().beginTransaction();

		try {
			final RecurrenceRule recurrenceRuleOriginal = RecurrenceRuleUtils
					.createRecurrenceRule(transaction.getContinuousTransaction().getRecurrenceRule());

			// Generate continuous transactions before this single transaction if needed
			final ContinuousTransaction continuousTransactionBefore = transaction.getContinuousTransaction().getCopy();

			final RecurrenceRule recurrenceRuleBefore = RecurrenceRuleUtils
					.createRecurrenceRule(continuousTransactionBefore.getRecurrenceRule());

			final LocalDate lastDateBefore = RecurrenceRuleUtils.getLastRecurrenceDateBefore(recurrenceRuleBefore,
					continuousTransactionBefore.getDateBeginn(), transaction.getDate());

			recurrenceRuleBefore.setUntil(DateUtils.localDateToDateTime(lastDateBefore));

			continuousTransactionBefore.setRecurrenceRule(recurrenceRuleBefore.toString());

			final List<Transaction> transactionsBefore = ContinuousTransactionService
					.generateTransactionsFromNewContinuousTransaction(continuousTransactionBefore);

			if (transactionsBefore != null && !transactionsBefore.isEmpty()) {
				DatabaseService.getInstance().persistContinuousTransaction(continuousTransactionBefore,
						transactionsBefore);
			}

			// generate continuous transactions after this single transaction if needed
			final ContinuousTransaction continuousTransactionAfter = transaction.getContinuousTransaction().getCopy();

			final RecurrenceRule recurrenceRuleAfter = RecurrenceRuleUtils
					.createRecurrenceRule(continuousTransactionAfter.getRecurrenceRule());

			final LocalDate firstDateAfter = RecurrenceRuleUtils.getFirstRecurrenceDateAfter(recurrenceRuleAfter,
					continuousTransactionAfter.getDateBeginn(), transaction.getDate());

			continuousTransactionAfter.setDateBeginn(firstDateAfter);

			boolean continuousTransactionsAfterIsNeeded = true;
			if (recurrenceRuleOriginal.getCount() != null) {
				final int numberOfTransactionsBefore = transactionsBefore != null ? transactionsBefore.size() : 0;

				final int numberOfTransactionsAfter = recurrenceRuleOriginal.getCount() - numberOfTransactionsBefore
						- 1;
				if (numberOfTransactionsAfter > 0) {
					recurrenceRuleAfter.setCount(numberOfTransactionsAfter);
				} else {
					continuousTransactionsAfterIsNeeded = false;
				}
			}

			if (continuousTransactionsAfterIsNeeded) {
				continuousTransactionAfter.setRecurrenceRule(recurrenceRuleAfter.toString());
				final List<Transaction> transactionsAfter = ContinuousTransactionService
						.generateTransactionsFromNewContinuousTransaction(continuousTransactionAfter);
				DatabaseService.getInstance().persistContinuousTransaction(continuousTransactionAfter,
						transactionsAfter);
			}

			DatabaseService.getInstance().deleteAllContinuousTransactions(transaction.getContinuousTransaction());
		} catch (final Exception e) {
			DatabaseService.getInstance().rollbackTransaction();
			throw e;
		}
		if (ownTransaction) {
			DatabaseService.getInstance().commitTransaction();
		}
	}

}
