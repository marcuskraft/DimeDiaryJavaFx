package com.dimediary.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CONTINUOUS_TRANSACTION")
public class ContinuousTransaction implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1064986628363384286L;

	public enum IterationState {
		dayli(1), weekly(2), monthly(3), yearly(4), workday(5);
		int value;

		private IterationState(final int value) {
			this.value = value;
		}
	};

	@Id
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

	@Column(name = "NUMBER_OF_ITERATIONS")
	private Integer numberOfIterations;

	@Column(name = "ITERATION_STATE")
	private IterationState iterationState;

	@Column(name = "EVERY_ITERATION_STATE")
	private Integer everyIterationState;

}
