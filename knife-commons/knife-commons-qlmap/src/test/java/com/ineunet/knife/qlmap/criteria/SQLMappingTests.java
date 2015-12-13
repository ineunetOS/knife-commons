package com.ineunet.knife.qlmap.criteria;

import java.util.Date;

import org.junit.Test;

public class SQLMappingTests {

	@Test
	public void test() {
		ICriteria c = new Criteria("orders", "u");
		c.addRestrictor(Restrictors.moreEq("write_time", new Date()));
		c.addRestrictor(Restrictors.or(Restrictors.eq("name", "x"), Restrictors.like("name", "%hi%")));
		c.orderBy("shopName ASC");
		System.out.println(c.getQueryString());
		
		c = new Criteria(Criteria.class, "o");
		c.addRestrictor(Restrictors.moreEq("writeTime", new Date()));
		System.out.println(c.getQueryString());
		
		c.addIfNotBlank(Restrictors.likeNotBlank("name", "1"));
		c.addIfNotBlank(Restrictors.eq("sex", "0"));
		c.addIfNotBlank(Restrictors.eq("sex", 0));
		c.addIfNotBlank(Restrictors.eq("alias", ""));
		
		c.orderBy("shopName desc");
		System.out.println(c.getQueryString());
		System.out.println(c.limit(10, 10));
		
		c = new Criteria(Criteria.class, "o", true);
		c.addRestrictor(Restrictors.moreEq("writeTime", new Date()));
		System.out.println(c.getQueryString());
		
		c.addIfNotBlank(Restrictors.likeNotBlank("name", "1"));
		c.addIfNotBlank(Restrictors.eq("sex", "0"));
		c.addIfNotBlank(Restrictors.eq("sex", 0));
		c.addIfNotBlank(Restrictors.eq("alias", ""));
		
		c.orderBy("shopName desc");
		System.out.println(c.getQueryString());
		System.out.println(c.limit(10, 10));
	}
	
}
