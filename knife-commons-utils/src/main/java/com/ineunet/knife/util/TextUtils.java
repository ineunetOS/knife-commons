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
 * Created on 2015-9-11
 */
public abstract class TextUtils {

	/**
	 * 将字符串内容替换成星号.<br>
	 * Replace to asterisk.
	 * @param str e.g. 123456
	 * @param keepSize e.g. 4
	 * @param keepStart e.g. false
	 * @return e.g. **3456
	 */
	public static String asterisked(String str, int keepSize, boolean keepStart) {
		if (StringUtils.isBlank(str)) return "";
		
		int length = str.length();
		if (length < keepSize) return str;
		if (keepSize < 1) return getAsterisks(length);
		
		int notKeepSize = length - keepSize;
		String keep;
		if (keepStart) {
			keep = str.substring(0, keepSize);
			return keep + getAsterisks(notKeepSize);
		} else {
			keep = str.substring(notKeepSize);
			return getAsterisks(notKeepSize) + keep;
		}
	}
	
	/**
	 * 生成长度为<tt>length</tt>的星号字符串。
	 * @param length e.g. 4
	 * @return e.g. <code>****</code>
	 */
	public static String getAsterisks(int length) {
		if (length < 1) return "";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			sb.append("*");
		}
		return sb.toString();
	}
	
	/**
	 * 在 <tt>text</tt>两边加上英文双引号，不进行trim以及任何处理<br>
	 * 如果<tt>text == null</tt>，返回 <tt>"null"</tt>
	 * @param text
	 * @since 1.0.3
	 */
	public static String addDoubleQuotes(String text) {
		return "\"" + text + "\"";
	}
	
	/**
	 * 如果 <tt>text</tt>没有双引号括起来，就两边加上英文双引号<br>
	 * @see {@link #addDoubleQuotes(String)}
	 * @param text
	 * @since 1.0.3
	 */
	public static String addDoubleQuotesIfNo(String text) {
		if (text == null)
			return "\"null\"";
		
		String trim = text.trim();
		if (trim.startsWith("\"") && trim.endsWith("\""))
			return text;
		return addDoubleQuotes(text);
	}
	
}
