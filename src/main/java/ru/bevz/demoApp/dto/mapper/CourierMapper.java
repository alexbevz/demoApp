package ru.bevz.demoApp.dto.mapper;

import org.springframework.stereotype.Component;
import ru.bevz.demoApp.controller.request.CourierInfo;
import ru.bevz.demoApp.dto.model.CourierDto;
import ru.bevz.demoApp.model.Courier;
import ru.bevz.demoApp.model.Region;

import java.util.stream.Collectors;


@Component
public class CourierMapper {

	public CourierDto toCourierDto(Courier courier) {
		return new CourierDto()
						.setId(courier.getId())
						.setType(courier.getType().getName())
						.setRegions(courier.getRegions()
										.stream()
										.map(Region::getNumber)
										.collect(Collectors.toSet())
						)
						.setWorkingHours(courier.getWorkingHours()
										.stream()
										.map(timePeriod -> timePeriod.getFrom() + "-" + timePeriod.getTo())
										.collect(Collectors.toSet())
						);
	}

	public CourierDto toCourierDto(CourierInfo courierInfo) {
		return new CourierDto()
						.setId(courierInfo.getCourierId())
						.setType(courierInfo.getCourierType())
						.setRegions(courierInfo.getRegions())
						.setWorkingHours(courierInfo.getWorkingHours());
	}

	public CourierInfo toCourierInfo(Courier courier) {
		return new CourierInfo()
						.setCourierId(courier.getId())
						.setCourierType(courier.getType().getName())
						.setRegions(courier.getRegions()
										.stream()
										.map(Region::getNumber)
										.collect(Collectors.toSet())
						)
						.setRating(courier.getRating().getValue())
						.setEarnings(courier.getEarnings().getValue());
	}
}
