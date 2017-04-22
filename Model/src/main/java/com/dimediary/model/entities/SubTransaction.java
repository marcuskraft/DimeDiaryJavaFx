package com.dimediary.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SUB_TRANSACTIONS")
public class SubTransaction implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -3144204895636709667L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	private String name;

	private Double amount;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP", updatable = true)
	private Date timestamp;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_NAME")
	private Category category;

	private String description;

	private String producent;

	private String dealer;

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

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final Date timestamp) {
		this.timestamp = timestamp;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getProducent() {
		return this.producent;
	}

	public void setProducent(final String producent) {
		this.producent = producent;
	}

	public String getDealer() {
		return this.dealer;
	}

	public void setDealer(final String dealer) {
		this.dealer = dealer;
	}

}
