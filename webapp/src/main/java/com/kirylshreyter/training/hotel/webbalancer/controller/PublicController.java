package com.kirylshreyter.training.hotel.webbalancer.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.HttpClientBuilder;
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

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/public")
public class PublicController {

	//@Inject
	//private CacheMethods cacheMethods;

	private Integer getRandomServer() {
		Integer i = ThreadLocalRandom.current().nextInt(1, 3 + 1);
		return i;
	}
	@CrossOrigin(origins = "http://127.0.0.1:8888")
	@RequestMapping(method = RequestMethod.POST)
	private ResponseEntity<List<Object>> getAllAvailableRoom(@RequestBody String data,
			@RequestHeader(value="Origin") String origin) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = null;
		List<Object> myObject = null;
		String temportyUrl = "http://127.0.0.1:808" + getRandomServer();
		HttpHeaders headers = new HttpHeaders();
		try {
			String targetUrl = String.format(temportyUrl);
			request = new HttpPost(targetUrl);
			ByteArrayEntity bae = new ByteArrayEntity(data.getBytes());
			request.addHeader("Content-Type", "application/json; charset=UTF-8");
			request.addHeader("Origin",origin);
			request.setEntity(bae);
			HttpResponse response = httpClient.execute(request);
			headers.add("Access-Control-Allow-Origin", origin);
			ObjectMapper objectMapper = new ObjectMapper();
			myObject = (List<Object>) objectMapper.readValue(response.getEntity().getContent(), Object.class);
		} catch (Exception ex) {
			return new ResponseEntity<List<Object>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Object>>(myObject, headers, HttpStatus.OK);

	}
	
	@CrossOrigin(origins = "http://127.0.0.1:8888")
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	private ResponseEntity<Long> insertRequest(@RequestBody String data,
			@RequestHeader(value="Origin") String origin) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = null;
		String temportyUrl = "http://127.0.0.1:808" + getRandomServer() + "/book";
		HttpHeaders headers = new HttpHeaders();
		Long myObject = null;
		try {
			String targetUrl = String.format(temportyUrl);
			request = new HttpPost(targetUrl);
			ByteArrayEntity bae = new ByteArrayEntity(data.getBytes());
			request.addHeader("Content-Type", "application/json; charset=UTF-8");
			request.addHeader("Origin",origin);
			request.setEntity(bae);
			HttpResponse response = httpClient.execute(request);
			headers.add("Access-Control-Allow-Origin", origin);
			ObjectMapper objectMapper = new ObjectMapper();
			myObject = (Long) objectMapper.readValue(response.getEntity().getContent(), Long.class);
		} catch (Exception ex) {
			return new ResponseEntity<Long>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Long>(myObject, headers, HttpStatus.OK);

	}

	@CrossOrigin(origins = "http://127.0.0.1:8887")
	@RequestMapping(value = "/{entityTree}/{entityId}/add", method = RequestMethod.GET)
	private ResponseEntity<Object> getEntityAdd(@PathVariable String entityTree, @PathVariable Long entityId,
			@RequestHeader(value = "Origin") String origin) {
		HttpClient httpClient = HttpClientBuilder.create().build();
		String temportyUrl = "http://127.0.0.1:808" + getRandomServer() + "/%s/%s" + "/add";
		try {
			String targetUrl = String.format(temportyUrl, entityTree, entityId.toString());
			System.out.println(targetUrl);
			HttpGet request = new HttpGet(targetUrl);
			HttpResponse response = httpClient.execute(request);
			ObjectMapper objectMapper = new ObjectMapper();
			System.out.println("ok");
			Object myObject = objectMapper.readValue(response.getEntity().getContent(), Object.class);
			HttpHeaders headers = new HttpHeaders();
			headers.add("Access-Control-Allow-Origin", origin);
			return new ResponseEntity<Object>(myObject, headers, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
		}
	}
}
