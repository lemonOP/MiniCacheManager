package com.james.minicachemanager.cache.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * an LRU cache
 * 
 * @author James
 * 
 */
public class LRUCache<K, V> {

	private static final float hashTableLoadFactor = 0.75f;

	private LinkedHashMap<K, V> map;// 数据结构存储

	private int cacheSize;// 缓存的数量

	public LRUCache() {
		// TODO Auto-generated constructor stub
	}

	public LRUCache(int cacheSize) {
		this.cacheSize = cacheSize;
		int hashTableCapacity = (int) Math
				.ceil(cacheSize / hashTableLoadFactor) + 1;
		map = new LinkedHashMap<K, V>(hashTableCapacity, hashTableLoadFactor,
				true) {

			/**
			 * 
			 */
			private static final long serialVersionUID = -4253233823373796325L;

			@Override
			protected boolean removeEldestEntry(Entry<K, V> eldest) {
				// TODO Auto-generated method stub
				return size() > LRUCache.this.cacheSize;
			}

		};
	}

	/**
	 * 获取值
	 * @param key
	 * @return
	 */
	public synchronized V get(K key) {
		return map.get(key);
	}

	
	
	/**
	 * put to map
	 * @param key
	 * @param value
	 */
	public synchronized void put(K key,V value){
		map.put(key, value);
	}
	
	
	/**
	 * clears the cache
	 */
	public synchronized void clear(){
		map.clear();
	}
	
	/**
	 * return the number of used entries in the cache
	 * 
	 * @return
	 */
	public synchronized int usedEntries(){
		
		return map.size();
	}
	
	/**
	 *
	 * @return
	 */
	public synchronized Collection<Map.Entry<K,V>> getAll(){
		
		return new ArrayList<Map.Entry<K,V>>(map.entrySet());
	} 
	
	
}
