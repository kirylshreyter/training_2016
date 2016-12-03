package com.kirylshreyter.training.hotel.web.utils;

import java.util.Map;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

@Component
public class ObjectIdentifier {

	@Inject
	private MapInitializer mapInitializer;

	public Object idendifyAnObject(Object object) {

		Map<Object, Object> map = mapInitializer.initializeMap();

		object = map.get(object.getClass().getName());

		return object;
	}

}
