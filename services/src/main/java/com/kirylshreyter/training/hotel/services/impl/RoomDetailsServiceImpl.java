package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

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
	public Boolean delete(Long id) {
		return roomDetailsDao.delete(id);
	}

}
