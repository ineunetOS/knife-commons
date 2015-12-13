package com.ineunet.knife.config;

import junit.framework.Assert;

import org.junit.Test;

public class KnifeConfigImplTests {

	@Test
	public void testGet()
	{
		String multi_tenant = ConfigFactory.getKnifeConfig().getString("multi_tenant");
		Assert.assertEquals("true", multi_tenant);
		
		multi_tenant = ConfigFactory.getKnifeConfig().getString("multi_tenant1");
		Assert.assertEquals("", multi_tenant);
		
		multi_tenant = ConfigFactory.getKnifeConfig().getString("multi_tenant2");
		Assert.assertEquals("", multi_tenant);
		
		multi_tenant = ConfigFactory.getKnifeConfig().getString("multi_tenant3");
		Assert.assertEquals(null, multi_tenant);
	}
	
}
