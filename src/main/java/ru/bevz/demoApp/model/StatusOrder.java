package ru.bevz.demoApp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum StatusOrder {
	UNASSIGNED("UNASSIGNED"), ASSIGNED("ASSIGNED"), COMPLETE("COMPLETE");

	private String code;
}
