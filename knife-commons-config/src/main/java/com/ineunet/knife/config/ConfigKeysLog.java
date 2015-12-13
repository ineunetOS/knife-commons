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
 * @author Hilbert Wang
 * 
 */
public abstract class ConfigKeysLog {
	
	public static final String mgtlog = "mgtlog";
	public static final String mgtlogdir = "mgtlogdir";
	public static final String syslog = "syslog";
	
	/**
	 * Key name of DataExpression log
	 * @since 2.0.2
	 */
	public static final String data_exp_log = "data_exp_log";
	
	/**
	 * Key name of sql log
	 * @since 2.0.2
	 */
	public static final String sqllog = "sqllog";
	
	
	public static final String store_type = "store_type";
	public static final String store_dir = "store_dir";
	public static final String log_db = "log_db";

}
