package com.ineunet.knife.util;

import java.util.HashMap;
import java.util.Map;

import junit.framework.Assert;

import org.junit.Test;

/**
 * 
 * @author Hilbert Wang
 * @since 2.0.2
 * Created on 2015-4-12
 */
public class CloneUtilsTests {

	@Test
	public void testCloneMap() {
		Map<String, Object> map = new HashMap<String, Object>();
		Map<String, Object> clone = CloneUtils.cloneMap(map);
		Assert.assertEquals(map, clone);
		
		map.put("1", "");
		map.put("1", new Object());
		clone = CloneUtils.cloneMap(map);
		Assert.assertEquals(map, clone);
	}
	
}
