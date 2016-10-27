package com.kirylshreyter.training.hotel.daodb;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Employee;

public interface EmployeeDao {
	
	Employee get(Long id);

	void insert(Employee entity);

	void update(Employee entity);

	void delete(Long id);

	List<Employee> getAll();

}
