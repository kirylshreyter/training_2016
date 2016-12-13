package com.kirylshreyter.training.hotel.services;

import com.kirylshreyter.training.hotel.datamodel.Employee;

public interface EmployeeService {

	Long save(Employee employee);

	Boolean update(Employee employee);
}
