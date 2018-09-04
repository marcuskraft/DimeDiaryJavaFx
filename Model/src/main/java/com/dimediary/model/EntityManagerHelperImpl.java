package com.dimediary.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelperImpl {

	private static EntityManager entityManager = null;
	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager(final String persistenceUnit) {
		if (EntityManagerHelperImpl.entityManager == null) {
			if (EntityManagerHelperImpl.emf == null) {
				EntityManagerHelperImpl.emf = Persistence.createEntityManagerFactory(persistenceUnit);
			}
			EntityManagerHelperImpl.entityManager = EntityManagerHelperImpl.emf.createEntityManager();
		}
		return EntityManagerHelperImpl.entityManager;
	}

	public static void closeEntityManager() {
		if (EntityManagerHelperImpl.entityManager != null) {
			if (EntityManagerHelperImpl.entityManager.getTransaction().isActive()) {
				EntityManagerHelperImpl.entityManager.getTransaction().commit();
			}
			EntityManagerHelperImpl.entityManager.close();
			EntityManagerHelperImpl.entityManager = null;
		}
		if (EntityManagerHelperImpl.emf != null) {
			EntityManagerHelperImpl.emf.close();
			EntityManagerHelperImpl.emf = null;
		}

	}

}
