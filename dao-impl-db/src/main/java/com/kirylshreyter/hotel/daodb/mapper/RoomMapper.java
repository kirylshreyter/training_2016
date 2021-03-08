package com.kirylshreyter.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.hotel.datamodel.Room;

public class RoomMapper implements RowMapper<Room> {
	public Room mapRow(ResultSet rs, int rowNum) throws SQLException {
		Room entity = new Room();
		entity.setId(rs.getLong("id"));
		entity.setNumber(rs.getString("number"));
		entity.setRoomDetailsId(rs.getLong("room_details_id"));
		entity.setStatus(rs.getString("status"));
		return entity;

	}
}