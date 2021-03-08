package com.kirylshreyter.hotel.daodb.constant.logging;

public class User {
    public static final String READ_START = "Read user from users table";
    public static final String READ_BY_EMAIL_START = "Read user by email {} from users table";
    public static final String READ_BY_EMAIL_END = "Finish read user by email {} from users table";
    public static final String READ_END = "Finish read user from users table";
    public static final String INSERT_START_LOG = "Insert user into users table";
    public static final String INSERT_END_LOG = "User has been successfully inserted - ID: {}";
}
