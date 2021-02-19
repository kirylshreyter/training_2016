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

import com.kirylshreyter.training.hotel.datamodel.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class UserServiceTest {

	@Inject
	private UserService userService;

	@Inject
	private CommonService commonService;

	private User prepareWithInsertEntity() {
		User user = new User();
		user.setName("Иван");
		user.setEmail("ivanov@gmail.com");
		user.setId(userService.save(user));
		return user;
	}

	private User prepareWithoutInsertEntity() {
		User user = new User();
		user.setName("Иван");
		user.setEmail("ivanov@gmail.com");
		return user;
	}

	@Transactional
	private void deleteObjectList(List<User> selectedObjects) {
		for (int i = 0; i < selectedObjects.size(); i++) {
			commonService.delete(selectedObjects.get(i), selectedObjects.get(i).getId());
		}
	}

	@Transactional
	private List<User> createObjectListWithInsert() {
		List<User> objectList = new ArrayList<User>();
		for (int i = 0; i < 5; i++) {
			User user = new User();
			user = prepareWithoutInsertEntity();
			Long id = userService.save(user);
			user.setId(id);
			objectList.add(user);
		}
		return objectList;
	}

	@Test
	// @Ignore
	public void getTest() {
		User insertedEntity = new User();
		insertedEntity = prepareWithInsertEntity();
		User entity = (User) commonService.get(new User(), insertedEntity.getId());
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
		User insertedEntity = new User();
		insertedEntity = prepareWithInsertEntity();
		User entity = (User) commonService.get(new User(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertTrue("Object should be deleted, but it's not.",
				commonService.delete(insertedEntity, insertedEntity.getId()));
	}

	@Test
	// @Ignore
	@Transactional
	public void saveTest() {
		User nonInsertedEntity = new User();
		nonInsertedEntity = prepareWithoutInsertEntity();
		Long insertedEntityId = userService.save(nonInsertedEntity);
		User insertedEntity = new User();
		insertedEntity = (User) commonService.get(new User(), insertedEntityId);
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
		User insertedEntity = new User();
		insertedEntity = prepareWithInsertEntity();
		User gettedEntity = (User) commonService.get(new User(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", gettedEntity);
		Assert.assertEquals("Id for inserted and selected object must be the same.", insertedEntity.getId(),
				gettedEntity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity,
				gettedEntity);
		User newEntity = new User();
		newEntity = prepareWithoutInsertEntity();
		Assert.assertNotEquals("Objects must have a differense.", newEntity, gettedEntity);
		newEntity.setId(gettedEntity.getId());
		Assert.assertTrue("Object in DB was not updated.", userService.update(newEntity));
		gettedEntity = (User) commonService.get(new User(), newEntity.getId());
		Assert.assertEquals("Objects must to be similar.", newEntity, gettedEntity);
		commonService.delete(gettedEntity, gettedEntity.getId());

	}

	@Test
	// @Ignore
	public void getAllTest() {
		List<User> objectList = createObjectListWithInsert();
		List<User> selectedObjects = new ArrayList<User>();
		selectedObjects = commonService.getAll(new User());
		Assert.assertEquals("List of selected objects is different from list of inserted objects.", objectList,
				selectedObjects);
		deleteObjectList(selectedObjects);

	}

	@Test
	@Ignore
	public void saveXmlTest() {
		User user = prepareWithoutInsertEntity();
		user.setId(userService.save(user));

	}

	@Test
	@Ignore
	public void getXmlTest() {
		User user = (User) commonService.get(new User(), 1L);
		Assert.assertNotNull("book for id=1 should not be null", user);
		Assert.assertEquals(new Long(1), user.getId());
		System.out.println(user.toString());
	}
}
