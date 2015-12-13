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

import java.util.Collection;

import com.ineunet.knife.util.StringUtils;


/**
 *
 * @author Hilbert Wang
 * @since knife 1.0.0
 * Created on 2015年3月8日
 */
public class WebValidatorRestrictor {

	public static WebValidator notNull(String propertyName, Object propertyValue) {
		WebValidator valid;
		if (propertyValue == null) {
			valid = new WebValidator(false, propertyName + "为必填项");
		} else {
			valid = new WebValidator(true, "");
		}
		return valid;
	}

	public static WebValidator notBlank(String propertyName, String propertyValue) {
		WebValidator valid;
		if (StringUtils.isBlank(propertyValue)) {
			valid = new WebValidator(false, propertyName + "为必填项");
		} else {
			valid = new WebValidator(true, "");
		}
		return valid;
	}

	/**
	 * 验证不能为纯空格，但是不做为空校验. Validate not all spaces.
	 * @param propertyName
	 * @param propertyValue
	 * @since 2.0.1
	 */
	public static WebValidator notBlankSpace(String propertyName, String propertyValue) {
		WebValidator valid;
		if (StringUtils.isEmpty(propertyValue) || propertyValue.trim().length() != 0) {
			valid = new WebValidator(true, "");
		} else {
			valid = new WebValidator(false, propertyName + "不能为纯空格");
		}
		return valid;
	}

	public static <X> WebValidator notEmpty(String propertyName, Collection<X> propertyValue) {
		WebValidator valid;
		if (propertyValue.isEmpty()) {
			valid = new WebValidator(false, propertyName + "为必填项");
		} else {
			valid = new WebValidator(true, "");
		}
		return valid;
	}

	public static WebValidator notNullZero(String propertyName, Number propertyValue) {
		WebValidator valid;
		if (propertyValue == null) {
			valid = new WebValidator(false, propertyName + "为必填项");
		} else if (propertyValue.longValue() == 0) {
			valid = new WebValidator(false, propertyName + "不能为0");
		} else {
			valid = new WebValidator(true, "");
		}
		return valid;
	}

	public static <X> WebValidator notEquals(String propertyName, X propertyValue, X notEqualValue) {
		if (propertyValue == null && notEqualValue == null) {
			return new WebValidator(false, propertyName + "不能等于 " + notEqualValue);
		} else if (propertyValue != null && propertyValue.equals(notEqualValue)) {
			return new WebValidator(false, propertyName + "不能等于 " + notEqualValue);
		} else {
			return new WebValidator(true, "");
		}
	}

	/**
	 * 如果包含中文字符，中文字符按两个长度计算 e.g. length('name', value, 0, 20);
	 */
	public static WebValidator length(String propertyName, String propertyValue, int start, int end) {
		WebValidator valid = new WebValidator(true, "");
		if (StringUtils.isBlank(propertyValue)) {
			return valid;
		}

		int length = ValidatorUtils.length(propertyValue);
		if (start == 0 && length > end) {
			valid = new WebValidator(false, propertyName + "长度不能超过" + end + "个字符");
		} else if (length < start || length > end) {
			StringBuilder s = new StringBuilder();
			s.append(propertyName).append("长度必须在 ").append(start).append(" 到 ").append(end).append(" 之间");
			valid = new WebValidator(false, s.toString());
		}
		return valid;
	}

	public static WebValidator length(String propertyName, Number propertyValue, int start, int end) {
		if (propertyValue == null)
			propertyValue = 0;
		String str = String.valueOf(propertyValue);
		return length(propertyName, str, start, end);
	}

	public static WebValidator greaterThan(String propertyName, Long propertyValue, Long referenceValue) {
		if (propertyValue > referenceValue) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "不能大于" + referenceValue);
	}

	public static WebValidator greaterThan(String propertyName, Integer propertyValue, Integer referenceValue) {
		if (propertyValue > referenceValue) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "不能大于" + referenceValue);
	}

	public static WebValidator lessThan(String propertyName, Long propertyValue, Long referenceValue) {
		if (propertyValue < referenceValue) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "不能小于" + referenceValue);
	}

	public static WebValidator lessThan(String propertyName, Integer propertyValue, Integer referenceValue) {
		if (propertyValue < referenceValue) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "不能小于" + referenceValue);
	}

	public static WebValidator hasNotChinese(String propertyName, String propertyValue) {
		if (ValidatorUtils.hasChineseChar(propertyValue)) {
			return new WebValidator(false, propertyName + "不能包含中文字符");
		}
		return new WebValidator(true, "");
	}
	
	/**
	 * @since 2.0.1
	 */
	public static WebValidator matchTelephone(String propertyName, String propertyValue) {
		if (StringUtils.isBlank(propertyValue)) {
			return new WebValidator(true, "");
		}
		if (ValidatorUtils.matchTelephone(propertyValue)) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "不符合中国固定电话格式");
	}
	
	/**
	 * @since 2.0.1
	 */
	public static WebValidator matchMobile(String propertyName, String propertyValue) {
		if (StringUtils.isBlank(propertyValue)) {
			return new WebValidator(true, "");
		}
		if (ValidatorUtils.matchMobile(propertyValue)) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "不符合中国手机号码格式");
	}
	
	/**
	 * @since 2.0.1
	 */
	public static WebValidator matchFax(String propertyName, String propertyValue) {
		if (StringUtils.isBlank(propertyValue)) {
			return new WebValidator(true, "");
		}
		if (ValidatorUtils.matchFax(propertyValue)) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "不符合中国传真格式");
	}
	
	/**
	 * @since 2.0.1
	 */
	public static WebValidator matchEmail(String propertyName, String propertyValue) {
		if (StringUtils.isBlank(propertyValue)) {
			return new WebValidator(true, "");
		}
		if (ValidatorUtils.matchEmail(propertyValue)) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "不符合email格式");
	}
	
	/**
	 * @since 2.0.1
	 */
	public static WebValidator matchAccount(String propertyName, String propertyValue) {
		if (StringUtils.isBlank(propertyValue)) {
			return new WebValidator(false, propertyName + "为必填项");
		}
		if (ValidatorUtils.matchAccount(propertyValue)) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "包含非法字符");
	}
	
	/**
	 * @since 2.0.1
	 */
	public static WebValidator matchPassword(String propertyName, String propertyValue) {
		if (ValidatorUtils.matchPassword(propertyValue)) {
			return new WebValidator(true, "");
		}
		return new WebValidator(false, propertyName + "密码中包含非法字符");
	}

}
