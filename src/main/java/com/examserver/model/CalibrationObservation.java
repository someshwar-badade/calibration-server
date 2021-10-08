package com.examserver.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CalibrationObservation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private InstrumentCalibration instrumentCalibration;
	
	private String parameter;
	private String uom;
	private String accuracy;
	private String value;
	private String observation1;
	private String observation2;
	private String observation3;
	private String observationText;
	
	
	
	public CalibrationObservation() {
		super();
	}


	public CalibrationObservation(String parameter, String uom,String accuracy,InstrumentCalibration instrumentCalibration) {
		super();
		
		this.parameter = parameter;
		this.uom = uom;
		this.accuracy = accuracy;
		this.instrumentCalibration = instrumentCalibration;
	}

	public CalibrationObservation(Long id, InstrumentCalibration instrumentCalibration, String parameter, String uom,
			String accuracy, String value, String observation1, String observation2, String observation3,
			String observationText) {
		super();
		this.id = id;
		this.instrumentCalibration = instrumentCalibration;
		this.parameter = parameter;
		this.uom = uom;
		this.accuracy = accuracy;
		this.value = value;
		this.observation1 = observation1;
		this.observation2 = observation2;
		this.observation3 = observation3;
		this.observationText = observationText;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public InstrumentCalibration getInstrumentCalibration() {
		return instrumentCalibration;
	}



	public void setInstrumentCalibration(InstrumentCalibration instrumentCalibration) {
		this.instrumentCalibration = instrumentCalibration;
	}



	public String getParameter() {
		return parameter;
	}



	public void setParameter(String parameter) {
		this.parameter = parameter;
	}



	public String getUom() {
		return uom;
	}



	public void setUom(String uom) {
		this.uom = uom;
	}



	public String getAccuracy() {
		return accuracy;
	}



	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}



	public String getValue() {
		return value;
	}



	public void setValue(String value) {
		this.value = value;
	}



	public String getObservation1() {
		return observation1;
	}



	public void setObservation1(String observation1) {
		this.observation1 = observation1;
	}



	public String getObservation2() {
		return observation2;
	}



	public void setObservation2(String observation2) {
		this.observation2 = observation2;
	}



	public String getObservation3() {
		return observation3;
	}



	public void setObservation3(String observation3) {
		this.observation3 = observation3;
	}



	public String getObservationText() {
		return observationText;
	}



	public void setObservationText(String observationText) {
		this.observationText = observationText;
	}
	
	
	
}
