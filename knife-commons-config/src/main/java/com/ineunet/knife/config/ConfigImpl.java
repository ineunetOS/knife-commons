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

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Hilbert
 *
 */
public class ConfigImpl implements IConfig {

	private static final Logger log = LoggerFactory.getLogger(ConfigImpl.class);
	private final Properties properties = new Properties();

	public ConfigImpl(String propFile) {
		try {
			InputStream in = this.getClass().getClassLoader().getResourceAsStream(propFile);
			if (in != null)
				properties.load(in);
		} catch (IOException e) {
			log.error("Wrong config file name.");
		}
	}

	@Override
	public Set<String> keys() {
		Set<String> keys = new HashSet<String>();
		Enumeration<Object> keyEnum = properties.keys();
		while (keyEnum.hasMoreElements()) {
			keys.add((String) keyEnum.nextElement());
		}
		return keys;
	}

	@Override
	public Collection<Object> values() {
		return properties.values();
	}

	@Override
	public Boolean getBoolean(String name) {
		Object v = properties.get(name);
		if (v == null)
			return null;
		String sv = String.valueOf(v);
		String svTrim = sv.trim();
		if (svTrim.length() == 0)
			return null;
		return Boolean.valueOf(svTrim);
	}

	@Override
	public String getString(String name) {
		Object v = properties.get(name);
		if (v == null)
			return null;
		return String.valueOf(v);
	}
	
	@Override
	public Integer getInteger(String name) {
		Object v = properties.get(name);
		if (v == null)
			return null;
		String sv = String.valueOf(v);
		String svTrim = sv.trim();
		if (svTrim.length() == 0)
			return null;
		return Integer.valueOf(svTrim);
	}

	@Override
	public boolean get(String name, boolean defaultValue) {
		Boolean v = this.getBoolean(name);
		if (v == null)
			return defaultValue;
		return v;
	}

	@Override
	public String get(String name, String defaultValue) {
		String v = this.getString(name);
		if (v == null || v.trim().length() == 0)
			return defaultValue;
		return v;
	}

	@Override
	public int get(String name, int defaultValue) {
		String v = this.getString(name);
		if (v == null || v.trim().length() == 0)
			return defaultValue;
		return Integer.parseInt(v);
	}

}
