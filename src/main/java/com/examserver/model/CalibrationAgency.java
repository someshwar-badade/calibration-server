package com.examserver.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="calibration_agency")
public class CalibrationAgency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String address;
	private String email;
	private String mobile;
	
	@OneToMany(mappedBy = "calibrationAgency",  cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<InstrumentMaster> instrumentMasters = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "calibrationAgency",  cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<InstrumentCalibration> instrumentCalibration = new LinkedHashSet<>();
	
	public CalibrationAgency() {
		super();
	}


	public CalibrationAgency(Long id, String name, String address, String email, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobile = mobile;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public Set<InstrumentMaster> getInstrumentMasters() {
		return instrumentMasters;
	}


	public void setInstrumentMasters(Set<InstrumentMaster> instrumentMasters) {
		this.instrumentMasters = instrumentMasters;
	}


	public Set<InstrumentCalibration> getInstrumentCalibration() {
		return instrumentCalibration;
	}


	public void setInstrumentCalibration(Set<InstrumentCalibration> instrumentCalibration) {
		this.instrumentCalibration = instrumentCalibration;
	}
	
	
	
	
}
