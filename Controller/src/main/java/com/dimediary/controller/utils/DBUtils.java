package com.dimediary.controller.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import com.dimediary.controller.balance.AccountBalancer;
import com.dimediary.controller.balance.AccountBalancer.BalanceAction;
import com.dimediary.model.EntityManagerHelper;
import com.dimediary.model.entities.BalanceHistory;
import com.dimediary.model.entities.BalanceHistoryPK;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.BankAccountCategory;
import com.dimediary.model.entities.Category;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;

/**
 * class to handle all the data base actions Singleton
 *
 * @author eyota
 *
 */
public class DBUtils {

	private EntityManager entityManager;

	private DBUtils() {
		this.initialize();
	}

	private static DBUtils instance = null;

	/**
	 *
	 * @return gives back the instance of DBUtils
	 */
	public static DBUtils getInstance() {
		if (DBUtils.instance == null) {
			DBUtils.instance = new DBUtils();
		}
		return DBUtils.instance;
	}

	private void initialize() {
		this.entityManager = EntityManagerHelper.getEntityManager();
	}

	/**
	 * closes the data base connection
	 */
	public void close() {
		EntityManagerHelper.closeEntityManager();
	}

	/**
	 *
	 * @return names of all bank accounts
	 */
	public ArrayList<String> getBankAccountNames() {
		final ArrayList<String> names = new ArrayList<>();

		final TypedQuery<BankAccount> query = this.entityManager.createNamedQuery("allBankAccounts", BankAccount.class);
		final List<BankAccount> bankAccounts = query.getResultList();

		for (final BankAccount bankAccount : bankAccounts) {
			names.add(bankAccount.getName());
		}

		return names;
	}

	/**
	 *
	 * @param bankAccountName
	 *            name of bank account
	 * @return bank account
	 */
	public BankAccount getBankAccount(final String bankAccountName) {

		final BankAccount bankAccount = this.entityManager.find(BankAccount.class, bankAccountName);

		return bankAccount;
	}

	/**
	 *
	 * @param bankAccountsNames
	 *            names of bank accounts
	 * @return list of bank accounts
	 */
	public ArrayList<BankAccount> getBankAccounts(final ArrayList<String> bankAccountsNames) {
		final List<BankAccount> bankAccounts = this.entityManager
				.createNamedQuery("findBankAccounts", BankAccount.class).setParameter("namesList", bankAccountsNames)
				.getResultList();
		return new ArrayList<BankAccount>(bankAccounts);
	}

	/**
	 *
	 * @param bankAccountCategory
	 *            bank account categories
	 * @return list of bank accounts which belongs to the given bank account
	 *         categories
	 */
	public ArrayList<BankAccount> getBankAccounts(final BankAccountCategory bankAccountCategory) {

		final List<BankAccount> bankAccounts = this.entityManager
				.createNamedQuery("findBankaccountsWithCategory", BankAccount.class)
				.setParameter("bankAccountCategory", bankAccountCategory).getResultList();

		return new ArrayList<BankAccount>(bankAccounts);
	}

	/**
	 *
	 * @return list of all names of the bank account categories
	 */
	public ArrayList<String> getBankAccountCategoryNames() {
		final ArrayList<String> names = new ArrayList<>();

		final List<BankAccountCategory> bankAccountCategories = this.entityManager
				.createNamedQuery("allAccountCategories", BankAccountCategory.class).getResultList();

		for (final BankAccountCategory bankAccountCategory : bankAccountCategories) {
			names.add(bankAccountCategory.getName());
		}

		return names;
	}

	/**
	 *
	 * @param bankAccountCategoryName
	 *            bank account category name
	 * @return bank account category
	 */
	public BankAccountCategory getBankAccountCategory(final String bankAccountCategoryName) {

		final BankAccountCategory bankAccountCategory = this.entityManager.find(BankAccountCategory.class,
				bankAccountCategoryName);

		return bankAccountCategory;
	}

	/**
	 *
	 * @param bankAccountCategoryNames
	 *            list of names of bank account category names
	 * @return list of bank account categories
	 */
	public ArrayList<BankAccountCategory> getBankAccountCategories(final ArrayList<String> bankAccountCategoryNames) {

		final List<BankAccountCategory> bankAccountCategories = this.entityManager
				.createNamedQuery("findAccountCategories", BankAccountCategory.class)
				.setParameter("nameList", bankAccountCategoryNames).getResultList();

		return new ArrayList<BankAccountCategory>(bankAccountCategories);
	}

	/**
	 *
	 * @param bankAccount
	 *            bank account
	 * @return list of all balance histories of the given bank account
	 */
	public ArrayList<BalanceHistory> getBalanceHistories(final BankAccount bankAccount) {
		final List<BalanceHistory> balanceHistories = this.entityManager
				.createNamedQuery("accountBalance", BalanceHistory.class).setParameter("bankAccount", bankAccount)
				.getResultList();
		return new ArrayList<BalanceHistory>(balanceHistories);

	}

	/**
	 *
	 * @param bankAccount
	 *            bank account
	 * @param date
	 *            date
	 * @return list of balance histories for this bank account after the given
	 *         date (including the given date)
	 */
	public ArrayList<BalanceHistory> getBalanceHistoriesAfterDate(final BankAccount bankAccount, final Date date) {
		final List<BalanceHistory> balanceHistories = this.entityManager
				.createNamedQuery("accountBalanceDate", BalanceHistory.class).setParameter("date", date)
				.setParameter("bankAccount", bankAccount).getResultList();
		return new ArrayList<BalanceHistory>(balanceHistories);
	}

	/**
	 *
	 * @param bankAccount
	 * @param date
	 * @return balance history of this bank account at the given date
	 */
	public BalanceHistory getBalanceHistory(final BankAccount bankAccount, final Date date) {
		final BalanceHistoryPK balanceHistoryPK = new BalanceHistoryPK(bankAccount, date);
		return this.entityManager.find(BalanceHistory.class, balanceHistoryPK);
	}

	public BalanceHistory getLastBalanceHistory(final BankAccount bankAccount) {
		try {
			return this.entityManager.createNamedQuery("lastAccountBalance", BalanceHistory.class)
					.setParameter("bankAccount", bankAccount).getSingleResult();
		} catch (final NoResultException e) {
			// TODO logging
			return null;
		}
	}

	/**
	 *
	 * @param dateFrom
	 * @param dateUntil
	 * @param bankAccountName
	 * @return list of transactions
	 */
	public List<Transaction> getTransactions(final Date dateFrom, final Date dateUntil, final String bankAccountName) {
		final BankAccount bankAccount = this.getBankAccount(bankAccountName);
		return this.getTransactions(dateFrom, dateUntil, bankAccount);
	}

	/**
	 *
	 * @param dateFrom
	 * @param dateUntil
	 * @param bankAccount
	 * @return list of transactions belonging to the given bank account between
	 *         the two dates (including both days)
	 */
	public List<Transaction> getTransactions(final Date dateFrom, final Date dateUntil, final BankAccount bankAccount) {
		List<Transaction> transactions;

		final TypedQuery<Transaction> query = this.entityManager
				.createNamedQuery("TransactionsBetween", Transaction.class).setParameter("bankAccount", bankAccount)
				.setParameter("dateFrom", dateFrom).setParameter("dateUntil", dateUntil);

		transactions = query.getResultList();

		return transactions;
	}

	/**
	 *
	 * @param bankAccount
	 * @return list of all transactions of the given bank account
	 */
	public ArrayList<Transaction> getTransactions(final BankAccount bankAccount) {
		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("allAccountTransactions", Transaction.class).setParameter("bankAccount", bankAccount)
				.getResultList();
		return new ArrayList<Transaction>(transactions);
	}

	/**
	 *
	 * @param bankAccount
	 * @param date
	 * @return list of transactions at the given date for the given bank account
	 */
	public ArrayList<Transaction> getTransactions(final BankAccount bankAccount, final Date date) {
		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("TransactionsAtDay", Transaction.class).setParameter("bankAccount", bankAccount)
				.setParameter("date", date).getResultList();
		return new ArrayList<Transaction>(transactions);
	}

	public ArrayList<Transaction> getTransactionsFromDate(final ContinuousTransaction continuousTransaction,
			final Date date) {
		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("ContinuousTransansactionFromDate", Transaction.class)
				.setParameter("continuousTransaction", continuousTransaction).setParameter("date", date)
				.getResultList();
		return new ArrayList<Transaction>(transactions);
	}

	public ArrayList<Transaction> getTransactions(final ContinuousTransaction continuousTransaction) {
		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("ContinuousTransactions", Transaction.class)
				.setParameter("continuousTransaction", continuousTransaction).getResultList();
		return new ArrayList<Transaction>(transactions);
	}

	/**
	 *
	 * @param categoryName
	 * @return category belonging to this category name
	 */
	public Category getCategory(final String categoryName) {

		final Category category = this.entityManager.find(Category.class, categoryName);

		return category;
	}

	/**
	 *
	 * @param categoryNames
	 * @return list of categories belonging to this category names
	 */
	public ArrayList<Category> getCategories(final ArrayList<String> categoryNames) {
		final List<Category> categories = this.entityManager.createNamedQuery("findCategories", Category.class)
				.setParameter("namesList", categoryNames).getResultList();
		return new ArrayList<Category>(categories);
	}

	/**
	 *
	 * @return list of alle category names
	 */
	public ArrayList<String> getCategoryNames() {
		final ArrayList<String> categoryNames = new ArrayList<>();

		final List<Category> categories = this.entityManager.createNamedQuery("allCategories", Category.class)
				.getResultList();

		for (final Category category : categories) {
			categoryNames.add(category.getName());
		}

		return categoryNames;
	}

	/**
	 *
	 * @param transaction
	 *            Transaction to persist
	 */
	public void persist(final Transaction transaction) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(transaction);

		AccountBalancer.updateBalance(transaction, AccountBalancer.BalanceAction.adding);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void persistTransactions(final ArrayList<Transaction> transactions) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		for (final Transaction transaction : transactions) {
			this.persist(transaction);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	private void persist(final ContinuousTransaction continuousTransaction) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(continuousTransaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void persistContinuousTransaction(final ContinuousTransaction continuousTransaction,
			final ArrayList<Transaction> transactions) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.persist(continuousTransaction);
		for (final Transaction transaction : transactions) {
			this.persist(transaction);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param category
	 *            Category to persist
	 */
	public void persist(final Category category) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(category);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}

	}

	/**
	 *
	 * @param bankAccount
	 *            BankAccount to persist
	 */
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

	/**
	 * BankAccountCategory to persist
	 *
	 * @param bankAccountCategory
	 */
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

	/**
	 * BalanceHistory to persist
	 *
	 * @param balanceHistory
	 */
	public void persist(final BalanceHistory balanceHistory) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(balanceHistory);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param balanceHistories
	 *            balance histories to persist
	 */
	public void persistBalanceHistories(final ArrayList<BalanceHistory> balanceHistories) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		for (final BalanceHistory balanceHistory : balanceHistories) {
			this.persist(balanceHistory);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param balanceHistory
	 *            balance history to merge
	 */
	public void merge(final BalanceHistory balanceHistory) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.merge(balanceHistory);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void merge(final Transaction transaction) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.merge(transaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void merge(final ContinuousTransaction continuousTransaction) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.merge(continuousTransaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param balanceHistories
	 *            balance histories to merge
	 */
	public void mergeBalanceHistories(final ArrayList<BalanceHistory> balanceHistories) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		for (final BalanceHistory balanceHistory : balanceHistories) {
			this.merge(balanceHistory);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param bankAccountCategory
	 *            bank account category to delete
	 * @throws RollbackException
	 */
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

	/**
	 *
	 * @param bankAccount
	 *            bank account to delete
	 */
	public void delete(final BankAccount bankAccount) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.deleteBalanceHistories(bankAccount);
		this.deleteTransactions(bankAccount);
		this.entityManager.remove(bankAccount);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param transaction
	 *            transaction to delete
	 */
	public void delete(final Transaction transaction) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		AccountBalancer.updateBalance(transaction, BalanceAction.deleting);

		this.entityManager.remove(transaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param category
	 *            category to delete
	 */
	public void delete(final Category category) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.remove(category);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param balanceHistory
	 *            balance history to delete
	 */
	public void delete(final BalanceHistory balanceHistory) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.remove(balanceHistory);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param bankAccountCategoryNames
	 *            list of bank account category names to delete
	 * @throws RollbackException
	 */
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

	/**
	 * list of bank account names to delete
	 *
	 * @param bankAccountNames
	 */
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

	/**
	 * list of transactions to delete
	 *
	 * @param transactions
	 */
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

	/**
	 *
	 * @param bankAccount
	 *            bank accounts for which all transactions will be deleted
	 */
	public void deleteTransactions(final BankAccount bankAccount) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		final List<Transaction> transactions = this.getTransactions(bankAccount);
		for (final Transaction transaction : transactions) {
			this.delete(transaction);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param categories
	 *            list of categories to delete
	 */
	public void deleteCategories(final ArrayList<Category> categories) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		for (final Category category : categories) {
			this.delete(category);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param balanceHistories
	 *            list of balance histories to delete
	 */
	public void deleteBalanceHistories(final ArrayList<BalanceHistory> balanceHistories) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		for (final BalanceHistory balanceHistory : balanceHistories) {
			this.delete(balanceHistory);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 *
	 * @param bankAccount
	 *            bank account for which all balance histories will be deleted
	 */
	public void deleteBalanceHistories(final BankAccount bankAccount) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		final ArrayList<BalanceHistory> balanceHistories = DBUtils.getInstance().getBalanceHistories(bankAccount);
		if (!balanceHistories.isEmpty()) {
			DBUtils.getInstance().deleteBalanceHistories(balanceHistories);
		}

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void deleteAllContinuousTransactions(final ContinuousTransaction continuousTransaction) {
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		final ArrayList<Transaction> transactions = this.getTransactions(continuousTransaction);
		this.deleteTransactions(transactions);
		this.entityManager.remove(continuousTransaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

}
