package com.kirylshreyter.hotel.web.cache;

import java.util.concurrent.TimeUnit;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CacheInitializer {

	static Cache<String, Object> CACHE;
	private static final int TIMEOUT_IN_MILLIS = 600000;
	private static final Logger LOGGER = LoggerFactory.getLogger(CacheInitializer.class);

	static {
		CACHE = CacheBuilder.newBuilder().expireAfterWrite(TIMEOUT_IN_MILLIS, TimeUnit.MILLISECONDS).build();
		LOGGER.info("Cache Initialized");
	}
}
