package com.kirylshreyter.training.hotel.services;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

public interface RoomDetailsService {
	Long save(RoomDetails roomDetails);

	Boolean update(RoomDetails roomDetails);

	RoomDetails get(Long id);

	List<RoomDetails> getAll();

	Boolean delete(Long id);

}
