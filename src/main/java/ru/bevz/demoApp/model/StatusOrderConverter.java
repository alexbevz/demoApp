package ru.bevz.demoApp.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;


@Converter(autoApply = true)
public class StatusOrderConverter implements AttributeConverter<StatusOrder, String> {

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
		return Stream.of(StatusOrder.values())
						.filter(c -> c.getCode().equals(code))
						.findFirst()
						.orElseThrow(IllegalAccessError::new);
	}
}
