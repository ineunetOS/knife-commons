package com.ineunet.knife.util.validation;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 * @author Hilbert Wang
 * @since 2.0.0
 * Created on 2015年3月14日 
 */
public class ValidRestrictorTests {
	
	@Test
	public void testNotBlankSpace() {
		String s = "";
		Assert.assertEquals(true, WebValidatorRestrictor.notBlankSpace("", s).isSuccess());
		s = " ";
		Assert.assertEquals(false, WebValidatorRestrictor.notBlankSpace("", s).isSuccess());
	}
	
	@Test
	public void testMatchPassword() {
		WebValidator v = WebValidatorRestrictor.matchPassword("【密码】", "");
		Assert.assertEquals(false, v.isSuccess());
		// Assert.assertEquals("", v.getMsg());
		System.out.println(v.getMsg());
	}
	
}
