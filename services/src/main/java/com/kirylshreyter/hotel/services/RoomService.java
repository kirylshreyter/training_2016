package com.kirylshreyter.hotel.services;

import com.kirylshreyter.hotel.commons.AvailableRoom;
import com.kirylshreyter.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.hotel.datamodel.Room;

import java.util.Date;
import java.util.List;

public interface RoomService extends AbstractService<Room> {
    RoomWithAdditionalInfo getWithAdditionalInfo(Long id);

    List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate);

    List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces);
}
