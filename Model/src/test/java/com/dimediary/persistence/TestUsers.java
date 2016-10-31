package com.dimediary.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class TestUsers {

	@Test
	public void readUsers() {

		final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceHSQLDB");
		final EntityManager em = emf.createEntityManager(); // Retrieve an
															// application
															// managed entity
															// manager

		final TypedQuery<PUser> query = em.createNamedQuery("allUsers", PUser.class);
		final List<PUser> users = query.getResultList();

		for (final PUser pUser : users) {
			System.out.println(pUser.getSurname() + " " + pUser.getName());
		}

		em.close();
		emf.close(); // close at application end

	}

}
