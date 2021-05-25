package ru.bevz.demoApp.controller.api;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OkResponseEntitiesId {

	@JsonValue
	private Map<String, Set<Id>> entitiesId;

	public OkResponseEntitiesId(String nameEntity, Set<Id> entitiesId) {
		this.entitiesId = new HashMap<>();
		this.entitiesId.put(nameEntity, entitiesId);
	}

	public Map<String, Set<Id>> getEntitiesId() {
		return entitiesId;
	}
}
