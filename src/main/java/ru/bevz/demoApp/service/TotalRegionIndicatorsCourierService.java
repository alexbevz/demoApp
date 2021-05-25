package ru.bevz.demoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bevz.demoApp.repository.TotalRegionIndicatorsCourierRepository;

@Service
public class TotalRegionIndicatorsCourierService {

	@Autowired
	private TotalRegionIndicatorsCourierRepository totalRegionIndicatorsCourierRepository;

}
