package com.kirylshreyter.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.kirylshreyter.hotel.datamodel.BookingRequest;
import com.kirylshreyter.hotel.datamodel.User;
import com.kirylshreyter.hotel.services.BookingRequestService;
import com.kirylshreyter.hotel.services.RoomService;
import com.kirylshreyter.hotel.services.UserService;
import com.kirylshreyter.hotel.web.model.BookingRequestModel;
import com.kirylshreyter.hotel.web.model.UserModel;
import org.json.JSONObject;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.hotel.daodb.util.DateConverter;

@RestController
@RequestMapping("/")
public class AvailableRoomController {
	
	@Inject
	private BookingRequestService bookingRequestService;

	@Inject
	private RoomService roomService;

	@Inject
	private ConversionService conversionService;

	@Inject
	private DateConverter dateConverter;
	
	@Inject
	private UserService userService;

	/*
	 * @RequestMapping(method = RequestMethod.GET) public
	 * ResponseEntity<List<Object>> getAll() { List<Object> all = new
	 * ArrayList<Object>(commonService.getAll(new Room())); List<Object>
	 * converted = new ArrayList<>(); for (Object object : all) {
	 * converted.add(this.conversionService.convert(object, Object.class)); }
	 * return new ResponseEntity<List<Object>>(converted, HttpStatus.OK); }
	 */

	@CrossOrigin(origins = "http://127.0.0.1:8888")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<List<Object>> getAvailableRoom(@RequestBody String body,
			@RequestHeader(value = "Origin") String origin) {
		HttpHeaders headers = new HttpHeaders();
		JSONObject jsonResult = new JSONObject(body);
		List<Object> all = null;
		try {
			all = new ArrayList<Object>(roomService.getAllAvailableRoom(
					dateConverter.stringToJavaUtilDateConverter(jsonResult.getString("arrivalDate")),
					dateConverter.stringToJavaUtilDateConverter(jsonResult.getString("departureDate")),
					jsonResult.getInt("numberOfPlaces")));
		} catch (NullPointerException e) {
			return null;
		}
		List<Object> converted = new ArrayList<>();
		for (Object object : all) {
			converted.add(this.conversionService.convert(object, Object.class));
			headers.add("Access-Control-Allow-Origin", origin);
		}
		if (converted.size() > 0) {
			return new ResponseEntity<List<Object>>(converted, headers, HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Object>>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*@CrossOrigin(origins = "http://127.0.0.1:8888")
	@RequestMapping(value="/insert",method = RequestMethod.POST)
	public ResponseEntity<Long> insertUser(@RequestBody UserModel userModel,
			@RequestHeader(value = "Origin") String origin) {
		HttpHeaders headers = new HttpHeaders();
		Long id = userService.create((User) this.conversionService.convert(userModel, Object.class));
		headers.add("Access-Control-Allow-Origin", origin);
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}*/
	
	@CrossOrigin(origins = "http://127.0.0.1:8888")
	@RequestMapping(value="/book",method = RequestMethod.POST)
	public ResponseEntity<Long> insertRequest(@RequestBody String body,
			@RequestHeader(value = "Origin") String origin) {
		HttpHeaders headers = new HttpHeaders();
		JSONObject jsonResult = new JSONObject(body);
		UserModel userModel = new UserModel();
		userModel.setId(jsonResult.getLong("id"));
		userModel.setName(jsonResult.getString("firstName"));
		userModel.setEmail(jsonResult.getString("email"));
		Long userId = userService.create((User) this.conversionService.convert(userModel, Object.class));
		BookingRequestModel bookingRequestModel = new BookingRequestModel();
		bookingRequestModel.setId(jsonResult.getLong("id"));
		bookingRequestModel.setUserId(userId);
		bookingRequestModel.setRoomId(jsonResult.getLong("roomId"));
		bookingRequestModel.setArrivalDate(dateConverter.stringToJavaUtilDateConverter(jsonResult.getString("arrivalDate")));
		bookingRequestModel.setDepartureDate(dateConverter.stringToJavaUtilDateConverter(jsonResult.getString("departureDate")));
		Long bookingRequestId = bookingRequestService.create((BookingRequest) this.conversionService.convert(bookingRequestModel, Object.class));
		headers.add("Access-Control-Allow-Origin", origin);
		return new ResponseEntity<Long>(bookingRequestId, HttpStatus.CREATED);
	}
}
