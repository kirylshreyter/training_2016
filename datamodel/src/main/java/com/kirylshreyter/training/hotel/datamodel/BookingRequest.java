package com.kirylshreyter.training.hotel.datamodel;

import java.util.Date;

public class BookingRequest extends AbstractModel {

	private Long clientId;
	private Date arrivalDate;
	private Date departureDate;
	private String nonConvertedArrivalDate;
	private String nonConvertedDepartureDate;

	public String getNonConvertedArrivalDate() {
		return nonConvertedArrivalDate;
	}

	public void setNonConvertedArrivalDate(String nonConvertedArrivalDate) {
		this.nonConvertedArrivalDate = nonConvertedArrivalDate;
	}

	public String getNonConvertedDepartureDate() {
		return nonConvertedDepartureDate;
	}

	public void setNonConvertedDepartureDate(String nonConvertedDepartureDate) {
		this.nonConvertedDepartureDate = nonConvertedDepartureDate;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
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

}
