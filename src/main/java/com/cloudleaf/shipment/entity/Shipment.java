package com.cloudleaf.shipment.entity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloudleaf.shipment.validation.CourierCode;

import lombok.Data;
import lombok.ToString;
@Data
@ToString
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


}
