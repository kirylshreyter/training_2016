package com.kirylshreyter.training.hotel.daodb.util;

import org.springframework.stereotype.Repository;

import com.kirylshreyter.training.hotel.datamodel.BookingRequest;
import com.kirylshreyter.training.hotel.datamodel.Employee;
import com.kirylshreyter.training.hotel.datamodel.Room;
import com.kirylshreyter.training.hotel.datamodel.RoomDetails;
import com.kirylshreyter.training.hotel.datamodel.RoomOrder;

@Repository
public class NotNullChecker {
	public Boolean BookingRequestNotNullChecker(BookingRequest entity) {
		if (entity.getUserId() == null) {
			throw new RuntimeException("User Id is not setted.");
		}
		if (entity.getRoomId() == null) {
			throw new RuntimeException("Room Id is not setted.");
		}
		if (entity.getArrivalDate() == null) {
			throw new RuntimeException("Arrival date is not setted.");
		}
		if (entity.getDepartureDate() == null) {
			throw new RuntimeException("Departure date is not setted.");
		}
		return true;
	}

	public Boolean EmployeeNotNullChecker(Employee entity) {
		if (entity.getFirstName() == null) {
			throw new RuntimeException("Employee's first name is not setted.");
		}
		if (entity.getLastName() == null) {
			throw new RuntimeException("Employee's last name is not setted.");
		}
		if (entity.getPhone() == null) {
			throw new RuntimeException("Employee's phone number is not setted.");
		}
		if (entity.getEmail() == null) {
			throw new RuntimeException("Employee's email is not setted.");
		}
		if (entity.getPosition() == null) {
			throw new RuntimeException("Employee's position is not setted.");
		}
		return true;
	}

	public Boolean RoomNotNullChecker(Room entity) {
		if (entity.getNumber() == null) {
			throw new RuntimeException("Room's number is not setted.");
		}
		if (entity.getRoomDetailsId() == null) {
			throw new RuntimeException("Room details is not setted.");
		}
		if (entity.getStatus() == null) {
			throw new RuntimeException("Status is not setted.");
		}
		return true;
	}

	public Boolean RoomDetailsNotNullChecker(RoomDetails entity) {
		if (entity.getNumberOfPlaces() == null) {
			throw new RuntimeException();
		}
		if (entity.getCostPerNight() == null) {
			throw new RuntimeException();
		}
		if (entity.getRoomType() == null) {
			throw new RuntimeException();
		}
		return true;
	}

	public Boolean RoomOrderNotNullChecker(RoomOrder entity) {
		if (entity.getBookingRequestId() == null) {
			throw new RuntimeException("Booking request is not setted.");
		}
		if (entity.getEmployeeId() == null) {
			throw new RuntimeException("Employee is not setted.");
		}
		if (entity.getTotalCost() == null) {
			throw new RuntimeException("Total cost is not setted.");
		}
		return true;
	}

}
