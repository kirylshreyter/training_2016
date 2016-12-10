package com.kirylshreyter.training.hotel.daoapi;

public interface ICommon {

	<T> Object get(Object obj, Long id);
	
	Boolean delete (Object obj, Long id);
}
