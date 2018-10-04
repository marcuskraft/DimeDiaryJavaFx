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

	/**
	 * generates all transactions belonging to this continuous transaction
	 *
	 * @param continuousTransaction
	 * @return
	 */
	public static List<Transaction> generateTransactionsForContinuousTransaction(
			final ContinuousTransaction continuousTransaction) {
		final RecurrenceRule recurrenceRule = RecurrenceRuleUtils
				.createRecurrenceRule(continuousTransaction.getRecurrenceRule());
		final LocalDate firstDate = continuousTransaction.getDateBeginn();
		final List<LocalDate> dates = RecurrenceRuleUtils.getDatesForRecurrenceRule(recurrenceRule,
				DateUtils.localDateToDateTime(continuousTransaction.getDateBeginn()),
				DateUtils.localDateToDateTime(firstDate));

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
	private static void splitContinuousTransaction(final ContinuousTransaction continuousTransaction,
			final LocalDate lastDateBefore, final LocalDate firstDateAfter) {
		// TODO: don't delete all transactions, only reorganize the continuous
		// transaction into two
		final boolean ownTransaction = DatabaseService.getInstance().beginTransaction();

		try {
			final RecurrenceRule recurrenceRuleOriginal = RecurrenceRuleUtils
					.createRecurrenceRule(continuousTransaction.getRecurrenceRule());

			final List<Transaction> transactionsBefore = ContinuousTransactionService
					.generateContinuousTransactionBefore(continuousTransaction, lastDateBefore);

			ContinuousTransactionService.generateContinuousTransactionAfter(continuousTransaction, firstDateAfter,
					recurrenceRuleOriginal, transactionsBefore);

			DatabaseService.getInstance().deleteAllContinuousTransactions(continuousTransaction);
		} catch (final Exception e) {
			DatabaseService.getInstance().rollbackTransaction();
			throw e;
		}
		if (ownTransaction) {
			DatabaseService.getInstance().commitTransaction();
		}
	}

	private static void generateContinuousTransactionAfter(final ContinuousTransaction continuousTransaction,
			final LocalDate firstDateAfter, final RecurrenceRule recurrenceRuleOriginal,
			final List<Transaction> transactionsBefore) {
		final ContinuousTransaction continuousTransactionAfter = continuousTransaction.getCopy();

		final RecurrenceRule recurrenceRuleAfter = RecurrenceRuleUtils
				.createRecurrenceRule(continuousTransactionAfter.getRecurrenceRule());

		final LocalDate firstDateAfterRecurrence = RecurrenceRuleUtils.getFirstRecurrenceDateAfter(recurrenceRuleAfter,
				continuousTransactionAfter.getDateBeginn(), firstDateAfter.minusDays(1));

		continuousTransactionAfter.setDateBeginn(firstDateAfterRecurrence);

		boolean continuousTransactionsAfterIsNeeded = true;
		if (recurrenceRuleOriginal.getCount() != null) {
			final int numberOfTransactionsBefore = transactionsBefore != null ? transactionsBefore.size() : 0;

			final int numberOfTransactionsAfter = recurrenceRuleOriginal.getCount() - numberOfTransactionsBefore - 1;
			if (numberOfTransactionsAfter > 0) {
				recurrenceRuleAfter.setCount(numberOfTransactionsAfter);
			} else {
				continuousTransactionsAfterIsNeeded = false;
			}
		}

		if (continuousTransactionsAfterIsNeeded) {
			continuousTransactionAfter.setRecurrenceRule(recurrenceRuleAfter.toString());
			final List<Transaction> transactionsAfter = DatabaseService.getInstance()
					.getTransactionsFromDate(continuousTransaction, firstDateAfterRecurrence);
			if (transactionsAfter == null) {
				return;
			}

			for (final Transaction transaction : transactionsAfter) {
				transaction.setContinuousTransaction(continuousTransactionAfter);
			}

			DatabaseService.getInstance().persistContinuousTransactionMergeTransactions(continuousTransactionAfter,
					transactionsAfter);
		}
	}

	private static List<Transaction> generateContinuousTransactionBefore(
			final ContinuousTransaction continuousTransaction, final LocalDate lastDateBefore) {
		final ContinuousTransaction continuousTransactionBefore = continuousTransaction.getCopy();

		final RecurrenceRule recurrenceRuleBefore = RecurrenceRuleUtils
				.createRecurrenceRule(continuousTransactionBefore.getRecurrenceRule());

		final LocalDate lastDateBeforeRecurrence = RecurrenceRuleUtils.getLastRecurrenceDateBefore(recurrenceRuleBefore,
				continuousTransactionBefore.getDateBeginn(), lastDateBefore.plusDays(1));

		if (lastDateBeforeRecurrence == null) {
			return null;
		}

		recurrenceRuleBefore.setUntil(DateUtils.localDateToDateTime(lastDateBeforeRecurrence));

		continuousTransactionBefore.setRecurrenceRule(recurrenceRuleBefore.toString());

		final List<Transaction> transactionsBefore = DatabaseService.getInstance()
				.getTransactionsUntil(continuousTransaction, lastDateBeforeRecurrence);

		if (transactionsBefore != null && !transactionsBefore.isEmpty()) {
			for (final Transaction transaction : transactionsBefore) {
				transaction.setContinuousTransaction(continuousTransactionBefore);
			}
			DatabaseService.getInstance().persistContinuousTransactionMergeTransactions(continuousTransactionBefore,
					transactionsBefore);
		}
		return transactionsBefore;
	}

}
