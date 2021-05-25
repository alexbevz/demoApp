package ru.bevz.demoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bevz.demoApp.dto.model.CourierDto;
import ru.bevz.demoApp.model.Courier;
import ru.bevz.demoApp.repository.CourierRepository;
import ru.bevz.demoApp.repository.TypeCourierRepository;

import java.util.Set;

@Service
public class CourierService {

	@Autowired
	private CourierRepository courierRepository;

	@Autowired
	private TypeCourierRepository typeCourierRepository;

	@Autowired
	private RegionService regionService;

	@Autowired
	private TimePeriodService timePeriodService;

	@Autowired
	private EarningsCourierService earningsCourierService;

	@Autowired
	private RatingCourierService ratingCourierService;

	public void createCouriers(Set<CourierDto> courierDtoSet) {
		for (CourierDto courierDto : courierDtoSet) {
			createCourier(courierDto);
		}
	}

	public void createCourier(CourierDto courierDto) {
		Courier courier = new Courier();

		courier.setId(courierDto.getId());
		//TODO: тяжелый случай
		courier.setType(typeCourierRepository.findByName(courierDto.getType())
						.orElse(typeCourierRepository.getOne(1L)));
		courier.setRegions(regionService.saveOrCreateByNumbers(courierDto.getRegions()));
		courier.setWorkingHours(timePeriodService.saveOrCreateByFromToSet(courierDto.getWorkingHours()));
		courier.setAvailableCapacity(courier.getType().getCapacity());
		courier.setEarnings(earningsCourierService.createByCourierId(courierDto.getId()));
		courier.setRating(ratingCourierService.createByCourierId(courierDto.getId()));

		courierRepository.save(courier);
	}
}
