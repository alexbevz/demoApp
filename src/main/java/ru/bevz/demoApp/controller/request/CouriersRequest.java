package ru.bevz.demoApp.controller.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class CouriersRequest {

	@NotNull
	@NotEmpty
	private Set<CourierInfo> data;
}
