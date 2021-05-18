package ru.bevz.demoApp.controller.request;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class OrderRequest {

	@NotNull
	@NotEmpty
	private Set<OrderInfo> data;
}
