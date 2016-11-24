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
	private IBookingRequestDao bookingRequestDao;
	@Inject
	private IClientDao clientDao;

	@Override
	public Long save(BookingRequest bookingRequest, Client client) {
		Long insertedClientId = clientDao.insert(client);
		bookingRequest.setClientId(insertedClientId);
		Long insertedBookingRequestId = bookingRequestDao.insert(bookingRequest);
		return insertedBookingRequestId;
	}

	@Override
	public void update(BookingRequest bookingRequest) {
		bookingRequestDao.update(bookingRequest);
	}

	@Override
	public BookingRequest get(Long id) {
		return bookingRequestDao.get(id);
	}

	@Override
	public List<BookingRequest> getAll() {
		List<BookingRequest> BookingRequestList = new ArrayList<BookingRequest>(bookingRequestDao.getAll());
		return BookingRequestList;
	}

	@Override
	public void delete(Long id) {
		bookingRequestDao.delete(id);
	}

	@Override
	public Long save(BookingRequest bookingRequest) {
		return bookingRequestDao.insert(bookingRequest);
	}

	@Override
	public BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return bookingRequestDao.getWithAdditionalInfo(id);
	}

}
