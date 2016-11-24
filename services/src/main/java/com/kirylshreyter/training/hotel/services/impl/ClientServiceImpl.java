package com.kirylshreyter.training.hotel.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daodb.ClientDao;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.ClientService;

import javax.ejb.*;

//@Service
@W
public class ClientServiceImpl implements ClientService {

	@Inject
	private ClientDao clientDao;

	@Override
	public Long save(Client client) {
		return clientDao.insert(client);

	}

	@Override
	public Boolean update(Client client) {
		return clientDao.update(client);

	}

	@Override
	public Client get(Long id) {
		return clientDao.get(id);
	}

	@Override
	public List<Client> getAll() {
		List<Client> clientList = new ArrayList<Client>(clientDao.getAll());
		return clientList;
	}

	@Override
	public Boolean delete(Long id) {
		return clientDao.delete(id);
	}

}
