package com.kirylshreyter.training.hotel.daodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daodb.EmployeeDao;
import com.kirylshreyter.training.hotel.daodb.mapper.EmployeeMapper;
import com.kirylshreyter.training.hotel.datamodel.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?", new Object[] { id },
				new EmployeeMapper());
	}

	@Override
	public Long insert(Employee entity) {

		final String INSERT_SQL = "INSERT INTO employee (first_name,last_name,phone,email,position) VALUES (?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getFirstName());
				ps.setString(2, entity.getLastName());
				ps.setString(3, entity.getPhone());
				ps.setString(4, entity.getEmail());
				ps.setString(5, entity.getPosition());
				return ps;
			}
		}, keyHolder);
		;
		entity.setId(keyHolder.getKey().longValue());

		return entity.getId();

	}

	@Override
	public void update(Employee entity) {
		jdbcTemplate.update(
				"UPDATE employee SET first_name = ?, last_name = ?, phone = ?, email = ?, position = ?  where id = ?",
				entity.getFirstName(), entity.getLastName(), entity.getPhone(), entity.getEmail(), entity.getPosition(),
				entity.getId());

	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);

	}

	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
	}

}
