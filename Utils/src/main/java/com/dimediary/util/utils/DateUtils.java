package com.dimediary.util.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.ArrayList;
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
	public final static int numberOfMonthFutureTransactions = 120;

	public static LocalDate getLastSunday(LocalDate localDate) {
		return DateUtils.getLastSunday(localDate, false);
	}

	public static LocalDate getLastSundayAlways(LocalDate localDate) {
		return DateUtils.getLastSunday(localDate, true);
	}

	private static LocalDate getLastSunday(LocalDate localDate, boolean always) {
		if (localDate == null) {
			return null;
		}
		final int dayOfWeek = localDate.getDayOfWeek().getValue();
		if (always || dayOfWeek != 7) {
			return localDate.minusDays(dayOfWeek);
		}
		return localDate;
	}

	public static LocalDate getNextSunday(LocalDate localDate) {
		return getNextSunday(localDate, false);
	}

	public static LocalDate getNextSundayAlways(LocalDate localDate) {
		return getNextSunday(localDate, true);
	}

	private static LocalDate getNextSunday(LocalDate localDate, boolean always) {
		if (localDate == null) {
			return null;
		}
		final int dayOfWeek = localDate.getDayOfWeek().getValue();
		if (dayOfWeek == 7) {
			if (always) {
				return localDate.plusDays(dayOfWeek);
			} else {
				return localDate;
			}
		}
		return localDate.plusDays(7 - dayOfWeek);
	}

	/**
	 *
	 * @param bankAccount
	 * @param dateFrom
	 * @return list of sundays from the dateFrom on or if this is null the creation
	 *         date of the given bank account until 108 weeks in the future related
	 *         to the actual date
	 */
	public static ArrayList<LocalDate> getAllSundaysForBalancing(final BankAccount bankAccount,
			final LocalDate dateFrom) {
		final ArrayList<LocalDate> sundays = new ArrayList<>();

		final LocalDate lastSunday = DateUtils.getLastSundayForBalancing(DateUtils.numberOfMonthFutureTransactions);

		LocalDate sunday;
		if (dateFrom != null) {
			sunday = DateUtils.getNextSunday(dateFrom);
		} else {
			sunday = DateUtils.getLastSunday(bankAccount.getDateStartBudget());
		}

		sundays.add(sunday);

		while (sunday.isBefore(lastSunday)) {
			sunday = DateUtils.getNextSundayAlways(sunday);
			sundays.add(sunday);
		}

		return sundays;

	}

	/**
	 *
	 * @param numberOfWeeks
	 * @return gives back the sunday for numberOfWeeks weeks in the future
	 */
	public static LocalDate getLastSundayForBalancing() {
		return DateUtils.getLastSundayForBalancing(DateUtils.numberOfMonthFutureTransactions);
	}

	private static LocalDate getLastSundayForBalancing(final int numberOfMonths) {
		final LocalDate actualSunday = getLastSunday(LocalDate.now());
		return getNextSunday(actualSunday.plusMonths(numberOfMonths));
	}

	/**
	 *
	 * @return the actual month
	 */
	public static Month getActualMonth() {
		return DateUtils.getMonth(LocalDate.now());
	}

	/**
	 *
	 * @return the actual year
	 */
	public static int getActualYear() {
		return DateUtils.getYear(LocalDate.now());
	}

	/**
	 *
	 * @param date
	 * @return year of the given date
	 */
	public static int getYear(final LocalDate date) {
		return date.getYear();
	}

	/**
	 *
	 * @param date
	 * @return month of the given date
	 */
	public static Month getMonth(final LocalDate date) {
		return date.getMonth();
	}

	/**
	 *
	 * @param month
	 * @param year
	 * @return list of dates for all days of the given month and year
	 */
	public static ArrayList<LocalDate> getDatesForMonth(final Month month, final int year) {
		final ArrayList<LocalDate> dates = new ArrayList<>();

		LocalDate actualDate = LocalDate.of(year, month, 1);
		final LocalDate lastDate = actualDate.plusMonths(1);

		while (actualDate.isBefore(lastDate)) {
			dates.add(actualDate);
			actualDate = actualDate.plusDays(1);
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

	public static DateTime localDateToDateTime(final LocalDate localDate) {
		return new DateTime(TimeZone.getDefault(),
				localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
	}

	public static LocalDate dateTimeToLocalDate(final DateTime dateTime) {
		return Instant.ofEpochMilli(dateTime.getTimestamp()).atZone(ZoneId.systemDefault()).toLocalDate();
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
