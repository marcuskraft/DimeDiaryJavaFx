package com.dimediary.controller.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.dimediary.model.EntityManagerHelper;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Category;
import com.dimediary.model.entities.Transaction;

public class DBUtils {

	public static ArrayList<String> getBankAccountNames() {
		final ArrayList<String> names = new ArrayList<>();

		final EntityManager entityManager = EntityManagerHelper.getEntityManager();

		final TypedQuery<BankAccount> query = entityManager.createNamedQuery("allBankAccounts", BankAccount.class);
		final List<BankAccount> bankAccounts = query.getResultList();

		for (final BankAccount bankAccount : bankAccounts) {
			names.add(bankAccount.getName());
		}

		EntityManagerHelper.closeEntityManager();

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

		final EntityManager entityManager = EntityManagerHelper.getEntityManager();
		final TypedQuery<Transaction> query = entityManager.createNamedQuery("TransactionsBetween", Transaction.class)
				.setParameter("bankAccount", bankAccount).setParameter("dateFrom", dateFrom)
				.setParameter("dateUntil", dateUntil);

		transactions = query.getResultList();

		EntityManagerHelper.closeEntityManager();

		return transactions;
	}

	public static BankAccount getBankAccount(final String bankAccountName) {

		final EntityManager entityManager = EntityManagerHelper.getEntityManager();

		final BankAccount bankAccount = entityManager.find(BankAccount.class, bankAccountName);

		EntityManagerHelper.closeEntityManager();
		return bankAccount;
	}

	public static Category getCategory(final String categoryName) {

		final EntityManager entityManager = EntityManagerHelper.getEntityManager();

		final Category category = entityManager.createNamedQuery("findCategory", Category.class)
				.setParameter("name", categoryName).getSingleResult();

		EntityManagerHelper.closeEntityManager();
		return category;
	}

	public static ArrayList<String> getCategoryNames() {
		final ArrayList<String> categoryNames = new ArrayList<>();

		final EntityManager entityManager = EntityManagerHelper.getEntityManager();

		final List<Category> categories = entityManager.createNamedQuery("allCategories", Category.class)
				.getResultList();

		for (final Category category : categories) {
			categoryNames.add(category.getName());
		}

		EntityManagerHelper.closeEntityManager();

		return categoryNames;
	}

	public static void persist(final Transaction transaction) {
		final EntityManager entityManager = EntityManagerHelper.getEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(transaction);
		entityManager.getTransaction().commit();

		EntityManagerHelper.closeEntityManager();
	}

}
