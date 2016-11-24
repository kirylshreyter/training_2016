package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;

public class NotAvailableRoomMapper implements RowMapper<NotAvailableRoom> {

	@Override
	public NotAvailableRoom mapRow(ResultSet rs, int rowNum) throws SQLException {
		NotAvailableRoom entity = new NotAvailableRoom();
		entity.setRoomId(rs.getLong("room_id"));
		return entity;
	}

}
