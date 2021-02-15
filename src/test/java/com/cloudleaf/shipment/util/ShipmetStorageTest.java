package com.cloudleaf.shipment.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import com.cloudleaf.shipment.entity.Shipment;

public class ShipmetStorageTest {
	
	@Test
    public void testStoageShipmentByTrackingNumber() throws Exception {
		Shipment saveShipment = TestUtil.loadShipment();		
		
		Shipment shipment = ShipmetStorage.getShipmet(saveShipment.getTrackingNumber());
		assertNotNull(shipment);
		assertEquals(shipment.getTrackingNumber(),saveShipment.getTrackingNumber());
		
	}
	@Test
    public void testStoageShipmentId() throws Exception {
		Shipment saveShipment = TestUtil.loadShipment();		
		
		Shipment shipment = ShipmetStorage.getShipmet(saveShipment.getId());
		assertNotNull(shipment);
		assertEquals(shipment.getTrackingNumber(),saveShipment.getTrackingNumber());
		
	}
	
	@Test
    public void testStoageShipmentNull() throws Exception {
		TestUtil.loadShipment();		
		Shipment shipment = ShipmetStorage.getShipmet("");
		assertNull(shipment);
		
		
	}
	
	

}
