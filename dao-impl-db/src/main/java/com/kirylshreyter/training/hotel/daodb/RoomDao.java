package com.kirylshreyter.training.hotel.daodb;

import java.util.Date;
import java.util.List;

import com.kirylshreyter.training.hotel.daodb.customentity.AvailableRoom;
import com.kirylshreyter.training.hotel.daodb.customentity.NotAvailableRoom;
import com.kirylshreyter.training.hotel.daodb.customentity.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.Room;

public interface RoomDao {

	Room get(Long id);

	Long insert(Room entity);

	void update(Room entity);

	void delete(Long id);

	List<Room> getAll();

	RoomWithAdditionalInfo getWithAdditionalInfo(Long id);

	List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate);

	List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces);

}
