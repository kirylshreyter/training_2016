package com.kirylshreyter.training.hotel.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daoapi.IEmployeeDao;
import com.kirylshreyter.training.hotel.datamodel.Employee;
import com.kirylshreyter.training.hotel.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Inject
	private IEmployeeDao employeeDao;

	@Override
	public Long save(Employee employee) {
		return employeeDao.insert(employee);
	}

	@Override
	public Boolean update(Employee employee) {
		return employeeDao.update(employee);
	}
}
