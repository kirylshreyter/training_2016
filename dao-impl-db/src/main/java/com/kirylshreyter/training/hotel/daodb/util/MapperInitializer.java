package com.kirylshreyter.training.hotel.daodb.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.daodb.mapper.AvailableRoomMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.BookingRequestMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.BookingRequestWithAdditionalInfoMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.ClientMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.EmployeeMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.NotAvailableRoomMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomDetailsMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomOrderMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomOrderWithAdditionalInfoMapper;
import com.kirylshreyter.training.hotel.daodb.mapper.RoomWithAdditionalInfoMapper;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.datamodel.Employee;
import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

@Component
public class MapperInitializer {
	
	public Map<Object, Object> initializeMapper() {
		Map<Object, Object> map = new HashMap<>();
		List<Object> arrayOfDatamodelObjects = new ArrayList<Object>();
		arrayOfDatamodelObjects.add(new AvailableRoom());
		arrayOfDatamodelObjects.add(new BookingRequest());
		arrayOfDatamodelObjects.add(new BookingRequestWithAdditionalInfo());
		arrayOfDatamodelObjects.add(new Client());
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
		arrayOfMappers.add(new ClientMapper());
		arrayOfMappers.add(new EmployeeMapper());
		arrayOfMappers.add(new NotAvailableRoomMapper());
		arrayOfMappers.add(new RoomDetailsMapper());
		arrayOfMappers.add(new RoomMapper());
		arrayOfMappers.add(new RoomOrderMapper());
		arrayOfMappers.add(new RoomOrderWithAdditionalInfoMapper());
		arrayOfMappers.add(new RoomWithAdditionalInfoMapper());

		for (int i = 0; i < arrayOfDatamodelObjects.size(); i++) {
			map.put(arrayOfDatamodelObjects.get(i).getClass().getName(), arrayOfMappers.get(i).getClass().getName());
		}
		return Collections.unmodifiableMap(map);

	}

}
