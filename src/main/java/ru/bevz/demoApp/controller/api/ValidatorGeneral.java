package ru.bevz.demoApp.controller.api;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
@Data
public class ValidatorGeneral {

	@Autowired
	private Validator validator;

	public boolean isValid(Object object) {
		Set<ConstraintViolation<Object>> validates = validator.validate(object);
		boolean notValid = false;
		for (ConstraintViolation<Object> violation : validates) {
			if (violation.getInvalidValue() != null) {
				notValid = true;
			}
		}

		return notValid;
	}
}
