package com.kirylshreyter.training.hotel.services.impl;

import java.io.IOException;
import java.util.List;

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

		try {
			return clientDao.insert(client);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

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
		return clientDao.getAll();
	}

	@Override
	public Boolean delete(Long id) {
		return clientDao.delete(id);
	}

}
