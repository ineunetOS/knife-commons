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
 * @author Hilbert Wang
 * @since 1.0.0
 */
public abstract class ClassStrUtils {
	
	/**
	 * e.g. StrUtils to strUtils, str to str
	 * @param string e.g. StrUtils
	 * @return e.g. stringUtils
	 */
	public static String toFirstLower(String string) {
		int c = ((int) string.charAt(0));
		if (c >= 65 && c <=90) {
			// is upper
			char lower = (char) (((int) string.charAt(0)) + 32);
			return lower + string.substring(1);
		}
		return string;
	}
	
	/**
	 * e.g. strUtils to StrUtils, str to Str
	 * @param string e.g. strUtils
	 * @return e.g. StringUtils
	 */
	public static String toFirstUpper(String string) {
		int c = ((int) string.charAt(0));
		if (c >= 97 && c <=122) {
			// is lower
			char Upp = (char) (((int) string.charAt(0)) - 32);
			return Upp + string.substring(1);
		}
		return string;
	}
	
	/**
	 * e.g. transform 'StrUtils' to 'str_utils', 'strUtils' to 'str_utils'
	 * @param string e.g. StrUtils
	 * @return e.g. str_utils
	 */
	public static String hump2Underline(String string) {
		if (string == null) return null;
		if (string.trim().length() == 0) return "";
		string = toFirstLower(string);
		StringBuilder sb = new StringBuilder();
		char[] arr = string.toCharArray();
		for (char c : arr) {
			if (c >= 65 && c <=90) {
				c += 32;
				sb.append("_").append(String.valueOf(c).toLowerCase());
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	/**
	 * @param fieldName e.g. name
	 * @return e.g. getName
	 */
	public static String fieldToGetMethod(String fieldName) {
		return "get" + toFirstUpper(fieldName);
	}

}
