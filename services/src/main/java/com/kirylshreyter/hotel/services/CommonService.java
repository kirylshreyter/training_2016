package com.kirylshreyter.hotel.services;

import java.util.List;

public interface CommonService {
	
	<T> Object get(Object obj, Long id);
	
	Boolean delete (Object obj, Long id);
	
	<T> List<T> getAll(Object obj);

}
