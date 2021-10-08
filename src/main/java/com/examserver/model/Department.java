package com.examserver.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<InstrumentMaster> instrumentMasters = new LinkedHashSet<>();

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Company company;
	
	
	public Department() {
		super();
	}


	public Department(Long id, String name, Set<InstrumentMaster> instrumentMasters) {
		super();
		this.id = id;
		this.name = name;
		this.instrumentMasters = instrumentMasters;
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


	public Set<InstrumentMaster> getInstrumentMasters() {
		return instrumentMasters;
	}


	public void setInstrumentMasters(Set<InstrumentMaster> instrumentMasters) {
		this.instrumentMasters = instrumentMasters;
	}

	
	public Company getCompany() {
		return company;
	}


	public void setCompany(Company company) {
		this.company = company;
	}
	
	
	
}
