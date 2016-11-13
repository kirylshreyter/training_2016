CREATE TABLE client (
	id BIGINT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(256) NOT NULL,
	last_name VARCHAR(256) NOT NULL,
	phone VARCHAR(16) NOT NULL,
	email VARCHAR(128) NOT NULL,
	address VARCHAR(512) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE booking_request (
	id BIGINT NOT NULL AUTO_INCREMENT,
	room_id BIGINT NOT NULL,
	client_id BIGINT NOT NULL,
	arrival_date DATE NOT NULL,
	departure_date DATE NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE employee (
	id BIGINT NOT NULL AUTO_INCREMENT,
	first_name VARCHAR(256) NOT NULL,
	last_name VARCHAR(256) NOT NULL,
	phone VARCHAR(16) NOT NULL,
	email VARCHAR(128) NOT NULL,
	address VARCHAR(512) NOT NULL,
	position VARCHAR(16) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE room_order (
	id BIGINT NOT NULL AUTO_INCREMENT,
	booking_request_id BIGINT NOT NULL,
	employee_id BIGINT NOT NULL,
	total_cost DECIMAL NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE room (
	id BIGINT NOT NULL AUTO_INCREMENT,
	number VARCHAR(8) NOT NULL UNIQUE,
	room_details_id BIGINT NOT NULL,
	status VARCHAR(16) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE room_details (
	id BIGINT NOT NULL AUTO_INCREMENT,
	room_type VARCHAR(24) NOT NULL,
	number_of_places INT(8) NOT NULL,
	cost_per_night DECIMAL NOT NULL,
	additional_information VARCHAR(512) NOT NULL,
	PRIMARY KEY (id)
);

ALTER TABLE booking_request ADD CONSTRAINT booking_request_fk0 FOREIGN KEY (room_id) REFERENCES room(id);

ALTER TABLE booking_request ADD CONSTRAINT booking_request_fk1 FOREIGN KEY (client_id) REFERENCES client(id);

ALTER TABLE room_order ADD CONSTRAINT room_order_fk0 FOREIGN KEY (booking_request_id) REFERENCES booking_request(id);

ALTER TABLE room_order ADD CONSTRAINT room_order_fk1 FOREIGN KEY (employee_id) REFERENCES employee(id);

ALTER TABLE room ADD CONSTRAINT room_fk0 FOREIGN KEY (room_details_id) REFERENCES room_details(id);

