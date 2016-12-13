package com.kirylshreyter.training.hotel.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daoapi.IClientDao;
import com.kirylshreyter.training.hotel.datamodel.Client;
import com.kirylshreyter.training.hotel.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	@Inject
	private IClientDao clientDao;
	

	@Override
	public Long save(Client client) {
		return clientDao.insert(client);
	}

	@Override
	public Boolean update(Client client) {
		return clientDao.update(client);

	}
}
