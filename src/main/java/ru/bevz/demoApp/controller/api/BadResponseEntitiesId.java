package ru.bevz.demoApp.controller.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Data
public class BadResponseEntitiesId {
	@JsonProperty("validation_error")
	private Map<String, Set<Id>> validationError;

	public BadResponseEntitiesId(String nameEntity, Set<Id> entitiesId) {
		this.validationError = new HashMap<>();
		validationError.put(nameEntity, entitiesId);
	}
}
