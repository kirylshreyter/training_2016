package com.kirylshreyter.training.hotel.daoapi;

import com.kirylshreyter.training.hotel.datamodel.Client;

public interface IClientDao {

	Long insert(Client entity);

	Boolean update(Client entity);
}
