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
package com.ineunet.knife.util.jackson;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

import com.ineunet.knife.util.StringUtils;

/**
 * 
 * @author Hilbert Wang
 * @see {@linkplain http://wiki.fasterxml.com/JacksonInFiveMinutes }
 * @since 1.0.0
 * 
 */
@SuppressWarnings("deprecation")
public class JsonUtils {

	static final ObjectMapper objectMapper = new ObjectMapper();
	static {
		objectMapper.configure(org.codehaus.jackson.map.DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		objectMapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
	}

	public static <T> T toObject(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) return null;
		T object = null;
		try {
			object = objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return object;
	}
	
	/**
	 * @since 1.0.2
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) return Collections.EMPTY_LIST;
		// return toObject(json, new TypeReference<List<T>>() {});
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, clazz);
		List<T> list;
		try {
			list =  (List<T>) objectMapper.readValue(json, javaType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	/**
	 * @since 1.0.2
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(InputStream json, Class<T> clazz) {
		if (json == null) return Collections.EMPTY_LIST;
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, clazz);
		List<T> list;
		try {
			list =  (List<T>) objectMapper.readValue(json, javaType);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return list;
	}
	
	public static <T> T toObject(String json, TypeReference<?> type) {
		if (StringUtils.isBlank(json)) return null;

		T object = null;
		try {
			object = objectMapper.readValue(json, type);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return object;
	}
	
	public static <T> T toObject(File json, Class<T> clazz) {
		if (json == null || !json.exists())
			throw new IllegalArgumentException("file not exists.");

		T object = null;
		try {
			object = objectMapper.readValue(json, clazz);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return object;
	}

	public static String toString(Object object) {
		String s = null;
		try {
			s = objectMapper.writeValueAsString(object);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return s;
	}
	
	/**
	 * Fast 1000% than <code>getObject(json, Map.class);</code>
	 * @param json simple json string. e.g. {"男":1, "女":0}
	 * @param valClass class of value. Supports: Integer.class, String.class, Boolean.class
	 */
	@SuppressWarnings("unchecked")
	public static<X> Map<String, X> toMap(String json, Class<X> valClass) {
		Map<String, X> map = new HashMap<String, X>();
		try {
			JsonFactory f = new JsonFactory();
			JsonParser jp = f.createJsonParser(json);
			jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				JsonToken token = jp.getCurrentToken();
				if(token.equals(JsonToken.FIELD_NAME)) {
					jp.nextToken();// to value token
					if(valClass.equals(Integer.class) || valClass.equals(int.class) ) {
						map.put(jp.getCurrentName(), (X) Integer.valueOf(jp.getIntValue()));
					} else if (valClass.equals(String.class)) {
						map.put(jp.getCurrentName(), (X) jp.getText());
					} else if (valClass.equals(Boolean.class) || valClass.equals(boolean.class)) {
						map.put(jp.getCurrentName(), (X) Boolean.valueOf(jp.getBooleanValue()));
					}
				}
			}
			jp.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return map;
	}
	
	/**
	 * same logic as 'public static&lt;X&gt; Map&lt;String, X&gt toMap(String json, Class&lt;X&gt valClass)';
	 * @param json
	 * @param valClass
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static<X> Map<X, String> toMapInverse(String json, Class<X> valClass) {
		Map<X, String> map = new HashMap<X, String>();
		try {
			JsonFactory f = new JsonFactory();
			JsonParser jp = f.createJsonParser(json);
			jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
			while (jp.nextToken() != JsonToken.END_OBJECT) {
				JsonToken token = jp.getCurrentToken();
				if(token.equals(JsonToken.FIELD_NAME)) {
					jp.nextToken();// to value token
					if(valClass.equals(Integer.class) || valClass.equals(int.class) ) {
						map.put((X) Integer.valueOf(jp.getIntValue()), jp.getCurrentName());
					} else if (valClass.equals(String.class)) {
						map.put((X) jp.getText(), jp.getCurrentName());
					} else if (valClass.equals(Boolean.class) || valClass.equals(boolean.class)) {
						map.put((X) Boolean.valueOf(jp.getBooleanValue()), jp.getCurrentName());
					}
				}
			}
			jp.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return map;
	}

}
