package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.RoomDao;
import com.kirylshreyter.training.hotel.daodb.customentity.IntersactedDate;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.services.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Inject
	private RoomDao roomDao;

	@Override
	public void save(Room room) {
		roomDao.insert(room);

	}

	@Override
	public void update(Room room) {
		roomDao.update(room);

	}

	@Override
	public Room get(Long id) {
		return roomDao.get(id);
	}

	@Override
	public List<Room> getAll() {
		List<Room> roomList = new ArrayList<Room>(roomDao.getAll());
		return roomList;
	}

	@Override
	public void delete(Long id) {
		roomDao.delete(id);
	}

	@Override
	public List<IntersactedDate> getBookedRoomWithIntersactedDate(BookingRequest bookingRequest) {
		return roomDao.getBookedRoomWithIntersactedDate(bookingRequest);
	}

}
