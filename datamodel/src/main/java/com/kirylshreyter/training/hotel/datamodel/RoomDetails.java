package com.kirylshreyter.training.hotel.datamodel;

public class RoomDetails extends AbstractModel {

	private String roomType;
	private Integer numberOfPlaces;
	private Double costPerNight;
	private String additionalInformation;

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
}
