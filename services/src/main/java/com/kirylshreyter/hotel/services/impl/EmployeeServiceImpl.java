package com.kirylshreyter.hotel.services.impl;

import com.kirylshreyter.hotel.daoapi.IEmployeeDao;
import com.kirylshreyter.hotel.datamodel.Employee;
import com.kirylshreyter.hotel.services.EmployeeService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Inject
    private IEmployeeDao employeeDao;

    @Override
    public Long create(Employee entity) {
        return employeeDao.create(entity);
    }

    @Override
    public Employee read(Long id) {
        return null;
    }

    @Override
    public Boolean update(Employee employee) {
        return employeeDao.update(employee);
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
