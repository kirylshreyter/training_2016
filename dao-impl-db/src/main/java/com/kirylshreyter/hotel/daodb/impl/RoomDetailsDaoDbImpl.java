package com.kirylshreyter.hotel.daodb.impl;

import com.kirylshreyter.hotel.daoapi.IRoomDetailsDao;
import com.kirylshreyter.hotel.daodb.util.NotNullChecker;
import com.kirylshreyter.hotel.datamodel.RoomDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RoomDetailsDaoDbImpl implements IRoomDetailsDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomDetailsDaoDbImpl.class);

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private NotNullChecker notNullChecker;

    @Override
    public Long create(RoomDetails entity) {
        LOGGER.info("Trying to create room details in table room_details...");
        if (notNullChecker.RoomDetailsNotNullChecker(entity)) {
            final String INSERT_SQL = "INSERT INTO room_details (number_of_places,cost_per_night,room_type,additional_information) VALUES (?,?,?,?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[]{"id"});
                    ps.setLong(1, entity.getNumberOfPlaces());
                    ps.setDouble(2, entity.getCostPerNight());
                    ps.setString(3, entity.getRoomType());
                    ps.setString(4, entity.getAdditionalInformation());
                    return ps;
                }
            }, keyHolder);
            ;
            entity.setId(keyHolder.getKey().longValue());
            Long insertedId = entity.getId();
            LOGGER.info("Room details was created, id = {}", insertedId);
            return insertedId;
        } else {
            return null;
        }
    }

    @Override
    public RoomDetails read(Long id) {
        return null;
    }

    @Override
    public Boolean update(RoomDetails entity) {
        LOGGER.info("Trying to update room details with id = {} in table room_details...", entity.getId());
        if (notNullChecker.RoomDetailsNotNullChecker(entity)) {
            jdbcTemplate.update(
                    "UPDATE room_details SET number_of_places = ?, cost_per_night = ?, room_type = ?, additional_information = ?  where id = ?",
                    entity.getNumberOfPlaces(), entity.getCostPerNight(), entity.getRoomType(),
                    entity.getAdditionalInformation(), entity.getId());
            LOGGER.info("Room details was updated, id = {}", entity.getId());
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer delete(Long id) {
        return null;
    }

    @Override
    public List<RoomDetails> getAll() {
        return null;
    }
}
