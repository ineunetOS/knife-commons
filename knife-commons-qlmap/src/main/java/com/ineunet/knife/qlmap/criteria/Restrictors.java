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

import java.util.List;

import com.ineunet.knife.util.collect.ISimpleMap;
import com.ineunet.knife.util.collect.SortedMap;

/**
 * 约束条件操作静态工厂，包括等于，不等于，大于，小于等@see {@link RestrictType}
 * <p>
 * 
 * 具体操作还包括 and , or等
 * 
 * @author 王旭
 * 
 * @since 2010-7-2
 * 
 */
public class Restrictors {

	/**
	 * 对两个ICriterion进行 "逻辑与" 合并
	 */
	public static Restrictor and(Restrictor c1, Restrictor c2) {
		return new LogicRestrictor(c1, c2, RestrictType.and);
	}

	/**
	 * 对两个ICriterion进行 "逻辑或" 合并
	 */
	public static Restrictor or(Restrictor c1, Restrictor c2) {
		return new LogicRestrictor(c1, c2, RestrictType.or);
	}

	/**
	 * 按照值匹配某个属性
	 * 
	 * @param property
	 * @param value
	 * @return
	 */
	public static Restrictor eq(String property, Object value) {
		return new SimpleRestrictor(property, value, RestrictType.eq);
	}

	public static Restrictor iEq(String property, Object value) {
		return new SimpleRestrictor(property, value, RestrictType.iEq);
	}
	
	public static Restrictor isNull(String property) {
		return new SimpleRestrictor(property, null, RestrictType.isNull);
	}
	
	public static Restrictor isNotNull(String property) {
		return new SimpleRestrictor(property, null, RestrictType.isNotNull);
	}

	public static Restrictor less(String property, Object value) {
		return new SimpleRestrictor(property, value, RestrictType.less);
	}

	public static Restrictor more(String property, Object value) {
		return new SimpleRestrictor(property, value, RestrictType.more);
	}

	public static Restrictor lessEq(String property, Object value) {
		return new SimpleRestrictor(property, value, RestrictType.lessEq);
	}

	public static Restrictor moreEq(String property, Object value) {
		return new SimpleRestrictor(property, value, RestrictType.moreEq);
	}

	public static Restrictor like(String property, String value) {
		return new SimpleRestrictor(property, value, RestrictType.like);
	}
	
	public static Restrictor likeNotBlank(String property, String value) {
		if(value == null) throw new IllegalArgumentException();
		String val = value.replaceAll("%", "");
		if(val.trim().length() == 0) return null;
		return like(property, value);
	}

	public static Restrictor iLike(String property, String value) {
		return new SimpleRestrictor(property, value, RestrictType.iLike);
	}
	
	public static Restrictor iLikeNotBlank(String property, String value) {
		if(value == null) throw new IllegalArgumentException();
		String val = value.replaceAll("%", "");
		if(val.trim().length() == 0) return null;
		return iLike(property, value);
	}
	
	public static Restrictor match(String property, Object value, RestrictType type) {
		return new SimpleRestrictor(property, value, type);
	}

	/**
	 * @param property
	 * @param nested
	 *            nested selection e.g. (select id from shop where shop_name
	 *            like '%ads%')
	 * @return
	 */
	public static Restrictor in(String property, String nested) {
		return new ExpressionRestrictor(property, nested, RestrictType.in);
	}

	private static final ISimpleMap<RestrictType, String> RESTRICTION_NAME = new SortedMap<RestrictType, String>();
	static {
		RESTRICTION_NAME.put(RestrictType.eq, "=");
		RESTRICTION_NAME.put(RestrictType.iEq, "!=");
		RESTRICTION_NAME.put(RestrictType.less, "<");
		RESTRICTION_NAME.put(RestrictType.more, ">");
		RESTRICTION_NAME.put(RestrictType.lessEq, "<=");
		RESTRICTION_NAME.put(RestrictType.moreEq, ">=");
		RESTRICTION_NAME.put(RestrictType.like, " like ");
		RESTRICTION_NAME.put(RestrictType.iLike, " not like ");
		RESTRICTION_NAME.put(RestrictType.not, "not");
		RESTRICTION_NAME.put(RestrictType.in, " in ");

		RESTRICTION_NAME.put(RestrictType.isNull, " is null");
		RESTRICTION_NAME.put(RestrictType.isNotNull, " is not null");
		RESTRICTION_NAME.put(RestrictType.and, "and");
		RESTRICTION_NAME.put(RestrictType.or, "or");
	}
	
	/**
	 * @since 1.2.4
	 */
	public static List<RestrictType> getRestricts() {
		return (List<RestrictType>) RESTRICTION_NAME.keys();
	}

	public static final String getRestriction(RestrictType type) {
		return RESTRICTION_NAME.get(type);
	}

}
