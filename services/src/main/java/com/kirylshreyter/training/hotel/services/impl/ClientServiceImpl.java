package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.ClientDao;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	@Inject
	private ClientDao clientDao;

	@Override
	public void save(Client client) {
		Long returnedId = clientDao.insert(client);
		LOGGER.info("Client was inserted, id = {}", returnedId);

	}

	@Override
	public void update(Client client) {
		clientDao.update(client);

	}

	@Override
	public Client get(Long id) {
		try {
			return clientDao.get(id);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	@Override
	public List<Client> getAll() {
		List<Client> clientList = new ArrayList<Client>(clientDao.getAll());
		return clientList;
	}

	@Override
	public void delete(Long id) {
		clientDao.delete(id);
		LOGGER.info("Client was deleted, id = {}", id);

	}

}
