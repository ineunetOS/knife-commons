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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Hilbert
 * @since 1.0.0
 *
 */
public class SortedMap<K, V> implements ISortedMap<K, V> {

	private Map<K, V> map = new HashMap<K, V>();
	private List<K> keys = new ArrayList<K>(4);

	public void put(K key, V value) {
		map.put(key, value);
		keys.add(key);
	}

	public V get(K key) {
		return map.get(key);
	}

	public List<K> keyList() {
		return keys;
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}

	@Override
	public boolean containsKey(K key) {
		return keys.contains(key);
	}

	@Override
	public boolean containsValue(V value) {
		return map.containsValue(value);
	}

	@Override
	public void remove(K key) {
		keys.remove(key);
		map.remove(key);
	}

	@Override
	public int size() {
		return keys.size();
	}

	@Override
	public Map<K, V> asMap() {
		return this.map;
	}

}
