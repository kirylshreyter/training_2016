package com.kirylshreyter.hotel.daoapi;

import com.kirylshreyter.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.hotel.datamodel.BookingRequest;

public interface IBookingRequestDao extends IAbstractDao<BookingRequest> {
    BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id);
}
