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
@Table(name = "rating_courier")
public class RatingCourier {

	@Id
	private Long id;

	@Column
	private float value;

	@Column(name = "min_average_time_region")
	private int minAverageTimeRegion;
}
