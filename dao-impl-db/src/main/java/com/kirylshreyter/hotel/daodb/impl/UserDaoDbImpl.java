package com.kirylshreyter.hotel.daodb.impl;

import com.kirylshreyter.hotel.daoapi.IUserDao;
import com.kirylshreyter.hotel.daodb.constant.Columns;
import com.kirylshreyter.hotel.daodb.mapper.UserMapper;
import com.kirylshreyter.hotel.datamodel.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Objects;

@Repository
public class UserDaoDbImpl implements IUserDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoDbImpl.class);

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Override
    public Long create(User entity) {
        LOGGER.info(com.kirylshreyter.hotel.daodb.constant.logging.User.INSERT_START_LOG);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(com.kirylshreyter.hotel.daodb.constant.query.User.INSERT, new String[]{Columns.ID});
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getEncryptedPassword());
            return preparedStatement;
        }, keyHolder);
        entity.setId(Objects.requireNonNull(keyHolder.getKey()).longValue());
        LOGGER.info(com.kirylshreyter.hotel.daodb.constant.logging.User.INSERT_END_LOG, entity.getId());
        return entity.getId();
    }

    @Override
    public User read(Long id) {
        LOGGER.info(com.kirylshreyter.hotel.daodb.constant.logging.User.READ_START);
        User user = jdbcTemplate.queryForObject(com.kirylshreyter.hotel.daodb.constant.query.User.READ, new UserMapper());
        LOGGER.info(com.kirylshreyter.hotel.daodb.constant.logging.User.READ_END);
        return user;
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
        LOGGER.info(com.kirylshreyter.hotel.daodb.constant.logging.User.READ_BY_EMAIL_START, email);
        User user = jdbcTemplate.queryForObject(com.kirylshreyter.hotel.daodb.constant.query.User.READ, new UserMapper());
        LOGGER.info(com.kirylshreyter.hotel.daodb.constant.logging.User.READ_BY_EMAIL_END, email);
        return user;
    }
}
