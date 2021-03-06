package ru.bevz.demoApp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "total_region_indicators_courier")
public class TotalRegionIndicatorsCourier {

	@Id
	private Long id;

	@Column(name = "total_time")
	private int totalTime;

	@Column(name = "count_complete_orders")
	private int countCompleteOrders;

	@ManyToOne
	@JoinColumn(name = "courier_id")
	private Courier courier;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;
}
