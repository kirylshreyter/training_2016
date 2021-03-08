package com.kirylshreyter.hotel.services.impl;

import com.kirylshreyter.hotel.daoapi.IUserDao;
import com.kirylshreyter.hotel.datamodel.User;
import com.kirylshreyter.hotel.services.UserService;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private IUserDao iUserDao;

    @Override
    public Boolean update(User user) {
        return iUserDao.update(user);
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
        return iUserDao.findByEmail(email);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return null;
    }

    @Override
    public User findByToken(String token) {
        return null;
    }

    @Override
    public Long create(User entity) {
        return iUserDao.create(entity);
    }

    @Override
    public User read(Long id) {
        return null;
    }
}
