package com.kirylshreyter.training.hotel.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.datamodel.Room;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-service-context.xml")
public class ClientServiceTest {

	@Inject
	private ClientService clientService;

	@Inject
	private RoomService roomService;

	@Test
	@Ignore
	public void getByIdTest() {
		Client client = clientService.get(2L);
		Assert.assertNotNull("Client should not be null.", client);
	}

	@Test
	@Ignore
	public void deleteTest() {
		clientService.delete(2L);
	}

	@Test
	public void insertTest() {
		Room room = new Room();
		room.setNumber("1AAA");
		room.setStatus("A");
		room.setRoomDetailsId(100L);
		roomService.save(room);
	}

}
