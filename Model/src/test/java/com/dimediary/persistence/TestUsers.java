package com.dimediary.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Test;

public class TestUsers {

	public void readUsers(final EntityManager em, final PUser user) {

		final TypedQuery<PUser> query = em.createNamedQuery("allUsers", PUser.class);
		final List<PUser> users = query.getResultList();

		Assert.assertTrue("User not persisted!", users.contains(user));

	}

	@Test
	public void addUser() {

		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceHSQLDB");
		final EntityManager em = emf.createEntityManager(); // Retrieve an
															// application
															// managed entity
															// manager

		final PUser user = new PUser("Vogel", "Hans");

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();

		this.readUsers(em, user);

		em.getTransaction().begin();
		em.remove(user);
		em.getTransaction().commit();

		em.close();
		emf.close(); // close at application end
	}

}
