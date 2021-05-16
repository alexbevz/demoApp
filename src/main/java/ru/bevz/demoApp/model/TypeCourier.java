package ru.bevz.demoApp.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "type_courier")
public class TypeCourier {

	@Id
	private Long id;

	@Column
	private String name;

	@Column
	private float capacity;

	@Column(name = "profit_ratio")
	private float profitRatio;
}
