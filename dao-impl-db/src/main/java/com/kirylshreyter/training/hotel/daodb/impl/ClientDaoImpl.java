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

import com.kirylshreyter.training.hotel.daodb.ClientDao;
import com.kirylshreyter.training.hotel.daodb.mapper.ClientMapper;
import com.kirylshreyter.training.hotel.datamodel.Client;

@Repository
public class ClientDaoImpl implements ClientDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Client get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM client WHERE id = ?", new Object[] { id },
				new ClientMapper());
	}

	@Override
	public Long insert(Client entity) {
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

		return entity.getId();
	}

	@Override
	public void update(Client entity) {
		jdbcTemplate.update(
				"UPDATE client SET first_name = ?, last_name = ?, address = ?, phone = ?, email = ?  where id = ?",
				entity.getFirstName(), entity.getLastName(), entity.getAddress(), entity.getPhone(), entity.getEmail(),
				entity.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM client WHERE id = ?", id);
	}

	@Override
	public List<Client> getAll() {
		return jdbcTemplate.query("SELECT * FROM client", new ClientMapper());
	}

}