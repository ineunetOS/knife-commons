package com.ineunet.knife.util;

import org.junit.Test;

import junit.framework.Assert;

public class PinYinUtilsTests {

	@Test
	public void testGetSpell() {
		Assert.assertEquals("shenjingyuan", PinYinUtils.getSpell("神经元"));
		Assert.assertEquals("sjy", PinYinUtils.getFirstSpell("神经元"));
	}
	
}
