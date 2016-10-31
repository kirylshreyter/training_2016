package com.kirylshreyter.training.hotel.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.kirylshreyter.training.hotel.datamodel.BookedRoom;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath**:service-context.xml")
@TestExecutionListeners(listeners = {DependencyInjectionTestExecutionListener.class, DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class})
public class BookedRoomServiceTest {

	@Inject
	private BookedRoomService bookedRoomService;
	

	@Test
	public void getByIdtest() {
		BookedRoom bookedRoom = bookedRoomService.get(1L);

		Assert.assertNotNull("book for id=1 should not be null", bookedRoom);
		Assert.assertEquals(new Long(2), bookedRoom.getId());

	}

}
