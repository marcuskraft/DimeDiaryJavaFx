package com.dimediary.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.dimediary.model.EntityManagerHolder;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;

public class DBUtils {

	public static ArrayList<String> getBankAccountNames() {
		final ArrayList<String> names = new ArrayList<>();

		final EntityManagerHolder entityManagerHolder = EntityManagerHolder.getInstance();
		final EntityManager entityManager = entityManagerHolder.getEntityManager();

		final TypedQuery<BankAccount> query = entityManager.createNamedQuery("allBankAccounts", BankAccount.class);
		final List<BankAccount> bankAccounts = query.getResultList();

		for (final BankAccount bankAccount : bankAccounts) {
			names.add(bankAccount.getName());
		}

		entityManagerHolder.close();

		return names;
	}

	public static List<Transaction> geTransactions(final Date dateFrom, final Date dateUntil,
			final String bankAccountName) {
		final BankAccount bankAccount = DBUtils.getBankAccount(bankAccountName);
		return DBUtils.geTransactions(dateFrom, dateUntil, bankAccount);
	}

	public static List<Transaction> geTransactions(final Date dateFrom, final Date dateUntil,
			final BankAccount bankAccount) {
		List<Transaction> transactions;

		final EntityManagerHolder entityManagerHolder = EntityManagerHolder.getInstance();
		final EntityManager entityManager = entityManagerHolder.getEntityManager();
		final TypedQuery<Transaction> query = entityManager.createNamedQuery("TransactionsBetween", Transaction.class)
				.setParameter("bankAccount", bankAccount).setParameter("dateFrom", dateFrom)
				.setParameter("dateUntil", dateUntil);

		transactions = query.getResultList();

		entityManagerHolder.close();

		return transactions;
	}

	private static BankAccount getBankAccount(final String bankAccountName) {
		final EntityManagerHolder entityManagerHolder = EntityManagerHolder.getInstance();
		final EntityManager entityManager = entityManagerHolder.getEntityManager();

		final BankAccount bankAccount = entityManager.find(BankAccount.class, bankAccountName);

		entityManagerHolder.close();
		return bankAccount;
	}

}
