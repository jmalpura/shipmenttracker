package com.cloudleaf.shipment.util;

import java.util.concurrent.ConcurrentHashMap;

import com.cloudleaf.shipment.entity.Shipment;

public class ShipmetStorage extends ConcurrentHashMap<String, Shipment> {

	private static final long serialVersionUID = -3448654975768143274L;
	private static ShipmetStorage storage;

	private ShipmetStorage() {

	}

	private static ShipmetStorage getShipmetStorage() {
		if (storage == null) {
			storage = new ShipmetStorage();
		}
		return storage;
	}

	public static void saveShipmet(Shipment shipment) {
		getShipmetStorage().put(shipment.getTrackingNumber(), shipment);
	}

	public static Shipment getShipmet(String trackingNumber) {
		Shipment shipment = getShipmetStorage().get(trackingNumber);
		if (shipment == null) {
			shipment = getShipmetStorage().values().stream().filter(e -> trackingNumber.equalsIgnoreCase(e.getId()))
					.findAny().orElse(null);
		}
		return shipment;
	}

}
