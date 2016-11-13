package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.RoomOrderDao;
import com.kirylshreyter.training.hotel.daodb.util.DateConverter;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;
import com.kirylshreyter.training.hotel.services.RoomOrderService;

@Service
public class RoomOrderServiceImpl implements RoomOrderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomOrderServiceImpl.class);

	@Inject
	private RoomOrderDao roomOrderDao;

	@Inject
	private DateConverter dateConverter;

	@Override
	public void save(RoomOrder roomOrder) {
		roomOrder.setBookedStartDay(dateConverter.stringToJavaUtilDateConverter(roomOrder.getNonConvertedbookedStartDay()));
		roomOrder.setBookedEndDay(dateConverter.stringToJavaUtilDateConverter(roomOrder.getNonConvertedbookedEndDay()));
		Long returnedId = roomOrderDao.insert(roomOrder);
		LOGGER.info("Room Order was inserted, id = {}", returnedId);

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
		LOGGER.info("Room Order was deleted, id = {}", id);

	}

}
