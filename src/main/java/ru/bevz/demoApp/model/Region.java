package ru.bevz.demoApp.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "region")
public class Region {

	@Id
	private Long id;

	@Column
	private int number;
}
