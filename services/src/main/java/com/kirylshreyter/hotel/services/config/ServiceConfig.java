package com.kirylshreyter.hotel.services.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.daodb.config.DaoDbConfig.class
})
@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.services.impl.UserServiceImpl.class,
        com.kirylshreyter.hotel.services.impl.AuthenticationServiceImpl.class,
        com.kirylshreyter.hotel.services.impl.CommonServiceImpl.class,
        com.kirylshreyter.hotel.services.impl.RoomServiceImpl.class,
        com.kirylshreyter.hotel.services.impl.EmployeeServiceImpl.class,
        com.kirylshreyter.hotel.services.impl.BookingRequestServiceImpl.class,
        com.kirylshreyter.hotel.services.impl.RoomDetailsServiceImpl.class,
        com.kirylshreyter.hotel.services.impl.RoomOrderServiceImpl.class
})

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.services.security.impl.TokeServiceImpl.class
})

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.services.config.ServiceConfig.class
})

public class ServiceConfig {
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ApplicationProperties applicationProperties() {
        return new ApplicationProperties();
    }
}
