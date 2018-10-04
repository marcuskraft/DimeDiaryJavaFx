package com.dimediary.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * entity class for the categories
 *
 * @author eyota
 *
 */
@NamedQueries({ @NamedQuery(name = "allCategories", query = "from Category"),
		@NamedQuery(name = "findCategories", query = "from Category c WHERE c.name IN :namesList"),
		@NamedQuery(name = Category.DELETE_ALL_CATEGORIES, query = "DELETE FROM Category") })
@Entity
@Table(name = "CATEGORY")
public class Category implements Serializable {

	public static final String DELETE_ALL_CATEGORIES = "DELETE_ALL_CATEGORIES";

	/**
	 *
	 */
	private static final long serialVersionUID = -8922036259983542096L;

	@Id
	@Column(name = "NAME")
	private String name;

	/**
	 *
	 * @return name of the category
	 */
	public String getName() {
		return this.name;
	}

	/**
	 *
	 * @param name
	 *                 name of the entity class
	 */
	public void setName(final String name) {
		this.name = name;
	}

}
