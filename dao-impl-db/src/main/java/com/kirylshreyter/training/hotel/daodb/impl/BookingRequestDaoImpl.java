package com.kirylshreyter.training.hotel.daodb.impl;

import static java.lang.Math.toIntExact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daodb.BookingRequestDao;
import com.kirylshreyter.training.hotel.daodb.mapper.BookingRequestMapper;
import com.kirylshreyter.training.hotel.daodb.util.DateConverter;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;

@Repository
public class BookingRequestDaoImpl implements BookingRequestDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingRequestDaoImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;
	@Inject
	DateConverter dateConverter;

	private Boolean notNullChecker(BookingRequest entity) {
		if (entity.getClientId() == null) {
			throw new RuntimeException("Client Id is not setted.");
		}
		if (entity.getRoomId() == null) {
			throw new RuntimeException("Room Id is not setted.");
		}
		if (entity.getArrivalDate() == null) {
			throw new RuntimeException("Arrival date is not setted.");
		}
		if (entity.getDepartureDate() == null) {
			throw new RuntimeException("Departure date is not setted.");
		}
		return true;
	}

	@Override
	public BookingRequest get(Long id) {
		BookingRequest bookingRequest = new BookingRequest();
		StringBuilder sb = new StringBuilder();
		sb.append("Record with id = ");
		sb.append(id);
		sb.append(" does not exist.");
		try {
			bookingRequest = jdbcTemplate.queryForObject("SELECT * FROM booking_request WHERE id = ?",
					new Object[] { id }, new BookingRequestMapper());
		} catch (EmptyResultDataAccessException e) {
			throw new EmptyResultDataAccessException(sb.toString(), toIntExact(id));
		} catch (CannotGetJdbcConnectionException e) {
			throw new CannotGetJdbcConnectionException("Cannot establish connectio to database.", new SQLException());
		}

		return bookingRequest;
	}

	@Override
	public Long insert(BookingRequest entity) {

		if (notNullChecker(entity)) {
			final String INSERT_SQL = "INSERT INTO booking_request (room_id,client_id,arrival_date,departure_date) VALUES (?,?,?,?)";

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
					ps.setLong(1, entity.getRoomId());
					ps.setLong(2, entity.getClientId());
					ps.setDate(3, dateConverter.javaUtilDateToJavaSqlDateConverter(entity.getArrivalDate()));
					ps.setDate(4, dateConverter.javaUtilDateToJavaSqlDateConverter(entity.getDepartureDate()));
					return ps;
				}
			}, keyHolder);
			;
			entity.setId(keyHolder.getKey().longValue());

		}
		Long insertedId = entity.getId();
		LOGGER.info("Booking Request was created, id = {}", insertedId);
		return insertedId;

	}

	@Override
	public void update(BookingRequest entity) {
		jdbcTemplate.update(
				"UPDATE booking_request SET room_id, client_id = ?, arrival_date = ?, departure_date = ?  where id = ?",
				entity.getRoomId(), entity.getClientId(), entity.getArrivalDate(), entity.getDepartureDate(),
				entity.getId());

	}

	@Override
	public void delete(Long id) {
		Integer deletedRows = jdbcTemplate.update("DELETE FROM booking_request WHERE id = ?", id);
		if (deletedRows == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("Booking Request was NOT deleted. Booking Request with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			LOGGER.info(sb.toString());
			throw new RuntimeException(sb.toString());
		} else {
			LOGGER.info("Booking Request with id = {} was deleted.", id);
		}

	}

	@Override
	public List<BookingRequest> getAll() {
		return jdbcTemplate.query("SELECT * FROM booking_request", new BookingRequestMapper());
	}

}
