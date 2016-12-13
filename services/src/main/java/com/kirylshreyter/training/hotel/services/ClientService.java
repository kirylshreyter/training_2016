package com.kirylshreyter.training.hotel.services;

import com.kirylshreyter.training.hotel.datamodel.Client;

public interface ClientService {

	Long save(Client client);

	Boolean update(Client client);
}
