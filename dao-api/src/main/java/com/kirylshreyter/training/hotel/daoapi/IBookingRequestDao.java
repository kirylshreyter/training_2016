package com.kirylshreyter.training.hotel.daoapi;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;

public interface IBookingRequestDao {

	BookingRequest get(Long id);

	Long insert(BookingRequest entity);

	void update(BookingRequest entity);

	void delete(Long id);

	List<BookingRequest> getAll();

	BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id);

}
