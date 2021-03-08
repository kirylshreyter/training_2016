package com.kirylshreyter.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.kirylshreyter.hotel.datamodel.Employee;
import com.kirylshreyter.hotel.services.CommonService;
import com.kirylshreyter.hotel.services.EmployeeService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.hotel.web.model.EmployeeModel;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Inject
	private EmployeeService employeeService;

	@Inject
	private CommonService commonService;

	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll() {
		List<Object> all = new ArrayList<Object>(commonService.getAll(new Employee()));
		List<Object> converted = new ArrayList<>();
		for (Object object : all) {
			converted.add(this.conversionService.convert(object, Object.class));
		}
		return new ResponseEntity<List<Object>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable Long employeeId) {
		Object object = commonService.get(new Employee(), employeeId);
		return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody EmployeeModel employeeModel) {
		Long id = employeeService.create((Employee) this.conversionService.convert(employeeModel, Object.class));
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody EmployeeModel employeeModel, @PathVariable Long employeeId) {
		Employee employee = (Employee) this.conversionService.convert(employeeModel, Object.class);
		employee.setId(employeeId);
		return new ResponseEntity<Boolean>(employeeService.update(employee), HttpStatus.OK);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable Long employeeId) {
		return new ResponseEntity<Boolean>(commonService.delete(new Employee(), employeeId), HttpStatus.OK);
	}

}
