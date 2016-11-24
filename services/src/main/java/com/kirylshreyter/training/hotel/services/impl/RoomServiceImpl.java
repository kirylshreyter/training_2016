package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IRoomDao;
import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.services.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

	@Inject
	private IRoomDao roomDao;

	@Override
	public Long save(Room room) {
		return roomDao.insert(room);
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
	public RoomWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return roomDao.getWithAdditionalInfo(id);
	}

	@Override
	public List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces) {
		return roomDao.getAllAvailableRoom(arrivalDate, departureDate, numberOfPlaces);
	}

}
