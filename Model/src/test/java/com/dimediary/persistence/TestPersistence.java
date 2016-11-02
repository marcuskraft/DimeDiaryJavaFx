package com.dimediary.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dimediary.model.EntityManagerHolder;
import com.dimediary.model.entities.BankAccount;
import com.dimediary.model.entities.Transaction;
import com.dimediary.model.entities.User;

public class TestPersistence {

	private EntityManager em;
	private EntityManagerHolder emH;
	// private EntityManagerFactory emf;

	@Before
	public void Initiate() {
		// this.emf =
		// Persistence.createEntityManagerFactory("PersistenceHSQLDB");
		this.emH = EntityManagerHolder.getInstance();
		this.em = this.emH.getEntityManager(); // this.emf.createEntityManager();
	}

	@After
	public void Close() {
		this.emH.close();
		// this.em.close();
		// this.emf.close();
	}

	public void readUsers(final EntityManager em, final User user) {

		final TypedQuery<User> query = em.createNamedQuery("allUsers", User.class);
		final List<User> users = query.getResultList();

		Assert.assertTrue("User not persisted!", users.contains(user));

	}

	@Test
	public void addUser() {

		final User user = new User("Vogel", "Hans");

		this.em.getTransaction().begin();
		this.em.persist(user);
		this.em.getTransaction().commit();

		this.readUsers(this.em, user);

		this.em.getTransaction().begin();
		this.em.remove(user);
		this.em.getTransaction().commit();

	}

	@Test
	public void readTransaction() {

		final TypedQuery<Transaction> query = this.em.createNamedQuery("allTransactions", Transaction.class);
		final List<Transaction> transactions = query.getResultList();

		Assert.assertTrue("Table transactions is empty!", !transactions.isEmpty());

		for (final Transaction transaction : transactions) {
			System.out.println(transaction.getName());
			System.out.println(transaction.getBankAccount().getBic());
			System.out.println(transaction.getBankAccount().getUser().getSurname());
			System.out.println(transaction.getCategory().getName());
			System.out.println(transaction.getTimestamp());
		}

	}

	@Test
	public void readBankAccounts() {

		final TypedQuery<BankAccount> query = this.em.createNamedQuery("allBankAccounts", BankAccount.class);
		final List<BankAccount> bankAccounts = query.getResultList();

		for (final BankAccount bankAccount : bankAccounts) {
			System.out.println(bankAccount.getBankName());
			System.out.println(bankAccount.getIban());
		}

	}

}
