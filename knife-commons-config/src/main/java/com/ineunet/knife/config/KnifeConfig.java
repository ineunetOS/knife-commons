package com.ineunet.knife.config;

import java.util.Collection;
import java.util.Set;

/**
 * 为调用方便提供的纯静态方法类
 * @see com.ineunet.knife.config.IConfig
 * @author hilbert.wang@hotmail.com<br>
 * Created on 2015年12月4日
 */
public final class KnifeConfig {
	
	private static IConfig knife;
	static {
		knife = ConfigFactory.getKnifeConfig();
	}
	
	private KnifeConfig() {}

	public static Boolean getBoolean(String name) {
		return knife.getBoolean(name);
	}

	public static String getString(String name) {
		return knife.getString(name);
	}
	
	public static Integer getInteger(String name) {
		return knife.getInteger(name);
	}

	public static boolean get(String name, boolean defaultValue) {
		return knife.get(name, defaultValue);
	}

	public static String get(String name, String defaultValue) {
		return knife.get(name, defaultValue);
	}

	public static int get(String name, int defaultValue) {
		return knife.get(name, defaultValue);
	}

	public static Set<String> keys() {
		return knife.keys();
	}

	public static Collection<Object> values() {
		return knife.values();
	}

}
