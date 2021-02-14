package com.kirylshreyter.training.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

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

import com.kirylshreyter.training.hotel.daodb.util.DateConverter;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.BookingRequestService;
import com.kirylshreyter.training.hotel.services.ClientService;
import com.kirylshreyter.training.hotel.services.RoomService;
import com.kirylshreyter.training.hotel.web.model.BookingRequestModel;
import com.kirylshreyter.training.hotel.web.model.ClientModel;

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
	private ClientService clientService;

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
	public ResponseEntity<Long> insertClient(@RequestBody ClientModel clientModel,
			@RequestHeader(value = "Origin") String origin) {
		HttpHeaders headers = new HttpHeaders();
		Long id = clientService.save((Client) this.conversionService.convert(clientModel, Object.class));
		headers.add("Access-Control-Allow-Origin", origin);
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);
	}*/
	
	@CrossOrigin(origins = "http://127.0.0.1:8888")
	@RequestMapping(value="/book",method = RequestMethod.POST)
	public ResponseEntity<Long> insertRequest(@RequestBody String body,
			@RequestHeader(value = "Origin") String origin) {
		HttpHeaders headers = new HttpHeaders();
		JSONObject jsonResult = new JSONObject(body);
		ClientModel clientModel = new ClientModel();
		clientModel.setId(jsonResult.getLong("id"));
		clientModel.setFirstName(jsonResult.getString("firstName"));
		clientModel.setLastName(jsonResult.getString("lastName"));
		clientModel.setPhone(jsonResult.getString("phone"));
		clientModel.setEmail(jsonResult.getString("email"));
		Long clientId = clientService.save((Client) this.conversionService.convert(clientModel, Object.class));
		BookingRequestModel bookingRequestModel = new BookingRequestModel();
		bookingRequestModel.setId(jsonResult.getLong("id"));
		bookingRequestModel.setClientId(clientId);
		bookingRequestModel.setRoomId(jsonResult.getLong("roomId"));
		bookingRequestModel.setArrivalDate(dateConverter.stringToJavaUtilDateConverter(jsonResult.getString("arrivalDate")));
		bookingRequestModel.setDepartureDate(dateConverter.stringToJavaUtilDateConverter(jsonResult.getString("departureDate")));
		Long bookingRequestId = bookingRequestService.save((BookingRequest) this.conversionService.convert(bookingRequestModel, Object.class));
		headers.add("Access-Control-Allow-Origin", origin);
		return new ResponseEntity<Long>(bookingRequestId, HttpStatus.CREATED);
	}
}
