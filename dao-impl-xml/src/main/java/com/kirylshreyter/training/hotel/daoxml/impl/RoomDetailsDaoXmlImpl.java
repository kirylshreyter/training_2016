package com.kirylshreyter.training.hotel.daoxml.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IRoomDetailsDao;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

@Repository
public class RoomDetailsDaoXmlImpl implements IRoomDetailsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsDaoXmlImpl.class);

	private Boolean notNullChecker(RoomDetails entity) {
		if (entity.getNumberOfPlaces() == null) {
			throw new RuntimeException("Client's first name is not setted.");
		}
		if (entity.getCostPerNight() == null) {
			throw new RuntimeException("Client's last name is not setted.");
		}
		if (entity.getRoomType() == null) {
			throw new RuntimeException("Client's phone number is not setted.");
		}
		return true;
	}

	@Override
	public RoomDetails get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(RoomDetails entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RoomDetails entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RoomDetails> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
