package com.cloudleaf.shipment;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URL;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cloudleaf.shipment.entity.Shipment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class ShipmentControllerTest {


	@LocalServerPort
    private int port;
	

    @Autowired
    private TestRestTemplate restTemplate;
    
   @Test
    public void testInvalidTrackingId() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
            new URL("http://localhost:" + port + "/shipment/123").toString(), String.class);
        assertTrue(response.getBody().contains("Tracking Number not found"));

    }
    
    @Test
    public void testPostEmptyRequest() throws Exception {
    	Shipment shipment = new Shipment();
        ResponseEntity<Shipment> response = restTemplate.postForEntity( 
        		new URL("http://localhost:" + port + "/shipment").toString(),
        		shipment,Shipment.class) ;
        
        assertTrue(response.getStatusCode().is4xxClientError());
    }
    
	 
	
    
}
