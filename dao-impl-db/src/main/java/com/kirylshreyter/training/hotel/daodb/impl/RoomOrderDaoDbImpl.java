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

import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IRoomOrderDao;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomOrderMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomOrderWithAdditionalInfoMapper;
import com.kirylshreyter.training.hotel.daodb.util.NotNullChecker;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

@Repository
public class RoomOrderDaoDbImpl implements IRoomOrderDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomOrderDaoDbImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private NotNullChecker notNullChecker;

	@Override
	public RoomOrder get(Long id) {
		RoomOrder roomOrder = new RoomOrder();
		try {
			roomOrder = jdbcTemplate.queryForObject("SELECT * FROM `room_order`  WHERE id = ?", new Object[] { id },
					new RoomOrderMapper());
		} catch (EmptyResultDataAccessException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Record with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			throw new EmptyResultDataAccessException(sb.toString(), toIntExact(id));
		} catch (CannotGetJdbcConnectionException e) {
			throw new CannotGetJdbcConnectionException("Cannot establish connection to database.", new SQLException());
		}

		return roomOrder;
	}

	@Override
	public Long insert(RoomOrder entity) {
		LOGGER.info("Trying to create roo order in table room_order ...");
		if (notNullChecker.RoomOrderNotNullChecker(entity)) {
			try {
				final String INSERT_SQL = "INSERT INTO room_order (booking_request_id,employee_id,total_cost) VALUES (?,?,?)";

				KeyHolder keyHolder = new GeneratedKeyHolder();
				jdbcTemplate.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
						ps.setLong(1, entity.getBookingRequestId());
						ps.setLong(2, entity.getEmployeeId());
						ps.setDouble(3, entity.getTotalCost());
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
		Long insertedId = entity.getId();
		LOGGER.info("Room order was created, id = {}", insertedId);

		return insertedId;

	}

	@Override
	public void update(RoomOrder entity) {
		LOGGER.info("Trying to update room order with id = {} in table room_order.", entity.getId());
		if (notNullChecker.RoomOrderNotNullChecker(entity)) {
			try {
				jdbcTemplate.update(
						"UPDATE room_order SET booking_request_id = ?, employee_id = ?, total_cost = ? where id = ?",
						entity.getBookingRequestId(), entity.getEmployeeId(), entity.getTotalCost(), entity.getId());
			} catch (DataIntegrityViolationException e) {
				StringBuilder sb = new StringBuilder();
				sb.append("Cannot update room order with id = ");
				sb.append(entity.getId());
				sb.append(". Some of changed fields does not exist.");
				throw new DataIntegrityViolationException(sb.toString());
			}
			LOGGER.info("Room order was updated, id = {}", entity.getId());
		}
	}

	@Override
	public void delete(Long id) {
		LOGGER.info("Trying to delete room order with id = {} from table room_order.", id);
		Integer deletedRows = null;
		try {
			deletedRows = jdbcTemplate.update("DELETE FROM room_order WHERE id = ?", id);
		} catch (DataIntegrityViolationException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Cannot delete room order with id = ");
			sb.append(id);
			sb.append(". This room order id-key is used as foreign key in other table.");
			throw new DataIntegrityViolationException(sb.toString());
		}
		if (deletedRows == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("Room order was NOT deleted. Booking Request with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			LOGGER.info(sb.toString());
			throw new RuntimeException(sb.toString());
		} else {
			LOGGER.info("Room order with id = {} was deleted.", id);
		}

	}

	@Override
	public List<RoomOrder> getAll() {
		return jdbcTemplate.query("SELECT * FROM room_order", new RoomOrderMapper());
	}

	@Override
	public RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id) {
		RoomOrderWithAdditionalInfo roomOrderWithAdditionalInfo = new RoomOrderWithAdditionalInfo();
		try {
			roomOrderWithAdditionalInfo = jdbcTemplate.queryForObject(
					"SELECT ro.id,br.arrival_date,br.departure_date,r.number,r.status,rd.room_type,rd.number_of_places,rd.cost_per_night,rd.additional_information, c.first_name as client_first_name,c.last_name as client_last_name,c.phone as client_phone,c.email as client_email,c.address as client_address,e.first_name as employee_first_name,e.last_name as employee_last_name,e.phone as employee_phone,e.email as employee_email,e.address as employee_address,e.position as employee_position FROM room_order ro JOIN booking_request br ON (ro.booking_request_id=br.id) JOIN employee e ON (ro.employee_id=e.id) JOIN client c ON (br.client_id=c.id) JOIN room r ON (br.room_id=r.id) JOIN room_details rd ON (r.room_details_id=rd.id) WHERE ro.id=?",
					new Object[] { id }, new RoomOrderWithAdditionalInfoMapper());
		} catch (EmptyResultDataAccessException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Record with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			throw new EmptyResultDataAccessException(sb.toString(), toIntExact(id));
		} catch (CannotGetJdbcConnectionException e) {
			throw new CannotGetJdbcConnectionException("Cannot establish connection to database.", new SQLException());
		}

		return roomOrderWithAdditionalInfo;
	}
}
