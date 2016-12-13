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

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RoomDetailsServiceTest {

	@Inject
	private RoomDetailsService roomDetailsService;

	@Inject
	private CommonService commonService;

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

	@Transactional
	private void deleteObjectList(List<RoomDetails> selectedObjects) {
		for (int i = 0; i < selectedObjects.size(); i++) {
			commonService.delete(selectedObjects.get(i), selectedObjects.get(i).getId());
		}
	}

	@Transactional
	private List<RoomDetails> createObjectListWithInsert() {
		List<RoomDetails> objectList = new ArrayList<RoomDetails>();
		for (int i = 0; i < 5; i++) {
			RoomDetails roomDetails = new RoomDetails();
			roomDetails = prepareWithoutInsertEntity();
			Long id = roomDetailsService.save(roomDetails);
			roomDetails.setId(id);
			objectList.add(roomDetails);
		}
		return objectList;
	}

	@Test
	// @Ignore
	public void getTest() {
		RoomDetails insertedEntity = new RoomDetails();
		insertedEntity = prepareWithInsertEntity();
		RoomDetails entity = (RoomDetails) commonService.get(new RoomDetails(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertEquals("Id for inserted and selected objects should be the same.", insertedEntity.getId(),
				entity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity, entity);
		commonService.delete(insertedEntity, insertedEntity.getId());
	}

	@Test
	// @Ignore
	public void deleteTest() {
		RoomDetails insertedEntity = new RoomDetails();
		insertedEntity = prepareWithInsertEntity();
		RoomDetails entity = (RoomDetails) commonService.get(new RoomDetails(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertTrue("Object should be deleted, but it's not.",
				commonService.delete(insertedEntity, insertedEntity.getId()));
	}

	@Test
	// @Ignore
	@Transactional
	public void saveTest() {
		RoomDetails nonInsertedEntity = new RoomDetails();
		nonInsertedEntity = prepareWithoutInsertEntity();
		Long insertedEntityId = roomDetailsService.save(nonInsertedEntity);
		RoomDetails insertedEntity = new RoomDetails();
		insertedEntity = (RoomDetails) commonService.get(new RoomDetails(), insertedEntityId);
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
		RoomDetails insertedEntity = prepareWithInsertEntity();
		RoomDetails gettedEntity = (RoomDetails) commonService.get(new RoomDetails(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", gettedEntity);
		Assert.assertEquals("Id for inserted and selected object must be the same.", insertedEntity.getId(),
				gettedEntity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity,
				gettedEntity);
		RoomDetails newEntity = prepareWithoutInsertEntity();
		newEntity.setCostPerNight(200.00);
		Assert.assertNotEquals("Objects must have a differense.", newEntity, gettedEntity);
		newEntity.setId(gettedEntity.getId());
		Assert.assertTrue("Object in DB was not updated.", roomDetailsService.update(newEntity));
		gettedEntity = (RoomDetails) commonService.get(new RoomDetails(), newEntity.getId());
		Assert.assertEquals("Objects must to be similar.", newEntity, gettedEntity);
		commonService.delete(gettedEntity, gettedEntity.getId());
	}

	@Test
	// @Ignore
	public void getAllTest() {
		List<RoomDetails> objectList = createObjectListWithInsert();
		List<RoomDetails> selectedObjects = new ArrayList<RoomDetails>(commonService.getAll(new RoomDetails()));
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
	@Ignore
	public void getXmlTest() {
		RoomDetails roomDetails = (RoomDetails) commonService.get(new RoomDetails(), 1L);
		Assert.assertNotNull("book for id=1 should not be null", roomDetails);
		Assert.assertEquals(new Long(1), roomDetails.getId());
		System.out.println(roomDetails.toString());
	}

}
