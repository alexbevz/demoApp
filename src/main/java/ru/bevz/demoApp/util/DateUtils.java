package ru.bevz.demoApp.util;

import ru.bevz.demoApp.model.TimePeriod;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DateUtils {

	private DateUtils() {
	}

	public static TimePeriod toTimePeriodWithoutId(String str) {
		TimePeriod timePeriod = new TimePeriod();

		List<LocalTime> localTimes = Arrays.stream(str.split("-")).map(LocalTime::parse).collect(Collectors.toList());
		timePeriod.setFrom(localTimes.get(0));
		timePeriod.setTo(localTimes.get(1));
		return timePeriod;
	}
}
