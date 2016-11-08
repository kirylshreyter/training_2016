package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

public final class BookedRoomMapper implements RowMapper<BookedRoom> {

	@Override
	public BookedRoom mapRow(ResultSet rs, int RowNum) throws SQLException {
		BookedRoom entity = new BookedRoom();
		entity.setId(rs.getLong("id"));
		entity.setBookingRequestId(rs.getLong("booking_request_id"));
		entity.setRoomOrderId(rs.getInt("room_order_id"));
		return entity;
	}
}