package com.dimediary.model.entities;

import java.io.Serializable;

import jakarta.persistence.*;
/**
 * entity for the bank account categories
 *
 * @author eyota
 *
 */
@NamedQueries({ @NamedQuery(name = "allAccountCategories", query = "from BankAccountCategory"),
		@NamedQuery(name = "findAccountCategories", query = "from BankAccountCategory b WHERE b.name IN :nameList"),
		@NamedQuery(name = BankAccountCategory.DELETE_ALL_BANKACCOUNT_CATEGORIES, query = "DELETE FROM BankAccountCategory") })
@Entity
@Table(name = "BANKACCOUNT_CATEGORY")
public class BankAccountCategory implements Serializable {

	public static final String DELETE_ALL_BANKACCOUNT_CATEGORIES = "DELETE_ALL_BANKACCOUNT_CATEGORIES";

	/**
	 *
	 */
	private static final long serialVersionUID = -6934027507205045824L;

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "IS_REAL_ACCOUNT")
	private Boolean isRealAccount;

	/**
	 *
	 * @return name of the bank account category
	 */
	public String getName() {
		return this.name;
	}

	/**
	 *
	 * @param name
	 *                 name of the bank account category
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 *
	 * @return true is this is a real account
	 */
	public Boolean getIsRealAccount() {
		return this.isRealAccount;
	}

	/**
	 *
	 * @param isRealAccount
	 *                          set if this is a real account or not
	 */
	public void setIsRealAccount(final Boolean isRealAccount) {
		this.isRealAccount = isRealAccount;
	}

}
