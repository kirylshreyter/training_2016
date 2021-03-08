package com.kirylshreyter.hotel.commons;

import com.kirylshreyter.hotel.datamodel.AbstractModel;

public class RoomWithAdditionalInfo extends AbstractModel {

	private String number;
	private String roomType;
	private Integer numberOfPlaces;
	private Double costPerNight;
	private String additionalInformation;
	private String status;

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
}
