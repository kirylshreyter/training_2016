package com.kirylshreyter.hotel.web.model;

public class RoomModel extends ParentModel {

	private String number;
	private Long roomDetailsId;
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
	 * @return the roomDetailsId
	 */
	public Long getRoomDetailsId() {
		return roomDetailsId;
	}

	/**
	 * @param roomDetailsId
	 *            the roomDetailsId to set
	 */
	public void setRoomDetailsId(Long roomDetailsId) {
		this.roomDetailsId = roomDetailsId;
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
