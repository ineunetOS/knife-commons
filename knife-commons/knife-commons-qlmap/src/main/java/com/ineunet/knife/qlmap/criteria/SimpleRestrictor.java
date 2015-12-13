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

/**
 * 简单表达式javabean，用来存放一组属性，属性值，约束条件（如<code> &gt, &lt, like, =</code>）
 * 
 * @author 王旭
 * 
 * @since 2010-7
 *
 */
class SimpleRestrictor implements Restrictor {

	private String property;
	private Object value;
	private String restriction;

	/**
	 * 根据属性名，属性值，约束条件构造对象
	 * 
	 * @param property 属性名
	 * @param value 属性值
	 * @param restriction 约束条件
	 */
	public SimpleRestrictor(String property, Object value, RestrictType restriction) {
		this.property = property;
		this.value = value;
		this.restriction = Restrictors.getRestriction(restriction);
	}

	public String getProperty() {
		return property;
	}

	public Object getValue() {
		return value;
	}

	@Override
	public String getRestriction() {
		return restriction;
	}

}
