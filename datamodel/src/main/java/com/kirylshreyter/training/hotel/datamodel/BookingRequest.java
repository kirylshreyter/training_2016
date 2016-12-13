package com.kirylshreyter.training.hotel.datamodel;

import java.util.Date;

public class BookingRequest extends AbstractModel {

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((arrivalDate == null) ? 0 : arrivalDate.hashCode());
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((departureDate == null) ? 0 : departureDate.hashCode());
		result = prime * result + ((roomId == null) ? 0 : roomId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingRequest other = (BookingRequest) obj;
		if (arrivalDate == null) {
			if (other.arrivalDate != null)
				return false;
		} else if (!arrivalDate.equals(other.arrivalDate))
			return false;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (departureDate == null) {
			if (other.departureDate != null)
				return false;
		} else if (!departureDate.equals(other.departureDate))
			return false;
		if (roomId == null) {
			if (other.roomId != null)
				return false;
		} else if (!roomId.equals(other.roomId))
			return false;
		return true;
	}

	private Long roomId;
	private Long clientId;
	private Date arrivalDate;
	private Date departureDate;

	/**
	 * @return the roomId
	 */
	public Long getRoomId() {
		return roomId;
	}

	/**
	 * @param roomId
	 *            the roomId to set
	 */
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	/**
	 * @return the clientId
	 */
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId
	 *            the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
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
}
