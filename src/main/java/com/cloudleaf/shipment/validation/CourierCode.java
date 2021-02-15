package com.cloudleaf.shipment.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = CourierCodeValidator.class)

public @interface CourierCode {

	String message() default "Courier Code allowed FedEx, UPS, USPS only";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}