package com.kirylshreyter.training.hotel.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IRoomOrderDao;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;
import com.kirylshreyter.training.hotel.services.RoomOrderService;

@Service
public class RoomOrderServiceImpl implements RoomOrderService {

	@Inject
	private IRoomOrderDao roomOrderDao;

	@Override
	public Long save(RoomOrder roomOrder) {
		return roomOrderDao.insert(roomOrder);
	}

	@Override
	public Boolean update(RoomOrder roomOrder) {
		return roomOrderDao.update(roomOrder);
	}

	@Override
	public RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return roomOrderDao.getWithAdditionalInfo(id);
	}

}
