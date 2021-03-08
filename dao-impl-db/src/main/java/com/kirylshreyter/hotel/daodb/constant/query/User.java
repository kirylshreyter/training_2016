package com.kirylshreyter.hotel.daodb.constant.query;

public class User {
    public static final String INSERT = "INSERT INTO users (name, email, encrypted_password) VALUES (?,?,?)";
    public static final String READ = "SELECT * FROM users";
}
