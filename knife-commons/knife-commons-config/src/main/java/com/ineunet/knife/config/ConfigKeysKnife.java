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
 * @author Hilbert
 * 
 */
public abstract class ConfigKeysKnife {
	
	public static final String multi_tenant = "multi_tenant";
	public static final String allow_tenant_login = "allow_tenant_login";
	public static final String devMode = "devMode";
	public static final String cacheType = "cacheType";
	public static final String valid = "valid";
	public static final String serial = "serial";
	public static final String charset = "charset";
	public static final String servlet_mapping = "servlet_mapping";
	public static final String menu_type = "menu_type";
	
	// *********** db ************ //
	public static final String db_type = "db_type";
	public static final String use_mycat = "use_mycat";
	
	// email
	public static final String default_sender_account = "default_sender_account";
	public static final String default_sender_password = "default_sender_password";
	
	// deploy type, distributed or not
	public static final String deploy_type = "deploy_type";
	
	// db, dir, mongodb, ftpserver
	public static final String upload_store_type = "upload_store_type";
	
	// *********** log ************ //
	public static final String syslog = "syslog";
	
}
