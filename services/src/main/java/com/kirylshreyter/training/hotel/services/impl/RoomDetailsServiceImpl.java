package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.RoomDetailsDao;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.kirylshreyter.training.hotel.services.RoomDetailsService;

@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsServiceImpl.class);

	@Inject
	private RoomDetailsDao roomDetailsDao;

	@Override
	public void save(RoomDetails roomDetails) {
		Long returnedId = roomDetailsDao.insert(roomDetails);
		LOGGER.info("Room Details was inserted, id = {}", returnedId);

	}

	@Override
	public void update(RoomDetails roomDetails) {
		roomDetailsDao.update(roomDetails);

	}

	@Override
	public RoomDetails get(Long id) {
		return roomDetailsDao.get(id);
	}

	@Override
	public List<RoomDetails> getAll() {
		List<RoomDetails> roomDetailsList = new ArrayList<RoomDetails>(roomDetailsDao.getAll());
		return roomDetailsList;
	}

	@Override
	public void delete(Long id) {
		roomDetailsDao.delete(id);
		LOGGER.info("Room Details was deleted, id = {}", id);
	}

}
