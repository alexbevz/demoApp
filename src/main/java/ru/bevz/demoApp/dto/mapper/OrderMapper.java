package ru.bevz.demoApp.dto.mapper;

import org.springframework.stereotype.Component;
import ru.bevz.demoApp.controller.request.OrderInfo;
import ru.bevz.demoApp.dto.model.OrderDto;
import ru.bevz.demoApp.model.Order;

import java.util.stream.Collectors;

@Component
public class OrderMapper {

	private OrderMapper() {
	}

	public OrderDto toOrderDto(Order order) {
		return new OrderDto()
						.setId(order.getId())
						.setWeight(order.getWeight())
						.setRegion(order.getRegion().getNumber())
						.setDeliveryHours(order.getDeliveryHours()
										.stream()
										.map(timePeriod -> timePeriod.getFrom() + "-" + timePeriod.getTo())
										.collect(Collectors.toSet()));
	}

	public OrderDto toOrderDto(OrderInfo orderInfo) {
		return new OrderDto()
						.setId(orderInfo.getOrderId())
						.setWeight(orderInfo.getWeight().floatValue())
						.setRegion(orderInfo.getRegion())
						.setDeliveryHours(orderInfo.getDeliveryHours());
	}
}
