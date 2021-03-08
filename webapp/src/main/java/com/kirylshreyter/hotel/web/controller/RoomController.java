package com.kirylshreyter.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.kirylshreyter.hotel.services.CommonService;
import com.kirylshreyter.hotel.services.RoomService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.hotel.datamodel.Room;
import com.kirylshreyter.hotel.web.model.RoomModel;

@RestController
@RequestMapping("/room")
public class RoomController {
	@Inject
	private RoomService roomService;

	@Inject
	private CommonService commonService;

	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll() {
		List<Object> all = new ArrayList<Object>(commonService.getAll(new Room()));
		List<Object> converted = new ArrayList<>();
		for (Object object : all) {
			converted.add(this.conversionService.convert(object, Object.class));
		}
		if (converted.size() > 0) {
			return new ResponseEntity<List<Object>>(converted, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Object>>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable Long roomId) {
		Object object = commonService.get(new Room(), roomId);
		if (object != null) {
			return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody RoomModel roomModel) {
		Long id = roomService.create((Room) this.conversionService.convert(roomModel, Object.class));
		if (id != null) {
			return new ResponseEntity<Long>(id, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}

	}

	@RequestMapping(value = "/{roomId}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody RoomModel roomModel, @PathVariable Long roomId) {
		Room room = (Room) this.conversionService.convert(roomModel, Object.class);
		room.setId(roomId);
		Boolean status = roomService.update(room);
		if (status == true) {
			return new ResponseEntity<Boolean>(status, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(status, HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/{roomId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable Long roomId) {
		Boolean status = commonService.delete(new Room(), roomId);
		if (status == true) {
			return new ResponseEntity<Boolean>(status, HttpStatus.OK);
		} else {
			return new ResponseEntity<Boolean>(status, HttpStatus.NOT_FOUND);
		}
	}
}
