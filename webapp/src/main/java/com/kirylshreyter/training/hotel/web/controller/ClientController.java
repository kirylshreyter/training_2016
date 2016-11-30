package com.kirylshreyter.training.hotel.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.ClientService;
import com.kirylshreyter.training.hotel.web.model.ClientModel;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@Inject
	private ClientService clientService;

	@Inject
	private ConversionService conversionService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClientModel>> getAll() {
		List<Client> all = clientService.getAll();
		List<ClientModel> converted = new ArrayList<>();
		for (Client client : all) {
			converted.add(this.conversionService.convert(client, ClientModel.class));
		}

		return new ResponseEntity<List<ClientModel>>(converted, HttpStatus.OK);
	}

	@RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
	public ResponseEntity<ClientModel> getById(@PathVariable Long clientId) {
		Client client = clientService.get(clientId);
		return new ResponseEntity<ClientModel>(this.conversionService.convert(client, ClientModel.class),
				HttpStatus.OK);
	}

}
