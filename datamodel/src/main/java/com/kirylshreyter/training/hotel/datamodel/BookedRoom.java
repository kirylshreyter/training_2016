package com.kirylshreyter.training.hotel.datamodel;

import java.util.Date;

public class BookedRoom extends AbstractModel {

	private Integer bookingRequestId;
	private Integer roomOrderId;
	private Date bookedStartDay;
	private Date bookedEndDay;

	public Integer getBookingRequestId() {
		return bookingRequestId;
	}

	public void setBookingRequestId(Integer bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}

	public Integer getRoomOrderId() {
		return roomOrderId;
	}

	public void setRoomOrderId(Integer roomOrderId) {
		this.roomOrderId = roomOrderId;
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
