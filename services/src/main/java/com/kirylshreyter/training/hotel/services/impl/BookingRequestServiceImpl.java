package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.BookingRequestDao;
import com.kirylshreyter.training.hotel.daodb.ClientDao;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.BookingRequestService;

@Service
public class BookingRequestServiceImpl implements BookingRequestService {

	@Inject
	private BookingRequestDao bookingRequestDao;
	@Inject
	private ClientDao clientDao;

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
	public void save(BookingRequest bookingRequest) {
		bookingRequestDao.insert(bookingRequest);
	}

}
