package com.kirylshreyter.hotel.services.impl;

import com.kirylshreyter.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.hotel.daoapi.IRoomOrderDao;
import com.kirylshreyter.hotel.datamodel.RoomOrder;
import com.kirylshreyter.hotel.services.RoomOrderService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class RoomOrderServiceImpl implements RoomOrderService {

    @Inject
    private IRoomOrderDao roomOrderDao;

    @Override
    public Long create(RoomOrder entity) {
        return roomOrderDao.create(entity);
    }

    @Override
    public RoomOrder read(Long id) {
        return null;
    }

    @Override
    public Boolean update(RoomOrder roomOrder) {
        return roomOrderDao.update(roomOrder);
    }

    @Override
    public Integer delete(Long id) {
        return null;
    }

    @Override
    public List<RoomOrder> getAll() {
        return null;
    }

    @Override
    public RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id) {
        return roomOrderDao.getWithAdditionalInfo(id);
    }

}
