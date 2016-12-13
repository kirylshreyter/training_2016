package com.kirylshreyter.training.hotel.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daoapi.IRoomDetailsDao;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.kirylshreyter.training.hotel.services.RoomDetailsService;

@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

	@Inject
	private IRoomDetailsDao roomDetailsDao;

	@Override
	public Long save(RoomDetails roomDetails) {
		return roomDetailsDao.insert(roomDetails);

	}

	@Override
	public Boolean update(RoomDetails roomDetails) {
		return roomDetailsDao.update(roomDetails);

	}
}
