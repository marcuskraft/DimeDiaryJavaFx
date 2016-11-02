package com.dimediary.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHolder {

	private EntityManager entityManager = null;
	private EntityManagerFactory emf = null;

	private static EntityManagerHolder instance = null;

	private EntityManagerHolder() {
		this.emf = Persistence.createEntityManagerFactory("PersistenceHSQLDB");
		this.entityManager = this.emf.createEntityManager();
	}

	public static EntityManagerHolder getInstance() {
		if (EntityManagerHolder.instance == null) {
			EntityManagerHolder.instance = new EntityManagerHolder();
		}
		return EntityManagerHolder.instance;
	}

	public EntityManager getEntityManager() {
		return this.entityManager;
	}

	public void close() {
		this.entityManager.close();
		this.emf.close();
		EntityManagerHolder.instance = null;
	}

}
