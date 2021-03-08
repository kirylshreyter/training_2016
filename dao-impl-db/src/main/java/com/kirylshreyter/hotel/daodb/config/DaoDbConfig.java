package com.kirylshreyter.hotel.daodb.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.daodb.impl.BookingRequestDaoDbImpl.class,
        com.kirylshreyter.hotel.daodb.impl.CommonDaoDbImpl.class,
        com.kirylshreyter.hotel.daodb.impl.EmployeeDaoDbImpl.class,
        com.kirylshreyter.hotel.daodb.impl.RoomDaoDbImpl.class,
        com.kirylshreyter.hotel.daodb.impl.UserDaoDbImpl.class,
        com.kirylshreyter.hotel.daodb.impl.RoomDetailsDaoDbImpl.class,
        com.kirylshreyter.hotel.daodb.impl.RoomOrderDaoDbImpl.class
})

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.daodb.util.DateConverter.class
})
public class DaoDbConfig {
    @Value("${jdbc.driverClassName}")
    private String jdbcDriverClassName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String jdbcUsername;

    @Value("${jdbc.password}")
    private String jdbcPassword;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(jdbcDriverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(jdbcUsername);
        dataSource.setPassword(jdbcPassword);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager txManager() {
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
