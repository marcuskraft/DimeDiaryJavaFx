package com.dimediary.util.utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dmfs.rfc5545.DateTime;
import org.dmfs.rfc5545.recur.Freq;
import org.dmfs.rfc5545.recur.InvalidRecurrenceRuleException;
import org.dmfs.rfc5545.recur.RecurrenceRule;
import org.dmfs.rfc5545.recur.RecurrenceRule.Part;
import org.dmfs.rfc5545.recur.RecurrenceRuleIterator;

public class RecurrenceUtils {

	private final static Logger log = LogManager.getLogger(DBUtils.class);

	public static void test() {
		final RecurrenceRule rule = new RecurrenceRule(Freq.MONTHLY);
		try {
			rule.setByPart(Part.BYMONTHDAY, 1);
		} catch (final InvalidRecurrenceRuleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final RecurrenceRuleIterator iterator = rule.iterator(DateTime.now());

		final List<Date> dates = new ArrayList<>();
		int maxInstances = 100;
		while (iterator.hasNext() && (!rule.isInfinite() || maxInstances-- > 0)) {
			final DateTime nextInstance = iterator.nextDateTime();
			final Date date = new Date(nextInstance.getSeconds() * 1000);
			dates.add(date);
		}

		final int i = 1;
	}

	public static RecurrenceRule getRecurrenceRule(final String ruleString) {
		try {
			return new RecurrenceRule(ruleString);
		} catch (final InvalidRecurrenceRuleException e) {
			RecurrenceUtils.log.error("ruleString ist kein gültiger String zur Erzeugung einer RecurrenceRule", e);
			throw new IllegalStateException(e);
		}
	}

}
