package com.kirylshreyter.training_2016.datamodel;

import java.util.Date;

class Invoice {

	private int id;
	private int clientId;
	private int roomDetailsId;
	private double totalCost;
	private Date arrivalDate;
	private Date departureDate;
	private int administratorId;

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

	protected double getTotalCost() {
		return totalCost;
	}

	protected void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
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

	protected int getAdministratorId() {
		return administratorId;
	}

	protected void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}

	protected int getId() {
		return id;
	}

}
