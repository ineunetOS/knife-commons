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
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Hilbert Wang
 * 
 * @since knife 1.0.0
 *
 */
public class WebValidator implements IValidator {

	private StringBuilder msg;
	private boolean success = true;
	private Map<Object, Object> params;

	public WebValidator() {
		msg = new StringBuilder();
	}

	public WebValidator(boolean success, String msg) {
		this.success = success;
		this.msg = new StringBuilder(msg);
	}

	// Created on 2015-3-6
	public Object getParam(Object key) {
		if (params == null) return null;
		return params.get(key);
	}
	
	public Object setParam(Object key, Object value) {
		if (params == null) 
			params = new HashMap<Object, Object>();
		return params.put(key, value);
	}
	
	/**
	 * Only append Error. Not append validator if success.
	 * @return <code>this</code>
	 */
	public IValidator appendError(IValidator validator) {
		if (validator == null) return this;
		if (! (validator instanceof WebValidator) ) {
			throw new IllegalArgumentException("Must WebValidator.");
		}
		
		WebValidator valid = (WebValidator) validator;
		if (valid.isSuccess())
			return this;
		if (this.success) {
			this.msg = valid.msg;
			this.success = valid.success;
		} else {
			msg.append("<br>").append(valid.getMsg());
		}
		return this;
	}

	public IValidator notNull(String propertyTitle, Object propertyValue) {
		return this.appendError(WebValidatorRestrictor.notNull(propertyTitle, propertyValue));
	}

	public IValidator notBlank(String propertyTitle, String propertyValue) {
		return this.appendError(WebValidatorRestrictor.notBlank(propertyTitle, propertyValue));
	}
	
	/**
	 * 验证不能为纯空格. Validate not all spaces.
	 * @param propertyTitle
	 * @param propertyValue
	 * @since 2.0.1
	 */
	public IValidator notBlankSpace(String propertyTitle, String propertyValue) {
		return this.appendError(WebValidatorRestrictor.notBlankSpace(propertyTitle, propertyValue));
	}
	
	public <X> IValidator notEmpty(String propertyTitle, Collection<X> propertyValue) {
		return this.appendError(WebValidatorRestrictor.notEmpty(propertyTitle, propertyValue));
	}
	
	public IValidator notNullZero(String propertyTitle, Number propertyValue) {
		return this.appendError(WebValidatorRestrictor.notNullZero(propertyTitle, propertyValue));
	}

	public <X> IValidator notEquals(String propertyTitle, X propertyValue, X notEqualValue) {
		return this.appendError(WebValidatorRestrictor.notEquals(propertyTitle, propertyValue, notEqualValue));
	}

	/**
	 * e.g. length('name', value, 0, 20);
	 */
	public IValidator length(String propertyTitle, String propertyValue, int start, int end) {
		return this.appendError(WebValidatorRestrictor.length(propertyTitle, propertyValue, start, end));
	}
	
	public IValidator length(String propertyTitle, Number propertyValue, int start, int end) {
		return this.appendError(WebValidatorRestrictor.length(propertyTitle, propertyValue, start, end));
	}
	
	public IValidator greaterThan(String propertyTitle, Long propertyValue, Long referenceValue) {
		return this.appendError(WebValidatorRestrictor.greaterThan(propertyTitle, propertyValue, referenceValue));
	}
	
	public IValidator greaterThan(String propertyTitle, Integer propertyValue, Integer referenceValue) {
		return this.appendError(WebValidatorRestrictor.greaterThan(propertyTitle, propertyValue, referenceValue));
	}
	
	public IValidator lessThan(String propertyTitle, Long propertyValue, Long referenceValue) {
		return this.appendError(WebValidatorRestrictor.lessThan(propertyTitle, propertyValue, referenceValue));
	}
	
	public IValidator lessThan(String propertyTitle, Integer propertyValue, Integer referenceValue) {
		return this.appendError(WebValidatorRestrictor.lessThan(propertyTitle, propertyValue, referenceValue));
	}
	
	/**
	 * @since 2.0.1
	 */
	public IValidator matchTelephone(String propertyTitle, String propertyValue) {
		return this.appendError(WebValidatorRestrictor.matchTelephone(propertyTitle, propertyValue));
	}
	
	/**
	 * @since 2.0.1
	 */
	public IValidator matchMobile(String propertyTitle, String propertyValue) {
		return this.appendError(WebValidatorRestrictor.matchMobile(propertyTitle, propertyValue));
	}
	
	/**
	 * @since 2.0.1
	 */
	public IValidator matchFax(String propertyTitle, String propertyValue) {
		return this.appendError(WebValidatorRestrictor.matchFax(propertyTitle, propertyValue));
	}
	
	/**
	 * @since 2.0.1
	 */
	public IValidator matchEmail(String propertyTitle, String propertyValue) {
		return this.appendError(WebValidatorRestrictor.matchEmail(propertyTitle, propertyValue));
	}
	
	@Override
	public IValidator matchAccount(String propertyTitle, String propertyValue) {
		return this.appendError(WebValidatorRestrictor.matchAccount(propertyTitle, propertyValue));
	}

	@Override
	public IValidator matchPassword(String propertyTitle, String propertyValue) {
		return this.appendError(WebValidatorRestrictor.matchPassword(propertyTitle, propertyValue));
	}

	public String getMsg() {
		return msg.toString();
	}

	public boolean isSuccess() {
		return success;
	}

	public boolean isFailure() {
		return !success;
	}
	
	public String toString() {
		return msg.toString();
	}

}
