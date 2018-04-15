package com.dimediary.util.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmfs.rfc5545.DateTime;
import org.dmfs.rfc5545.recur.InvalidRecurrenceRuleException;
import org.dmfs.rfc5545.recur.RecurrenceRule;
import org.dmfs.rfc5545.recur.RecurrenceRuleIterator;

public class RecurrenceRuleUtils {

	private final static Logger log = LogManager.getLogger(RecurrenceRuleUtils.class);

	public final static int numberOfMonthFutureTransactions = 120;

	public static List<Date> getDatesForRecurrenceRule(RecurrenceRule recurrenceRule, DateTime beginOfRule,
			DateTime dateFrom) {
		final List<Date> dates = new ArrayList<>();
		final RecurrenceRuleIterator recurrenceRuleIterator = recurrenceRule.iterator(beginOfRule);

		if (dateFrom != null) {
			recurrenceRuleIterator.fastForward(dateFrom);
		}

		final Date dateUntilMax = DateUtils.AddMonth(new Date(), numberOfMonthFutureTransactions);

		Date date = DateUtils.dateTimeToDate(beginOfRule);
		while (recurrenceRuleIterator.hasNext() && date.before(dateUntilMax)) {
			final DateTime dateTime = recurrenceRuleIterator.nextDateTime();
			date = DateUtils.dateTimeToDate(dateTime);
			dates.add(date);
		}
		return dates;
	}

	public static RecurrenceRule createRecurrenceRule(final String ruleString) {
		try {
			return new RecurrenceRule(ruleString);
		} catch (final InvalidRecurrenceRuleException e) {
			log.error("RuleString ist keine gültige RecurrenceRule", e);
			throw new IllegalStateException("RuleString ist keine gültige RecurrenceRule", e);
		}
	}

	public static Date getLastDateByCount(RecurrenceRule recurrenceRule, DateTime begin) {
		if (recurrenceRule.isInfinite()) {
			return null;
		}
		final RecurrenceRuleIterator recurrenceRuleIterator = recurrenceRule.iterator(begin);
		recurrenceRuleIterator.skipAllButLast();
		Date date = null;
		if (recurrenceRuleIterator.hasNext()) {
			date = DateUtils.dateTimeToDate(recurrenceRuleIterator.nextDateTime());
		}
		return date;
	}

}
