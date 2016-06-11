package com.dimediary.model.transaction;

public abstract class Transaction implements ITransaction {

	protected double amount;
	
	@Override
	public double getAmount() {
		return amount;
	}

	@Override
	public void setAmount(double amount) {
		this.amount = amount;
	}

	
	public Transaction(double amount) {
		this.amount = amount;
	}
	



}
