package com.ineunet.knife.util;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Hilbert
 *
 */
public interface ISortedMap<K, V> {
	
	void put(K key, V value);
	
	V get(K key);
	
	List<K> keyList();
	
	Collection<V> values();
	
	boolean containsKey(K key);
	
	boolean containsValue(V value);
	
	void remove(K key);
	
	int size();
	
	Map<K, V> asMap();

}
