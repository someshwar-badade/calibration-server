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
	
	private String description;
	
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<InstrumentMaster> instrumentMasters = new LinkedHashSet<>();

	@ManyToOne(fetch = FetchType.EAGER)
	private Company company;
	
	
	public Department() {
		super();
	}


	public Department(Long id, String name, String description, Company company, Set<InstrumentMaster> instrumentMasters) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.instrumentMasters = instrumentMasters;
		this.company = company;
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

	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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
