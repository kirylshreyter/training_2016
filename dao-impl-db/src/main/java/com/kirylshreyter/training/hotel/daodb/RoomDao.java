package com.kirylshreyter.training.hotel.daodb;

import java.util.List;

import com.kirylshreyter.training.hotel.daodb.customentity.IntersactedDate;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Room;

public interface RoomDao {

	Room get(Long id);

	Long insert(Room entity);

	void update(Room entity);

	void delete(Long id);

	List<Room> getAll();

	public List<IntersactedDate> getBookedRoomWithIntersactedDate(BookingRequest bookingRequest);

}
