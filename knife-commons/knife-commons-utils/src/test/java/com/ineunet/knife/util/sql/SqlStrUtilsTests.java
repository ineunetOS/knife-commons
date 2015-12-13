package com.ineunet.knife.util.sql;

//import org.junit.Assert;
//import junit.framework.Assert;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.ineunet.knife.util.sql.SqlStrUtils;


/**
 * 
 * @author Hilbert Wang
 * @since 2.0.2
 * Created on 2015-3-30
 */
public class SqlStrUtilsTests {
	
	@Test
	public void testGetSelectColumns() {
		 Assert.assertArrayEquals(new String[] {"id", "code", "name"}, SqlStrUtils.getSelectColumns("select  id,  code,name from user "));
	}

	@Test
	public void testGetNamedParameters() {
		String sql = "update BSPD_RCVDETAIL set inspected_qty1=:inspected_qty1, inspected_qty2=:inspected_qty2, inspected_qty3=:inspected_qty3 where id=:inStoreDetailId;";
		Assert.assertEquals(Arrays.asList(new String[] {"inspected_qty1", "inspected_qty2", "inspected_qty3", "inStoreDetailId"}), SqlStrUtils.getNamedParameters(sql));
		
		sql = "update BSPD_RCVDETAIL set inspected_qty=:inspected_qty1 where id=:inStoreDetailId;";
		Assert.assertEquals(Arrays.asList(new String[] {"inspected_qty1", "inStoreDetailId"}), SqlStrUtils.getNamedParameters(sql));
	}
	
}
