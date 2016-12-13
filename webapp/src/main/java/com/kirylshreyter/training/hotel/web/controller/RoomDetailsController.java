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

import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.kirylshreyter.training.hotel.services.CommonService;
import com.kirylshreyter.training.hotel.services.RoomDetailsService;
import com.kirylshreyter.training.hotel.web.model.RoomDetailsModel;

@RestController
@RequestMapping("/roomdetails")
public class RoomDetailsController {
	@Inject
	private RoomDetailsService roomDetailsService;

	@Inject
	private CommonService commonService;

	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll() {
		List<Object> all = new ArrayList<Object>(commonService.getAll(new RoomDetails()));
		List<Object> converted = new ArrayList<>();
		for (Object object : all) {
			converted.add(this.conversionService.convert(object, Object.class));
		}
		return new ResponseEntity<List<Object>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{detailsId}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable Long detailsId) {
		Object object = commonService.get(new RoomDetails(), detailsId);
		return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody RoomDetailsModel roomDetailsModel) {
		Long id = roomDetailsService.save((RoomDetails) this.conversionService.convert(roomDetailsModel, Object.class));
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{detailsId}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody RoomDetailsModel roomDetailsModel,
			@PathVariable Long detailsId) {
		RoomDetails roomDetails = (RoomDetails) this.conversionService.convert(roomDetailsModel, Object.class);
		roomDetails.setId(detailsId);
		return new ResponseEntity<Boolean>(roomDetailsService.update(roomDetails), HttpStatus.OK);
	}

	@RequestMapping(value = "/{detailsId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable Long employeeId) {
		return new ResponseEntity<Boolean>(commonService.delete(new RoomDetails(), employeeId), HttpStatus.OK);
	}

}
