package com.kirylshreyter.training.hotel.daodb;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

public interface RoomDetailsDao {
	

	RoomDetails get(Long id);

	Long insert(RoomDetails entity);

	void update(RoomDetails entity);

	void delete(Long id);

	List<RoomDetails> getAll();

}
