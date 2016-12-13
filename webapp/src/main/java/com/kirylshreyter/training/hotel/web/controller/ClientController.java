package com.kirylshreyter.training.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.ClientService;
import com.kirylshreyter.training.hotel.services.CommonService;
import com.kirylshreyter.training.hotel.web.model.ClientModel;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Inject
	private ClientService clientService;

	@Inject
	private CommonService commonService;

	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Object>> getAll() {
		List<Object> all = new ArrayList<Object>(clientService.getAll());
		List<Object> converted = new ArrayList<>();
		for (Object object : all) {
			converted.add(this.conversionService.convert(object, Object.class));
		}
		HttpHeaders headers = new HttpHeaders();
		headers.add("entity", converted.get(0).getClass().getName());
		return new ResponseEntity<List<Object>>(converted,headers, HttpStatus.OK);
	}

	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getById(@PathVariable Long clientId) {
		Object object = commonService.get(new Client(), clientId);
		return new ResponseEntity<Object>(this.conversionService.convert(object, Object.class), HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Long> createNewClient(@RequestBody ClientModel clientModel) {
		Long id = clientService.save((Client) this.conversionService.convert(clientModel, Object.class));
		return new ResponseEntity<Long>(id, HttpStatus.CREATED);

	}

	@RequestMapping(value = "/{clientId}", method = RequestMethod.POST)
	public ResponseEntity<Boolean> updateClient(@RequestBody ClientModel clientModel, @PathVariable Long clientId) {
		Client client = (Client) this.conversionService.convert(clientModel, Object.class);
		client.setId(clientId);
		return new ResponseEntity<Boolean>(clientService.update(client), HttpStatus.OK);
	}

	@RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable Long clientId) {
		return new ResponseEntity<Boolean>(commonService.delete(new Client(), clientId), HttpStatus.OK);
	}
}