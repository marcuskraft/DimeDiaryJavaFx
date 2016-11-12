package com.dimediary.controller.utils;

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

}
