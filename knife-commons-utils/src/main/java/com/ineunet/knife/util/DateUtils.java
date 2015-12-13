/*
 * Copyright 2013-2016 iNeunet OpenSource and the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ineunet.knife.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.ineunet.knife.util.exception.KnifeUtilsException;

/**
 * 
 * @author Hilbert Wang
 * 
 * @since 2007-8-1
 * 
 */
public abstract class DateUtils {

	/** yyyy-MM-dd HH:mm:ss */
	public static final String PATTERN_DATE_TIME_ = "yyyy-MM-dd HH:mm:ss";
	/** yyyyMMdd HH:mm:ss */
	public static final String PATTERN_DATE_TIME = "yyyyMMdd HH:mm:ss";

	/** yyyy-MM-dd */
	public static final String PATTERN_DATE_ = "yyyy-MM-dd";

	/** yyyyMMdd */
	public static final String PATTERN_DATE = "yyyyMMdd";

	/** yyyyMMdd */
	public static final String PATTERN_yyyyMM = "yyyyMM";

	/** yyyy-MM-dd HH:mm:ss */
	public static final SimpleDateFormat FORMAT_DATE_TIME_ = new SimpleDateFormat(DateUtils.PATTERN_DATE_TIME_);

	/** yyyy-MM-dd */
	public static final SimpleDateFormat FORMAT_DATE_ = new SimpleDateFormat(DateUtils.PATTERN_DATE_);

	/** yyyyMMdd */
	public static final SimpleDateFormat FORMAT_DATE = new SimpleDateFormat(PATTERN_DATE);

	/** yyyyMM */
	public static final SimpleDateFormat FORMAT_yyyyMM = new SimpleDateFormat(PATTERN_yyyyMM);

	public static final String toString(Date date, String pattern) {
		try {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			return format.format(date);
		} catch (Exception e) {
			throw new KnifeUtilsException(e);
		}
	}

	/**
	 * Specified <code>pattern</code> match specified parameter
	 * <code>date</code>.
	 * 
	 * @param date
	 * @param pattern
	 * @return date
	 */
	public static final Date toDate(String date, String pattern) {
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(date);
		} catch (ParseException e) {
			throw new KnifeUtilsException(e);
		}
	}

	/**
	 * 
	 * @param date
	 *            yyyy-MM-dd
	 * @return date
	 */
	public static final Date toDate_(String date) {
		try {
			return FORMAT_DATE_.parse(date);
		} catch (ParseException e) {
			throw new KnifeUtilsException(e);
		}
	}

	/** yyyy-MM-dd HH:mm:ss */
	public static final Date toDateTime_(String date) {
		try {
			return FORMAT_DATE_TIME_.parse(date);
		} catch (ParseException e) {
			throw new KnifeUtilsException(e);
		}
	}

	/** yyyy-MM-dd HH:mm:ss */
	public static String toStrDateTime_(Date date) {
		return FORMAT_DATE_TIME_.format(date);
	}
	
	/** yyyy-MM-dd HH:mm:ss */
	public static String toStrDate_(Date date) {
		return FORMAT_DATE_TIME_.format(date);
	}

	/** yyyy-MM-dd HH:mm:ss */
	public static String getCurrentDateTime_() {
		return FORMAT_DATE_TIME_.format(new Date());
	}

	/**
	 * yyyy-MM-dd
	 * 
	 * @since 2.0.2
	 */
	public static String getCurrentDate_() {
		return FORMAT_DATE_.format(new Date());
	}

	/**
	 * @return current year. e.g. 2014
	 */
	public static int year() {
		return Calendar.getInstance().get(Calendar.YEAR);
	}

	/**
	 * @return current month. e.g. 10
	 */
	public static int month() {
		return Calendar.getInstance().get(Calendar.MONTH);
	}

	/**
	 * @return e.g. 201405
	 * @since 1.2.0
	 */
	public static String fullMonth() {
		return FORMAT_yyyyMM.format(new Date());
	}

	/**
	 * @return e.g. 20140426
	 */
	public static String fullDay() {
		return FORMAT_DATE.format(new Date());
	}

	/**
	 * @param month
	 * @return last day of month
	 */
	public static int lastDayOfMonth(int month) {
		if (month < 1 || month > 12)
			throw new IllegalArgumentException("Wrong month: " + month);

		boolean leap = leapYear(year());
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
			return 31;
		if (month == 2) {
			if (leap)
				return 29;
			return 28;
		}
		return 30;
	}

	public static boolean leapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
			// is leap year
			return true;
		} else {
			// is not leap year
			return false;
		}
	}

	/**
	 * 返回减去天数的日期
	 * 
	 * @param days
	 *            天数
	 * @return date before <tt>days</tt>
	 * @since 1.2.0
	 */
	public static Date minusDays(int days) {
		return minusDays(days, new Date());
	}

	public static Date minusDays(int days, Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - days);
		return now.getTime();
	}

	/**
	 * 返回增加天数的日期
	 * 
	 * @param days
	 *            天数
	 * @return date after <tt>days</tt>
	 * @since 1.2.0
	 */
	public static Date plusDays(int days) {
		return plusDays(days, new Date());
	}

	/**
	 * @param days
	 * @param date
	 *            a certain date
	 * @return date after <tt>days</tt> days
	 * @since 2.0.2
	 */
	public static Date plusDays(int days, Date date) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + days);
		return now.getTime();
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param start 较小的时间
	 * @param end 较大的时间
	 * @return 相差天数
	 * @since 2.0.2
	 */
	public static int getPeriodDays(Date start, Date end) {
		try {
			start = FORMAT_DATE_.parse(FORMAT_DATE_.format(start));
			end = FORMAT_DATE_.parse(FORMAT_DATE_.format(end));
			Calendar cal = Calendar.getInstance();
			cal.setTime(start);
			long time1 = cal.getTimeInMillis();
			cal.setTime(end);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception e) {
			throw new KnifeUtilsException(e);
		}
	}
	
	/**
	 * 计算两个日期之间相差的天数
	 * @param start 开始日期 yyyy-MM-dd格式
	 * @param end 结束日期  yyyy-MM-dd格式
	 * @return 相差天数
	 * @since 2.0.2
	 */
	public static int getPeriodDays(String start, String end) {
		try {
			Date startDate = FORMAT_DATE_.parse(start);
			Date endDate = FORMAT_DATE_.parse(end);
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(endDate);
			long time2 = cal.getTimeInMillis();
			long between_days = (time2 - time1) / (1000 * 3600 * 24);
			return Integer.parseInt(String.valueOf(between_days));
		} catch (Exception e) {
			throw new KnifeUtilsException(e);
		}
	}

}
