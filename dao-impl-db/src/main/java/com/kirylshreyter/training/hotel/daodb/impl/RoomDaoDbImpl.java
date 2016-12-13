package com.kirylshreyter.training.hotel.daodb.impl;

import static java.lang.Math.toIntExact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

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

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daoapi.IRoomDao;
import com.kirylshreyter.training.hotel.daodb.mapper.AvailableRoomMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.NotAvailableRoomMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomWithAdditionalInfoMapper;
import com.kirylshreyter.training.hotel.daodb.util.NotNullChecker;
import com.kirylshreyter.training.hotel.datamodel.Room;

@Repository
public class RoomDaoDbImpl implements IRoomDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDaoDbImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private NotNullChecker notNullChecker;

	@Override
	public Long insert(Room entity) {
		LOGGER.info("Trying to create room in table room ...");
		if (notNullChecker.RoomNotNullChecker(entity)) {
			try {
				final String INSERT_SQL = "INSERT INTO room (number, room_details_id, status) VALUES (?,?,?)";

				KeyHolder keyHolder = new GeneratedKeyHolder();
				jdbcTemplate.update(new PreparedStatementCreator() {
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
						ps.setString(1, entity.getNumber());
						ps.setLong(2, entity.getRoomDetailsId());
						ps.setString(3, entity.getStatus());
						return ps;
					}
				}, keyHolder);
				;
				entity.setId(keyHolder.getKey().longValue());
			} catch (DataIntegrityViolationException e) {
				throw new DataIntegrityViolationException(
						"Cannot create room. Some of inserted fields contents a value that provide links to not existing parent rows.");
			}
		}
		Long insertedId = entity.getId();
		LOGGER.info("Room was created, id = {}", insertedId);
		return insertedId;
	}

	@Override
	public Boolean update(Room entity) {

		LOGGER.info("Trying to update room with id = {} in table room.", entity.getId());
		if (notNullChecker.RoomNotNullChecker(entity)) {
			jdbcTemplate.update("UPDATE room SET number = ?, room_details_id = ?, status = ? where id = ?",
					entity.getNumber(), entity.getRoomDetailsId(), entity.getStatus(), entity.getId());
			LOGGER.info("Room was updated, id = {}", entity.getId());
			return true;
		} else {
			return false;
		}
	}

	@Override
	public RoomWithAdditionalInfo getWithAdditionalInfo(Long id) {
		RoomWithAdditionalInfo roomWithAdditionalInfo = new RoomWithAdditionalInfo();
		try {
			roomWithAdditionalInfo = jdbcTemplate.queryForObject(
					"SELECT r.id,r.number,r.status,rd.room_type,rd.number_of_places,rd.cost_per_night,rd.additional_information FROM room r JOIN room_details rd ON (r.room_details_id=r.id) WHERE r.id=?",
					new Object[] { id }, new RoomWithAdditionalInfoMapper());
		} catch (EmptyResultDataAccessException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Record with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			throw new EmptyResultDataAccessException(sb.toString(), toIntExact(id));
		} catch (CannotGetJdbcConnectionException e) {
			throw new CannotGetJdbcConnectionException("Cannot establish connection to database.", new SQLException());
		}

		return roomWithAdditionalInfo;
	}

	@Override
	public List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT room_id FROM booking_request WHERE ((arrival_date = '");
		sb.append(departureDate);
		sb.append("') OR (arrival_date<'");
		sb.append(departureDate);
		sb.append("')) AND ((departure_date='");
		sb.append(arrivalDate);
		sb.append("') OR (departure_date>'");
		sb.append(arrivalDate);
		sb.append("'))");
		return jdbcTemplate.query(sb.toString(), new NotAvailableRoomMapper());
	}

	@Override
	public List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces) {
		List<NotAvailableRoom> listOfNotAvailableRoom = new ArrayList<NotAvailableRoom>(
				getAllNotAvailableRoom(arrivalDate, departureDate));
		ListIterator<NotAvailableRoom> a = listOfNotAvailableRoom.listIterator();
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT r.id as room_id,r.number,rd.room_type,rd.cost_per_night,rd.additional_information FROM room r JOIN room_details rd ON (r.room_details_id=rd.id) WHERE status='1' AND rd.number_of_places='");
		sb.append(numberOfPlaces);
		sb.append("'");
		try {
			while (a.hasNext() == true) {
				sb.append(" AND id<>");
				int i = a.nextIndex();
				NotAvailableRoom notAvailableRoom = listOfNotAvailableRoom.get(i);
				sb.append(notAvailableRoom.getRoomId());
				a.next();
			}
		} catch (Exception e) {
			sb.append(";");
		} finally {
			sb.append(";");
		}
		List<AvailableRoom> listAvailableRoom = new ArrayList<AvailableRoom>();
		listAvailableRoom = jdbcTemplate.query(sb.toString(), new AvailableRoomMapper());
		if (listAvailableRoom.isEmpty()) {
			throw new RuntimeException("Sorry, we are have not free numbers for you on this dates.");
		} else {
			return jdbcTemplate.query(sb.toString(), new AvailableRoomMapper());
		}
	}
}
