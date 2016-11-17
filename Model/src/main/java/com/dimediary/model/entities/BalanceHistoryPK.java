package com.dimediary.model.entities;

import java.io.Serializable;
import java.util.Date;

/**
 * primary key class for BalanceHistory
 * 
 * @author eyota
 *
 */
public class BalanceHistoryPK implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4539881778212051537L;
	private Date date;
	private BankAccount bankAccount;

	/**
	 * constructor
	 */
	public BalanceHistoryPK() {
		super();
	}

	/**
	 * constructor
	 * 
	 * @param bankAccount
	 *            bank account for which this balance key is for
	 * @param date
	 *            Date for which this balance history is for
	 */
	public BalanceHistoryPK(final BankAccount bankAccount, final Date date) {
		super();
		this.date = date;
		this.bankAccount = bankAccount;
	}

	/**
	 *
	 * @return Date for this balance history
	 */
	public Date getDate() {
		return this.date;
	}

	/**
	 *
	 * @param date
	 *            Date for this balance history
	 */
	public void setDate(final Date date) {
		this.date = date;
	}

	/**
	 *
	 * @return bank account for which this balance key is for
	 */
	public BankAccount getBankAccount() {
		return this.bankAccount;
	}

	/**
	 *
	 * @param bankAccount
	 *            bank account for which this balance key is for
	 */
	public void setBankAccount(final BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public int hashCode() {
		return 1;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		final BalanceHistoryPK balanceHistory = (BalanceHistoryPK) obj;
		if (!this.date.equals(balanceHistory.getDate())) {
			return false;
		}
		if (!this.bankAccount.getName().equals(balanceHistory.getBankAccount().getName())) {
			return false;
		}
		return true;
	}
}
