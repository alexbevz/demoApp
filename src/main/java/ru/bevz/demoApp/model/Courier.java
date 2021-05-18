package ru.bevz.demoApp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;

@Data
@EqualsAndHashCode
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

}
