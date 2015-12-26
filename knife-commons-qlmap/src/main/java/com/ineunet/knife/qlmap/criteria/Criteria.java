/*
 * Copyright 2013-2016 iNeunet OpenSource and the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.ineunet.knife.qlmap.criteria;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ineunet.knife.util.Asserts;
import com.ineunet.knife.util.StringUtils;

/**
 * 先上例子：<br>
 * <code>
 * Criteria c = new Criteria(User.class, "u", true);<br>
 * c.addRestrictor(Restrictors.moreEq("writeTime", new Date()));<br>
 * c.add(Restrictors.like("name", "1"));<br>
 * c.add(Restrictors.eq("sex", 0));
 * c.orderBy("shopName desc");<br>
 * c.limit(0, 10);<br>
 * System.out.println(c.queryString());<br>
 * : "from Criteria o where 1=1 and o.writeTime&gt;=:writeTime and o.name like :name and o.sex=:sex order by o.shopName desc limit 0,10"
 * </code>
 * <p>
 * 
 * <code>
 * Criteria c = new Criteria(User.class, "u", true);<br>
 * c.addRestrictor(Restrictors.moreEq("writeTime", new Date()));<br>
 * c.addIfNotBlank(Restrictors.like("name", "1"));<br>
 * c.addIfNotBlank(Restrictors.eq("sex", "0"));<br>
 * c.addIfNotBlank(Restrictors.eq("sex", 0));
 * c.addIfNotBlank(Restrictors.eq("alias", ""));<br>
 * c.orderBy("shopName desc");<br>
 * c.limit(0, 10);<br>
 * System.out.println(c.queryString());<br>
 * : "from Criteria o where 1=1 and o.writeTime&gt;=:writeTime and o.name like :name and o.sex=:sex order by o.shopName desc limit 0,10"
 * </code>
 * <p>
 * 
 * <code>List&lt;User&gt; users = PersistUtils.getHibernateTemplate().find(c);</code>
 * <p>
 * 
 * 支持直接对数据库表(table)和对象实体(entity)进行查询。只负责组装查询语句，与具体持久层技术无关。
 * <p>
 * 例子1，查询数据库表或视图：<br>
 * sql      : select * from user where user_id=? and password=?;<br> 
 * Criteria : 
 * { Criteria c= new Criteria("user"); 
 * c.add(Restrictor.eq("user_id", "wangx"));<br>
 * c.add(Restrictor.eq("password", "z")); } <br>
 * 查询：findBySql(sql, new String[]{"wangx", "z"}); findBySql(c);
 * 
 * <p>
 * 例子2，查询实体：<br>
 * hql: from User where userId=? and password=?; <br>
 * Criteria:{ Criteria cq = new Criteria(User.class); cq.add(Restrictor.eq("userId", 'wangx'));
 * cq.add(Restrictor.eq("password", 'z')); } <br>
 * 查询： find(hql, new String[]{"wangx", "z"}); find(c);
 * 
 * <p>
 * 例子3，查询实体（Named Parameter，别名）：<br>
 * hql: from User u where u.userId=:userId and u.password=:password; <br>
 * Criteria:{ 
 * <code>Criteria cq = new Criteria(User.class, "u", true); cq.add(Restrictor.eq("userId", 'wangx'));
 * cq.add(Restrictor.eq("password", 'z')); } </code><br>
 * 查询： find(hql, new String[]{"wangx", "z"}); find(c);
 * 
 * <p>
 * 例子4，逻辑或查询：<br>
 * hql:from SysOrganization where organizationType='3' or password='4';
 * Criteria:{ Criteria c = new Criteria(SysOrganization.class);
 * c.add(Restrictor.or(Restrictor.eq("organizationType", "4"),
 * Restrictor.eq("organizationType", "3")) ); } <br>
 * 查询：find(c);
 * 
 * @author Hilbert Wang
 * 
 * @since 2010-7-2
 * 
 */
public class Criteria implements ICriteria {
	
	/** 查询语句中 属性值的占位符 e.g. name=? and pwd=? */
	static final String VALUE_PLACEHOLDER = "?";
	static final String VALUE_NAMED_SIGN = ":";

	private String select = "*";
	private StringBuilder queryString;
	private StringBuilder orderBy;
	private StringBuilder limit;
	
	private List<Object> values = new ArrayList<Object>();
	
	private Map<String, Object> namedValues = new HashMap<>();
	
	/** is sql or hql */
	private boolean sql = false;
	
	/**
	 * use named parameters or JPA-style positional parameters
	 */
	private boolean namedParam = false;
	
	private String alias;
	
	private static final String restriction_isNull = Restrictors.getRestriction(RestrictType.isNull);
	private static final String restriction_isNotNull = Restrictors.getRestriction(RestrictType.isNotNull);

	/**
	 * 查询映射实体
	 * @param entityClass 实体类型
	 */
	public Criteria(Class<?> entityClass) {
		queryString = new StringBuilder().append(entityClass.getSimpleName()).append(" where 1=1");
	}
	
	public Criteria(Class<?> entityClass, String alias) {
		this.alias = alias;
		queryString = new StringBuilder().append(entityClass.getSimpleName()).append(" ").append(alias).append(" where 1=1");
	}
	
	public Criteria(Class<?> entityClass, String alias, boolean namedParam) {
		this(entityClass, alias);
		this.namedParam = namedParam;
	}

	/**
	 * 直接查询数据库
	 * @param table 查询的表名
	 */
	public Criteria(String table) {
		sql = true;
		queryString = new StringBuilder().append(table).append(" where 1=1");
	}
	
	public Criteria(String table, boolean namedParam) {
		sql = true;
		this.namedParam = namedParam;
		queryString = new StringBuilder().append(table).append(" where 1=1");
	}
	
	public Criteria(String table, String alias) {
		Asserts.notBlank(alias);
		this.alias = alias;
		sql = true;
		queryString = new StringBuilder().append(table).append(" ").append(alias).append(" where 1=1");
	}
	
	/**
	 * Ignore when { null, empty String, 0 Long }
	 * @param restrictor Restrictor
	 * @return criteria
	 */
	@Override
	public ICriteria addIfNotBlank(Restrictor restrictor) {
		if(restrictor instanceof SimpleRestrictor) {
			Object val = ((SimpleRestrictor) restrictor).getValue();
			if(val == null) return this;
			
			if(val instanceof String) {
				String valStr = (String) val;
				if(valStr.trim().length() == 0) return this;
			} else if (val instanceof Long) {
				Long valLong = (Long) val;
				if(valLong == 0) return this;
			}  else if (val instanceof Integer) {
				Integer valInteger = (Integer) val;
				if(valInteger == 0) return this;
			}
		}
		return this.addRestrictor(restrictor);
	}

	public ICriteria addRestrictor(Restrictor criterion) {
		if(criterion == null) return this;
		queryString.append(" and ");
		if (criterion instanceof SimpleRestrictor)
			addSimpleExpression(criterion);
		else if(criterion instanceof ExpressionRestrictor)
			addExpressionCriterion(criterion);
		else if (criterion instanceof LogicRestrictor)
			addLogicalExpression(criterion);
		return this;
	}

	@Override
	public ICriteria orderBy(String orderby) {
		if(orderby == null || orderby.trim().length() == 0) return this;
		orderBy = new StringBuilder();
		if(sql) {
			// order by shopName ASC
			String[] arr = orderby.trim().split(" +");
			if(arr.length == 2) {
				String orderField = arr[0].trim();
				String sort = arr[1].trim();
				orderby = CriteriaUtils.propToColumn(orderField) + " " + sort;
			} else {
				orderby = CriteriaUtils.propToColumn(arr[0].trim());
			}
		}
		orderBy.append(" order by ");
		if (this.hasAlias()) {
			orderBy.append(this.alias).append(".");
		}
		orderBy.append(orderby);
		return this;
	}
	
	@Override
	public ICriteria limit(int start, int rows) {
		limit = new StringBuilder();
		limit.append(" limit ").append(start).append(",").append(rows);
		return this;
	}

	/*
	 * 添加简单运算表达式
	 */
	private ICriteria addSimpleExpression(Restrictor criterion) {
		SimpleRestrictor e = (SimpleRestrictor) criterion;
		String restriction = e.getRestriction();
		if (this.hasAlias()) {
			queryString.append(this.alias).append(".");
		}
		queryString.append(e.getProperty());
		queryString.append(restriction);
		if (restriction.equals(restriction_isNull) || restriction.equals(restriction_isNotNull)) {
			return this;
		}
		
		if (this.namedParam) {
			queryString.append(VALUE_NAMED_SIGN).append(e.getProperty());
			namedValues.put(e.getProperty().trim(), e.getValue());
		} else {
			queryString.append(VALUE_PLACEHOLDER);
			values.add(e.getValue());
		}
		return this;
	}
	
	// Like <code>SimpleExpression</code>. But not use <code>VALUE_PLACEHOLDER</code>
	private ICriteria addExpressionCriterion(Restrictor criterion) {
		ExpressionRestrictor e = (ExpressionRestrictor) criterion;
		if (this.hasAlias()) {
			queryString.append(this.alias).append(".");
		}
		queryString.append(e.getProperty());
		queryString.append(e.getRestriction());
		queryString.append(e.getExpression());
		return this;
	}

	/*
	 * 添加逻辑运算表达式
	 */
	private ICriteria addLogicalExpression(Restrictor criterion) {
		LogicRestrictor e = (LogicRestrictor) criterion;
		Restrictor ic1 = e.getLeft();
		Restrictor ic2 = e.getRight();

		boolean isOr = RestrictType.or.toString().equals(e.getRestriction());
		if (isOr)// 如果是 or 运算，用小括号扩上
			queryString.append("(");

		// 添加左侧表达式
		if (ic1 instanceof SimpleRestrictor)
			addSimpleExpression(ic1);
		else if (ic1 instanceof LogicRestrictor)
			addLogicalExpression(ic1);

		// 添加逻辑运算符
		queryString.append(" ").append(e.getRestriction()).append(" ");

		// 添加右侧表达式
		if (ic2 instanceof SimpleRestrictor)
			addSimpleExpression(ic2);
		else if (ic2 instanceof LogicRestrictor)
			addLogicalExpression(ic2);

		if (isOr)// 如果是 or 运算，用小括号扩上
			queryString.append(")");

		return this;
	}
	
	@Override
	public ICriteria setSelectColumns(String select) {
		this.select = select;
		return this;
	}

	public String getQueryString() {
		StringBuilder qs = new StringBuilder();
		if (sql) {
			qs.append("select ").append(select).append(" from ").append(queryString);
		} else {
			qs.append("from ").append(queryString.toString());
		}
		if(this.orderBy != null)
			qs.append(this.orderBy);
		if(this.limit != null)
			qs.append(this.limit);
		return qs.toString();
	}
	
	@Override
	public String getCountString() {
		return "select count(*) from " + queryString.toString();
	}
	
	@Override
	public String getDeleteString() {
		return "delete from " + queryString.toString();
	}

	public Object[] getValues() {
		return values.toArray();
	}
	
	@Override
	public Map<String, Object> getNamedValues() {
		return namedValues;
	}

	public String getOrderBy() {
		if(orderBy == null) return null;
		return orderBy.toString();
	}

	@Override
	public String getAlias() {
		return this.alias;
	}

	public boolean hasAlias() {
		return StringUtils.isNotBlank(alias);
	}
	
	@Override
	public boolean isNamedParam() {
		return namedParam;
	}
	
	@Override
	public String toString() {
		return this.getQueryString();
	}

}
