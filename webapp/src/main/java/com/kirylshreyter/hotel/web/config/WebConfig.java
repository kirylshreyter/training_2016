package com.kirylshreyter.hotel.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.services.config.ServiceConfig.class
})

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.web.controller.AvailableRoomController.class,
        com.kirylshreyter.hotel.web.controller.RoomController.class,
        com.kirylshreyter.hotel.web.controller.EmployeeController.class,
        com.kirylshreyter.hotel.web.controller.UserController.class,
        com.kirylshreyter.hotel.web.controller.RoomDetailsController.class,
        com.kirylshreyter.hotel.web.controller.BookingRequestController.class,
        com.kirylshreyter.hotel.web.controller.RoomOrderController.class
})

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.web.converter.ObjectToObjectConverter.class
})

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.web.util.ObjectIdentifier.class
})

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.web.config.ConversionServiceConfig.class
})

public class WebConfig implements WebMvcConfigurer {
}
