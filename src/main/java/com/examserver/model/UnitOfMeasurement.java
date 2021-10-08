package com.examserver.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unit_of_measurment")
public class UnitOfMeasurement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String shortName;
	private String longName;
	
	
	public UnitOfMeasurement() {
		super();
	}


	public UnitOfMeasurement(Long id, String shortName, String longName) {
		super();
		this.id = id;
		this.shortName = shortName;
		this.longName = longName;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getShortName() {
		return shortName;
	}


	public void setShortName(String shortName) {
		this.shortName = shortName;
	}


	public String getLongName() {
		return longName;
	}


	public void setLongName(String longName) {
		this.longName = longName;
	}
	
	
	
}
