package com.ineunet.knife.util;

import org.junit.Test;

import junit.framework.Assert;

public class StrUtilsTests {

	@Test
	public void testCapitalize() {
		Assert.assertEquals("Str", StringUtils.capitalize("str"));
		Assert.assertEquals("Str", StringUtils.capitalize("Str"));
	}
	
}
