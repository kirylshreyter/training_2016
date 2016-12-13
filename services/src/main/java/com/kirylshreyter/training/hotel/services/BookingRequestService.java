package com.kirylshreyter.training.hotel.services;

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;

public interface BookingRequestService {

	Long save(BookingRequest bookingRequest);

	Boolean update(BookingRequest bookingRequest);

	Long save(BookingRequest bookingRequest, Client client);

	BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id);

}
