package com.kirylshreyter.training.hotel.services;

import java.util.Date;
import java.util.List;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.Room;

public interface RoomService {
	Long save(Room room);

	void update(Room room);

	Room get(Long id);

	List<Room> getAll();

	void delete(Long id);

	RoomWithAdditionalInfo getWithAdditionalInfo(Long id);

	List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces);

}
