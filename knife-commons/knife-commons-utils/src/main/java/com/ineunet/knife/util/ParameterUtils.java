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
package com.ineunet.knife.util;

/**
 * 
 * @author hilbert.wang@hotmail.com
 * @since 1.0.2
 */
public abstract class ParameterUtils {
	
	/**
	 * 将字符串转换成Long
	 * @param param number string
	 * @return long or null if parameter is null or empty.
	 */
	public static Long parseLong(String param) {
		try {
			if (!StringUtils.isBlank(param)) {
				return Long.valueOf(param);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Parameter " + param + " is not a number.");
		}
		return null;
	}
	
	/**
	 * 将字符串转换成Integer
	 * @param param number string
	 * @return long or null if parameter is null or empty.
	 */
	public static Integer parseInt(String param) {
		try {
			if (!StringUtils.isBlank(param)) {
				return Integer.valueOf(param);
			}
		} catch (Exception e) {
			throw new IllegalArgumentException("Parameter " + param + " is not a number.");
		}
		return null;
	}
	
	/**
	 * 将整数转换成Boolean，0 false， 其它 true
	 * @param param number string
	 * @return boolean or null if parameter is null.
	 */
	public static Boolean parseBoolean(Integer param) {
		if (param == null) return null;
		if (param == 0) return false;
		return true;
	}
	
	/**
	 * 将整数转换成Boolean，0 false， 其它 true
	 * @param param number string
	 * @return false if parameter is null or empty.
	 */
	public static boolean parseBool(Integer param) {
		if (param == null) return false;
		if (param == 0) return false;
		return true;
	}

}
