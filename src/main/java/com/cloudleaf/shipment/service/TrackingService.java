package com.cloudleaf.shipment.service;

import org.springframework.stereotype.Service;

import com.cloudleaf.shipment.entity.Shipment;
import com.cloudleaf.tracking.aftership.entity.Tracking;

@Service
public interface TrackingService {

	public String saveShipment(Shipment shipment);

	public Tracking getTracking(String id);

}
