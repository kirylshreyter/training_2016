package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

public class RoomDetailsMapper implements RowMapper<RoomDetails> {

	@Override
	public RoomDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomDetails entity = new RoomDetails();
		entity.setNumberOfPlaces(rs.getInt("number_of_places"));
		entity.setCostPerNight(rs.getDouble("cost_per_night"));
		entity.setRoomType(rs.getString("room_type"));
		entity.setFloor(rs.getString("floor"));
		return entity;
	}
}