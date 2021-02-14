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

import com.kirylshreyter.training.hotel.datamodel.Client;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class ClientServiceTest {

	@Inject
	private ClientService clientService;

	@Inject
	private CommonService commonService;

	private Client prepareWithInsertEntity() {
		Client client = new Client();
		client.setFirstName("Иван");
		client.setLastName("Иванов");
		client.setPhone("+375297800000");
		client.setEmail("ivanov@gmail.com");
		client.setId(clientService.save(client));
		return client;
	}

	private Client prepareWithoutInsertEntity() {
		Client client = new Client();
		client.setFirstName("Иван");
		client.setLastName("Иванов");
		client.setPhone("+375297800000");
		client.setEmail("ivanov@gmail.com");
		return client;
	}

	@Transactional
	private void deleteObjectList(List<Client> selectedObjects) {
		for (int i = 0; i < selectedObjects.size(); i++) {
			commonService.delete(selectedObjects.get(i), selectedObjects.get(i).getId());
		}
	}

	@Transactional
	private List<Client> createObjectListWithInsert() {
		List<Client> objectList = new ArrayList<Client>();
		for (int i = 0; i < 5; i++) {
			Client client = new Client();
			client = prepareWithoutInsertEntity();
			Long id = clientService.save(client);
			client.setId(id);
			objectList.add(client);
		}
		return objectList;
	}

	@Test
	// @Ignore
	public void getTest() {
		Client insertedEntity = new Client();
		insertedEntity = prepareWithInsertEntity();
		Client entity = (Client) commonService.get(new Client(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertEquals("Id for inserted and selected objects should be the same.", insertedEntity.getId(),
				entity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity, entity);
		commonService.delete(insertedEntity, insertedEntity.getId());
	}

	@Test
	// @Ignore
	@Transactional
	public void deleteTest() {
		Client insertedEntity = new Client();
		insertedEntity = prepareWithInsertEntity();
		Client entity = (Client) commonService.get(new Client(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertTrue("Object should be deleted, but it's not.",
				commonService.delete(insertedEntity, insertedEntity.getId()));
	}

	@Test
	// @Ignore
	@Transactional
	public void saveTest() {
		Client nonInsertedEntity = new Client();
		nonInsertedEntity = prepareWithoutInsertEntity();
		Long insertedEntityId = clientService.save(nonInsertedEntity);
		Client insertedEntity = new Client();
		insertedEntity = (Client) commonService.get(new Client(), insertedEntityId);
		insertedEntity.setId(insertedEntityId);
		Assert.assertEquals("Id for inserted and selected objects should be the same.", nonInsertedEntity.getId(),
				insertedEntity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", nonInsertedEntity,
				insertedEntity);
		commonService.delete(insertedEntity, insertedEntity.getId());
	}

	@Test
	// @Ignore
	@Transactional
	public void updateTest() {
		Client insertedEntity = new Client();
		insertedEntity = prepareWithInsertEntity();
		Client gettedEntity = (Client) commonService.get(new Client(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", gettedEntity);
		Assert.assertEquals("Id for inserted and selected object must be the same.", insertedEntity.getId(),
				gettedEntity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity,
				gettedEntity);
		Client newEntity = new Client();
		newEntity = prepareWithoutInsertEntity();
		Assert.assertNotEquals("Objects must have a differense.", newEntity, gettedEntity);
		newEntity.setId(gettedEntity.getId());
		Assert.assertTrue("Object in DB was not updated.", clientService.update(newEntity));
		gettedEntity = (Client) commonService.get(new Client(), newEntity.getId());
		Assert.assertEquals("Objects must to be similar.", newEntity, gettedEntity);
		commonService.delete(gettedEntity, gettedEntity.getId());

	}

	@Test
	// @Ignore
	public void getAllTest() {
		List<Client> objectList = createObjectListWithInsert();
		List<Client> selectedObjects = new ArrayList<Client>();
		selectedObjects = commonService.getAll(new Client());
		Assert.assertEquals("List of selected objects is different from list of inserted objects.", objectList,
				selectedObjects);
		deleteObjectList(selectedObjects);

	}

	@Test
	@Ignore
	public void saveXmlTest() {
		Client client = prepareWithoutInsertEntity();
		client.setId(clientService.save(client));

	}

	@Test
	@Ignore
	public void getXmlTest() {
		Client client = (Client) commonService.get(new Client(), 1L);
		Assert.assertNotNull("book for id=1 should not be null", client);
		Assert.assertEquals(new Long(1), client.getId());
		System.out.println(client.toString());
	}
}
