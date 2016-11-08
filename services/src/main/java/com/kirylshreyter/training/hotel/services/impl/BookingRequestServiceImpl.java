package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.BookingRequestDao;
import com.kirylshreyter.training.hotel.daodb.ClientDao;
import com.kirylshreyter.training.hotel.daodb.util.DateConverters;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.BookingRequestService;

@Service
public class BookingRequestServiceImpl implements BookingRequestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingRequestServiceImpl.class);

	@Inject
	private BookingRequestDao bookingRequestDao;
	@Inject
	private ClientDao clientDao;
	@Inject
	private DateConverters dateConverter;

	@Override
	public Long save(BookingRequest bookingRequest, Client client) {
		bookingRequest.setArrivalDate(dateConverter.stringToDateConverter(bookingRequest.getNonConvertedArrivalDate()));
		bookingRequest
				.setDepartureDate(dateConverter.stringToDateConverter(bookingRequest.getNonConvertedDepartureDate()));
		Long insertedClientId = clientDao.insert(client);
		bookingRequest.setClientId(insertedClientId);
		Long insertedBookingRequestId = bookingRequestDao.insert(bookingRequest);
		LOGGER.info("Client and Booking Request was created, Client id = {}, Booking Request id = {}", insertedClientId,
				insertedBookingRequestId);
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
		LOGGER.info("Booking Request was deleted, id = {}",id);

	}

	@Override
	public void save(BookingRequest bookingRequest) {
		Long returnedId = bookingRequestDao.insert(bookingRequest);
		LOGGER.info("Booking Request was inserted, id = {}",returnedId);
	}

}
