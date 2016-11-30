package com.kirylshreyter.training.hotel.datamodel;

public class Room extends AbstractModel {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [number=" + number + ", roomDetailsId=" + roomDetailsId + ", status=" + status + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((roomDetailsId == null) ? 0 : roomDetailsId.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		Room other = (Room) obj;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (roomDetailsId == null) {
			if (other.roomDetailsId != null)
				return false;
		} else if (!roomDetailsId.equals(other.roomDetailsId))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

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
