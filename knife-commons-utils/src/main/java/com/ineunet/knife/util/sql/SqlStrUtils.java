package com.ineunet.knife.util.sql;

import java.util.List;

import com.ineunet.knife.util.Asserts;
import com.ineunet.knife.util.ExpressionStrUtils;

/**
 * 
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015-3-30
 */
public abstract class SqlStrUtils {
	
	/**
	 * Example:<br>
	 * <code>new String[] {"id", "code", "name"} equals SqlStrUtils.getSelectColumns("select  id,  code,name from user ")</code>
	 */
	public static String[] getSelectColumns(String sql) {
		Asserts.notBlank(sql);
		sql = sql.trim();
		if (sql.startsWith("select ") || sql.startsWith("SELECT ")) {
			sql = sql.substring(7).trim();
			int idxFrom = sql.indexOf(" from ");
			if (idxFrom == -1)
				idxFrom = sql.indexOf(" FROM ");
			if (idxFrom == -1)
				throw new IllegalArgumentException("Bad sql, no from ");
			sql = sql.substring(0, idxFrom).trim();
			String[] columns = sql.split(",");
			for (int i = 0; i < columns.length; i++) {
				columns[i] = columns[i].trim();
			}
			return columns;
		} else {
			throw new IllegalArgumentException("Not a select sql");
		}
	}
	
	/**
	 * @param sql e.g. select x from table where id=:id and name like :name
	 * @return paramerter names. e.g. [id, name]
	 */
	public static List<String> getNamedParameters(String sql) {
		return ExpressionStrUtils.getNamedParameters(sql, ":");
	}
	
}
