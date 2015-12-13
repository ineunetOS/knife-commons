package com.ineunet.knife.qlmap.criteria;


public class CriteriaTests {

	private static final ICriteria c = new Criteria("bill");
	
	//@Test
	public void testOrderBy() {
		c.orderBy(" paymentId      ASC");
		System.out.println(c.getQueryString());
		
		c.orderBy(" paymentId DESC");
		System.out.println(c.getQueryString());
		
		c.addRestrictor(Restrictors.in("id", "(select id from shop where shop_name like '%ads%')"));
		System.out.println(c.getQueryString());
	}
	
}
