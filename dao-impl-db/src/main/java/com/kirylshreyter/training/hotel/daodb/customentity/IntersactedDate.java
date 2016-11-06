package com.kirylshreyter.training.hotel.daodb.customentity;

import java.util.Date;

public class IntersactedDate {
	private Long roomId;
	private Date bookedStartDay;
	private Date bookedEndDay;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
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

}
