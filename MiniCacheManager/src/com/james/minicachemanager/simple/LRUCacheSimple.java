package com.james.minicachemanager.simple;

import java.util.Map;

import com.james.minicachemanager.cache.algorithm.LRUCache;
import com.james.minilog.MiniLog;

public class LRUCacheSimple {

	private static final String TAG = LRUCacheSimple.class.getSimpleName();
	public LRUCacheSimple() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		LRUCache<String, String> c = new LRUCache<>(3);
		c.put("1", "one");
		c.put("2", "two");
		c.put("3", "three");
		c.put("4", "four");
		if (c.get("2") == null)
			throw new Error();
		c.put("5", "five");
		c.put("4", "second four");
		// Verify cache content.
		if (c.usedEntries() != 3)
			throw new Error();
		if (!c.get("4").equals("second four"))
			throw new Error();
		if (!c.get("5").equals("five"))
			throw new Error();
		if (!c.get("2").equals("two"))
			throw new Error();
		// List cache content.
		for (Map.Entry<String, String> e : c.getAll())
			MiniLog.d(TAG, e.getKey() + " : " + e.getValue());

	}

}
