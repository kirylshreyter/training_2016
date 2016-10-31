package com.kirylshreyter.training.hotel.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;

import com.kirylshreyter.training.hotel.daodb.BookedRoomDao;
import com.kirylshreyter.training.hotel.daodb.impl.BookedRoomDaoImpl;
import com.kirylshreyter.training.hotel.datamodel.BookedRoom;
import com.kirylshreyter.training.hotel.services.BookedRoomService;

@Service
public class BookedRoomServiceImpl implements BookedRoomService {
	@Inject
	private BookedRoomDao bookedRoomDao;

	@Override
	public void saveAll(List<BookedRoom> bookedRooms) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(BookedRoom bookedRoom) {
		// TODO Auto-generated method stub

	}

	@Override
	public BookedRoom get(Long id) {
		return bookedRoomDao.get(id);
	}

}
