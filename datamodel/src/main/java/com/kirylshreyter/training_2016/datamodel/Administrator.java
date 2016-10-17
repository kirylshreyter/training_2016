package com.kirylshreyter.training_2016.datamodel;

class Administrator {

	private int id;
	private String firstName;
	private String lastName;

	protected String getFirstName() {
		return firstName;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected String getLastName() {
		return lastName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected int getId() {
		return id;
	}

}
