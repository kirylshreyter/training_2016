package com.kirylshreyter.training.hotel.datamodel;

public class RoomOrder extends AbstractModel {

	private Long bookingRequestId;
	private Long employeeId;
	private Double totalCost;

	public Long getBookingRequestId() {
		return bookingRequestId;
	}

	public void setBookingRequestId(Long bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

}