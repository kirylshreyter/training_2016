package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IBookingRequestDao;
import com.kirylshreyter.training.hotel.daoapi.IClientDao;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.BookingRequestService;

@Service
public class BookingRequestServiceImpl implements BookingRequestService {

	@Inject
	private IBookingRequestDao iBookingRequestDao;
	@Inject
	private IClientDao iClientDao;

	@Override
	public Long save(BookingRequest bookingRequest, Client client) {
		Long insertedClientId = null;
			insertedClientId = iClientDao.insert(client);
		bookingRequest.setClientId(insertedClientId);
		Long insertedBookingRequestId = iBookingRequestDao.insert(bookingRequest);
		return insertedBookingRequestId;
	}

	@Override
	public void update(BookingRequest bookingRequest) {
		iBookingRequestDao.update(bookingRequest);
	}

	@Override
	public BookingRequest get(Long id) {
		return iBookingRequestDao.get(id);
	}

	@Override
	public List<BookingRequest> getAll() {
		List<BookingRequest> BookingRequestList = new ArrayList<BookingRequest>(iBookingRequestDao.getAll());
		return BookingRequestList;
	}

	@Override
	public void delete(Long id) {
		iBookingRequestDao.delete(id);
	}

	@Override
	public Long save(BookingRequest bookingRequest) {
		return iBookingRequestDao.insert(bookingRequest);
	}

	@Override
	public BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return iBookingRequestDao.getWithAdditionalInfo(id);
	}

}
