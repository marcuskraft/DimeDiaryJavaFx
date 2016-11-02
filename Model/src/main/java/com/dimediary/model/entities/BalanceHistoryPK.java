package com.dimediary.model.entities;

import java.io.Serializable;
import java.util.Date;

public class BalanceHistoryPK implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -4539881778212051537L;
	private Date date;
	private BankAccount bankAccount;

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
