package com.kirylshreyter.training.hotel.services;

import javax.inject.Inject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath**:service-context.xml")
public class BookedRoomServiceTest {
	@Inject
	private BookedRoomService bookedRoomService;

	@Test
	public void getByIdtest() {
		BookedRoom bookedRoom = bookedRoomService.get(1l);
		Assert.assertNotNull("book for id=1 should not be null", bookedRoom);
		Assert.assertEquals(new Long(1), bookedRoom.getId());
	}

}
