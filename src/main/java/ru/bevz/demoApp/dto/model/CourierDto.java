package ru.bevz.demoApp.dto.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourierDto {

	private long id;

	private String type;

	private Set<Integer> regions;

	private Set<String> workingHours;

}
