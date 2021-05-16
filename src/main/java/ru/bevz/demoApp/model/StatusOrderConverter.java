package ru.bevz.demoApp.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.HashMap;
import java.util.Map;


@Converter(autoApply = true)
public class StatusOrderConverter implements AttributeConverter<StatusOrder, String> {

	private static final Map<String, StatusOrder> map;

	static {
		map = new HashMap<>();
		for (StatusOrder value : StatusOrder.values()) {
			map.put(value.getCode(), value);
		}
	}

	@Override
	public String convertToDatabaseColumn(StatusOrder statusOrder) {
		if (statusOrder == null) {
			return null;
		}
		return statusOrder.getCode();
	}

	@Override
	public StatusOrder convertToEntityAttribute(String code) {
		if (code == null) {
			return null;
		}
		//TODO: не знаю, что лучше вернуть (null) при случае, когда нет такого ключа.
		return map.get(code);
	}
}
