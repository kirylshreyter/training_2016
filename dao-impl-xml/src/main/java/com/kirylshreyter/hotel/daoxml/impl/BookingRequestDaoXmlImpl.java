package com.kirylshreyter.hotel.daoxml.impl;

import com.kirylshreyter.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.hotel.daoapi.IBookingRequestDao;
import com.kirylshreyter.hotel.datamodel.BookingRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRequestDaoXmlImpl implements IBookingRequestDao {
	@Override
	public Long create(BookingRequest entity) {
		return null;
	}

	@Override
	public BookingRequest read(Long id) {
		return null;
	}

	@Override
	public Boolean update(BookingRequest entity) {
		return null;
	}

	@Override
	public Integer delete(Long id) {
		return null;
	}

	@Override
	public List<BookingRequest> getAll() {
		return null;
	}

	@Override
	public BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return null;
	}
}
