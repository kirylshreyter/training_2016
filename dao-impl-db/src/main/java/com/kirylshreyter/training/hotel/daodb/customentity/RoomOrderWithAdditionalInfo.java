package com.kirylshreyter.training.hotel.daodb.customentity;

import java.util.Date;

import com.kirylshreyter.training.hotel.datamodel.AbstractModel;

public class RoomOrderWithAdditionalInfo extends AbstractModel {

	private String number;
	private String roomType;
	private Integer numberOfPlaces;
	private Double costPerNight;
	private String additionalInformation;
	private String status;
	private String ClientFirstName;
	private String ClientLastName;
	private String ClientPhone;
	private String ClientEmail;
	private String ClientAddress;
	private Date arrivalDate;
	private Date departureDate;
	private String EmployeeFirstName;
	private String EmployeeLastName;
	private String EmployeePhone;
	private String EmployeeEmail;
	private String EmployeeAddress;
	private String EmployeePosition;

	private Double totalCost;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public Integer getNumberOfPlaces() {
		return numberOfPlaces;
	}

	public void setNumberOfPlaces(Integer numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	public Double getCostPerNight() {
		return costPerNight;
	}

	public void setCostPerNight(Double costPerNight) {
		this.costPerNight = costPerNight;
	}

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getClientFirstName() {
		return ClientFirstName;
	}

	public void setClientFirstName(String clientFirstName) {
		ClientFirstName = clientFirstName;
	}

	public String getClientLastName() {
		return ClientLastName;
	}

	public void setClientLastName(String clientLastName) {
		ClientLastName = clientLastName;
	}

	public String getClientPhone() {
		return ClientPhone;
	}

	public void setClientPhone(String clientPhone) {
		ClientPhone = clientPhone;
	}

	public String getClientEmail() {
		return ClientEmail;
	}

	public void setClientEmail(String clientEmail) {
		ClientEmail = clientEmail;
	}

	public String getClientAddress() {
		return ClientAddress;
	}

	public void setClientAddress(String clientAddress) {
		ClientAddress = clientAddress;
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

	public String getEmployeeFirstName() {
		return EmployeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		EmployeeFirstName = employeeFirstName;
	}

	public String getEmployeeLastName() {
		return EmployeeLastName;
	}

	public void setEmployeeLastName(String employeeLastName) {
		EmployeeLastName = employeeLastName;
	}

	public String getEmployeePhone() {
		return EmployeePhone;
	}

	public void setEmployeePhone(String employeePhone) {
		EmployeePhone = employeePhone;
	}

	public String getEmployeeEmail() {
		return EmployeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}

	public String getEmployeeAddress() {
		return EmployeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		EmployeeAddress = employeeAddress;
	}

	public String getEmployeePosition() {
		return EmployeePosition;
	}

	public void setEmployeePosition(String employeePosition) {
		EmployeePosition = employeePosition;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

}
