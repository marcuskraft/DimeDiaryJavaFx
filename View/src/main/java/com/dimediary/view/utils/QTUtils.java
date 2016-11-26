package com.dimediary.view.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QDateTime;
import com.trolltech.qt.gui.QColor;
import com.trolltech.qt.gui.QWidget;

public class QTUtils {

	public static Date qDateToDate(final QDate qdate) {
		if (qdate == null) {
			return null;
		}
		final QDateTime dateTime = new QDateTime(qdate);
		final Date dateFrom = new Date(dateTime.toMSecsSinceEpoch());
		return dateFrom;
	}

	public static QDate dateToQDate(final Date date) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat format;

		format = new SimpleDateFormat("yyyy");
		final int year = Integer.parseInt(format.format(date));

		format = new SimpleDateFormat("MM");
		final int mounth = Integer.parseInt(format.format(date));

		format = new SimpleDateFormat("dd");
		final int day = Integer.parseInt(format.format(date));

		return new QDate(year, mounth, day);
	}

	public static void setBackgrundColor(final QWidget widget, final int r, final int g, final int b) {
		final QColor BtnColor1 = QColor.fromRgb(r, g, b);
		widget.setStyleSheet("background-color: " + BtnColor1.name());
	}

}
