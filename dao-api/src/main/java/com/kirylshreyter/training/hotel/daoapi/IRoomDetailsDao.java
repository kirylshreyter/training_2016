package com.kirylshreyter.training.hotel.daoapi;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

public interface IRoomDetailsDao {

	Long insert(RoomDetails entity);

	Boolean update(RoomDetails entity);

	Boolean delete(Long id);

	List<RoomDetails> getAll();

}
