package com.xyz.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class UtilityClass {
	
	public static long minutesDiff(String startTime, String endTime) {
		
		long minutesDiff = 0;

		//
		// Create an instance of SimpleDateFormat with the specified
		// format.
		//
		try {
			long MINUTE_MILLIS = 1000 * 60;
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
			Date startDate = sdf.parse(startTime);

			Date endDate = sdf.parse(endTime);

			Calendar calendar = GregorianCalendar.getInstance();
			calendar.setTime(startDate);

			minutesDiff = ((endDate.getTime() - startDate.getTime()) / MINUTE_MILLIS);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return minutesDiff;
	}
}
