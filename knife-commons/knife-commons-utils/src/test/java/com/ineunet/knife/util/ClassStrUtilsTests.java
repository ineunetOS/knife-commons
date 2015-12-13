package com.ineunet.knife.util;

import junit.framework.Assert;

import org.junit.Test;

/**
 *
 * @author Hilbert Wang
 * @since 2.0.0
 */
public class ClassStrUtilsTests {
	
	@Test
	public void testToFirstUpper() {
		Assert.assertEquals("StrUtils", ClassStrUtils.toFirstUpper("strUtils"));
		Assert.assertEquals("Str_utils", ClassStrUtils.toFirstUpper("Str_utils"));
		
		Assert.assertEquals("A", ClassStrUtils.toFirstUpper("a"));
		Assert.assertEquals("Z", ClassStrUtils.toFirstUpper("z"));
	}
	
	@Test
	public void testFieldToGetMethod() {
		Assert.assertEquals("getA", ClassStrUtils.fieldToGetMethod("a"));
		Assert.assertEquals("getUserName", ClassStrUtils.fieldToGetMethod("userName"));
		Assert.assertEquals("getCODE", ClassStrUtils.fieldToGetMethod("CODE"));
	}

	@Test
	public void testHump2Underline() {
		Assert.assertEquals("str_utils", ClassStrUtils.hump2Underline("StrUtils"));
		Assert.assertEquals("str", ClassStrUtils.hump2Underline("Str"));
		Assert.assertEquals("str_utils_dr", ClassStrUtils.hump2Underline("StrUtilsDr"));
		Assert.assertEquals("str_utils_dr_t", ClassStrUtils.hump2Underline("StrUtilsDrT"));
		
		Assert.assertEquals("str_utils", ClassStrUtils.hump2Underline("strUtils"));
		Assert.assertEquals("str", ClassStrUtils.hump2Underline("str"));
		
		Assert.assertEquals("_str", ClassStrUtils.hump2Underline("_str"));
		Assert.assertEquals("", ClassStrUtils.hump2Underline(""));
	}
	
}
