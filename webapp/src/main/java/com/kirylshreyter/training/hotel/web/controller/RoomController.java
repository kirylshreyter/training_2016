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

import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.services.CommonService;
import com.kirylshreyter.training.hotel.services.RoomService;
import com.kirylshreyter.training.hotel.web.model.RoomModel;

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
		return new ResponseEntity<List<Object>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{roomId}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable Long roomId) {
		Object object = commonService.get(new Room(), roomId);
		return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody RoomModel roomModel) {
		Long id = roomService.save((Room) this.conversionService.convert(roomModel, Object.class));
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{roomId}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody RoomModel roomModel, @PathVariable Long roomId) {
		Room room = (Room) this.conversionService.convert(roomModel, Object.class);
		room.setId(roomId);
		return new ResponseEntity<Boolean>(roomService.update(room), HttpStatus.OK);
	}

	@RequestMapping(value = "/{roomId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable Long roomId) {
		return new ResponseEntity<Boolean>(commonService.delete(new Room(), roomId), HttpStatus.OK);
	}

}
