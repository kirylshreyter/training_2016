package com.kirylshreyter.training.hotel.daodb;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

public interface BookedRoomDao {
	
	BookedRoom get(Long id);

    void insert(BookedRoom entity);

    void update(BookedRoom entity);

    void delete(Long id);

    List<BookedRoom> getAll();

}
