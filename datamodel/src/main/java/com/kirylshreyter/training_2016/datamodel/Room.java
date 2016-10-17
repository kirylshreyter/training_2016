package com.kirylshreyter.training_2016.datamodel;

import java.util.Date;

class Room {

	private int id;
	private String number;
	private int roomDetailsId;
	private String status;
	private int clientId;
	private int administratorId;
	private double costPerDay;
	private Date fromWhichBusy;
	private Date toWhichBusy;

	protected String getNumber() {
		return number;
	}

	protected void setNumber(String number) {
		this.number = number;
	}

	protected int getRoomDetailsId() {
		return roomDetailsId;
	}

	protected void setRoomDetailsId(int roomDetailsId) {
		this.roomDetailsId = roomDetailsId;
	}

	protected String getStatus() {
		return status;
	}

	protected void setStatus(String status) {
		this.status = status;
	}

	protected int getClientId() {
		return clientId;
	}

	protected void setClientId(int clientId) {
		this.clientId = clientId;
	}

	protected int getAdministratorId() {
		return administratorId;
	}

	protected void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}

	protected double getCostPerDay() {
		return costPerDay;
	}

	protected void setCostPerDay(double costPerDay) {
		this.costPerDay = costPerDay;
	}

	protected Date getFromWhichBusy() {
		return fromWhichBusy;
	}

	protected void setFromWhichBusy(Date fromWhichBusy) {
		this.fromWhichBusy = fromWhichBusy;
	}

	protected Date getToWhichBusy() {
		return toWhichBusy;
	}

	protected void setToWhichBusy(Date toWhichBusy) {
		this.toWhichBusy = toWhichBusy;
	}

	protected int getId() {
		return id;
	}

}
