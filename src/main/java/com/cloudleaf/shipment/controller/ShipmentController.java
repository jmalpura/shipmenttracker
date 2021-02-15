package com.cloudleaf.shipment.controller;

import javax.validation.Valid;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiAuthNone;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiPathParam;
import org.jsondoc.core.annotation.ApiVersion;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudleaf.shipment.entity.Shipment;
import com.cloudleaf.shipment.service.ShipmentService;

import lombok.extern.log4j.Log4j2;

@Api(name = "Shipment API", description = "Shipment Service is provided by Cloudleaf and IT provides APIs to create "
		+ "new Shipment and Tracking the status of Shipment")
@ApiVersion(since = "1.0")
@ApiAuthNone

@RestController
@RequestMapping("/shipment")
@Validated
@Log4j2
public class ShipmentController {

	private final ShipmentService shipmentService;

	public ShipmentController(ShipmentService shipmentService) {
		this.shipmentService = shipmentService;
	}

	@ApiMethod(description = "Create Shipment service will Validate Shipment details and Interface to AfterShip "
			+ "Tracking System to provide Shipment tracking manachinsim")
	@RequestMapping(method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE }, headers = "Accept=application/json")

	public ResponseEntity<Shipment> createShipment(@Valid @RequestBody Shipment shipment) throws Exception {
		return new ResponseEntity<>(shipmentService.createShipment(shipment), HttpStatus.CREATED);
	}

	@ApiMethod(description = "Get Shipment status retuns Shipment status for givnen Tracking Number or AfterShip Id")
	@GetMapping("{id}")
	public ResponseEntity<Shipment> getShipmentStatus(@ApiPathParam(description = "Tracking Number or AfterShip Id") @PathVariable("id") String id) throws Exception {
		log.info("Get Shipment : {}", id);
		return new ResponseEntity<>(shipmentService.getShipmentStatus(id), HttpStatus.OK);
	}

}
