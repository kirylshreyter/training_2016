package com.kirylshreyter.training.hotel.services;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath**:service-context.xml")
public class BookedRoomServiceTest {

	ApplicationContext context = new ClassPathXmlApplicationContext("service-context.xml");
	private BookedRoomService bookedRoomService = (BookedRoomService) context.getBean("bookedRoomService");
	

	@Test
	public void getByIdtest() {
		BookedRoom bookedRoom = bookedRoomService.get(1L);

		Assert.assertNotNull("book for id=1 should not be null", bookedRoom);
		Assert.assertEquals(new Long(2), bookedRoom.getId());

	}

}
