/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : hotel

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2016-11-06 18:06:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for booked_room
-- ----------------------------
DROP TABLE IF EXISTS `booked_room`;
CREATE TABLE `booked_room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `booking_request_id` bigint(20) NOT NULL,
  `room_order_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `booked_room_fk0` (`booking_request_id`),
  KEY `booked_room_fk1` (`room_order_id`),
  CONSTRAINT `booked_room_fk0` FOREIGN KEY (`booking_request_id`) REFERENCES `booking_request` (`id`),
  CONSTRAINT `booked_room_fk1` FOREIGN KEY (`room_order_id`) REFERENCES `room_order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booked_room
-- ----------------------------

-- ----------------------------
-- Table structure for booking_request
-- ----------------------------
DROP TABLE IF EXISTS `booking_request`;
CREATE TABLE `booking_request` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` bigint(20) NOT NULL,
  `room_details_id` bigint(20) NOT NULL,
  `arrival_date` date NOT NULL,
  `departure_date` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `booking_request_fk0` (`client_id`),
  KEY `booking_request_fk1` (`room_details_id`),
  CONSTRAINT `booking_request_fk0` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`),
  CONSTRAINT `booking_request_fk1` FOREIGN KEY (`room_details_id`) REFERENCES `room_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booking_request
-- ----------------------------
INSERT INTO `booking_request` VALUES ('1', '43', '1', '2016-12-20', '2016-12-30');
INSERT INTO `booking_request` VALUES ('8', '44', '1', '2015-12-25', '2015-12-30');
INSERT INTO `booking_request` VALUES ('9', '54', '1', '2015-05-20', '2015-05-25');
INSERT INTO `booking_request` VALUES ('10', '55', '1', '2015-05-20', '2015-05-25');
INSERT INTO `booking_request` VALUES ('11', '56', '1', '2015-05-20', '2015-05-25');
INSERT INTO `booking_request` VALUES ('12', '57', '1', '2015-12-21', '2015-12-28');
INSERT INTO `booking_request` VALUES ('13', '58', '1', '2015-12-28', '2015-12-21');
INSERT INTO `booking_request` VALUES ('14', '59', '1', '2015-12-28', '2015-12-21');
INSERT INTO `booking_request` VALUES ('15', '60', '1', '2015-12-28', '2015-12-21');
INSERT INTO `booking_request` VALUES ('16', '61', '1', '2015-12-21', '2015-12-28');
INSERT INTO `booking_request` VALUES ('17', '62', '1', '2015-12-21', '2015-12-28');
INSERT INTO `booking_request` VALUES ('18', '63', '1', '2015-12-21', '2015-12-28');
INSERT INTO `booking_request` VALUES ('19', '64', '1', '2015-12-21', '2015-12-28');
INSERT INTO `booking_request` VALUES ('20', '65', '1', '2015-12-21', '2015-12-28');
INSERT INTO `booking_request` VALUES ('21', '66', '1', '2015-12-21', '2015-12-28');
INSERT INTO `booking_request` VALUES ('22', '67', '1', '2015-12-21', '2015-12-28');

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(256) NOT NULL,
  `last_name` varchar(256) NOT NULL,
  `address` varchar(512) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `email` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=68 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('43', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('44', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('45', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('46', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('47', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('48', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('49', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('50', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('51', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('52', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('53', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('54', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('55', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('56', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('57', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('58', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('59', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('60', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('61', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('62', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('63', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('64', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('65', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('66', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');
INSERT INTO `client` VALUES ('67', 'Иван', 'Иванов', 'Республика Беларусь, г. Минск, ул. В. Хоружей, д.1, кв. 1', '+375297800000', 'ivanov@gmail.com');

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(256) NOT NULL,
  `last_name` varchar(256) NOT NULL,
  `phone` varchar(16) NOT NULL,
  `email` varchar(128) NOT NULL,
  `position` varchar(16) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'Петр', 'Петров', '+375297897897', 'a@a.com', 'manager');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number` varchar(8) NOT NULL,
  `room_details_id` bigint(20) NOT NULL,
  `status` varchar(16) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`),
  KEY `room_fk0` (`room_details_id`),
  CONSTRAINT `room_fk0` FOREIGN KEY (`room_details_id`) REFERENCES `room_details` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '5A', '1', 'available');
INSERT INTO `room` VALUES ('2', '5B', '2', 'available');
INSERT INTO `room` VALUES ('3', '4A', '3', 'available');
INSERT INTO `room` VALUES ('4', '4B', '4', 'available');
INSERT INTO `room` VALUES ('5', '3A', '5', 'not available');
INSERT INTO `room` VALUES ('6', '3B', '6', 'available');
INSERT INTO `room` VALUES ('7', '2A', '7', 'available');
INSERT INTO `room` VALUES ('8', '2B', '8', 'not available');

-- ----------------------------
-- Table structure for room_details
-- ----------------------------
DROP TABLE IF EXISTS `room_details`;
CREATE TABLE `room_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `number_of_places` int(8) NOT NULL,
  `cost_per_night` decimal(10,0) NOT NULL,
  `room_type` varchar(24) NOT NULL,
  `floor` varchar(4) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_details
-- ----------------------------
INSERT INTO `room_details` VALUES ('1', '1', '50', 'lux', '5');
INSERT INTO `room_details` VALUES ('2', '2', '75', 'lux', '5');
INSERT INTO `room_details` VALUES ('3', '1', '45', 'half-lux', '4');
INSERT INTO `room_details` VALUES ('4', '2', '55', 'half-lux', '4');
INSERT INTO `room_details` VALUES ('5', '1', '35', 'economy', '3');
INSERT INTO `room_details` VALUES ('6', '2', '45', 'economy', '3');
INSERT INTO `room_details` VALUES ('7', '1', '25', 'economy', '2');
INSERT INTO `room_details` VALUES ('8', '2', '35', 'economy', '2');

-- ----------------------------
-- Table structure for room_order
-- ----------------------------
DROP TABLE IF EXISTS `room_order`;
CREATE TABLE `room_order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `room_id` bigint(20) NOT NULL,
  `booking_request_id` bigint(20) NOT NULL,
  `employee_id` bigint(20) NOT NULL,
  `total_cost` decimal(10,0) NOT NULL,
  `booked_start_day` date NOT NULL,
  `booked_end_day` date NOT NULL,
  PRIMARY KEY (`id`),
  KEY `room_order_fk0` (`room_id`),
  KEY `room_order_fk1` (`booking_request_id`),
  KEY `room_order_fk2` (`employee_id`),
  CONSTRAINT `room_order_fk0` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`),
  CONSTRAINT `room_order_fk1` FOREIGN KEY (`booking_request_id`) REFERENCES `booking_request` (`id`),
  CONSTRAINT `room_order_fk2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room_order
-- ----------------------------
INSERT INTO `room_order` VALUES ('1', '1', '1', '1', '50', '2015-12-20', '2015-12-30');
