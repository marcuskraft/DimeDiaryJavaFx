package com.dimediary.services;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;
import com.dimediary.model.utils.AmountUtils;
import com.dimediary.services.utils.DBUtils;

@RunWith(MockitoJUnitRunner.class)
public class TestAccountBalancer {

	private static final String TEST_ACCOUNT = "TestAccount";
	private static final LocalDate DATE_START_DAY = LocalDate.of(2016, 5, 1);
	private static final Double START_BUDGET = 500.0;

	@Mock
	private BankAccount bankAccount;

	// @Before
	public void before() {
		Mockito.when(this.bankAccount.getDateStartBudget()).thenReturn(TestAccountBalancer.DATE_START_DAY);
		Mockito.when(this.bankAccount.getStartBudget()).thenReturn(TestAccountBalancer.START_BUDGET);
		Mockito.when(this.bankAccount.getName()).thenReturn(TestAccountBalancer.TEST_ACCOUNT);
	}

	// @Test
	public void testInitialize() {
		// AccountBalancer.initBalance(DBUtils.getInstance().getBankAccount("TestAccount"));

		final Double amount2 = 50.00;
		final Double amount3 = -78.45;
		final Double amount4 = 457.47;
		final Double amount5 = -45.74;
		final Double amount6 = 47.12;
		final Double amount7 = -4.14;
		final Double amount8 = 471.85;
		final Double amountJuly2 = 412.47;

		final LocalDate date2 = LocalDate.of(2016, 6, 2);
		final LocalDate date3 = LocalDate.of(2016, 6, 3);
		final LocalDate date4 = LocalDate.of(2016, 6, 4);
		final LocalDate date5 = LocalDate.of(2016, 6, 5);
		final LocalDate date6 = LocalDate.of(2016, 6, 6);
		final LocalDate date7 = LocalDate.of(2016, 6, 7);
		final LocalDate date8 = LocalDate.of(2016, 6, 8);
		final LocalDate dateJuly2 = LocalDate.of(2016, 7, 2);

		this.createTransaction(amount2, date2);
		this.createTransaction(amount3, date3);
		this.createTransaction(amount4, date4);
		this.createTransaction(amount5, date5);
		final Transaction transaction = this.createTransaction(amount6, date6);
		this.createTransaction(amount7, date7);
		this.createTransaction(amount8, date8);
		this.createTransaction(amountJuly2, dateJuly2);

		Double amount2After = AccountBalanceService.getBalance(this.bankAccount, date2);
		Double amount3After = AccountBalanceService.getBalance(this.bankAccount, date3);
		Double amount4After = AccountBalanceService.getBalance(this.bankAccount, date4);
		Double amount5After = AccountBalanceService.getBalance(this.bankAccount, date5);
		Double amount6After = AccountBalanceService.getBalance(this.bankAccount, date6);
		Double amount7After = AccountBalanceService.getBalance(this.bankAccount, date7);
		Double amount8After = AccountBalanceService.getBalance(this.bankAccount, date8);
		Double amountJuly2After = AccountBalanceService.getBalance(this.bankAccount, dateJuly2);

		Double shouldBe2 = TestAccountBalancer.START_BUDGET + amount2;
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

		amount2After = AccountBalanceService.getBalance(this.bankAccount, date2);
		amount3After = AccountBalanceService.getBalance(this.bankAccount, date3);
		amount4After = AccountBalanceService.getBalance(this.bankAccount, date4);
		amount5After = AccountBalanceService.getBalance(this.bankAccount, date5);
		amount6After = AccountBalanceService.getBalance(this.bankAccount, date6);
		amount7After = AccountBalanceService.getBalance(this.bankAccount, date7);
		amount8After = AccountBalanceService.getBalance(this.bankAccount, date8);
		amountJuly2After = AccountBalanceService.getBalance(this.bankAccount, dateJuly2);

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

	private Transaction createTransaction(final Double amount, final LocalDate date) {
		final Transaction transaction = new Transaction();

		transaction.setBankAccount(this.bankAccount);
		transaction.setAmount(amount);
		transaction.setDate(date);

		DBUtils.getInstance().persist(transaction);
		return transaction;
	}

	// @After
	public void close() {
		DBUtils.getInstance().delete(this.bankAccount);

		DBUtils.getInstance().close();
	}

}
