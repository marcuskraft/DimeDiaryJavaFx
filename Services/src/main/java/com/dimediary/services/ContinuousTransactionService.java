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

	/**
	 * splits the continuous transaction into two continuous transactions. The first
	 * one will start at the same date as the old continuous transaction and will
	 * end not later than lastDateBefore. The second one will start not earlier than
	 * firstDateAfter and end at the same date as the old one. The old continuous
	 * transaction with all his transactions will be deleted. The recurrence rule
	 * itself is still the same for both new continuous transactions.
	 *
	 * @param continuousTransaction
	 * @param lastDateBefore
	 * @param firstDateAfter
	 */
	public static void splitContinuousTransaction(final ContinuousTransaction continuousTransaction,
			final LocalDate lastDateBefore, final LocalDate firstDateAfter) {
		final boolean ownTransaction = DatabaseService.getInstance().beginTransaction();

		try {
			final RecurrenceRule recurrenceRuleOriginal = RecurrenceRuleUtils
					.createRecurrenceRule(continuousTransaction.getRecurrenceRule());

			// Generate continuous transactions before this single transaction if needed
			final ContinuousTransaction continuousTransactionBefore = continuousTransaction.getCopy();

			final RecurrenceRule recurrenceRuleBefore = RecurrenceRuleUtils
					.createRecurrenceRule(continuousTransactionBefore.getRecurrenceRule());

			final LocalDate lastDateBeforeRecurrence = RecurrenceRuleUtils.getLastRecurrenceDateBefore(
					recurrenceRuleBefore, continuousTransactionBefore.getDateBeginn(), lastDateBefore.plusDays(1));

			recurrenceRuleBefore.setUntil(DateUtils.localDateToDateTime(lastDateBeforeRecurrence));

			continuousTransactionBefore.setRecurrenceRule(recurrenceRuleBefore.toString());

			final List<Transaction> transactionsBefore = ContinuousTransactionService
					.generateTransactionsFromNewContinuousTransaction(continuousTransactionBefore);

			if (transactionsBefore != null && !transactionsBefore.isEmpty()) {
				DatabaseService.getInstance().persistContinuousTransaction(continuousTransactionBefore,
						transactionsBefore);
			}

			// generate continuous transactions after this single transaction if needed
			final ContinuousTransaction continuousTransactionAfter = continuousTransaction.getCopy();

			final RecurrenceRule recurrenceRuleAfter = RecurrenceRuleUtils
					.createRecurrenceRule(continuousTransactionAfter.getRecurrenceRule());

			final LocalDate firstDateAfterRecurrence = RecurrenceRuleUtils.getFirstRecurrenceDateAfter(
					recurrenceRuleAfter, continuousTransactionAfter.getDateBeginn(), firstDateAfter.minusDays(1));

			continuousTransactionAfter.setDateBeginn(firstDateAfterRecurrence);

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

			DatabaseService.getInstance().deleteAllContinuousTransactions(continuousTransaction);
		} catch (final Exception e) {
			DatabaseService.getInstance().rollbackTransaction();
			throw e;
		}
		if (ownTransaction) {
			DatabaseService.getInstance().commitTransaction();
		}
	}

	/**
	 * splits the continuous transaction around the given transaction. Two new
	 * continuous transactions are created and the old one with all his transactions
	 * will be deleted. The given transaction will be deleted and there will be no
	 * new transaction at this date whether in the continuous transaction before nor
	 * in the the one after this transaction. The recurrence rule itself is still
	 * the same for both new continuous transactions.
	 *
	 * @param transaction
	 */
	public static void splitContinuousTransaction(final Transaction transaction) {
		ContinuousTransactionService.splitContinuousTransaction(transaction.getContinuousTransaction(),
				transaction.getDate().minusDays(1), transaction.getDate().plusDays(1));
	}

}
