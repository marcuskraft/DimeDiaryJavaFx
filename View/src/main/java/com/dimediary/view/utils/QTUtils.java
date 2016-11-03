package com.dimediary.view.utils;

import java.util.Date;

import com.trolltech.qt.core.QDate;
import com.trolltech.qt.core.QDateTime;

public class QTUtils {

	public static Date qDateToDate(final QDate qdateFrom) {
		final QDateTime dateTime = new QDateTime(qdateFrom);
		final Date dateFrom = new Date(dateTime.toMSecsSinceEpoch());
		return dateFrom;
	}
}
