package com.kirylshreyter.training.hotel.datamodel;

public class Room extends AbstractModel {

	private String number;
	private Integer roomDetailsId;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getRoomDetailsId() {
		return roomDetailsId;
	}

	public void setRoomDetailsId(Integer roomDetailsId) {
		this.roomDetailsId = roomDetailsId;
	}

}
