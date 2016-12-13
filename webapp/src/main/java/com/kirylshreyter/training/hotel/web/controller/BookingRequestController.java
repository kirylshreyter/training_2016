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

import com.kirylshreyter.training.hotel.daodb.util.DateConverter;
import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.services.BookingRequestService;
import com.kirylshreyter.training.hotel.services.CommonService;
import com.kirylshreyter.training.hotel.web.model.BookingRequestModel;

@RestController
@RequestMapping("/bookingrequest")
public class BookingRequestController {

	@Inject
	private DateConverter dateConverter;

	@Inject
	private BookingRequestService bookingRequestService;

	@Inject
	private CommonService commonService;

	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll() {
		List<Object> all = new ArrayList<Object>(commonService.getAll(new BookingRequest()));
		List<Object> converted = new ArrayList<>();
		for (Object object : all) {
			converted.add(this.conversionService.convert(object, Object.class));
		}
		return new ResponseEntity<List<Object>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{bookingRequestId}", method = RequestMethod.GET)
	public ResponseEntity<Object> get(@PathVariable Long bookingRequestId) {
		Object object = commonService.get(new BookingRequest(), bookingRequestId);
		return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> create(@RequestBody BookingRequestModel bookingRequestModel) {
		Long id = bookingRequestService
				.save((BookingRequest) this.conversionService.convert(bookingRequestModel, Object.class));
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{bookingRequestId}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> update(@RequestBody BookingRequestModel bookingRequestModel,
			@PathVariable Long bookingRequestId) {
		BookingRequest bookingRequest = (BookingRequest) this.conversionService.convert(bookingRequestModel,
				Object.class);
		bookingRequest.setId(bookingRequestId);
		bookingRequest.setArrivalDate(dateConverter.javaSqlDateToJavaUtilDate(bookingRequestModel.getArrivalDate()));
		bookingRequest
				.setDepartureDate(dateConverter.javaSqlDateToJavaUtilDate(bookingRequestModel.getDepartureDate()));
		return new ResponseEntity<Boolean>(bookingRequestService.update(bookingRequest), HttpStatus.OK);
	}

	@RequestMapping(value = "/{bookingRequestId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable Long bookingRequestId) {
		return new ResponseEntity<Boolean>(commonService.delete(new BookingRequest(), bookingRequestId), HttpStatus.OK);
	}

}
