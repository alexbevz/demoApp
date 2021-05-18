package ru.bevz.demoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bevz.demoApp.model.EarningsCourier;
import ru.bevz.demoApp.repository.EarningsCourierRepository;

@Service
public class EarningsCourierService {

	@Autowired
	private EarningsCourierRepository earningsCourierRepository;

	EarningsCourier createByCourierId(long id) {
		return earningsCourierRepository.save(new EarningsCourier().setId(id));
	}
}
