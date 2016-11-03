package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.BookedRoomDao;
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
		bookedRoomDao.insert(bookedRoom);

	}

	@Override
	public BookedRoom get(Long id) {
		return bookedRoomDao.get(id);
	}

	@Override
	public void update(BookedRoom bookedRoom) {
		bookedRoomDao.update(bookedRoom);

	}

	@Override
	public void delete(Long id) {
		bookedRoomDao.delete(id);

	}

	@Override
	public List<BookedRoom> getAll() {
		List<BookedRoom> ner = new ArrayList<BookedRoom>();
		ner = bookedRoomDao.getAll();
		return ner;
	}

}
