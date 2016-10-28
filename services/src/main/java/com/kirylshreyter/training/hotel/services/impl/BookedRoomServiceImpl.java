package com.kirylshreyter.training.hotel.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.kirylshreyter.training.hotel.daodb.impl.BookedRoomDaoImpl;
import com.kirylshreyter.training.hotel.datamodel.BookedRoom;
import com.kirylshreyter.training.hotel.services.BookedRoomService;

@ContextConfiguration(locations = "classpath**:service-context.xml")
public class BookedRoomServiceImpl implements BookedRoomService {
	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	ApplicationContext context = new ClassPathXmlApplicationContext("service-context.xml");
	private BookedRoomDaoImpl bookedRoomDao = (BookedRoomDaoImpl) context.getBean("bookedRoomDao");

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
