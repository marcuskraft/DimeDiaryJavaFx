package com.dimediary.model;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelperImpl {

	private static EntityManager entityManager = null;
	private static EntityManagerFactory emf = null;

	public static EntityManager getEntityManager(final String persistenceUnit, final Map<String, String> properties) {
		if (EntityManagerHelperImpl.entityManager == null) {
			if (EntityManagerHelperImpl.emf == null) {
				if (properties == null) {
					EntityManagerHelperImpl.emf = Persistence.createEntityManagerFactory(persistenceUnit);
				} else {
					EntityManagerHelperImpl.emf = Persistence.createEntityManagerFactory(persistenceUnit, properties);
				}

			}
			EntityManagerHelperImpl.entityManager = EntityManagerHelperImpl.emf.createEntityManager();
		}
		return EntityManagerHelperImpl.entityManager;
	}

	public static EntityManager getEntityManager(final String persistenceUnit) {
		return EntityManagerHelperImpl.getEntityManager(persistenceUnit, null);
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
