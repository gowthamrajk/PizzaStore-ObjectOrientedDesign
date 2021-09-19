package com.gowthamrajk.pizzastore;

public class Address {
	
	private int doorNumber;
	private String street;
	private String city;
	private String district;
	private String state;
	
	public Address(int doorNumber, String street, String city, String district, String state) {
		this.doorNumber = doorNumber;
		this.street = street;
		this.city = city;
		this.district = district;
		this.state = state;
	}

	public int getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(int doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		
		return "Address => Door Number : " + doorNumber + ", Street : " + street + ", City : " + city 
				+ ", District : " + district + ", State : " + state;
	}
}
