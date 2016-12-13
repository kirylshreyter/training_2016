package com.kirylshreyter.training.hotel.services;

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

public interface RoomDetailsService {

	Long save(RoomDetails roomDetails);

	Boolean update(RoomDetails roomDetails);
}
