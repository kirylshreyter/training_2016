package com.kirylshreyter.training.hotel.services;

import java.util.List;

import com.kirylshreyter.training.hotel.daodb.customentity.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

public interface RoomOrderService {
	void save(RoomOrder roomOrder);

	void update(RoomOrder roomOrder);

	RoomOrder get(Long id);

	List<RoomOrder> getAll();

	void delete(Long id);

	RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id);

}
