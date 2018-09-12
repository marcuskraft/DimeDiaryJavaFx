package com.dimediary.services;

import org.junit.Test;

import com.dimediary.services.database.DatabaseService;

public class DatabaseServiceTest {

	@Test
	public void testDatabase() {
		DatabaseService.getInstance(DatabaseService.PERSISTENCE_DERBY_TEST).clearAllTransactions();
	}

}
