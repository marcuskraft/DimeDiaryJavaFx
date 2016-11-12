package com.dimediary.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
		@NamedQuery(name = "accountBalance", query = "from BalanceHistory b WHERE b.bankAccount = :bankAccount"),
		@NamedQuery(name = "accountBalanceDate", query = "from BalanceHistory b WHERE b.bankAccount = :bankAccount AND b.date >= :date") })
@Entity
@Table(name = "BALANCE_HISTORY")
@IdClass(BalanceHistoryPK.class)
public class BalanceHistory implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -8067932338253105032L;

	@Id
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE")
	private Date date;

	@Id
	@ManyToOne
	@JoinColumn(name = "BANKACCOUNT_NAME")
	private BankAccount bankAccount;

	@Column(name = "AMOUNT")
	private Double amount;

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(final BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public void addAmount(final Double amount) {
		this.amount = this.amount + amount;
	}

}
