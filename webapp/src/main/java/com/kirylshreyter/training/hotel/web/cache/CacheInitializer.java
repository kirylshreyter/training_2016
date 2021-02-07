package com.kirylshreyter.training.hotel.web.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

public class CacheInitializer {

	static Cache<String, Object> CACHE;
	private static final int TIMEOUT_IN_MILLIS = 600000;

	static {
		CACHE = CacheBuilder.newBuilder().expireAfterWrite(TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS).build();
		System.out.println("Cache Initialized");
	}
}
