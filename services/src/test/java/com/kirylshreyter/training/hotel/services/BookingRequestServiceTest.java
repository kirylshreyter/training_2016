package com.kirylshreyter.training.hotel.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kirylshreyter.training.hotel.datamodel.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-service-context.xml")
public class BookingRequestServiceTest {

	/*
	 * @Inject private ClientService clientService;
	 * 
	 * @Inject private RoomService roomService;
	 * 
	 * @Inject private RoomDetailsService roomDetailsService;
	 */
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	public Long newClient() {
		Client client = new Client();
		client.setFirstName("Иван");
		client.setLastName("Иванов");
		client.setPhone("+375297800000");
		client.setEmail("ivanov@gmail.com");
		client.setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
		final String INSERT_SQL = "INSERT INTO client (first_name, last_name, address,phone,email) VALUES (?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, client.getFirstName());
				ps.setString(2, client.getLastName());
				ps.setString(3, client.getAddress());
				ps.setString(4, client.getPhone());
				ps.setString(5, client.getEmail());
				return ps;
			}
		}, keyHolder);
		;
		client.setId(keyHolder.getKey().longValue());
		return client.getId();
	}

	/*
	 * public static Long newRoomDetails() { RoomDetails roomDetails = new
	 * RoomDetails(); roomDetails.setRoomType("economy");
	 * roomDetails.setNumberOfPlaces(2); roomDetails.setCostPerNight(100.00);
	 * roomDetails.setAdditionalInformation("1 этаж"); return
	 * roomDetailsService.save(roomDetails);
	 * 
	 * }
	 * 
	 * public static Long newRoom() { Room room = new Room();
	 * room.setNumber("1A"); room.setRoomDetailsId(newRoomDetails());
	 * room.setStatus("available"); return roomService.save(room);
	 * 
	 * }
	 */
	@BeforeClass
	public static void prepareMethodData() {
	}

	@Test
	// @Ignore
	public void saveTest() {
		// BookingRequest bookingRequest = new BookingRequest();
		// bookingRequest.setClientId(newClient());
		// bookingRequest.setRoomId(newRoom());
		newClient();

		// Long insertedBookingrequestId =
		// bookingRequestService.save(newBookingRequest(), newClient());
		// Assert.assertNotNull("booking_request shoud have an id.",
		// insertedBookingrequestId);
		// System.out.println(insertedBookingrequestId.toString());
	}

	/*
	 * 
	 * BookingRequest bookingRequest = new BookingRequest();
	 * bookingRequest.setRoomId(1L);
	 * bookingRequest.setArrivalDate(dateConverter.
	 * stringToJavaUtilDateConverter ("2015-01-01"));
	 * bookingRequest.setDepartureDate(dateConverter.
	 * stringToJavaUtilDateConverter("2015-01-03"));
	 * 
	 * 
	 * 
	 * }
	 */

	/*
	 * @Inject private BookingRequestService bookingRequestService;
	 * 
	 * @Inject private RoomService roomService;
	 * 
	 * @Inject private RoomOrderService roomOrderService;
	 * 
	 * @Inject private DateConverter dateConverter;
	 */

	/*
	 * @AfterClass public static void deleteTestData() {
	 * System.out.println("deleteTestData"); }
	 * 
	 * @Before public void prepareMethodData() {
	 * System.out.println("prepareMethodData"); }
	 * 
	 * @After public void deleteMethodData() {
	 * System.out.println("deleteMethodData"); }
	 */

	
	/*
	 * @Test
	 * 
	 * @Ignore public void getTest() { BookingRequest bookingRequest =
	 * bookingRequestService.get(3L);
	 * Assert.assertNotNull("Booking request for id= 2 should not be null",
	 * bookingRequest); Assert.assertEquals(new Long(3),
	 * bookingRequest.getId()); System.out.println(bookingRequest.getId()); }
	 */
	  
	 /* @Test
	  
	  @Ignore public void deleteTest() { bookingRequestService.delete(1L); }
	  
	  @Test
	  
	  @Ignore public void getAllTest() { bookingRequestService.getAll(); }
	 */
}