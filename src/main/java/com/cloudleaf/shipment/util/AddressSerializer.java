package com.cloudleaf.shipment.util;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;

import com.cloudleaf.shipment.entity.Address;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.google.common.base.Joiner;

@JsonComponent
public class AddressSerializer extends StdSerializer<Address> {

	private static final long serialVersionUID = 88199011L;

	public AddressSerializer() {
		this(null);
	}

	public AddressSerializer(Class<Address> t) {
		super(t);
	}

	@Override
	public void serialize(Address address, JsonGenerator gen, SerializerProvider serializers)
			throws IOException, JsonProcessingException {
		
		gen.writeString(Joiner.on(" ").skipNulls().join(address.getAddress(),address.getCity()
				  ,address.getState(),address.getCountry(),address.getZipcode()));
	}

}