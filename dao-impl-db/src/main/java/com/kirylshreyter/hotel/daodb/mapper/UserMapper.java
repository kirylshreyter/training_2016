package com.kirylshreyter.hotel.daodb.mapper;

import com.kirylshreyter.hotel.daodb.constant.Columns;
import com.kirylshreyter.hotel.datamodel.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User entity = new User();
        entity.setId(rs.getLong(Columns.ID));
        entity.setEmail(rs.getString(Columns.EMAIL));
        entity.setEncryptedPassword(rs.getString(Columns.ENCRYPTED_PASSWORD));
        entity.setName(rs.getString(Columns.NAME));
        return entity;
    }
}
