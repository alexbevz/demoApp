package ru.bevz.demoApp.controller.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Id {

	@JsonProperty("id")
	private long value;

	public Id(long id) {
		this.value = id;
	}
}