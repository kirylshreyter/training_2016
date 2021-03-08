package com.kirylshreyter.hotel.daoxml.impl;

import com.kirylshreyter.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.hotel.daoapi.IRoomOrderDao;
import com.kirylshreyter.hotel.datamodel.RoomOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomOrderDaoXmlImpl implements IRoomOrderDao {
    @Override
    public Long create(RoomOrder entity) {
        return null;
    }

    @Override
    public RoomOrder read(Long id) {
        return null;
    }

    @Override
    public Boolean update(RoomOrder entity) {
        return null;
        // TODO Auto-generated method stub

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
        // TODO Auto-generated method stub
        return null;
    }
}
