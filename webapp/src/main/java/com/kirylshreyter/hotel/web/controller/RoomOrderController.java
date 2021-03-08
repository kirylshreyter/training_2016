package com.kirylshreyter.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.kirylshreyter.hotel.services.CommonService;
import com.kirylshreyter.hotel.services.RoomOrderService;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.hotel.datamodel.RoomOrder;
import com.kirylshreyter.hotel.web.model.RoomOrderModel;

@RestController
@RequestMapping("/roomorder")
public class RoomOrderController {
	@Inject
	private RoomOrderService roomOrderService;

	@Inject
	private CommonService commonService;

	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll() {
		List<Object> all = new ArrayList<Object>(commonService.getAll(new RoomOrder()));
		List<Object> converted = new ArrayList<>();
		for (Object object : all) {
			converted.add(this.conversionService.convert(object, Object.class));
		}
		return new ResponseEntity<List<Object>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{roomOrderId}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable Long roomOrderId) {
		Object object = commonService.get(new RoomOrder(), roomOrderId);
		return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://127.0.0.1:8887")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody RoomOrderModel roomOrderModel,
			@RequestHeader(value = "Origin") String origin) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Access-Control-Allow-Origin", origin);
		Long id = roomOrderService.create((RoomOrder) this.conversionService.convert(roomOrderModel, Object.class));
		return new ResponseEntity<Long>(id, headers, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{roomOrderId}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody RoomOrderModel roomOrderModel, @PathVariable Long roomOrderId) {
		RoomOrder roomOrder = (RoomOrder) this.conversionService.convert(roomOrderModel, Object.class);
		roomOrder.setId(roomOrderId);
		return new ResponseEntity<Boolean>(roomOrderService.update(roomOrder), HttpStatus.OK);
	}

	@RequestMapping(value = "/{roomOrderId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable Long roomOrderId) {
		return new ResponseEntity<Boolean>(commonService.delete(new RoomOrder(), roomOrderId), HttpStatus.OK);
	}

}
