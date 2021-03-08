package com.kirylshreyter.hotel.web.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kirylshreyter.hotel.datamodel.BookingRequest;
import com.kirylshreyter.hotel.datamodel.Employee;
import com.kirylshreyter.hotel.datamodel.User;
import com.kirylshreyter.hotel.web.model.AvailableRoomModel;
import com.kirylshreyter.hotel.web.model.BookingRequestModel;
import com.kirylshreyter.hotel.web.model.UserModel;
import com.kirylshreyter.hotel.commons.AvailableRoom;
import com.kirylshreyter.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.hotel.datamodel.Room;
import com.kirylshreyter.hotel.datamodel.RoomDetails;
import com.kirylshreyter.hotel.datamodel.RoomOrder;
import com.kirylshreyter.hotel.web.model.BookingRequestWithAdditionalInfoModel;
import com.kirylshreyter.hotel.web.model.EmployeeModel;
import com.kirylshreyter.hotel.web.model.NotAvailableRoomModel;
import com.kirylshreyter.hotel.web.model.RoomDetailsModel;
import com.kirylshreyter.hotel.web.model.RoomModel;
import com.kirylshreyter.hotel.web.model.RoomOrderModel;
import com.kirylshreyter.hotel.web.model.RoomOrderWithAdditionalInfoModel;
import com.kirylshreyter.hotel.web.model.RoomWithAdditionalInfoModel;

public class MapInitializer {

	static final Map<Object, Object> MAP = new HashMap<>();
	static final Map<Object, Object> MAP_MODEL = new HashMap<>();

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

		List<Object> arrayOfWebModelObjects = new ArrayList<Object>();
		arrayOfWebModelObjects.add(new AvailableRoomModel());
		arrayOfWebModelObjects.add(new BookingRequestModel());
		arrayOfWebModelObjects.add(new BookingRequestWithAdditionalInfoModel());
		arrayOfWebModelObjects.add(new UserModel());
		arrayOfWebModelObjects.add(new EmployeeModel());
		arrayOfWebModelObjects.add(new NotAvailableRoomModel());
		arrayOfWebModelObjects.add(new RoomDetailsModel());
		arrayOfWebModelObjects.add(new RoomModel());
		arrayOfWebModelObjects.add(new RoomOrderModel());
		arrayOfWebModelObjects.add(new RoomOrderWithAdditionalInfoModel());
		arrayOfWebModelObjects.add(new RoomWithAdditionalInfoModel());

		for (int i = 0; i < arrayOfDatamodelObjects.size(); i++) {
			MAP.put(arrayOfDatamodelObjects.get(i).getClass().getName(),
					arrayOfWebModelObjects.get(i).getClass().getName());
		}
		for (int i = 0; i < arrayOfWebModelObjects.size(); i++) {
			MAP_MODEL.put(arrayOfWebModelObjects.get(i).getClass().getName(),
					arrayOfDatamodelObjects.get(i).getClass().getName());
		}
	}
}
