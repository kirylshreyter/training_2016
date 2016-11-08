package com.kirylshreyter.training.hotel.services;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kirylshreyter.training.hotel.datamodel.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ClientServiceTest {

	@Inject
	private ClientService clientService;

	@Test
	public void getByIdTest() {
		Client client = clientService.get(1L);
		Assert.assertNotNull("Client should not be null.", client);
	}

}
