package com.dimediary.controller.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.dmfs.rfc5545.DateTime;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import com.dimediary.model.entities.BankAccount;
import com.dimediary.util.utils.DateUtils;

@RunWith(MockitoJUnitRunner.class)
public class DateUtilsTest {

	private static final LocalDate UNTIL_DATE = LocalDate.of(2019, 2, 5);
	private static final LocalDate START_DAY = LocalDate.of(2018, 3, 1);
	private static final LocalDate FROM_DATE = LocalDate.of(2018, 4, 12);

	@Mock
	BankAccount BankAccount;

	@Test
	public void localDateTimeToDateTimeTest() {
		final LocalDate localDateBefore = LocalDate.now();
		final DateTime dateTime = DateUtils.localDateToDateTime(localDateBefore);
		final LocalDate localDateAfter = DateUtils.dateTimeToLocalDate(dateTime);

		Assert.assertTrue("localDateToDateTime and dateTimeToLocalDate not reversible methods",
				localDateBefore.compareTo(localDateAfter) == 0);
	}

	@Test
	public void localDateToDateTimeTest() {
		final LocalDate localDate = LocalDate.of(2018, 2, 28);
		final DateTime dateTime = DateUtils.localDateToDateTime(localDate);

		Assert.assertTrue(localDate.getYear() == dateTime.getYear());
		Assert.assertTrue(localDate.getMonthValue() == dateTime.getMonth() + 1);
		Assert.assertTrue(localDate.getDayOfMonth() == dateTime.getDayOfMonth());
	}

	@Test
	public void dateTimeToLocalDateTest() {
		final DateTime dateTime = DateTime.now();
		final LocalDate localDate = DateUtils.dateTimeToLocalDate(dateTime);

		Assert.assertTrue(localDate.getYear() == dateTime.getYear());
		Assert.assertTrue(localDate.getMonthValue() == dateTime.getMonth() + 1);
		Assert.assertTrue(localDate.getDayOfMonth() == dateTime.getDayOfMonth());
	}

	@Test
	public void getLastSundayTest() {
		final LocalDate localDate = LocalDate.of(2018, 4, 30);
		final LocalDate lastSunday = DateUtils.getLastSunday(localDate);

		Assert.assertTrue(lastSunday.isBefore(localDate));
		Assert.assertTrue(lastSunday.getDayOfWeek() == DayOfWeek.SUNDAY);
		Assert.assertTrue(2018 == lastSunday.getYear());
		Assert.assertTrue(4 == lastSunday.getMonthValue());
		Assert.assertTrue(29 == lastSunday.getDayOfMonth());

		final LocalDate lastSunday2 = DateUtils.getLastSunday(lastSunday);
		Assert.assertTrue(lastSunday2.equals(lastSunday));

		final LocalDate lastSunday3 = DateUtils.getLastSundayAlways(lastSunday);

		Assert.assertTrue(lastSunday3.isBefore(lastSunday));
		Assert.assertTrue(lastSunday3.getDayOfWeek() == DayOfWeek.SUNDAY);
		Assert.assertTrue(2018 == lastSunday3.getYear());
		Assert.assertTrue(4 == lastSunday3.getMonthValue());
		Assert.assertTrue(22 == lastSunday3.getDayOfMonth());
	}

	@Test
	public void getNextSundayTest() {
		final LocalDate localDate = LocalDate.of(2018, 4, 30);
		final LocalDate nextSunday = DateUtils.getNextSunday(localDate);

		Assert.assertTrue(nextSunday.isAfter(localDate));
		Assert.assertTrue(nextSunday.getDayOfWeek() == DayOfWeek.SUNDAY);
		Assert.assertTrue(2018 == nextSunday.getYear());
		Assert.assertTrue(5 == nextSunday.getMonthValue());
		Assert.assertTrue(6 == nextSunday.getDayOfMonth());

		final LocalDate nextSunday2 = DateUtils.getNextSunday(nextSunday);
		Assert.assertTrue(nextSunday2.equals(nextSunday));

		final LocalDate nextSunday3 = DateUtils.getNextSundayAlways(nextSunday);

		Assert.assertTrue(nextSunday3.isAfter(nextSunday));
		Assert.assertTrue(nextSunday3.getDayOfWeek() == DayOfWeek.SUNDAY);
		Assert.assertTrue(2018 == nextSunday3.getYear());
		Assert.assertTrue(5 == nextSunday3.getMonthValue());
		Assert.assertTrue(13 == nextSunday3.getDayOfMonth());
	}

	@Test
	public void getAllSundaysForBalancingTest() {
		Mockito.when(this.BankAccount.getDateStartBudget()).thenReturn(DateUtilsTest.START_DAY);
		final List<LocalDate> localDates = DateUtils.getAllSundaysForBalancing(this.BankAccount,
				DateUtilsTest.FROM_DATE);

		LocalDate lastDate = DateUtilsTest.FROM_DATE;
		for (final LocalDate localDate : localDates) {
			Assert.assertTrue(localDate.getDayOfWeek() == DayOfWeek.SUNDAY);
			Assert.assertTrue(lastDate.isBefore(localDate));
			lastDate = localDate;
		}

		final List<LocalDate> localDates2 = DateUtils.getAllSundaysForBalancing(this.BankAccount, null);
		final LocalDate lastSunday = DateUtils.getLastSunday(DateUtilsTest.START_DAY);

		Assert.assertTrue(lastSunday.equals(localDates2.get(0)));
		lastDate = DateUtilsTest.START_DAY;
		for (final LocalDate localDate : localDates) {
			Assert.assertTrue(localDate.getDayOfWeek() == DayOfWeek.SUNDAY);
			Assert.assertTrue(lastDate.isBefore(localDate));
			lastDate = localDate;
		}
	}

	@Test
	public void getDatesForMonthTest() {
		final List<LocalDate> localDates = DateUtils.getDatesForMonth(Month.DECEMBER, 2018);
		final Set<LocalDate> set = new HashSet<>(localDates);

		LocalDate lastDate = localDates.get(0).minusDays(1);

		Assert.assertTrue(localDates.size() == 31);
		Assert.assertTrue(localDates.size() == set.size());
		for (final LocalDate localDate : localDates) {
			Assert.assertTrue(localDate.getMonth() == Month.DECEMBER);
			Assert.assertTrue(localDate.getYear() == 2018);
			Assert.assertTrue(lastDate.isBefore(localDate));
			lastDate = localDate;
		}
	}

	@Test
	public void getFirstDayOfMonthTest() {
		final LocalDate firstDay = DateUtils.firstDayOfMonth(Month.AUGUST, 2018);

		Assert.assertTrue(2018 == firstDay.getYear());
		Assert.assertTrue(8 == firstDay.getMonthValue());
		Assert.assertTrue(1 == firstDay.getDayOfMonth());
	}

	@Test
	public void getLastDayOfMonthTest() {
		final LocalDate lastDayNormal = DateUtils.lastDayOfMonth(Month.FEBRUARY, 2018);

		Assert.assertTrue(2018 == lastDayNormal.getYear());
		Assert.assertTrue(2 == lastDayNormal.getMonthValue());
		Assert.assertTrue(28 == lastDayNormal.getDayOfMonth());

		final LocalDate lastDaySpecial = DateUtils.lastDayOfMonth(Month.FEBRUARY, 2020);

		Assert.assertTrue(2020 == lastDaySpecial.getYear());
		Assert.assertTrue(2 == lastDaySpecial.getMonthValue());
		Assert.assertTrue(29 == lastDaySpecial.getDayOfMonth());

	}

	@Test
	public void getDatesFromToTest() {
		final List<LocalDate> localDates = DateUtils.getLocalDatesFromTo(DateUtilsTest.FROM_DATE,
				DateUtilsTest.UNTIL_DATE);
		final Set<LocalDate> set = new HashSet<>(localDates);

		Assert.assertTrue(localDates.size() == set.size());

		LocalDate lastDate = localDates.get(0).minusDays(1);

		for (final LocalDate localDate : localDates) {
			Assert.assertTrue(lastDate.isBefore(localDate));
			lastDate = localDate;
		}

	}

}
