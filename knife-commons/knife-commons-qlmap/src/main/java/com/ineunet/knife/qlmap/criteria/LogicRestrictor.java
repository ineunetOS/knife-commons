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
 * 逻辑表达式javabean，用来存放一组属性，属性值，约束条件（如<code> and, or</code>）
 * @author 王旭
 * @since 2010-7
 *
 */
class LogicRestrictor implements Restrictor
{
	
	private Restrictor left;
	private Restrictor right;
	private String restriction;
	
	/**
	 * 根据属性名，属性值，约束条件构造对象
	 * @param property 属性名
	 * @param value 属性值
	 * @param restriction 约束条件
	 */
	public LogicRestrictor(Restrictor left, Restrictor right, RestrictType restriction)
	{
		this.left = left;
		this.right = right;
		this.restriction = Restrictors.getRestriction(restriction);
	}

	public Restrictor getLeft()
	{
		return left;
	}

	public Restrictor getRight()
	{
		return right;
	}

	@Override
	public String getRestriction()
	{
		return restriction;
	}

}
