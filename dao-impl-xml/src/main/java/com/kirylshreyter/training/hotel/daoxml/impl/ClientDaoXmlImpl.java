package com.kirylshreyter.training.hotel.daoxml.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IClientDao;
import com.kirylshreyter.training.hotel.datamodel.Client;

@Repository
public class ClientDaoXmlImpl implements IClientDao {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientDaoXmlImpl.class);

	private Boolean notNullChecker(Client entity) {
		if (entity.getFirstName() == null) {
			throw new RuntimeException("Client's first name is not setted.");
		}
		if (entity.getLastName() == null) {
			throw new RuntimeException("Client's last name is not setted.");
		}
		if (entity.getPhone() == null) {
			throw new RuntimeException("Client's phone number is not setted.");
		}
		if (entity.getEmail() == null) {
			throw new RuntimeException("Client's email is not setted.");
		}
		if (entity.getAddress() == null) {
			throw new RuntimeException("Client's address is not setted.");
		}
		return true;
	}

	@Override
	public Client get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long insert(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean update(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Client> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
