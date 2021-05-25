package ru.bevz.demoApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.bevz.demoApp.model.TimePeriod;
import ru.bevz.demoApp.repository.TimePeriodRepository;
import ru.bevz.demoApp.util.DateUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TimePeriodService {

	@Autowired
	private TimePeriodRepository timePeriodRepository;

	Set<TimePeriod> saveOrCreateByFromToSet(Set<String> setFromTo) {
		return setFromTo.stream().map(this::saveOrCreateByFromTo).collect(Collectors.toSet());
	}

	TimePeriod saveOrCreateByFromTo(String fromTo) {
		TimePeriod timePeriod = DateUtils.toTimePeriodWithoutId(fromTo);
		return timePeriodRepository.findByFromAndTo(timePeriod.getFrom(), timePeriod.getTo())
						.orElseGet(() -> timePeriodRepository.save(timePeriod));
	}
}
