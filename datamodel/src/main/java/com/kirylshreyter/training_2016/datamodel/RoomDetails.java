package com.kirylshreyter.training_2016.datamodel;

class RoomDetails {

	private int id;
	private int numberOfPlaces;
	private String apartmentsClass;

	protected int getNumber_of_places() {
		return numberOfPlaces;
	}

	protected void setNumber_of_places(int number_of_places) {
		this.numberOfPlaces = number_of_places;
	}

	protected String getApartments_class() {
		return apartmentsClass;
	}

	protected void setApartments_class(String apartments_class) {
		this.apartmentsClass = apartments_class;
	}

	protected int getId() {
		return id;
	}

}
