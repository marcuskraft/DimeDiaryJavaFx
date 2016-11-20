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

	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_BEGINN")
	private Date dateBeginn;

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

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public Date getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(final Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(final Double amount) {
		this.amount = amount;
	}

	public BankAccount getBankAccount() {
		return this.bankAccount;
	}

	public void setBankAccount(final BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(final User user) {
		this.user = user;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(final Category category) {
		this.category = category;
	}

	public Integer getNumberOfIterations() {
		return this.numberOfIterations;
	}

	public void setNumberOfIterations(final Integer numberOfIterations) {
		this.numberOfIterations = numberOfIterations;
	}

	public Date getIterateUntil() {
		return this.iterateUntil;
	}

	public void setIterateUntil(final Date iterateUntil) {
		this.iterateUntil = iterateUntil;
	}

	public IterationState getIterationState() {
		return this.iterationState;
	}

	public void setIterationState(final IterationState iterationState) {
		this.iterationState = iterationState;
	}

	public DayOfMonth getDayOfMonth() {
		return this.dayOfMonth;
	}

	public void setDayOfMonth(final DayOfMonth dayOfMonth) {
		this.dayOfMonth = dayOfMonth;
	}

	public Integer getEveryIterationState() {
		return this.everyIterationState;
	}

	public void setEveryIterationState(final Integer everyIterationState) {
		this.everyIterationState = everyIterationState;
	}

	public boolean isEveryWorkday() {
		return this.everyWorkday;
	}

	public void setEveryWorkday(final boolean everyWorkday) {
		this.everyWorkday = everyWorkday;
	}

	public List<DayOfWeekEntity> getDayOfWeeks() {
		return this.dayOfWeeks;
	}

	public void setDayOfWeeks(final List<DayOfWeekEntity> dayOfWeeks) {
		this.dayOfWeeks = dayOfWeeks;
	}

	public Integer getEveryYearDayOfMonth() {
		return this.EveryYearDayOfMonth;
	}

	public void setEveryYearDayOfMonth(final Integer everyYearDayOfMonth) {
		this.EveryYearDayOfMonth = everyYearDayOfMonth;
	}

	public Integer getNumberOfMonth() {
		return this.numberOfMonth;
	}

	public void setNumberOfMonth(final Integer numberOfMonth) {
		this.numberOfMonth = numberOfMonth;
	}

	public Date getDateBeginn() {
		return this.dateBeginn;
	}

	public void setDateBeginn(final Date dateBeginn) {
		this.dateBeginn = dateBeginn;
	}
}
