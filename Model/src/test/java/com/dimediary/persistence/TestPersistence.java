package com.dimediary.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dimediary.model.transaction.PTransaction;
import com.dimediary.model.user.PUser;

public class TestPersistence {

	private EntityManager em;
	private EntityManagerFactory emf;

	@Before
	public void Initiate() {
		this.emf = Persistence.createEntityManagerFactory("PersistenceHSQLDB");
		this.em = this.emf.createEntityManager();
	}

	@After
	public void Close() {
		this.em.close();
		this.emf.close();
	}

	public void readUsers(final EntityManager em, final PUser user) {

		final TypedQuery<PUser> query = em.createNamedQuery("allUsers", PUser.class);
		final List<PUser> users = query.getResultList();

		Assert.assertTrue("User not persisted!", users.contains(user));

	}

	@Test
	public void addUser() {

		final PUser user = new PUser("Vogel", "Hans");

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

		final PTransaction transaction = this.em.find(PTransaction.class, 0);

		System.out.println(transaction.getName());
		System.out.println(transaction.getBankAccount().getBic());
		System.out.println(transaction.getBankAccount().getUser().getSurname());
		System.out.println(transaction.getCategory().getName());
		System.out.println(transaction.getTimestamp());

	}

}
