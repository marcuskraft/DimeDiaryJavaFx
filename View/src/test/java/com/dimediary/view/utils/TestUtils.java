package com.dimediary.view.utils;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.trolltech.qt.core.QDate;

public class TestUtils {

	@Test
	public void testDateUtils() {
		@SuppressWarnings("deprecation")
		final Date date = new Date(2016, 8, 15);

		final QDate qDate = QTUtils.dateToQDate(date);

		final Date date2 = QTUtils.qDateToDate(qDate);

		Assert.assertTrue(date.equals(date2));

	}

}
