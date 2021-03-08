package com.kirylshreyter.hotel.daoapi;

import com.kirylshreyter.hotel.commons.AvailableRoom;
import com.kirylshreyter.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.hotel.datamodel.Room;

import java.util.Date;
import java.util.List;

public interface IRoomDao extends IAbstractDao<Room> {
    RoomWithAdditionalInfo getWithAdditionalInfo(Long id);

    List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate);

    List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces);
}
