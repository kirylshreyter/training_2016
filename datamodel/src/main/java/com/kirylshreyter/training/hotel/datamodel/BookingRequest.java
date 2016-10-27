package com.kirylshreyter.training.hotel.datamodel;

import java.util.Date;

public class BookingRequest {

	private Integer clientId;
	private Integer roomDetailsId;
	private Date arrivalDate;

	public Integer getClientId() {
		return clientId;
	}

	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}

	public Integer getRoomDetailsId() {
		return roomDetailsId;
	}

	public void setRoomDetailsId(Integer roomDetailsId) {
		this.roomDetailsId = roomDetailsId;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	private Date departureDate;

}
