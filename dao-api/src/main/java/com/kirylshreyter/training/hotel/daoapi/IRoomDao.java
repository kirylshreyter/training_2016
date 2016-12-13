package com.kirylshreyter.training.hotel.daoapi;

import java.util.Date;
import java.util.List;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.Room;

public interface IRoomDao {

	Long insert(Room entity);

	Boolean update(Room entity);

	RoomWithAdditionalInfo getWithAdditionalInfo(Long id);

	List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate);

	List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces);

}
