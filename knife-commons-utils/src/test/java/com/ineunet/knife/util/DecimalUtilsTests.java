package com.ineunet.knife.util;

import java.math.BigDecimal;

import org.junit.Test;

import junit.framework.Assert;

/**
 * 
 * @author Hilbert Wang
 * @since 2.0.2
 * Created on 2015-4-8
 */
public class DecimalUtilsTests {

	@Test
	public void testCutInvalidScale() {
		Assert.assertEquals(new BigDecimal("2"), DecimalUtils.cutInvalidSacle(new BigDecimal("2.00")));
		Assert.assertEquals(new BigDecimal("2.1"), DecimalUtils.cutInvalidSacle(new BigDecimal("2.100")));
		Assert.assertEquals(new BigDecimal("0.34"), DecimalUtils.cutInvalidSacle(new BigDecimal("0.340000")));
		
		Assert.assertEquals(new BigDecimal("0.123456789"), DecimalUtils.cutInvalidSacle(new BigDecimal("0.123456789000")));
		Assert.assertEquals(new BigDecimal("1"), DecimalUtils.cutInvalidSacle(new BigDecimal("1.00")));
	}
	
	@Test
	public void testIsValueEquals() {
		Assert.assertEquals(true, DecimalUtils.isValueEquals(new BigDecimal("2"), new BigDecimal("2.00")));
		Assert.assertEquals(true, DecimalUtils.isValueEquals(new BigDecimal("2.0"), new BigDecimal("2.00")));
		Assert.assertEquals(true, DecimalUtils.isValueEquals(new BigDecimal("2.0000000000000000000000000001"), new BigDecimal("2.00")));
		Assert.assertEquals(false, DecimalUtils.isValueEquals(new BigDecimal("2.000001"), new BigDecimal("2.00")));
	}
	
}
