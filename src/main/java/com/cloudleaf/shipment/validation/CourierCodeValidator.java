package com.cloudleaf.shipment.validation;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cloudleaf.shipment.util.CourierCodes;

public class CourierCodeValidator implements ConstraintValidator<CourierCode, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Arrays.stream(CourierCodes.values()).anyMatch((t) -> t.name().equals(value));
		
	}
}