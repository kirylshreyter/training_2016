package com.kirylshreyter.training.hotel.daoxml.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IRoomDao;
import com.kirylshreyter.training.hotel.datamodel.Room;

@Repository
public class RoomDaoXmlImpl implements IRoomDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDaoXmlImpl.class);

	private Boolean notNullChecker(Room entity) {
		if (entity.getNumber() == null) {
			throw new RuntimeException("Room's number is not setted.");
		}
		if (entity.getRoomDetailsId() == null) {
			throw new RuntimeException("Room details is not setted.");
		}
		if (entity.getStatus() == null) {
			throw new RuntimeException("Status is not setted.");
		}
		return true;
	}

	@Override
	public Room get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(Room entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Room entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Room> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomWithAdditionalInfo getWithAdditionalInfo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces) {
		// TODO Auto-generated method stub
		return null;
	}
}
