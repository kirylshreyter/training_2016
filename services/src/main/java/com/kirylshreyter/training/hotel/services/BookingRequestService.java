package com.kirylshreyter.training.hotel.services;

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;

public interface BookingRequestService {

	Long save(BookingRequest bookingRequest);

	Boolean update(BookingRequest bookingRequest);

	BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id);
	
	Long save2steps(BookingRequest bookingRequest, Client client);

}
