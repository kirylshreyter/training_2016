package com.kirylshreyter.training.hotel.datamodel;

public class Room extends AbstractModel {

	private String number;
	private Long roomDetailsId;
	private String status;

	public Long getRoomDetailsId() {
		return roomDetailsId;
	}

	public void setRoomDetailsId(Long roomDetailsId) {
		this.roomDetailsId = roomDetailsId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
