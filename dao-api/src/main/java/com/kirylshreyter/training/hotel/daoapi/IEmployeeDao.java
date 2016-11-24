package com.kirylshreyter.training.hotel.daoapi;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Employee;

public interface IEmployeeDao {
	
	Employee get(Long id);

	Long insert(Employee entity);

	void update(Employee entity);

	void delete(Long id);

	List<Employee> getAll();

}
