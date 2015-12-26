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
package com.ineunet.knife.config.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author hilbert.wang@hotmail.com<br>
 * 
 */
public abstract class ConfigUtils {

	/**
	 * @param mapString
	 *            like 'onl.com=onl, offl.com=offl, ineunet.com=home'
	 * @return map of mapString configure
	 */
	public static Map<String, String> parseMapString(String mapString) {
		return parseMapString(mapString, "=", false);
	}

	/**
	 * @param mapString
	 *            like 'onl.com=onl, offl.com=offl, ineunet.com=home'
	 * @param split
	 *            e.g. '=', ':', ','
	 * @param inverse true key is key, false value is key
	 * @return map of mapString configure
	 */
	public static Map<String, String> parseMapString(String mapString, String split, boolean inverse) {
		Map<String, String> map = new HashMap<String, String>();
		String[] props = mapString.split(",");
		for (String prop : props) {
			String[] kv = prop.split(split);
			if(inverse)
				map.put(kv[1].trim(), kv[0].trim());
			else
				map.put(kv[0].trim(), kv[1].trim());
		}
		return map;
	}

}
