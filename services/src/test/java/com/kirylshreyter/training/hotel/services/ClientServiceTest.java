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

import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

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
		client.setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
		client.setId(clientService.save(client));
		return client;
	}

	private Client prepareWithoutInsertEntity() {
		Client client = new Client();
		client.setFirstName("Иван");
		client.setLastName("Иванов");
		client.setPhone("+375297800000");
		client.setEmail("ivanov@gmail.com");
		client.setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
		return client;
	}

	private void deleteObjectList(List<Client> selectedObjects) {
		for (int i = 0; i < selectedObjects.size(); i++) {
			clientService.delete(selectedObjects.get(i).getId());
		}
	}

	private List<Client> createObjectListWithInsert() {
		List<Client> objectList = new ArrayList<Client>();
		for (int i = 0; i < 5; i++) {
			objectList.add(prepareWithoutInsertEntity());
			Long id = clientService.save(objectList.get(i));
			Client entity = new Client();
			entity = objectList.get(i);
			entity.setId(id);
			objectList.set(i, entity);
		}
		return objectList;
	}

	@Test
	@Ignore
	public void getTest() {
		Client insertedEntity = new Client();
		insertedEntity = prepareWithInsertEntity();
		Client entity = (Client) commonService.get(new Client(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertEquals("Id for inserted and selected objects should be the same.", insertedEntity.getId(),
				entity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity, entity);
		clientService.delete(insertedEntity.getId());
	}

	@Test
	@Ignore
	public void deleteTest() {
		Client insertedEntity = new Client();
		insertedEntity = prepareWithInsertEntity();
		Client entity = (Client) commonService.get(new Client(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertTrue("Object should be deleted, but it's not.", clientService.delete(insertedEntity.getId()));
	}

	@Test
	@Ignore
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
		clientService.delete(insertedEntity.getId());
	}

	@Test
	@Ignore
	public void updateTest() {
		Client insertedEntity = new Client();
		insertedEntity = prepareWithInsertEntity();
		Client gettedEntity = (Client) commonService.get(new Client(), insertedEntity.getId());
		System.out.println(gettedEntity.hashCode());
		Assert.assertNotNull("Getted from DB object should not be null.", gettedEntity);
		Assert.assertEquals("Id for inserted and selected object must be the same.", insertedEntity.getId(),
				gettedEntity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity,
				gettedEntity);
		Client newEntity = new Client();
		System.out.println(newEntity.hashCode());
		newEntity = prepareWithoutInsertEntity();
		Assert.assertNotEquals("Objects must have a differense.", newEntity, gettedEntity);
		Assert.assertTrue("Object in DB was not updated.", clientService.update(newEntity));
		newEntity.setId(insertedEntity.getId());
		gettedEntity = (Client) commonService.get(new Client(), newEntity.getId());
		Assert.assertEquals("Objects must to be similar.", newEntity, gettedEntity);
		clientService.delete(gettedEntity.getId());

	}

	@Test
	@Ignore
	public void getAllTest() {
		List<Client> objectList = createObjectListWithInsert();
		List<Client> selectedObjects = new ArrayList<>(clientService.getAll());
		Assert.assertEquals("List of selected objects is different from list of inserted objects.", objectList,
				selectedObjects);
		deleteObjectList(selectedObjects);

	}

	@Test
	@Ignore
	public void saveXmlTest() {
		Client client = new Client();
		client.setFirstName("Иван");
		client.setLastName("Иванов");
		client.setPhone("+375297800000");
		client.setEmail("ivanov@gmail.com");
		client.setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
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

	@Test
	@Ignore
	public void get() {
		Object obj = commonService.get(new Client(), 73L);
		System.out.println(obj.toString());
	}
	
	@Test
	//@Ignore
	public void delete(){
		Boolean a = commonService.delete(new Client(), 79L);
		Assert.assertTrue(a);
	}

}
