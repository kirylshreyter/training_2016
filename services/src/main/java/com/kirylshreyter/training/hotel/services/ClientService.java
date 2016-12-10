package com.kirylshreyter.training.hotel.services;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Client;

public interface ClientService {

	Long save(Client client);

	Boolean update(Client client);

	List<Client> getAll();

	Boolean delete(Long id);

}
