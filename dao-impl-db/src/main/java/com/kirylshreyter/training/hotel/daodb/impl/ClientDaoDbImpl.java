package com.kirylshreyter.training.hotel.daodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IClientDao;
import com.kirylshreyter.training.hotel.daodb.util.NotNullChecker;
import com.kirylshreyter.training.hotel.datamodel.Client;

@Repository
public class ClientDaoDbImpl implements IClientDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientDaoDbImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private NotNullChecker notNullChecker;

	@Override
	public Long insert(Client entity) {
		LOGGER.info("Trying to create client in table client...");
		if (notNullChecker.clientNotNullChecker(entity)) {
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
			LOGGER.info("Client was created, id = {}", entity.getId());
			return entity.getId();
		}else{
			return null;
		}
		
	}

	@Override
	public Boolean update(Client entity) {
		LOGGER.info("Trying to update client with id = {} in table client...", entity.getId());
		if (notNullChecker.clientNotNullChecker(entity)) {
			jdbcTemplate.update(
					"UPDATE client SET first_name = ?, last_name = ?, address = ?, phone = ?, email = ?  where id = ?",
					entity.getFirstName(), entity.getLastName(), entity.getAddress(), entity.getPhone(),
					entity.getEmail(), entity.getId());
			LOGGER.info("Client was updated, id = {}", entity.getId());
			return true;
		} else {
			return false;
		}
	}
}
