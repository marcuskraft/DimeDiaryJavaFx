package com.dimediary.controller.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.dimediary.model.EntityManagerHelper;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.BankAccountCategory;
import com.dimediary.model.entities.Category;
import com.dimediary.model.entities.Transaction;

public class DBUtils {

	private EntityManager entityManager;

	private DBUtils() {
		this.initialize();
	}

	private static DBUtils instance = null;

	public static DBUtils getInstance() {
		if (DBUtils.instance == null) {
			DBUtils.instance = new DBUtils();
		}
		return DBUtils.instance;
	}

	public void initialize() {
		this.entityManager = EntityManagerHelper.getEntityManager();
	}

	public void close() {
		EntityManagerHelper.closeEntityManager();
	}

	public ArrayList<String> getBankAccountNames() {
		final ArrayList<String> names = new ArrayList<>();

		final TypedQuery<BankAccount> query = this.entityManager.createNamedQuery("allBankAccounts", BankAccount.class);
		final List<BankAccount> bankAccounts = query.getResultList();

		for (final BankAccount bankAccount : bankAccounts) {
			names.add(bankAccount.getName());
		}

		return names;
	}

	public BankAccount getBankAccount(final String bankAccountName) {

		final BankAccount bankAccount = this.entityManager.find(BankAccount.class, bankAccountName);

		return bankAccount;
	}

	public ArrayList<BankAccount> getBankAccounts(final ArrayList<String> bankAccountsNames) {
		final List<BankAccount> bankAccounts = this.entityManager
				.createNamedQuery("findBankAccounts", BankAccount.class).setParameter("namesList", bankAccountsNames)
				.getResultList();
		return new ArrayList<BankAccount>(bankAccounts);
	}

	public ArrayList<String> getBankAccountCategoryNames() {
		final ArrayList<String> names = new ArrayList<>();

		final List<BankAccountCategory> bankAccountCategories = this.entityManager
				.createNamedQuery("allAccountCategories", BankAccountCategory.class).getResultList();

		for (final BankAccountCategory bankAccountCategory : bankAccountCategories) {
			names.add(bankAccountCategory.getName());
		}

		return names;
	}

	public BankAccountCategory getBankAccountCategory(final String bankAccountCategoryName) {

		final BankAccountCategory bankAccountCategory = this.entityManager.find(BankAccountCategory.class,
				bankAccountCategoryName);

		return bankAccountCategory;
	}

	public ArrayList<BankAccountCategory> getBankAccountCategories(final ArrayList<String> bankAccountCategoryNames) {

		final List<BankAccountCategory> bankAccountCategories = this.entityManager
				.createNamedQuery("findAccountCategories", BankAccountCategory.class)
				.setParameter("nameList", bankAccountCategoryNames).getResultList();

		return new ArrayList<BankAccountCategory>(bankAccountCategories);
	}

	public List<Transaction> geTransactions(final Date dateFrom, final Date dateUntil, final String bankAccountName) {
		final BankAccount bankAccount = this.getBankAccount(bankAccountName);
		return this.geTransactions(dateFrom, dateUntil, bankAccount);
	}

	public List<Transaction> geTransactions(final Date dateFrom, final Date dateUntil, final BankAccount bankAccount) {
		List<Transaction> transactions;

		final TypedQuery<Transaction> query = this.entityManager
				.createNamedQuery("TransactionsBetween", Transaction.class).setParameter("bankAccount", bankAccount)
				.setParameter("dateFrom", dateFrom).setParameter("dateUntil", dateUntil);

		transactions = query.getResultList();

		return transactions;
	}

	public ArrayList<BankAccount> getBankAccounts(final BankAccountCategory bankAccountCategory) {

		final List<BankAccount> bankAccounts = this.entityManager
				.createNamedQuery("findBankaccountsWithCategory", BankAccount.class)
				.setParameter("bankAccountCategory", bankAccountCategory).getResultList();

		return new ArrayList<BankAccount>(bankAccounts);
	}

	public Category getCategory(final String categoryName) {

		final Category category = this.entityManager.find(Category.class, categoryName);

		return category;
	}

	public ArrayList<String> getCategoryNames() {
		final ArrayList<String> categoryNames = new ArrayList<>();

		final List<Category> categories = this.entityManager.createNamedQuery("allCategories", Category.class)
				.getResultList();

		for (final Category category : categories) {
			categoryNames.add(category.getName());
		}

		return categoryNames;
	}

	public void persist(final Transaction transaction) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(transaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}

	}

	public void persist(final BankAccount bankAccount) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(bankAccount);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void persist(final BankAccountCategory bankAccountCategory) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(bankAccountCategory);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void delete(final BankAccountCategory bankAccountCategory) throws RollbackException {

		try {
			final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

			if (ownTransaction) {
				this.entityManager.getTransaction().begin();
			}

			this.entityManager.remove(bankAccountCategory);

			if (ownTransaction) {
				this.entityManager.getTransaction().commit();
			}
		} catch (final RollbackException e) {
			throw e;
		}

	}

	public void delete(final BankAccount bankAccount) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.remove(bankAccount);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void delete(final Transaction transaction) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.remove(transaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void deleteBankAccountCategories(final ArrayList<String> bankAccountCategoryNames) throws RollbackException {
		try {
			final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

			if (ownTransaction) {
				this.entityManager.getTransaction().begin();
			}

			final List<BankAccountCategory> bankAccountCategories = this
					.getBankAccountCategories(bankAccountCategoryNames);
			for (final BankAccountCategory bankAccountCategory : bankAccountCategories) {
				this.delete(bankAccountCategory);
			}

			if (ownTransaction) {
				this.entityManager.getTransaction().commit();
			}
		} catch (final RollbackException e) {
			throw e;
		}

	}

	public void deleteBankAccounts(final ArrayList<String> bankAccountNames) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		final List<BankAccount> bankAccounts = this.getBankAccounts(bankAccountNames);
		for (final BankAccount bankAccount : bankAccounts) {
			this.delete(bankAccount);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void deleteTransactions(final ArrayList<Transaction> transactions) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		for (final Transaction transaction : transactions) {
			this.delete(transaction);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

}
