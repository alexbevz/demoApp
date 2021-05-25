package ru.bevz.demoApp.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;
import ru.bevz.demoApp.controller.request.CourierInfo;
import ru.bevz.demoApp.controller.request.CouriersRequest;
import ru.bevz.demoApp.dto.mapper.CourierMapper;
import ru.bevz.demoApp.model.Courier;
import ru.bevz.demoApp.repository.CourierRepository;
import ru.bevz.demoApp.service.CourierService;
import ru.bevz.demoApp.service.TypeCourierService;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/couriers")
public class CourierController {

	@Autowired
	private ValidatorGeneral validator;
	@Autowired
	private CourierMapper courierMapper;

	@Autowired
	private CourierRepository courierRepository;

	@Autowired
	private CourierService courierService;

	@Autowired
	private TypeCourierService typeCourierService;

	@ExceptionHandler(HttpMessageNotReadableException.class)
	ResponseEntity<Object> handleExceptionAsJSON(HttpMessageNotReadableException exception) {
		return ResponseEntity.badRequest().body("HttpMessageNotReadable");
	}

	Set<Id> getCouriersId(Set<CourierInfo> courierInfoSet) {
		return courierInfoSet.stream()
						.map(CourierInfo::getCourierId)
						.map(Id::new)
						.collect(Collectors.toSet());
	}

	@PostMapping("")
	ResponseEntity<Object> createCouriers(@RequestBody CouriersRequest couriersRequest) {
		Set<Id> notValidId = new HashSet<>();

		for (CourierInfo courierInfo : couriersRequest.getData()) {
			if (!typeCourierService.contains(courierInfo.getCourierType())
							|| courierRepository.existsById(courierInfo.getCourierId())
							|| validator.isValid(courierInfo)) {
				notValidId.add(new Id(courierInfo.getCourierId()));
			}
		}

		if (!notValidId.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new BadResponseEntitiesId("couriers", notValidId));
		}

		courierService.createCouriers(couriersRequest.getData()
						.stream()
						.map(courierMapper::toCourierDto)
						.collect(Collectors.toSet())
		);

		return ResponseEntity.status(HttpStatus.CREATED).body(new OkResponseEntitiesId("couriers", getCouriersId(couriersRequest.getData())));
	}

	//TODO: реализовать
	@PatchMapping("/{id}")
	ResponseEntity<Object> updateCourier(@PathVariable(value = "id") long courierId, @RequestBody CourierInfo courierInfo) {

		return ResponseEntity.ok().body("Ok");
	}

	@GetMapping("/{id}")
	ResponseEntity<Object> getCourier(@PathVariable(value = "id") long courierId) {
		Optional<Courier> courier = courierRepository.findById(courierId);
		if (!courier.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Not exists courier with this id!");
		}
		return ResponseEntity.status(HttpStatus.OK).body(courierMapper.toCourierInfo(courier.get()));
	}
}
