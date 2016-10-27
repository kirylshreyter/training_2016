package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import org.springframework.jdbc.core.RowMapper;
import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

public class BookedRoomMapper implements RowMapper<BookedRoom> {

	@Override
	public BookedRoom mapRow(ResultSet rs, int RowNum) throws SQLException {
		Long id = rs.getLong("id");
		Integer bookingRequestId = rs.getInt("booking_request_id");
		Integer roomOrderId = rs.getInt("room_order_id");
		Date bookedStartDay = rs.getDate("booked_start_day");
		Date bookedEndDay = rs.getDate("booked_end_day");
		BookedRoom entity = new BookedRoom();
		entity.setId(id);
		entity.setBookingRequestId(bookingRequestId);
		entity.setRoomOrderId(roomOrderId);
		entity.setBookedStartDay(bookedStartDay);
		entity.setBookedEndDay(bookedEndDay);
		return entity;
	}

}