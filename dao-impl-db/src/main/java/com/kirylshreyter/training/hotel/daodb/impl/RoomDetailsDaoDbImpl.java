package com.kirylshreyter.training.hotel.daodb.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IRoomDetailsDao;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomDetailsMapper;
import com.kirylshreyter.training.hotel.daodb.util.NotNullChecker;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

@Repository
public class RoomDetailsDaoDbImpl implements IRoomDetailsDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsDaoDbImpl.class);

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private NotNullChecker notNullChecker;

	@Override
	public Long insert(RoomDetails entity) {
		LOGGER.info("Trying to create room details in table room_details...");

		if (notNullChecker.RoomDetailsNotNullChecker(entity)) {
			final String INSERT_SQL = "INSERT INTO room_details (number_of_places,cost_per_night,room_type,additional_information) VALUES (?,?,?,?)";

			KeyHolder keyHolder = new GeneratedKeyHolder();
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
					ps.setLong(1, entity.getNumberOfPlaces());
					ps.setDouble(2, entity.getCostPerNight());
					ps.setString(3, entity.getRoomType());
					ps.setString(4, entity.getAdditionalInformation());
					return ps;
				}
			}, keyHolder);
			;
			entity.setId(keyHolder.getKey().longValue());
		}
		Long insertedId = entity.getId();
		LOGGER.info("Room details was created, id = {}", insertedId);
		return insertedId;
	}

	@Override
	public Boolean update(RoomDetails entity) {
		LOGGER.info("Trying to update room details with id = {} in table room_details...", entity.getId());
		if (notNullChecker.RoomDetailsNotNullChecker(entity)) {
			jdbcTemplate.update(
					"UPDATE room_details SET number_of_places = ?, cost_per_night = ?, room_type = ?, additional_information = ?  where id = ?",
					entity.getNumberOfPlaces(), entity.getCostPerNight(), entity.getRoomType(),
					entity.getAdditionalInformation(), entity.getId());
			LOGGER.info("Room details was updated, id = {}", entity.getId());
		}
		// TODO
		return null;

	}

	@Override
	public Boolean delete(Long id) {
		LOGGER.info("Trying to delete room details with id = {} from table room_details.", id);
		Integer deletedRows = null;
		try {
			deletedRows = jdbcTemplate.update("DELETE FROM room_details WHERE id = ?", id);
		} catch (DataIntegrityViolationException e) {
			StringBuilder sb = new StringBuilder();
			sb.append("Cannot delete room details with id = ");
			sb.append(id);
			sb.append(". This room details id-key is used as foreign key in other table.");
			throw new DataIntegrityViolationException(sb.toString());
		}
		if (deletedRows == 0) {
			StringBuilder sb = new StringBuilder();
			sb.append("Room details was NOT deleted. Room details with id = ");
			sb.append(id);
			sb.append(" does not exist.");
			LOGGER.info(sb.toString());
			throw new RuntimeException(sb.toString());
		} else {
			LOGGER.info("Room details with id = {} was deleted.", id);
		}
		// TODO
		return null;

	}

	@Override
	public List<RoomDetails> getAll() {
		return jdbcTemplate.query("SELECT * FROM room_details", new RoomDetailsMapper());
	}

}
