package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

public class RoomOrderMapper implements RowMapper<RoomOrder> {

	@Override
	public RoomOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomOrder entity = new RoomOrder();
		entity.setRoomId(rs.getInt("room_id"));
		entity.setBookingRequestId(rs.getInt("booking_request_id"));
		entity.setEmployeeId(rs.getInt("employee_id"));
		entity.setTotalCost(rs.getDouble("total_cost"));
		entity.setBookedStartDay(rs.getDate("booked_start_day"));
		entity.setBookedEndDay(rs.getDate("booked_end_day"));
		return entity;
	}

}
