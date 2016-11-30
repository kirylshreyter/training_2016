package com.kirylshreyter.training.hotel.web.classloader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.kirylshreyter.training.hotel.commons.AvailableRoom;
import com.kirylshreyter.training.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.training.hotel.commons.NotAvailableRoom;
import com.kirylshreyter.training.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.training.hotel.commons.RoomWithAdditionalInfo;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.datamodel.Employee;
import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;
import com.kirylshreyter.training.hotel.web.model.AvailableRoomModel;
import com.kirylshreyter.training.hotel.web.model.BookingRequestModel;
import com.kirylshreyter.training.hotel.web.model.BookingRequestWithAdditionalInfoModel;
import com.kirylshreyter.training.hotel.web.model.ClientModel;
import com.kirylshreyter.training.hotel.web.model.EmployeeModel;
import com.kirylshreyter.training.hotel.web.model.NotAvailableRoomModel;
import com.kirylshreyter.training.hotel.web.model.RoomDetailsModel;
import com.kirylshreyter.training.hotel.web.model.RoomModel;
import com.kirylshreyter.training.hotel.web.model.RoomOrderModel;
import com.kirylshreyter.training.hotel.web.model.RoomOrderWithAdditionalInfoModel;
import com.kirylshreyter.training.hotel.web.model.RoomWithAdditionalInfoModel;

public class MapInitializer {

	public static void main(String[] args) {
		// Map<String, Object> myObjectAsDict = new HashMap<>();
		final Map<Object, Object> map = new HashMap<>();
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

		List<Object> arrayOfWebModelObjects = new ArrayList<Object>();
		arrayOfWebModelObjects.add(new AvailableRoomModel());
		arrayOfWebModelObjects.add(new BookingRequestModel());
		arrayOfWebModelObjects.add(new BookingRequestWithAdditionalInfoModel());
		arrayOfWebModelObjects.add(new ClientModel());
		arrayOfWebModelObjects.add(new EmployeeModel());
		arrayOfWebModelObjects.add(new NotAvailableRoomModel());
		arrayOfWebModelObjects.add(new RoomDetailsModel());
		arrayOfWebModelObjects.add(new RoomModel());
		arrayOfWebModelObjects.add(new RoomOrderModel());
		arrayOfWebModelObjects.add(new RoomOrderWithAdditionalInfoModel());
		arrayOfWebModelObjects.add(new RoomWithAdditionalInfoModel());

		for (int i = 0; i < arrayOfDatamodelObjects.size(); i++) {
			map.put(arrayOfDatamodelObjects.get(i).getClass(), arrayOfWebModelObjects.get(i).getClass());

		}
		if (new Client().getClass().isInstance(new Employee())){
			System.out.println(true);
		}else{
			System.out.println(false);
		};

	}
}

/*
 * Field[] allFields; for (int i = 0; i < list.size(); i++) { allFields =
 * list.get(i).getClass().getDeclaredFields(); for (Field field : allFields) {
 * Class<?> targetType = field.getType(); Object objectValue = null; try {
 * objectValue = targetType.newInstance(); } catch (InstantiationException e) {
 * // TODO Auto-generated catch block e.printStackTrace(); } catch
 * (IllegalAccessException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } Object value = null; try { value =
 * field.get(objectValue); } catch (IllegalArgumentException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } catch
 * (IllegalAccessException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } myObjectAsDict.put(field.getName(), value); }
 * 
 * }
 */

/*
 * List<Field> allFields = new ArrayList<>(); for (int i = 0; i < list.size();
 * i++) {
 * 
 * ReflectionUtils.doWithFields(list.get(i).getClass(), new FieldCallback() {
 * public void doWith(Field field) throws IllegalArgumentException,
 * IllegalAccessException { field.setAccessible(true); allFields.add(field); }
 * }); }
 * 
 * for (Field field : allFields) { Class<?> targetType = field.getType(); Object
 * objectValue = null; try { objectValue = targetType.newInstance(); } catch
 * (InstantiationException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } catch (IllegalAccessException e) { // TODO
 * Auto-generated catch block e.printStackTrace(); } Object value = null; try {
 * value = field.get(objectValue); } catch (IllegalArgumentException e) { //
 * TODO Auto-generated catch block e.printStackTrace(); } catch
 * (IllegalAccessException e) { // TODO Auto-generated catch block
 * e.printStackTrace(); } myObjectAsDict.put(field.getName(), value); }
 * 
 * for (int i = 0; i < myObjectAsDict.size(); i++) {
 * System.out.println(myObjectAsDict.get(i).toString()); }
 */

/*
 * abstractModel.setId(75L); System.out.println(abstractModel.hashCode());
 * System.out.println(abstractModel1.hashCode());
 * System.out.println(abstractModel.equals(abstractModel1));
 * ReflectionUtils.doWithFields(abstractModel.getClass(), new FieldCallback() {
 * public void doWith(Field field) throws IllegalArgumentException,
 * IllegalAccessException { field.setAccessible(true); field.set(abstractModel,
 * null); } }); ReflectionUtils.doWithFields(abstractModel1.getClass(), new
 * FieldCallback() { public void doWith(Field field) throws
 * IllegalArgumentException, IllegalAccessException { field.setAccessible(true);
 * field.set(abstractModel1, null); } });
 * System.out.println(abstractModel.hashCode());
 * System.out.println(abstractModel1.hashCode());
 * System.out.println(abstractModel.equals(abstractModel1));
 */

