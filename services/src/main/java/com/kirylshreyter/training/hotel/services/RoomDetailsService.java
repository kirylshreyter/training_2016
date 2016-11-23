package com.kirylshreyter.training.hotel.services;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

public interface RoomDetailsService {
	Long save(RoomDetails roomDetails);

	void update(RoomDetails roomDetails);

	RoomDetails get(Long id);

	List<RoomDetails> getAll();

	void delete(Long id);

}
