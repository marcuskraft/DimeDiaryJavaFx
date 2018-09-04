package com.dimediary.model.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.dimediary.model.utils.AmountUtils;

@NamedQueries({ @NamedQuery(name = "allTransactions", query = "from Transaction"),
		@NamedQuery(name = "TransactionsBetween", query = "from Transaction t WHERE t.bankAccount = :bankAccount"
				+ " AND t.date BETWEEN :dateFrom AND :dateUntil ORDER BY t.date"),
		@NamedQuery(name = "allAccountTransactions", query = "from Transaction t WHERE t.bankAccount = :bankAccount"),
		@NamedQuery(name = "TransactionsAtDay", query = "from Transaction t WHERE t.bankAccount = :bankAccount AND t.date = :date order by t.timestamp"),
		@NamedQuery(name = "ContinuousTransansactionFromDate", query = "from Transaction t WHERE t.continuousTransaction = :continuousTransaction "
				+ "AND t.date >= :date"),
		@NamedQuery(name = "ContinuousTransactions", query = "from Transaction t WHERE t.continuousTransaction = :continuousTransaction"),
		@NamedQuery(name = "TransactionsWithoutAccountBetween", query = "from Transaction t where t.bankAccount is null and t.date BETWEEN :dateFrom"
				+ " AND :dateUntil ORDER BY t.date"),
		@NamedQuery(name = "TransactionsWithoutAccount", query = "from Transaction t where t.bankAccount is null and t.date = :date"),
		@NamedQuery(name = Transaction.DATE_OF_LAST_TRANSACTION_OF_CONTINUOUS_TRANSACTION, query = "SELECT MAX(date) from Transaction t WHERE t.continuousTransaction = :continuousTransaction") })
@Entity
@Table(name = "TRANSACTIONS", indexes = { @Index(columnList = "date", name = "transaction_date_hidx") })
public class Transaction implements Serializable {

	public static final String DATE_OF_LAST_TRANSACTION_OF_CONTINUOUS_TRANSACTION = "dateOfLastTransactionOfContinuousTransaction";

	/**
	 *
	 */
	private static final long serialVersionUID = -6570668384679595613L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "AMOUNT")
	private Double amount;

	@ManyToOne
	@JoinColumn(name = "BANKACCOUNT_NAME")
	private BankAccount bankAccount;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "CATEGORY_NAME")
	private Category category;

	@Column(name = "DATE")
	private LocalDate date;

	@Column(name = "TIMESTAMP", updatable = true)
	private LocalDateTime timestamp;

	@ManyToOne
	private ContinuousTransaction continuousTransaction;

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

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Double getAmount() {
		return AmountUtils.round(this.amount);
	}

	public void setAmount(final Double amount) {
		this.amount = AmountUtils.round(amount);
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

	public LocalDate getDate() {
		return this.date;
	}

	public void setDate(final LocalDate date) {
		this.date = date;
	}

	public LocalDateTime getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public Transaction getCopy() {
		final Transaction transaction = new Transaction();
		transaction.setAmount(this.getAmount());
		transaction.setBankAccount(this.getBankAccount());
		transaction.setCategory(this.getCategory());
		transaction.setContinuousTransaction(this.getContinuousTransaction());
		transaction.setDate(this.getDate());
		transaction.setName(this.getName());
		transaction.setUser(this.getUser());
		return transaction;
	}

	public ContinuousTransaction getContinuousTransaction() {
		return this.continuousTransaction;
	}

	public void setContinuousTransaction(final ContinuousTransaction continuousTransaction) {
		this.continuousTransaction = continuousTransaction;
	}

}
