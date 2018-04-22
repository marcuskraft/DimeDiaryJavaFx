package com.dimediary.controller.utils;

import java.time.LocalDate;
import java.util.Date;

import org.dmfs.rfc5545.DateTime;
import org.junit.Assert;
import org.junit.Test;

import com.dimediary.util.utils.DateUtils;

public class DateUtilsTest {

	@Test
	public void dateTimeToDateTest() {
		final Date dateBefore = new Date();
		final DateTime dateTime = DateUtils.dateToDateTime(dateBefore);
		final Date dateAfter = DateUtils.dateTimeToDate(dateTime);

		Assert.assertTrue("DateTimeToDate and DateToDateTime not reversible methods",
				dateBefore.compareTo(dateAfter) == 0);

	}

	@Test
	public void localDateTimeToDateTimeTest() {
		final LocalDate localDateBefore = LocalDate.now();
		final DateTime dateTime = DateUtils.localDateToDateTime(localDateBefore);
		final LocalDate localDateAfter = DateUtils.dateTimeToLocalDate(dateTime);

		Assert.assertTrue("localDateToDateTime and dateTimeToLocalDate not reversible methods",
				localDateBefore.compareTo(localDateAfter) == 0);

	}

	@Test
	public void date2LocalDate() {
		final Date dateBefore = new Date(1462572000000l);
		final LocalDate localDate = DateUtils.date2LocalDate(dateBefore);
		final Date dateAfter = DateUtils.localDateToDate(localDate);

		Assert.assertTrue("date2LocalDate and localDateToDate not reversible methods",
				dateBefore.compareTo(dateAfter) == 0);
	}

}
