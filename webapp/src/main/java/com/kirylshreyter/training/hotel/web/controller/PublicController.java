package com.kirylshreyter.training.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.json.JSONObject;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.training.hotel.daodb.util.DateConverter;
import com.kirylshreyter.training.hotel.services.RoomService;

@RestController
@RequestMapping("/availablerooms")
public class PublicController {

	@Inject
	private RoomService roomService;

	@Inject
	private ConversionService conversionService;

	@Inject
	private DateConverter dateConverter;

	/*
	 * @RequestMapping(method = RequestMethod.GET) public
	 * ResponseEntity<List<Object>> getAll() { List<Object> all = new
	 * ArrayList<Object>(commonService.getAll(new Room())); List<Object>
	 * converted = new ArrayList<>(); for (Object object : all) {
	 * converted.add(this.conversionService.convert(object, Object.class)); }
	 * return new ResponseEntity<List<Object>>(converted, HttpStatus.OK); }
	 */

	@CrossOrigin(origins = "http://localhost:8888")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<Object>> getAvailableRoom(@RequestBody String body) {

		JSONObject jsonResult = new JSONObject(body);
		List<Object> all = new ArrayList<Object>(roomService.getAllAvailableRoom(
				dateConverter.stringToJavaUtilDateConverter(jsonResult.getString("arrivalDate")),
				dateConverter.stringToJavaUtilDateConverter(jsonResult.getString("departureDate")),
				jsonResult.getInt("numberOfPlaces")));
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
}
