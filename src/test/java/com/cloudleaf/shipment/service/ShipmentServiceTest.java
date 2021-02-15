package com.cloudleaf.shipment.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cloudleaf.shipment.entity.Shipment;
import com.cloudleaf.shipment.util.ShipmentException;
import com.cloudleaf.shipment.util.TestUtil;
import com.cloudleaf.tracking.aftership.entity.Tracking;

@SpringBootTest
public class ShipmentServiceTest {

	@MockBean
	TrackingService trackingService;

	@Autowired
	ShipmentService shipmentService;

	@Test
	public void testCreateExisitngShipment() {
		Shipment shipment = TestUtil.loadShipment();
		Throwable exception = assertThrows(ShipmentException.class, () -> {
			shipmentService.createShipment(shipment);

		});
		assertTrue(exception.getMessage().contains("Given Tracking Number is already exists"));

	}

	@Test
	public void tesNotValidShipmentStatus() {
		Throwable exception = assertThrows(ShipmentException.class, () -> {
			shipmentService.getShipmentStatus("");

		});
		assertTrue(exception.getMessage().contains("not found"));

	}

	@Test
	public void testCreateShipment () {
		
		String newId = "id123";
		when(trackingService.saveShipment(any(Shipment.class))).thenReturn(newId);
		Shipment shipment = TestUtil.newShipment("ta12333");
		Shipment savedShipment = shipmentService.createShipment(shipment);
		
		verify(trackingService, times(1)).saveShipment(any(Shipment.class));

	    assertTrue(newId.equals(savedShipment.getId()));
	}
	

	@Test
	public void testValidShipmentStatus () {
		
		Shipment shipment = TestUtil.loadShipment();
		shipment.setCurrentStatus("InTransit");
		Tracking tracking  = new Tracking();
		tracking.setTag("Pending");
		when(trackingService.getTracking(anyString())).thenReturn(tracking);
		Shipment savedShipment = shipmentService.getShipmentStatus(shipment.getId());
		verify(trackingService, times(1)).getTracking(anyString());
		assertTrue(savedShipment.getCurrentStatus().equals(tracking.getTag()));
	}

}
