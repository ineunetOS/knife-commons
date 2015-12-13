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

import java.util.Map;

/**
 * @author Hilbert Wang
 */
public interface ICriteria {
	
	ICriteria addIfNotBlank(Restrictor restrictor);

	ICriteria addRestrictor(Restrictor restrictor);
	
	/**
	 * @param select such as <code>"id, name"</code>, or *
	 * @return
	 */
	ICriteria setSelectColumns(String select);
	
	String getQueryString();
	
	String getCountString();
	
	Object[] getValues();
	
	/**
	 * @since 1.0.5
	 */
	Map<String, Object> getNamedValues();
	
	ICriteria orderBy(String orderby);
	
	String getOrderBy();
	
	ICriteria limit(int start, int rows);
	
	/**
	 * @return 表别名
	 * @since 1.0.5
	 */
	String getAlias();
	
}
