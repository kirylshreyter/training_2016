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

import com.kirylshreyter.training.hotel.daodb.BookingRequestDao;
import com.kirylshreyter.training.hotel.daodb.mapper.BookingRequestMapper;
import com.kirylshreyter.training.hotel.daodb.util.DateConverters;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;

@Repository
public class BookingRequestDaoImpl implements BookingRequestDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	@Inject
	DateConverters dateConverter;

	@Override
	public BookingRequest get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM booking_request WHERE id = ?", new Object[] { id },
				new BookingRequestMapper());
	}

	@Override
	public Long insert(BookingRequest entity) {
		final String INSERT_SQL = "INSERT INTO booking_request (client_id, room_details_id, arrival_date,departure_date) VALUES (?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setLong(1, entity.getClientId());
				ps.setLong(2, entity.getRoomDetailsId());
				ps.setString(3, dateConverter.dateToStringConverter(entity.getArrivalDate()));
				ps.setString(4, dateConverter.dateToStringConverter(entity.getDepartureDate()));
				return ps;
			}
		}, keyHolder);
		;
		entity.setId(keyHolder.getKey().longValue());

		return entity.getId();
	}

	@Override
	public void update(BookingRequest entity) {
		jdbcTemplate.update(
				"UPDATE booking_request SET client_id = ?, room_details_id = ?, arrival_date = ?, departure_date = ?  where id = ?",
				entity.getClientId(), entity.getRoomDetailsId(), entity.getArrivalDate(), entity.getDepartureDate(),
				entity.getId());

	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM booking_request WHERE id = ?", id);

	}

	@Override
	public List<BookingRequest> getAll() {
		return jdbcTemplate.query("SELECT * FROM booking_request", new BookingRequestMapper());
	}

}
