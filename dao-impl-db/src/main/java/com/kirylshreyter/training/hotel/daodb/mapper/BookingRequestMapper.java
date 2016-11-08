package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.datamodel.BookingRequest;

public class BookingRequestMapper implements RowMapper<BookingRequest> {

	@Override
	public BookingRequest mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookingRequest entity = new BookingRequest();
		entity.setId(rs.getLong("id"));
		entity.setClientId(rs.getLong("client_id"));
		entity.setRoomDetailsId(rs.getLong("room_details_id"));
		entity.setArrivalDate(rs.getDate("arrival_date"));
		entity.setDepartureDate(rs.getDate("departure_date"));
		return entity;
	}

}
