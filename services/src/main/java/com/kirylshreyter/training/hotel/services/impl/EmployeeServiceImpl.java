package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.EmployeeDao;
import com.kirylshreyter.training.hotel.datamodel.Employee;
import com.kirylshreyter.training.hotel.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private EmployeeDao employeeDao;

	@Override
	public void save(Employee employee) {
		employeeDao.insert(employee);

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

	}

}
