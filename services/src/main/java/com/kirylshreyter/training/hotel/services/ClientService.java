package com.kirylshreyter.training.hotel.services;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Client;

public interface ClientService {
	void save(Client client);

	void update(Client client);

	Client get(Long id);

	List<Client> getAll();

	void delete(Long id);

}
