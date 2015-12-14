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
		calendar.add(Calendar.DATE, x);
		return calendar.getTime();
	}
}
