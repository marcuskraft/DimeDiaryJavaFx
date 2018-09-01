package com.dimediary.services;

import java.time.LocalDate;

import org.junit.Test;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.services.database.DatabaseService;

public class DatabaseServiceTest {

	@Test
	public void testDatabase() {
		DatabaseService.getInstance(DatabaseService.PERSISTENCE_DERBY_TEST).clearDatabase();
		final BankAccount bankAccount = new BankAccount();
		bankAccount.setName("test2");
		bankAccount.setBankName("Sparkasse");
		bankAccount.setDateStartBudget(LocalDate.now());
		bankAccount.setStartBudget(400.4);
		DatabaseService.getInstance(DatabaseService.PERSISTENCE_DERBY_TEST).persist(bankAccount);
	}

}
