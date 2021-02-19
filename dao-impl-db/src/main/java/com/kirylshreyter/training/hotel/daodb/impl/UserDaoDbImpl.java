package com.kirylshreyter.training.hotel.daodb.impl;

import com.kirylshreyter.training.hotel.daoapi.IUserDao;
import com.kirylshreyter.training.hotel.datamodel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.util.Objects;

@Repository
public class UserDaoDbImpl implements IUserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoDbImpl.class);

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long insert(User entity) {
        LOGGER.info("Inserting user into users table");
        final String INSERT_SQL = "INSERT INTO users (name, email, encrypted_password) VALUES (?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL, new String[]{"id"});
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getEncryptedPassword());
            return preparedStatement;
        }, keyHolder);
        entity.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        LOGGER.info("User has been successfully inserted - ID: {}", entity.getId());
        return entity.getId();
    }

    @Override
    public Boolean update(User entity) {
        LOGGER.info("Updating user in table users - ID: {}", entity.getId());
        jdbcTemplate.update(
                "UPDATE users SET name = ?, email = ?, encrypted_password = ? where id = ?",
                entity.getName(), entity.getEmail(), entity.getEncryptedPassword(), entity.getId());
        LOGGER.info("User has been successfully updated - ID: {}", entity.getId());
        return true;
    }
}
