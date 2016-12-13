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

import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class RoomServiceTest {

	@Inject
	private RoomDetailsService roomDetailsService;

	@Inject
	private RoomService roomService;

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

	@Transactional
	private void deleteObjectList(List<Room> selectedObjects) {
		for (int i = 0; i < selectedObjects.size(); i++) {
			Long roomDetailsId = selectedObjects.get(i).getRoomDetailsId();
			commonService.delete(new Room(), selectedObjects.get(i).getId());
			commonService.delete(new RoomDetails(), roomDetailsId);
		}
	}

	@Transactional
	private List<Room> createObjectListWithInsert() {
		List<Room> objectList = new ArrayList<Room>();
		for (Integer i = 0; i < 5; i++) {
			RoomDetails roomDetails = new RoomDetails();
			roomDetails = prepareWithInsertEntity();
			Room room = new Room();
			room.setNumber(i.toString());
			room.setStatus("available");
			room.setRoomDetailsId(roomDetails.getId());
			room.setId(roomService.save(room));
			objectList.add(room);
		}
		return objectList;
	}

	@Test
	// @Ignore
	@Transactional
	public void getTest() {
		RoomDetails insertedRoomDetails = new RoomDetails();
		insertedRoomDetails = prepareWithInsertEntity();
		Room room = new Room();
		room.setNumber("1A");
		room.setStatus("available");
		room.setRoomDetailsId(insertedRoomDetails.getId());
		room.setId(roomService.save(room));
		Room entity = (Room) commonService.get(new Room(), room.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertEquals("Id for inserted and selected objects should be the same.", room.getId(), entity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", room, entity);
		commonService.delete(room, room.getId());
		commonService.delete(insertedRoomDetails, insertedRoomDetails.getId());
	}

	@Test
	// @Ignore
	@Transactional
	public void deleteTest() {
		RoomDetails insertedRoomDetails = new RoomDetails();
		insertedRoomDetails = prepareWithInsertEntity();
		Room room = new Room();
		room.setNumber("1A");
		room.setStatus("available");
		room.setRoomDetailsId(insertedRoomDetails.getId());
		room.setId(roomService.save(room));
		Room entity = (Room) commonService.get(new Room(), room.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertTrue("Object should be deleted, but it's not.", commonService.delete(room, room.getId()));
		Assert.assertTrue("Object should be deleted, but it's not.",
				commonService.delete(insertedRoomDetails, insertedRoomDetails.getId()));
	}

	@Test
	// @Ignore
	@Transactional
	public void saveTest() {
		RoomDetails insertedRoomDetails = new RoomDetails();
		insertedRoomDetails = prepareWithInsertEntity();
		Room room = new Room();
		room.setNumber("1A");
		room.setStatus("available");
		room.setRoomDetailsId(insertedRoomDetails.getId());
		room.setId(roomService.save(room));
		Room newRoom = (Room) commonService.get(new Room(), room.getId());
		Assert.assertEquals("Id for inserted and selected objects should be the same.", room.getId(), newRoom.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", room, newRoom);
		commonService.delete(room, room.getId());
		commonService.delete(insertedRoomDetails, insertedRoomDetails.getId());
	}

	@Test
	// @Ignore
	@Transactional
	public void updateTest() {
		RoomDetails insertedRoomDetails = new RoomDetails();
		insertedRoomDetails = prepareWithInsertEntity();
		Room room = new Room();
		room.setNumber("1A");
		room.setStatus("available");
		room.setRoomDetailsId(insertedRoomDetails.getId());
		room.setId(roomService.save(room));
		Room recievedFromDbRoom = (Room) commonService.get(new Room(), room.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", recievedFromDbRoom);
		Assert.assertEquals("Id for inserted and selected object must be the same.", room.getId(),
				recievedFromDbRoom.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", room, recievedFromDbRoom);
		room.setStatus("not available");
		Assert.assertNotEquals("Objects must have a differense.", room, recievedFromDbRoom);
		room.setId(recievedFromDbRoom.getId());
		Assert.assertTrue("Object in DB was not updated.", roomService.update(room));
		recievedFromDbRoom = (Room) commonService.get(new Room(), room.getId());
		Assert.assertEquals("Objects must to be similar.", room, recievedFromDbRoom);
		commonService.delete(room, room.getId());
		commonService.delete(insertedRoomDetails, insertedRoomDetails.getId());
	}

	@Test
	// @Ignore
	public void getAllTest() {
		List<Room> objectList = createObjectListWithInsert();
		List<Room> selectedObjects = new ArrayList<Room>(commonService.getAll(new Room()));
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
