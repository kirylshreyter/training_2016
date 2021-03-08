package com.kirylshreyter.hotel.services;

import com.kirylshreyter.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.hotel.datamodel.RoomOrder;

public interface RoomOrderService extends AbstractService<RoomOrder> {
    RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id);
}
