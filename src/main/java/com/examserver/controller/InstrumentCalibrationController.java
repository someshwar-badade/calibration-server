package com.examserver.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.model.CalibrationObservation;
import com.examserver.model.CommonPage;
import com.examserver.model.InstrumentCalibration;
import com.examserver.model.InstrumentTypeMasterParameter;
import com.examserver.model.SearchCriteria;
import com.examserver.service.InstrumentCalibrationService;
import com.examserver.service.InstrumentTypeMasterParameterService;

@RestController
@RequestMapping("/api/instrument-calibration")
@CrossOrigin("*")
public class InstrumentCalibrationController {

	@Autowired
	InstrumentCalibrationService service;
	
	@Autowired
	InstrumentTypeMasterParameterService parameterService;
	
	@GetMapping
	public ResponseEntity<Page<InstrumentCalibration>> getInstruments(CommonPage commonPage,
			SearchCriteria searchCriteria){
		return new ResponseEntity<>(service.getAllFilteredRecords(commonPage, searchCriteria),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?>  getRecord(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.getRecord(id));
	}
	
	//create instrument
	@PostMapping
	public InstrumentCalibration addInstrumentType(@RequestBody InstrumentCalibration r) {
		Set<InstrumentTypeMasterParameter> parameters = new HashSet<>();
		Set<CalibrationObservation> observations = new HashSet<>();
		parameters =  parameterService.getParameter(r.getInstrumentMaster().getInstrumentType());
		for(InstrumentTypeMasterParameter p: parameters) {
			observations.add(new CalibrationObservation(p.getParameter(),p.getParameterUom(),p.getAccuracy(),r));
		}
		r.setCalibrationObservation(observations);
		
		return this.service.addRecord(r);
	}
	
	//Update instrument
	@PutMapping
	public InstrumentCalibration updateRecord(@RequestBody InstrumentCalibration r) {
		return this.service.updateRecord(r);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecord(@PathVariable("id") Long id){
		this.service.deleteRecord(id);
	}
	
	
	
}
