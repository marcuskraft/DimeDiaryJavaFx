package com.dimediary.model.interfaces;

import javax.persistence.EntityManager;

public interface IPersistable {

	public void persist(EntityManager em);

}
