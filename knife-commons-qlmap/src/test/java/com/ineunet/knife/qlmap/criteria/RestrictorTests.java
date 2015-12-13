package com.ineunet.knife.qlmap.criteria;

import org.junit.Test;

import junit.framework.Assert;

public class RestrictorTests {
	
	@Test
	public void testLikeNotBlank() {
		Restrictor c = Restrictors.likeNotBlank("name", "% %");
		Assert.assertEquals(null, c);
		c = Restrictors.likeNotBlank("name", "%%");
		Assert.assertEquals(null, c);
		c = Restrictors.likeNotBlank("name", "%");
		Assert.assertEquals(null, c);
		c = Restrictors.likeNotBlank("name", " % ");
		Assert.assertEquals(null, c);
		
		SimpleRestrictor sc = (SimpleRestrictor) Restrictors.likeNotBlank("name", "%123%");
		Assert.assertEquals("%123%", sc.getValue());
		sc = (SimpleRestrictor) Restrictors.likeNotBlank("name", "%a%c%");
		Assert.assertEquals("%a%c%", sc.getValue());
	}
	
	@Test
	public void testiLikeNotBlank() {
		Restrictor c = Restrictors.iLikeNotBlank("name", "% %");
		Assert.assertEquals(null, c);
		c = Restrictors.iLikeNotBlank("name", "%%");
		Assert.assertEquals(null, c);
		c = Restrictors.iLikeNotBlank("name", "%");
		Assert.assertEquals(null, c);
		c = Restrictors.iLikeNotBlank("name", " % ");
		Assert.assertEquals(null, c);
		
		SimpleRestrictor sc = (SimpleRestrictor) Restrictors.iLikeNotBlank("name", "%123%");
		Assert.assertEquals("%123%", sc.getValue());
	}

}
