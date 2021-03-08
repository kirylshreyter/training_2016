package com.kirylshreyter.hotel.services.impl;

import com.kirylshreyter.hotel.commons.AvailableRoom;
import com.kirylshreyter.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.hotel.daoapi.IRoomDao;
import com.kirylshreyter.hotel.datamodel.Room;
import com.kirylshreyter.hotel.services.RoomService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Inject
    private IRoomDao roomDao;

    @Override
    public Long create(Room entity) {
        return roomDao.create(entity);
    }

    @Override
    public Room read(Long id) {
        return null;
    }

    @Override
    public Boolean update(Room room) {
        return roomDao.update(room);
    }

    @Override
    public Integer delete(Long id) {
        return null;
    }

    @Override
    public List<Room> getAll() {
        return null;
    }

    @Override
    public RoomWithAdditionalInfo getWithAdditionalInfo(Long id) {
        return roomDao.getWithAdditionalInfo(id);
    }

    @Override
    public List<AvailableRoom> getAllAvailableRoom(Date arrivalDate, Date departureDate, Integer numberOfPlaces) {
        return roomDao.getAllAvailableRoom(arrivalDate, departureDate, numberOfPlaces);
    }

    @Override
    public List<NotAvailableRoom> getAllNotAvailableRoom(Date arrivalDate, Date departureDate) {
        return roomDao.getAllNotAvailableRoom(arrivalDate, departureDate);
    }

}
