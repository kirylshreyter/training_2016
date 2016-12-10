package com.kirylshreyter.training.hotel.services;

public interface CommonService {
	
	<T> Object get(Object obj, Long id);
	
	Boolean delete (Object obj, Long id);

}
