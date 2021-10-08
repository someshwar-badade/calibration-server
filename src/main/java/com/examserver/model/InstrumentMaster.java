package com.examserver.model;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="instrument_master")
public class InstrumentMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String code;
	private String description;
	private String make;
	private String purchaseDate;
	private int calibrationFrequency;
	private String nextCalibrationDate;
	private String lastCalibrationDate;
	private String whereUsed;
	private String calibrationRange;
	private String accuracy;
	private String accuracyUom;
	private String masterStd;
	private int leastCount;
	private String createdAt;
	private String updatedAt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private InstrumentTypeMaster instrumentType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Department department;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private CalibrationAgency calibrationAgency;
	
	@OneToMany(mappedBy = "instrumentMaster",  cascade = CascadeType.ALL )
	@JsonIgnore
	private Set<InstrumentCalibration> instrumentCalibration = new LinkedHashSet<>();
	
	public InstrumentMaster() {
		super();
	}

	public InstrumentMaster(Long id, String code, String description, String make, String purchaseDate,
			int calibrationFrequency, String nextCalibrationDate, String lastCalibrationDate, String whereUsed,
			String calibrationRange, String accuracy, String accuracyUom, String masterStd, int leastCount,
			String createdAt, String updatedAt) {
		super();
		this.id = id;
		this.code = code;
		this.description = description;
		this.make = make;
		this.purchaseDate = purchaseDate;
		this.calibrationFrequency = calibrationFrequency;
		this.nextCalibrationDate = nextCalibrationDate;
		this.lastCalibrationDate = lastCalibrationDate;
		this.whereUsed = whereUsed;
		this.calibrationRange = calibrationRange;
		this.accuracy = accuracy;
		this.accuracyUom = accuracyUom;
		this.masterStd = masterStd;
		this.leastCount = leastCount;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public int getCalibrationFrequency() {
		return calibrationFrequency;
	}

	public void setCalibrationFrequency(int calibrationFrequency) {
		this.calibrationFrequency = calibrationFrequency;
	}

	public String getNextCalibrationDate() {
		return nextCalibrationDate;
	}

	public void setNextCalibrationDate(String nextCalibrationDate) {
		this.nextCalibrationDate = nextCalibrationDate;
	}

	public String getLastCalibrationDate() {
		return lastCalibrationDate;
	}

	public void setLastCalibrationDate(String lastCalibrationDate) {
		this.lastCalibrationDate = lastCalibrationDate;
	}

	public String getWhereUsed() {
		return whereUsed;
	}

	public void setWhereUsed(String whereUsed) {
		this.whereUsed = whereUsed;
	}

	public String getCalibrationRange() {
		return calibrationRange;
	}

	public void setCalibrationRange(String calibrationRange) {
		this.calibrationRange = calibrationRange;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String getAccuracyUom() {
		return accuracyUom;
	}

	public void setAccuracyUom(String accuracyUom) {
		this.accuracyUom = accuracyUom;
	}

	public String getMasterStd() {
		return masterStd;
	}

	public void setMasterStd(String masterStd) {
		this.masterStd = masterStd;
	}

	public int getLeastCount() {
		return leastCount;
	}

	public void setLeastCount(int leastCount) {
		this.leastCount = leastCount;
	}



	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
		this.updatedAt = updatedAt;
	}

	public InstrumentTypeMaster getInstrumentType() {
		return instrumentType;
	}

	public void setInstrumentType(InstrumentTypeMaster instrumentType) {
		this.instrumentType = instrumentType;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public CalibrationAgency getCalibrationAgency() {
		return calibrationAgency;
	}

	public void setCalibrationAgency(CalibrationAgency calibrationAgency) {
		this.calibrationAgency = calibrationAgency;
	}

	public Set<InstrumentCalibration> getInstrumentCalibration() {
		return instrumentCalibration;
	}

	public void setInstrumentCalibration(Set<InstrumentCalibration> instrumentCalibration) {
		this.instrumentCalibration = instrumentCalibration;
	}
	
	
	
}
