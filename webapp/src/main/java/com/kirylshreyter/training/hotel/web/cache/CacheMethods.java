package com.kirylshreyter.training.hotel.web.cache;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ConcurrentMap;

@Service
public class CacheMethods {

    private final ConcurrentMap<String, Object> concurrentMap = CacheInitializer.CACHE.asMap();

    public void putEntityInCache(String key, Object value) {
        concurrentMap.putIfAbsent(key, value);
    }

    public void putMultiplyEntityInCache(List<String> listKey, List<Object> listValue) {
        for (int i = 0; i < concurrentMap.size(); i++) {
            String key = listKey.get(i);
            int finalI = i;
            concurrentMap.computeIfAbsent(key, k -> listValue.get(finalI));
        }

    }

    public void deleteFromCache(String key) {
        concurrentMap.remove(key);
    }

    public Object getEntityFromCache(String key) {
        return concurrentMap.get(key);
    }
}
