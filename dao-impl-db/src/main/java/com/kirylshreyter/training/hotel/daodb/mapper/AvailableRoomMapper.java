package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.daodb.customentity.AvailableRoom;

public class AvailableRoomMapper implements RowMapper<AvailableRoom> {

	@Override
	public AvailableRoom mapRow(ResultSet rs, int numRows) throws SQLException {
		AvailableRoom entity = new AvailableRoom();
		entity.setRoomId(rs.getLong("id"));
		entity.setNumber(rs.getString("number"));
		entity.setRoomDetailsId(rs.getLong("room_details_id"));
		entity.setStatus(rs.getString("status"));
		entity.setCostPerNight(rs.getDouble("cost_per_night"));
		return entity;
	}

}
