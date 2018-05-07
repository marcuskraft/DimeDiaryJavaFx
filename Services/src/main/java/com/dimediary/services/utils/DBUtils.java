package com.dimediary.services.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.dimediary.model.EntityManagerHelper;
import com.dimediary.model.entities.BalanceHistory;
import com.dimediary.model.entities.BalanceHistoryPK;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.BankAccountCategory;
import com.dimediary.model.entities.Category;
import com.dimediary.model.entities.ContinuousTransaction;
import com.dimediary.model.entities.Transaction;
import com.dimediary.services.AccountBalanceService;
import com.dimediary.services.AccountBalanceService.BalanceAction;

/**
 * class to handle all the data base actions Singleton
 *
 * @author eyota
 *
 */
public class DBUtils {

	private final static Logger log = LogManager.getLogger(DBUtils.class);

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
		DBUtils.log.info("initialize");
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
	public List<String> getBankAccountNames() {
		DBUtils.log.info("getBankAccountNames");
		final List<String> names = new ArrayList<>();

		final List<BankAccount> bankAccounts = this.entityManager.createNamedQuery("allBankAccounts", BankAccount.class)
				.getResultList();

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
		if (bankAccountName == null) {
			return null;
		}
		DBUtils.log.info("getBankAccount: " + bankAccountName);
		final BankAccount bankAccount = this.entityManager.find(BankAccount.class, bankAccountName);

		return bankAccount;
	}

	/**
	 *
	 * @param bankAccountsNames
	 *            names of bank accounts
	 * @return list of bank accounts
	 */
	public List<BankAccount> getBankAccounts(final List<String> bankAccountsNames) {

		if (bankAccountsNames.isEmpty()) {
			return null;
		}

		for (final String string : bankAccountsNames) {
			DBUtils.log.info("getBankAccounts: " + string);
		}

		final List<BankAccount> bankAccounts = this.entityManager
				.createNamedQuery(BankAccount.FIND_BANK_ACCOUNTS, BankAccount.class)
				.setParameter("namesList", bankAccountsNames).getResultList();
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
		if (bankAccountCategory == null) {
			return null;
		}
		DBUtils.log.info("getBankAccounts by Category: " + bankAccountCategory);

		final List<BankAccount> bankAccounts = this.entityManager
				.createNamedQuery(BankAccount.FIND_BANKACCOUNTS_WITH_CATEGORY, BankAccount.class)
				.setParameter("bankAccountCategory", bankAccountCategory).getResultList();

		return new ArrayList<BankAccount>(bankAccounts);
	}

	/**
	 *
	 * @return list of all names of the bank account categories
	 */
	public ArrayList<String> getBankAccountCategoryNames() {
		DBUtils.log.info("getBankAccountCategoryNames");
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
		if (bankAccountCategoryName == null) {
			return null;
		}

		DBUtils.log.info("getBankAccountCategory: " + bankAccountCategoryName);
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
		if (bankAccountCategoryNames.isEmpty()) {
			return null;
		}

		for (final String string : bankAccountCategoryNames) {
			DBUtils.log.info("getBankAccountCategory: " + string);
		}

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
		if (bankAccount == null) {
			return null;
		}
		DBUtils.log.info("getBalanceHistories for bank account: " + bankAccount.getName());
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
	 * @return list of balance histories for this bank account after the given date
	 *         (including the given date)
	 */
	public ArrayList<BalanceHistory> getBalanceHistoriesAfterDate(final BankAccount bankAccount, final LocalDate date) {
		if (bankAccount == null || date == null) {
			return null;
		}
		DBUtils.log.info("getBalanceHistoriesAfterDate for bank account: " + bankAccount.getName() + " and after date: "
				+ date.toString());
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
	public BalanceHistory getBalanceHistory(final BankAccount bankAccount, final LocalDate date) {
		if (bankAccount == null || date == null) {
			return null;
		}
		DBUtils.log.info(
				"getBalanceHistory for bank account: " + bankAccount.getName() + " and on date: " + date.toString());
		final BalanceHistoryPK balanceHistoryPK = new BalanceHistoryPK(bankAccount, date);
		return this.entityManager.find(BalanceHistory.class, balanceHistoryPK);
	}

	public BalanceHistory getLastBalanceHistory(final BankAccount bankAccount) {
		if (bankAccount == null) {
			return null;
		}

		DBUtils.log.info("getLastBalanceHistory for bank account: " + bankAccount.getName());
		try {
			return this.entityManager.createNamedQuery("lastAccountBalance", BalanceHistory.class)
					.setParameter("bankAccount", bankAccount).getSingleResult();
		} catch (final NoResultException e) {
			DBUtils.log.warn("no balance history in database for the bank account: " + bankAccount.getName(), e);
			return null;
		}
	}

	public Transaction getTransaction(final Integer id) {
		if (id == null) {
			return null;
		}

		DBUtils.log.info("getTransaction: " + id);
		return this.entityManager.find(Transaction.class, id);
	}

	/**
	 *
	 * @param dateFrom
	 * @param dateUntil
	 * @param bankAccountName
	 * @return list of transactions
	 */
	public List<Transaction> getTransactions(final LocalDate dateFrom, final LocalDate dateUntil,
			final String bankAccountName) {
		if (dateFrom == null || dateUntil == null || bankAccountName == null) {
			return null;
		}

		final BankAccount bankAccount = this.getBankAccount(bankAccountName);
		return this.getTransactions(dateFrom, dateUntil, bankAccount);
	}

	/**
	 *
	 * @param dateFrom
	 * @param dateUntil
	 * @param bankAccount
	 * @return list of transactions belonging to the given bank account between the
	 *         two dates (including both days)
	 */
	public List<Transaction> getTransactions(final LocalDate dateFrom, final LocalDate dateUntil,
			final BankAccount bankAccount) {
		if (dateFrom == null || dateUntil == null || bankAccount == null) {
			return null;
		}

		DBUtils.log.info("getTransactions from date: " + dateFrom.toString() + " until date: " + dateUntil.toString()
				+ " for bank account: " + bankAccount.getName());
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
		if (bankAccount == null) {
			return null;
		}

		DBUtils.log.info("getTransactions for bank account: " + bankAccount.getName());
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
	public ArrayList<Transaction> getTransactions(final BankAccount bankAccount, final LocalDate date) {
		if (bankAccount == null || date == null) {
			return null;
		}

		DBUtils.log.info("getTransactions for bank account: " + bankAccount.getName() + " at date: " + date.toString());
		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("TransactionsAtDay", Transaction.class).setParameter("bankAccount", bankAccount)
				.setParameter("date", date).getResultList();
		return new ArrayList<Transaction>(transactions);
	}

	/**
	 *
	 * @param continuousTransaction
	 * @param date
	 * @return list of transactions belonging to this continuous transaction after
	 *         the given date (inclusive)
	 */
	public List<Transaction> getTransactionsFromDate(final ContinuousTransaction continuousTransaction,
			final LocalDate date) {
		if (continuousTransaction == null || date == null) {
			return null;
		}

		DBUtils.log.info("getTransactionsFromDate for continuous transaction: " + continuousTransaction.getName() + " ("
				+ continuousTransaction.getId() + ") " + " at date: " + date.toString());

		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("ContinuousTransansactionFromDate", Transaction.class)
				.setParameter("continuousTransaction", continuousTransaction).setParameter("date", date)
				.getResultList();
		return transactions;
	}

	/**
	 *
	 * @param continuousTransaction
	 * @return list of all transactions belonging to the given continuous
	 *         transaction
	 */
	public ArrayList<Transaction> getTransactions(final ContinuousTransaction continuousTransaction) {
		if (continuousTransaction == null) {
			return null;
		}
		DBUtils.log.info("getTransactions for continuous transaction: " + continuousTransaction.getName() + " ("
				+ continuousTransaction.getId() + ") ");

		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("ContinuousTransactions", Transaction.class)
				.setParameter("continuousTransaction", continuousTransaction).getResultList();
		return new ArrayList<Transaction>(transactions);
	}

	/**
	 *
	 * @param dateFrom
	 * @param dateUntil
	 * @return all transactions in the given date range (both inclusive) with no
	 *         bank account
	 */
	public ArrayList<Transaction> getTransactionsWithoutAccount(final LocalDate dateFrom, final LocalDate dateUntil) {
		if (dateFrom == null || dateUntil == null) {
			return null;
		}

		DBUtils.log.info("getTransactionsWithoutAccount from date: " + dateFrom.toString() + " until date: "
				+ dateUntil.toString());
		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("TransactionsWithoutAccountBetween", Transaction.class)
				.setParameter("dateFrom", dateFrom).setParameter("dateUntil", dateUntil).getResultList();
		return new ArrayList<Transaction>(transactions);
	}

	/**
	 *
	 * @param date
	 * @return all transaction on the given date without a bank account
	 */
	public ArrayList<Transaction> getTrandactionsWithoutAccount(final LocalDate date) {
		if (date == null) {
			return null;
		}

		DBUtils.log.info("getTransactionsWithoutAccount at date: " + date.toString());
		final List<Transaction> transactions = this.entityManager
				.createNamedQuery("TransactionsWithoutAccount", Transaction.class).setParameter("date", date)
				.getResultList();
		return new ArrayList<Transaction>(transactions);
	}

	/**
	 *
	 * @param bankAccount
	 * @return all ContinuousTransactions belonging to this account
	 */
	public List<ContinuousTransaction> getContinuousTransactions(final BankAccount bankAccount) {
		if (bankAccount == null) {
			return null;
		}

		DBUtils.log.info("geContinuousTransactions for: " + bankAccount.getName());
		return this.entityManager.createNamedQuery(ContinuousTransaction.CONTINUOUS_TRANSACTION_FOR_BANK_ACCOUNT,
				ContinuousTransaction.class).setParameter("bankAccount", bankAccount).getResultList();
	}

	public LocalDate getDateOfLastTransaction(final ContinuousTransaction continuousTransaction) {
		if (continuousTransaction == null) {
			return null;
		}
		this.entityManager.merge(continuousTransaction);
		DBUtils.log.info("getDateOfLastTransaction for: " + continuousTransaction.getName());
		return this.entityManager
				.createNamedQuery(Transaction.DATE_OF_LAST_TRANSACTION_OF_CONTINUOUS_TRANSACTION, LocalDate.class)
				.setParameter("continuousTransaction", continuousTransaction).getSingleResult();
	}

	/**
	 *
	 * @param categoryName
	 * @return category belonging to this category name
	 */
	public Category getCategory(final String categoryName) {
		if (categoryName == null) {
			return null;
		}

		DBUtils.log.info("getCategory: " + categoryName);
		final Category category = this.entityManager.find(Category.class, categoryName);

		return category;
	}

	/**
	 *
	 * @param categoryNames
	 * @return list of categories belonging to this category names
	 */
	public ArrayList<Category> getCategories(final ArrayList<String> categoryNames) {
		if (categoryNames == null || categoryNames.isEmpty()) {
			return null;
		}

		for (final String string : categoryNames) {
			DBUtils.log.info("getCategories: " + string);
		}

		final List<Category> categories = this.entityManager.createNamedQuery("findCategories", Category.class)
				.setParameter("namesList", categoryNames).getResultList();
		return new ArrayList<Category>(categories);
	}

	/**
	 *
	 * @return list of all category names
	 */
	public ArrayList<String> getCategoryNames() {
		DBUtils.log.info("getCategoryNames");
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
		if (transaction == null) {
			return;
		}
		DBUtils.log.info("persist transaction: " + transaction.getId());
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(transaction);

		AccountBalanceService.updateBalance(transaction, AccountBalanceService.BalanceAction.adding);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 * persists the given list of transactions
	 *
	 * @param transactions
	 */
	public void persistTransactions(final List<Transaction> transactions) {
		if (transactions == null || transactions.isEmpty()) {
			return;
		}
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

	/**
	 * persists the given continuous transaction
	 *
	 * @param continuousTransaction
	 */
	private void persist(final ContinuousTransaction continuousTransaction) {
		if (continuousTransaction == null) {
			return;
		}
		DBUtils.log.info("persist ContinuousTransaction: " + continuousTransaction.getId());
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.persist(continuousTransaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	/**
	 * persists the given continuous transaction and a list of transactions
	 *
	 * @param continuousTransaction
	 * @param transactions
	 */
	public void persistContinuousTransaction(final ContinuousTransaction continuousTransaction,
			final List<Transaction> transactions) {
		if (continuousTransaction == null || transactions == null || transactions.isEmpty()) {
			return;
		}
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
		if (category == null) {
			return;
		}
		DBUtils.log.info("persist Category: " + category.getName());
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
		if (bankAccount == null) {
			return;
		}
		DBUtils.log.info("persist BankAccount: " + bankAccount.getName());
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
		if (bankAccountCategory == null) {
			return;
		}
		DBUtils.log.info("persist BankAccountCategory: " + bankAccountCategory.getName());
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
		if (balanceHistory == null) {
			return;
		}
		DBUtils.log.info("persist BalanceHistory for bank account: " + balanceHistory.getBankAccount() + " and date: "
				+ balanceHistory.getDate().toString());
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
	public void persistBalanceHistories(final List<BalanceHistory> balanceHistories) {
		if (balanceHistories == null || balanceHistories.isEmpty()) {
			return;
		}
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
		if (balanceHistory == null) {
			return;
		}
		DBUtils.log.info("merge BalanceHistory for bank account: " + balanceHistory.getBankAccount() + " and date: "
				+ balanceHistory.getDate().toString());
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.merge(balanceHistory);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void merge(final ContinuousTransaction continuousTransaction) {
		if (continuousTransaction == null) {
			return;
		}
		DBUtils.log.info("merge ContinuousTransaction: " + continuousTransaction.getId());
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		this.entityManager.merge(continuousTransaction);

		if (ownTransaction) {
			this.entityManager.getTransaction().commit();
		}
	}

	public void merge(final List<Transaction> transactions) {
		if (transactions == null) {
			return;
		}
		DBUtils.log.info("merge Transactions");
		final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;
		if (ownTransaction) {
			this.entityManager.getTransaction().begin();
		}

		for (final Transaction transaction : transactions) {
			this.entityManager.merge(transaction);
		}

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
		if (balanceHistories == null || balanceHistories.isEmpty()) {
			return;
		}
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
		if (bankAccountCategory == null) {
			return;
		}
		try {
			DBUtils.log.info("delete BankAccountCategory: " + bankAccountCategory.getName());
			final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

			if (ownTransaction) {
				this.entityManager.getTransaction().begin();
			}

			this.entityManager.remove(bankAccountCategory);

			if (ownTransaction) {
				this.entityManager.getTransaction().commit();
			}
		} catch (final RollbackException e) {
			throw new RollbackException("can't delete bank account category: " + bankAccountCategory.getName(), e);
		}

	}

	/**
	 *
	 * @param bankAccount
	 *            bank account to delete
	 */
	public void delete(final BankAccount bankAccount) throws RollbackException {
		if (bankAccount == null) {
			return;
		}
		try {
			DBUtils.log.info("delete BankAccount: " + bankAccount.getName());
			final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

			if (ownTransaction) {
				this.entityManager.getTransaction().begin();
			}
			this.deleteBalanceHistories(bankAccount);
			this.entityManager.remove(bankAccount);

			if (ownTransaction) {
				this.entityManager.getTransaction().commit();
			}
		} catch (final RollbackException e) {
			throw new RollbackException("can't delete bank account: " + bankAccount.getName(), e);
		}
	}

	/**
	 *
	 * @param transaction
	 *            transaction to delete
	 */
	public void delete(final Transaction transaction) {
		if (transaction == null) {
			return;
		}
		try {
			DBUtils.log.info("delete Transaction: " + transaction.getId());
			final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

			if (ownTransaction) {
				this.entityManager.getTransaction().begin();
			}

			AccountBalanceService.updateBalance(transaction, BalanceAction.deleting);
			if (!this.entityManager.contains(transaction)) {
				final Transaction transactionLocal = this.entityManager.merge(transaction);
				this.entityManager.remove(transactionLocal);
			} else {
				this.entityManager.remove(transaction);
			}

			if (ownTransaction) {
				this.entityManager.getTransaction().commit();
			}
		} catch (final Exception e) {
			DBUtils.log.error("can't delete transaction: " + transaction.getId(), e);
			throw e;
		}
	}

	/**
	 *
	 * @param category
	 *            category to delete
	 */
	public void delete(final Category category) {
		if (category == null) {
			return;
		}
		try {
			DBUtils.log.info("delete Category: " + category.getName());
			final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

			if (ownTransaction) {
				this.entityManager.getTransaction().begin();
			}

			this.entityManager.remove(category);

			if (ownTransaction) {
				this.entityManager.getTransaction().commit();
			}
		} catch (final Exception e) {
			DBUtils.log.error("can't delete category: " + category.getName(), e);
			throw e;
		}
	}

	/**
	 *
	 * @param balanceHistory
	 *            balance history to delete
	 */
	public void delete(final BalanceHistory balanceHistory) {
		if (balanceHistory == null) {
			return;
		}
		try {
			DBUtils.log.info("delete BalanceHistory for bank account: " + balanceHistory.getBankAccount().getBankName()
					+ " and date: " + balanceHistory.getDate().toString());
			final boolean ownTransaction = this.entityManager.getTransaction().isActive() ? false : true;

			if (ownTransaction) {
				this.entityManager.getTransaction().begin();
			}

			this.entityManager.remove(balanceHistory);

			if (ownTransaction) {
				this.entityManager.getTransaction().commit();
			}
		} catch (final Exception e) {
			DBUtils.log.error(
					"can't delete BalanceHistory for bank account: " + balanceHistory.getBankAccount().getBankName()
							+ " and date: " + balanceHistory.getDate().toString(),
					e);
			throw e;
		}
	}

	/**
	 *
	 * @param bankAccountCategoryNames
	 *            list of bank account category names to delete
	 * @throws RollbackException
	 */
	public void deleteBankAccountCategories(final ArrayList<String> bankAccountCategoryNames) throws RollbackException {
		if (bankAccountCategoryNames == null || bankAccountCategoryNames.isEmpty()) {
			return;
		}
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
	public void deleteBankAccounts(final ArrayList<String> bankAccountNames) throws RollbackException {
		if (bankAccountNames == null || bankAccountNames.isEmpty()) {
			return;
		}
		try {
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
		} catch (final RollbackException e) {
			throw e;
		}
	}

	/**
	 * list of transactions to delete
	 *
	 * @param transactions
	 */
	public void deleteTransactions(final List<Transaction> transactions) {
		if (transactions == null || transactions.isEmpty()) {
			return;
		}
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
		if (bankAccount == null) {
			return;
		}
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
		if (categories == null || categories.isEmpty()) {
			return;
		}
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
		if (balanceHistories == null || balanceHistories.isEmpty()) {
			return;
		}
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
		if (bankAccount == null) {
			return;
		}
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
		if (continuousTransaction == null) {
			return;
		}
		DBUtils.log.info("deleteAllContinuousTransactions : " + continuousTransaction.getId());
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
