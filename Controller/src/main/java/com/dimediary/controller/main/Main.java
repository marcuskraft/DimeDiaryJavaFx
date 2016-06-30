package com.dimediary.controller.main;

import java.util.ArrayList;

import com.dimediary.model.transaction.BankTransaction;
import com.dimediary.model.transaction.CashTransaction;
import com.dimediary.model.transaction.ITransaction;

public class Main {

	public static void main(String[] args) {
		ArrayList<ITransaction> transactions = new ArrayList<ITransaction>();

		for (int i = 0; i < 10; i++) {
			transactions.add(new BankTransaction((double) i));
			transactions.add(new CashTransaction((double) i));
		}

		for (ITransaction transaction : transactions) {
			System.out.println(transaction.getClass().getName());
			System.out.println(transaction.getAmount());
		}
		
		try {
			Thread.sleep(40000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
