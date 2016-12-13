package com.kirylshreyter.training.hotel.services.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;
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
	public Boolean update(Room room) {
		return roomDao.update(room);
	}

	@Override
	public RoomWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return roomDao.getWithAdditionalInfo(id);
	}

	@Override
	public List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces) {
		return roomDao.getAllAvailableRoom(arrivalDate, departureDate, numberOfPlaces);
	}

	@Override
	public List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate) {
		return roomDao.getAllNotAvailableRoom(arrivalDate, departureDate);
	}

}
