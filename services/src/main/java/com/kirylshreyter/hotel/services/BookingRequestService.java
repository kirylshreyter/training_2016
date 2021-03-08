package com.kirylshreyter.hotel.services;

import com.kirylshreyter.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.hotel.datamodel.BookingRequest;
import com.kirylshreyter.hotel.datamodel.User;

public interface BookingRequestService extends AbstractService<BookingRequest> {
    BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id);

    Long create2steps(BookingRequest bookingRequest, User user);
}
