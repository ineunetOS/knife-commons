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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Hilbert Wang
 * @since 1.0.0
 * Created on 2015-4-12
 */
public abstract class CloneUtils {

	@SuppressWarnings("unchecked")
	public static<K, V> Map<K, V> cloneMap(Map<K, V> map) {
		if (map == null) return null;
		Map<K, V> clone;
		if (map instanceof Cloneable) {
			clone = (Map<K, V>) ((HashMap<K, V>) map).clone();
		} else {
			LinkedHashMap<K,V> temp = new LinkedHashMap<K,V>();
			temp.putAll(map);
			clone = (Map<K, V>) temp.clone();
			temp.clear();
			temp = null;
		}
		return clone;
	}
	
}
