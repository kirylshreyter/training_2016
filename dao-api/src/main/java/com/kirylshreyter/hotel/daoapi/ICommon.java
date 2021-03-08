package com.kirylshreyter.hotel.daoapi;

import java.util.List;

public interface ICommon {

	<T> Object get(Object obj, Long id);
	
	Boolean delete (Object obj, Long id);
	
	<T> List<T> getAll(Object obj);
}
