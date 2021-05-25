package ru.bevz.demoApp.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto {

	private long id;

	private float weight;

	private int region;

	private Set<String> deliveryHours;
}
