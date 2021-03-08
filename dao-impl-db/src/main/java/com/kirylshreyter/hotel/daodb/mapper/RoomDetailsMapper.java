package com.kirylshreyter.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.hotel.datamodel.RoomDetails;

public class RoomDetailsMapper implements RowMapper<RoomDetails> {

	@Override
	public RoomDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomDetails entity = new RoomDetails();
		entity.setId(rs.getLong("id"));
		entity.setNumberOfPlaces(rs.getInt("number_of_places"));
		entity.setCostPerNight(rs.getDouble("cost_per_night"));
		entity.setRoomType(rs.getString("room_type"));
		entity.setAdditionalInformation(rs.getString("additional_information"));
		return entity;
	}
}