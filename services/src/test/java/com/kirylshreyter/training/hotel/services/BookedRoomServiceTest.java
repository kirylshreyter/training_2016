package com.kirylshreyter.training.hotel.services;

import java.text.SimpleDateFormat;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kirylshreyter.training.hotel.datamodel.BookedRoom;
import com.kirylshreyter.training.hotel.datamodel.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class BookedRoomServiceTest {

	@Inject
	private BookedRoomService bookedRoomService;

	@Inject
	private ClientService clientService;

	@Test
	public void getByIdtest() {
		for (int i = 0; i < 20; i++) {
			PrepareTestData();
		}
		BookedRoom bookedRoom = bookedRoomService.get(1L);
		System.out.println(bookedRoom.getId());

		Assert.assertNotNull("book for id=1 should not be null", bookedRoom);
		Assert.assertEquals(new Long(1), bookedRoom.getId());

	}

	@Test
	@Ignore
	public void BokedRoomSaveTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		BookedRoom bookedRoom = new BookedRoom();
		bookedRoom.setBookingRequestId(1);
		bookedRoom.setRoomOrderId(1);
		/*
		 * sdf.setTimeZone(TimeZone.getTimeZone("GMT")); Date bsd; try { bsd =
		 * sdf.parse("20-12-2016"); bookedRoom.setBookedStartDay(bsd); } catch
		 * (ParseException e) { e.printStackTrace(); } Date bed; try { bed =
		 * sdf.parse("30-12-2016"); bookedRoom.setBookedEndDay(bed); } catch
		 * (ParseException e) { e.printStackTrace(); }
		 */
		bookedRoomService.save(bookedRoom);

	}

	@Test
	@Ignore
	public void BokedRoomUpdateTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		BookedRoom bookedRoom = new BookedRoom();
		bookedRoom.setId((long) 1);
		bookedRoom.setBookingRequestId(1);
		bookedRoom.setRoomOrderId(1);
		/*
		 * sdf.setTimeZone(TimeZone.getTimeZone("GMT")); Date bsd; try { bsd =
		 * sdf.parse("01-01-2016"); bookedRoom.setBookedStartDay(bsd); } catch
		 * (ParseException e) { e.printStackTrace(); } Date bed; try { bed =
		 * sdf.parse("03-01-2016"); bookedRoom.setBookedEndDay(bed); } catch
		 * (ParseException e) { e.printStackTrace(); }
		 */
		bookedRoomService.update(bookedRoom);

	}

	@Test
	@Ignore
	public void deleteByIdTest() {

		bookedRoomService.delete(1L);
	}

	@Test
	@Ignore
	public void getAllTest() {
		bookedRoomService.getAll();
	}

	public void PrepareTestData() {
		Client client = new Client();
		client.setFirstName("Иван");
		client.setLastName("Иванов");
		client.setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
		client.setPhone("+375297800000");
		client.setEmail("ivanov@gmail.com");
		clientService.save(client);
		/*
		 * BookedRoom bookedRoom = new BookedRoom();
		 * bookedRoom.setBookingRequestId(1); bookedRoom.setRoomOrderId(1);
		 * bookedRoomService.save(bookedRoom);
		 */
	}

}
