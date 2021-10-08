package com.examserver.model;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InstrumentCalibration {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String logno;
	private Date dateOfCalibration;
	private String refNo;
	private String remark;
	private Boolean isExternal=false;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private CalibrationAgency calibrationAgency;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private InstrumentMaster instrumentMaster;
	
	@OneToMany(mappedBy = "instrumentCalibration", cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<CalibrationObservation> calibrationObservation = new LinkedHashSet<>();
	
	private String doneBy;
	private Date calibrationCompletedDate;
	private String certificateNo;
	
	
	
	public InstrumentCalibration() {
		super();
	}



	public InstrumentCalibration(Long id, String logno, Date dateOfCalibration, String refNo, String remark,
			Boolean isExternal, String doneBy, Date calibrationCompletedDate, String certificateNo) {
		super();
		this.id = id;
		this.logno = logno;
		this.dateOfCalibration = dateOfCalibration;
		this.refNo = refNo;
		this.remark = remark;
		this.isExternal = isExternal;
		this.doneBy = doneBy;
		this.calibrationCompletedDate = calibrationCompletedDate;
		this.certificateNo = certificateNo;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getLogno() {
		return logno;
	}



	public void setLogno(String logno) {
		this.logno = logno;
	}



	public Date getDateOfCalibration() {
		return dateOfCalibration;
	}



	public void setDateOfCalibration(Date dateOfCalibration) {
		this.dateOfCalibration = dateOfCalibration;
	}



	public String getRefNo() {
		return refNo;
	}



	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}



	public String getRemark() {
		return remark;
	}



	public void setRemark(String remark) {
		this.remark = remark;
	}



	public Boolean getIsExternal() {
		return isExternal;
	}



	public void setIsExternal(Boolean isExternal) {
		this.isExternal = isExternal;
	}



	public CalibrationAgency getCalibrationAgency() {
		return calibrationAgency;
	}



	public void setCalibrationAgency(CalibrationAgency calibrationAgency) {
		this.calibrationAgency = calibrationAgency;
	}



	public InstrumentMaster getInstrumentMaster() {
		return instrumentMaster;
	}



	public void setInstrumentMaster(InstrumentMaster instrumentMaster) {
		this.instrumentMaster = instrumentMaster;
	}



	public Set<CalibrationObservation> getCalibrationObservation() {
		return calibrationObservation;
	}



	public void setCalibrationObservation(Set<CalibrationObservation> calibrationObservation) {
		this.calibrationObservation = calibrationObservation;
	}



	public String getDoneBy() {
		return doneBy;
	}



	public void setDoneBy(String doneBy) {
		this.doneBy = doneBy;
	}



	public Date getCalibrationCompletedDate() {
		return calibrationCompletedDate;
	}



	public void setCalibrationCompletedDate(Date calibrationCompletedDate) {
		this.calibrationCompletedDate = calibrationCompletedDate;
	}



	public String getCertificateNo() {
		return certificateNo;
	}



	public void setCertificateNo(String certificateNo) {
		this.certificateNo = certificateNo;
	}
	
	
	
}
