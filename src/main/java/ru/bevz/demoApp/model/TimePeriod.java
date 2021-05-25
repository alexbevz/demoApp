package ru.bevz.demoApp.model;


import lombok.Data;

import javax.persistence.*;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "time_period")
public class TimePeriod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "from_time")
	private LocalTime from;

	@Column(name = "to_time")
	private LocalTime to;
}
