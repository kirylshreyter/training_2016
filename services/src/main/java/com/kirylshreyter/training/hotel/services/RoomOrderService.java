package com.kirylshreyter.training.hotel.services;

import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

public interface RoomOrderService {
	
	Long save(RoomOrder roomOrder);

	Boolean update(RoomOrder roomOrder);

	RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id);
}
