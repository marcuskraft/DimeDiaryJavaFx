package com.dimediary.controller.balance;

import java.util.Date;

import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;

public interface IAccountBalancer {

	public static enum BalanceAction {
		adding, deleting
	}

	public Double getBalance(BankAccount bankAccount, Date date);

	public void updateBalance(Transaction transaction, BalanceAction action);

	public void initBalance(BankAccount bankAccount);

	public void proofBalance(BankAccount bankAccount);

}
