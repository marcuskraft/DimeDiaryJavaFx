package com.dimediary.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "allUsers", query = "from User"),
		@NamedQuery(name = User.DELETE_ALL_USERS, query = "DELETE from User") })
@Entity
@Table(name = "USERS")
public class User implements Serializable {

	public static final String DELETE_ALL_USERS = "DELETE_ALL_USERS";

	/**
	 *
	 */
	private static final long serialVersionUID = -5847904277566539271L;

	public User() {
	}

	public User(final String name, final String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
