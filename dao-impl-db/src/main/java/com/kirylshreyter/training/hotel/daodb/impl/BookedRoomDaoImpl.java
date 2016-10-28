package com.kirylshreyter.training.hotel.daodb.impl;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.kirylshreyter.training.hotel.daodb.BookedRoomDao;
import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

public class BookedRoomDaoImpl implements BookedRoomDao {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("service-context.xml");
	private JdbcTemplate jdbcTemplate = (JdbcTemplate) context.getBean("jdbcTemplate");

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
