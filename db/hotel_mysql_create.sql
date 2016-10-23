CREATE TABLE `client` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`first_name` varchar(256) NOT NULL,
	`last_name` varchar(256) NOT NULL,
	`address` varchar(512) NOT NULL,
	`phone` varchar(16) NOT NULL,
	`email` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `booking_request` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`client_id` bigint NOT NULL,
	`room_details_id` bigint NOT NULL,
	`arrival_date` DATE NOT NULL,
	`departure_date` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `employee` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`first_name` varchar(256) NOT NULL,
	`last_name` varchar(256) NOT NULL,
	`phone` varchar(16) NOT NULL,
	`email` varchar(128) NOT NULL,
	`position` varchar(16) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room_order` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`room_id` bigint NOT NULL,
	`booking_request_id` bigint NOT NULL,
	`employee_id` bigint NOT NULL,
	`total_cost` DECIMAL NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`number` varchar(8) NOT NULL UNIQUE,
	`room_details_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `booked_room` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`booking_request_id` bigint NOT NULL,
	`room_order_id` bigint NOT NULL,
	`booked_start_day` DATE NOT NULL,
	`booked_end_day` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room_details` (
	`id` bigint NOT NULL AUTO_INCREMENT,
	`number_of_places` INT(8) NOT NULL,
	`cost_per_night` DECIMAL NOT NULL,
	`room_type` varchar(24) NOT NULL,
	`floor` varchar(4) NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `booking_request` ADD CONSTRAINT `booking_request_fk0` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);

ALTER TABLE `booking_request` ADD CONSTRAINT `booking_request_fk1` FOREIGN KEY (`room_details_id`) REFERENCES `room_details`(`id`);

ALTER TABLE `room_order` ADD CONSTRAINT `room_order_fk0` FOREIGN KEY (`room_id`) REFERENCES `room`(`id`);

ALTER TABLE `room_order` ADD CONSTRAINT `room_order_fk1` FOREIGN KEY (`booking_request_id`) REFERENCES `booking_request`(`id`);

ALTER TABLE `room_order` ADD CONSTRAINT `room_order_fk2` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);

ALTER TABLE `room` ADD CONSTRAINT `room_fk0` FOREIGN KEY (`room_details_id`) REFERENCES `room_details`(`id`);

ALTER TABLE `booked_room` ADD CONSTRAINT `booked_room_fk0` FOREIGN KEY (`booking_request_id`) REFERENCES `booking_request`(`id`);

ALTER TABLE `booked_room` ADD CONSTRAINT `booked_room_fk1` FOREIGN KEY (`room_order_id`) REFERENCES `room_order`(`id`);

