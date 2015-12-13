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
package com.ineunet.knife.util.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ineunet.knife.util.StringUtils;

/**
 * 
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015-3-19
 */
public class ValidatorUtils {
	
	/**
	 * TODO 是个0也能通过验证
	 * 前面区号，0开头后面2~3位，中间 电话号码7~8位 ，后面 分机号3~4位
	 */
	private static final String REG_TELEPHONE = "^(((0\\d{2,3})-)(\\d{7,8})(-(\\d{3,4}))|((0\\d{2,3})-)(\\d{7,8})|((0\\d{2,3}))(\\d{7,8}))?$";
	private static final String REG_MOBILE = "^1\\d{10}$";
	private static final String REG_EMAIL = "^((([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+(\\.([a-z]|\\d|[!#\\$%&'\\*\\+\\-\\/=\\?\\^_`{\\|}~]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])+)*)|((\\x22)((((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(([\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x7f]|\\x21|[\\x23-\\x5b]|[\\x5d-\\x7e]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(\\\\([\\x01-\\x09\\x0b\\x0c\\x0d-\\x7f]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF]))))*(((\\x20|\\x09)*(\\x0d\\x0a))?(\\x20|\\x09)+)?(\\x22)))@((([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|\\d|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.)+(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])|(([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])([a-z]|\\d|-|\\.|_|~|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])*([a-z]|[\\u00A0-\\uD7FF\\uF900-\\uFDCF\\uFDF0-\\uFFEF])))\\.?$";
	private static final String REG_FAX = "^(((0\\d{2,3})-)(\\d{7,8})|((0\\d{2,3}))(\\d{7,8}))?$";
	/** 账户只能包含字母,数字,_,@和. */
	private static final String REG_ACCOUNT = "^[A-Za-z0-9_@.]{0,31}$";
	/** 密码只能为1-20位字母 数字 + _ */
	private static final String REG_PASSWORD = "^[A-Za-z0-9_+]{1,20}$";
	
	public static boolean hasChineseChar(String str) {
		boolean temp = false;
		Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
		Matcher m = p.matcher(str);
		if (m.find()) {
			temp = true;
		}
		return temp;
	}

	/**
	 * 计算<tt>str</tt>长度，如果<tt>str</tt>中包含中文字符，中文字符按两个字符算
	 * @param str
	 */
	public static int length(String str) {
		if (StringUtils.isEmpty(str))
			return 0;
		str = str.replaceAll("([\u4e00-\u9fa5]|[，￥！？％＆＠＃＾。“”；《》‘’｜【】—…·＋－×、（）])", "  ");
		return str.length();
	}

	/**
	 * @param str e.g. 025-68588587
	 * @return whether is a telephone number
	 * @since 2.0.1
	 */
	public static boolean matchTelephone(String str) {
		if (StringUtils.isEmpty(str)) return false;
		return Pattern.matches(REG_TELEPHONE, str.trim());
	}
	
	/**
	 * 是否手机号
	 * @since 2.0.1
	 */
	public static boolean matchMobile(String str) {
		if (StringUtils.isEmpty(str)) return false;
		return Pattern.matches(REG_MOBILE, str.trim());
	}
	
	/**
	 * @return 是否传真号
	 * @since 2.0.1
	 */
	public static boolean matchFax(String str) {
		if (StringUtils.isEmpty(str)) return false;
		return Pattern.matches(REG_FAX, str.trim());
	}
	
	/**
	 * @return 是否email格式
	 * @since 2.0.1
	 */
	public static boolean matchEmail(String str) {
		if (StringUtils.isEmpty(str)) return false;
		return Pattern.matches(REG_EMAIL, str.trim());
	}
	
	public static boolean matchAccount(String str) {
		if (StringUtils.isBlank(str)) return false;
		return Pattern.matches(REG_ACCOUNT, str.trim());
	}
	
	public static boolean matchPassword(String str) {
		if (StringUtils.isBlank(str)) return false;
		return Pattern.matches(REG_PASSWORD, str.trim());
	}

}
