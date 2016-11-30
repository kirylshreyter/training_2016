package com.kirylshreyter.training.hotel.datamodel;

public class RoomDetails extends AbstractModel {



	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((additionalInformation == null) ? 0 : additionalInformation.hashCode());
		result = prime * result + ((costPerNight == null) ? 0 : costPerNight.hashCode());
		result = prime * result + ((numberOfPlaces == null) ? 0 : numberOfPlaces.hashCode());
		result = prime * result + ((roomType == null) ? 0 : roomType.hashCode());
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
		RoomDetails other = (RoomDetails) obj;
		if (additionalInformation == null) {
			if (other.additionalInformation != null)
				return false;
		} else if (!additionalInformation.equals(other.additionalInformation))
			return false;
		if (costPerNight == null) {
			if (other.costPerNight != null)
				return false;
		} else if (!costPerNight.equals(other.costPerNight))
			return false;
		if (numberOfPlaces == null) {
			if (other.numberOfPlaces != null)
				return false;
		} else if (!numberOfPlaces.equals(other.numberOfPlaces))
			return false;
		if (roomType == null) {
			if (other.roomType != null)
				return false;
		} else if (!roomType.equals(other.roomType))
			return false;
		return true;
	}

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
