package com.kirylshreyter.training.hotel.daodb.customentity;

public class AvailableRoom {

	private Long RoomId;
	private Long RoomDetailsId;
	private String Number;
	private String status;
	private Double costPerNight;

	public Double getCostPerNight() {
		return costPerNight;
	}

	public void setCostPerNight(Double costPerNight) {
		this.costPerNight = costPerNight;
	}

	public Long getRoomId() {
		return RoomId;
	}

	public void setRoomId(Long roomId) {
		RoomId = roomId;
	}

	public Long getRoomDetailsId() {
		return RoomDetailsId;
	}

	public void setRoomDetailsId(Long roomDetailsId) {
		RoomDetailsId = roomDetailsId;
	}

	public String getNumber() {
		return Number;
	}

	public void setNumber(String number) {
		Number = number;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
