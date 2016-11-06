package com.kirylshreyter.training.hotel.daodb;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

public interface RoomOrderDao {
	
	RoomOrder get(Long id);

	Long insert(RoomOrder entity);

	void update(RoomOrder entity);

	void delete(Long id);

	List<RoomOrder> getAll();

}
