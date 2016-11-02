package com.dimediary.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "allBankAccounts", query = "from BankAccount") })
@Entity
@Table(name = "BANKACCOUNT")
public class BankAccount implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7788504506056118005L;

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "BANKNAME")
	private String bankName;

	@Column(name = "IBAN")
	private String iban;

	@Column(name = "BIC")
	private String bic;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne
	@JoinColumn(name = "BANKACCOUNT_CATEGORY_ID")
	private BankAccountCategory bankAccountCategory;

	public BankAccountCategory getBankAccountCategory() {
		return this.bankAccountCategory;
	}

	public void setBankAccountCategory(final BankAccountCategory bankAccountCategory) {
		this.bankAccountCategory = bankAccountCategory;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(final String bankName) {
		this.bankName = bankName;
	}

	public String getIban() {
		return this.iban;
	}

	public void setIban(final String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return this.bic;
	}

	public void setBic(final String bic) {
		this.bic = bic;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

}
