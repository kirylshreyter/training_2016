package com.kirylshreyter.hotel.services.impl;

import com.kirylshreyter.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.hotel.daoapi.IBookingRequestDao;
import com.kirylshreyter.hotel.daoapi.IUserDao;
import com.kirylshreyter.hotel.datamodel.BookingRequest;
import com.kirylshreyter.hotel.datamodel.User;
import com.kirylshreyter.hotel.services.BookingRequestService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class BookingRequestServiceImpl implements BookingRequestService {
    @Inject
    private IBookingRequestDao iBookingRequestDao;

    @Inject
    private IUserDao iUserDao;

    @Override
    public Long create(BookingRequest entity) {
        return iBookingRequestDao.create(entity);
    }

    @Override
    public BookingRequest read(Long id) {
        return null;
    }

    @Override
    public Boolean update(BookingRequest bookingRequest) {
        return iBookingRequestDao.update(bookingRequest);
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
        return iBookingRequestDao.getWithAdditionalInfo(id);
    }

    @Override
    public Long create2steps(BookingRequest bookingRequest, User user) {
        Long userId = iUserDao.create(user);
        bookingRequest.setUserId(userId);
        return iBookingRequestDao.create(bookingRequest);
    }

}
