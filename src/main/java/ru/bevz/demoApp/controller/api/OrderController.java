package ru.bevz.demoApp.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.bevz.demoApp.controller.request.*;
import ru.bevz.demoApp.dto.mapper.OrderMapper;
import ru.bevz.demoApp.repository.OrderRepository;
import ru.bevz.demoApp.service.OrderService;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private ValidatorGeneral validator;
	@Autowired
	private OrderMapper orderMapper;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderService orderService;

	Set<Id> getOrdersId(Set<OrderInfo> orderInfoSet) {
		return orderInfoSet.stream()
						.map(OrderInfo::getOrderId)
						.map(Id::new)
						.collect(Collectors.toSet());
	}

	@PostMapping("")
	ResponseEntity<Object> createOrders(@RequestBody OrderRequest orderRequest) {
		Set<Id> notValidId = new HashSet<>();

		for (OrderInfo orderInfo : orderRequest.getData()) {
			if (orderRepository.existsById(orderInfo.getOrderId())
							|| validator.isValid(orderInfo)) {
				notValidId.add(new Id(orderInfo.getOrderId()));
			}
		}

		if (!notValidId.isEmpty()) {
			return ResponseEntity.badRequest().body(new BadResponseEntitiesId("orders", notValidId));
		}

		orderService.createOrders(orderRequest.getData()
						.stream()
						.map(orderMapper::toOrderDto)
						.collect(Collectors.toSet())
		);

		return ResponseEntity.ok().body(new OkResponseEntitiesId("orders", getOrdersId(orderRequest.getData())));
	}

	//TODO: реализовать
	@PostMapping("/assign")
	ResponseEntity<Object> assignOrders(@RequestBody CourierInfo courierInfo) {
		return ResponseEntity.status(HttpStatus.OK).body("Ok");
	}

	//TODO: реализовать
	@PostMapping("/complete")
	ResponseEntity<Object> completeOrder(@RequestBody CompletedOrderRequest completedOrderRequest) {
		System.out.println(completedOrderRequest);
		return ResponseEntity.status(HttpStatus.OK).body("Ok");
	}
}
