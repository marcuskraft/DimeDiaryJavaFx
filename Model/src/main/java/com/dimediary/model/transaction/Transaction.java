package com.dimediary.model.transaction;

public abstract class Transaction implements ITransaction {

	protected double amount;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public Transaction(double amount) {
		this.amount = amount;
	}
	



}
