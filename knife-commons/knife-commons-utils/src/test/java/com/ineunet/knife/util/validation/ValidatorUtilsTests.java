package com.ineunet.knife.util.validation;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author Hilbert Wang
 * @since 2.0.1
 * Created on 2015-3-19
 */
public class ValidatorUtilsTests {

	@Test
	public void testLength() {
		String s = "";
		Assert.assertEquals(0, ValidatorUtils.length(s));
		s = "，";
		Assert.assertEquals(2, ValidatorUtils.length(s));
		s = "￥";
		Assert.assertEquals(2, ValidatorUtils.length(s));
		s = "好的";
		Assert.assertEquals(4, ValidatorUtils.length(s));
		s = "“好的”";
		Assert.assertEquals(8, ValidatorUtils.length(s));
		s = "【试】％＆×";
		Assert.assertEquals(12, ValidatorUtils.length(s));
		s = "－＋、？＃";
		Assert.assertEquals(10, ValidatorUtils.length(s));
	}
	
	@Test
	public void testMatchTelephone() {
		Assert.assertEquals(true, ValidatorUtils.matchTelephone("02568588587"));
		Assert.assertEquals(true, ValidatorUtils.matchTelephone("025-68588587"));
		Assert.assertEquals(true, ValidatorUtils.matchTelephone("051368588587"));
		Assert.assertEquals(true, ValidatorUtils.matchTelephone("0513-68588587"));
		
		Assert.assertEquals(false, ValidatorUtils.matchTelephone("05-68588587"));
		Assert.assertEquals(true, ValidatorUtils.matchTelephone("0000000000"));
	}
	
}
