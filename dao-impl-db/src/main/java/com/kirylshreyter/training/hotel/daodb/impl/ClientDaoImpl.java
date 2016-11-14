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

import com.kirylshreyter.training.hotel.daodb.ClientDao;
import com.kirylshreyter.training.hotel.daodb.mapper.ClientMapper;
import com.kirylshreyter.training.hotel.datamodel.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientDaoImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Client get(Long id) {
		Client client = new Client();
		try {
			jdbcTemplate.queryForObject("SELECT * FROM client WHERE id = ?", new Object[] { id }, new ClientMapper());
		} catch (EmptyResultDataAccessException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Record with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			throw new EmptyResultDataAccessException(sb.toString(), toIntExact(id));
		} catch (CannotGetJdbcConnectionException e) {
			throw new CannotGetJdbcConnectionException("Cannot establish connection to database.", new SQLException());
		}
		return client;
	}

	@Override
	public Long insert(Client entity) {
		LOGGER.info("Trying to create client in table client...");
		if (notNullChecker(entity) == true) {
//////////////////////////////////////////////////////////////////////////////////////////////////////
			final String INSERT_SQL = "INSERT INTO client (first_name, last_name, address,phone,email) VALUES (?,?,?,?,?)";
			KeyHolder keyHolder = new GeneratedKeyHolder();
			
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
					ps.setString(1, entity.getFirstName());
					ps.setString(2, entity.getLastName());
					ps.setString(3, entity.getAddress());
					ps.setString(4, entity.getPhone());
					ps.setString(5, entity.getEmail());
					return ps;
				}
			}, keyHolder);
			;
			entity.setId(keyHolder.getKey().longValue());
		}
		Long insertedId = entity.getId();
		LOGGER.info("Client was created, id = {}", insertedId);
		return insertedId;
	}

	@Override
	public void update(Client entity) {
		LOGGER.info("Trying to update client with id = {} in table client...", entity.getId());
		if (notNullChecker(entity)) {
			jdbcTemplate.update(
					"UPDATE client SET first_name = ?, last_name = ?, address = ?, phone = ?, email = ?  where id = ?",
					entity.getFirstName(), entity.getLastName(), entity.getAddress(), entity.getPhone(),
					entity.getEmail(), entity.getId());
			LOGGER.info("Client was updated, id = {}", entity.getId());
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("Trying to delete client with id = {} from table client.", id);
		Integer deletedRows = null;
		try {
			deletedRows = jdbcTemplate.update("DELETE FROM client WHERE id = ?", id);
		} catch (DataIntegrityViolationException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Cannot delete client with id = ");
			sb.append(id);
			sb.append(". This client id-key is used as foreign key in other table.");
			throw new DataIntegrityViolationException(sb.toString());
		}
		if (deletedRows == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("Client was NOT deleted. Client with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			LOGGER.info(sb.toString());
			throw new RuntimeException(sb.toString());
		} else {
			LOGGER.info("Client with id = {} was deleted.", id);
		}
	}

	@Override
	public List<Client> getAll() {
		return jdbcTemplate.query("SELECT * FROM client", new ClientMapper());
	}

	private Boolean notNullChecker(Client entity) {
		if (entity.getFirstName() == null) {
			throw new RuntimeException("Client's first name is not setted.");
		}
		if (entity.getLastName() == null) {
			throw new RuntimeException("Client's last name is not setted.");
		}
		if (entity.getPhone() == null) {
			throw new RuntimeException("Client's phone number is not setted.");
		}
		if (entity.getEmail() == null) {
			throw new RuntimeException("Client's email is not setted.");
		}
		if (entity.getAddress() == null) {
			throw new RuntimeException("Client's address is not setted.");
		}
		return true;
	}

}
