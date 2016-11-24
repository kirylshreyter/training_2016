package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

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
	public void save(RoomOrder roomOrder) {
		roomOrderDao.insert(roomOrder);

	}

	@Override
	public void update(RoomOrder roomOrder) {
		roomOrderDao.update(roomOrder);
	}

	@Override
	public RoomOrder get(Long id) {
		return roomOrderDao.get(id);
	}

	@Override
	public List<RoomOrder> getAll() {
		List<RoomOrder> roomOrderList = new ArrayList<RoomOrder>(roomOrderDao.getAll());
		return roomOrderList;
	}

	@Override
	public void delete(Long id) {
		roomOrderDao.delete(id);
	}

	@Override
	public RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return roomOrderDao.getWithAdditionalInfo(id);
	}

}
