package ru.bevz.demoApp.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "time_period")
public class TimePeriod {

	@Id
	private Long id;

	@Column
	private LocalTime from;

	@Column
	private LocalTime to;
}
