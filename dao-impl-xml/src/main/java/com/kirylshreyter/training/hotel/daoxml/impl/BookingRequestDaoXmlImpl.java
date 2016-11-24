package com.kirylshreyter.training.hotel.daoxml.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IBookingRequestDao;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;

@Repository
public class BookingRequestDaoXmlImpl implements IBookingRequestDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingRequestDaoXmlImpl.class);

	private Boolean notNullChecker(BookingRequest entity) {
		if (entity.getClientId() == null) {
			throw new RuntimeException("Client Id is not setted.");
		}
		if (entity.getRoomId() == null) {
			throw new RuntimeException("Room Id is not setted.");
		}
		if (entity.getArrivalDate() == null) {
			throw new RuntimeException("Arrival date is not setted.");
		}
		if (entity.getDepartureDate() == null) {
			throw new RuntimeException("Departure date is not setted.");
		}
		return true;
	}

	@Override
	public BookingRequest get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(BookingRequest entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BookingRequest entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<BookingRequest> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
