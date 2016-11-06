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

import com.kirylshreyter.training.hotel.daodb.BookedRoomDao;
import com.kirylshreyter.training.hotel.daodb.mapper.BookedRoomMapper;
import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

@Repository
public class BookedRoomDaoImpl implements BookedRoomDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public BookedRoom get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM booked_room WHERE id = ?", new Object[] { id },
				new BookedRoomMapper());

	}

	@Override
	public Long insert(BookedRoom entity) {
		final String INSERT_SQL = "INSERT INTO booked_room (booking_request_id,room_order_id) VALUES (?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setLong(1, entity.getBookingRequestId());
				ps.setLong(2, entity.getRoomOrderId());
				return ps;
			}
		}, keyHolder);
		;
		entity.setId(keyHolder.getKey().longValue());

		return entity.getId();
	}

	@Override
	public void update(BookedRoom entity) {
		jdbcTemplate.update("UPDATE booked_room SET booking_request_id = ?, room_order_id = ?  where id = ?",
				entity.getBookingRequestId(), entity.getRoomOrderId(), entity.getId());

	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM booked_room WHERE id = ?", id);

	}

	@Override
	public List<BookedRoom> getAll() {
		return jdbcTemplate.query("SELECT * FROM booked_room", new BookedRoomMapper());
	}

}
