package com.dimediary.test;

import java.util.ArrayList;

import com.dimediary.model.transaction.*;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<ITransaction> transactions = new ArrayList<ITransaction>();
		
		for (int i =0; i<10; i++) {
			transactions.add(new BankTransaction((double)i));
			transactions.add(new CashTransaction((double)i));
		}
		
		for (ITransaction transaction : transactions) {
			System.out.println(transaction.getClass().getName());
			System.out.println(transaction.getAmount());
		}
		
		
	}

}
