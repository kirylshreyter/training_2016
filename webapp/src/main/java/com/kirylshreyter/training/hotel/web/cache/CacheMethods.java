package com.kirylshreyter.training.hotel.web.cache;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Service;

@Service
public class CacheMethods {

	private ConcurrentMap<String, Object> concurrentMap = CacheInitializer.CACHE.asMap();

	public void putEntityInCache(String key, Object value) {
		if (concurrentMap.get(key) == null) {
			concurrentMap.put(key, value);
		}
	}

	public void putMultiplyEntityInCache(List<String> listKey, List<Object> listValue) {
		for (int i = 0; i < concurrentMap.size(); i++) {
			String key = listKey.get(i);
			if (concurrentMap.get(key) == null) {
				concurrentMap.put(key, listValue.get(i));
			}
		}

	}

	public boolean deleteFromCache(String key) {
		if (concurrentMap.remove(key) == null) {
			return false;
		} else {
			return true;
		}

	}

	public Object getEntityFromCache(String key) {
		return concurrentMap.get(key);
	}

}
