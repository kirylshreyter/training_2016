package com.kirylshreyter.training.hotel.commons;

import java.util.Date;

import com.kirylshreyter.training.hotel.datamodel.AbstractModel;

public class RoomOrderWithAdditionalInfo extends AbstractModel {

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

	private String number;
	private String roomType;
	private Integer numberOfPlaces;
	private Double costPerNight;
	private String additionalInformation;
	private String status;
	private String userName;
	private String userEmail;
	private Date arrivalDate;
	private Date departureDate;
	private String EmployeeFirstName;
	private String EmployeeLastName;
	private String EmployeePhone;
	private String EmployeeEmail;
	private String EmployeePosition;
	private Double totalCost;

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType
	 *            the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * @return the numberOfPlaces
	 */
	public Integer getNumberOfPlaces() {
		return numberOfPlaces;
	}

	/**
	 * @param numberOfPlaces
	 *            the numberOfPlaces to set
	 */
	public void setNumberOfPlaces(Integer numberOfPlaces) {
		this.numberOfPlaces = numberOfPlaces;
	}

	/**
	 * @return the costPerNight
	 */
	public Double getCostPerNight() {
		return costPerNight;
	}

	/**
	 * @param costPerNight
	 *            the costPerNight to set
	 */
	public void setCostPerNight(Double costPerNight) {
		this.costPerNight = costPerNight;
	}

	/**
	 * @return the additionalInformation
	 */
	public String getAdditionalInformation() {
		return additionalInformation;
	}

	/**
	 * @param additionalInformation
	 *            the additionalInformation to set
	 */
	public void setAdditionalInformation(String additionalInformation) {
		this.additionalInformation = additionalInformation;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	/**
	 * @return the arrivalDate
	 */
	public Date getArrivalDate() {
		return arrivalDate;
	}

	/**
	 * @param arrivalDate
	 *            the arrivalDate to set
	 */
	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	/**
	 * @return the departureDate
	 */
	public Date getDepartureDate() {
		return departureDate;
	}

	/**
	 * @param departureDate
	 *            the departureDate to set
	 */
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	/**
	 * @return the employeeFirstName
	 */
	public String getEmployeeFirstName() {
		return EmployeeFirstName;
	}

	/**
	 * @param employeeFirstName
	 *            the employeeFirstName to set
	 */
	public void setEmployeeFirstName(String employeeFirstName) {
		EmployeeFirstName = employeeFirstName;
	}

	/**
	 * @return the employeeLastName
	 */
	public String getEmployeeLastName() {
		return EmployeeLastName;
	}

	/**
	 * @param employeeLastName
	 *            the employeeLastName to set
	 */
	public void setEmployeeLastName(String employeeLastName) {
		EmployeeLastName = employeeLastName;
	}

	/**
	 * @return the employeePhone
	 */
	public String getEmployeePhone() {
		return EmployeePhone;
	}

	/**
	 * @param employeePhone
	 *            the employeePhone to set
	 */
	public void setEmployeePhone(String employeePhone) {
		EmployeePhone = employeePhone;
	}

	/**
	 * @return the employeeEmail
	 */
	public String getEmployeeEmail() {
		return EmployeeEmail;
	}

	/**
	 * @param employeeEmail
	 *            the employeeEmail to set
	 */
	public void setEmployeeEmail(String employeeEmail) {
		EmployeeEmail = employeeEmail;
	}

	/**
	 * @return the employeePosition
	 */
	public String getEmployeePosition() {
		return EmployeePosition;
	}

	/**
	 * @param employeePosition
	 *            the employeePosition to set
	 */
	public void setEmployeePosition(String employeePosition) {
		EmployeePosition = employeePosition;
	}
}
