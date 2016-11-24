package com.kirylshreyter.training.hotel.commons;

public class AvailableRoom {

	private Long roomId;
	private String number;
	private String roomType;
	private Double costPerNight;
	private String additionalInformation;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

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

}
