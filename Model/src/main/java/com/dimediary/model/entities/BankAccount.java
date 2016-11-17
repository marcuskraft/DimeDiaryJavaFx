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

/**
 * entity class for bank accounts
 * 
 * @author eyota
 *
 */
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

	/**
	 *
	 * @return bank account category
	 */
	public BankAccountCategory getBankAccountCategory() {
		return this.bankAccountCategory;
	}

	/**
	 *
	 * @param bankAccountCategory
	 *            bank account category
	 */
	public void setBankAccountCategory(final BankAccountCategory bankAccountCategory) {
		this.bankAccountCategory = bankAccountCategory;
	}

	/**
	 *
	 * @return name of the bank account
	 */
	public String getName() {
		return this.name;
	}

	/**
	 *
	 * @param name
	 *            name of the bank account
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 *
	 * @return name of the bank
	 */
	public String getBankName() {
		return this.bankName;
	}

	/**
	 *
	 * @param bankName
	 *            name of the bank
	 */
	public void setBankName(final String bankName) {
		this.bankName = bankName;
	}

	/**
	 *
	 * @return IBAN of the bank account
	 */
	public String getIban() {
		return this.iban;
	}

	/**
	 *
	 * @param iban
	 *            IBAN of the bank account
	 */
	public void setIban(final String iban) {
		this.iban = iban;
	}

	/**
	 *
	 * @return BIC of the bank account
	 */
	public String getBic() {
		return this.bic;
	}

	/**
	 * BIC of the bank account
	 * 
	 * @param bic
	 */
	public void setBic(final String bic) {
		this.bic = bic;
	}

	/**
	 *
	 * @return user who own this bank account
	 */
	public User getUser() {
		return this.user;
	}

	/**
	 *
	 * @param user
	 *            user who own this bank account
	 */
	public void setUser(final User user) {
		this.user = user;
	}

	/**
	 *
	 * @return Date for which the start budget (getStartBudget) belongs to
	 */
	public Date getDateStartBudget() {
		return this.dateStartBudget;
	}

	/**
	 *
	 * @param dateStartBudget
	 *            Date for which the start budget (getStartBudget) belongs to
	 */
	public void setDateStartBudget(final Date dateStartBudget) {
		this.dateStartBudget = dateStartBudget;
	}

	/**
	 *
	 * @return start budget at the Date of dateStartBudget
	 */
	public Double getStartBudget() {
		return this.startBudget;
	}

	/**
	 * start budget at the Date of dateStartBudget
	 * 
	 * @param startBudget
	 */
	public void setStartBudget(final Double startBudget) {
		this.startBudget = startBudget;
	}

}
