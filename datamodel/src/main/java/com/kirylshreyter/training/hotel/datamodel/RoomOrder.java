package com.kirylshreyter.training.hotel.datamodel;

import java.util.Date;

public class RoomOrder extends AbstractModel {

	private Integer roomId;
	private Integer employeeId;
	private Double totalCost;
	private Date bookedStartDay;
	private Date bookedEndDay;
	private String nonConvertedbookedStartDay;
	private String nonConvertedbookedEndDay;

	public String getNonConvertedbookedStartDay() {
		return nonConvertedbookedStartDay;
	}

	public void setNonConvertedbookedStartDay(String nonConvertedbookedStartDay) {
		this.nonConvertedbookedStartDay = nonConvertedbookedStartDay;
	}

	public String getNonConvertedbookedEndDay() {
		return nonConvertedbookedEndDay;
	}

	public void setNonConvertedbookedEndDay(String nonConvertedbookedEndDay) {
		this.nonConvertedbookedEndDay = nonConvertedbookedEndDay;
	}

	public Date getBookedStartDay() {
		return bookedStartDay;
	}

	public void setBookedStartDay(Date bookedStartDay) {
		this.bookedStartDay = bookedStartDay;
	}

	public Date getBookedEndDay() {
		return bookedEndDay;
	}

	public void setBookedEndDay(Date bookedEndDay) {
		this.bookedEndDay = bookedEndDay;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
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