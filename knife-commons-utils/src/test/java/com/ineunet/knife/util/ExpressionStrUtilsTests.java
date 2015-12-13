package com.ineunet.knife.util;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015年4月14日 
 */
public class ExpressionStrUtilsTests {

	@Test
	public void testEscapeRegex$() {
		String s = "$abc";
		Assert.assertEquals("\\x24abc", ExpressionStrUtils.escapeRegex$(s));
	}
	
	@Test
	public void testGetNamedParameters() {
		String s = "数据错误：$item";
		Assert.assertEquals(Arrays.asList(new String[] {"item"}), ExpressionStrUtils.getNamedParameters(s, "$"));
	}
	
}
