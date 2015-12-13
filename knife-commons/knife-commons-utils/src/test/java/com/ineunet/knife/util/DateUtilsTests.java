package com.ineunet.knife.util;

import java.util.Date;

import junit.framework.Assert;

import org.junit.Test;

public class DateUtilsTests {

	@Test
	public void testToDate()
	{
		System.out.println(DateUtils.toDate_("2013-9-21"));
		System.out.println(DateUtils.toDateTime_("2013-9-24 12:12:20"));
	}
	
	@Test
	public void testYear() {
		System.out.println("testYear" + DateUtils.year());
	}
	
	@Test
	public void testFullDay() {
		System.out.println("testFullDay: " + DateUtils.fullDay());
	}
	
	@Test
	public void testFullMonth() {
		System.out.println("testFullMonth: " + DateUtils.fullMonth());
	}
	
	@Test
	public void testPeriodDays() {
		System.out.println("***************** testPeriodDays *******************");
		Date d1 = DateUtils.minusDays(7);
		//System.out.println(DateUtils.toDefaultString(d1));
		Date d2 = new Date();
		//System.out.println(DateUtils.toDefaultString(d2));
		Assert.assertEquals(7, DateUtils.getPeriodDays(d1, d2));
		Assert.assertEquals(7, DateUtils.getPeriodDays(DateUtils.toStrDateTime_(d1), DateUtils.toStrDateTime_(d2)));
		Assert.assertEquals(-7, DateUtils.getPeriodDays(DateUtils.toStrDateTime_(d2), DateUtils.toStrDateTime_(d1)));
	}
	
	@Test
	public void testToString() {
		Date d1 = DateUtils.toDate_("2015-6-3");
		Assert.assertEquals("2015-06-03", DateUtils.toString(d1, "yyyy-MM-dd"));
	}
	
	@Test
	public void testPlusDays() {
		Date d1 = DateUtils.toDate_("2015-6-27");
		Date d2 = DateUtils.plusDays(1, d1);
		Assert.assertEquals("2015-06-28", DateUtils.toString(d2, "yyyy-MM-dd"));
	}
	
}
