DROP DATABASE [IF EXISTS] hotel;

CREATE DATABASE [IF NOT EXIST] hotel
	DEFAULT CHARACTER SET cp1251
	COLLATE cp1251_general_ci;

CREATE TABLE `client` (
	`id` bigint NOT NULL,
	`first_name` varchar(256) NOT NULL,
	`last_name` varchar(256) NOT NULL,
	`address` varchar(512) NOT NULL,
	`phone` varchar(17) NOT NULL,
	`email` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room_details` (
	`id` bigint NOT NULL,
	`number_of_places` INT(10) NOT NULL,
	`apartments_class` varchar(64) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room` (
	`id` bigint NOT NULL,
	`number` varchar(32) NOT NULL UNIQUE,
	`room_details_id` bigint NOT NULL,
	`status` char(10) NOT NULL,
	`client_id` bigint,
	`administrator_id` bigint,
	`cost_per_day` DECIMAL NOT NULL,
	`from_which_busy` DATE,
	`to_which_busy` DATE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `application` (
	`id` bigint NOT NULL,
	`client_id` bigint NOT NULL,
	`room_details_id` bigint NOT NULL,
	`administrator_id` bigint,
	`arrival_date` DATE NOT NULL,
	`departure_date` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `administrator` (
	`id` bigint NOT NULL,
	`first_name` varchar(256) NOT NULL,
	`last_name` varchar(256) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `invoice` (
	`id` bigint NOT NULL,
	`client_id` bigint NOT NULL,
	`room_details_id` bigint NOT NULL,
	`total_cost` DECIMAL NOT NULL,
	`arrival_date` DATE NOT NULL,
	`departure_date` DATE NOT NULL,
	`administrator_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `room` ADD CONSTRAINT `room_fk0` FOREIGN KEY (`room_details_id`) REFERENCES `room_details`(`id`);

ALTER TABLE `room` ADD CONSTRAINT `room_fk1` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);

ALTER TABLE `room` ADD CONSTRAINT `room_fk2` FOREIGN KEY (`administrator_id`) REFERENCES `administrator`(`id`);

ALTER TABLE `application` ADD CONSTRAINT `application_fk0` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);

ALTER TABLE `application` ADD CONSTRAINT `application_fk1` FOREIGN KEY (`room_details_id`) REFERENCES `room_details`(`id`);

ALTER TABLE `application` ADD CONSTRAINT `application_fk2` FOREIGN KEY (`administrator_id`) REFERENCES `administrator`(`id`);

ALTER TABLE `invoice` ADD CONSTRAINT `invoice_fk0` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);

ALTER TABLE `invoice` ADD CONSTRAINT `invoice_fk1` FOREIGN KEY (`room_details_id`) REFERENCES `room_details`(`id`);

ALTER TABLE `invoice` ADD CONSTRAINT `invoice_fk2` FOREIGN KEY (`administrator_id`) REFERENCES `administrator`(`id`);

