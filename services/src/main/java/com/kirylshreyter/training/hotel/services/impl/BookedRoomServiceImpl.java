package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.BookedRoomDao;
import com.kirylshreyter.training.hotel.datamodel.BookedRoom;
import com.kirylshreyter.training.hotel.services.BookedRoomService;

@Service
public class BookedRoomServiceImpl implements BookedRoomService {

	private static final Logger LOGGER = LoggerFactory.getLogger(BookedRoomServiceImpl.class);
	@Inject
	private BookedRoomDao bookedRoomDao;

	@Override
	public void save(BookedRoom bookedRoom) {
		Long returnedId = bookedRoomDao.insert(bookedRoom);
		LOGGER.info("Booked Room was inserted, id = {}", returnedId);

	}

	@Override
	public BookedRoom get(Long id) {
		try {
			return bookedRoomDao.get(id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public void update(BookedRoom bookedRoom) {
		bookedRoomDao.update(bookedRoom);

	}

	@Override
	public void delete(Long id) {
		bookedRoomDao.delete(id);
		LOGGER.info("Booked Room was inserted, id = {}", id);

	}

	@Override
	public List<BookedRoom> getAll() {
		List<BookedRoom> bookedRoomList = new ArrayList<BookedRoom>(bookedRoomDao.getAll());
		return bookedRoomList;
	}

}
