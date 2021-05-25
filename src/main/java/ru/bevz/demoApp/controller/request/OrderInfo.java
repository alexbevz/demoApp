package ru.bevz.demoApp.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderInfo {

	@NotNull
	@JsonProperty("order_id")
	private long orderId;

	@NotNull
	@DecimalMax(value = "50")
	@DecimalMin(value = "0.01")
	private Number weight;

	@NotNull
	private int region;

	@NotNull
	@NotEmpty
	@JsonFormat(shape = JsonFormat.Shape.ARRAY)
	@JsonProperty("delivery_hours")
	private Set<@Pattern(regexp = "^(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})-(20|21|22|23|[01]\\d|\\d)((:[0-5]\\d){1,2})$") String> deliveryHours;
}
