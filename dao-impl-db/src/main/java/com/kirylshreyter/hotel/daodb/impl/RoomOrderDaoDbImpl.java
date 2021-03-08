package com.kirylshreyter.hotel.daodb.impl;

import com.kirylshreyter.hotel.commons.RoomOrderWithAdditionalInfo;
import com.kirylshreyter.hotel.daoapi.IRoomOrderDao;
import com.kirylshreyter.hotel.daodb.mapper.RoomOrderWithAdditionalInfoMapper;
import com.kirylshreyter.hotel.daodb.util.NotNullChecker;
import com.kirylshreyter.hotel.datamodel.RoomOrder;
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
public class RoomOrderDaoDbImpl implements IRoomOrderDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomOrderDaoDbImpl.class);

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private NotNullChecker notNullChecker;

    @Override
    public Long create(RoomOrder entity) {
        LOGGER.info("Trying to create roo order in table room_order ...");
        if (notNullChecker.RoomOrderNotNullChecker(entity)) {
            final String INSERT_SQL = "INSERT INTO room_order (booking_request_id,employee_id,total_cost) VALUES (?,?,?)";
            KeyHolder keyHolder = new GeneratedKeyHolder();
            jdbcTemplate.update(new PreparedStatementCreator() {
                @Override
                public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                    PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[]{"id"});
                    ps.setLong(1, entity.getBookingRequestId());
                    ps.setLong(2, entity.getEmployeeId());
                    ps.setDouble(3, entity.getTotalCost());
                    return ps;
                }
            }, keyHolder);
            ;
            entity.setId(keyHolder.getKey().longValue());
            Long insertedId = entity.getId();
            LOGGER.info("Room order was created, id = {}", insertedId);
            return insertedId;
        } else {
            return null;
        }
    }

    @Override
    public RoomOrder read(Long id) {
        return null;
    }

    @Override
    public Boolean update(RoomOrder entity) {
        LOGGER.info("Trying to update room order with id = {} in table room_order.", entity.getId());
        if (notNullChecker.RoomOrderNotNullChecker(entity)) {
            jdbcTemplate.update(
                    "UPDATE room_order SET booking_request_id = ?, employee_id = ?, total_cost = ? where id = ?",
                    entity.getBookingRequestId(), entity.getEmployeeId(), entity.getTotalCost(), entity.getId());
            LOGGER.info("Room order was updated, id = {}", entity.getId());
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
    public List<RoomOrder> getAll() {
        return null;
    }

    @Override
    public RoomOrderWithAdditionalInfo getWithAdditionalInfo(Long id) {
        RoomOrderWithAdditionalInfo roomOrderWithAdditionalInfo = new RoomOrderWithAdditionalInfo();
        roomOrderWithAdditionalInfo = jdbcTemplate.queryForObject(
                "SELECT ro.id,br.arrival_date,br.departure_date,r.number,r.status,rd.room_type,rd.number_of_places,rd.cost_per_night,rd.additional_information, u.name as user_name,u.email as user_email,e.first_name as employee_first_name,e.last_name as employee_last_name,e.phone as employee_phone,e.email as employee_email,e.position as employee_position FROM room_order ro JOIN booking_request br ON (ro.booking_request_id=br.id) JOIN employee e ON (ro.employee_id=e.id) JOIN users u ON (br.user_id=u.id) JOIN room r ON (br.room_id=r.id) JOIN room_details rd ON (r.room_details_id=rd.id) WHERE ro.id=?",
                new Object[]{id}, new RoomOrderWithAdditionalInfoMapper());
        return roomOrderWithAdditionalInfo;
    }
}
