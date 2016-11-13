package com.kirylshreyter.training.hotel.daodb;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.BookingRequest;

public interface BookingRequestDao {

	BookingRequest get(Long id);

	Long insert(BookingRequest entity);

	void update(BookingRequest entity);

	void delete(Long id);

	List<BookingRequest> getAll();

}
