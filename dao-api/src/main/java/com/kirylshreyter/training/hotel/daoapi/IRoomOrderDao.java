package com.kirylshreyter.training.hotel.daoapi;

import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

public interface IRoomOrderDao {

	Long insert(RoomOrder entity);

	Boolean update(RoomOrder entity);

	RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id);
}
