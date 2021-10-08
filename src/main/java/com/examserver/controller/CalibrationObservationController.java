package com.examserver.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.examserver.model.InstrumentCalibration;
import com.examserver.service.CalibrationObservationService;

@RestController
@RequestMapping("/api/calibration-observation")
@CrossOrigin("*")
public class CalibrationObservationController {

	@Autowired
	CalibrationObservationService service;
	
	@GetMapping("/{calibrationId}")
	public Set<CalibrationObservation> getRecords(@PathVariable("calibrationId") Long calibrationId) {
		InstrumentCalibration instrumentCalibration = new InstrumentCalibration();
		instrumentCalibration.setId(calibrationId);
		return this.service.getParameter(instrumentCalibration);
	}
	
	@GetMapping("/{calibrationId}/{id}")
	public CalibrationObservation getRecord(@PathVariable("calibrationId") Long calibrationId,@PathVariable("id") Long id) {
		
		return this.service.getRecord(id);
	}
	
	@PostMapping
	public CalibrationObservation addRecord(@RequestBody CalibrationObservation r) {
		
		return service.addRecord(r);
	}
	
	@PutMapping
	public CalibrationObservation updateRecord(@RequestBody CalibrationObservation r) {
		return service.addRecord(r);
	}
	
	@DeleteMapping("/{id}")
	public void deleteRecord(@PathVariable("id") Long id) {
			
			 this.service.deleteRecord(id);
		}
}
