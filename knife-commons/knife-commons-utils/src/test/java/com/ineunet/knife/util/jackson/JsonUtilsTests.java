package com.ineunet.knife.util.jackson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import com.ineunet.knife.util.model.SingleMap;

import junit.framework.Assert;

public class JsonUtilsTests {

	static String json = "{\"女\":0,\"男\":1}";
	static String json1 = "{\"女\":\"0\",\"男\":\"1\"}";
	static String json2 = "{\"女\":true,\"男\":false,\"女2\":true,\"男2\":false}";

	@Test
	public void testToList() {
		List<SingleMap<String, String>> expected = new ArrayList<>();
		expected.add(new SingleMap<String, String>("k1", "v1"));
		expected.add(new SingleMap<String, String>("k2", "v2"));
		String json = JsonUtils.toString(expected);
		
		@SuppressWarnings("rawtypes")
		List<SingleMap> actual = new ArrayList<>();
		actual = JsonUtils.toList(json, SingleMap.class);
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void testJson2Map() {
		long t1 = System.currentTimeMillis();
		Map<String, Integer> map = JsonUtils.toObject(json, new TypeReference<LinkedHashMap<String, Integer>>() {
		});
		System.out.println(System.currentTimeMillis() - t1);
		Assert.assertEquals(0, map.get("女").intValue());
		Assert.assertEquals(1, map.get("男").intValue());
	}

	@Test
	public void testJson2Map2() {
		long t0 = System.currentTimeMillis();
		Map<String, Integer> map = JsonUtils.toMap(json, Integer.class);
		System.out.println(System.currentTimeMillis() - t0);
		Assert.assertEquals(0, map.get("女").intValue());
		Assert.assertEquals(1, map.get("男").intValue());

		long t1 = System.currentTimeMillis();
		Map<String, String> map1 = JsonUtils.toMap(json1, String.class);
		System.out.println(System.currentTimeMillis() - t1);
		Assert.assertEquals("0", map1.get("女"));
		Assert.assertEquals("1", map1.get("男"));
		
		long t2 = System.currentTimeMillis();
		Map<String, Boolean> map2 = JsonUtils.toMap(json2, Boolean.class);
		System.out.println(System.currentTimeMillis() - t2);
		Assert.assertEquals(true, map2.get("女").booleanValue());
		Assert.assertEquals(false, map2.get("男").booleanValue());
		Assert.assertEquals(true, map2.get("女2").booleanValue());
		Assert.assertEquals(false, map2.get("男2").booleanValue());
	}

	// @Test
	public void testEffective() throws JsonParseException, IOException {
		System.out.println("---------------------------------------------");
		JsonFactory f = new JsonFactory();
		JsonParser jp = f.createJsonParser(json1);
		jp.nextToken(); // will return JsonToken.START_OBJECT (verify?)
		while (jp.nextToken() != JsonToken.END_OBJECT) {
			String fieldname = jp.getCurrentName();
			System.out.println(fieldname);
			System.out.println(jp.getText());
			System.out.println("name:" + jp.getCurrentToken().name());
			System.out.println("asString:" + jp.getCurrentToken().asString());
			System.out.println("isNumeric:" + jp.getCurrentToken().isNumeric());
			System.out.println("isScalarValue:" + jp.getCurrentToken().isScalarValue());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");

	}

}
