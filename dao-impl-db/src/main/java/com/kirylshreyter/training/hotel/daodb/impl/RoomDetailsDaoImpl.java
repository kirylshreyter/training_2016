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

import com.kirylshreyter.training.hotel.daodb.RoomDetailsDao;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomDetailsMapper;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

@Repository
public class RoomDetailsDaoImpl implements RoomDetailsDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public RoomDetails get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM room_details WHERE id = ?", new Object[] { id },
				new RoomDetailsMapper());
	}

	@Override
	public Long insert(RoomDetails entity) {
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

		return entity.getId();

	}

	@Override
	public void update(RoomDetails entity) {
		jdbcTemplate.update(
				"UPDATE room_details SET number_of_places = ?, cost_per_night = ?, room_type = ?, additional_information = ?  where id = ?",
				entity.getNumberOfPlaces(), entity.getCostPerNight(), entity.getRoomType(),
				entity.getAdditionalInformation(), entity.getId());

	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM room_details WHERE id = ?", id);

	}

	@Override
	public List<RoomDetails> getAll() {
		return jdbcTemplate.query("SELECT * FROM room_details", new RoomDetailsMapper());
	}

}
