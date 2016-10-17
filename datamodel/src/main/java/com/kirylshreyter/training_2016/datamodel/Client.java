package com.kirylshreyter.training_2016.datamodel;

class Client {

	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String phone;
	private String email;

	protected String getFirst_name() {
		return firstName;
	}

	protected void setFirst_name(String first_name) {
		this.firstName = first_name;
	}

	protected String getLast_name() {
		return lastName;
	}

	protected void setLast_name(String last_name) {
		this.lastName = last_name;
	}

	protected String getAddress() {
		return address;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	protected String getPhone() {
		return phone;
	}

	protected void setPhone(String phone) {
		this.phone = phone;
	}

	protected String getEmail() {
		return email;
	}

	protected void setEmail(String email) {
		this.email = email;
	}

	protected int getId() {
		return id;
	}

}
