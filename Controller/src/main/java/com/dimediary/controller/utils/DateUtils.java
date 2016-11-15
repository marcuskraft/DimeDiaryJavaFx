package com.dimediary.controller.utils;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.dimediary.model.entities.BankAccount;

public class DateUtils {

	// TODO add the numberOfWeeksFuture in the options
	private final static int numberOfWeeksFuture = 60;

	public static Date getLastSunday(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		if (!DateUtils.isSunday(date)) {
			calendar.add(Calendar.DAY_OF_WEEK, 1 - dayOfWeek);
		}

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static Date getNextSunday(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		calendar.add(Calendar.DAY_OF_WEEK, 8 - dayOfWeek);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static ArrayList<Date> getSundays(final BankAccount bankAccount) {
		final ArrayList<Date> sundays = new ArrayList<>();

		final Date lastSunday = DateUtils.getLastSunday(DateUtils.numberOfWeeksFuture);
		Date sunday = DateUtils.getLastSunday(bankAccount.getDateStartBudget());
		sundays.add(sunday);

		while (sunday.before(lastSunday)) {
			sunday = DateUtils.getNextSunday(sunday);
			sundays.add(sunday);
		}

		return sundays;

	}

	public static Date getLastSunday(final int numberOfWeeks) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.WEEK_OF_YEAR, numberOfWeeks);

		return calendar.getTime();

	}

	public static boolean isSunday(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK) == 1;
	}

	public static Date addOneDay(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_WEEK, 1);
		return calendar.getTime();
	}

	public static Date getDate(final int day, final int month, final int year) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day);
		return calendar.getTime();
	}

	public static Month getActualMonth() {
		return DateUtils.getMonth(new Date());
	}

	public static int getActualYear() {
		return DateUtils.getYear(new Date());
	}

	public static int getYear(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	public static Month getMonth(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return DateUtils.getMonth(calendar.get(Calendar.MONTH));
	}

	public static Month getMonth(final Integer month) {
		if (month == null) {
			return null;
		}
		switch (month) {
		case Calendar.JANUARY:
			return Month.JANUARY;
		case Calendar.FEBRUARY:
			return Month.FEBRUARY;
		case Calendar.MARCH:
			return Month.MARCH;
		case Calendar.APRIL:
			return Month.APRIL;
		case Calendar.MAY:
			return Month.MAY;
		case Calendar.JUNE:
			return Month.JUNE;
		case Calendar.JULY:
			return Month.JULY;
		case Calendar.AUGUST:
			return Month.AUGUST;
		case Calendar.SEPTEMBER:
			return Month.SEPTEMBER;
		case Calendar.OCTOBER:
			return Month.OCTOBER;
		case Calendar.NOVEMBER:
			return Month.NOVEMBER;
		case Calendar.DECEMBER:
			return Month.DECEMBER;
		default:
			return null;
		}
	}

	public static ArrayList<Date> getDatesForMonth(final Month month, final Integer year) {
		final ArrayList<Date> dates = new ArrayList<>();

		final Calendar calendar = Calendar.getInstance();

		calendar.set(Calendar.MONTH, month.getValue());
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		final Integer numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = 0; i < numberOfDays; i++) {
			dates.add(calendar.getTime());
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		return dates;
	}

}
