package com.kirylshreyter.hotel.daoxml.impl;

import com.kirylshreyter.hotel.commons.AvailableRoom;
import com.kirylshreyter.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.hotel.daoapi.IRoomDao;
import com.kirylshreyter.hotel.datamodel.Room;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RoomDaoXmlImpl implements IRoomDao{
	@Override
	public Long create(Room entity) {
		return null;
	}

	@Override
	public Room read(Long id) {
		return null;
	}

	@Override
	public Boolean update(Room entity) {
		return null;
	}

	@Override
	public Integer delete(Long id) {
		return null;
	}

	@Override
	public List<Room> getAll() {
		return null;
	}

	@Override
	public RoomWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return null;
	}

	@Override
	public List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate) {
		return null;
	}

	@Override
	public List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces) {
		return null;
	}
}
