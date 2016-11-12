package com.dimediary.model.utils;

public class AmountUtils {

	public static Double round(final Double number) {
		final Double result = Math.round(100.0 * number) / 100.0;
		return result;
	}

}
