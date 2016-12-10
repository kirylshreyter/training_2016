package com.kirylshreyter.training.hotel.web.controller;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.ClientService;
import com.kirylshreyter.training.hotel.services.CommonService;
import com.kirylshreyter.training.hotel.services.RoomDetailsService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Inject
	private ClientService clientService;

	@Inject
	private RoomDetailsService roomDetailsService;
	
	@Inject
	private CommonService commonService;

	@Inject
	private ConversionService conversionService;
	@Inject
	private Converter<Object, Object> objectToObjectConverter;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Boolean> test() {

		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable Long clientId) {
		Object object = commonService.get(new Client(), clientId);
		if(object==null){return new ResponseEntity<Object>(null,HttpStatus.NOT_FOUND);}else{
		return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);}
	}

}
