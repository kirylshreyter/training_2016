package com.kirylshreyter.training.hotel.daoapi;

import com.kirylshreyter.training.hotel.datamodel.User;

public interface IUserDao {

	Long insert(User entity);

	Boolean update(User entity);
}
