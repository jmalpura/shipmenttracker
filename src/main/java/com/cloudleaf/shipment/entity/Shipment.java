package com.cloudleaf.shipment.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloudleaf.shipment.validation.CourierCode;

public class Shipment implements Serializable {

	private static final long serialVersionUID = 8918928031L;

	private String id;

	@NotNull(message = "{shipment.origin.notempty}")
	private Address origin;

	@NotNull(message = "{shipment.destination.notempty}")
	private Address destination;

	private String currentStatus;

	@NotBlank(message = "{shipment.trackingNumber.notempty}")
	private String trackingNumber;

	@NotBlank(message = "{shipment.courierCode.notempty}")
	@CourierCode(message = "{shipment.courierCode.allowedvalues}")
	private String courierCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Address getOrigin() {
		return origin;
	}

	public void setOrigin(Address origin) {
		this.origin = origin;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public String getCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String getTrackingNumber() {
		return trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	public String getCourierCode() {
		return courierCode;
	}

	public void setCourierCode(String courierCode) {
		this.courierCode = courierCode;
	}

}
