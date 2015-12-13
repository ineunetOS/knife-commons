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
public abstract class ConfigKeysDB {

	public static final String mongo_db_use = "mongo.db.use";
	public static final String mongo_db_addr = "mongo.db.addr";
	public static final String mongo_db_defaultdb = "mongo.db.defaultdb";
	
	/**
	 * @since 2.2.0
	 */
	public static final String use_mycat = "use_mycat";
	
}
