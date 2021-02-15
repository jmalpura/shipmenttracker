package com.cloudleaf.shipment.service;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.cloudleaf.shipment.entity.Shipment;
import com.cloudleaf.shipment.util.ShipmentException;
import com.cloudleaf.tracking.aftership.entity.AfterShipTrackingResponse;
import com.cloudleaf.tracking.aftership.entity.Tracking;
import com.cloudleaf.tracking.aftership.entity.TrackingRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Qualifier("afterShipTrackingService")
public class AfterShipTrackingService implements TrackingService {
    private static final Logger logger = LogManager.getLogger(AfterShipTrackingService.class);

	@Autowired
	RestTemplate restTemplate;

	@Value("${shipment.aftership.apikey}")
	private String apiKey;

	@Value("${shipment.aftership.apiUrl}")
	private String aftershipApiUrl;

	
	@Override
	public String saveShipment(Shipment shipment) {

		Tracking tracking = new Tracking();
		tracking.setTracking_number(shipment.getTrackingNumber());
		tracking.setSlug(shipment.getCourierCode());
		tracking.setTracking_origin_country(shipment.getOrigin().getCountry());
		tracking.setTracking_destination_country(shipment.getDestination().getCountry());

		HttpHeaders headers = new HttpHeaders();

		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("aftership-api-key", apiKey);

		TrackingRequest trackingReuest = new TrackingRequest();
		trackingReuest.setTracking(tracking);
		
		logger.info("trackingReuest to save "+trackingReuest);

		HttpEntity<TrackingRequest> entity = new HttpEntity<>(trackingReuest, headers);
		try {
			ResponseEntity<AfterShipTrackingResponse> response = restTemplate.postForEntity(aftershipApiUrl, entity,
					AfterShipTrackingResponse.class);
			if (response.getStatusCode() == HttpStatus.CREATED) {
				AfterShipTrackingResponse afterShipTrackingResponse = response.getBody();
				return afterShipTrackingResponse.getData().getTracking().getId();

			} else {
				logger.error("Trqcking Response status is not Create tracking Nunber"+shipment.getTrackingNumber());
				throw new ShipmentException("Failed to Save Tracking Id");
			}
		} catch (HttpClientErrorException clientErrorException) {
			logger.error("Trqcking Errored "+shipment.getTrackingNumber());
			
			String errorResponse = clientErrorException.getResponseBodyAsString();
			ObjectMapper om = new ObjectMapper();
			try {
				AfterShipTrackingResponse trakingResonse = om.readValue(errorResponse, AfterShipTrackingResponse.class);
				throw new ShipmentException(trakingResonse.getMeta().getMessage());

			} catch (JsonProcessingException e) {
				throw new ShipmentException("Failed to Save Tracking Id ");
			}

		}
	}

	@Override
	public Tracking getTracking(String id) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("aftership-api-key", apiKey);

		URI uri = UriComponentsBuilder.fromHttpUrl(aftershipApiUrl + "/{id}").build(id);

		HttpEntity<TrackingRequest> entity = new HttpEntity<>(null, headers);

		ResponseEntity<AfterShipTrackingResponse> response = restTemplate.exchange(uri, HttpMethod.GET, entity,
				AfterShipTrackingResponse.class);

		if (response.getStatusCode() == HttpStatus.OK) {
			return response.getBody().getData().getTracking();

		} else {

			throw new ShipmentException("Tracking Id not exists");
		}

	}

}
