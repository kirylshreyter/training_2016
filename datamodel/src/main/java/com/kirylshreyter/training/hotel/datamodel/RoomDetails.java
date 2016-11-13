package com.kirylshreyter.training.hotel.datamodel;

public class RoomDetails extends AbstractModel {

	private String roomType;
	private Integer numberOfPlaces;
	private Double costPerNight;
	private String additionalInformation;

	public String getAdditionalInformation() {
		return additionalInformation;
	}

	public void setAdditionalInformation(String additional_information) {
		this.additionalInformation = additional_information;
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

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

}
