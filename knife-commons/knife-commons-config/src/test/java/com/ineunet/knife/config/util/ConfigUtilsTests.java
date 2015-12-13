package com.ineunet.knife.config.util;

import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

public class ConfigUtilsTests {

	@Test
	public void testParseMapString()
	{
		String s = "onl.com=onl, offl.com=offl, ineunet.com=home";
		Map<String, String> map = ConfigUtils.parseMapString(s);
		Assert.assertEquals("onl", map.get("onl.com"));
		Assert.assertEquals("offl", map.get("offl.com"));
		Assert.assertEquals("home", map.get("ineunet.com"));
		
		s = "onl.com=onl";
		map = ConfigUtils.parseMapString(s);
		Assert.assertEquals("onl", map.get("onl.com"));
		
		map = ConfigUtils.parseMapString(s, "=", false);
		Assert.assertEquals("onl.com", map.get("onl"));
		
		s = "{\"歼十\":1, \"枭龙\":2}";
	}
	
}
