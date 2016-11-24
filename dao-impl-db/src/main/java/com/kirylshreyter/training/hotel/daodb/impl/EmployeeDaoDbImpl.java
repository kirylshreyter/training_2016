package com.kirylshreyter.training.hotel.daodb.impl;

import static java.lang.Math.toIntExact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IEmployeeDao;
import com.kirylshreyter.training.hotel.daodb.mapper.EmployeeMapper;
import com.kirylshreyter.training.hotel.datamodel.Employee;

@Repository
public class EmployeeDaoDbImpl implements IEmployeeDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoDbImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Employee get(Long id) {
		Employee employee = new Employee();
		try {
			employee = jdbcTemplate.queryForObject("SELECT * FROM employee WHERE id = ?", new Object[] { id },
					new EmployeeMapper());
		} catch (EmptyResultDataAccessException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Record with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			throw new EmptyResultDataAccessException(sb.toString(), toIntExact(id));
		} catch (CannotGetJdbcConnectionException e) {
			throw new CannotGetJdbcConnectionException("Cannot establish connection to database.", new SQLException());
		}
		return employee;
	}

	@Override
	public Long insert(Employee entity) {
		LOGGER.info("Trying to create employee in table employee ...");
		if (notNullChecker(entity)) {
			final String INSERT_SQL = "INSERT INTO employee (first_name,last_name,phone,email,address,position) VALUES (?,?,?,?,?,?)";

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
					ps.setString(1, entity.getFirstName());
					ps.setString(2, entity.getLastName());
					ps.setString(3, entity.getPhone());
					ps.setString(4, entity.getEmail());
					ps.setString(5, entity.getAddress());
					ps.setString(6, entity.getPosition());
					return ps;
				}
			}, keyHolder);
			;
			entity.setId(keyHolder.getKey().longValue());
		}
		Long insertedId = entity.getId();
		LOGGER.info("Employee was created, id = {}", insertedId);
		return insertedId;

	}

	@Override
	public void update(Employee entity) {
		LOGGER.info("Trying to update employee with id = {} in table employee...", entity.getId());
		if (notNullChecker(entity)) {
			jdbcTemplate.update(
					"UPDATE employee SET first_name = ?, last_name = ?, phone = ?, email = ?, position = ?, address = ?  where id = ?",
					entity.getFirstName(), entity.getLastName(), entity.getPhone(), entity.getEmail(),
					entity.getPosition(), entity.getAddress(), entity.getId());
			LOGGER.info("Employee was updated, id = {}", entity.getId());
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("Trying to delete employee with id = {} from table employee.", id);
		Integer deletedRows = null;
		try {
			deletedRows = jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);
		} catch (DataIntegrityViolationException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Cannot delete employee with id = ");
			sb.append(id);
			sb.append(". This employee id-key is used as foreign key in other table.");
			throw new DataIntegrityViolationException(sb.toString());
		}
		if (deletedRows == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("Employee was NOT deleted. Employee with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			LOGGER.info(sb.toString());
			throw new RuntimeException(sb.toString());
		} else {
			LOGGER.info("Employee with id = {} was deleted.", id);
		}
	}

	@Override
	public List<Employee> getAll() {
		return jdbcTemplate.query("SELECT * FROM employee", new EmployeeMapper());
	}

	private Boolean notNullChecker(Employee entity) {
		if (entity.getFirstName() == null) {
			throw new RuntimeException("Employee's first name is not setted.");
		}
		if (entity.getLastName() == null) {
			throw new RuntimeException("Employee's last name is not setted.");
		}
		if (entity.getPhone() == null) {
			throw new RuntimeException("Employee's phone number is not setted.");
		}
		if (entity.getEmail() == null) {
			throw new RuntimeException("Employee's email is not setted.");
		}
		if (entity.getAddress() == null) {
			throw new RuntimeException("Employee's address is not setted.");
		}
		if (entity.getPosition() == null) {
			throw new RuntimeException("Employee's position is not setted.");
		}
		return true;
	}

}
