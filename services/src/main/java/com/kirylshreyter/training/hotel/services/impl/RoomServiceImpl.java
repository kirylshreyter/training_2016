package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.RoomDao;
import com.kirylshreyter.training.hotel.daodb.customentity.AvailableRoom;
import com.kirylshreyter.training.hotel.daodb.customentity.IntersactedDate;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.services.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomServiceImpl.class);

	@Inject
	private RoomDao roomDao;

	@Override
	public void save(Room room) {
		Long returnedId = roomDao.insert(room);
		LOGGER.info("New Room was inserted, id = {}", returnedId);

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
		LOGGER.info("Room was deleted, id = {}", id);
	}

	@Override
	public List<IntersactedDate> getBookedRoomWithIntersactedDate(BookingRequest bookingRequest) {
		return roomDao.getBookedRoomWithIntersactedDate(bookingRequest);
	}

	@Override
	public List<AvailableRoom> getAllAvailableRoom(List<IntersactedDate> listOfIntersactedDates) {
		return roomDao.getAllAvailableRoom(listOfIntersactedDates);
	}

}
