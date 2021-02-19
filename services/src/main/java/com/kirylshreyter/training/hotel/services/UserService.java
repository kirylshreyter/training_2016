package com.kirylshreyter.training.hotel.services;

import com.kirylshreyter.training.hotel.datamodel.User;

public interface UserService {

	Long save(User user);

	Boolean update(User user);
}
