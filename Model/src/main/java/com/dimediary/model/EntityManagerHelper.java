package com.dimediary.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

	private static EntityManager entityManager = null;
	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager() {
		if (EntityManagerHelper.entityManager == null) {
			if (EntityManagerHelper.emf == null) {
				EntityManagerHelper.emf = Persistence.createEntityManagerFactory("PersistenceHSQLDB");
			}
			EntityManagerHelper.entityManager = EntityManagerHelper.emf.createEntityManager();
		}
		return EntityManagerHelper.entityManager;
	}

	public static void closeEntityManager() {
		if (EntityManagerHelper.entityManager != null) {
			EntityManagerHelper.entityManager.close();
			EntityManagerHelper.entityManager = null;
		}
		if (EntityManagerHelper.emf != null) {
			EntityManagerHelper.emf.close();
			EntityManagerHelper.emf = null;
		}

	}

}
