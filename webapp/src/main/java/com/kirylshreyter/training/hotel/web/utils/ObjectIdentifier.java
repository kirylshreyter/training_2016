package com.kirylshreyter.training.hotel.web.utils;

import java.util.Collections;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class ObjectIdentifier {

	public Object idendifyAnObject(Object object) {

		Map<Object, Object> map = Collections.unmodifiableMap(MapInitializer.MAP);
		Map<Object, Object> mapModel = Collections.unmodifiableMap(MapInitializer.MAP_MODEL);
		Object obj = new Object();
		obj = map.get(object.getClass().getName());
		if (obj != null) {
			object = obj;
		} else {
			object = mapModel.get(object.getClass().getName());
		}

		return object;
	}

}
