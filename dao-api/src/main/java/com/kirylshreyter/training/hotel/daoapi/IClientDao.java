package com.kirylshreyter.training.hotel.daoapi;

import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Client;

public interface IClientDao {

	Long insert(Client entity);

	Boolean update(Client entity);

	Boolean delete(Long id);

	List<Client> getAll();

}
