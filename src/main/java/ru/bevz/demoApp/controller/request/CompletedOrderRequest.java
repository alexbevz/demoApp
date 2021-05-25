package ru.bevz.demoApp.controller.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompletedOrderRequest {

	@NotNull
	@JsonProperty("courier_id")
	private long courierId;

	@NotNull
	@JsonProperty("order_id")
	private long orderId;

	@NotNull
	@JsonProperty("complete_time")
	@DateTimeFormat
	private LocalDateTime completeTime;
}
