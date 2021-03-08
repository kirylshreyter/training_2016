package com.kirylshreyter.hotel.daoapi;

import com.kirylshreyter.hotel.datamodel.User;

public interface IUserDao extends IAbstractDao<User> {
    User findByEmail(String email);
}
