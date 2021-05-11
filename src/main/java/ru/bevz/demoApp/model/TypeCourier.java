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
	private Integer id;

	@Column
	private String name;

	@Column
	private Float capacity;

	@Column(name = "profit_ratio")
	private Float profitRatio;
}
