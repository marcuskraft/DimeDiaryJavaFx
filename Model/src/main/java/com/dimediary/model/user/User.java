package com.dimediary.model.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.dimediary.model.persistence.PUser;

public class User implements IUser {

	private final PUser pUser;

	public User(final String firstName, final String lastName) {
		this.pUser = new PUser(lastName, firstName);
	}

	@Override
	public String getLastName() {
		return this.pUser.getName();
	}

	public void setLastName(final String lastName) {
		this.pUser.setName(lastName);
	}

	@Override
	public String getFirstName() {
		return this.pUser.getSurname();
	}

	public void setFirstName(final String firstName) {
		this.pUser.setSurname(firstName);
	}

	@Override
	public void persist(final EntityManager em) {
		try {
			em.persist(this.pUser);
		} catch (final Exception e) {
			throw new PersistenceException(e);
		}
	}

}
