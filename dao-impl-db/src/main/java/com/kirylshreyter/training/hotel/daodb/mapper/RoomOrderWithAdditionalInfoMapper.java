package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;

public class RoomOrderWithAdditionalInfoMapper implements RowMapper<RoomOrderWithAdditionalInfo> {

	@Override
	public RoomOrderWithAdditionalInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		RoomOrderWithAdditionalInfo entity = new RoomOrderWithAdditionalInfo();
		entity.setNumber(rs.getString("number"));
		entity.setRoomType(rs.getString("room_type"));
		entity.setNumberOfPlaces(rs.getInt("number_of_places"));
		entity.setCostPerNight(rs.getDouble("cost_per_night"));
		entity.setAdditionalInformation(rs.getString("additional_information"));
		entity.setStatus(rs.getString("status"));
		entity.setId(rs.getLong("id"));
		entity.setArrivalDate(rs.getDate("arrival_date"));
		entity.setDepartureDate(rs.getDate("departure_date"));
		entity.setClientFirstName(rs.getString("client_first_name"));
		entity.setClientLastName(rs.getString("client_last_name"));
		entity.setClientPhone(rs.getString("client_phone"));
		entity.setClientEmail(rs.getString("client_email"));
		entity.setEmployeeFirstName(rs.getString("employee_first_name"));
		entity.setEmployeeLastName(rs.getString("employee_last_name"));
		entity.setEmployeePhone(rs.getString("employee_phone"));
		entity.setEmployeeEmail(rs.getString("employee_email"));
		entity.setEmployeePosition(rs.getString("employee_position"));
		entity.setTotalCost(rs.getDouble("total_cost"));
		return entity;
	}

}
