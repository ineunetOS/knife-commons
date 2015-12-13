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

/**
 * 
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015-3-19
 */
public interface IValidator {

	/**
	 * Not append success message. Only append failure message.
	 * @param valid
	 * @return
	 */
	IValidator appendError(IValidator valid);
	
	IValidator notNull(String propertyTitle, Object propertyValue);
	
	IValidator notBlank(String propertyTitle, String propertyValue);
	
	/**
	 * 验证不能为纯空格. Validate not all spaces.
	 * @param propertyTitle
	 * @param propertyValue
	 * @since 2.0.1
	 */
	IValidator notBlankSpace(String propertyTitle, String propertyValue);
	
	<X> IValidator notEmpty(String propertyTitle, Collection<X> propertyValue);
	
	IValidator notNullZero(String propertyTitle, Number propertyValue);
	
	<X> IValidator notEquals(String propertyTitle, X propertyValue, X notEqualValue);
	
	/**
	 * e.g. length('name', value, 0, 20);
	 */
	IValidator length(String propertyTitle, String propertyValue, int start, int end);
	
	IValidator length(String propertyTitle, Number propertyValue, int start, int end);
	
	IValidator greaterThan(String propertyTitle, Long propertyValue, Long referenceValue);
	
	IValidator greaterThan(String propertyTitle, Integer propertyValue, Integer referenceValue);
	
	IValidator lessThan(String propertyTitle, Long propertyValue, Long referenceValue);
	
	IValidator lessThan(String propertyTitle, Integer propertyValue, Integer referenceValue);
	
	IValidator matchTelephone(String propertyTitle, String propertyValue);
	
	IValidator matchMobile(String propertyTitle, String propertyValue);
	
	IValidator matchFax(String propertyTitle, String propertyValue);
	
	IValidator matchEmail(String propertyTitle, String propertyValue);
	
	IValidator matchAccount(String propertyTitle, String propertyValue);
	
	IValidator matchPassword(String propertyTitle, String propertyValue);
	
	String getMsg();
	
	boolean isSuccess();
	
	boolean isFailure();
}
