package com.cloudleaf.shipment.service;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.cloudleaf.shipment.entity.Shipment;
import com.cloudleaf.shipment.util.ShipmentException;
import com.cloudleaf.shipment.util.TestUtil;
import com.cloudleaf.tracking.aftership.entity.AfterShipTrackingResponse;
import com.cloudleaf.tracking.aftership.entity.Data;
import com.cloudleaf.tracking.aftership.entity.Meta;
import com.cloudleaf.tracking.aftership.entity.Tracking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
public class AfterShipmentServiceTest {

	@MockBean
	RestTemplate restTemplate ;
	
	@Autowired 
	TrackingService afterShipTrackingService; 
	
	@Test
	public void testSaveShipment() {
		
		Shipment shipment = TestUtil.newShipment("TA12334");
		   HttpHeaders responseHeaders = new HttpHeaders();
		   AfterShipTrackingResponse response = new AfterShipTrackingResponse();
		   Data data = new Data();
		   Tracking tracking = new Tracking();
		   tracking.setId("ID12345");
		   data.setTracking(tracking);
		   response.setData(data);
		   
		ResponseEntity<Object> responseEntity = new ResponseEntity<>(
				response,
			    responseHeaders, 
			    HttpStatus.CREATED
			);
		
		when(restTemplate.postForEntity(anyString(),any(),any())).thenReturn(responseEntity);
		
		String id = afterShipTrackingService.saveShipment(shipment);
		assertTrue(id.equals(tracking.getId()));

	}
	
	@Test
	public void testSaveShipmentHttpError() throws JsonProcessingException {
		
		Shipment shipment = TestUtil.newShipment("TA12334");
		   
		   AfterShipTrackingResponse response = new AfterShipTrackingResponse();
		   Data data = new Data();
		   Tracking tracking = new Tracking();
		   Meta meta = new Meta();
		   meta.setMessage("Failed");
		   response.setMeta(meta);
		   data.setTracking(tracking);
		   response.setData(data);
		   
		   ObjectMapper Obj = new ObjectMapper();
		   String exceptionresponse = Obj.writeValueAsString(response);
	        
		   
		when(restTemplate.postForEntity(anyString(),any(),any()))
			.thenThrow(new HttpClientErrorException(HttpStatus.BAD_REQUEST,"Error occurred",exceptionresponse.getBytes(), null));
		
		Throwable exception = assertThrows(ShipmentException.class, () -> {
			afterShipTrackingService.saveShipment(shipment);

		});
		assertTrue(exception.getMessage().contains("Failed"));
	}
	

	@Test
	public void testGetTracking() {
		
		   HttpHeaders responseHeaders = new HttpHeaders();
		   AfterShipTrackingResponse response = new AfterShipTrackingResponse();
		   Data data = new Data();
		   Tracking tracking = new Tracking();
		   tracking.setId("ID12345");
		   tracking.setTag("Pending");
		   data.setTracking(tracking);
		   response.setData(data);
		   
		ResponseEntity<AfterShipTrackingResponse> responseEntity = new ResponseEntity<>(
				response,
			    responseHeaders, 
			    HttpStatus.OK
			);
		


		when(restTemplate.exchange(any(), any(HttpMethod.class),Matchers.<HttpEntity<?>> any(),  
				Matchers.<Class<AfterShipTrackingResponse>> any()))
				.thenReturn(responseEntity);
				
		Tracking responseTracking = afterShipTrackingService.getTracking("ID12345");
		assertTrue(responseTracking.getTag().equals(tracking.getTag()));

	}
	

	@Test
	public void testGetTrackingFail() {
		
	   HttpHeaders responseHeaders = new HttpHeaders();
	   AfterShipTrackingResponse response = new AfterShipTrackingResponse();
		   
		ResponseEntity<AfterShipTrackingResponse> responseEntity = new ResponseEntity<>(
				response,
			    responseHeaders, 
			    HttpStatus.BAD_REQUEST
			);
		

		when(restTemplate.exchange(any(), any(HttpMethod.class),Matchers.<HttpEntity<?>> any(),  
				Matchers.<Class<AfterShipTrackingResponse>> any()))
				.thenReturn(responseEntity);		
		
		Throwable exception = assertThrows(ShipmentException.class, () -> {
			 afterShipTrackingService.getTracking("ID12345");

		});
		assertTrue(exception.getMessage().contains("Tracking Id not exists"));
		

	}
	
}
