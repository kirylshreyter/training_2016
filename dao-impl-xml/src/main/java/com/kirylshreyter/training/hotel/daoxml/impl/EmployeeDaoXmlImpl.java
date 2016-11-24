package com.kirylshreyter.training.hotel.daoxml.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IEmployeeDao;
import com.kirylshreyter.training.hotel.datamodel.Employee;

@Repository
public class EmployeeDaoXmlImpl implements IEmployeeDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoXmlImpl.class);

	private Boolean notNullChecker(Employee entity) {
		if (entity.getFirstName() == null) {
			throw new RuntimeException("Employee's first name is not setted.");
		}
		if (entity.getLastName() == null) {
			throw new RuntimeException("Employee's last name is not setted.");
		}
		if (entity.getPhone() == null) {
			throw new RuntimeException("Employee's phone number is not setted.");
		}
		if (entity.getEmail() == null) {
			throw new RuntimeException("Employee's email is not setted.");
		}
		if (entity.getAddress() == null) {
			throw new RuntimeException("Employee's address is not setted.");
		}
		if (entity.getPosition() == null) {
			throw new RuntimeException("Employee's position is not setted.");
		}
		return true;
	}

	@Override
	public Employee get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(Employee entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Employee entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
