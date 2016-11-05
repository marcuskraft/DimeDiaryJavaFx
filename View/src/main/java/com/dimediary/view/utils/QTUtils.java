package com.dimediary.view.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QDateTime;

public class QTUtils {

	public static Date qDateToDate(final QDate qdate) {
		final QDateTime dateTime = new QDateTime(qdate);
		final Date dateFrom = new Date(dateTime.toMSecsSinceEpoch());
		return dateFrom;
	}

	public static QDate dateToQDate(final Date date) {
		SimpleDateFormat format;

		format = new SimpleDateFormat("yyyy");
		final int year = Integer.parseInt(format.format(date));

		format = new SimpleDateFormat("MM");
		final int mounth = Integer.parseInt(format.format(date));

		format = new SimpleDateFormat("dd");
		final int day = Integer.parseInt(format.format(date));

		return new QDate(year, mounth, day);
	}
}
