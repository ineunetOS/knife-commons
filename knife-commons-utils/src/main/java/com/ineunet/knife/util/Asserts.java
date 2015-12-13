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

import java.util.Collection;

/**
 * 
 * @author Hilbert Wang
 * 
 * @since 1.0.2
 *
 */
public abstract class Asserts {
	
	/**
	 * @param object
	 * @param message
	 * @since 2.2.0
	 */
	public static void not(boolean object, String message) {
		if(!object)
			throw new IllegalArgumentException(message);
	}
	
	/**
	 * @param object
	 * @param message
	 * @since 2.2.0
	 */
	public static void not(boolean object) {
		not(object, "[Assertion failed] - this argument cannot be false.");
	}
	
	public static void notNull(Object object, String message) {
		if(object == null)
			throw new IllegalArgumentException(message);
	}
	
	public static void notNull(Object object) {
		notNull(object, "[Assertion failed] - this argument cannot be null.");
	}
	
	public static void notEmpty(Collection<Object> collections, String message) {
		if(collections == null || collections.isEmpty())
			throw new IllegalArgumentException(message); 
	}
	
	public static void notEmpty(Collection<Object> collections) {
		if(collections == null || collections.isEmpty())
			throw new IllegalArgumentException("[Assertion failed] - this argument cannot be empty or null."); 
	}
	
	public static void notEmpty(Object[] array, String message) {
		if(array == null || array.length == 0)
			throw new IllegalArgumentException(message); 
	}
	
	public static void notEmpty(Object[] array) {
		notEmpty(array, "[Assertion failed] - this array cannot be empty or null.");
	}
	
	public static void notBlank(Long l, String message) {
		if(l == null || l == 0)
			throw new IllegalArgumentException(message);
	}
	
	public static void notBlank(Long l) {
		notBlank(l, "[Assertion failed] - this long cannot be null or zero.");
	}
	
	public static void notBlank(String s, String message) {
		if(s == null || s.trim().length() == 0)
			throw new IllegalArgumentException(message);
	}
	
	public static void notBlank(String s) {
		notBlank(s, "[Assertion failed] - this string cannot be null or blank.");
	}
	
	public static<X> void notContains(Collection<X> c, X elem, String message) {
		if(c.contains(elem))
			throw new IllegalArgumentException(message);
	}
	
	public static<X> void notContains(Collection<X> c, X elem) {
		notContains(c, elem, "[Assertion failed] - this collection cannot contains same element.");
	}

}
