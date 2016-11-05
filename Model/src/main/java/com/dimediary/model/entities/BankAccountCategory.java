package com.dimediary.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "allAccountCategories", query = "from BankAccountCategory"),
		@NamedQuery(name = "findAccountCategories", query = "from BankAccountCategory b WHERE b.name IN :nameList") })
@Entity
@Table(name = "BANKACCOUNT_CATEGORY")
public class BankAccountCategory implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = -6934027507205045824L;

	@Id
	@Column(name = "NAME")
	private String name;

	@Column(name = "IS_REAL_ACCOUNT")
	private Boolean isRealAccount;

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Boolean getIsRealAccount() {
		return this.isRealAccount;
	}

	public void setIsRealAccount(final Boolean isRealAccount) {
		this.isRealAccount = isRealAccount;
	}

}
