package com.kirylshreyter.hotel.daoxml.impl;

import com.kirylshreyter.hotel.daoapi.IUserDao;
import com.kirylshreyter.hotel.datamodel.User;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

@Repository
public class UserDaoXmlImpl implements IUserDao {

    @Inject
    private Common common;

    @Override
    public Long create(User entity) {
        List<User> allUsers = readCollection(entity);
        Long id = getNextId(allUsers);

        allUsers.add(entity);

        entity.setId(id);

        writeCollection(allUsers);
        return id;
    }

    @Override
    public User read(Long id) {
        return null;
    }

    @Override
    public Boolean update(User entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer delete(Long id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User findByEmail(String email) {
        return null;
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
        return allUsers.isEmpty() ? 1L : allUsers.get(allUsers.size() - 1).getId() + 1;
    }
}
