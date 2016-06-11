package com.dimediary.model.transaction;

public class BankTransaction extends Transaction {

	public BankTransaction(double amount) {
		super(amount);
		this.amount -= 1.0;
	}
	
	public int getZero() {
		return 0;
	}


}
