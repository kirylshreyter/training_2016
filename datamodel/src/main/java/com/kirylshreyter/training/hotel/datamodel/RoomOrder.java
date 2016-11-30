package com.kirylshreyter.training.hotel.datamodel;

public class RoomOrder extends AbstractModel {

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RoomOrder [bookingRequestId=" + bookingRequestId + ", employeeId=" + employeeId + ", totalCost="
				+ totalCost + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((bookingRequestId == null) ? 0 : bookingRequestId.hashCode());
		result = prime * result + ((employeeId == null) ? 0 : employeeId.hashCode());
		result = prime * result + ((totalCost == null) ? 0 : totalCost.hashCode());
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
		RoomOrder other = (RoomOrder) obj;
		if (bookingRequestId == null) {
			if (other.bookingRequestId != null)
				return false;
		} else if (!bookingRequestId.equals(other.bookingRequestId))
			return false;
		if (employeeId == null) {
			if (other.employeeId != null)
				return false;
		} else if (!employeeId.equals(other.employeeId))
			return false;
		if (totalCost == null) {
			if (other.totalCost != null)
				return false;
		} else if (!totalCost.equals(other.totalCost))
			return false;
		return true;
	}

	private Long bookingRequestId;
	private Long employeeId;
	private Double totalCost;

	public Long getBookingRequestId() {
		return bookingRequestId;
	}

	public void setBookingRequestId(Long bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

}