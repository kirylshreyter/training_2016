package com.kirylshreyter.training.hotel.daoxml.impl;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IRoomDao;
import com.kirylshreyter.training.hotel.datamodel.Room;

@Repository
public class RoomDaoXmlImpl implements IRoomDao{

	@Override
	public Long insert(Room entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Room entity) {
		return null;
		// TODO Auto-generated method stub
		
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
