package com.kirylshreyter.hotel.daoxml.impl;

import com.kirylshreyter.hotel.daoapi.IEmployeeDao;
import com.kirylshreyter.hotel.datamodel.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoXmlImpl implements IEmployeeDao {
	@Override
	public Long create(Employee entity) {
		return null;
	}

	@Override
	public Employee read(Long id) {
		return null;
	}

	@Override
	public Boolean update(Employee entity) {
		return null;
	}

	@Override
	public Integer delete(Long id) {
		return null;
	}

	@Override
	public List<Employee> getAll() {
		return null;
	}
}
