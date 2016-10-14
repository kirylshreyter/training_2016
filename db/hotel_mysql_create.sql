CREATE TABLE `client_details` (
	`id` INT NOT NULL,
	`first_name` VARCHAR(128) NOT NULL,
	`last_name` VARCHAR(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `request` (
	`id` INT NOT NULL,
	`client` INT NOT NULL,
	`room` INT NOT NULL,
	`time_of_stay` TIME NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `administrator` (
	`id` INT NOT NULL,
	`first_name` VARCHAR(128) NOT NULL,
	`last_name` VARCHAR(128) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room_details` (
	`id` INT NOT NULL,
	`number_of_seats` INT(30) NOT NULL,
	`apartments_class` VARCHAR(32) NOT NULL,
	`cost_per_day` DECIMAL NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `bill` (
	`id` INT NOT NULL,
	`client` INT NOT NULL,
	`room` INT NOT NULL,
	`administrator` INT NOT NULL,
	`time_for_stay` TIME NOT NULL,
	`total_cost` DECIMAL NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `room` (
	`id` INT NOT NULL,
	`room` INT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `client` (
	`id` INT NOT NULL,
	`client` INT NOT NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `request` ADD CONSTRAINT `request_fk0` FOREIGN KEY (`client`) REFERENCES `client`(`id`);

ALTER TABLE `request` ADD CONSTRAINT `request_fk1` FOREIGN KEY (`room`) REFERENCES `room`(`id`);

ALTER TABLE `bill` ADD CONSTRAINT `bill_fk0` FOREIGN KEY (`client`) REFERENCES `client`(`id`);

ALTER TABLE `bill` ADD CONSTRAINT `bill_fk1` FOREIGN KEY (`room`) REFERENCES `room`(`id`);

ALTER TABLE `bill` ADD CONSTRAINT `bill_fk2` FOREIGN KEY (`administrator`) REFERENCES `administrator`(`id`);

ALTER TABLE `bill` ADD CONSTRAINT `bill_fk3` FOREIGN KEY (`time_for_stay`) REFERENCES `request`(`time_of_stay`);

ALTER TABLE `room` ADD CONSTRAINT `room_fk0` FOREIGN KEY (`room`) REFERENCES `room_details`(`id`);

ALTER TABLE `client` ADD CONSTRAINT `client_fk0` FOREIGN KEY (`client`) REFERENCES `client_details`(`id`);

