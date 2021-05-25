package ru.bevz.demoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bevz.demoApp.model.RatingCourier;
import ru.bevz.demoApp.repository.RatingCourierRepository;

@Service
public class RatingCourierService {

	@Autowired
	private RatingCourierRepository ratingCourierRepository;

	RatingCourier createByCourierId(long id) {
		return ratingCourierRepository.save(new RatingCourier().setId(id));
	}
}
