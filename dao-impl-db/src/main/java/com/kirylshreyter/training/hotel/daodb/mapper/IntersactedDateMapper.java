package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.daodb.customentity.IntersactedDate;

public class IntersactedDateMapper implements RowMapper<IntersactedDate> {

	@Override
	public IntersactedDate mapRow(ResultSet rs, int rowNum) throws SQLException {
		IntersactedDate entity = new IntersactedDate();
		entity.setRoomId(rs.getLong("room_id"));
		entity.setBookedStartDay(rs.getDate("booked_start_day"));
		entity.setBookedEndDay(rs.getDate("booked_end_day"));
		return entity;
	}

}
