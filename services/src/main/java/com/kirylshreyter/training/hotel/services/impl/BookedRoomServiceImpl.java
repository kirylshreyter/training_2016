package com.kirylshreyter.training.hotel.services.impl;

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
		if (bookedRoom.getId() == null) {
			bookedRoomDao.insert(bookedRoom);
        } else {
        	bookedRoomDao.update(bookedRoom);
        }
	}

	@Override
	public BookedRoom get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
