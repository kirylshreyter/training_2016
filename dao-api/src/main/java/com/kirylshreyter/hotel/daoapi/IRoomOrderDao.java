package com.kirylshreyter.hotel.daoapi;

import com.kirylshreyter.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.hotel.datamodel.RoomOrder;

public interface IRoomOrderDao extends IAbstractDao<RoomOrder> {
    RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id);
}
