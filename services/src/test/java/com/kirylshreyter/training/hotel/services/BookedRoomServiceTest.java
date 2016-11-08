package com.kirylshreyter.training.hotel.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class BookedRoomServiceTest {

	@Inject
	private BookedRoomService bookedRoomService;

	@Test
	public void getByIdtest() {
		BookedRoom bookedRoom = bookedRoomService.get(1L);
		Assert.assertNotNull("Booker Room should not be null", bookedRoom);
	}

	@Test
	@Ignore
	public void BokedRoomSaveTest() {
		BookedRoom bookedRoom = new BookedRoom();
		bookedRoom.setBookingRequestId(1L);
		bookedRoom.setRoomOrderId(1);
		bookedRoomService.save(bookedRoom);

	}

	@Test
	@Ignore
	public void BokedRoomUpdateTest() {
		BookedRoom bookedRoom = new BookedRoom();
		bookedRoom.setId((long) 1);
		bookedRoom.setBookingRequestId(1L);
		bookedRoom.setRoomOrderId(1);
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

}
