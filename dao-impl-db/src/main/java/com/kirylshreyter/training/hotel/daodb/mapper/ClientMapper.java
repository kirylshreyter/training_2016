package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.datamodel.Client;

public class ClientMapper implements RowMapper<Client> {

	@Override
	public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
		Client entity = new Client();
		entity.setId(rs.getLong("id"));
		entity.setFirstName(rs.getString("first_name"));
		entity.setLastName(rs.getString("last_name"));
		entity.setAddress(rs.getString("address"));
		entity.setPhone(rs.getString("phone"));
		entity.setEmail(rs.getString("email"));
		return entity;
	}

}