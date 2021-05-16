package ru.bevz.demoApp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "order")
public class Order {

	@Id
	private Long id;

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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Float.compare(order.weight, weight) == 0 && Objects.equals(id, order.id) && status == order.status && Objects.equals(datetimeAssignment, order.datetimeAssignment) && Objects.equals(dateRealization, order.dateRealization) && Objects.equals(region, order.region) && Objects.equals(courier, order.courier) && Objects.equals(timePeriodComplete, order.timePeriodComplete) && Objects.equals(deliveryHours, order.deliveryHours);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, weight, status, datetimeAssignment, dateRealization, region, courier, timePeriodComplete, deliveryHours);
	}
}
