package com.kirylshreyter.training.hotel.web_balancer.controller;

import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/clients")
public class ClientController {

	@RequestMapping(method = RequestMethod.GET)
	private ResponseEntity<List<Object>> sendGet() {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet request = null;
		List<Object> myObject = null;
		try {
			request = new HttpGet("http://127.0.0.1:8081/clients");
			HttpResponse response = httpClient.execute(request);
			ObjectMapper objectMapper = new ObjectMapper();
			myObject = (List<Object>) objectMapper.readValue(response.getEntity().getContent(), Object.class);
		} catch (Exception ex) {
			return null;
		}
		return new ResponseEntity<List<Object>>(myObject, HttpStatus.OK);

	}
}
