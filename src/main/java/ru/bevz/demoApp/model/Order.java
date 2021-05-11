package ru.bevz.demoApp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@Table(name = "order")
public class Order {

	@Id
	private Integer id;

	@Column
	private float weight;

	@Column
	private StatusOrder status;

	@Column(name = "datetime_assignment")
	private LocalDateTime datetimeAssignment;

	@Column(name = "date_realization")
	private LocalDate dateRealization;

	@ManyToOne
	@JoinColumn(name = "region_id")
	private Region region;

	@ManyToOne
	@JoinColumn(name = "courier_id")
	private Courier courier;

	@ManyToOne
	@JoinColumn(name = "time_period_complete_id")
	private TimePeriod timePeriodComplete;

	@ManyToMany
	@JoinTable(name = "order_delivery_hours",
					joinColumns = @JoinColumn(name = "order_id"),
					inverseJoinColumns = @JoinColumn(name = "time_period_id"))
	private Set<TimePeriod> deliveryHours;
}
