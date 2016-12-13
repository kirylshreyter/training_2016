package com.kirylshreyter.training.hotel.daoapi;

import com.kirylshreyter.training.hotel.datamodel.Employee;

public interface IEmployeeDao {
	
	Long insert(Employee entity);

	Boolean update(Employee entity);

}
