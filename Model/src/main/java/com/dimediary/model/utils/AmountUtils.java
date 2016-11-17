package com.dimediary.model.utils;

/**
 * util class for amount
 * 
 * @author eyota
 *
 */
public class AmountUtils {

	/**
	 *
	 * @param number
	 *            number to be rounded
	 * @return Double rounded to 2 decimals
	 */
	public static Double round(final Double number) {
		final Double result = Math.round(100.0 * number) / 100.0;
		return result;
	}

}
