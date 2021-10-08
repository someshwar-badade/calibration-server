package com.examserver.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="instrument_type_master_parameter")
public class InstrumentTypeMasterParameter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String parameter;
	private String parameterUom;
	private String accuracy;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private InstrumentTypeMaster instrumentType;

	
	public InstrumentTypeMasterParameter() {
		super();
	}


	public InstrumentTypeMasterParameter(Long id, String parameter, String parameterUom, String accuracy,
			InstrumentTypeMaster instrumentType) {
		super();
		this.id = id;
		this.parameter = parameter;
		this.parameterUom = parameterUom;
		this.accuracy = accuracy;
		this.instrumentType = instrumentType;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getParameter() {
		return parameter;
	}


	public void setParameter(String parameter) {
		this.parameter = parameter;
	}


	public String getParameterUom() {
		return parameterUom;
	}


	public void setParameterUom(String parameterUom) {
		this.parameterUom = parameterUom;
	}


	public String getAccuracy() {
		return accuracy;
	}


	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}


	public InstrumentTypeMaster getInstrumentType() {
		return instrumentType;
	}


	public void setInstrumentType(InstrumentTypeMaster instrumentType) {
		this.instrumentType = instrumentType;
	}
	
	
}
