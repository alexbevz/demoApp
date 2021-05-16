package ru.bevz.demoApp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Data
@Entity
@Table(name = "courier")
public class Courier {

	@Id
	private Long id;

	@Column(name = "available_capacity")
	private float availableCapacity;

	@OneToOne
	@JoinColumn(name = "rating_id")
	private RatingCourier rating;

	@OneToOne
	@JoinColumn(name = "earnings_id")
	private EarningsCourier earnings;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private TypeCourier type;

	@ManyToMany
	@JoinTable(name = "courier_region",
					joinColumns = @JoinColumn(name = "courier_id"),
					inverseJoinColumns = @JoinColumn(name = "region_id")
	)
	private Set<Region> regions;

	@ManyToMany
	@JoinTable(name = "courier_working_hours",
					joinColumns = @JoinColumn(name = "courier_id"),
					inverseJoinColumns = @JoinColumn(name = "time_period_id")
	)
	private Set<TimePeriod> workingHours;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Courier courier = (Courier) o;
		return Float.compare(courier.availableCapacity, availableCapacity) == 0 && Objects.equals(id, courier.id) && Objects.equals(rating, courier.rating) && Objects.equals(earnings, courier.earnings) && Objects.equals(type, courier.type) && Objects.equals(regions, courier.regions) && Objects.equals(workingHours, courier.workingHours);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, availableCapacity, rating, earnings, type, regions, workingHours);
	}
}
