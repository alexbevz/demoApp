package ru.bevz.demoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bevz.demoApp.dto.model.OrderDto;
import ru.bevz.demoApp.model.Order;
import ru.bevz.demoApp.model.StatusOrder;
import ru.bevz.demoApp.repository.OrderRepository;

import java.util.Set;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private TimePeriodService timePeriodService;

	@Autowired
	private RegionService regionService;

	public void createOrders(Set<OrderDto> orderDtoSet) {
		orderDtoSet.iterator().forEachRemaining(this::createOrder);
	}

	public void createOrder(OrderDto orderDto) {
		Order order = new Order();

		order.setId(orderDto.getId());
		order.setWeight(orderDto.getWeight());
		order.setRegion(regionService.saveOrCreateByNumber(orderDto.getRegion()));
		order.setDeliveryHours(timePeriodService.saveOrCreateByFromToSet(orderDto.getDeliveryHours()));
		order.setStatus(StatusOrder.UNASSIGNED);

		orderRepository.save(order);
	}
}
