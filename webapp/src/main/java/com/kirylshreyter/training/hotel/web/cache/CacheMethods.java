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
			String str = listKey.get(i);
			if (concurrentMap.get(str) == null) {
				concurrentMap.put(str, listValue.get(i));
			}
		}

	}

	public void deleteFromCache() {
		// TODO delete if update or delete from database

	}

	public Object getEntityFromCache(String key) {
		return concurrentMap.get(key);
	}

}
