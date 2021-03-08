package com.kirylshreyter.hotel.daodb.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kirylshreyter.hotel.daodb.mapper.AvailableRoomMapper;
import com.kirylshreyter.hotel.daodb.mapper.BookingRequestMapper;
import com.kirylshreyter.hotel.daodb.mapper.NotAvailableRoomMapper;
import com.kirylshreyter.hotel.daodb.mapper.RoomOrderMapper;
import com.kirylshreyter.hotel.commons.AvailableRoom;
import com.kirylshreyter.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.hotel.daodb.mapper.BookingRequestWithAdditionalInfoMapper;
import com.kirylshreyter.hotel.daodb.mapper.UserMapper;
import com.kirylshreyter.hotel.daodb.mapper.EmployeeMapper;
import com.kirylshreyter.hotel.daodb.mapper.RoomDetailsMapper;
import com.kirylshreyter.hotel.daodb.mapper.RoomMapper;
import com.kirylshreyter.hotel.daodb.mapper.RoomOrderWithAdditionalInfoMapper;
import com.kirylshreyter.hotel.daodb.mapper.RoomWithAdditionalInfoMapper;
import com.kirylshreyter.hotel.datamodel.BookingRequest;
import com.kirylshreyter.hotel.datamodel.User;
import com.kirylshreyter.hotel.datamodel.Employee;
import com.kirylshreyter.hotel.datamodel.Room;
import com.kirylshreyter.hotel.datamodel.RoomDetails;
import com.kirylshreyter.hotel.datamodel.RoomOrder;

public class MapperInitializer {

	public static final Map<Object, Object> MAPPERS_MAP = new HashMap<>();

	static {
		List<Object> arrayOfDatamodelObjects = new ArrayList<Object>();
		arrayOfDatamodelObjects.add(new AvailableRoom());
		arrayOfDatamodelObjects.add(new BookingRequest());
		arrayOfDatamodelObjects.add(new BookingRequestWithAdditionalInfo());
		arrayOfDatamodelObjects.add(new User());
		arrayOfDatamodelObjects.add(new Employee());
		arrayOfDatamodelObjects.add(new NotAvailableRoom());
		arrayOfDatamodelObjects.add(new RoomDetails());
		arrayOfDatamodelObjects.add(new Room());
		arrayOfDatamodelObjects.add(new RoomOrder());
		arrayOfDatamodelObjects.add(new RoomOrderWithAdditionalInfo());
		arrayOfDatamodelObjects.add(new RoomWithAdditionalInfo());

		List<Object> arrayOfMappers = new ArrayList<Object>();
		arrayOfMappers.add(new AvailableRoomMapper());
		arrayOfMappers.add(new BookingRequestMapper());
		arrayOfMappers.add(new BookingRequestWithAdditionalInfoMapper());
		arrayOfMappers.add(new UserMapper());
		arrayOfMappers.add(new EmployeeMapper());
		arrayOfMappers.add(new NotAvailableRoomMapper());
		arrayOfMappers.add(new RoomDetailsMapper());
		arrayOfMappers.add(new RoomMapper());
		arrayOfMappers.add(new RoomOrderMapper());
		arrayOfMappers.add(new RoomOrderWithAdditionalInfoMapper());
		arrayOfMappers.add(new RoomWithAdditionalInfoMapper());

		for (int i = 0; i < arrayOfDatamodelObjects.size(); i++) {
			MAPPERS_MAP.put(arrayOfDatamodelObjects.get(i).getClass().getName(),
					arrayOfMappers.get(i).getClass().getName());
		}
	}
}
