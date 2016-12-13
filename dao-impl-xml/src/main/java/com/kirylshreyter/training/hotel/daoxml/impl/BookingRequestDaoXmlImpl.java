package com.kirylshreyter.training.hotel.daoxml.impl;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IBookingRequestDao;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;

@Repository
public class BookingRequestDaoXmlImpl implements IBookingRequestDao {

	@Override
	public Long insert(BookingRequest entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(BookingRequest entity) {
		return null;
		// TODO Auto-generated method stub

	}

	@Override
	public BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
