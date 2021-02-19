package com.kirylshreyter.training.hotel.services.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.kirylshreyter.training.hotel.daoapi.IUserDao;
import com.kirylshreyter.training.hotel.datamodel.User;
import com.kirylshreyter.training.hotel.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Inject
	private IUserDao iUserDao;
	

	@Override
	public Long save(User user) {
		return iUserDao.insert(user);
	}

	@Override
	public Boolean update(User user) {
		return iUserDao.update(user);

	}
}
