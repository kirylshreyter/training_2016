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

import com.kirylshreyter.training.hotel.daodb.RoomOrderDao;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomOrderMapper;
import com.kirylshreyter.training.hotel.daodb.util.DateConverters;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

@Repository
public class RoomOrderDaoImpl implements RoomOrderDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	@Inject
	private DateConverters dateConverter;

	@Override
	public RoomOrder get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM `room_order`  WHERE id = ?", new Object[] { id },
				new RoomOrderMapper());
	}

	@Override
	public Long insert(RoomOrder entity) {
		final String INSERT_SQL = "INSERT INTO room_order (room_id,booking_request_id,employee_id,total_cost,booked_start_day,booked_end_day) VALUES (?,?,?,?,?,?)";

		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setLong(1, entity.getRoomId());
				ps.setLong(2, entity.getBookingRequestId());
				ps.setLong(3, entity.getEmployeeId());
				ps.setDouble(4, entity.getTotalCost());
				ps.setString(5, dateConverter.dateToStringConverter(entity.getBookedStartDay()));
				ps.setString(6, dateConverter.dateToStringConverter(entity.getBookedEndDay()));
				return ps;
			}
		}, keyHolder);
		;
		entity.setId(keyHolder.getKey().longValue());

		return entity.getId();
	}

	@Override
	public void update(RoomOrder entity) {
		jdbcTemplate.update(
				"UPDATE room_order SET room_id = ?, booking_request_id = ?, employee_id = ?, total_cost = ?, booked_start_day = ?, booked_end_day = ?  where id = ?",
				entity.getRoomId(), entity.getBookingRequestId(), entity.getEmployeeId(), entity.getTotalCost(),
				entity.getBookedStartDay(), entity.getBookedEndDay(), entity.getId());

	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM room_order WHERE id = ?", id);

	}

	@Override
	public List<RoomOrder> getAll() {
		return jdbcTemplate.query("SELECT * FROM room_order", new RoomOrderMapper());
	}

}
