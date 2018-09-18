package com.dimediary.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

import org.dmfs.rfc5545.recur.Freq;
import org.dmfs.rfc5545.recur.InvalidRecurrenceRuleException;
import org.dmfs.rfc5545.recur.RecurrenceRule;
import org.dmfs.rfc5545.recur.RecurrenceRule.Part;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.model.utils.AmountUtils;
import com.dimediary.services.database.DatabaseService;
import com.dimediary.util.utils.DateUtils;
import com.dimediary.util.utils.RecurrenceRuleUtils;

public class TestAccountBalancer {

	private static final long SEED_FOR_RANDOM_INT = 64754L;
	private static final long SEED_FOR_RANDOM_BOOL = 417854L;
	private static final long SEED_FOR_RANDOM_DOUBLE = 142754L;
	private static DatabaseService DB_INSTANCE;
	private BankAccount bankAccount;

	private static final Double RANGE_MAX = 350.00;

	@Before
	public void before() {
		TestAccountBalancer.DB_INSTANCE = DatabaseService.getInstance(DatabaseService.PERSISTENCE_DERBY_TEST);
		TestAccountBalancer.DB_INSTANCE.beginTransaction();
		TestAccountBalancer.DB_INSTANCE.clearAllTransactions();
		final List<String> bankaccountNames = TestAccountBalancer.DB_INSTANCE.getBankAccountNames();
		if (bankaccountNames != null && bankaccountNames.size() == 1) {
			this.bankAccount = TestAccountBalancer.DB_INSTANCE.getBankAccount(bankaccountNames.get(0));
		} else {
			throw new IllegalStateException("There must be exact one bank account in the tast database");
		}
		TestAccountBalancer.DB_INSTANCE.commitTransaction();
	}

	@After
	public void close() {
		TestAccountBalancer.DB_INSTANCE.close();
	}

	@Test
	public void testSimpleTransactionAdding() {

		Iterator<Map.Entry<LocalDate, Double>> iterator;
		final Map<LocalDate, Double> amountDatas = this.generateRandomTransactions();

		Double balanceShould = this.bankAccount.getStartBudget();
		Double balance;

		iterator = amountDatas.entrySet().iterator();
		while (iterator.hasNext()) {
			final Map.Entry<LocalDate, Double> amounData = iterator.next();

			balance = AccountBalanceService.getBalance(this.bankAccount, amounData.getKey());
			balanceShould += AmountUtils.round(amounData.getValue());

			Assert.assertNotNull(balance);
			Assert.assertNotNull(balanceShould);
			Assert.assertEquals(balance, AmountUtils.round(balanceShould));
		}

	}

	@Test
	public void testContinuousTransaction() throws InvalidRecurrenceRuleException {

		final ContinuousTransaction continuousTransaction = new ContinuousTransaction();
		final LocalDate dateBeginnContinuousTransaction = this.bankAccount.getDateStartBudget().plusDays(50);

		final RecurrenceRule recurrenceRule = new RecurrenceRule(Freq.MONTHLY);
		recurrenceRule.setByPart(Part.BYMONTHDAY, 1);
		recurrenceRule.setCount(10);

		LocalDate testDate = this.bankAccount.getDateStartBudget();
		Double balance;
		for (int i = 0; i < 20; i++) {
			testDate = testDate.plusDays(i * i * 30);
			balance = AccountBalanceService.getBalance(this.bankAccount, testDate);
			Assert.assertEquals(balance, this.bankAccount.getStartBudget());
		}

		this.generateContinuousTransaction(continuousTransaction, dateBeginnContinuousTransaction, recurrenceRule);

		testDate = this.bankAccount.getDateStartBudget();
		Double balanceIs = AccountBalanceService.getBalance(this.bankAccount, testDate);
		Assert.assertEquals(balanceIs, this.bankAccount.getStartBudget());

		final List<LocalDate> recurrenceDates = RecurrenceRuleUtils.getDatesForRecurrenceRule(recurrenceRule,
				dateBeginnContinuousTransaction, dateBeginnContinuousTransaction);

		Double balanceShould = this.bankAccount.getStartBudget();
		for (final LocalDate localDate : recurrenceDates) {
			balanceShould = AmountUtils.round(balanceShould + continuousTransaction.getAmount());
			for (int i = 0; i < localDate.getMonth().length(localDate.isLeapYear()); i++) {
				testDate = localDate.plusDays(i);
				balanceIs = AccountBalanceService.getBalance(this.bankAccount, testDate);
				Assert.assertEquals(balanceIs, balanceShould);
			}
		}

	}

	@Test
	public void TestGetBalanceFollowingDays() throws InvalidRecurrenceRuleException {
		this.generateRandomTransactions();

		final ContinuousTransaction continuousTransaction = new ContinuousTransaction();
		final RecurrenceRule recurrenceRule = new RecurrenceRule(Freq.MONTHLY);
		recurrenceRule.setByPart(Part.BYMONTHDAY, 1);
		recurrenceRule.setCount(100);

		this.generateContinuousTransaction(continuousTransaction, this.bankAccount.getDateStartBudget().plusMonths(2),
				recurrenceRule);

		final List<LocalDate> dates = new ArrayList<>();
		LocalDate lastDate = this.bankAccount.getDateStartBudget().plusDays(10);
		for (int i = 0; i < 400; i++) {
			dates.add(lastDate);
			lastDate = lastDate.plusDays(1);
		}

		final Map<LocalDate, Double> balancesFollowingDays = AccountBalanceService
				.getBalancesFollowingDays(this.bankAccount, dates);

		Double balanceFollowing;
		Double balance;
		for (final LocalDate localDate : dates) {
			balance = AccountBalanceService.getBalance(this.bankAccount, localDate);
			balanceFollowing = balancesFollowingDays.get(localDate);
			Assert.assertEquals(balance, balanceFollowing);
		}

	}

	@Test
	public void testDeleteTransaction() {
		final Map<LocalDate, Double> transactions = this.generateRandomTransactions();

		LocalDate firstDate = null;
		LocalDate lastDate = null;
		final Transaction transactionToDelete;
		LocalDate localDateToDelete = null;
		int i = 0;
		final int iMax = transactions.size() - 1;
		for (final Entry<LocalDate, Double> element : transactions.entrySet()) {
			final Entry<LocalDate, Double> transactionSet = element;
			if (i == 0) {
				firstDate = transactionSet.getKey();
			} else if (i == 15) {
				localDateToDelete = element.getKey();
			} else if (i == iMax) {
				lastDate = transactionSet.getKey();
			}
			i++;
		}

		final List<LocalDate> dates = DateUtils.getLocalDatesFromTo(firstDate, lastDate);
		final Map<LocalDate, Double> balancesFollowingDays = AccountBalanceService
				.getBalancesFollowingDays(this.bankAccount, dates);

		final ArrayList<Transaction> transactionsAtThisDate = TestAccountBalancer.DB_INSTANCE
				.getTransactions(this.bankAccount, localDateToDelete);

		Assert.assertNotNull(transactionsAtThisDate);
		Assert.assertTrue(transactionsAtThisDate.size() == 1);

		transactionToDelete = transactionsAtThisDate.get(0);
		final Double balanceForThisTransaction = transactionToDelete.getAmount();
		final LocalDate dateForThisTransaction = transactionToDelete.getDate();

		TestAccountBalancer.DB_INSTANCE.delete(transactionToDelete);

		Double balance;
		for (final LocalDate localDate : dates) {
			balance = AccountBalanceService.getBalance(this.bankAccount, localDate);
			if (!localDate.isBefore(dateForThisTransaction)) {
				balance = AmountUtils.round(balance + balanceForThisTransaction);
			}
			final Double actual = balancesFollowingDays.get(localDate);
			Assert.assertEquals(balance, actual);
		}

	}

	private void generateContinuousTransaction(final ContinuousTransaction continuousTransaction,
			final LocalDate dateBeginnContinuousTransaction, final RecurrenceRule recurrenceRule) {
		continuousTransaction.setBankAccount(this.bankAccount);
		continuousTransaction.setAmount(50.0);
		continuousTransaction.setDateBeginn(dateBeginnContinuousTransaction);
		continuousTransaction.setRecurrenceRule(recurrenceRule.toString());

		final List<Transaction> transactions = ContinuousTransactionService
				.generateTransactionsForContinuousTransaction(continuousTransaction);

		TestAccountBalancer.DB_INSTANCE.persistContinuousTransaction(continuousTransaction, transactions);
	}

	private Map<LocalDate, Double> generateRandomTransactions() {
		final Map<LocalDate, Double> amountDatas = new TreeMap<>();

		Double amount;
		LocalDate date = this.bankAccount.getDateStartBudget();
		final Random randomDouble = new Random(TestAccountBalancer.SEED_FOR_RANDOM_DOUBLE);
		final Random randomBool = new Random(TestAccountBalancer.SEED_FOR_RANDOM_BOOL);
		final Random randomInt = new Random(TestAccountBalancer.SEED_FOR_RANDOM_INT);
		for (int i = 0; i < 100; i++) {
			amount = TestAccountBalancer.RANGE_MAX * randomDouble.nextDouble();
			if (randomBool.nextBoolean()) {
				amount = -amount;
			}
			date = date.plusDays(randomInt.nextInt(i + 1));

			amountDatas.put(date, AmountUtils.round(amount));

		}

		// generate transactions
		final Iterator<Map.Entry<LocalDate, Double>> iterator = amountDatas.entrySet().iterator();
		while (iterator.hasNext()) {
			final Map.Entry<LocalDate, Double> amounData = iterator.next();
			this.createTransaction(amounData.getValue(), amounData.getKey());

		}
		return amountDatas;
	}

	private Transaction createTransaction(final Double amount, final LocalDate date) {
		final Transaction transaction = new Transaction();

		transaction.setBankAccount(this.bankAccount);
		transaction.setAmount(AmountUtils.round(amount));
		transaction.setDate(date);

		TestAccountBalancer.DB_INSTANCE.persist(transaction);
		return transaction;
	}

}
