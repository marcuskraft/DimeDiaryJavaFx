package com.dimediary.controller.test;

import java.util.Calendar;
import java.util.Date;

import org.junit.After;
import org.junit.Test;

import com.dimediary.controller.balance.AccountBalancer;
import com.dimediary.controller.utils.DBUtils;
import com.dimediary.model.entities.BankAccount;

public class TestAccountBalancer {

	private BankAccount bankAccount;

	// @Before
	public void before() {
		this.bankAccount = new BankAccount();
		this.bankAccount.setName("TestAccount");

		final Calendar calendar = Calendar.getInstance();
		calendar.set(2016, 5, 1, 0, 0, 0);
		final Date date = calendar.getTime();

		this.bankAccount.setDateStartBudget(date);
		this.bankAccount.setStartBudget(500.0);

		DBUtils.getInstance().persist(this.bankAccount);
	}

	@Test
	public void testInitialize() {

		final AccountBalancer accountBalancer = new AccountBalancer();
		accountBalancer.initBalance(DBUtils.getInstance().getBankAccount("TestAccount"));
	}

	@After
	public void close() {
		DBUtils.getInstance().close();
	}

}
