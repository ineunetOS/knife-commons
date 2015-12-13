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
package com.ineunet.knife.config;

import java.util.Collection;
import java.util.Set;

/**
 * 
 * @author Hilbert
 * 
 * @since 1.0.0
 *
 */
public interface IConfig {
	
	Boolean getBoolean(String name);
	String getString(String name);
	Integer getInteger(String name);
	
	boolean get(String name, boolean defaultValue);
	String get(String name, String defaultValue);
	
	/**
	 * @since 1.0.5
	 * 
	 * @param name
	 * @param defaultValue
	 * @return
	 */
	int get(String name, int defaultValue);

	Set<String> keys();

	Collection<Object> values();
	
}
