package com.cloudleaf.shipment.entity;

import com.cloudleaf.shipment.util.AddressSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
@JsonSerialize(using = AddressSerializer.class)
public class Address {

	private String address;
	private String city;
	private String country;
	private String zipcode;
	private String state; 

	

	@Override
	public String toString() {
		return "Address [address=" + address + ", city=" + city + ", country=" + country + ", zipcode=" + zipcode + "]";
	}

}
