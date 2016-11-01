package com.dimediary.model.persistence;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TRANSACTIONS")
public class PTransaction implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6570668384679595613L;

	@Id
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AMOUNT")
	private Double amount;

	@ManyToOne
	@JoinColumn(name = "BANKACCOUNT_ID")
	private PBankAccount bankAccount;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private PUser user;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID")
	private PCategory category;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private Date date;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP")
	private Date timestamp;

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

	public PBankAccount getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(final PBankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public PUser getUser() {
		return this.user;
	}

	public void setUser(final PUser user) {
		this.user = user;
	}

	public PCategory getCategory() {
		return this.category;
	}

	public void setCategory(final PCategory category) {
		this.category = category;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final Date timestamp) {
		this.timestamp = timestamp;
	}

}
