package com.dimediary.view.window.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.util.StringConverter;

public class NumberToDateStringConverter extends StringConverter<Number> {

	final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

	@Override
	public String toString(Number object) {
		final long days = object.longValue();
		final LocalDate date = LocalDate.ofEpochDay(days);
		return date.format(this.dateTimeFormatter);
	}

	@Override
	public Number fromString(String string) {
		LocalDate localDate;
		localDate = LocalDate.parse(string, this.dateTimeFormatter);
		return Long.valueOf(localDate.toEpochDay());

	}

}
