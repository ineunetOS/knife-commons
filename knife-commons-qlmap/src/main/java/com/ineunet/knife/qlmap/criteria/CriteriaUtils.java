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
 * 
 * @author Hilbert
 * 
 * @since 1.2.0
 *
 */
class CriteriaUtils {

	/**
	 * e.g. userName to user_name
	 * Transform field name to sql column.<br>
	 * (Not so fast.)
	 * e.g. userName to user_name
	 * @param propName propName
	 * @return prop_name
	 */
	public static String propToColumn(String propName) {
		char[] arr = propName.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(Character.isUpperCase(arr[i])) {
				String s1 = propName.substring(0, i);
				String s = "_" + Character.toLowerCase(arr[i]);
				String s2 = propName.substring(i+1);
				return propToColumn(s1 + s + s2);
			}
		}
		return propName;
	}

}
