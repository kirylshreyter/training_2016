package com.kirylshreyter.training.hotel.web.model;

public class RoomOrderModel extends ParentModel {

	private Long bookingRequestId;
	private Long employeeId;
	private Double totalCost;

	/**
	 * @return the bookingRequestId
	 */
	public Long getBookingRequestId() {
		return bookingRequestId;
	}

	/**
	 * @param bookingRequestId
	 *            the bookingRequestId to set
	 */
	public void setBookingRequestId(Long bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}

	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId
	 *            the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the totalCost
	 */
	public Double getTotalCost() {
		return totalCost;
	}

	/**
	 * @param totalCost
	 *            the totalCost to set
	 */
	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}
}
