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

import com.kirylshreyter.training.hotel.daoapi.IRoomDetailsDao;
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
			return true;
		} else {
			return false;
		}
	}
}
