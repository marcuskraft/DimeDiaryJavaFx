package com.dimediary.model.persistence;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "BANKACCOUNT")
public class PBankAccount implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7788504506056118005L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Integer id;

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
	private PUser user;

	@ManyToOne
	@JoinColumn(name = "BANKACCOUNT_CATEGORY_ID")
	private PBankAccountCategory bankAccountCategory;

	public PBankAccountCategory getBankAccountCategory() {
		return this.bankAccountCategory;
	}

	public void setBankAccountCategory(final PBankAccountCategory bankAccountCategory) {
		this.bankAccountCategory = bankAccountCategory;
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

	public PUser getUser() {
		return this.user;
	}

	public void setUser(final PUser user) {
		this.user = user;
	}

}
