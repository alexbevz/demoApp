package ru.bevz.demoApp.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "rating_courier")
public class RatingCourier {

	@Id
	private Integer id;

	@Column
	private Float value;

	@Column(name = "min_average_time_region")
	private Integer minAverageTimeRegion;
}
