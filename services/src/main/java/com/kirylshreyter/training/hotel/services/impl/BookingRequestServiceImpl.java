package com.kirylshreyter.training.hotel.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IBookingRequestDao;
import com.kirylshreyter.training.hotel.daoapi.IUserDao;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.User;
import com.kirylshreyter.training.hotel.services.BookingRequestService;

@Service
public class BookingRequestServiceImpl implements BookingRequestService {

	@Inject
	private IBookingRequestDao iBookingRequestDao;
	
	@Inject
	private IUserDao iUserDao;

	@Override
	public Boolean update(BookingRequest bookingRequest) {
		return iBookingRequestDao.update(bookingRequest);
	}

	@Override
	public Long save(BookingRequest bookingRequest) {
		return iBookingRequestDao.insert(bookingRequest);
	}

	@Override
	public BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id) {
		return iBookingRequestDao.getWithAdditionalInfo(id);
	}

	@Override
	public Long save2steps(BookingRequest bookingRequest, User user) {
		Long userId = iUserDao.insert(user);
		bookingRequest.setUserId(userId);
		return iBookingRequestDao.insert(bookingRequest);
	}

}
