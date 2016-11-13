package com.kirylshreyter.training.hotel.daodb.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.kirylshreyter.training.hotel.datamodel.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee entity = new Employee();
		entity.setId(rs.getLong("id"));
		entity.setFirstName(rs.getString("first_name"));
		entity.setLastName(rs.getString("last_name"));
		entity.setPhone(rs.getString("phone"));
		entity.setEmail(rs.getString("email"));
		entity.setAddress(rs.getString("address"));
		entity.setPosition(rs.getString("position"));
		return entity;
	}

}