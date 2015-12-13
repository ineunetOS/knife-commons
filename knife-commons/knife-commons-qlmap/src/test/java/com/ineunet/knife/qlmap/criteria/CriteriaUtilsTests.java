package com.ineunet.knife.qlmap.criteria;

import junit.framework.Assert;

import org.junit.Test;

public class CriteriaUtilsTests {

	@Test
	public void testTransPropName() {
		Assert.assertEquals("prop_name", CriteriaUtils.propToColumn("propName"));
		Assert.assertEquals("prop_name_name", CriteriaUtils.propToColumn("propNameName"));
	}

}
