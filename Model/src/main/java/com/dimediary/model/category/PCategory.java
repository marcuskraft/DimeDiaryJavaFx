package com.dimediary.model.category;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY")
public class PCategory implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8922036259983542096L;

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

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

}
