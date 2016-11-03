package com.kirylshreyter.training.hotel.daodb.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daodb.BookedRoomDao;
import com.kirylshreyter.training.hotel.daodb.mapper.AllBookesRoomMapper;
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
	public void insert(BookedRoom entity) {
		jdbcTemplate.update(
				"INSERT INTO booked_room (booking_request_id,room_order_id,booked_start_day,booked_end_day) VALUES (?,?,?,?)",
				entity.getBookingRequestId(), entity.getRoomOrderId(), entity.getBookedStartDay(),
				entity.getBookedEndDay());
	}

	@Override
	public void update(BookedRoom entity) {
		jdbcTemplate.update(
				"UPDATE booked_room SET booking_request_id = ?, room_order_id = ?, booked_start_day = ?, booked_end_day = ?  where id = ?",
				entity.getBookingRequestId(), entity.getRoomOrderId(), entity.getBookedStartDay(),
				entity.getBookedEndDay(), entity.getId());

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
