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

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author hilbert.wang@hotmail.com<br>
 */
public class ConfigFactory {
	private static final Logger logger = LoggerFactory.getLogger(ConfigFactory.class);
	private static IConfig knife;
	private static final Map<String, IConfig> configMap = new HashMap<String, IConfig>();
	private static String propertiesDir = "";
	
	static {
		init();
	}
	
	private static void init() {
		try {
			knife = new ConfigImpl(propertiesDir + "knife.properties");
			configMap.clear();
			configMap.put(ConfigType.knife.getValue(), knife);
		} catch (Exception e) {
			logger.error("property files wrong!");
		}
	}
	
	/**
	 * 设置目录，默认是在classpath根目录
	 * @param propertiesDir 目录路径
	 * @since 1.0.3
	 */
	public static void setPropertiesDir(String propertiesDir) {
		if (propertiesDir == null)
			propertiesDir = "";
		propertiesDir = propertiesDir.trim();
		if (!propertiesDir.endsWith("/"))
			propertiesDir += "/";
		ConfigFactory.propertiesDir = propertiesDir;
		init();
	}

	public static IConfig getKnifeConfig() {
		return knife;
	}

	public static IConfig getConfig(String propFile) {
		IConfig c = configMap.get(propFile);
		if (c == null) {
			c = new ConfigImpl(propertiesDir + propFile + ".properties");
			configMap.put(propFile, c);
		}
		return c;
	}
	
	/**
	 * @param propFile 配置文件类型
	 * @return IConfig实例
	 */
	public static IConfig getConfig(ConfigType propFile) {
		return getConfig(propFile.getValue());
	}

}
