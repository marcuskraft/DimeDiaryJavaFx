package com.dimediary.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

@Entity
@Table(name = "CONTINUOUS_TRANSACTION")
@NamedQueries({
		@NamedQuery(name = ContinuousTransaction.CONTINUOUS_TRANSACTION_FOR_BANK_ACCOUNT, query = "from ContinuousTransaction WHERE bankAccount = :bankAccount"),
		@NamedQuery(name = ContinuousTransaction.DELETE_ALL_CONTINUOUS_TRANSACTIONS, query = "DELETE FROM ContinuousTransaction") })
public class ContinuousTransaction implements Serializable, Comparable<ContinuousTransaction> {

	public static final String DELETE_ALL_CONTINUOUS_TRANSACTIONS = "DELETE_ALL_CONTINUOUS_TRANSACTIONS";

	public static final String CONTINUOUS_TRANSACTION_FOR_BANK_ACCOUNT = "continuousTransactionForBankAccount";

	/**
	 *
	 */
	private static final long serialVersionUID = 1064986628363384286L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "TIMESTAMP", updatable = true)
	private LocalDateTime timestamp;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "DATE_BEGINN")
	private LocalDate dateBeginn;

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
		this.timestamp = LocalDateTime.now();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final LocalDateTime timestamp) {
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

	public LocalDate getDateBeginn() {
		return this.dateBeginn;
	}

	public void setDateBeginn(final LocalDate dateBeginn) {
		this.dateBeginn = dateBeginn;
	}

	public String getRecurrenceRule() {
		return this.recurrenceRule;
	}

	public void setRecurrenceRule(final String recurrenceRule) {
		this.recurrenceRule = recurrenceRule;
	}

	public Transaction createTransaction(final LocalDate date) {
		final Transaction transaction = new Transaction();
		transaction.setAmount(this.getAmount());
		transaction.setBankAccount(this.getBankAccount());
		transaction.setCategory(this.getCategory());
		transaction.setContinuousTransaction(this);
		transaction.setDate(date);
		transaction.setName(this.getName());
		return transaction;
	}

	public ContinuousTransaction getCopy() {
		final ContinuousTransaction continuousTransactionCopy = new ContinuousTransaction();

		continuousTransactionCopy.setAmount(this.getAmount());
		continuousTransactionCopy.setBankAccount(this.getBankAccount());
		continuousTransactionCopy.setCategory(this.getCategory());
		continuousTransactionCopy.setDateBeginn(this.getDateBeginn());
		continuousTransactionCopy.setName(this.getName());
		continuousTransactionCopy.setRecurrenceRule(this.getRecurrenceRule());
		continuousTransactionCopy.setUser(this.getUser());

		return continuousTransactionCopy;
	}

	@Override
	public int compareTo(final ContinuousTransaction other) {
		if (other == null) {
			return -1;
		}
		return this.dateBeginn.compareTo(other.getDateBeginn());
	}

}
