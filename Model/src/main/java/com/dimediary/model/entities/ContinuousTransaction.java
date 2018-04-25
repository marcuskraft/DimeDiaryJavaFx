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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONTINUOUS_TRANSACTION")
@NamedQueries({
		@NamedQuery(name = ContinuousTransaction.CONTINUOUS_TRANSACTION_FOR_BANK_ACCOUNT, query = "from ContinuousTransaction WHERE bankAccount = :bankAccount") })
public class ContinuousTransaction implements Serializable {

	public static final String CONTINUOUS_TRANSACTION_FOR_BANK_ACCOUNT = "continuousTransactionForBankAccount";

	/**
	 *
	 */
	private static final long serialVersionUID = 1064986628363384286L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP", updatable = true)
	private Date timestamp;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AMOUNT")
	private Double amount;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_BEGINN")
	private Date dateBeginn;

	@ManyToOne
	@JoinColumn(name = "BANKACCOUNT_NAME")
	private BankAccount bankAccount;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_NAME")
	private Category category;

	private String recurrenceRule;

	@PrePersist
	private void setTimestamp() {
		this.timestamp = new Date();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final Date timestamp) {
		this.timestamp = timestamp;
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

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(final BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public Date getDateBeginn() {
		return this.dateBeginn;
	}

	public void setDateBeginn(final Date dateBeginn) {
		this.dateBeginn = dateBeginn;
	}

	public String getRecurrenceRule() {
		return this.recurrenceRule;
	}

	public void setRecurrenceRule(final String recurrenceRule) {
		this.recurrenceRule = recurrenceRule;
	}

	public Transaction createTransaction(Date date) {
		final Transaction transaction = new Transaction();
		transaction.setAmount(this.getAmount());
		transaction.setBankAccount(this.getBankAccount());
		transaction.setCategory(this.getCategory());
		transaction.setContinuousTransaction(this);
		transaction.setDate(date);
		transaction.setName(this.getName());
		return transaction;
	}

}
