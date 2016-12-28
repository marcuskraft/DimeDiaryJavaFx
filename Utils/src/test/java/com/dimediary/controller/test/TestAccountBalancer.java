package com.dimediary.controller.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;
import com.dimediary.model.utils.AmountUtils;
import com.dimediary.util.balance.AccountBalancer;
import com.dimediary.util.utils.DBUtils;
import com.dimediary.util.utils.DateUtils;

public class TestAccountBalancer {

	private BankAccount bankAccount;
	private final Double startBudget = 500.0;

	@Before
	public void before() {
		this.bankAccount = new BankAccount();
		this.bankAccount.setName("TestAccount");

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 5, 1);
		final Date date = calendar.getTime();

		this.bankAccount.setDateStartBudget(date);
		this.bankAccount.setStartBudget(this.startBudget);

		DBUtils.getInstance().persist(this.bankAccount);
	}

	@Test
	public void testInitialize() {
		AccountBalancer.initBalance(DBUtils.getInstance().getBankAccount("TestAccount"));

		final Double amount2 = 50.00;
		final Double amount3 = -78.45;
		final Double amount4 = 457.47;
		final Double amount5 = -45.74;
		final Double amount6 = 47.12;
		final Double amount7 = -4.14;
		final Double amount8 = 471.85;
		final Double amountJuly2 = 412.47;

		final Date date2 = DateUtils.getDate(2, 5, 2016);
		final Date date3 = DateUtils.getDate(3, 5, 2016);
		final Date date4 = DateUtils.getDate(4, 5, 2016);
		final Date date5 = DateUtils.getDate(5, 5, 2016);
		final Date date6 = DateUtils.getDate(6, 5, 2016);
		final Date date7 = DateUtils.getDate(7, 5, 2016);
		final Date date8 = DateUtils.getDate(8, 5, 2016);
		final Date dateJuly2 = DateUtils.getDate(2, 6, 2016);

		this.createTransaction(amount2, date2);
		this.createTransaction(amount3, date3);
		this.createTransaction(amount4, date4);
		this.createTransaction(amount5, date5);
		final Transaction transaction = this.createTransaction(amount6, date6);
		this.createTransaction(amount7, date7);
		this.createTransaction(amount8, date8);
		this.createTransaction(amountJuly2, dateJuly2);

		Double amount2After = AccountBalancer.getBalance(this.bankAccount, date2);
		Double amount3After = AccountBalancer.getBalance(this.bankAccount, date3);
		Double amount4After = AccountBalancer.getBalance(this.bankAccount, date4);
		Double amount5After = AccountBalancer.getBalance(this.bankAccount, date5);
		Double amount6After = AccountBalancer.getBalance(this.bankAccount, date6);
		Double amount7After = AccountBalancer.getBalance(this.bankAccount, date7);
		Double amount8After = AccountBalancer.getBalance(this.bankAccount, date8);
		Double amountJuly2After = AccountBalancer.getBalance(this.bankAccount, dateJuly2);

		Double shouldBe2 = this.startBudget + amount2;
		Double shouldBe3 = shouldBe2 + amount3;
		Double shouldBe4 = shouldBe3 + amount4;
		Double shouldBe5 = shouldBe4 + amount5;
		Double shouldBe6 = shouldBe5 + amount6;
		Double shouldBe7 = shouldBe6 + amount7;
		Double shouldBe8 = shouldBe7 + amount8;
		Double shouldBeJuly2 = shouldBe8 + amountJuly2;

		shouldBe2 = AmountUtils.round(shouldBe2);
		shouldBe3 = AmountUtils.round(shouldBe3);
		shouldBe4 = AmountUtils.round(shouldBe4);
		shouldBe5 = AmountUtils.round(shouldBe5);
		shouldBe6 = AmountUtils.round(shouldBe6);
		shouldBe7 = AmountUtils.round(shouldBe7);
		shouldBe8 = AmountUtils.round(shouldBe8);
		shouldBeJuly2 = AmountUtils.round(shouldBeJuly2);
		amount2After = AmountUtils.round(amount2After);
		amount3After = AmountUtils.round(amount3After);
		amount4After = AmountUtils.round(amount4After);
		amount5After = AmountUtils.round(amount5After);
		amount6After = AmountUtils.round(amount6After);
		amount7After = AmountUtils.round(amount7After);
		amount8After = AmountUtils.round(amount8After);
		amountJuly2After = AmountUtils.round(amountJuly2After);

		Assert.assertTrue(amount2After.equals(shouldBe2));
		Assert.assertTrue(amount3After.equals(shouldBe3));
		Assert.assertTrue(amount4After.equals(shouldBe4));
		Assert.assertTrue(amount5After.equals(shouldBe5));
		Assert.assertTrue(amount6After.equals(shouldBe6));
		Assert.assertTrue(amount7After.equals(shouldBe7));
		Assert.assertTrue(amount8After.equals(shouldBe8));
		Assert.assertTrue(amountJuly2After.equals(shouldBeJuly2));

		////////////////////////////////////////////

		DBUtils.getInstance().delete(transaction);

		amount2After = AccountBalancer.getBalance(this.bankAccount, date2);
		amount3After = AccountBalancer.getBalance(this.bankAccount, date3);
		amount4After = AccountBalancer.getBalance(this.bankAccount, date4);
		amount5After = AccountBalancer.getBalance(this.bankAccount, date5);
		amount6After = AccountBalancer.getBalance(this.bankAccount, date6);
		amount7After = AccountBalancer.getBalance(this.bankAccount, date7);
		amount8After = AccountBalancer.getBalance(this.bankAccount, date8);
		amountJuly2After = AccountBalancer.getBalance(this.bankAccount, dateJuly2);

		shouldBe6 -= amount6;
		shouldBe7 -= amount6;
		shouldBe8 -= amount6;
		shouldBeJuly2 -= amount6;

		shouldBe2 = AmountUtils.round(shouldBe2);
		shouldBe3 = AmountUtils.round(shouldBe3);
		shouldBe4 = AmountUtils.round(shouldBe4);
		shouldBe5 = AmountUtils.round(shouldBe5);
		shouldBe6 = AmountUtils.round(shouldBe6);
		shouldBe7 = AmountUtils.round(shouldBe7);
		shouldBe8 = AmountUtils.round(shouldBe8);
		shouldBeJuly2 = AmountUtils.round(shouldBeJuly2);
		amount2After = AmountUtils.round(amount2After);
		amount3After = AmountUtils.round(amount3After);
		amount4After = AmountUtils.round(amount4After);
		amount5After = AmountUtils.round(amount5After);
		amount6After = AmountUtils.round(amount6After);
		amount7After = AmountUtils.round(amount7After);
		amount8After = AmountUtils.round(amount8After);
		amountJuly2After = AmountUtils.round(amountJuly2After);

		Assert.assertTrue(amount2After.equals(shouldBe2));
		Assert.assertTrue(amount3After.equals(shouldBe3));
		Assert.assertTrue(amount4After.equals(shouldBe4));
		Assert.assertTrue(amount5After.equals(shouldBe5));
		Assert.assertTrue(amount6After.equals(shouldBe6));
		Assert.assertTrue(amount7After.equals(shouldBe7));
		Assert.assertTrue(amount8After.equals(shouldBe8));
		Assert.assertTrue(amountJuly2After.equals(shouldBeJuly2));

	}

	private Transaction createTransaction(final Double amount, final Date date) {
		final Transaction transaction = new Transaction();

		transaction.setBankAccount(this.bankAccount);
		transaction.setAmount(amount);
		transaction.setDate(date);

		DBUtils.getInstance().persist(transaction);
		return transaction;
	}

	@After
	public void close() {
		DBUtils.getInstance().delete(this.bankAccount);

		DBUtils.getInstance().close();
	}

}
