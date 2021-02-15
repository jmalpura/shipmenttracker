package com.cloudleaf.shipment.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.cloudleaf.shipment.entity.Shipment;
import com.cloudleaf.shipment.util.ShipmentException;
import com.cloudleaf.shipment.util.ShipmetStorage;
import com.cloudleaf.tracking.aftership.entity.Tracking;

/**
 * Service class that provides the implementation to create and fetch status Shipment request.
 * @author jmalpura
 *
 */
@Service
public class ShipmentService {
    private static final Logger logger = LogManager.getLogger(ShipmentService.class);


	@Qualifier("afterShipTrackingService")
	private final TrackingService trackingService;

	public ShipmentService(TrackingService trackingService) {
		this.trackingService = trackingService;
	}

	/**
     * Create shipment involves checking given tracking number already exists in repository, 
     * if not exists interface to Tracking service to save the Shipment detains
     * @param Shipment shipment, for shipment details to save.
     * @return Shipment contains shipment details along with After ship tracking Id
     */
	public Shipment createShipment(Shipment shipment) {

		if (ShipmetStorage.getShipmet(shipment.getTrackingNumber()) != null) {
			logger.info("Shipment id alredy exists "+ shipment.getTrackingNumber());
			throw new ShipmentException("Given Tracking Number is already exists " + shipment.getTrackingNumber());
		}

		String id = trackingService.saveShipment(shipment);
		shipment.setId(id);
		ShipmetStorage.saveShipmet(shipment);
		return shipment;

	}


	/**
     * Get shipment status involves checking given tracking number exists in repository, 
     * if exists interface to Tracking service get the tracking status.
     * @param id ,Tracking number or id
     * @return Shipment contains shipment details along with latest status
     */
	public Shipment getShipmentStatus(String id) {

		Shipment shipment = ShipmetStorage.getShipmet(id);
		if (shipment == null) {
			logger.info("Shipment id not found "+ id);
			throw new ShipmentException("Given Shipement Id or Tracking Number not found " + id);
		}
		Tracking tracking = trackingService.getTracking(id);
		shipment.setCurrentStatus(tracking.getTag());
		ShipmetStorage.saveShipmet(shipment);
		return shipment;
	}

}
