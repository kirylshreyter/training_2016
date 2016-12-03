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

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RoomDetailsServiceTest {
	@Inject
	private RoomDetailsService roomDetailsService;
	
	private RoomDetails prepareWithInsertEntity() {
		RoomDetails roomDetails = new RoomDetails();
		roomDetails.setNumberOfPlaces(1);
		roomDetails.setRoomType("economy");
		roomDetails.setCostPerNight(100.00);
		roomDetails.setAdditionalInformation("1st floor");
		roomDetails.setId(roomDetailsService.save(roomDetails));
		return roomDetails;
	}

	private RoomDetails prepareWithoutInsertEntity() {
		RoomDetails roomDetails = new RoomDetails();
		roomDetails.setNumberOfPlaces(1);
		roomDetails.setRoomType("economy");
		roomDetails.setCostPerNight(100.00);
		roomDetails.setAdditionalInformation("1st floor");
		return roomDetails;
	}

	private void deleteObjectList(List<RoomDetails> selectedObjects) {
		for (int i = 0; i < selectedObjects.size(); i++) {
			roomDetailsService.delete(selectedObjects.get(i).getId());
		}
	}

	private List<RoomDetails> createObjectListWithInsert() {
		List<RoomDetails> objectList = new ArrayList<RoomDetails>();
		for (int i = 0; i < 5; i++) {
			objectList.add(prepareWithoutInsertEntity());
			Long id = roomDetailsService.save(objectList.get(i));
			RoomDetails entity = new RoomDetails();
			entity = objectList.get(i);
			entity.setId(id);
			objectList.set(i, entity);
		}
		return objectList;
	}

	@Test
	@Ignore
	public void getTest() {
		RoomDetails insertedEntity = new RoomDetails();
		insertedEntity = prepareWithInsertEntity();
		RoomDetails entity = roomDetailsService.get(insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertEquals("Id for inserted and selected objects should be the same.", insertedEntity.getId(),
				entity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity, entity);
		roomDetailsService.delete(insertedEntity.getId());
	}

	@Test
	@Ignore
	public void deleteTest() {
		RoomDetails insertedEntity = new RoomDetails();
		insertedEntity = prepareWithInsertEntity();
		RoomDetails entity = roomDetailsService.get(insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertTrue("Object should be deleted, but it's not.", roomDetailsService.delete(insertedEntity.getId()));
	}

	@Test
	@Ignore
	public void saveTest() {
		RoomDetails nonInsertedEntity = new RoomDetails();
		nonInsertedEntity = prepareWithoutInsertEntity();
		Long insertedEntityId = roomDetailsService.save(nonInsertedEntity);
		RoomDetails insertedEntity = new RoomDetails();
		insertedEntity = roomDetailsService.get(insertedEntityId);
		insertedEntity.setId(insertedEntityId);
		Assert.assertEquals("Id for inserted and selected objects should be the same.", nonInsertedEntity.getId(),
				insertedEntity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", nonInsertedEntity,
				insertedEntity);
		roomDetailsService.delete(insertedEntity.getId());
	}

	@Test
	@Ignore
	public void updateTest() {
		RoomDetails insertedEntity = new RoomDetails();
		insertedEntity = prepareWithInsertEntity();
		RoomDetails gettedEntity = roomDetailsService.get(insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", gettedEntity);
		Assert.assertEquals("Id for inserted and selected object must be the same.", insertedEntity.getId(),
				gettedEntity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity,
				gettedEntity);
		RoomDetails newEntity = new RoomDetails();
		newEntity = prepareWithoutInsertEntity();
		Assert.assertNotEquals("Objects must have a differense.", newEntity, gettedEntity);
		Assert.assertTrue("Object in DB was not updated.", roomDetailsService.update(newEntity));
		newEntity.setId(insertedEntity.getId());
		gettedEntity = roomDetailsService.get(newEntity.getId());
		Assert.assertEquals("Objects must to be similar.", newEntity, gettedEntity);
		roomDetailsService.delete(gettedEntity.getId());

	}

	@Test
	@Ignore
	public void getAllTest() {
		List<RoomDetails> objectList = createObjectListWithInsert();
		List<RoomDetails> selectedObjects = new ArrayList<>(roomDetailsService.getAll());
		Assert.assertEquals("List of selected objects is different from list of inserted objects.", objectList,
				selectedObjects);
		deleteObjectList(selectedObjects);

	}

	@Test
	@Ignore
	public void saveXmlTest() {
		RoomDetails roomDetails = new RoomDetails();
		roomDetails.setNumberOfPlaces(1);
		roomDetails.setRoomType("economy");
		roomDetails.setCostPerNight(100.00);
		roomDetails.setAdditionalInformation("1st floor");
		roomDetails.setId(roomDetailsService.save(roomDetails));

	}

	@Test
	//@Ignore
	public void getXmlTest() {
		RoomDetails roomDetails = roomDetailsService.get(1l);
		Assert.assertNotNull("book for id=1 should not be null", roomDetails);
		Assert.assertEquals(new Long(1), roomDetails.getId());
		System.out.println(roomDetails.toString());
	}

}
