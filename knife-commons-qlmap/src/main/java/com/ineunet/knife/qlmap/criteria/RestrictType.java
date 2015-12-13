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
 * 约束条件枚举
 * @author 王旭
 * @since 2010-7-2
 *
 */
public enum RestrictType {
	/** 等于 <code>=</code> */
	eq,

	/** 不等于 <code>!=</code> */
	iEq,

	/** 小于 <code>&lt</code> */
	less,

	/** 大于 <code>&gt</code> */
	more,

	/** 小于等于 <code>&lt=</code> */
	lessEq,

	/** 大于等于 <code>&gt=</code> */
	moreEq,

	like, iLike, not, isNull, isNotNull,

	and, or,

	/** @since 1.2.0 */
	in
}
