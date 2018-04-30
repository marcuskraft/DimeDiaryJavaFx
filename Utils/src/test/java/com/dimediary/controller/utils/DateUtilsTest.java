package com.dimediary.controller.utils;

import java.time.LocalDate;

import org.dmfs.rfc5545.DateTime;
import org.junit.Assert;
import org.junit.Test;

import com.dimediary.util.utils.DateUtils;

public class DateUtilsTest {

	@Test
	public void localDateTimeToDateTimeTest() {
		final LocalDate localDateBefore = LocalDate.now();
		final DateTime dateTime = DateUtils.localDateToDateTime(localDateBefore);
		final LocalDate localDateAfter = DateUtils.dateTimeToLocalDate(dateTime);

		Assert.assertTrue("localDateToDateTime and dateTimeToLocalDate not reversible methods",
				localDateBefore.compareTo(localDateAfter) == 0);

	}

}
