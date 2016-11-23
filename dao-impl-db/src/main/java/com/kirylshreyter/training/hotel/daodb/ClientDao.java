package com.kirylshreyter.training.hotel.daodb;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Client;

public interface ClientDao {

	Client get(Long id);

	Long insert(Client entity);

	Boolean update(Client entity);

	Boolean delete(Long id);

	List<Client> getAll();

}
