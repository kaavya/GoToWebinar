package com.citrix.qa.webinar.util;

import java.util.Calendar;
import java.util.Date;

public class Utility {
	/**
	 * Generates a unix suffix based on current time
	 * 
	 * @return unique timestamp suffix
	 */
	public static String getUniqueSuffix() {
		return String.valueOf(new Date().getTime());
	}

	/**
	 * Get current date + x days
	 * 
	 * @param x
	 *            no of days
	 * @return Date object with x days from current
	 */
	public static Date getXDaysFromNow(int x) {
		Calendar calendar = Calendar.getInstance();

		for (int i = 0; i < x;) {
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			// i is only increased if it is week day
			if (calendar.get(Calendar.DAY_OF_WEEK) <= 5) {
				i++;
			}

		}
		return calendar.getTime();
	}
}
