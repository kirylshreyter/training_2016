package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;

public class RoomWithAdditionalInfoMapper implements RowMapper<RoomWithAdditionalInfo> {

	@Override
	public RoomWithAdditionalInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomWithAdditionalInfo entity = new RoomWithAdditionalInfo();
		entity.setId(rs.getLong("id"));
		entity.setNumber(rs.getString("number"));
		entity.setRoomType(rs.getString("room_type"));
		entity.setNumberOfPlaces(rs.getInt("number_of_places"));
		entity.setCostPerNight(rs.getDouble("cost_per_night"));
		entity.setAdditionalInformation(rs.getString("additional_information"));
		entity.setStatus(rs.getString("status"));
		return entity;
	}

}
