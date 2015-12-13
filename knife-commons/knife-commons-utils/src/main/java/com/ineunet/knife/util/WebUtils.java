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

import javax.servlet.http.HttpServletRequest;

import com.ineunet.knife.util.StringUtils;

/**
 * 
 * @author hilbert.wang@hotmail.com
 * @since 2.2.8
 */
public abstract class WebUtils {

	public static String getParamString(HttpServletRequest request, String name) {
		return request.getParameter(name);
	}
	
	public static Long getParamLong(HttpServletRequest request, String name) {
		String s = request.getParameter(name);
		if (StringUtils.isBlank(s))
			return null;
		return Long.valueOf(s.trim());
	}

	public static long getParamLong(HttpServletRequest request, String name, int defaultValue) {
		String s = request.getParameter(name);
		if (StringUtils.isBlank(s))
			return defaultValue;
		return Long.parseLong(s.trim());
	}
	
	public static long getParamLong(HttpServletRequest request, String name, long defaultValue) {
		String s = request.getParameter(name);
		if (StringUtils.isBlank(s))
			return defaultValue;
		return Long.parseLong(s.trim());
	}
	
	public static Integer getParamInteger(HttpServletRequest request, String name) {
		String s = request.getParameter(name);
		if (StringUtils.isBlank(s))
			return null;
		return Integer.valueOf(s.trim());
	}
	
	public static int getParamInt(HttpServletRequest request, String name) {
		String s = request.getParameter(name);
		if (StringUtils.isBlank(s))
			return 0;
		return Integer.parseInt(s.trim());
	}
	
	public static int getParamInt(HttpServletRequest request, String name, int defaultValue) {
		String s = request.getParameter(name);
		if (StringUtils.isBlank(s))
			return defaultValue;
		return Integer.parseInt(s.trim());
	}
	
	public static Boolean getParamBoolean(HttpServletRequest request, String name) {
		String s = request.getParameter(name);
		if (StringUtils.isBlank(s))
			return null;
		return Boolean.valueOf(s.trim());
	}
	
}
