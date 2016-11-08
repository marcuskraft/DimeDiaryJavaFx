package com.dimediary.model.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({ @NamedQuery(name = "allBankAccounts", query = "from BankAccount"),
		@NamedQuery(name = "findBankaccountsWithCategory", query = "from BankAccount b WHERE bankAccountCategory = :bankAccountCategory"),
		@NamedQuery(name = "findBankAccounts", query = "from BankAccount b WHERE b.name IN :namesList") })
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
	@JoinColumn(name = "BANKACCOUNT_CATEGORY_NAME")
	private BankAccountCategory bankAccountCategory;

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_STARTBUDGET")
	private Date dateStartBudget;

	@Column(name = "STARTBUDGET")
	private Double startBudget;

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

	public Date getDateStartBudget() {
		return this.dateStartBudget;
	}

	public void setDateStartBudget(final Date dateStartBudget) {
		this.dateStartBudget = dateStartBudget;
	}

	public Double getStartBudget() {
		return this.startBudget;
	}

	public void setStartBudget(final Double startBudget) {
		this.startBudget = startBudget;
	}

}
