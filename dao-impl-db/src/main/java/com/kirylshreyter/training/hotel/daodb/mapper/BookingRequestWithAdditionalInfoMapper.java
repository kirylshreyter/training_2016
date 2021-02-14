package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;

public class BookingRequestWithAdditionalInfoMapper implements RowMapper<BookingRequestWithAdditionalInfo> {

	@Override
	public BookingRequestWithAdditionalInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		BookingRequestWithAdditionalInfo entity = new BookingRequestWithAdditionalInfo();
		entity.setNumber(rs.getString("number"));
		entity.setRoomType(rs.getString("room_type"));
		entity.setNumberOfPlaces(rs.getInt("number_of_places"));
		entity.setCostPerNight(rs.getDouble("cost_per_night"));
		entity.setAdditionalInformation(rs.getString("additional_information"));
		entity.setStatus(rs.getString("status"));
		entity.setId(rs.getLong("id"));
		entity.setFirstName(rs.getString("first_name"));
		entity.setLastName(rs.getString("last_name"));
		entity.setPhone(rs.getString("phone"));
		entity.setEmail(rs.getString("email"));
		entity.setArrivalDate(rs.getDate("arrival_date"));
		entity.setDepartureDate(rs.getDate("departure_date"));
		return entity;
	}

}
