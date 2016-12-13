package com.kirylshreyter.training.hotel.daoapi;

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

public interface IRoomDetailsDao {

	Long insert(RoomDetails entity);

	Boolean update(RoomDetails entity);
}
