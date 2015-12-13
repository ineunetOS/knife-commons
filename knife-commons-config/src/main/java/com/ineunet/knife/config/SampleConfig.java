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
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * A template of <code>IConfig</code> use <code>ConcurrentHashMap</code>
 * 
 * @author Hilbert
 * 
 */
public class SampleConfig<K, V> implements IConfig {
	
	private Map<K, V> keyValues = new ConcurrentHashMap<K, V>();

	@Override
	public Boolean getBoolean(String name) {
		return (Boolean) keyValues.get(name);
	}

	@Override
	public String getString(String name) {
		return (String) keyValues.get(name);
	}
	
	@Override
	public Integer getInteger(String name) {
		return (Integer) keyValues.get(name);
	}

	@Override
	public boolean get(String name, boolean defaultValue) {
		if(this.getBoolean(name) != null)
			return this.getBoolean(name);
		return defaultValue;
	}

	@Override
	public String get(String name, String defaultValue) {
		String v = this.getString(name);
		if(v == null || v.trim().length() == 0)
			return defaultValue;
		return v;
	}

	@Override
	public int get(String name, int defaultValue) {
		String v = this.getString(name);
		if(v == null || v.trim().length() == 0)
			return defaultValue;
		return Integer.parseInt(v);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<String> keys() {
		
		return ((Set<String>) keyValues.keySet());
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Object> values() {
		return ((Collection<Object>) keyValues.values());
	}
	
	public V put(K key, V value) {
		return keyValues.put(key, value);
	}

}
