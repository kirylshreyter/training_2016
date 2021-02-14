package com.kirylshreyter.training.hotel.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kirylshreyter.training.hotel.daodb.util.DateConverter;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.datamodel.Employee;
import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RoomOrderServiceTest {

	@Inject
	private ClientService clientService;

	@Inject
	private CommonService commonService;

	@Inject
	private RoomService roomService;

	@Inject
	private RoomDetailsService roomDetailsService;

	@Inject
	private DateConverter dateConverter;

	@Inject
	private BookingRequestService bookingRequestService;

	@Inject
	private EmployeeService employeeService;

	@Inject
	private RoomOrderService roomOrderService;

	@Transactional
	private List<RoomOrder> createObjectListWithInsert() {
		List<RoomOrder> objectList = new ArrayList<RoomOrder>();
		for (Integer i = 0; i < 5; i++) {
			Employee employee = prepareEmployeeWithInsert();
			RoomDetails roomDetails = prepareRoomDetailsWithInsert();
			Room room = new Room();
			room.setNumber(i.toString());
			room.setStatus("available");
			room.setRoomDetailsId(roomDetails.getId());
			room.setId(roomService.save(room));
			Client client = prepareClientWithInsert();
			BookingRequest bookingRequest = prepareBookingRequestWithInsert(room.getId(), client.getId());
			RoomOrder roomOrder = new RoomOrder();
			roomOrder.setBookingRequestId(bookingRequest.getId());
			roomOrder.setEmployeeId(employee.getId());
			roomOrder.setTotalCost(
					dateConverter.getDiffTwoDate(bookingRequest.getArrivalDate(), bookingRequest.getDepartureDate())
							* roomDetails.getCostPerNight());
			roomOrder.setId(roomOrderService.save(roomOrder));
			objectList.add(roomOrder);
		}
		return objectList;
	}

	@Transactional
	private void deleteObjectList(List<RoomOrder> selectedObjects) {
		for (int i = 0; i < selectedObjects.size(); i++) {
			Long roomOrderId = selectedObjects.get(i).getId();
			Long employeeId = selectedObjects.get(i).getEmployeeId();
			Long bookingRequestId = selectedObjects.get(i).getBookingRequestId();
			BookingRequest bookingRequest = new BookingRequest();
			bookingRequest = (BookingRequest) commonService.get(new BookingRequest(), bookingRequestId);
			Long clientId = bookingRequest.getClientId();
			Long roomId = bookingRequest.getRoomId();
			Room room = (Room) commonService.get(new Room(), roomId);
			Long roomDetailsId = room.getRoomDetailsId();
			commonService.delete(new RoomOrder(), roomOrderId);
			commonService.delete(new Employee(), employeeId);
			commonService.delete(new BookingRequest(), bookingRequestId);
			commonService.delete(new Client(), clientId);
			commonService.delete(new Room(), roomId);
			commonService.delete(new RoomDetails(), roomDetailsId);
		}
	}

	private RoomDetails prepareRoomDetailsWithInsert() {
		RoomDetails roomDetails = new RoomDetails();
		roomDetails.setNumberOfPlaces(1);
		roomDetails.setRoomType("economy");
		roomDetails.setCostPerNight(100.00);
		roomDetails.setAdditionalInformation("1st floor");
		roomDetails.setId(roomDetailsService.save(roomDetails));
		return roomDetails;
	}

	private Room prepareRoomWithInsert(RoomDetails roomDetails) {
		Room room = new Room();
		room.setNumber("1A");
		room.setStatus("available");
		room.setRoomDetailsId(roomDetails.getId());
		room.setId(roomService.save(room));
		return room;
	}

	private Client prepareClientWithInsert() {
		Client client = new Client();
		client.setFirstName("Иван");
		client.setLastName("Иванов");
		client.setPhone("+375297800000");
		client.setEmail("ivanov@gmail.com");
		client.setId(clientService.save(client));
		return client;
	}

	private Employee prepareEmployeeWithInsert() {
		Employee employee = new Employee();
		employee.setFirstName("Иван");
		employee.setLastName("Иванов");
		employee.setPhone("+375297800000");
		employee.setEmail("ivanov@gmail.com");
		employee.setPosition("administrator");
		employee.setId(employeeService.save(employee));
		return employee;
	}

	private BookingRequest prepareBookingRequestWithInsert(Long roomId, Long clientId) {
		BookingRequest bookingRequest = new BookingRequest();
		bookingRequest.setRoomId(roomId);
		bookingRequest.setClientId(clientId);
		bookingRequest.setArrivalDate(dateConverter.stringToJavaUtilDateConverter("2017-01-01"));
		bookingRequest.setDepartureDate(dateConverter.stringToJavaUtilDateConverter("2017-01-05"));
		bookingRequest.setId(bookingRequestService.save(bookingRequest));
		return bookingRequest;
	}

	@Test
	//@Ignore
	@Transactional
	public void getTest() {
		Employee employee = prepareEmployeeWithInsert();
		RoomDetails roomDetails = prepareRoomDetailsWithInsert();
		Room room = prepareRoomWithInsert(roomDetails);
		Client client = prepareClientWithInsert();
		BookingRequest bookingRequest = prepareBookingRequestWithInsert(room.getId(), client.getId());
		RoomOrder roomOrder = new RoomOrder();
		roomOrder.setBookingRequestId(bookingRequest.getId());
		roomOrder.setEmployeeId(employee.getId());
		roomOrder.setTotalCost(
				dateConverter.getDiffTwoDate(bookingRequest.getArrivalDate(), bookingRequest.getDepartureDate())
						* roomDetails.getCostPerNight());
		roomOrder.setId(roomOrderService.save(roomOrder));
		RoomOrder recievedRoomOrder = (RoomOrder) commonService.get(new RoomOrder(), roomOrder.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", recievedRoomOrder);
		Assert.assertEquals("Id for inserted and selected objects should be the same.", roomOrder.getId(),
				recievedRoomOrder.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", roomOrder,
				recievedRoomOrder);
		commonService.delete(recievedRoomOrder, recievedRoomOrder.getId());
		commonService.delete(bookingRequest, bookingRequest.getId());
		commonService.delete(employee, employee.getId());
		commonService.delete(client, client.getId());
		commonService.delete(room, room.getId());
		commonService.delete(roomDetails, roomDetails.getId());
	}

	@Test
	//@Ignore
	@Transactional
	public void deleteTest() {
		Employee employee = prepareEmployeeWithInsert();
		RoomDetails roomDetails = prepareRoomDetailsWithInsert();
		Room room = prepareRoomWithInsert(roomDetails);
		Client client = prepareClientWithInsert();
		BookingRequest bookingRequest = prepareBookingRequestWithInsert(room.getId(), client.getId());
		RoomOrder roomOrder = new RoomOrder();
		roomOrder.setBookingRequestId(bookingRequest.getId());
		roomOrder.setEmployeeId(employee.getId());
		roomOrder.setTotalCost(
				dateConverter.getDiffTwoDate(bookingRequest.getArrivalDate(), bookingRequest.getDepartureDate())
						* roomDetails.getCostPerNight());
		roomOrder.setId(roomOrderService.save(roomOrder));
		RoomOrder recievedRoomOrder = (RoomOrder) commonService.get(new RoomOrder(), roomOrder.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", recievedRoomOrder);
		Assert.assertTrue("Object should be deleted, but it's not.",
				commonService.delete(recievedRoomOrder, recievedRoomOrder.getId()));
		commonService.delete(bookingRequest, bookingRequest.getId());
		commonService.delete(employee, employee.getId());
		commonService.delete(client, client.getId());
		commonService.delete(room, room.getId());
		commonService.delete(roomDetails, roomDetails.getId());
	}

	@Test
	//@Ignore
	@Transactional
	public void saveTest() {
		Employee employee = prepareEmployeeWithInsert();
		RoomDetails roomDetails = prepareRoomDetailsWithInsert();
		Room room = prepareRoomWithInsert(roomDetails);
		Client client = prepareClientWithInsert();
		BookingRequest bookingRequest = prepareBookingRequestWithInsert(room.getId(), client.getId());
		RoomOrder roomOrder = new RoomOrder();
		roomOrder.setBookingRequestId(bookingRequest.getId());
		roomOrder.setEmployeeId(employee.getId());
		roomOrder.setTotalCost(
				dateConverter.getDiffTwoDate(bookingRequest.getArrivalDate(), bookingRequest.getDepartureDate())
						* roomDetails.getCostPerNight());
		roomOrder.setId(roomOrderService.save(roomOrder));
		RoomOrder recievedRoomOrder = (RoomOrder) commonService.get(new RoomOrder(), roomOrder.getId());

		Assert.assertEquals("Id for inserted and selected objects should be the same.", roomOrder.getId(),
				recievedRoomOrder.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", roomOrder,
				recievedRoomOrder);
		commonService.delete(recievedRoomOrder, recievedRoomOrder.getId());
		commonService.delete(bookingRequest, bookingRequest.getId());
		commonService.delete(employee, employee.getId());
		commonService.delete(client, client.getId());
		commonService.delete(room, room.getId());
		commonService.delete(roomDetails, roomDetails.getId());
	}

	@Test
	//@Ignore
	@Transactional
	public void updateTest() {
		Employee employee = prepareEmployeeWithInsert();
		RoomDetails roomDetails = prepareRoomDetailsWithInsert();
		Room room = prepareRoomWithInsert(roomDetails);
		Client client = prepareClientWithInsert();
		BookingRequest bookingRequest = prepareBookingRequestWithInsert(room.getId(), client.getId());
		RoomOrder roomOrder = new RoomOrder();
		roomOrder.setBookingRequestId(bookingRequest.getId());
		roomOrder.setEmployeeId(employee.getId());
		roomOrder.setTotalCost(
				dateConverter.getDiffTwoDate(bookingRequest.getArrivalDate(), bookingRequest.getDepartureDate())
						* roomDetails.getCostPerNight());
		roomOrder.setId(roomOrderService.save(roomOrder));
		RoomOrder recievedRoomOrder = (RoomOrder) commonService.get(new RoomOrder(), roomOrder.getId());

		Assert.assertNotNull("Getted from DB object should not be null.", recievedRoomOrder);
		Assert.assertEquals("Id for inserted and selected object must be the same.", roomOrder.getId(),
				recievedRoomOrder.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", roomOrder,
				recievedRoomOrder);
		roomOrder.setTotalCost(roomOrder.getTotalCost() * 1.5);
		Assert.assertNotEquals("Objects must have a differense.", roomOrder, recievedRoomOrder);
		roomOrder.setId(recievedRoomOrder.getId());
		Assert.assertTrue("Object in DB was not updated.", roomOrderService.update(roomOrder));

		recievedRoomOrder = (RoomOrder) commonService.get(new RoomOrder(), roomOrder.getId());
		Assert.assertEquals("Objects must to be similar.", roomOrder, recievedRoomOrder);
		commonService.delete(recievedRoomOrder, recievedRoomOrder.getId());
		commonService.delete(bookingRequest, bookingRequest.getId());
		commonService.delete(employee, employee.getId());
		commonService.delete(client, client.getId());
		commonService.delete(room, room.getId());
		commonService.delete(roomDetails, roomDetails.getId());
	}

	@Test
	//@Ignore
	@Transactional
	public void getAllTest() {
		List<RoomOrder> objectList = createObjectListWithInsert();
		List<RoomOrder> selectedObjects = new ArrayList<RoomOrder>(commonService.getAll(new RoomOrder()));
		Assert.assertEquals("List of selected objects is different from list of inserted objects.", objectList,
				selectedObjects);
		deleteObjectList(selectedObjects);
	}
	@Test
	@Ignore
	public void createList() {
		createObjectListWithInsert();
		
	}
}
