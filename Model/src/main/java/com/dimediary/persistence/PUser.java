package com.dimediary.persistence;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "allUsers", query = "from PUser") })
@Entity
@Table(name = "USERS")
public class PUser {

	public PUser() {
	}

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

}
