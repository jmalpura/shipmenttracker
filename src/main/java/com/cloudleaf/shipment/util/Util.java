package com.cloudleaf.shipment.util;

import java.util.UUID;

public class Util {

	private Util() {

	}

	public static Long getNewRequestId() {

		return null;
	}

	public static String getNewShipmentId() {

		return UUID.randomUUID().toString();
	}

}
