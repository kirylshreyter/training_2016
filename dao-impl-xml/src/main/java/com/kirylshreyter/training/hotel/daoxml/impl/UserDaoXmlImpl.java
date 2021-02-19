package com.kirylshreyter.training.hotel.daoxml.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.daoapi.IUserDao;
import com.kirylshreyter.training.hotel.datamodel.User;

@Repository
public class UserDaoXmlImpl implements IUserDao {

	@Inject
	private Common common;

	@Override
	public Long insert(User entity) {
		List<User> allUsers = readCollection(entity);
		Long id = getNextId(allUsers);

		allUsers.add(entity);

		entity.setId(new Long(id));

		writeCollection(allUsers);
		return id;
	}

	private List<User> readCollection(User entity) {
		try {
			common.intialize(entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (List<User>) Common.xstream.fromXML(Common.file);
	}

	private void writeCollection(List<User> newList) {
		try {
			Common.xstream.toXML(newList, new FileOutputStream(Common.file));
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);// TODO custom exception
		}
	}

	private long getNextId(List<User> allUsers) {
		return allUsers.isEmpty() ? 1l : allUsers.get(allUsers.size() - 1).getId() + 1;
	}

	@Override
	public Boolean update(User entity) {
		// TODO Auto-generated method stub
		return null;
	}
}
