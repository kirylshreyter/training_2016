package com.kirylshreyter.training.hotel.services;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.kirylshreyter.training.hotel.datamodel.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:service-context.xml")
public class EmployeeServiceTest {

	@Inject
	private CommonService commonService;

	@Inject
	private EmployeeService employeeService;

	private Employee prepareWithInsertEntity() {
		Employee employee = new Employee();
		employee.setFirstName("Иван");
		employee.setLastName("Иванов");
		employee.setPhone("+375297800000");
		employee.setEmail("ivanov@gmail.com");
		employee.setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
		employee.setPosition("administrator");
		employee.setId(employeeService.save(employee));
		return employee;
	}

	private Employee prepareWithoutInsertEntity() {
		Employee employee = new Employee();
		employee.setFirstName("Иван");
		employee.setLastName("Иванов");
		employee.setPhone("+375297800000");
		employee.setEmail("ivanov@gmail.com");
		employee.setAddress("Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1");
		employee.setPosition("administrator");
		return employee;
	}

	@Transactional
	private void deleteObjectList(List<Employee> selectedObjects) {
		for (int i = 0; i < selectedObjects.size(); i++) {
			commonService.delete(selectedObjects.get(i), selectedObjects.get(i).getId());
		}
	}

	@Transactional
	private List<Employee> createObjectListWithInsert() {
		List<Employee> objectList = new ArrayList<Employee>();
		for (int i = 0; i < 5; i++) {
			Employee employee = new Employee();
			employee = prepareWithoutInsertEntity();
			Long id = employeeService.save(employee);
			employee.setId(id);
			objectList.add(employee);
		}
		return objectList;
	}

	@Test
	// @Ignore
	public void getTest() {
		Employee insertedEntity = new Employee();
		insertedEntity = prepareWithInsertEntity();
		Employee entity = (Employee) commonService.get(new Employee(), insertedEntity.getId());
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
		Employee insertedEntity = new Employee();
		insertedEntity = prepareWithInsertEntity();
		Employee entity = (Employee) commonService.get(new Employee(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", entity);
		Assert.assertTrue("Object should be deleted, but it's not.",
				commonService.delete(insertedEntity, insertedEntity.getId()));
	}

	@Test
	// @Ignore
	@Transactional
	public void saveTest() {
		Employee nonInsertedEntity = new Employee();
		nonInsertedEntity = prepareWithoutInsertEntity();
		Long insertedEntityId = employeeService.save(nonInsertedEntity);
		Employee insertedEntity = new Employee();
		insertedEntity = (Employee) commonService.get(new Employee(), insertedEntityId);
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
		Employee insertedEntity = new Employee();
		insertedEntity = prepareWithInsertEntity();
		Employee gettedEntity = (Employee) commonService.get(new Employee(), insertedEntity.getId());
		Assert.assertNotNull("Getted from DB object should not be null.", gettedEntity);
		Assert.assertEquals("Id for inserted and selected object must be the same.", insertedEntity.getId(),
				gettedEntity.getId());
		Assert.assertEquals("Inserted object is not the object which getted from database.", insertedEntity,
				gettedEntity);
		Employee newEntity = new Employee();
		newEntity = prepareWithoutInsertEntity();
		newEntity.setAddress("г. Гродно");
		Assert.assertNotEquals("Objects must have a differense.", newEntity, gettedEntity);
		newEntity.setId(gettedEntity.getId());
		Assert.assertTrue("Object in DB was not updated.", employeeService.update(newEntity));
		gettedEntity = (Employee) commonService.get(new Employee(), newEntity.getId());
		Assert.assertEquals("Objects must to be similar.", newEntity, gettedEntity);
		commonService.delete(gettedEntity, gettedEntity.getId());

	}

	@Test
	// @Ignore
	public void getAllTest() {
		List<Employee> objectList = createObjectListWithInsert();
		List<Employee> selectedObjects = new ArrayList<Employee>();
		selectedObjects = commonService.getAll(new Employee());
		Assert.assertEquals("List of selected objects is different from list of inserted objects.", objectList,
				selectedObjects);
		deleteObjectList(selectedObjects);

	}

}
