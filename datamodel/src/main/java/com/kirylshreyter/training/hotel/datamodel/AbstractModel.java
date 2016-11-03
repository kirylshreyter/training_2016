package com.kirylshreyter.training.hotel.datamodel;

public class AbstractModel {

    private Long id;
    private String firstName;
	private String lastName;
	private String phone;
	private String email;
	private Integer roomDetailsId;
	private Integer bookingRequestId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRoomDetailsId() {
		return roomDetailsId;
	}

	public void setRoomDetailsId(Integer roomDetailsId) {
		this.roomDetailsId = roomDetailsId;
	}

	public Integer getBookingRequestId() {
		return bookingRequestId;
	}

	public void setBookingRequestId(Integer bookingRequestId) {
		this.bookingRequestId = bookingRequestId;
	}

  

}
