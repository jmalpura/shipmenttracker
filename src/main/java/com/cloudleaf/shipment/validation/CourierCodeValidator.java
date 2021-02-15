package com.cloudleaf.shipment.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourierCodeValidator implements ConstraintValidator<CourierCode, String> {

	List<String> courierCodes = Arrays.asList("FedEx", "UPS", "USPS");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		return courierCodes.contains(value);

	}
}