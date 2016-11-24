package com.kirylshreyter.training.hotel.daoxml.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IRoomOrderDao;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

@Repository
public class RoomOrderDaoXmlImpl implements IRoomOrderDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomOrderDaoXmlImpl.class);

	private Boolean notNullChecker(RoomOrder entity) {
		if (entity.getBookingRequestId() == null) {
			throw new RuntimeException("Booking request is not setted.");
		}
		if (entity.getEmployeeId() == null) {
			throw new RuntimeException("Employee is not setted.");
		}
		if (entity.getTotalCost() == null) {
			throw new RuntimeException("Total cost is not setted.");
		}
		return true;
	}

	@Override
	public RoomOrder get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(RoomOrder entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(RoomOrder entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<RoomOrder> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
