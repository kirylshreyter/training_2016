package com.kirylshreyter.hotel.services.impl;

import com.kirylshreyter.hotel.daoapi.IRoomDetailsDao;
import com.kirylshreyter.hotel.datamodel.RoomDetails;
import com.kirylshreyter.hotel.services.RoomDetailsService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

    @Inject
    private IRoomDetailsDao roomDetailsDao;

    @Override
    public Long create(RoomDetails entity) {
        return roomDetailsDao.create(entity);
    }

    @Override
    public RoomDetails read(Long id) {
        return null;
    }

    @Override
    public Boolean update(RoomDetails roomDetails) {
        return roomDetailsDao.update(roomDetails);

    }

    @Override
    public Integer delete(Long id) {
        return null;
    }

    @Override
    public List<RoomDetails> getAll() {
        return null;
    }
}
