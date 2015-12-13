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

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.ineunet.knife.util.exception.KnifeUtilsException;

/**
 * 
 * @author hilbert
 * 
 * @since 1.0.0
 *
 */
public abstract class NetUtils {

	/**
	 * @param url
	 * @param charset e.g. utf-8
	 * @since 2.0.0
	 */
	public static String decodeURL(String url, String charset) {
		try {
			return URLDecoder.decode(url, charset);
		} catch (UnsupportedEncodingException e) {
			throw new KnifeUtilsException(e.getMessage(), e);
		}
	}
	
	/**
	 * Decode <tt>url</tt> from 'utf-8'
	 * @param url
	 * @since 2.0.0
	 */
	public static String decodeURL(String url) {
		return decodeURL(url, "utf-8");
	}
	
	/**
	 * @param url
	 * @param charset e.g. utf-8
	 * @since 2.0.0
	 */
	public static String encodeURL(String url, String charset) {
		try {
			return URLEncoder.encode(url, charset);
		} catch (UnsupportedEncodingException e) {
			throw new KnifeUtilsException(e.getMessage(), e);
		}
	}
	
	/**
	 * Encode <tt>url</tt> to 'utf-8'
	 * @param url
	 * @since 2.0.0
	 */
	public static String encodeURL(String url) {
		return encodeURL(url, "utf-8");
	}
	
}
