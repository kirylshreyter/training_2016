package com.kirylshreyter.hotel.daodb.impl;

import com.kirylshreyter.hotel.commons.BookingRequestWithAdditionalInfo;
import com.kirylshreyter.hotel.daoapi.IBookingRequestDao;
import com.kirylshreyter.hotel.daodb.mapper.BookingRequestWithAdditionalInfoMapper;
import com.kirylshreyter.hotel.daodb.util.DateConverter;
import com.kirylshreyter.hotel.daodb.util.NotNullChecker;
import com.kirylshreyter.hotel.datamodel.BookingRequest;
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
import java.time.DateTimeException;
import java.util.List;

@Repository
public class BookingRequestDaoDbImpl implements IBookingRequestDao {
    private static final Logger LOGGER = LoggerFactory.getLogger(BookingRequestDaoDbImpl.class);

    @Inject
    private JdbcTemplate jdbcTemplate;

    @Inject
    private DateConverter dateConverter;

    @Inject
    private NotNullChecker notNullChecker;

    @Override
    public Long create(BookingRequest entity) {
        LOGGER.info("Trying to create booking request in table booking_request ...");
        if (notNullChecker.BookingRequestNotNullChecker(entity)) {
            if (entity.getArrivalDate().getTime() > entity.getDepartureDate().getTime()) {
                throw new DateTimeException("Arrival date cannot be more than departure date.");
            } else {
                final String INSERT_SQL = "INSERT INTO booking_request (room_id,user_id,arrival_date,departure_date) VALUES (?,?,?,?)";

                KeyHolder keyHolder = new GeneratedKeyHolder();

                jdbcTemplate.update(new PreparedStatementCreator() {
                    @Override
                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                        PreparedStatement ps = con.prepareStatement(INSERT_SQL, new String[]{"id"});
                        ps.setLong(1, entity.getRoomId());
                        ps.setLong(2, entity.getUserId());
                        ps.setDate(3, dateConverter.javaUtilDateToJavaSqlDateConverter(entity.getArrivalDate()));
                        ps.setDate(4, dateConverter.javaUtilDateToJavaSqlDateConverter(entity.getDepartureDate()));
                        return ps;
                    }
                }, keyHolder);
                ;
                entity.setId(keyHolder.getKey().longValue());
                Long insertedId = entity.getId();
                LOGGER.info("Booking Request was created, id = {}", insertedId);
                return insertedId;
            }
        } else {
            return null;
        }
    }

    @Override
    public BookingRequest read(Long id) {
        return null;
    }

    @Override
    public Boolean update(BookingRequest entity) {
        LOGGER.info("Trying to update booking request with id = {} in table booking_request.", entity.getId());
        if (notNullChecker.BookingRequestNotNullChecker(entity)) {
            jdbcTemplate.update(
                    "UPDATE booking_request SET room_id = ?, user_id = ?, arrival_date = ?, departure_date = ?  where id = ?",
                    entity.getRoomId(), entity.getUserId(), entity.getArrivalDate(), entity.getDepartureDate(),
                    entity.getId());
            LOGGER.info("Booking Request was updated, id = {}", entity.getId());
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
    public List<BookingRequest> getAll() {
        return null;
    }

    @Override
    public BookingRequestWithAdditionalInfo getWithAdditionalInfo(Long id) {
        BookingRequestWithAdditionalInfo bookingRequestWithAdditionalInfo = new BookingRequestWithAdditionalInfo();
        bookingRequestWithAdditionalInfo = jdbcTemplate.queryForObject(
                "SELECT br.id,br.arrival_date,br.departure_date,r.number,r.status,rd.room_type,rd.number_of_places,rd.cost_per_night,rd.additional_information,c.first_name,c.last_name,c.phone,c.email FROM booking_request br JOIN room r ON (br.room_id=r.id) JOIN users c ON (br.user_id=c.id) JOIN room_details rd ON (r.room_details_id=rd.id) WHERE br.id=?",
                new Object[]{id}, new BookingRequestWithAdditionalInfoMapper());
        return bookingRequestWithAdditionalInfo;
    }

}
