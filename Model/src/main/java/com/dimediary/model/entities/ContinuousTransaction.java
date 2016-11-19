package com.dimediary.model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONTINUOUS_TRANSACTION")
public class ContinuousTransaction implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1064986628363384286L;

	public enum IterationState {
		DAYLI(1), WEEKLY(2), MONTHLY(3), YEARLY(4);
		int value;

		private IterationState(final int value) {
			this.value = value;
		}
	};

	public enum DayOfMonth {
		FIRST(1), SECOND(2), THIRD(3), FIFTHTEENS(4), LAST(5), NEXT_TO_LAST(6);
		int value;

		private DayOfMonth(final int value) {
			this.value = value;
		}
	};

	@Id
	@Column(name = "ID")
	private Integer id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "TIMESTAMP", updatable = true)
	private Date timestamp;

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

	@Temporal(TemporalType.DATE)
	@Column(name = "ITERATE_UNTIL")
	private Date iterateUntil;

	@Column(name = "ITERATION_STATE")
	private IterationState iterationState;

	@Column(name = "DAY_OF_MONTH")
	private DayOfMonth dayOfMonth;

	@Column(name = "EVERY_ITERATION_STATE")
	private Integer everyIterationState;

	@Column(name = "EVERY_WORKDAY")
	private boolean everyWorkday;

	@OneToMany()
	private List<DayOfWeekEntity> dayOfWeeks;

	@Column(name = "EVERY_YEAR_DAY_OF_MONTH")
	private Integer EveryYearDayOfMonth;

	@Column(name = "NUMBER_OF_MONTH")
	private Integer numberOfMonth;

	@PrePersist
	private void setTimestamp() {
		this.timestamp = new Date();
	}
}
