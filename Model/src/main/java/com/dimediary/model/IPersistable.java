package com.dimediary.model;

import javax.persistence.EntityManager;

public interface IPersistable {

	public void persist(EntityManager em);

}
