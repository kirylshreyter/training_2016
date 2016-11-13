package com.kirylshreyter.training.hotel.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.cglib.core.Converter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kirylshreyter.training.hotel.daodb.customentity.AvailableRoom;
import com.kirylshreyter.training.hotel.daodb.customentity.IntersactedDate;
import com.kirylshreyter.training.hotel.daodb.util.DateConverter;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-service-context.xml")
public class BookingRequestServiceTest {

	@Inject
	private BookingRequestService bookingRequestService;

	@Inject
	private RoomService roomService;

	@Inject
	private RoomOrderService roomOrderService;

	@Inject
	private DateConverter dateConverter;

	/*@BeforeClass
	public static void prepareTestData() {
		System.out.println("prepareTestData");
	}

	@AfterClass
	public static void deleteTestData() {
		System.out.println("deleteTestData");
	}

	@Before
	public void prepareMethodData() {
		System.out.println("prepareMethodData");
	}

	@After
	public void deleteMethodData() {
		System.out.println("deleteMethodData");
	}*/

	@Test
	@Ignore
	public void BookingRequestSaveTest() {
		Client client = new Client();
		client.setFirstName("Иван");
		client.setLastName("Иванов");
		client.setPhone("+375297800000");
		client.setEmail("ivanov@gmail.com");
		client.setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
		BookingRequest bookingRequest = new BookingRequest();
		bookingRequest.setRoomId(1L);
		bookingRequest.setArrivalDate(dateConverter.stringToJavaUtilDateConverter("2015-01-01"));
		bookingRequest.setDepartureDate(dateConverter.stringToJavaUtilDateConverter("2015-01-03"));
		Long insertedBookingrequestId = bookingRequestService.save(bookingRequest, client);

		Assert.assertNotNull("booking_request shoud have an id.", insertedBookingrequestId);
		System.out.println(insertedBookingrequestId.toString());

		/*
		 * List<IntersactedDate> intersactedDateList = new
		 * ArrayList<IntersactedDate>(); intersactedDateList =
		 * roomService.getBookedRoomWithIntersactedDate(bookingRequest);
		 * List<AvailableRoom> availableRoomlist = new
		 * ArrayList<AvailableRoom>(); availableRoomlist =
		 * roomService.getAllAvailableRoom(intersactedDateList);
		 * 
		 * AvailableRoom availableRoom = new AvailableRoom(); availableRoom =
		 * availableRoomlist.get(1); RoomOrder roomOrder = new RoomOrder();
		 * roomOrder.setRoomId(availableRoom.getRoomId());
		 * roomOrder.setBookingRequestId(insertedBookingrequestId);
		 * roomOrder.setEmployeeId(1L);
		 * roomOrder.setTotalCost(availableRoom.getCostPerNight());
		 * roomOrder.setNonConvertedbookedStartDay(bookingRequest.
		 * getNonConvertedArrivalDate());
		 * roomOrder.setNonConvertedbookedEndDay(bookingRequest.
		 * getNonConvertedDepartureDate()); roomOrderService.save(roomOrder);
		 */ }

	/*
	 * @Inject private ClientService clientService;
	 */

	@Test
	@Ignore
	public void getTest() {
		BookingRequest bookingRequest = bookingRequestService.get(3L);
		Assert.assertNotNull("Booking request for id= 2 should not be null", bookingRequest);
		Assert.assertEquals(new Long(3), bookingRequest.getId());
		System.out.println(bookingRequest.getId());
	}


/*
 * @Test
 * 
 * @Ignore public void BokedRoomSaveTest() { SimpleDateFormat sdf = new
 * SimpleDateFormat("dd-MM-yyyy"); BookedRoom bookedRoom = new BookedRoom();
 * bookedRoom.setBookingRequestId(1); bookedRoom.setRoomOrderId(1);
 * 
 * sdf.setTimeZone(TimeZone.getTimeZone("GMT")); Date bsd; try { bsd =
 * sdf.parse("20-12-2016"); bookedRoom.setBookedStartDay(bsd); } catch
 * (ParseException e) { e.printStackTrace(); } Date bed; try { bed =
 * sdf.parse("30-12-2016"); bookedRoom.setBookedEndDay(bed); } catch
 * (ParseException e) { e.printStackTrace(); }
 * 
 * bookedRoomService.save(bookedRoom);
 * 
 * }
 * 
 * @Test
 * 
 * @Ignore public void BokedRoomUpdateTest() { SimpleDateFormat sdf = new
 * SimpleDateFormat("dd-MM-yyyy"); BookedRoom bookedRoom = new BookedRoom();
 * bookedRoom.setId((long) 1); bookedRoom.setBookingRequestId(1);
 * bookedRoom.setRoomOrderId(1);
 * 
 * sdf.setTimeZone(TimeZone.getTimeZone("GMT")); Date bsd; try { bsd =
 * sdf.parse("01-01-2016"); bookedRoom.setBookedStartDay(bsd); } catch
 * (ParseException e) { e.printStackTrace(); } Date bed; try { bed =
 * sdf.parse("03-01-2016"); bookedRoom.setBookedEndDay(bed); } catch
 * (ParseException e) { e.printStackTrace(); }
 * 
 * bookedRoomService.update(bookedRoom);
 * 
 * }
 */
 @Test
 @Ignore
 public void deleteTest() {
 bookingRequestService.delete(1L);
 }
 
 
 
 
 @Test
 //@Ignore
 public void getAllTest() {
 bookingRequestService.getAll();
 }
}
 /* @Test
 * 
 * @Ignore public void getAllTest() { bookedRoomService.getAll(); }
 * 
 * public void PrepareTestData() { Client client = new Client();
 * client.setFirstName("Иван"); client.setLastName("Иванов"); client.
 * setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
 * client.setPhone("+375297800000"); client.setEmail("ivanov@gmail.com");
 * clientService.save(client);
 * 
 * BookedRoom bookedRoom = new BookedRoom(); bookedRoom.setBookingRequestId(1);
 * bookedRoom.setRoomOrderId(1); bookedRoomService.save(bookedRoom);
 * 
 * }
 */
