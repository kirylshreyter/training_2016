package com.kirylshreyter.training.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.training.hotel.datamodel.User;
import com.kirylshreyter.training.hotel.services.UserService;
import com.kirylshreyter.training.hotel.services.CommonService;
import com.kirylshreyter.training.hotel.web.model.UserModel;

@RestController
@RequestMapping("/users")
public class UserController {

	@Inject
	private UserService userService;

	@Inject
	private CommonService commonService;

	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll() {
		List<Object> all = new ArrayList<Object>(commonService.getAll(new User()));
		List<Object> converted = new ArrayList<>();
		for (Object object : all) {
			converted.add(this.conversionService.convert(object, Object.class));
		}
		return new ResponseEntity<List<Object>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable Long userId) {
		Object object = commonService.get(new User(), userId);
		return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody UserModel userModel) {
		Long id = userService.save((User) this.conversionService.convert(userModel, Object.class));
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody UserModel userModel, @PathVariable Long userId) {
		User user = (User) this.conversionService.convert(userModel, Object.class);
		user.setId(userId);
		return new ResponseEntity<Boolean>(userService.update(user), HttpStatus.OK);
	}

	@RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable Long userId) {
		return new ResponseEntity<Boolean>(commonService.delete(new User(), userId), HttpStatus.OK);
	}
}
