package com.dimediary.services;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;
import com.dimediary.model.utils.AmountUtils;
import com.dimediary.services.database.DatabaseService;

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
		TestAccountBalancer.DB_INSTANCE.clearAllTransactions();
		final List<String> bankaccountNames = TestAccountBalancer.DB_INSTANCE.getBankAccountNames();
		if (bankaccountNames != null && bankaccountNames.size() == 1) {
			this.bankAccount = TestAccountBalancer.DB_INSTANCE.getBankAccount(bankaccountNames.get(0));
		} else {
			throw new IllegalStateException("There must be exact one bank account in the tast database");
		}
	}

	@Test
	public void testSimpleTransactionAdding() {

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
		Iterator<Map.Entry<LocalDate, Double>> iterator = amountDatas.entrySet().iterator();
		while (iterator.hasNext()) {
			final Map.Entry<LocalDate, Double> amounData = iterator.next();
			this.createTransaction(amounData.getValue(), amounData.getKey());

		}

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

	private Transaction createTransaction(final Double amount, final LocalDate date) {
		final Transaction transaction = new Transaction();

		transaction.setBankAccount(this.bankAccount);
		transaction.setAmount(AmountUtils.round(amount));
		transaction.setDate(date);

		TestAccountBalancer.DB_INSTANCE.persist(transaction);
		return transaction;
	}

	@After
	public void close() {
		TestAccountBalancer.DB_INSTANCE.clearAllTransactions();
		TestAccountBalancer.DB_INSTANCE.close();
	}

}
