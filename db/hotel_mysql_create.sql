CREATE TABLE `client` (
	`id` bigint NOT NULL,
	`first_name` varchar(256) NOT NULL,
	`last_name` varchar(256) NOT NULL,
	`address` varchar(512) NOT NULL,
	`phone` varchar(16) NOT NULL,
	`email` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `application` (
	`id` bigint NOT NULL,
	`client_id` bigint NOT NULL,
	`room_details_id` bigint NOT NULL,
	`arrival_date` DATE NOT NULL,
	`departure_date` DATE NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `employee` (
	`id` bigint NOT NULL,
	`first_name` varchar(256) NOT NULL,
	`last_name` varchar(256) NOT NULL,
	`phone` varchar(16) NOT NULL,
	`email` varchar(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room_order` (
	`id` bigint NOT NULL,
	`room_id` bigint NOT NULL,
	`application_id` bigint NOT NULL,
	`employee_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room` (
	`id` bigint NOT NULL,
	`number` varchar(8) NOT NULL UNIQUE,
	`room_details_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `applying_room` (
	`id` bigint NOT NULL,
	`application_id` bigint NOT NULL,
	`room_id` bigint NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room_details` (
	`id` bigint NOT NULL,
	`number_of_places` INT(8) NOT NULL,
	`apartments_class` varchar(24) NOT NULL,
	`cost_per_day` DECIMAL NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `application` ADD CONSTRAINT `application_fk0` FOREIGN KEY (`client_id`) REFERENCES `client`(`id`);

ALTER TABLE `application` ADD CONSTRAINT `application_fk1` FOREIGN KEY (`room_details_id`) REFERENCES `room_details`(`id`);

ALTER TABLE `room_order` ADD CONSTRAINT `room_order_fk0` FOREIGN KEY (`room_id`) REFERENCES `room`(`id`);

ALTER TABLE `room_order` ADD CONSTRAINT `room_order_fk1` FOREIGN KEY (`application_id`) REFERENCES `application`(`id`);

ALTER TABLE `room_order` ADD CONSTRAINT `room_order_fk2` FOREIGN KEY (`employee_id`) REFERENCES `employee`(`id`);

ALTER TABLE `room` ADD CONSTRAINT `room_fk0` FOREIGN KEY (`room_details_id`) REFERENCES `room_details`(`id`);

ALTER TABLE `applying_room` ADD CONSTRAINT `applying_room_fk0` FOREIGN KEY (`application_id`) REFERENCES `application`(`id`);

ALTER TABLE `applying_room` ADD CONSTRAINT `applying_room_fk1` FOREIGN KEY (`room_id`) REFERENCES `room`(`id`);

