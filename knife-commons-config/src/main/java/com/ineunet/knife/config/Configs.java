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

/**
 * 
 * @author hilbert.wang@hotmail.com<br>
 * 
 */
public class Configs {
	
	public static final String charset_utf8 = "UTF-8";
	
	public static boolean isDevMode() {
		return ConfigFactory.getKnifeConfig().get(ConfigKeysKnife.devMode, false);
	}
	
	/**
	 * @return db type of sys-manager
	 */
	public static String getSysDBType() {
		return ConfigFactory.getKnifeConfig().get("db_type", "mysql");
	}
	
	public static boolean isMySql() {
		if ("mysql".equals(getSysDBType())) {
			return true;
		}
		return false;
	}
	
	public static boolean isOracle() {
		if ("oracle".equals(getSysDBType())) {
			return true;
		}
		return false;
	}
	
	public static boolean mgtlog() {
		return ConfigFactory.getKnifeConfig().get(ConfigKeysLog.mgtlog, false);
	}
	
	public static boolean syslog() {
		return ConfigFactory.getKnifeConfig().get(ConfigKeysLog.syslog, true);
	}
	
	public static String getCharset() {
		return ConfigFactory.getKnifeConfig().get(ConfigKeysKnife.charset, charset_utf8);
	}

}
