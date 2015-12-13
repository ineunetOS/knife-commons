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
package com.ineunet.knife.util.model;

/**
 * 用来传参和传返回值
 * @author Hilbert
 * @since 1.0.2
 * @param <K>
 * @param <V>
 */
public class SingleMap<K, V> {

	private K key;
	private V value;

	public SingleMap() {
	}

	public SingleMap(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static<K, V> SingleMap<K, V> newSingleMap() {
		return new SingleMap();
	}
	
	public static<K, V> SingleMap<K, V> newSingleMap(K key, V value) {
		return new SingleMap<K, V>(key, value);
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	/**
	 * @since 1.0.3
	 */
	public void put(K key, V value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SingleMap<?, ?> other = (SingleMap<?, ?>) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SingleMap [key=" + key + ", value=" + value + "]";
	}

}
