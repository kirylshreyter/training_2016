package com.kirylshreyter.training.hotel.daodb.impl;

import java.util.List;

import javax.inject.Inject;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daodb.BookedRoomDao;
import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

@Repository
public class BookedRoomDaoImpl implements BookedRoomDao {
	
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public BookedRoom get(Long id) {
		return jdbcTemplate.queryForObject("SELECT * FROM booked_room WHERE id = ?", new Object[] { id }, new BeanPropertyRowMapper<BookedRoom>(BookedRoom.class));
		
		
	}

	@Override
	public void insert(BookedRoom entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(BookedRoom entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BookedRoom> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
