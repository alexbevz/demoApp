package ru.bevz.demoApp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "earnings_courier")
public class EarningsCourier {

	@Id
	private Integer id;

	@Column
	private Float value;

	@Column(name = "total_count_complete_orders")
	private Integer totalCountCompleteOrders;
}
