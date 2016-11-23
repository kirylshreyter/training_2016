package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.daodb.customentity.AvailableRoom;

public class AvailableRoomMapper implements RowMapper<AvailableRoom> {

	@Override
	public AvailableRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
		AvailableRoom entity = new AvailableRoom();
		entity.setNumber(rs.getString("number"));
		entity.setRoomType(rs.getString("room_type"));
		entity.setCostPerNight(rs.getDouble("cost_per_night"));
		entity.setAdditionalInformation(rs.getString("additional_information"));
		entity.setRoomId(rs.getLong("room_id"));
		return null;
	}

}
