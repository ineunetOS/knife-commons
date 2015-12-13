package com.ineunet.knife.util;

import org.junit.Test;

import junit.framework.Assert;

public class TextUtilsTests {

	@Test
	public void testAsterisked() {
		Assert.assertEquals("**3456", TextUtils.asterisked("123456", 4, false));
		Assert.assertEquals("1234**", TextUtils.asterisked("123456", 4, true));
		Assert.assertEquals("******", TextUtils.asterisked("123456", 0, false));
		Assert.assertEquals("123456", TextUtils.asterisked("123456", 6, false));
	}
	
}
