package com.kirylshreyter.training.hotel.daodb;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Client;

public interface ClientDao {

	Client get(Long id);

	void insert(Client entity);

	void update(Client entity);

	void delete(Long id);

	List<Client> getAll();

}
