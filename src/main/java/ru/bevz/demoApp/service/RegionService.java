package ru.bevz.demoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bevz.demoApp.model.Region;
import ru.bevz.demoApp.repository.RegionRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	Set<Region> saveOrCreateByNumbers(Set<Integer> numbers) {
		return numbers.stream().map(this::saveOrCreateByNumber).collect(Collectors.toSet());
	}

	Region saveOrCreateByNumber(int number) {
		return regionRepository.findByNumber(number)
						.orElseGet(() -> createRegion(number));
	}

	Region createRegion(int number) {
		return regionRepository.save(new Region().setNumber(number));
	}
}
