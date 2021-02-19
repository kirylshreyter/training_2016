package com.kirylshreyter.training.hotel.daodb.mapper;

import com.kirylshreyter.training.hotel.datamodel.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User entity = new User();
        entity.setId(rs.getLong("id"));
        entity.setName(rs.getString("name"));
        entity.setEmail(rs.getString("email"));
        return entity;
    }
}
