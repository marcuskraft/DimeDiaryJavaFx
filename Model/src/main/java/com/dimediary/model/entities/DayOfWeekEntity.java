package com.dimediary.model.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DAY_OF_WEEK")
public class DayOfWeekEntity implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 8608035438561064933L;
	@Id
	@Column(name = "DAY_OF_WEEK")
	private java.time.DayOfWeek dayOfWeek;

}
