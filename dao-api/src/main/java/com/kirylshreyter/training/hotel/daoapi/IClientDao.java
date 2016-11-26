package com.kirylshreyter.training.hotel.daoapi;

import java.io.IOException;
import java.util.List;

import com.kirylshreyter.training.hotel.datamodel.Client;

public interface IClientDao {

	Client get(Long id);

	Long insert(Client entity) throws IOException;

	Boolean update(Client entity);

	Boolean delete(Long id);

	List<Client> getAll();

}
