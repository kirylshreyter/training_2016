package com.kirylshreyter.training.hotel.datamodel;

public class RoomOrder extends AbstractModel {

	private Integer roomId;
	private Integer bookingRequestId;
	private Integer employeeId;
	private Double totalCost;

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public Integer getBookingRequestId() {
		return bookingRequestId;
	}

	public void setBookingRequestId(Integer bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

}
