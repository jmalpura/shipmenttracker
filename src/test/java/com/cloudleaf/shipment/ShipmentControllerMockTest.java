package com.cloudleaf.shipment;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cloudleaf.shipment.controller.ShipmentController;
import com.cloudleaf.shipment.entity.Shipment;
import com.cloudleaf.shipment.service.ShipmentService;
import com.cloudleaf.shipment.util.TestUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ShipmentController.class)
public class ShipmentControllerMockTest {
	private static final Gson GSON = new GsonBuilder().enableComplexMapKeySerialization().create();

	@MockBean
	private ShipmentService shipmentService;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@Test
	public void testMockPost() throws Exception {
		Shipment mockShipment = TestUtil.newShipment("TA12334");
		when(shipmentService.createShipment(any())).thenReturn(mockShipment);

		MvcResult result = mockMvc.perform(post("/shipment").contentType(MediaType.APPLICATION_JSON)
				.content(GSON.toJson(mockShipment)).accept(MediaType.APPLICATION_JSON)).andReturn();

		int status = result.getResponse().getStatus();

		assertEquals(HttpStatus.CREATED.value(), status);
		verify(shipmentService).createShipment(any(Shipment.class));

		assertNotNull(result);
	}

	@Test
	public void testMockInvalidPost() throws Exception {
		Shipment mockShipment = new Shipment();

		when(shipmentService.createShipment(any(Shipment.class))).thenReturn(mockShipment);
		MvcResult result = mockMvc.perform(post("/shipment").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).content(GSON.toJson(mockShipment))).andReturn();

		int status = result.getResponse().getStatus();
		String response = result.getResponse().getContentAsString();
		assertEquals(HttpStatus.BAD_REQUEST.value(), status);
		assertTrue(response.contains("Invalid Input"));
		verify(shipmentService, times(0)).createShipment(any(Shipment.class));
		assertNotNull(result);
	}

}
