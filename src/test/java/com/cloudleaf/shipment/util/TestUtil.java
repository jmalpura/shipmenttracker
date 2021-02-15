package com.cloudleaf.shipment.util;

import com.cloudleaf.shipment.entity.Address;
import com.cloudleaf.shipment.entity.Shipment;

public class TestUtil {
	
	public static Shipment loadShipment() {
		Address origin = new Address();
		origin.setCountry("India");
		Address destination = new Address();
		destination.setCountry("China");
		
		Shipment  saveShipment = new Shipment();
		saveShipment.setTrackingNumber("123456");
		saveShipment.setId("abc-2223-nnn");
		saveShipment.setCourierCode("USPS");
		saveShipment.setDestination(destination);
		saveShipment.setOrigin(origin);
		saveShipment.setCurrentStatus("InTransit");
		ShipmetStorage.saveShipmet(saveShipment);
		
		
		return saveShipment;
	}
	
	
	public static Shipment newShipment(String trackerId) {
		Address origin = new Address();
		origin.setCountry("India");
		Address destination = new Address();
		destination.setCountry("China");
		Shipment  saveShipment = new Shipment();
		saveShipment.setTrackingNumber(trackerId);
		saveShipment.setCourierCode("USPS");
		saveShipment.setDestination(destination);
		saveShipment.setOrigin(origin);
		saveShipment.setCurrentStatus("InTransit");
		
		return saveShipment;
	}

}
