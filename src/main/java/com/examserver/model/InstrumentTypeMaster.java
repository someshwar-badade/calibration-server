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
@Table(name="instrument_type_master")
public class InstrumentTypeMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String shortName;
	private String description;
	private String icon;
	
	@OneToMany(mappedBy = "instrumentType", cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<InstrumentMaster> instrumentMasters = new LinkedHashSet<>();
	
	@OneToMany(mappedBy = "instrumentType", cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<InstrumentTypeMasterParameter> instrumentTypeMasterParameters = new LinkedHashSet<>();
	
	public InstrumentTypeMaster() {
		super();
	}

	public InstrumentTypeMaster(Long id, String shortName, String description, String icon) {
		super();
		this.id = id;
		this.shortName = shortName;
		this.description = description;
		this.icon = icon;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Set<InstrumentMaster> getInstrumentMasters() {
		return instrumentMasters;
	}

	public void setInstrumentMasters(Set<InstrumentMaster> instrumentMasters) {
		this.instrumentMasters = instrumentMasters;
	}

	public Set<InstrumentTypeMasterParameter> getInstrumentTypeMasterParameters() {
		return instrumentTypeMasterParameters;
	}

	public void setInstrumentTypeMasterParameters(Set<InstrumentTypeMasterParameter> instrumentTypeMasterParameters) {
		this.instrumentTypeMasterParameters = instrumentTypeMasterParameters;
	}
	
	
	
	
	
}
