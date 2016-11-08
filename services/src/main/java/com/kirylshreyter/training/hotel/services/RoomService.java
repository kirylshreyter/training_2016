package com.kirylshreyter.training.hotel.services;

import java.util.List;

import com.kirylshreyter.training.hotel.daodb.customentity.AvailableRoom;
import com.kirylshreyter.training.hotel.daodb.customentity.IntersactedDate;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Room;

public interface RoomService {
	void save(Room room);

	void update(Room room);

	Room get(Long id);

	List<Room> getAll();

	void delete(Long id);

	public List<IntersactedDate> getBookedRoomWithIntersactedDate(BookingRequest bookingRequest);

	List<AvailableRoom> getAllAvailableRoom(List<IntersactedDate> listOfIntersactedDates);

}
