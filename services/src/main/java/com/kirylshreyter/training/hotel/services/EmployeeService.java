package com.kirylshreyter.training.hotel.services;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Employee;

public interface EmployeeService {
	void save(Employee employee);

	void update(Employee employee);

	Employee get(Long id);

	List<Employee> getAll();

	void delete(Long id);

}
