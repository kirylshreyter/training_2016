package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

public class AllBookesRoomMapper implements RowMapper<BookedRoom>{
	List<BookedRoom> resultList = new ArrayList<BookedRoom>();
	BookedRoom entity = new BookedRoom();
	
	@Override
	public BookedRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
	while (!rs.last()){
		entity.setId(rs.getLong("id"));
		entity.setBookingRequestId(rs.getInt("booking_request_id"));
		entity.setRoomOrderId(rs.getInt("room_order_id"));
		entity.setBookedStartDay(rs.getDate("booked_start_day"));
		entity.setBookedEndDay(rs.getDate("booked_end_day"));
		resultList.add(entity);}
		return (BookedRoom) resultList;
	}
	
}