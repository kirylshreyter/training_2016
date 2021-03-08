package com.kirylshreyter.hotel.services;

import com.kirylshreyter.hotel.datamodel.User;

public interface UserService extends AbstractService<User> {
    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    User findByToken(String token);
}
