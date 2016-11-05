package com.dimediary.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "allCategories", query = "from Category") })
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8922036259983542096L;

	@Id
	@Column(name = "NAME")
	private String name;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

}
