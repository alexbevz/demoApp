package ru.bevz.demoApp.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;
import java.util.Set;

@Data
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CourierInfo {

	@NotNull
	@JsonProperty("courier_id")
	private long courierId;

	@NotNull
	@JsonProperty("courier_type")
	private String courierType;

	@NotNull
	@NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	private Set<@PositiveOrZero Integer> regions;

	@NotNull
	@NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonProperty("working_hours")
	private Set<@Pattern(regexp = "^(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})-(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})$") String> workingHours;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private float rating;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private float earnings;
}
