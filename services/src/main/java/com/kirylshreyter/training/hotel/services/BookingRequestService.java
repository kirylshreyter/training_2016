package com.kirylshreyter.training.hotel.services;

import java.util.List;

import com.kirylshreyter.training.hotel.daodb.customentity.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;

public interface BookingRequestService {

	Long save(BookingRequest bookingRequest);

	void update(BookingRequest bookingRequest);

	BookingRequest get(Long id);

	List<BookingRequest> getAll();

	void delete(Long id);

	Long save(BookingRequest bookingRequest, Client client);

	BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id);

}
