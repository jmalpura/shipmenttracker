package com.cloudleaf.shipment.entity;

import com.cloudleaf.shipment.util.AddressSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = AddressSerializer.class)
public class Address {

	private String address;
	private String city;
	private String country;
	private String zipcode;
	private String state; 

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	
	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", country=" + country + ", zipcode=" + zipcode + "]";
	}

}
