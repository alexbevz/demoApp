package ru.bevz.demoApp.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Accessors(chain = true)
@Entity
@Table(name = "earnings_courier")
public class EarningsCourier {

	@Id
	private Long id;

	@Column
	private float value;

	@Column(name = "total_count_complete_orders")
	private int totalCountCompleteOrders;
}
