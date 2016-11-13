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
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

@Repository
public class RoomOrderDaoImpl implements RoomOrderDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public RoomOrder get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM `room_order`  WHERE id = ?", new Object[] { id },
				new RoomOrderMapper());
	}

	@Override
	public Long insert(RoomOrder entity) {
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

		return entity.getId();
	}

	@Override
	public void update(RoomOrder entity) {
		jdbcTemplate.update(
				"UPDATE room_order SET booking_request_id = ?, employee_id = ?, total_cost = ? where id = ?",
				entity.getBookingRequestId(), entity.getEmployeeId(), entity.getTotalCost(), entity.getId());

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
