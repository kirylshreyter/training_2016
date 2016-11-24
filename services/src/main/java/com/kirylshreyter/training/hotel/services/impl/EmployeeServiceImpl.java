package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daoapi.IEmployeeDao;
import com.kirylshreyter.training.hotel.datamodel.Employee;
import com.kirylshreyter.training.hotel.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Inject
	private IEmployeeDao employeeDao;

	@Override
	public void save(Employee employee) {
		Long returnedId = employeeDao.insert(employee);
		LOGGER.info("Employee was inserted, id = {}", returnedId);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);

	}

	@Override
	public Employee get(Long id) {
		return employeeDao.get(id);
	}

	@Override
	public List<Employee> getAll() {
		List<Employee> emplyeeList = new ArrayList<Employee>(employeeDao.getAll());
		return emplyeeList;
	}

	@Override
	public void delete(Long id) {
		employeeDao.delete(id);
		LOGGER.info("Employee was deleted, id = {}", id);

	}

}
