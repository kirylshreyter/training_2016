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

import com.kirylshreyter.training.hotel.daodb.RoomDao;
import com.kirylshreyter.training.hotel.daodb.customentity.IntersactedDate;
import com.kirylshreyter.training.hotel.daodb.mapper.IntersactedDateMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomMapper;
import com.kirylshreyter.training.hotel.daodb.util.DateConverters;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Room;

@Repository
public class RoomDaoImpl implements RoomDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Inject
	private DateConverters dateConverter;

	@Override
	public Room get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM room WHERE id = ?", new Object[] { id }, new RoomMapper());
	}

	@Override
	public Long insert(Room entity) {
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

		return entity.getId();

	}

	@Override
	public void update(Room entity) {
		jdbcTemplate.update("UPDATE room SET number = ?, room_details_id = ?, status = ? where id = ?",
				entity.getNumber(), entity.getRoomDetailsId(), entity.getStatus(), entity.getId());

	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("DELETE FROM employee WHERE id = ?", id);

	}

	@Override
	public List<Room> getAll() {
		return jdbcTemplate.query("SELECT * FROM room", new RoomMapper());
	}

	@Override
	public List<IntersactedDate> getBookedRoomWithIntersactedDate(BookingRequest bookingRequest) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				"SELECT ro.room_id, ro.booked_start_day, ro.booked_end_day FROM room_order ro JOIN room r ON (ro.room_id=r.id) WHERE (r.room_details_id=");

		sb.append(bookingRequest.getRoomDetailsId());
		sb.append(") AND (ro.booked_start_day='");
		sb.append(dateConverter.dateToStringConverter(bookingRequest.getDepartureDate()));
		sb.append("' OR ro.booked_start_day < '");
		sb.append(dateConverter.dateToStringConverter(bookingRequest.getDepartureDate()));
		sb.append("') AND (ro.booked_end_day='");
		sb.append(dateConverter.dateToStringConverter(bookingRequest.getArrivalDate()));
		sb.append("' OR ro.booked_end_day > '");
		sb.append(dateConverter.dateToStringConverter(bookingRequest.getArrivalDate()));
		sb.append("');");
		return jdbcTemplate.query(sb.toString(), new IntersactedDateMapper());

	}

}
