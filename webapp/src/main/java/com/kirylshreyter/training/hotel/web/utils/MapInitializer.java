package com.kirylshreyter.training.hotel.web.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.User;
import com.kirylshreyter.training.hotel.datamodel.Employee;
import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;
import com.kirylshreyter.training.hotel.web.model.AvailableRoomModel;
import com.kirylshreyter.training.hotel.web.model.BookingRequestModel;
import com.kirylshreyter.training.hotel.web.model.BookingRequestWithAdditionalInfoModel;
import com.kirylshreyter.training.hotel.web.model.UserModel;
import com.kirylshreyter.training.hotel.web.model.EmployeeModel;
import com.kirylshreyter.training.hotel.web.model.NotAvailableRoomModel;
import com.kirylshreyter.training.hotel.web.model.RoomDetailsModel;
import com.kirylshreyter.training.hotel.web.model.RoomModel;
import com.kirylshreyter.training.hotel.web.model.RoomOrderModel;
import com.kirylshreyter.training.hotel.web.model.RoomOrderWithAdditionalInfoModel;
import com.kirylshreyter.training.hotel.web.model.RoomWithAdditionalInfoModel;

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
