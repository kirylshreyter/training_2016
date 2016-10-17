package com.kirylshreyter.training_2016.datamodel;

import java.util.Date;

class Application {

	private int id;
	private int clientId;
	private int roomDetailsId;
	private int administratorId;
	private Date arrivalDate;
	private Date departureDate;

	protected int getClientId() {
		return clientId;
	}

	protected void setClientId(int clientId) {
		this.clientId = clientId;
	}

	protected int getRoomDetailsId() {
		return roomDetailsId;
	}

	protected void setRoomDetailsId(int roomDetailsId) {
		this.roomDetailsId = roomDetailsId;
	}

	protected int getAdministratorId() {
		return administratorId;
	}

	protected void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}

	protected Date getArrivalDate() {
		return arrivalDate;
	}

	protected void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	protected Date getDepartureDate() {
		return departureDate;
	}

	protected void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	protected int getId() {
		return id;
	}

}
