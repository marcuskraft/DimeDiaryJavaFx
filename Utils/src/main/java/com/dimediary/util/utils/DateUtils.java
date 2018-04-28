package com.dimediary.util.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.dmfs.rfc5545.DateTime;
import org.junit.Assert;

import com.dimediary.model.entities.BankAccount;

/**
 * class to handle date functionalities
 *
 * @author eyota
 *
 */
public class DateUtils {

	// TODO add the numberOfWeeksFutureBalancing in the options
	private final static int numberOfWeeksFutureBalancing = 108;
	private final static int numberOfMonthFutureTransactions = 120;

	public static ArrayList<Date> removeDatesBefore(final ArrayList<Date> dates, final Date dateFrom) {
		final ArrayList<Date> datesReturn = new ArrayList<>();
		for (final Date date : dates) {
			if (!date.before(dateFrom)) {
				datesReturn.add(date);
			}
		}
		return datesReturn;
	}

	/**
	 *
	 * @param date
	 * @return last sunday corresponding to the given date. If the given date is
	 *         already a sunday than the given date will be returned
	 */
	public static Date getLastSunday(final Date date) {
		return DateUtils.getLastSunday(date, false);
	}

	public static Date getLastSundayAlways(final Date date) {
		return DateUtils.getLastSunday(date, true);
	}

	private static Date getLastSunday(final Date date, final boolean always) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);

		final int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		if (always || !DateUtils.isSunday(date)) {
			calendar.add(Calendar.DAY_OF_WEEK, 1 - dayOfWeek);
		}

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	/**
	 *
	 * @param date
	 * @return next sunday corresponding to the given date. The next sunday will be
	 *         returned even if the given date is already a sunday.
	 */
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

	/**
	 *
	 * @param bankAccount
	 * @return
	 */

	/**
	 *
	 * @param bankAccount
	 * @param dateFrom
	 * @return list of sundays from the dateFrom on or if this is null the creation
	 *         date of the given bank account until 108 weeks in the future related
	 *         to the actual date
	 */
	public static ArrayList<Date> getAllSundaysForBalancing(final BankAccount bankAccount, final Date dateFrom) {
		final ArrayList<Date> sundays = new ArrayList<>();

		final Date lastSunday = DateUtils.getLastSundayForBalancing(DateUtils.numberOfWeeksFutureBalancing);

		Date sunday;
		if (dateFrom != null) {
			sunday = DateUtils.getLastSunday(dateFrom);
		} else {
			sunday = DateUtils.getLastSunday(bankAccount.getDateStartBudget());
		}

		sundays.add(sunday);

		while (sunday.before(lastSunday)) {
			sunday = DateUtils.getNextSunday(sunday);
			sundays.add(sunday);
		}

		return sundays;

	}

	/**
	 *
	 * @param numberOfWeeks
	 * @return gives back the sunday for numberOfWeeks weeks in the future
	 */
	public static Date getLastSundayForBalancing() {
		return DateUtils.getLastSundayForBalancing(DateUtils.numberOfWeeksFutureBalancing);
	}

	private static Date getLastSundayForBalancing(final int numberOfWeeks) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.WEEK_OF_YEAR, numberOfWeeks);
		calendar.set(Calendar.DAY_OF_MONTH, Calendar.SUNDAY);

		return calendar.getTime();

	}

	/**
	 *
	 * @param date
	 * @return true if the fiven date is a sunday and false if not
	 */
	public static boolean isSunday(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.DAY_OF_WEEK) == 1;
	}

	/**
	 *
	 * @param date
	 * @return date which is one day in the future corresponding to the given date
	 */
	public static Date addOneDay(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_WEEK, 1);
		return calendar.getTime();
	}

	/**
	 *
	 * @param date
	 * @return date which is one day in the future corresponding to the given date
	 */
	public static Date minusOneDay(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_WEEK, -1);
		return calendar.getTime();
	}

	public static Date AddMonth(final Date date, final Integer month) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, month);
		return calendar.getTime();
	}

	public static Date substractOnDay(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_WEEK, -1);
		return calendar.getTime();
	}

	/**
	 *
	 * @param day
	 * @param month
	 * @param year
	 * @return gives back a date for the given day, month and year
	 */
	public static Date getDate(final int day, final int month, final int year) {
		final Calendar calendar = Calendar.getInstance();
		calendar.set(year, month, day, 0, 0, 0);
		return calendar.getTime();
	}

	/**
	 *
	 * @return the actual month
	 */
	public static Month getActualMonth() {
		return DateUtils.getMonth(new Date());
	}

	/**
	 *
	 * @return the actual year
	 */
	public static int getActualYear() {
		return DateUtils.getYear(new Date());
	}

	/**
	 *
	 * @param date
	 * @return year of the given date
	 */
	public static int getYear(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar.get(Calendar.YEAR);
	}

	/**
	 *
	 * @param date
	 * @return month of the given date
	 */
	public static Month getMonth(final Date date) {
		final Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return DateUtils.getMonth(calendar.get(Calendar.MONTH));
	}

	/**
	 *
	 * @param month
	 * @return month which belongs to this number of month
	 */
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

	/**
	 *
	 * @param month
	 * @param year
	 * @return list of dates for all days of the given month and year
	 */
	public static ArrayList<Date> getDatesForMonth(final Month month, final Integer year) {
		final ArrayList<Date> dates = new ArrayList<>();

		final Calendar calendar = Calendar.getInstance();

		calendar.set(year, month.getValue() - 1, 1, 0, 0, 0);

		final Integer numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = 0; i < numberOfDays; i++) {
			dates.add(calendar.getTime());
			calendar.add(Calendar.DAY_OF_MONTH, 1);
		}

		return dates;
	}

	public static LocalDate firstDayOfMonth(Month month, int year) {
		return LocalDate.of(year, month, 1);
	}

	public static LocalDate lastDayOfMonth(Month month, int year) {
		final LocalDate localDate = LocalDate.of(year, month, 1);
		return localDate.withDayOfMonth(localDate.lengthOfMonth());
	}

	public static Date localDateToDate(final LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static LocalDate date2LocalDate(final Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static DateTime localDateToDateTime(final LocalDate localDate) {
		return new DateTime(DateUtils.localDateToDate(localDate).getTime());
	}

	public static LocalDate dateTimeToLocalDate(final DateTime dateTime) {
		return Instant.ofEpochMilli(dateTime.getTimestamp()).atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date dateTimeToDate(final DateTime dateTime) {
		return new Date(dateTime.getTimestamp());
	}

	public static DateTime dateToDateTime(final Date date) {
		return new DateTime(TimeZone.getDefault(), date.getTime());
	}

	public static List<LocalDate> getLocalDatesFromTo(LocalDate fromDate, LocalDate untilDate) {
		Assert.assertTrue(fromDate.isBefore(untilDate));

		final List<LocalDate> dates = new ArrayList<>();

		LocalDate nextDate = fromDate;

		do {
			dates.add(nextDate);
			nextDate = nextDate.plusDays(1);
		} while (nextDate.isBefore(untilDate));

		return dates;
	}

}
