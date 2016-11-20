package com.dimediary.controller.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.dimediary.controller.utils.DateUtils;
import com.dimediary.model.entities.ContinuousTransaction.DayOfMonth;

public class TestDateUtils {

	@Test
	public void testCreatingMonthlyDates() {
		final DayOfMonth dayOfMonth = DayOfMonth.THIRD;
		final Date dateFrom = new Date();
		final Calendar calendar = Calendar.getInstance();
		calendar.set(2018, 5, 1);
		final Date dateUntil = null;
		final Integer numberOfIterations = 10;
		final ArrayList<Date> dates = DateUtils.getMonthlyDates(1, dayOfMonth, dateFrom, dateUntil, numberOfIterations);

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
		for (final Date date : dates) {
			System.out.println(simpleDateFormat.format(date));
		}
	}

}
