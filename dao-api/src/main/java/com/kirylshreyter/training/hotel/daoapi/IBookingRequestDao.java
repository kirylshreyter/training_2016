package com.kirylshreyter.training.hotel.daoapi;

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;

public interface IBookingRequestDao {

	Long insert(BookingRequest entity);

	Boolean update(BookingRequest entity);

	BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id);
}
