package com.kirylshreyter.training.hotel.daodb.impl;

import static java.lang.Math.toIntExact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.DateTimeException;
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

import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IBookingRequestDao;
import com.kirylshreyter.training.hotel.daodb.mapper.BookingRequestMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.BookingRequestWithAdditionalInfoMapper;
import com.kirylshreyter.training.hotel.daodb.util.DateConverter;
import com.kirylshreyter.training.hotel.daodb.util.NotNullChecker;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;

@Repository
public class BookingRequestDaoDbImpl implements IBookingRequestDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookingRequestDaoDbImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;
	@Inject
	private DateConverter dateConverter;
	@Inject
	private NotNullChecker notNullChecker;

	@Override
	public BookingRequest get(Long id) {

		return jdbcTemplate.queryForObject("SELECT * FROM booking_request WHERE id = ?", new Object[] { id },
				new BookingRequestMapper());
	}

	@Override
	public Long insert(BookingRequest entity) {
		LOGGER.info("Trying to create booking request in table booking_request ...");
		if (notNullChecker.BookingRequestNotNullChecker(entity)) {
			if (entity.getArrivalDate().getTime() > entity.getDepartureDate().getTime()) {
				throw new DateTimeException("Arrival date can not be more than departure date.");

			} else {
				try {
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
				} catch (DataIntegrityViolationException e) {
					throw new DataIntegrityViolationException(
							"Cannot create booking request. Some of inserted fields contents a value that provide links to not existing parent rows.");
				}
			}

		}
		Long insertedId = entity.getId();
		LOGGER.info("Booking Request was created, id = {}", insertedId);
		return insertedId;

	}

	@Override
	public void update(BookingRequest entity) {
		LOGGER.info("Trying to update booking request with id = {} in table booking_request.", entity.getId());
		if (notNullChecker.BookingRequestNotNullChecker(entity)) {
			try {
				jdbcTemplate.update(
						"UPDATE booking_request SET room_id, client_id = ?, arrival_date = ?, departure_date = ?  where id = ?",
						entity.getRoomId(), entity.getClientId(), entity.getArrivalDate(), entity.getDepartureDate(),
						entity.getId());
			} catch (DataIntegrityViolationException e) {
				StringBuilder sb = new StringBuilder();
				sb.append("Cannot update booking request with id = ");
				sb.append(entity.getId());
				sb.append(". Some of changed fields does not exist.");
				throw new DataIntegrityViolationException(sb.toString());
			}
			LOGGER.info("Booking Request was updated, id = {}", entity.getId());
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("Trying to delete booking request with id = {} from table booking_request.", id);
		Integer deletedRows = null;
		try {
			deletedRows = jdbcTemplate.update("DELETE FROM booking_request WHERE id = ?", id);
		} catch (DataIntegrityViolationException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Cannot delete booking request with id = ");
			sb.append(id);
			sb.append(". This booking request id-key is used as foreign key in other table.");
			throw new DataIntegrityViolationException(sb.toString());
		}
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

	@Override
	public BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id) {
		BookingRequestWithAdditionalInfo bookingRequestWithAdditionalInfo = new BookingRequestWithAdditionalInfo();
		try {
			bookingRequestWithAdditionalInfo = jdbcTemplate.queryForObject(
					"SELECT br.id,br.arrival_date,br.departure_date,r.number,r.status,rd.room_type,rd.number_of_places,rd.cost_per_night,rd.additional_information,c.first_name,c.last_name,c.phone,c.email,c.address FROM booking_request br JOIN room r ON (br.room_id=r.id) JOIN client c ON (br.client_id=c.id) JOIN room_details rd ON (r.room_details_id=rd.id) WHERE br.id=?",
					new Object[] { id }, new BookingRequestWithAdditionalInfoMapper());
		} catch (EmptyResultDataAccessException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Record with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			throw new EmptyResultDataAccessException(sb.toString(), toIntExact(id));
		} catch (CannotGetJdbcConnectionException e) {
			throw new CannotGetJdbcConnectionException("Cannot establish connection to database.", new SQLException());
		}

		return bookingRequestWithAdditionalInfo;
	}

}
