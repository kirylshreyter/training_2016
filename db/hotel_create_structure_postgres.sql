CREATE TABLE "users" (
	"id" serial NOT NULL,
	"email" varchar(255) NOT NULL,
	"encrypted_password" varchar(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	"enabled" BOOLEAN NOT NULL DEFAULT 'FALSE',
	CONSTRAINT "users_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "room_order" (
	"id" serial NOT NULL,
	"total_cost" DECIMAL NOT NULL,
	"booking_request_id" integer NOT NULL,
	"employee_id" integer NOT NULL,
	CONSTRAINT "room_order_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "bookin_request" (
	"id" serial NOT NULL,
	"room_id" integer NOT NULL,
	"user_id" integer NOT NULL,
	"arrival_date" TIMESTAMP NOT NULL,
	"departure_date" TIMESTAMP NOT NULL,
	CONSTRAINT "bookin_request_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "room" (
	"id" serial NOT NULL,
	"number" varchar(8) NOT NULL,
	"room_details_id" integer NOT NULL,
	"status" varchar(16) NOT NULL,
	CONSTRAINT "room_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "room_details" (
	"id" serial NOT NULL,
	"room_type" varchar(32) NOT NULL,
	"number_of_places" integer NOT NULL,
	"cost_per_night" DECIMAL NOT NULL,
	"additional_information" varchar(512) NOT NULL,
	CONSTRAINT "room_details_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "employee" (
	"id" serial NOT NULL,
	"first_name" varchar(255) NOT NULL,
	"last_name" varchar(255) NOT NULL,
	"phone" varchar(16) NOT NULL,
	"email" varchar(128) NOT NULL,
	"position" varchar(16) NOT NULL,
	CONSTRAINT "employee_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "room_order" ADD CONSTRAINT "room_order_fk0" FOREIGN KEY ("booking_request_id") REFERENCES "bookin_request"("id");
ALTER TABLE "room_order" ADD CONSTRAINT "room_order_fk1" FOREIGN KEY ("employee_id") REFERENCES "employee"("id");

ALTER TABLE "bookin_request" ADD CONSTRAINT "bookin_request_fk0" FOREIGN KEY ("room_id") REFERENCES "room"("id");
ALTER TABLE "bookin_request" ADD CONSTRAINT "bookin_request_fk1" FOREIGN KEY ("user_id") REFERENCES "users"("id");

ALTER TABLE "room" ADD CONSTRAINT "room_fk0" FOREIGN KEY ("room_details_id") REFERENCES "room_details"("id");



