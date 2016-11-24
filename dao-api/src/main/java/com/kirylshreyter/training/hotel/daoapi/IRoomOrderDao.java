package com.kirylshreyter.training.hotel.daoapi;

import java.util.List;

import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

public interface IRoomOrderDao {

	RoomOrder get(Long id);

	Long insert(RoomOrder entity);

	void update(RoomOrder entity);

	void delete(Long id);

	List<RoomOrder> getAll();

	RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id);

}
