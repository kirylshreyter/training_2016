package com.kirylshreyter.training.hotel.daoxml.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IClientDao;
import com.kirylshreyter.training.hotel.datamodel.Client;

@Repository
public class ClientDaoXmlImpl implements IClientDao {

	@Inject
	private Common common;

	@Override
	public Long insert(Client entity) {
		List<Client> allClients = readCollection(entity);
		Long id = getNextId(allClients);

		allClients.add(entity);

		entity.setId(new Long(id));

		writeCollection(allClients);
		return id;
	}

	private List<Client> readCollection(Client entity) {
		try {
			common.intialize(entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<Client>) Common.xstream.fromXML(Common.file);
	}

	private void writeCollection(List<Client> newList) {
		try {
			Common.xstream.toXML(newList, new FileOutputStream(Common.file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<Client> allClients) {
		return allClients.isEmpty() ? 1l : allClients.get(allClients.size() - 1).getId() + 1;
	}

	@Override
	public Boolean update(Client entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
