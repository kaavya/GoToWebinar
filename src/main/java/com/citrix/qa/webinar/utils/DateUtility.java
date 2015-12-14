package com.citrix.qa.webinar.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtility {
	public static Date addDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);

	}

	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);

	}

	public static int getDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DATE);

	}

	public static int getDateDiffInMonths(Date date1, Date date2) {

		int m1 = getYear(date1) * 12 + getMonth(date1);
		int m2 = getYear(date2) * 12 + getMonth(date2);
		return m2 - m1;
	}

	public static String getName() {

		Calendar cal = Calendar.getInstance();

		String time = new String();
		time = "Meeting_";
		time.concat(cal.getTime().toString());

		return time;
	}
}
